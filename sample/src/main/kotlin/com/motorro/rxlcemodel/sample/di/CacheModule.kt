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

package com.motorro.rxlcemodel.sample.di

import android.content.Context
import com.motorro.rxlcemodel.base.entity.EntityValidatorFactory
import com.motorro.rxlcemodel.base.entity.LifespanValidatorFactory
import com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.base.service.SyncDelegateCacheService
import com.motorro.rxlcemodel.base.service.stringifyParams
import com.motorro.rxlcemodel.disklrucache.DiskLruCacheSyncDelegate
import com.motorro.rxlcemodel.sample.BuildConfig
import com.motorro.rxlcemodel.sample.di.CacheConfigModule.Companion.NOTE
import com.motorro.rxlcemodel.sample.di.CacheConfigModule.Companion.NOTE_LIST
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.service.CacheManager
import dagger.Module
import dagger.Provides
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

/**
 * Defines caching behaviour
 * We need that at [Singleton] scope as soon as we provide network use-cases (services) globally
 * @see com.motorro.rxlcemodel.sample.di.ServiceModule
 */
@Module
class CacheConfigModule {
    companion object {
        const val NOTE_LIST = "noteList"
        const val NOTE = "note"
    }

    /**
     * Cache note list for 5 seconds
     */
    @Singleton
    @Provides
    @Named(NOTE_LIST)
    fun userListCacheValidator(): EntityValidatorFactory = LifespanValidatorFactory(5000L)

    /**
     * Cache note for 5 seconds
     */
    @Singleton
    @Provides
    @Named(NOTE)
    fun userProfileCacheValidator(): EntityValidatorFactory = LifespanValidatorFactory(5000L)
}

/**
 * Defines caching components
 */
@Module
class CacheModule {
    companion object {
        /**
         * Cache size
         */
        private const val CACHE_SIZE: Long = 20 * 1024 * 1024
    }

    /**
     * Cache directory
     */
    @Provides
    @ActivityScope
    @Named("cacheDir")
    fun cacheDir(context: Context): File = context.cacheDir

    /**
     * DiskLruCache config provider
     */
    @Provides
    @ActivityScope
    fun cacheProvider(@Named("cacheDir") cacheDir: File) = DiskLruCacheSyncDelegate.DiskLruCacheProvider(
        cacheDir,
        BuildConfig.VERSION_CODE,
        CACHE_SIZE
    )

    /**
     * Cache manager
     */
    @Provides
    @ActivityScope
    fun cacheManager(provider: DiskLruCacheSyncDelegate.DiskLruCacheProvider): CacheManager = object : CacheManager {
        /**
         * Deletes all cache at once
         */
        override fun delete() = provider.cache.delete()
    }

    /**
     * Delegate for [SyncDelegateCacheService] that caches [NoteList]
     * Delegate uses cache directory provided by [diskCache]. This directory is designed to be shared
     * between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix]
     * to not to mix data with other delegates.
     * The [DiskLruCacheSyncDelegate.sd] is a serializer/deserializer that saves/restores entity from file streams
     */
    @ActivityScope
    @Provides
    fun noteListCacheDelegate(
        diskCache: DiskLruCacheSyncDelegate.DiskLruCacheProvider,
        @Named(NOTE_LIST) validatorFactory: EntityValidatorFactory
    ): SyncDelegateCacheService.Delegate<NoteList, String> = DiskLruCacheSyncDelegate(
            prefix = "note_list",
            sd = CacheDelegateSerializerDeserializer.WithObjectStream(
                    validatorFactory = validatorFactory,
                    dataClass = NoteList::class.java
            ),
            cacheProvider = diskCache
    )

    /**
     * Note list cache service
     * [DiskLruCacheSyncDelegate] uses params to create cache keys which should be strings.
     * Thus we should substitute data identifying parameters with string somehow.
     * In case of user list we have [Unit] for params as the list is always the same.
     * So we just supply some arbitrary string to uniquely identify our cache file to [stringifyParams]
     */
    @Provides
    @ActivityScope
    internal fun noteListCacheService(cacheDelegate: @JvmSuppressWildcards SyncDelegateCacheService.Delegate<NoteList, String>): CacheService<NoteList, Unit> =
        CacheService.withSyncDelegate(cacheDelegate.stringifyParams { "notes" })

    /**
     * Delegate for [SyncDelegateCacheService] that caches [Note]
     * Delegate uses cache directory provided by [diskCache]. This directory is designed to be shared between
     * several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix]
     * to not to mix data with other delegates.
     * The [DiskLruCacheSyncDelegate.sd] is a serializer/deserializer that saves/restores entity from file streams.
     */
    @ActivityScope
    @Provides
    fun noteCacheDelegate(
        diskCache: DiskLruCacheSyncDelegate.DiskLruCacheProvider,
        @Named(NOTE) validatorFactory: EntityValidatorFactory
    ): SyncDelegateCacheService.Delegate<Note, String> = DiskLruCacheSyncDelegate(
        prefix = "note",
        sd = CacheDelegateSerializerDeserializer.WithObjectStream(
            validatorFactory = validatorFactory,
            dataClass = Note::class.java
        ),
        cacheProvider = diskCache
    )


    /**
     * Note cache service
     * [DiskLruCacheSyncDelegate] uses params to create cache keys which should be strings.
     * Thus we should substitute data identifying parameters with string somehow.
     * In case of user profile caching we just stringify user id within [stringifyParams]
     */
    @Provides
    @ActivityScope
    internal fun noteCacheService(cacheDelegate: @JvmSuppressWildcards SyncDelegateCacheService.Delegate<Note, String>): CacheService<Note, Int> =
        CacheService.withSyncDelegate(cacheDelegate.stringifyParams { this.toString() })
}