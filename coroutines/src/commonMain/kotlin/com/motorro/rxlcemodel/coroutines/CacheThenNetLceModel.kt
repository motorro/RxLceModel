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
import com.motorro.rxlcemodel.common.LogLevel.WARNING
import com.motorro.rxlcemodel.common.Logger
import com.motorro.rxlcemodel.coroutines.service.ServiceSet
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.lce.LceState.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

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
            serviceSet.cache.getData(params).flowOn(ioDispatcher).transformLatest {
                processCachedData(it)
            }
        )
    }

    /**
     * Requests a refresh of data.
     * Data will be updated asynchronously
     */
    override suspend fun refresh() {
        withLogger {
            modelLog(INFO, "Invalidating cache to launch refresh...")
            withContext(ioDispatcher) {
                serviceSet.cache.invalidate(params)
            }
        }
    }

    /**
     * Processes cached data if available and updates clients
     */
    private suspend fun FlowCollector<LceState<DATA>>.processCachedData(entity: Entity<DATA>?) {
        val data = entity?.data
        val dataIsValid = true == entity?.isValid()
        withLogger {
            modelLog(INFO, "Data transformer. Update from cache: ${if (null == entity) "no data" else "has data"}, valid: $dataIsValid")
        }
        when {
            null != data && dataIsValid -> {
                withLogger {
                    modelLog(INFO, "Cache emitted valid data - CONTENT")
                }
                emit(
                    Content(
                        data = data,
                        dataIsValid = true
                    )
                )
            }
            else -> {
                withLogger {
                    modelLog(INFO, "Cache emitted valid data - CONTENT")
                }
                emit(
                    Loading(
                        data,
                        dataIsValid,
                        type = if (null == data) Loading.Type.LOADING else Loading.Type.REFRESHING
                    )
                )
                runCatching { loadAndCacheNetwork() }.onFailure { error ->
                    if (error !is CancellationException) {
                        withLogger {
                            modelLog(WARNING, "Error getting data from network - ERROR: $error")
                        }
                        emit(
                            Error(
                                data,
                                dataIsValid,
                                error
                            )
                        )
                    }
                }
            }
        }
    }

    /**
     * Loads network data and saves it to cache.
     * Cache will update subscribers through its own subscription.
     */
    private suspend fun loadAndCacheNetwork() {
        withContext(ioDispatcher) {
            withLogger { modelLog(INFO, "Subscribing network...") }
            val data = serviceSet.net.get(params)
            withLogger { modelLog(INFO, "Saving to cache...") }
            serviceSet.cache.save(params, data)
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
