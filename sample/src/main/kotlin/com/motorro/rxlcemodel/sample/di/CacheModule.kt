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
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.disklrucache.DiskLruCacheSyncDelegate.DiskLruCacheProvider
import com.motorro.rxlcemodel.disklrucache.withObjectStream
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
        private const val CACHE_SIZE: Long = 20L * 1024L * 1024L
    }

    /**
     * Cache directory
     */
    @Singleton
    @Provides
    @Named("cacheDir")
    fun cacheDir(context: Context): File = context.cacheDir

    /**
     * DiskLruCache config provider
     */
    @Singleton
    @Provides
    fun cacheProvider(@Named("cacheDir") cacheDir: File) = DiskLruCacheProvider(
        cacheDir,
        BuildConfig.VERSION_CODE,
        CACHE_SIZE
    )

    /**
     * Cache manager
     */
    @Singleton
    @Provides
    fun cacheManager(provider: DiskLruCacheProvider): CacheManager = object : CacheManager {
        /**
         * Deletes all cache at once
         */
        override fun delete() = provider.cache.delete()
    }

    /**
     * Note list cache service
     */
    @Singleton
    @Provides
    internal fun noteListCacheService(
        diskCache: DiskLruCacheProvider,
        @Named(NOTE_LIST) validatorFactory: EntityValidatorFactory
    ): CacheService<NoteList, Unit> = CacheService.withSyncDelegate(
        diskCache.withObjectStream(validatorFactory, "note") { "notes" }
    )

    /**
     * Note cache service
     * Using default factory-function parameters
     */
    @Singleton
    @Provides
    internal fun noteCacheService(
        diskCache: DiskLruCacheProvider,
        @Named(NOTE) validatorFactory: EntityValidatorFactory
    ): CacheService<Note, Int> = CacheService.withSyncDelegate(
        diskCache.withObjectStream(validatorFactory) { toString() }
    )
}