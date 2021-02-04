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

/**
 * State for "Loading-Content-Error" resource which retrieves [data]
 * @param DATA Data Type of data being held
 */
sealed class LceState<out DATA: Any> {
    /**
     * State data
     */
    abstract val data: DATA?

    /**
     * A property that is evaluated internally and may mean that data being emitted is stall,
     * invalidated or otherwise 'not-so-valid' until some further emission (say after network
     * reload).
     */
    abstract val dataIsValid: Boolean

    /**
     * Transfers to [Loading] state preserving data
     * @param type Loading type
     */
    fun toLoading(type: Loading.Type = Loading.Type.LOADING) = Loading(data, dataIsValid, type)

    /**
     * Transfers to [Error] state preserving data
     * @param error Occurred error
     */
    fun toError(error: Throwable) = Error(data, dataIsValid, error)

    /**
     * View is loading
     * @property data State data
     * @property dataIsValid Data validity at the time of emission
     * @property type Loading type
     */
    data class Loading<out DATA: Any> @JvmOverloads constructor (
            override val data: DATA?,
            override val dataIsValid: Boolean,
            val type: Type = Type.LOADING
    ): LceState<DATA>() {
        /**
         * Loading type
         */
        enum class Type {
            /**
             * Just loads. May be initial load operation
             */
            LOADING,
            /**
             * Loading more items for paginated view
             */
            LOADING_MORE,
            /**
             * Refreshing content
             */
            REFRESHING,
            /**
             * Updating data on server
             */
            UPDATING,
        }
    }

    /**
     * Data is loaded and content is displayed
     * @property data State data
     * @property dataIsValid Data validity at the time of emission
     */
    data class Content<out DATA: Any>(
            override val data: DATA,
            override val dataIsValid: Boolean
    ): LceState<DATA>()

    /**
     * Data (or part of it) failed to load
     * @property data State data
     * @property dataIsValid Data validity at the time of emission
     * @property error Data load error
     */
    data class Error<out DATA: Any>(
            override val data: DATA?,
            override val dataIsValid: Boolean,
            val error: Throwable
    ): LceState<DATA>()

    /**
     * A special state that may be used to terminate state emission in cases we always need a latest state to proceed
     * For example we have a view that subscribes to [LceState] for a resource identified with some PARAMS.
     * Than a delete operation is performed on that resource and it is not available anymore.
     * The one may emit [Terminated] to do a special processing (e.g. close the corresponding view) instead of
     * doing it through server request that will return a `Not found` error and doing a special case
     * processing afterwards.
     * Also useful when `onComplete` from state-emitter can't be processed by the end-subscriber. For example LiveData
     * does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion
     * logic.
     */
    class Terminated<out DATA: Any>: LceState<DATA>() {
        /**
         * State data
         */
        override val data: DATA? = null

        /**
         * A property that is evaluated internally and may mean that data being emitted is stall,
         * invalidated or otherwise 'not-so-valid' until some further emission (say after network
         * reload).
         */
        override val dataIsValid: Boolean = false

        override fun equals(other: Any?): Boolean = this === other || other is Terminated<*>

        override fun hashCode(): Int = 0
    }
}

/**
 * Maps data in LceState
 * @param mapper Data mapper
 */
inline fun <DATA_1: Any, DATA_2: Any> LceState<DATA_1>.map(mapper: (data: DATA_1) -> DATA_2): LceState<DATA_2> {
    return when(this) {
        is LceState.Loading -> LceState.Loading(data?.let(mapper), dataIsValid, type)
        is LceState.Content -> LceState.Content(mapper(data), dataIsValid)
        is LceState.Error -> LceState.Error(data?.let(mapper), dataIsValid, error)
        is LceState.Terminated -> LceState.Terminated()
    }
}

/**
 * Combines two Lce states.
 * Here is the result state matrix
 * | Receiver   | other      | Result     |
 * |------------|------------|------------|
 * | Loading    | Loading    | Loading    |
 * | Loading    | Content    | Loading    |
 * | Loading    | Error      | Error      |
 * | Loading    | Terminated | Terminated |
 * | Content    | Loading    | Loading    |
 * | Content    | Content    | Content*   |
 * | Content    | Error      | Error      |
 * | Content    | Terminated | Terminated |
 * | Error      | Loading    | Error      |
 * | Error      | Content    | Error      |
 * | Error      | Error      | Error      |
 * | Error      | Terminated | Terminated |
 * | Terminated | Loading    | Terminated |
 * | Terminated | Content    | Terminated |
 * | Terminated | Error      | Terminated |
 * | Terminated | Terminated | Terminated |
 * @receiver An Lce state that has a priority in final state resolution
 * @param other Other state to combine with
 * @param mapper Data mapper function. Returning null from it means data is not ready and will result
 * in loading state even if both states has data. You may return null-value of any kind to alter resulting state.
 */
inline fun <DATA_1: Any, DATA_2: Any, DATA_3: Any> LceState<DATA_1>.combine(other: LceState<DATA_2>, mapper: (data1: DATA_1?, data2: DATA_2?) -> DATA_3?):  LceState<DATA_3> {
    val data3 = mapper(data, other.data)
    val dataIsValid = null != data3 && dataIsValid && other.dataIsValid

    return when (this) {
        is LceState.Loading -> when (other) {
            is LceState.Error -> LceState.Error(data3, dataIsValid, other.error)
            is LceState.Terminated -> LceState.Terminated()
            else -> LceState.Loading(data3, dataIsValid, this.type)
        }
        is LceState.Content -> when (other) {
            is LceState.Error -> LceState.Error(data3, dataIsValid, other.error)
            is LceState.Terminated -> LceState.Terminated()
            is LceState.Loading -> LceState.Loading(data3, dataIsValid, other.type)
            is LceState.Content -> if (null == data3) {
                LceState.Loading(null, false)
            } else {
                LceState.Content(data3, dataIsValid)
            }
        }
        is LceState.Error -> if (other is LceState.Terminated) {
            LceState.Terminated()
        } else {
            LceState.Error(data3, dataIsValid, error)
        }
        is LceState.Terminated -> LceState.Terminated()
    }
}

/**
 * Runs transformation [block] catching any error and wrapping it to [LceState.Error]:
 * - The output data will be null
 * - The data will be invalid
 */
inline fun <DATA_1: Any, DATA_2: Any> LceState<DATA_1>.catchToLce(block: LceState<DATA_1>.() -> LceState<DATA_2>): LceState<DATA_2> = try {
    block()
} catch (e: Throwable) {
    LceState.Error(null, false, e)
}