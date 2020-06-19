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
import com.motorro.rxlcemodel.base.service.SyncDelegateCacheService.RefreshCommand.All
import com.motorro.rxlcemodel.base.service.SyncDelegateCacheService.RefreshCommand.Individual
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import java.util.*

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
    private sealed class RefreshCommand<P: Any> {
        /**
         * Called by actor to check if the command conserns him
         */
        abstract fun isForMe(params: P): Boolean

        /**
         * Refreshes actor with bound [params]
         */
        data class Individual<P: Any> (val params: P) : RefreshCommand<P>() {
            override fun isForMe(params: P): Boolean = params == this.params
        }

        /**
         * Refreshes all actors
         */
        class All<P: Any> : RefreshCommand<P>() {
            override fun isForMe(params: P): Boolean = true
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
        val readFromCache = Observable.fromCallable { Optional.ofNullable(delegate.get(params)) }
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
        refreshChannel.onNext(All())
    }

    /**
     * Deletes cached value.
     * The [getData] observable for the same key will emit empty [java.util.Optional].
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
