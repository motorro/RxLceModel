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

import com.motorro.rxlcemodel.cache.entity.EntityValidatorFactory
import com.motorro.rxlcemodel.disklrucache.DiskLruCacheSyncDelegate
import com.motorro.rxlcemodel.disklrucache.DiskLruCacheSyncDelegate.DiskLruCacheProvider
import com.motorro.rxlcemodel.disklrucache.createDefaultDelegatePrefix
import com.motorro.rxlcemodel.disklrucache.createDelegate
import com.motorro.rxlcemodel.disklrucache.createNormalizedDelegate
import com.motorro.rxlcemodel.rx.service.CacheFriend
import com.motorro.rxlcemodel.rx.service.SyncDelegateCacheService
import com.motorro.rxlcemodel.rx.service.stringifyParams
import kotlinx.serialization.BinaryFormat
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.cbor.Cbor

/**
 * Creates DiskLRU caching delegate for [SyncDelegateCacheService] that accepts Kotlin-serializable data
 *
 * @receiver Cache provider
 * @param validatorFactory Entity validation factory (defines cache TTL)
 * @param serializer Data serializer/deserializer
 * @param binaryFormat Binary format serializer
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 */
@ExperimentalSerializationApi
inline fun <reified D: Any, P: CacheFriend> DiskLruCacheProvider.withKotlin(
    validatorFactory: EntityValidatorFactory,
    serializer: KSerializer<D>,
    binaryFormat: BinaryFormat = Cbor,
    prefix: String = createDefaultDelegatePrefix(D::class.java)
) : SyncDelegateCacheService.Delegate<D, P> = createDelegate(
    prefix = prefix,
    sd = KotlinCacheDelegateSerializer(
        validatorFactory = validatorFactory,
        kSerializer = serializer,
        binaryFormat = binaryFormat
    ),
    stringify = { cacheKey }
)

/**
 * Creates DiskLRU caching delegate for [SyncDelegateCacheService] that accepts Kotlin-serializable data
 *
 * @receiver Cache provider
 * @param validatorFactory Entity validation factory (defines cache TTL)
 * @param serializer Data serializer/deserializer
 * @param binaryFormat Binary format serializer
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * @param stringify As [DiskLruCacheSyncDelegate] uses string params to create cache keys we should substitute
 * data identifying parameters with string using [stringifyParams]
 */
@ExperimentalSerializationApi
inline fun <reified D: Any, P: Any> DiskLruCacheProvider.withKotlin(
    validatorFactory: EntityValidatorFactory,
    serializer: KSerializer<D>,
    binaryFormat: BinaryFormat = Cbor,
    prefix: String = createDefaultDelegatePrefix(D::class.java),
    crossinline stringify: P.() -> String
) : SyncDelegateCacheService.Delegate<D, P> = createDelegate(
    prefix = prefix,
    sd = KotlinCacheDelegateSerializer(
        validatorFactory = validatorFactory,
        kSerializer = serializer,
        binaryFormat = binaryFormat
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
 * @param binaryFormat Binary format serializer
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 */
@ExperimentalSerializationApi
inline fun <reified D: Any, P: CacheFriend> DiskLruCacheProvider.withKotlinNormalized(
    validatorFactory: EntityValidatorFactory,
    serializer: KSerializer<D>,
    binaryFormat: BinaryFormat = Cbor,
    prefix: String = createDefaultDelegatePrefix(D::class.java)
) : SyncDelegateCacheService.Delegate<D, P> = createNormalizedDelegate(
    prefix = prefix,
    sd = KotlinCacheDelegateSerializer(
        validatorFactory = validatorFactory,
        kSerializer = DataWithCacheKeySerializer(serializer),
        binaryFormat = binaryFormat
    )
)

/**
 * Creates DiskLRU caching delegate for [SyncDelegateCacheService] that accepts Kotlin-serializable data
 * with cache key normalizing and check.
 *
 * @receiver Cache provider
 * @param validatorFactory Entity validation factory (defines cache TTL)
 * @param serializer Data serializer/deserializer
 * @param binaryFormat Binary format serializer
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * @param stringify As [DiskLruCacheSyncDelegate] uses string params to create cache keys we should substitute
 * data identifying parameters with string using [stringifyParams]
 */
@ExperimentalSerializationApi
inline fun <reified D: Any, P: Any> DiskLruCacheProvider.withKotlinNormalized(
    validatorFactory: EntityValidatorFactory,
    serializer: KSerializer<D>,
    binaryFormat: BinaryFormat = Cbor,
    prefix: String = createDefaultDelegatePrefix(D::class.java),
    crossinline stringify: P.() -> String
) : SyncDelegateCacheService.Delegate<D, P> = createNormalizedDelegate(
    prefix = prefix,
    sd = KotlinCacheDelegateSerializer(
        validatorFactory = validatorFactory,
        kSerializer = DataWithCacheKeySerializer(serializer),
        binaryFormat = binaryFormat
    ),
    stringify = stringify
)
