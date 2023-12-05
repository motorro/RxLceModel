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

import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.lce.combine
import com.motorro.rxlcemodel.lce.map
import coroutinesRunCatching
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.transform


/**
 * Terminates [LceUseCase.state] stream if [predicate] returns true
 * @param DATA Source model data type
 * @param predicate A predicate to check error state. If predicate returns true, the stream
 * is terminated with [LceState.Error.error]
 */
fun <DATA: Any> Flow<LceState<DATA>>.terminateOnError(
    predicate: (LceState.Error<DATA>) -> Boolean
): Flow<LceState<DATA>> = map { state ->
    when {
        state is LceState.Error && predicate(state) -> throw state.error
        else -> state
    }
}

/**
 * Model's state stream which terminates on any error
 * @param DATA Source model data type
 */
val <DATA: Any> Flow<LceState<DATA>>.stopOnErrors: Flow<LceState<DATA>>
    get() = terminateOnError { true }

/**
 * Model's state stream which terminates on errors with empty data
 * @param DATA Source model data type
 */
val <DATA: Any> Flow<LceState<DATA>>.stopOnEmptyErrors: Flow<LceState<DATA>>
    get() = terminateOnError { null == it.data }

/**
 * Returns model's data stream dropping state information
 * @param DATA Source model data type
 * @param terminateOnError A predicate to check error state. If predicate returns true, the stream
 * is terminated with [LceState.Error.error]
 */
fun <DATA: Any> Flow<LceState<DATA>>.getData(terminateOnError: (LceState.Error<DATA>) -> Boolean): Flow<DATA> =
    terminateOnError(terminateOnError)
        .transform {
            val data = it.data
            if (null != data) {
                emit(data)
            }
        }
        .distinctUntilChanged()

/**
 * Model's data stream with state information dropped.
 * No error state terminates stream
 * @param DATA Source model data type
 */
val <DATA: Any> Flow<LceState<DATA>>.dataNoErrors: Flow<DATA>
    get() = getData { false }

/**
 * Model's data stream with state information dropped.
 * Will terminate on any error
 * @param DATA Source model data type
 */
val <DATA: Any> Flow<LceState<DATA>>.dataStopOnErrors: Flow<DATA>
    get() = getData { true }

/**
 * Model's data stream with state information dropped.
 * Will terminate on errors with empty data
 * @param DATA Source model data type
 */
val <DATA: Any> Flow<LceState<DATA>>.dataStopOnEmptyErrors: Flow<DATA>
    get() = getData { null == it.data }

/**
 * Model's valid data stream with state information dropped.
 * Will terminate on any error
 * @param DATA Source model data type
 */
val <DATA: Any> Flow<LceState<DATA>>.validData: Flow<DATA>
    get() = terminateOnError { true }
        .transform {
            val data = it.data
            if (null != data && it.dataIsValid) {
                emit(data)
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
@OptIn(ExperimentalCoroutinesApi::class)
fun <DATA_1: Any, DATA_2: Any> Flow<LceState<DATA_1>>.flatMapSingleData(mapper: suspend (data: DATA_1) -> DATA_2): Flow<LceState<DATA_2>> {

    suspend fun stateMapper(data1: DATA_1?): LceState<DATA_2> = when(data1) {
        null -> LceState.Loading(null, false)
        else -> coroutinesRunCatching { LceState.Content(mapper(data1), true) }.getOrElse { e ->
            LceState.Error(null, false, e)
        }
    }

    return mapLatest { data1State ->
        data1State.combine(stateMapper(data1State.data)) { _, data2 -> data2 }
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
@OptIn(ExperimentalCoroutinesApi::class)
fun <DATA_1: Any, DATA_2: Any> Flow<LceState<DATA_1>>.flatMapLatestFlow(mapper: suspend (data: DATA_1) -> Flow<LceState<DATA_2>>): Flow<LceState<DATA_2>> =
    flatMapLatest { state1: LceState<DATA_1> ->
        when(val data1 = state1.data) {
            null -> flowOf(state1.combine(LceState.Loading(null, false)) { _,_ -> null })
            else -> coroutinesRunCatching { mapper(data1).map { state1.combine(it) { _, data2 -> data2 } } }.getOrElse {
                flowOf(LceState.Error(null, false, it))
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
    override val state: Flow<LceState<DATA_2>> = this@map.state.map { it.map(mapper) }
    override suspend fun refresh() = this@map.refresh()
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
    override val state: Flow<LceState<DATA_2>> = this@map.state.map { it.map(mapper) }
    override suspend fun refresh() = this@map.refresh()
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
@OptIn(ExperimentalCoroutinesApi::class)
fun <DATA: Any> LceUseCase<DATA>.withRefresh(refreshStream: Flow<Any>): Flow<LceState<DATA>> = merge(
    this.state,
    refreshStream.mapLatest { this.refresh() }.transform { }
)

/**
 * Refreshes data on subscription once
 * @receiver Original stream
 * @param refresh Refresh operation
 */
fun <DATA : Any> Flow<LceState<DATA>>.refreshed(refresh: suspend () -> Unit): Flow<LceState<DATA>> = flow {
    var refreshed = false
    emitAll(
        this@refreshed.transform { value ->
            emit(value)

            if (refreshed.not() && value is LceState.Content && value.dataIsValid) {
                refresh()
            }
            // Refresh only if the FIRST value is valid Content
            refreshed = true
        }
    )
}

/**
 * Wraps use-case to refresh on each subscription
 * @receiver Original model
  */
fun <DATA: Any> LceUseCase<DATA>.refreshed(): LceUseCase<DATA> = object : LceUseCase<DATA> {
    override val state: Flow<LceState<DATA>> = this@refreshed.state.refreshed(this@refreshed::refresh)
    override suspend fun refresh() = this@refreshed.refresh()
}

/**
 * Substitutes [LceState.Loading] with empty data with state produced by [block]
 * @receiver LCE stream
 * @param block transformation block
 */
inline fun <DATA: Any> Flow<LceState<DATA>>.onEmptyLoadingReturn(crossinline block: (LceState.Loading<DATA>) -> LceState<DATA>): Flow<LceState<DATA>> = map {
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
inline fun <DATA: Any> Flow<LceState<DATA>>.onEmptyLoadingReturnItem(crossinline block: () -> DATA?): Flow<LceState<DATA>> = map {
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
inline fun <T : Any> Flow<LceState<T>>.errorToLce(crossinline errorData: (Throwable) -> T? = { null }): Flow<LceState<T>> = catch {
    emit(LceState.Error(errorData(it), false, it))
}


