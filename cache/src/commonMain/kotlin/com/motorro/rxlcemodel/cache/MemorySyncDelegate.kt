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
import io.github.reactivecircus.cache4k.Cache

/**
 * A simple memory cache for cache-service
 * @param D Data type
 * @param P Params type
 */
abstract class MemorySyncDelegate<D: Any, P: Any>: CacheDelegate<D, P> {
    companion object {
        /**
         * Creates an in-memory LRU cache with [maxEntries] records maximum
         * to accommodate this many elements.
         * @param maxEntries Maximum number of entries in map
         */
        fun <D: Any, P: Any> create(maxEntries: Long) = object : MemorySyncDelegate<D, P>() {
            /**
             * Data storage
             */
            override val cache: Cache<P, Entity<D>> = Cache.Builder().maximumCacheSize(maxEntries).build()
        }
    }

    /**
     * Data storage
     */
    protected abstract val cache: Cache<P, Entity<D>>

    /**
     * Returns data if cached
     * @param params Caching key
     */
    override fun get(params: P): Entity<D>? = cache.get(params)?.createSnapshot()

    /**
     * Saves data to cache
     * @param params Caching key
     * @param entity Entity to cache
     */
    override fun save(params: P, entity: Entity<D>) {
        cache.put(params, entity)
    }

    /**
     * Invalidates cached value
     * @param params Caching key
     */
    override fun invalidate(params: P) {
        cache.invalidate(params)
    }

    /**
     * Invalidates all cached values
     */
    override fun invalidateAll() {
        cache.invalidateAll()
    }

    /**
     * Deletes cached value
     * @param params Caching key
     */
    override fun delete(params: P) {
        cache.invalidate(params)
    }
}
