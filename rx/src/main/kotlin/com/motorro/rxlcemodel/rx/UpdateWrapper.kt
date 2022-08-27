/*
 * Copyright 2019 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.rx

import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.rx.LogLevel.INFO
import com.motorro.rxlcemodel.rx.LogLevel.WARNING
import com.motorro.rxlcemodel.rx.entity.Entity
import com.motorro.rxlcemodel.rx.service.CacheService
import com.motorro.rxlcemodel.rx.service.UpdateOperationState
import com.motorro.rxlcemodel.rx.service.UpdateOperationState.*
import com.motorro.rxlcemodel.rx.service.buildUpdateOperation
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * A base class that wraps [LceModel] and mixes in a data update state
 * Extend to build models that patch some properties and load the whole data structure as a result
 * Implement methods to update properties using [doUpdate] template
 * @param DATA Data Type of data being held
 * @param PARAMS Params type that identify data being loaded
 * @param upstream LceModel that performs reading
 * @param cacheService Data cache service that updates the same cache as [upstream] uses
 * @param ioScheduler Scheduler to run IO operations
 * @param logger Logging function
 */
abstract class UpdateWrapper<DATA: Any, PARAMS: Any>(
    private val upstream: LceModel<DATA, PARAMS>,
    private val cacheService: CacheService<DATA, PARAMS>,
    private val ioScheduler: Scheduler,
    private val logger: Logger?
): LceModel<DATA, PARAMS> by upstream {
    /**
     * Network operation state broadcast
     */
    private val networkOperationState = PublishSubject.create<UpdateOperationState>()

    /**
     * Creates a cache-update operation that gets data from [dataSource] and saves to cache.
     * The completable updates [networkOperationState] to mix state to original [upstream]
     * @param dataSource Update operation data source factory
     */
    protected fun doUpdate(dataSource: (params: PARAMS) -> Single<out Entity<DATA>>): Completable =
            cacheService.buildUpdateOperation(upstream.params, dataSource)
                .subscribeOn(ioScheduler)
                .doOnSubscribe {
                    withLogger { modelLog(INFO, "Subscribing network...") }
                }
                .doOnNext { state ->
                    withLogger {
                        when (state) {
                            IDLE -> modelLog(INFO, "Network idle")
                            LOADING -> modelLog(INFO, "Network loading")
                            is ERROR -> modelLog(WARNING, "Network error: ${state.error}")
                        }
                    }
                    networkOperationState.onNext(state)
                }
                .doOnDispose {
                    withLogger { modelLog(INFO, "Network disposed") }
                    networkOperationState.onNext(IDLE)
                }
                .ignoreElements()

    /**
     * Model state. Subscription starts data load for the first subscriber.
     * Whenever last subscriber cancels, the model unsubscribes internal components for data updates
     * Wrapper mixes the [upstream] emissions with update operation status.
     */
    override val state: Observable<LceState<DATA>> by lazy {
        val mapper = BiFunction<UpdateOperationState, LceState<DATA>, LceState<DATA>> { update, upstream ->
            when(update) {
                IDLE -> upstream
                LOADING -> upstream.toLoading(type = LceState.Loading.Type.UPDATING)
                is ERROR -> upstream.toError(update.error)
            }
        }

        Observable.combineLatest(
                networkOperationState.startWithItem(IDLE),
                upstream.state,
                mapper
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