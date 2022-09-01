/*
 * Copyright 2022 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.cache

import com.motorro.rxlcemodel.cache.entity.Entity

/**
 * Delegate that synchronously performs caching operations
 */
interface CacheDelegate<D: Any, P: Any> {
    /**
     * Returns data if cached
     * @param params Caching key
     */
    fun get(params: P): Entity<D>?

    /**
     * Saves data to cache
     * @param params Caching key
     * @param entity Entity to cache
     */
    fun save(params: P, entity: Entity<D>)

    /**
     * Invalidates cached value
     * @param params Caching key
     */
    fun invalidate(params: P)

    /**
     * Invalidates all cached values
     */
    fun invalidateAll()

    /**
     * Deletes cached value
     * @param params Caching key
     */
    fun delete(params: P)
}