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
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * A simple memory cache for [SyncDelegateCacheService].
 * @param D Data type
 * @param P Params type
 */
abstract class MemorySyncDelegate<D: Any, P: Any>: SyncDelegateCacheService.Delegate<D, P> {
    companion object {
        /**
         * Creates a simple in-memory cache without LRU strategy
         * @param initialCapacity The initial capacity. The implementation performs internal sizing
         * to accommodate this many elements.
         */
        fun <D: Any, P: Any> simple(initialCapacity: Int = 16) = object : MemorySyncDelegate<D, P>() {
            /**
             * Data storage
             */
            override val cache: MutableMap<P, Entity<D>> = ConcurrentHashMap(initialCapacity)
        }

        /**
         * Creates an in-memory LRU cache with [maxEntries] records maximum
         * @param maxEntries Maximum number of entries in map
         * @param initialCapacity The initial capacity. The implementation performs internal sizing
         * to accommodate this many elements.
         */
        fun <D: Any, P: Any> lru(maxEntries: Int, initialCapacity: Int = 16) = object : MemorySyncDelegate<D, P>() {
            /**
             * Data storage
             */
            override val cache: MutableMap<P, Entity<D>> = Collections.synchronizedMap(
                    object : LinkedHashMap<P, Entity<D>>(initialCapacity) {
                        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<P, Entity<D>>?): Boolean =
                                size > maxEntries
                    }
            )
        }

        /**
         * Creates an in-memory LRU cache with custom [map] as a cache
         * @param map A map to hold cache data
         */
        fun <D: Any, P: Any> custom(map: MutableMap<P, Entity<D>>) = object : MemorySyncDelegate<D, P>() {
            /**
             * Data storage
             */
            override val cache: MutableMap<P, Entity<D>> = map
        }
    }

    /**
     * Data storage
     */
    protected abstract val cache: MutableMap<P, Entity<D>>

    /**
     * Returns data if cached
     * @param params Caching key
     */
    override fun get(params: P): Entity<D>? = cache[params]

    /**
     * Saves data to cache
     * @param params Caching key
     * @param entity Entity to cache
     */
    override fun save(params: P, entity: Entity<D>) {
        cache[params] = entity
    }

    /**
     * Invalidates cached value
     * @param params Caching key
     */
    override fun invalidate(params: P) {
        cache.remove(params)
    }

    /**
     * Invalidates all cached values
     */
    override fun invalidateAll() {
        cache.clear()
    }

    /**
     * Deletes cached value
     * @param params Caching key
     */
    override fun delete(params: P) {
        cache.remove(params)
    }
}
