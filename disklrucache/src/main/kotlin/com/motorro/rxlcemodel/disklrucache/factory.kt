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

import com.motorro.rxlcemodel.base.entity.EntityValidatorFactory
import com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer
import com.motorro.rxlcemodel.base.service.SyncDelegateCacheService
import com.motorro.rxlcemodel.base.service.stringifyParams
import com.motorro.rxlcemodel.disklrucache.DiskLruCacheSyncDelegate.DiskLruCacheProvider
import java.io.Serializable

/**
 * Creates DiskLRU caching delegate for [SyncDelegateCacheService]
 * Delegate uses cache directory provided by [DiskLruCacheProvider]. This directory is designed to be shared
 * between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix]
 * to not to mix data with other delegates.
 * The [DiskLruCacheSyncDelegate.sd] is a serializer/deserializer that saves/restores entity from file streams.
 *
 * @receiver Cache provider
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * @param sd Entity Serializer/deserializer
 * @param stringify As [DiskLruCacheSyncDelegate] uses string params to create cache keys we should substitute
 * data identifying parameters with string using [stringifyParams]
 */
inline fun <D: Any, P: Any> DiskLruCacheProvider.createDelegate(
    prefix: String,
    sd: CacheDelegateSerializerDeserializer<D>,
    crossinline stringify: P.() -> String = { toString() }
) : SyncDelegateCacheService.Delegate<D, P>  = DiskLruCacheSyncDelegate(
    prefix = prefix,
    sd = sd,
    cacheProvider = this
).stringifyParams(stringify)

/**
 * Creates DiskLRU caching delegate for [SyncDelegateCacheService] that accepts [Serializable] data
 *
 * @receiver Cache provider
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * @param validatorFactory Entity validation factory (defines cache TTL)
 * @param stringify As [DiskLruCacheSyncDelegate] uses string params to create cache keys we should substitute
 * data identifying parameters with string using [stringifyParams]
 */
inline fun <reified D: Serializable, P: Any> DiskLruCacheProvider.withObjectStream(
    prefix: String,
    validatorFactory: EntityValidatorFactory,
    crossinline stringify: P.() -> String = { toString() }
) : SyncDelegateCacheService.Delegate<D, P> = createDelegate(
    prefix = prefix,
    sd = CacheDelegateSerializerDeserializer.WithObjectStream(
        validatorFactory = validatorFactory,
        dataClass = D::class.java
    ),
    stringify = stringify
)
