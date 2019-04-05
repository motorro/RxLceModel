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
 * @param PARAMS Params that identify data being loaded
 */
sealed class LceState<out DATA: Any, PARAMS: Any> {
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
     * Params used to load state [data]
     */
    abstract val params: PARAMS

    /**
     * Transfers to [Loading] state preserving data
     * @param type Loading type
     */
    fun toLoading(type: Loading.Type = Loading.Type.LOADING) = Loading(data, dataIsValid, params, type)

    /**
     * Transfers to [Error] state preserving data
     * @param error Occurred error
     */
    fun toError(error: Throwable) = Error(data, dataIsValid, params, error)

    /**
     * View is loading
     * @property data State data
     * @property dataIsValid Data validity at the time of emission
     * @property params Params used to load [data]
     * @property type Loading type
     */
    data class Loading<out DATA: Any, PARAMS: Any> @JvmOverloads constructor (
            override val data: DATA?,
            override val dataIsValid: Boolean,
            override val params: PARAMS,
            val type: Type = Type.LOADING
    ): LceState<DATA, PARAMS>() {
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
     * @property params Params used to load [data]
     */
    data class Content<out DATA: Any, PARAMS: Any>(
            override val data: DATA,
            override val dataIsValid: Boolean,
            override val params: PARAMS
    ): LceState<DATA, PARAMS>()

    /**
     * Data (or part of it) failed to load
     * @property data State data
     * @property dataIsValid Data validity at the time of emission
     * @property params Params used to load [data]
     * @property error Data load error
     */
    data class Error<out DATA: Any, PARAMS: Any>(
            override val data: DATA?,
            override val dataIsValid: Boolean,
            override val params: PARAMS,
            val error: Throwable
    ): LceState<DATA, PARAMS>()

    /**
     * A special state that may be used to terminate state emission in cases we always need a latest state to proceed
     * For example we have a view that subscribes to [LceState] for a resource identified with [PARAMS].
     * Than a delete operation is performed on that resource and it is not available anymore.
     * The one may emit [Terminated] to do a special processing (e.g. close the corresponding view) instead of
     * doing it through server request that will return a `Not found` error and doing a special case
     * processing afterwards.
     * Also useful when `onComplete` from state-emitter can't be processed by the end-subscriber. For example LiveData
     * does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion
     * logic.
     * @property params Params used to load [data]
     */
    data class Terminated<out DATA: Any, PARAMS: Any>(override val params: PARAMS): LceState<DATA, PARAMS>() {
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
    }
}

/**
 * Maps data in LceState
 * @param mapper Data mapper
 */
inline fun <DATA_1: Any, DATA_2: Any, PARAMS: Any> LceState<DATA_1, PARAMS>.map(mapper: (data: DATA_1) -> DATA_2): LceState<DATA_2, PARAMS> {
    return when(this) {
        is LceState.Loading -> LceState.Loading(data?.let(mapper), dataIsValid, params, type)
        is LceState.Content -> LceState.Content(mapper(data), dataIsValid, params)
        is LceState.Error -> LceState.Error(data?.let(mapper), dataIsValid, params, error)
        is LceState.Terminated -> LceState.Terminated(params)
    }
}
