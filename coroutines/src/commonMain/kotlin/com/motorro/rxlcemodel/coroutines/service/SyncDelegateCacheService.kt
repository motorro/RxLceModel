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
import com.motorro.rxlcemodel.coroutines.service.SyncDelegateCacheService.RefreshCommand.All
import com.motorro.rxlcemodel.coroutines.service.SyncDelegateCacheService.RefreshCommand.Individual
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

/**
 * Service implementation
 * @param delegate Delegate to perform concrete caching operations
 */
class SyncDelegateCacheService<D: Any, P: Any> internal constructor (private val delegate: CacheDelegate<D, P>): CacheService<D, P> {
    /**
     * Refresh command to send through [refreshChannel]
     */
    private sealed class RefreshCommand<in P: Any> {
        /**
         * Called by actor to check if the command concerns him
         */
        abstract fun isForMe(params: P): Boolean

        /**
         * Refreshes actor with bound [params]
         */
        data class Individual<in P: Any> (private val params: P) : RefreshCommand<P>() {
            override fun isForMe(params: P): Boolean = params == this.params
        }

        /**
         * Refreshes all actors
         */
        object All : RefreshCommand<Any>() {
            override fun isForMe(params: Any): Boolean = true
        }
    }

    /**
     * Service update channel
     */
    private val refreshChannel: MutableSharedFlow<RefreshCommand<P>> = MutableSharedFlow()

    /**
     * Subscribes to cache data updates
     * @param params Params to notify of changes
     */
    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    override fun getData(params: P): Flow<Entity<D>?> {
        val readFromCache = { delegate.get(params) }.asFlow()
        val refreshFlow = refreshChannel.filter { it.isForMe(params) }.flatMapLatest { readFromCache }

        return flowOf(readFromCache, refreshFlow).flattenConcat()
    }

    /**
     * Saves entity in a cache
     * @param params Params that identify entity
     * @param entity Data to save
     */
    override suspend fun save(params: P, entity: Entity<D>) {
        delegate.save(params, entity)
        refreshChannel.emit(Individual(params))
    }

    /**
     * Makes cache service to refetch cached data updating subscribers with [params]
     * @param params Params that identify entity
     */
    override suspend fun refetch(params: P) {
        refreshChannel.emit(Individual(params))
    }

    /**
     * Makes cache service to refetch cached data for all active subscribers
     */
    override suspend fun refetchAll() {
        refreshChannel.emit(All)
    }

    /**
     * Clears cached value
     * @param params Params that identify entity
     */
    override suspend fun invalidate(params: P) {
        delegate.invalidate(params)
        refreshChannel.emit(Individual(params))
    }

    /**
     * Invalidates all cached values
     */
    override suspend fun invalidateAll() {
        delegate.invalidateAll()
        refreshChannel.emit(All)
    }

    /**
     * Deletes cached value.
     * The [getData] observable for the same key will emit empty `null`.
     * @param params Caching key
     */
    override suspend fun delete(params: P) {
        delegate.delete(params)
        refreshChannel.emit(Individual(params))
    }
}

