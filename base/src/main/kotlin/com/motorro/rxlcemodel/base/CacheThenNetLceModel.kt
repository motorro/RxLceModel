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

import com.motorro.rxlcemodel.base.LceState.*
import com.motorro.rxlcemodel.base.service.ServiceSet
import com.motorro.rxlcemodel.base.service.UpdateOperationState
import com.motorro.rxlcemodel.base.service.UpdateOperationState.*
import com.motorro.rxlcemodel.base.service.buildUpdateOperation
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function
import io.reactivex.rxjava3.subjects.PublishSubject

/**
 * A [LceModel] which uses cache subscription as a 'source of truth'.
 * When [state] is subscribed it loads cache data refreshing it if cache is stall or whenever cache
 * returns empty [java.util.Optional].
 * The model always returns cached data first - then network if data is stall
 * Cache service *must* notify of its data changes!
 * @param DATA Data type of data being held
 * @param PARAMS Params type that identify data being loaded
 * @param params Params that identify data being loaded
 * @param serviceSet Data service-set
 * @param startWith Observable that emits at loading start. Defaults to [LceState.Loading]
 */
class CacheThenNetLceModel<DATA: Any, PARAMS: Any>(
    override val params: PARAMS,
    serviceSet: ServiceSet<DATA, PARAMS>,
    startWith: Observable<LceState<DATA>>
): LceModel<DATA, PARAMS> {
    /**
     * Network operation state broadcast
     */
    private val networkOperationState = PublishSubject.create<UpdateOperationState>()

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
                .doOnNext { networkOperationState.onNext(it) }
                .doOnDispose { networkOperationState.onNext(IDLE) }
                .share()
    }

    /**
     * Model data. Subscription starts data load for the first subscriber.
     * Whenever last subscriber cancels, the model unsubscribes internal components for data updates
     */
    override val state: Observable<LceState<DATA>> by lazy {
        Observable.concat(
                startWith,
                serviceSet.cache.getData(params).switchMap<LceState<DATA>> { fromCache ->
                    val entity = fromCache.orElse(null)

                    val data = entity?.data
                    val isValid = true == entity?.isValid()

                    // Transforms cache update operation status to [LceState]
                    val updateStateTransformer = Function<UpdateOperationState, Observable<LceState<DATA>>> { updateStatus ->
                        val loadingType = if(null != data) {
                            // Cache has some content. Loads will refresh current data.
                            Loading.Type.REFRESHING
                        } else {
                            // Cache is empty. Value should be loaded
                            Loading.Type.LOADING
                        }

                        when(updateStatus) {
                            LOADING -> Observable.just(Loading(data, isValid, loadingType))
                            is ERROR -> Observable.just(Error(data, isValid, updateStatus.error))
                            IDLE -> if (null != data) {
                                // Emit same content if cache did not change or is late to emit upstream
                                Observable.just<LceState<DATA>>(Content(data, isValid))
                            } else {
                                // Prevent content emission when has no data. Effectively this happens if
                                // cache has not yet re-emitted loaded data
                                Observable.empty()
                            }
                        }
                    }

                    // Emit obtained content or start loading promptly if data is not valid
                    // Subscribe to refresh operations state afterwards
                    Observable.concat(
                            if (null != data && isValid) {
                                Observable.just(Content(data, isValid))
                            } else {
                                loadAndCacheNetwork.switchMap(updateStateTransformer)
                            },
                            networkOperationState.switchMap(updateStateTransformer)
                    )
                }
        ).distinctUntilChanged()
    }

    /**
     * Requests a refresh of data.
     * Data will be updated asynchronously
     */
    override val refresh: Completable by lazy {
        loadAndCacheNetwork.ignoreElements()
    }
}