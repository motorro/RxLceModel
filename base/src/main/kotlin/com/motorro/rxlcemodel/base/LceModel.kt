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
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.base.service.NetService
import com.motorro.rxlcemodel.base.service.ServiceSet
import com.motorro.rxlcemodel.base.service.UpdatingServiceSet
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * A model interface to load data and transmit it to subscribers along with loading operation state
 * @param DATA Data type of data being held
 * @param PARAMS Params type that identify data being loaded
 */
interface LceModel<DATA: Any, PARAMS: Any> {
    companion object {
        /**
         * Creates a model that returns cached data first, then refreshes if stall
         * @param DATA Data type of data being held
         * @param PARAMS Params type that identify data being loaded
         * @param params Params that identify data being loaded
         * @param serviceSet Service-set to load data
         * @param startWith Observable that emits at loading start. Defaults to [LceState.Loading]
         */
        @JvmOverloads fun <DATA: Any, PARAMS: Any> cacheThenNet(
            params: PARAMS,
            serviceSet: ServiceSet<DATA, PARAMS>,
            startWith: Observable<LceState<DATA>> = Observable.just(Loading(null, false))
        ): LceModel<DATA, PARAMS> = CacheThenNetLceModel(
                params = params,
                serviceSet = serviceSet,
                startWith = startWith
        )

        /**
         * Creates a model that returns cached data first, than refreshes if stall
         * @param DATA Data type of data being held
         * @param PARAMS Params type that identify data being loaded
         * @param params Params that identify data being loaded
         * @param net Net-service
         * @param cache Cache-service
         * @param startWith Observable that emits at loading start. Defaults to [LceState.Loading]
         */
        @JvmOverloads fun <DATA: Any, PARAMS: Any> cacheThenNet(
            params: PARAMS,
            net: NetService<DATA, PARAMS>,
            cache: CacheService<DATA, PARAMS>,
            startWith: Observable<LceState<DATA>> = Observable.just(Loading(null, false))
        ): LceModel<DATA, PARAMS> = cacheThenNet(
                params = params,
                serviceSet = object : ServiceSet<DATA, PARAMS> {
                    override val net: NetService<DATA, PARAMS> get() = net
                    override val cache: CacheService<DATA, PARAMS> get() = cache
                },
                startWith = startWith
        )
    }

    /**
     * Model state. Subscription starts data load for the first subscriber.
     * Whenever last subscriber cancels, the model unsubscribes internal components for data updates
     */
    val state: Observable<LceState<DATA>>

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
 * @param predicate A predicate to check error state. If predicate returns true, the stream
 * is terminated with [LceState.Error.error]
 */
fun <DATA: Any> Observable<LceState<DATA>>.terminateOnError(predicate: (Error<DATA>) -> Boolean): Observable<LceState<DATA>> = map { state ->
    when {
        state is Error && predicate(state) -> throw state.error
        else -> state
    }
}

/**
 * Model's state stream which terminates on any error
 * @param DATA Source model data type
 */
val <DATA: Any> Observable<LceState<DATA>>.stopOnErrors: Observable<LceState<DATA>>
    get() = terminateOnError { true }

/**
 * Model's state stream which terminates on errors with empty data
 * @param DATA Source model data type
 */
val <DATA: Any> Observable<LceState<DATA>>.stopOnEmptyErrors: Observable<LceState<DATA>>
    get() = terminateOnError { null == it.data }

/**
 * Returns model's data stream dropping state information
 * @param DATA Source model data type
 * @param terminateOnError A predicate to check error state. If predicate returns true, the stream
 * is terminated with [LceState.Error.error]
 */
fun <DATA: Any> Observable<LceState<DATA>>.getData(terminateOnError: (Error<DATA>) -> Boolean): Observable<DATA> =
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
 */
val <DATA: Any> Observable<LceState<DATA>>.dataNoErrors: Observable<DATA>
    get() = getData { false }

/**
 * Model's data stream with state information dropped.
 * Will terminate on any error
 * @param DATA Source model data type
 */
val <DATA: Any> Observable<LceState<DATA>>.dataStopOnErrors: Observable<DATA>
    get() = getData { true }

/**
 * Model's data stream with state information dropped.
 * Will terminate on errors with empty data
 * @param DATA Source model data type
 */
val <DATA: Any> Observable<LceState<DATA>>.dataStopOnEmptyErrors: Observable<DATA>
    get() = getData { null == it.data }

/**
 * Model's valid data stream with state information dropped.
 * Will terminate on any error
 * @param DATA Source model data type
 */
val <DATA: Any> Observable<LceState<DATA>>.validData: Observable<DATA>
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
 * Maps each [DATA_1] to single for [DATA_2] and merges back to LceState.
 * If error occurs in [mapper] emits [LceState.Error].
 * Example: load some [DATA_2] from server using original [DATA_1] as a parameter.
 * @param DATA_1 Source data type
 * @param DATA_2 Resulting data type
 * @param mapper Data mapper
 */
fun <DATA_1: Any, DATA_2: Any> Observable<LceState<DATA_1>>.flatMapSingleData(mapper: (data: DATA_1) -> Single<DATA_2>): Observable<LceState<DATA_2>> {

    fun dataMapper(data1: DATA_1, block: (DATA_2) -> LceState<DATA_2>) = mapper(data1)
        .map { block(it) }
        .onErrorReturn { Error(null, false, it) }

    fun nullableMapper(data1: DATA_1?, block: (DATA_2?) -> LceState<DATA_2>) = if (null == data1) {
        Single.just(block(null))
    } else {
        dataMapper(data1, block)
    }

    @Suppress("RemoveExplicitTypeArguments")
    return flatMapSingle<LceState<DATA_2>> { state ->
        when (state) {
            is Loading -> nullableMapper(state.data) { Loading(it, state.dataIsValid, state.type) }
            is Content -> dataMapper(state.data) { Content(it, state.dataIsValid) }
            is Error -> nullableMapper(state.data) { Error(it, state.dataIsValid, state.error) }
            is Terminated -> Single.just(Terminated)
        }
    }
}

/**
 * Creates a model wrapper that converts [DATA_1] to [DATA_2]
 * @receiver Original model
 * @param DATA_1 Source model data type
 * @param DATA_2 Resulting model data type
 * @param PARAMS Params type that identify data being loaded
 * @param mapper Data mapper
 */
fun <DATA_1: Any, DATA_2: Any, PARAMS: Any> LceModel<DATA_1, PARAMS>.map(mapper: (data: DATA_1) -> DATA_2): LceModel<DATA_2, PARAMS> = object : LceModel<DATA_2, PARAMS> {
    override val state: Observable<LceState<DATA_2>> = this@map.state.map { it.map(mapper) }
    override val refresh: Completable = this@map.refresh
    override val params: PARAMS = this@map.params
}

/**
 * Takes the [LceModel.state] of model that is being refreshed each time [refreshStream] emits a value
 * Useful when you create a model as a result of mapping of some input (params for example) and the
 * [LceModel.refresh] property becomes invisible for the outside world
 * @receiver Original model
 * @param DATA Source model data type
 * @param PARAMS Params type that identify data being loaded
 * @param refreshStream Whenever this stream emits a value, the model is refreshed
 */
fun <DATA: Any, PARAMS: Any> LceModel<DATA, PARAMS>.withRefresh(refreshStream: Observable<Int>): Observable<LceState<DATA>> = Observable.merge(
    this.state,
    refreshStream.flatMapCompletable { this.refresh }.toObservable()
)

/**
 * Substitutes [LceState.Loading] with empty data with state produced by [block]
 * @receiver LCE stream
 * @param block transformation block
 */
inline fun <DATA: Any> Observable<LceState<DATA>>.onEmptyLoadingReturn(crossinline block: (Loading<DATA>) -> LceState<DATA>): Observable<LceState<DATA>> = map {
    if (it is Loading && null == it.data) {
        block(it)
    } else {
        it
    }
}