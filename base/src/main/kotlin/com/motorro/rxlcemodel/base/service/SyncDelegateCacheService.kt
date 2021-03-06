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

import com.gojuno.koptional.Optional
import com.gojuno.koptional.toOptional
import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.service.SyncDelegateCacheService.RefreshCommand.All
import com.motorro.rxlcemodel.base.service.SyncDelegateCacheService.RefreshCommand.Individual
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

/**
 * Service implementation
 * @param delegate Delegate to perform concrete caching operations
 */
class SyncDelegateCacheService<D: Any, P: Any> internal constructor (private val delegate: Delegate<D, P>): CacheService<D, P> {
    /**
     * Delegate that synchronously performs caching operations
     */
    interface Delegate<D: Any, P: Any> {
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
    private val refreshChannel: Subject<RefreshCommand<P>> = PublishSubject.create<RefreshCommand<P>>().toSerialized()

    /**
     * Subscribes to cache data updates
     * @param params Params to notify of changes
     */
    override fun getData(params: P): Observable<Optional<Entity<D>>> {
        val readFromCache = Observable.fromCallable { delegate.get(params).toOptional() }
        return Observable.concatEager(
                listOf(
                    readFromCache,
                    refreshChannel
                            .filter { it.isForMe(params) }
                            .switchMap { readFromCache }
                )
        ).distinctUntilChanged()
    }

    /**
     * Saves entity in a cache
     * @param params Params that identify entity
     * @param entity Data to save
     */
    override fun save(params: P, entity: Entity<D>): Completable = Completable.fromAction {
        delegate.save(params, entity)
        refreshChannel.onNext(Individual(params))
    }

    /**
     * Makes cache service to refetch cached data updating subscribers with [params]
     * @param params Params that identify entity
     */
    override fun refetch(params: P): Completable = Completable.fromAction {
        refreshChannel.onNext(Individual(params))
    }

    /**
     * Makes cache service to refetch cached data for all active subscribers
     */
    override val refetchAll: Completable
        get() = Completable.fromAction {
            refreshChannel.onNext(All)
        }

    /**
     * Clears cached value
     * @param params Params that identify entity
     */
    override fun invalidate(params: P): Completable = Completable.fromAction {
        delegate.invalidate(params)
        refreshChannel.onNext(Individual(params))
    }

    /**
     * Invalidates all cached values
     */
    override val invalidateAll: Completable = Completable.fromAction {
        delegate.invalidateAll()
        refreshChannel.onNext(All)
    }

    /**
     * Deletes cached value.
     * The [getData] observable for the same key wil emit [com.gojuno.koptional.None]
     * @param params Caching key
     */
    override fun delete(params: P): Completable = Completable.fromAction {
        delegate.delete(params)
        refreshChannel.onNext(Individual(params))
    }
}

/**
 * Creates an adapter delegate that [stringify] [P] and uses result string as params to receiver
 * @receiver Delegate with String params e.g. the one that saves data to files and uses params as file names
 * @param stringify Function to stringify [P]
 */
inline fun <D: Any, P: Any> SyncDelegateCacheService.Delegate<D, String>.stringifyParams(crossinline stringify: P.() -> String = { toString() }) = object : SyncDelegateCacheService.Delegate<D, P> {
    override fun get(params: P): Entity<D>? = this@stringifyParams.get(params.stringify())
    override fun save(params: P, entity: Entity<D>) = this@stringifyParams.save(params.stringify(), entity)
    override fun invalidate(params: P) = this@stringifyParams.invalidate(params.stringify())
    override fun invalidateAll() = this@stringifyParams.invalidateAll()
    override fun delete(params: P) = this@stringifyParams.delete(params.stringify())
}
