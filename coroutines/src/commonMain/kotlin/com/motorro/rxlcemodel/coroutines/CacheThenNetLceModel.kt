/*
 * Copyright 2023 Nikolai Kotchetkov.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.motorro.rxlcemodel.coroutines

import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.common.LogLevel
import com.motorro.rxlcemodel.common.LogLevel.INFO
import com.motorro.rxlcemodel.common.Logger
import com.motorro.rxlcemodel.common.UpdateOperationState
import com.motorro.rxlcemodel.common.UpdateOperationState.*
import com.motorro.rxlcemodel.coroutines.service.ServiceSet
import com.motorro.rxlcemodel.coroutines.service.buildUpdateOperation
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.lce.LceState.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

/**
 * A [LceModel] which uses cache subscription as a 'source of truth'.
 * When [state] is subscribed it loads cache data refreshing it if cache is stall or whenever cache
 * returns null.
 * The model always returns cached data first - then network if data is stall
 * Cache service *must* notify of its data changes!
 * @param DATA Data type of data being held
 * @param PARAMS Params type that identify data being loaded
 * @param params Params that identify data being loaded
 * @param serviceSet Data service-set
 * @param startWith Observable that emits at loading start. Defaults to [LceState.Loading]
 * @param ioDispatcher Scheduler to run IO operations
 * @param logger Logging function
 */
class CacheThenNetLceModel<DATA: Any, PARAMS: Any>(
    override val params: PARAMS,
    private val serviceSet: ServiceSet<DATA, PARAMS>,
    startWith: Flow<LceState<DATA>>,
    private val ioDispatcher: CoroutineDispatcher,
    private val logger: Logger?
): LceModel<DATA, PARAMS> {
    /**
     * Model state. Subscription starts data load for the first subscriber.
     * Whenever last subscriber cancels, the model unsubscribes internal components for data updates
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    override val state: Flow<LceState<DATA>> = flow {
        emitAll(startWith)
        emitAll(
            serviceSet.cache.getData(params).flowOn(ioDispatcher).transformLatest { entity ->
                checkForUpdate(entity)
                emitAll(createDataFlow(entity))
            }
        )
    }

    /**
     * Requests a refresh of data.
     * Data will be updated asynchronously
     */
    override suspend fun refresh() {
        loadAndCacheNetwork()
    }

    /**
     * Network operation state broadcast
     */
    private val networkOperationState = MutableStateFlow<UpdateOperationState>(IDLE)

    /**
     * Loads network data and saves it to cache.
     * Cache will update subscribers through its own subscription
     * Will share active subscription to perform net->cache only once at a time
     * Same operation is used when refreshing data - that is why we update [networkOperationState]
     * to send [LceState.Loading] with [LceState.Loading.Type.REFRESHING] type to all state
     * subscribers.
     */
    private suspend fun loadAndCacheNetwork() {
        withContext(ioDispatcher) {
            serviceSet.cache.buildUpdateOperation(params) { serviceSet.net.get(it) }
                .onStart {
                    withLogger { modelLog(INFO, "Subscribing network...") }
                }
                .onEach { state ->
                    withLogger {
                        when (state) {
                            IDLE -> modelLog(INFO, "Network idle")
                            LOADING -> modelLog(INFO, "Network loading")
                            is ERROR -> modelLog(LogLevel.WARNING, "Network error: ${state.error}")
                        }
                    }
                    networkOperationState.emit(state)
                }
                .onCompletion {
                    withLogger { modelLog(INFO, "Network disposed") }
                    networkOperationState.emit(IDLE)
                }
                .collect()
        }
    }

    /**
     * Mixes data emitted by cache with a network operation state
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    private fun createDataFlow(entity: Entity<DATA>?): Flow<LceState<DATA>> {
        val data = entity?.data
        val dataIsValid = true == entity?.isValid()
        withLogger { modelLog(INFO, "Data transformer. Update from cache: ${if (null == entity) "no data" else "has data"}, valid: $dataIsValid") }
        return networkOperationState.transformLatest { updateOperationState ->
            withLogger {
                modelLog(
                    INFO,
                    "Network status: $updateOperationState")
            }
            when (updateOperationState) {
                LOADING -> emit(
                    Loading(
                        data = data,
                        dataIsValid = dataIsValid,
                        type = if (null == data) Loading.Type.LOADING else Loading.Type.REFRESHING
                    )
                )
                is ERROR -> emit(
                    Error(
                        data = data,
                        dataIsValid = dataIsValid,
                        error = updateOperationState.error
                    )
                )
                // No content emission for invalid data
                // The launched operation will update
                // status later
                IDLE -> if (null != data && dataIsValid) emit(
                    Content(
                        data = data,
                        dataIsValid = true
                    )
                )
            }
        }
    }

    /**
     * Checks for data validity and launches update operation if necessary
     */
    private suspend fun checkForUpdate(entity: Entity<DATA>?) {
        val dataIsValid = true == entity?.isValid()
        withLogger { modelLog(INFO, "Data updater. Update from cache: ${if (null == entity) "no data" else "has data"}, valid: $dataIsValid") }
        when {
            null == entity || dataIsValid.not() -> {
                withLogger { modelLog(INFO, "Data updater. Running update...") }
                loadAndCacheNetwork()
            }
            else -> {
                withLogger { modelLog(INFO, "Data updater. No update needed") }
            }
        }
    }

    /**
     * Runs if logger present
     */
    private inline fun withLogger(block: Logger.() -> Unit) {
        logger?.block()
    }

    /**
     * Logs message to logger with model id
     * @param level Log level
     * @param message Log message
     */
    private fun Logger.modelLog(level: LogLevel, message: String) {
        log(level, "CacheThanNetLceModel($params): $message")
    }
}
