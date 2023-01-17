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

package com.motorro.rxlcemodel.disklrucache

import com.jakewharton.disklrucache.DiskLruCache
import com.motorro.rxlcemodel.cache.CacheDelegate
import com.motorro.rxlcemodel.cache.CacheDelegateSerializerDeserializer
import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.common.Clock
import com.motorro.rxlcemodel.disklrucache.DiskLruCacheSyncDelegate.DiskLruCacheProvider
import java.io.*

/**
 * [DiskLruCache] caching delegate for cache services
 * Designed to operate common [cacheProvider] instance together with other delegates to be able to clean-up all
 * cache all-together - say delete user's cache when user logs out
 * Each entry contains:
 * 0 - saved entity
 * 1 - timestamp entity was last updated with `save`
 * 2 - timestamp entity was invalidated with `invalidate`
 * @param prefix Cache file prefix to group cached files
 * @param sd Entity serializer/deserializer
 * @param cacheProvider Disk LRU cache provider. Opens cache with a proper entry config
 * @param clock Provides timestamp for cache status marks
 * @see DiskLruCacheProvider
 */
class DiskLruCacheSyncDelegate<D: Any> @JvmOverloads constructor (
    private val prefix: String,
    private val sd: CacheDelegateSerializerDeserializer<D>,
    private val cacheProvider: DiskLruCacheProvider,
    private val clock: Clock = Clock.SYSTEM
): CacheDelegate<D, String> {
    /**
     * Provides properly configured [DiskLruCache] with required entry config
     * @param directory a writable directory
     * @param appVersion Current application version
     * @param maxSize the maximum number of bytes this cache should use to store
     */
    class DiskLruCacheProvider(directory: File, appVersion: Int, maxSize: Long) {
        /**
         * Configured [DiskLruCache]
         */
        val cache: DiskLruCache by lazy {
            DiskLruCache.open(
                    directory,
                    appVersion,
                    3,
                    maxSize
            )
        }
    }

    companion object {
        /**
         * Cache indices
         */
        private const val DATA_INDEX = 0
        private const val CREATED_INDEX = 1
        private const val INVALIDATED_INDEX = 2

        /**
         * Stream wrappers
         */
        private inline fun <T: Any?> DiskLruCache.Snapshot.withInputStream(index: Int, action: (InputStream) -> T): T =
                getInputStream(index).use {
                    action(it)
                }
        private inline fun DiskLruCache.Editor.withOutputStream(index: Int, action: (OutputStream) -> Unit) =
                newOutputStream(index).use {
                    action(it)
                }

        /**
         * Long wrappers
         */
        private fun DiskLruCache.Snapshot.readLong(index: Int): Long = withInputStream(index) {
            DataInputStream(it).use { ds -> ds.readLong() }
        }
        private fun DiskLruCache.Editor.writeLong(index: Int, value: Long) = withOutputStream(index) {
            DataOutputStream(it).use { ds -> ds.writeLong(value) }
        }

        /**
         * Data
         */
        private inline fun <T: Any?> DiskLruCache.Snapshot.withDataInputStream(crossinline action: (InputStream) -> T): T = withInputStream(
            DATA_INDEX,
            action
        )
        private inline fun DiskLruCache.Editor.withDataOutputStream(crossinline action: (OutputStream) -> Unit) = withOutputStream(
            DATA_INDEX,
            action
        )

        /**
         * Data length
         */
        private fun DiskLruCache.Snapshot.getDataLength(): Long = getLength(DATA_INDEX)

        /**
         * Created
         */
        private fun DiskLruCache.Snapshot.getCreatedAt(): Long = readLong(CREATED_INDEX)
        private fun DiskLruCache.Editor.setCreatedAt(value: Long) = writeLong(CREATED_INDEX, value)

        /**
         * Invalidated
         */
        private fun DiskLruCache.Snapshot.getInvalidatedAt(): Long = readLong(INVALIDATED_INDEX)
        private fun DiskLruCache.Editor.setInvalidatedAt(value: Long) = writeLong(INVALIDATED_INDEX, value)
    }

    /**
     * An key for entry that holds global invalidation status
     */
    private val invalidationKey = "${prefix}_invalidation"

    /**
     * Global invalidation timestamp
     */
    private var allInvalidatedAt: Long
        get() = cacheProvider.cache.get(invalidationKey)?.getInvalidatedAt() ?: 0L
        set(value) {
            cacheProvider.cache.edit(invalidationKey)?.run {
                runCatching {
                    withOutputStream(DATA_INDEX) {
                        it.write(0)
                    }
                    setCreatedAt(0)
                    setInvalidatedAt(value)
                    commit()
                }.getOrElse {
                    abort()
                }
            }
        }

    /**
     * Generates cache key with [params] and proceeds with [action]
     */
    private inline fun <D: Any?> withCacheKey(params: String, action: (key: String) -> D): D =
            action("${prefix}_$params")

    /**
     * Returns data if cached
     * @param params Caching key
     */
    override fun get(params: String): Entity<D>? = withCacheKey(params) { key ->
        cacheProvider.cache.get(key)?.use { snapshot -> with(snapshot) {
            val invalidated = getCreatedAt() < Math.max(getInvalidatedAt(), allInvalidatedAt)
            withDataInputStream {
                sd.deserializeSnapshot(it, getDataLength(), invalidated)
            }
        }}
    }

    /**
     * Saves data to cache
     * @param params Caching key
     * @param entity Entity to cache
     */
    override fun save(params: String, entity: Entity<D>) = withCacheKey<Unit>(params) { key ->
        cacheProvider.cache.edit(key)?.run {
            runCatching {
                withDataOutputStream {
                    sd.serialize(entity, it)
                }
                setCreatedAt(clock.getMillis())
                setInvalidatedAt(0L)
                commit()
            }.getOrElse {
                abort()
                throw it
            }
        }
    }

    /**
     * Clears cached value
     * @param params Caching key
     */
    override fun invalidate(params: String) = withCacheKey<Unit>(params) { key ->
        cacheProvider.cache.get(key)?.use {
            it.edit()?.run {
                runCatching {
                    setInvalidatedAt(clock.getMillis())
                    commit()
                }.getOrElse {
                    abort()
                }
            }
        }
    }

    /**
     * Invalidates all cached values
     */
    override fun invalidateAll() {
        allInvalidatedAt = clock.getMillis()
    }

    /**
     * Deletes cached value
     * @param params Caching key
     */
    override fun delete(params: String) = withCacheKey<Unit>(params) { key ->
        try {
            cacheProvider.cache.remove(key)
        } catch (e: Throwable) {
            // Ignored
        }
    }
}