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
 * Data combined with full cached key to validate we get exactly what we are looking for
 * For example, DiskLruCache has strict requirements and limited length of a cache key and
 * hashing of keys may be required to fit into requirements - thus there is a possibility of key
 * clash.
 * @param data Original data
 * @param cacheKey Full unmodified cache key
 * @see CacheFriendDelegate
 */
data class DataWithCacheKey<D: Any>(val data: D, val cacheKey: String)

/**
 * Wraps [delegate] adding unmodified [CacheFriend.cacheKey] to the mix with data.
 * Validates that key on [get] and returns null if it is not equals original.
 * Helps to make sure the data returned is not a result of clashed cache key.
 */
class CacheFriendDelegate<D: Any, P: CacheFriend>(
    private val delegate: CacheDelegate<DataWithCacheKey<D>, P>
): CacheDelegate<D, P> {
    /**
     * Returns data if cached
     * @param params Caching key
     */
    override fun get(params: P): Entity<D>? = delegate.get(params)
            ?.takeIf { params.cacheKey == it.data.cacheKey }
            ?.map { it.data }

    /**
     * Saves data to cache
     * @param params Caching key
     * @param entity Entity to cache
     */
    override fun save(params: P, entity: Entity<D>) = delegate.save(
            params,
            entity.map { DataWithCacheKey(it, params.cacheKey) }
    )

    /**
     * Invalidates cached value
     * @param params Caching key
     */
    override fun invalidate(params: P) = delegate.invalidate(params)

    /**
     * Invalidates all cached values
     */
    override fun invalidateAll() = delegate.invalidateAll()

    /**
     * Deletes cached value
     * @param params Caching key
     */
    override fun delete(params: P) = delegate.delete(params)
}

/**
 * Creates an adapter delegate that creates [CacheFriend] params using [stringify] function
 * @param stringify Function to stringify [P]
 * @receiver Delegate with [CacheFriend] params e.g. the one that saves data to files and uses params as file names
 */
inline fun <D: Any, P: Any> CacheDelegate<D, CacheFriend>.makeFriendParams(crossinline stringify: P.() -> String) = object : CacheDelegate<D, P> {
    private fun createFriend(params: P) = object : CacheFriend {
        override val cacheKey: String = params.stringify()
    }
    override fun get(params: P): Entity<D>? = this@makeFriendParams.get(createFriend(params))
    override fun save(params: P, entity: Entity<D>) = this@makeFriendParams.save(createFriend(params), entity)
    override fun invalidate(params: P) = this@makeFriendParams.invalidate(createFriend(params))
    override fun invalidateAll() = this@makeFriendParams.invalidateAll()
    override fun delete(params: P) = this@makeFriendParams.delete(createFriend(params))
}
