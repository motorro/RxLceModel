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

/**
 * Service-set for [com.motorro.rxlcemodel.rx.LceModel]
 * @param D Data type
 * @param P Params that identify data type
 */
interface ServiceSet<D: Any, in P: Any> {
    /**
     * Net service
     */
    val net: NetService<D, P>

    /**
     * Cache service
     */
    val cache: CacheService<D, P>
}

/**
 * [ServiceSet] extension with updating [net]
 * @param D Data type
 * @param U Update type
 * @param P Params that identify data type
 */
interface UpdatingServiceSet<D: Any, in U: Any, in P: Any>: ServiceSet<D, P> {
    /**
     * Updating net service
     */
    override val net: UpdatingNetService<D, U, P>
}
