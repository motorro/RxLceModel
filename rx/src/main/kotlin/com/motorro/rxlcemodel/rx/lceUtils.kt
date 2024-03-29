/*
 * Copyright 2020 Nikolai Kotchetkov.
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
import com.motorro.rxlcemodel.lce.combine
import com.motorro.rxlcemodel.lce.map
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single


/**
 * Terminates [LceModel.state] stream if [predicate] returns true
 * @param DATA Source model data type
 * @param predicate A predicate to check error state. If predicate returns true, the stream
 * is terminated with [LceState.Error.error]
 */
fun <DATA: Any> Observable<LceState<DATA>>.terminateOnError(predicate: (LceState.Error<DATA>) -> Boolean): Observable<LceState<DATA>> = map { state ->
    when {
        state is LceState.Error && predicate(state) -> throw state.error
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
fun <DATA: Any> Observable<LceState<DATA>>.getData(terminateOnError: (LceState.Error<DATA>) -> Boolean): Observable<DATA> =
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

    fun stateMapper(data1: DATA_1?): Observable<LceState<DATA_2>> = when(data1) {
        null -> Observable.just(LceState.Loading(null, false))
        else -> mapper(data1)
            .map<LceState<DATA_2>>{ LceState.Content(it, true) }
            .toObservable()
            .errorToLce()
    }

    return switchMap { data1State ->
        stateMapper(data1State.data).map { data2State ->
            data1State.combine(data2State) { _, data2 -> data2 }
        }
    }
}

/**
 * Maps each [DATA_1] to flow for [DATA_2] and combines with original state.
 * If error occurs in [mapper] emits [LceState.Error].
 * Example: Using original [DATA_1] as a parameter switch to new [DATA_2] LCE flow
 * @param DATA_1 Source data type
 * @param DATA_2 Resulting data type
 * @param mapper Data mapper
 */
fun <DATA_1: Any, DATA_2: Any> Observable<LceState<DATA_1>>.flatMapLatestFlow(mapper: (data: DATA_1) -> Observable<LceState<DATA_2>>): Observable<LceState<DATA_2>> {
    return switchMap { state1 ->
        when(val data1 = state1.data) {
            null -> Observable.just(state1.combine(LceState.Loading(null, false)) { _, _ -> null })
            else -> mapper(data1).map { state1.combine(it) { _, data2 -> data2 } }.errorToLce()
        }
    }
}

/**
 * Creates a use-case wrapper that converts [DATA_1] to [DATA_2]
 * @receiver Original model
 * @param DATA_1 Source data type
 * @param DATA_2 Resulting data type
 * @param mapper Data mapper
 */
fun <DATA_1: Any, DATA_2: Any> LceUseCase<DATA_1>.map(mapper: (data: DATA_1) -> DATA_2): LceUseCase<DATA_2> = object : LceUseCase<DATA_2> {
    override val state: Observable<LceState<DATA_2>> = this@map.state.map { it.map(mapper) }
    override val refresh: Completable = this@map.refresh
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
 * Takes the [LceUseCase.state] of model that is being refreshed each time [refreshStream] emits a value
 * Useful when you create a model as a result of mapping of some input (params for example) and the
 * [LceModel.refresh] property becomes invisible for the outside world
 * @receiver Original model
 * @param DATA Source model data type
 * @param refreshStream Whenever this stream emits a value, the model is refreshed
 */
fun <DATA: Any> LceUseCase<DATA>.withRefresh(refreshStream: Observable<in Nothing>): Observable<LceState<DATA>> = Observable.merge(
    this.state,
    refreshStream.flatMapCompletable { this.refresh }.toObservable()
)

/**
 * Refreshes data on subscription once
 * @receiver Original stream
 * @param refresh Refresh operation
 */
fun <DATA : Any> Observable<LceState<DATA>>.refreshed(refresh: Completable): Observable<LceState<DATA>> = publish { published ->
    Observable.mergeArray(
        // Original state stream
        published,
        // Take first emission. If it is a valid content - refresh
        published
            .take(1)
            .ofType(LceState.Content::class.java)
            .filter { it.dataIsValid }
            .flatMapCompletable { refresh }
            .toObservable()
    )
}

/**
 * Wraps use-case to refresh on each subscription
 * @receiver Original model
  */
fun <DATA: Any> LceUseCase<DATA>.refreshed(): LceUseCase<DATA> = object : LceUseCase<DATA> {
    override val state: Observable<LceState<DATA>> = this@refreshed.state.refreshed(this@refreshed.refresh)
    override val refresh: Completable = this@refreshed.refresh
}

/**
 * Substitutes [LceState.Loading] with empty data with state produced by [block]
 * @receiver LCE stream
 * @param block transformation block
 */
inline fun <DATA: Any> Observable<LceState<DATA>>.onEmptyLoadingReturn(crossinline block: (LceState.Loading<DATA>) -> LceState<DATA>): Observable<LceState<DATA>> = map {
    if (it is LceState.Loading && null == it.data) {
        block(it)
    } else {
        it
    }
}

/**
 * Substitutes [LceState.Loading] empty data with data produced by [block]
 * @receiver LCE stream
 * @param block Item creation block
 */
inline fun <DATA: Any> Observable<LceState<DATA>>.onEmptyLoadingReturnItem(crossinline block: () -> DATA?): Observable<LceState<DATA>> = map {
    if (it is LceState.Loading && null == it.data) {
        LceState.Loading(block(), it.dataIsValid, it.type)
    } else {
        it
    }
}

/**
 * Maps an upstream error to LceError
 * @param errorData Evaluates data for error state
 */
inline fun <T : Any> Observable<LceState<T>>.errorToLce(crossinline errorData: (Throwable) -> T? = { null }): Observable<LceState<T>> = onErrorReturn {
    LceState.Error(errorData(it), false, it)
}


