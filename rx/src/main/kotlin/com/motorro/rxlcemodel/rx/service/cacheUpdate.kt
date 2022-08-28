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

package com.motorro.rxlcemodel.rx.service

import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.rx.service.UpdateOperationState.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

/**
 * Cache update operation state
 */
internal sealed class UpdateOperationState {
    object IDLE: UpdateOperationState() {
        override fun toString(): String = "IDLE"
    }
    object LOADING: UpdateOperationState() {
        override fun toString(): String = "LOADING"
    }
    data class ERROR(val error: Throwable): UpdateOperationState() {
        override fun toString(): String = "ERROR: $error"
    }
}

/**
 * Creates a cache-update operation that gets data from [dataSource] and saves to cache.
 * Network error is returned as [UpdateOperationState.ERROR] while cache save terminates with error
 * to simplify debug.
 * @receiver Cache service
 * @param D Data type
 * @param P Param type
 * @param params Params to build [dataSource]
 * @param dataSource Update operation data source factory
 */
internal inline fun <D: Any, P: Any> CacheService<D, P>.buildUpdateOperation(params: P, dataSource: (params: P) -> Single<out Entity<D>>) =
       Observable.concat(
            Observable.just(LOADING),
            dataSource(params).flatMapObservable<UpdateOperationState> { networkData ->
                save(params, networkData).andThen(Observable.just(IDLE))
            }
       ).onErrorReturn(::ERROR)