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

package com.motorro.rxlcemodel.base.service

import com.motorro.rxlcemodel.base.entity.Entity
import io.reactivex.rxjava3.core.Single

/**
 * Interface to load an [com.motorro.rxlcemodel.base.entity.Entity] from network
 * @param D Data type
 * @param P Params that identify data type
 */
interface NetService<D: Any, in P: Any> {
    /**
     * Gets entity from network or throws on error
     * @param params Params that distinguish entity
     */
    fun get(params: P): Single<Entity<D>>
}

/**
 * [NetService] extension to update data on server
 * @param D Data type
 * @param U Update type
 * @param P Params that identify data type
 */
interface UpdatingNetService<D: Any, in U: Any, in P: Any>: NetService<D, P> {
    /**
     * Updates data on server returning updated one
     * @param params Params that distinguish entity
     * @param update Entity update
     */
    fun update(params: P, update: U): Single<Entity<D>>
}