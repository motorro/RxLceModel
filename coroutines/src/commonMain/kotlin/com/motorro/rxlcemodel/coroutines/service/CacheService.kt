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

package com.motorro.rxlcemodel.coroutines.service

import com.motorro.rxlcemodel.cache.CacheDelegate
import com.motorro.rxlcemodel.cache.entity.Entity
import kotlinx.coroutines.flow.Flow

/**
 * Interface to cache an [com.motorro.rxlcemodel.cache.entity.Entity] locally
 * Cache should notify subscribers that data has been updated through [getData] channel
 * @param D Data type
 * @param P Params that identify data type
 */
interface CacheService<D: Any, in P: Any> {

    /**
     * Subscribes to cache data updates
     * @param params Params to notify of changes
     */
    fun getData(params: P): Flow<Entity<D>?>

    /**
     * Saves entity in a cache
     * @param params Params that identify entity
     * @param entity Data to save
     */
    suspend fun save(params: P, entity: Entity<D>)

    /**
     * Makes cache service to refetch cached data updating subscribers with [params]
     * @param params Params that identify entity
     */
    suspend fun refetch(params: P)

    /**
     * Makes cache service to refetch cached data for all active subscribers
     */
    suspend fun refetchAll()

    /**
     * Invalidates cached value
     * @param params Params that identify entity
     */
    suspend fun invalidate(params: P)

    /**
     * Invalidates all cached values
     */
    suspend fun invalidateAll()

    /**
     * Deletes cached value.
     * The [getData] observable for the same key will emit `null`.
     * @param params Caching key
     */
    suspend fun delete(params: P)

    companion object {
        /**
         * Creates synchronous [CacheDelegate] cache service
         * @param delegate Delegate that synchronously performs caching actions
         */
        fun <D: Any, P: Any> withSyncDelegate(delegate: CacheDelegate<D, P>) = SyncDelegateCacheService(delegate)
    }
}