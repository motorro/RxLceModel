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

import com.motorro.rxlcemodel.base.LceState.Loading
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.base.service.NetService
import com.motorro.rxlcemodel.base.service.ServiceSet
import com.motorro.rxlcemodel.base.service.UpdatingServiceSet
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * A model interface to load data and transmit it to subscribers along with loading operation state
 * @param DATA Data type of data being loaded
 * @param PARAMS Params type that identify data being loaded
 */
interface LceModel<DATA: Any, PARAMS: Any>: LceUseCase<DATA> {
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
