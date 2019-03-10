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
import com.motorro.rxlcemodel.base.service.UpdatingServiceSet
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * A model interface to load and hold some data.
 * Model asynchronously loads data and transmits it through [state]
 * @param DATA Data type of data being held
 * @param PARAMS Params type that identify data being loaded
 */
interface LceModel<DATA: Any, PARAMS: Any> {
    companion object {
        /**
         * Creates a model that returns cached data first, than refreshes if stall
         * @param DATA Data type of data being held
         * @param PARAMS Params type that identify data being loaded
         * @param params Params that identify data being loaded
         * @param serviceSet Service-set to load data
         * @param startWith Observable that emits at loading start. Defaults to [LceState.Loading]
         */
        @JvmOverloads fun <DATA: Any, PARAMS: Any> cacheThanNet(
            params: PARAMS,
            serviceSet: ServiceSet<DATA, PARAMS>,
            startWith: Observable<LceState<DATA, PARAMS>> = Observable.just(Loading(null, false, params))
        ): LceModel<DATA, PARAMS> = CacheThenNetLceModel(
                params = params,
                serviceSet = serviceSet,
                startWith = startWith
        )
    }

    /**
     * Model state. Subscription starts data load for the first subscriber.
     * Whenever last subscriber cancels, the model unsubscribes internal components for data updates
     */
    val state: Observable<LceState<DATA, PARAMS>>

    /**
     * Requests a refresh of data.
     * Data will be updated asynchronously
     */
    val refresh: Completable

    /**
     * Params that identify data being loaded
     */
    val params: PARAMS
}

/**
 * [LceModel] extension that can [update] data
 * @param DATA Data type of data being held
 * @param UPDATE Update type
 * @param PARAMS Params type that identify data being loaded
 */
interface UpdatingLceModel<DATA: Any, in UPDATE: Any, PARAMS: Any>: LceModel<DATA, PARAMS> {
    /**
     * Updates data on server and refreshes local data
     * @param update Data update
     */
    fun update(update: UPDATE): Completable
}

/**
 * Wraps an [LceModel] to updating delegate creating an [UpdatingLceModel]
 * @param DATA Data type of data being held
 * @param UPDATE Update type
 * @param PARAMS Params type that identify data being loaded
 * @receiver LceModel that performs reading
 * @param serviceSet Service-set to load data
 */
fun <DATA: Any, UPDATE: Any, PARAMS: Any> LceModel<DATA, PARAMS>.withUpdates(serviceSet: UpdatingServiceSet<DATA, UPDATE, PARAMS>): UpdatingLceModel<DATA, UPDATE, PARAMS> =
        UpdatingLceModelWrapper(
                upstream = this,
                serviceSet = serviceSet
        )

/**
 * Terminates [LceModel.state] stream if [predicate] returns true
 * @param DATA Source model data type
 * @param PARAMS Params type
 * @param predicate A predicate to check error state. If predicate returns true, the stream
 * is terminated with [LceState.Error.error]
 */
fun <DATA: Any, PARAMS: Any> Observable<LceState<DATA, PARAMS>>.terminateOnError(predicate: (LceState.Error<DATA, PARAMS>) -> Boolean): Observable<LceState<DATA, PARAMS>> = map { state ->
    when {
        state is LceState.Error && predicate(state) -> throw state.error
        else -> state
    }
}

/**
 * Model's state stream which terminates on any error
 * @param DATA Source model data type
 * @param PARAMS Params type
 */
val <DATA: Any, PARAMS: Any> Observable<LceState<DATA, PARAMS>>.stopOnErrors: Observable<LceState<DATA, PARAMS>>
    get() = terminateOnError { true }

/**
 * Model's state stream which terminates on errors with empty data
 * @param DATA Source model data type
 * @param PARAMS Params type
 */
val <DATA: Any, PARAMS: Any> Observable<LceState<DATA, PARAMS>>.stopOnEmptyErrors: Observable<LceState<DATA, PARAMS>>
    get() = terminateOnError { null == it.data }

/**
 * Returns model's data stream dropping state information
 * @param DATA Source model data type
 * @param PARAMS Params type
 * @param terminateOnError A predicate to check error state. If predicate returns true, the stream
 * is terminated with [LceState.Error.error]
 */
fun <DATA: Any, PARAMS: Any> Observable<LceState<DATA, PARAMS>>.getData(terminateOnError: (LceState.Error<DATA, PARAMS>) -> Boolean): Observable<DATA> =
        terminateOnError(terminateOnError)
                .switchMap {
                    val data = it.data
                    when {
                        null != data -> Observable.just(data)
                        else -> Observable.empty()
                    }
                }
                .distinctUntilChanged()

/**
 * Model's data stream with state information dropped.
 * No error state terminates stream
 * @param DATA Source model data type
 * @param PARAMS Params type
 */
val <DATA: Any, PARAMS: Any> Observable<LceState<DATA, PARAMS>>.dataNoErrors: Observable<DATA>
    get() = getData { false }

/**
 * Model's data stream with state information dropped.
 * Will terminate on any error
 * @param DATA Source model data type
 * @param PARAMS Params type
 */
val <DATA: Any, PARAMS: Any> Observable<LceState<DATA, PARAMS>>.dataStopOnErrors: Observable<DATA>
    get() = getData { true }

/**
 * Model's data stream with state information dropped.
 * Will terminate on errors with empty data
 * @param DATA Source model data type
 * @param PARAMS Params type
 */
val <DATA: Any, PARAMS: Any> Observable<LceState<DATA, PARAMS>>.dataStopOnEmptyErrors: Observable<DATA>
    get() = getData { null == it.data }

/**
 * Model's valid data stream with state information dropped.
 * Will terminate on any error
 * @param DATA Source model data type
 * @param PARAMS Params type
 */
val <DATA: Any, PARAMS: Any> Observable<LceState<DATA, PARAMS>>.validData: Observable<DATA>
    get() = terminateOnError { true }
            .switchMap {
                val data = it.data
                when {
                    null != data && it.dataIsValid -> Observable.just(data)
                    else -> Observable.empty()
                }
            }
            .distinctUntilChanged()

/**
 * Creates a model wrapper that converts [DATA_1] to [DATA_2]
 * @param DATA_1 Source model data type
 * @param DATA_2 Resulting model data type
 * @param PARAMS Params type
 * @param mapper Data mapper
 */
fun <DATA_1: Any, DATA_2: Any, PARAMS: Any> LceModel<DATA_1, PARAMS>.map(mapper: (data: DATA_1) -> DATA_2): LceModel<DATA_2, PARAMS> = object :
    LceModel<DATA_2, PARAMS> {
    override val state: Observable<LceState<DATA_2, PARAMS>> = this@map.state.map { it.map(mapper) }
    override val refresh: Completable = this@map.refresh
    override val params: PARAMS = this@map.params
}