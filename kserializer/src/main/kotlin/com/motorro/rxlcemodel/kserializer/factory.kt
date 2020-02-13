/*
 * Copyright 2020 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.kserializer

import com.motorro.rxlcemodel.base.entity.EntityValidatorFactory
import com.motorro.rxlcemodel.base.service.CacheFriend
import com.motorro.rxlcemodel.base.service.SyncDelegateCacheService
import com.motorro.rxlcemodel.base.service.stringifyParams
import com.motorro.rxlcemodel.disklrucache.DiskLruCacheSyncDelegate
import com.motorro.rxlcemodel.disklrucache.DiskLruCacheSyncDelegate.DiskLruCacheProvider
import com.motorro.rxlcemodel.disklrucache.createDefaultDelegatePrefix
import com.motorro.rxlcemodel.disklrucache.createDelegate
import com.motorro.rxlcemodel.disklrucache.createNormalizedDelegate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.cbor.Cbor

/**
 * Creates DiskLRU caching delegate for [SyncDelegateCacheService] that accepts Kotlin-serializable data
 *
 * @receiver Cache provider
 * @param validatorFactory Entity validation factory (defines cache TTL)
 * @param serializer Data serializer/deserializer
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * @param stringify As [DiskLruCacheSyncDelegate] uses string params to create cache keys we should substitute
 * data identifying parameters with string using [stringifyParams]
 */
inline fun <reified D: Any, P: Any> DiskLruCacheProvider.withKotlin(
    validatorFactory: EntityValidatorFactory,
    serializer: KSerializer<D>,
    cbor: Cbor = Cbor.plain,
    prefix: String = createDefaultDelegatePrefix(D::class.java),
    crossinline stringify: P.() -> String = { toString() }
) : SyncDelegateCacheService.Delegate<D, P> = createDelegate(
    prefix = prefix,
    sd = KotlinCacheDelegateSerializer(
        validatorFactory = validatorFactory,
        kSerializer = serializer,
        cbor = cbor
    ),
    stringify = stringify
)

/**
 * Creates DiskLRU caching delegate for [SyncDelegateCacheService] that accepts Kotlin-serializable data
 * with cache key normalizing and check.
 *
 * @receiver Cache provider
 * @param validatorFactory Entity validation factory (defines cache TTL)
 * @param serializer Data serializer/deserializer
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 */
inline fun <reified D: Any, P: CacheFriend> DiskLruCacheProvider.withKotlinNormalized(
    validatorFactory: EntityValidatorFactory,
    serializer: KSerializer<D>,
    cbor: Cbor = Cbor.plain,
    prefix: String = createDefaultDelegatePrefix(D::class.java)
) : SyncDelegateCacheService.Delegate<D, P> = createNormalizedDelegate(
    prefix = prefix,
    sd = KotlinCacheDelegateSerializer(
        validatorFactory = validatorFactory,
        kSerializer = DataWithCacheKeySerializer(serializer),
        cbor = cbor
    )
)

/**
 * Creates DiskLRU caching delegate for [SyncDelegateCacheService] that accepts Kotlin-serializable data
 * with cache key normalizing and check.
 *
 * @receiver Cache provider
 * @param validatorFactory Entity validation factory (defines cache TTL)
 * @param serializer Data serializer/deserializer
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * @param stringify As [DiskLruCacheSyncDelegate] uses string params to create cache keys we should substitute
 * data identifying parameters with string using [stringifyParams]
 */
inline fun <reified D: Any, P: Any> DiskLruCacheProvider.withKotlinNormalized(
    validatorFactory: EntityValidatorFactory,
    serializer: KSerializer<D>,
    cbor: Cbor = Cbor.plain,
    prefix: String = createDefaultDelegatePrefix(D::class.java),
    crossinline stringify: P.() -> String = { toString() }
) : SyncDelegateCacheService.Delegate<D, P> = createNormalizedDelegate(
    prefix = prefix,
    sd = KotlinCacheDelegateSerializer(
        validatorFactory = validatorFactory,
        kSerializer = DataWithCacheKeySerializer(serializer),
        cbor = cbor
    ),
    stringify = stringify
)
