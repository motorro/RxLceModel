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

import com.motorro.rxlcemodel.rx.entity.Entity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import java.util.*

/**
 * Interface to cache an [com.motorro.rxlcemodel.rx.entity.Entity] locally
 * Cache should notify subscribers that data has been updated through [getData] channel
 * @param D Data type
 * @param P Params that identify data type
 */
interface CacheService<D: Any, in P: Any> {

    /**
     * Subscribes to cache data updates
     * @param params Params to notify of changes
     */
    fun getData(params: P): Observable<Optional<Entity<D>>>

    /**
     * Saves entity in a cache
     * @param params Params that identify entity
     * @param entity Data to save
     */
    fun save(params: P, entity: Entity<D>): Completable

    /**
     * Makes cache service to refetch cached data updating subscribers with [params]
     * @param params Params that identify entity
     */
    fun refetch(params: P): Completable

    /**
     * Makes cache service to refetch cached data for all active subscribers
     */
    val refetchAll: Completable

    /**
     * Invalidates cached value
     * @param params Params that identify entity
     */
    fun invalidate(params: P): Completable

    /**
     * Invalidates all cached values
     */
    val invalidateAll: Completable

    /**
     * Deletes cached value.
     * The [getData] observable for the same key will emit empty [java.util.Optional].
     * @param params Caching key
     */
    fun delete(params: P): Completable

    companion object {
        /**
         * Creates synchronous [SyncDelegateCacheService.Delegate] cache service
         * @param delegate Delegate that synchronously performs caching actions
         */
        fun <D: Any, P: Any> withSyncDelegate(delegate: SyncDelegateCacheService.Delegate<D, P>) =
                SyncDelegateCacheService(delegate)
    }
}