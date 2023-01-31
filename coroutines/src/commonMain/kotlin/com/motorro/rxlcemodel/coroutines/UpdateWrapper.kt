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
import com.motorro.rxlcemodel.common.UpdateOperationState
import com.motorro.rxlcemodel.common.UpdateOperationState.*
import com.motorro.rxlcemodel.coroutines.service.CacheService
import com.motorro.rxlcemodel.lce.LceState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

/**
 * A base class that wraps [LceModel] and mixes in a data update state
 * Extend to build models that patch some properties and load the whole data structure as a result
 * Implement methods to update properties using [doUpdate] template
 * @param DATA Data Type of data being held
 * @param PARAMS Params type that identify data being loaded
 * @param upstream LceModel that performs reading
 * @param cacheService Data cache service that updates the same cache as [upstream] uses
 * @param ioDispatcher Scheduler to run IO operations
 * @param logger Logging function
 */
abstract class UpdateWrapper<DATA: Any, PARAMS: Any>(
    private val upstream: LceModel<DATA, PARAMS>,
    private val cacheService: CacheService<DATA, PARAMS>,
    private val ioDispatcher: CoroutineDispatcher,
    private val logger: Logger?
): LceModel<DATA, PARAMS> by upstream {
    /**
     * Network operation state broadcast
     */
    private val networkOperationState = MutableStateFlow<UpdateOperationState>(IDLE)

    /**
     * Creates a cache-update operation that gets data from [dataSource] and saves to cache.
     * @param dataSource Update operation data source factory
     */
    protected suspend fun doUpdate(dataSource: suspend (params: PARAMS) -> Entity<DATA>) {
        networkOperationState.emit(LOADING)
        try {
            withContext(ioDispatcher) {
                withLogger { modelLog(INFO, "Subscribing network...") }
                val data = dataSource(params)
                withLogger { modelLog(INFO, "Saving to cache...") }
                cacheService.save(params, data)
            }
            networkOperationState.emit(IDLE)
        } catch (error: Throwable) {
            withLogger { modelLog(WARNING, "Network error: $error") }
            networkOperationState.emit(ERROR(error))
        }
    }

    /**
     * Model state. Subscription starts data load for the first subscriber.
     * Whenever last subscriber cancels, the model unsubscribes internal components for data updates
     * Wrapper mixes the [upstream] emissions with update operation status.
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    override val state: Flow<LceState<DATA>> = flow {
        emitAll(
            upstream.state.transformLatest { upstreamState ->
                networkOperationState.collect { update ->
                    emit(
                        when(update) {
                            IDLE -> upstreamState
                            LOADING -> upstreamState.toLoading(type = LceState.Loading.Type.UPDATING)
                            is ERROR -> upstreamState.toError(update.error)
                        }
                    )
                }
            }
        )
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
        log(level, "UpdateWrapper($params): $message")
    }
}