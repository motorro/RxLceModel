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

package com.motorro.rxlcemodel.base

import com.gojuno.koptional.Optional
import com.motorro.rxlcemodel.base.LceState.*
import com.motorro.rxlcemodel.base.LogLevel.INFO
import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.service.ServiceSet
import com.motorro.rxlcemodel.base.service.UpdateOperationState
import com.motorro.rxlcemodel.base.service.UpdateOperationState.*
import com.motorro.rxlcemodel.base.service.buildUpdateOperation
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.subjects.BehaviorSubject

/**
 * A [LceModel] which uses cache subscription as a 'source of truth'.
 * When [state] is subscribed it loads cache data refreshing it if cache is stall or whenever cache
 * returns [com.gojuno.koptional.None].
 * The model always returns cached data first - then network if data is stall
 * Cache service *must* notify of its data changes!
 * @param DATA Data type of data being held
 * @param PARAMS Params type that identify data being loaded
 * @param params Params that identify data being loaded
 * @param serviceSet Data service-set
 * @param startWith Observable that emits at loading start. Defaults to [LceState.Loading]
 * @param logger Logging function
 * @param ioScheduler Scheduler to run IO operations
 */
class CacheThenNetLceModel<DATA: Any, PARAMS: Any>(
    override val params: PARAMS,
    serviceSet: ServiceSet<DATA, PARAMS>,
    startWith: Observable<LceState<DATA>>,
    private val logger: Logger?,
    private val ioScheduler: Scheduler
): LceModel<DATA, PARAMS> {
    /**
     * Model state. Subscription starts data load for the first subscriber.
     * Whenever last subscriber cancels, the model unsubscribes internal components for data updates
     */
    override val state: Observable<LceState<DATA>> by lazy {
        Observable.concat(
            startWith,
            serviceSet.cache.getData(params).subscribeOn(ioScheduler).publish { upstream ->
                Observable.merge(
                    upstream.compose(createDataTransformer()),
                    upstream.compose(createDataUpdater())
                )
            }
        ).replay(1).refCount()
    }

    /**
     * Requests a refresh of data.
     * Data will be updated asynchronously
     */
    /**
     * Requests a refresh of data.
     * Data will be updated asynchronously
     */
    override val refresh: Completable by lazy {
        loadAndCacheNetwork.ignoreElements()
    }

    /**
     * Network operation state broadcast
     */
    private val networkOperationState = BehaviorSubject.createDefault<UpdateOperationState>(IDLE)

    /**
     * Loads network data and saves it to cache.
     * Cache will update subscribers through its own subscription
     * Will share active subscription to perform net->cache only once at a time
     * Same operation is used when refreshing data - that is why we update [networkOperationState]
     * to send [LceState.Loading] with [LceState.Loading.Type.REFRESHING] type to all state
     * subscribers.
     */
    private val loadAndCacheNetwork: Observable<UpdateOperationState> by lazy {
        serviceSet.cache.buildUpdateOperation(params) { serviceSet.net.get(it) }
            .subscribeOn(ioScheduler)
            .doOnSubscribe {
                withLogger { modelLog(INFO, "Subscribing network...") }
            }
            .doOnNext { state ->
                withLogger {
                    when (state) {
                        IDLE -> modelLog(INFO, "Network idle")
                        LOADING -> modelLog(INFO, "Network loading")
                        is ERROR -> modelLog(LogLevel.WARNING, "Network error: ${state.error}")
                    }
                }
                networkOperationState.onNext(state)
            }
            .doOnDispose {
                withLogger { modelLog(INFO, "Network disposed") }
                networkOperationState.onNext(IDLE)
            }
    }

    /**
     * Mixes data emitted by cache with a network operation state
     */
    private fun createDataTransformer(): ObservableTransformer<Optional<Entity<DATA>>, LceState<DATA>> = ObservableTransformer { upstream ->
        upstream.switchMap { optionalEntity ->
            val entity = optionalEntity.toNullable()
            val data = entity?.data
            val dataIsValid = true == entity?.isValid()
            withLogger { modelLog(INFO, "Data transformer. Update from cache: ${if (null == entity) "no data" else "has data"}, valid: $dataIsValid") }
            networkOperationState.switchMap { updateOperationState ->
                withLogger {
                    modelLog(
                        INFO,
                        "Network status: $updateOperationState")
                }
                when (updateOperationState) {
                    LOADING -> Observable.just(
                        Loading(
                            data = data,
                            dataIsValid = dataIsValid,
                            type = if (null == data) Loading.Type.LOADING else Loading.Type.REFRESHING
                        )
                    )
                    is ERROR -> Observable.just(
                        Error(
                            data = data,
                            dataIsValid = dataIsValid,
                            error = updateOperationState.error
                        )
                    )
                    IDLE -> when {
                        null != data && dataIsValid -> Observable.just(
                            Content(
                                data = data,
                                dataIsValid = true
                            )
                        )
                        else -> {
                            // No content emission for invalid data
                            // The launched operation will update
                            // status later
                            Observable.empty()
                        }
                    }
                }
            }
        }
    }

    /**
     * Checks for data validity and launches update operation if necessary
     */
    private fun createDataUpdater(): ObservableTransformer<Optional<Entity<DATA>>, LceState<DATA>> = ObservableTransformer { upstream ->
        upstream.switchMap { optionalEntity ->
            val entity = optionalEntity.toNullable()
            val dataIsValid = true == entity?.isValid()
            withLogger { modelLog(INFO, "Data updater. Update from cache: ${if (null == entity) "no data" else "has data"}, valid: $dataIsValid") }
            when {
                null == entity || false == dataIsValid -> {
                    withLogger { modelLog(INFO, "Data updater. Running update...") }
                    loadAndCacheNetwork.ignoreElements().toObservable()
                }
                else -> {
                    withLogger { modelLog(INFO, "Data updater. No update needed") }
                    Observable.empty()
                }
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