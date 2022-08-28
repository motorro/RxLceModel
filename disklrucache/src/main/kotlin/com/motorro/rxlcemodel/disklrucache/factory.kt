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

package com.motorro.rxlcemodel.disklrucache

import com.motorro.rxlcemodel.cache.*
import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.cache.entity.EntityValidatorFactory
import com.motorro.rxlcemodel.disklrucache.DiskLruCacheSyncDelegate.DiskLruCacheProvider
import java.io.Serializable
import java.security.MessageDigest
import java.util.*

/**
 * Default delegate prefix for type
 */
fun <T: Any> createDefaultDelegatePrefix(cls: Class<T>) = cls.simpleName.lowercase(Locale.US)

/**
 * Creates DiskLRU caching delegate for cache-service
 * Delegate uses cache directory provided by [DiskLruCacheProvider]. This directory is designed to be shared
 * between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix]
 * to not to mix data with other delegates.
 * The [DiskLruCacheSyncDelegate.sd] is a serializer/deserializer that saves/restores entity from file streams.
 *
 * @receiver Cache provider
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * @param sd Entity Serializer/deserializer
 */
fun <D: Any, P: CacheFriend> DiskLruCacheProvider.createDelegate(
    prefix: String,
    sd: CacheDelegateSerializerDeserializer<D>
) : CacheDelegate<D, P> = DiskLruCacheSyncDelegate(
    prefix = prefix,
    sd = sd,
    cacheProvider = this
).stringifyParams { cacheKey }

/**
 * Creates DiskLRU caching delegate for cache-service
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
    crossinline stringify: P.() -> String
) : CacheDelegate<D, P> = DiskLruCacheSyncDelegate(
    prefix = prefix,
    sd = sd,
    cacheProvider = this
).stringifyParams(stringify)

/**
 * Creates DiskLRU caching delegate for cache-service with cache key normalizing and check.
 * Delegate uses cache directory provided by [DiskLruCacheProvider]. This directory is designed to be shared
 * between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix]
 * to not to mix data with other delegates.
 * The [DiskLruCacheSyncDelegate.sd] is a serializer/deserializer that saves/restores entity from file streams.
 *
 * @receiver Cache provider
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * @param sd Entity Serializer/deserializer
 * data identifying parameters with string using [normalizeParams]
 */
fun <D: Any, P: CacheFriend> DiskLruCacheProvider.createNormalizedDelegate(
    prefix: String,
    sd: CacheDelegateSerializerDeserializer<DataWithCacheKey<D>>
) : CacheDelegate<D, P> = CacheFriendDelegate(
    DiskLruCacheSyncDelegate(
        prefix = prefix,
        sd = sd,
        cacheProvider = this
    ).normalizeParams(prefix)
)

/**
 * Creates DiskLRU caching delegate for cache-service with cache key normalizing and check
 * Delegate uses cache directory provided by [DiskLruCacheProvider]. This directory is designed to be shared
 * between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix]
 * to not to mix data with other delegates.
 * The [DiskLruCacheSyncDelegate.sd] is a serializer/deserializer that saves/restores entity from file streams.
 *
 * @receiver Cache provider
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * @param sd Entity Serializer/deserializer
 * @param stringify As [DiskLruCacheSyncDelegate] uses string params to create cache keys we should substitute
 * data identifying parameters with string using [normalizeParams]
 */
inline fun <D: Any, P: Any> DiskLruCacheProvider.createNormalizedDelegate(
    prefix: String,
    sd: CacheDelegateSerializerDeserializer<DataWithCacheKey<D>>,
    crossinline stringify: P.() -> String
) : CacheDelegate<D, P> = createNormalizedDelegate<D, CacheFriend>(prefix,sd).makeFriendParams(stringify)

/**
 * Creates DiskLRU caching delegate for cache-service that accepts [Serializable] data
 * with cache key normalizing and check
 *
 * @receiver Cache provider
 * @param validatorFactory Entity validation factory (defines cache TTL)
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 */
inline fun <reified D: Serializable, P: CacheFriend> DiskLruCacheProvider.withObjectStream(
    validatorFactory: EntityValidatorFactory,
    prefix: String = createDefaultDelegatePrefix(D::class.java)
) : CacheDelegate<D, P> = createDelegate(
    prefix = prefix,
    sd = CacheDelegateSerializerDeserializer.WithObjectStream(
        validatorFactory = validatorFactory,
        dataClass = D::class.java
    )
)

/**
 * Creates DiskLRU caching delegate for cache-service that accepts [Serializable] data
 * with cache key normalizing and check
 *
 * @receiver Cache provider
 * @param validatorFactory Entity validation factory (defines cache TTL)
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * @param stringify As [DiskLruCacheSyncDelegate] uses string params to create cache keys we should substitute
 * data identifying parameters with string using [stringifyParams]
 */
inline fun <reified D: Serializable, P: Any> DiskLruCacheProvider.withObjectStream(
    validatorFactory: EntityValidatorFactory,
    prefix: String = createDefaultDelegatePrefix(D::class.java),
    crossinline stringify: P.() -> String
) : CacheDelegate<D, P> = createDelegate(
    prefix = prefix,
    sd = CacheDelegateSerializerDeserializer.WithObjectStream(
        validatorFactory = validatorFactory,
        dataClass = D::class.java
    ),
    stringify = stringify
)

/**
 * Creates DiskLRU caching delegate for cache-service that accepts [Serializable] data
 * with cache key normalizing and check.
 *
 * @receiver Cache provider
 * @param validatorFactory Entity validation factory (defines cache TTL)
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * data identifying parameters with string using [stringifyParams]
 */
inline fun <reified D: Serializable, P: CacheFriend> DiskLruCacheProvider.withObjectStreamNormalized(
    validatorFactory: EntityValidatorFactory,
    prefix: String = createDefaultDelegatePrefix(D::class.java)
) : CacheDelegate<D, P> = createNormalizedDelegate(
    prefix = prefix,
    sd = WithObjectStreamAndCacheKey(
        validatorFactory = validatorFactory,
        dataClass = D::class.java
    )
)

/**
 * Creates DiskLRU caching delegate for cache-service that accepts [Serializable] data
 * with cache key normalizing and check.
 *
 * @receiver Cache provider
 * @param validatorFactory Entity validation factory (defines cache TTL)
 * @param prefix Caching name prefix to distinguish cache files from other delegates within the same cache directory
 * @param stringify As [DiskLruCacheSyncDelegate] uses string params to create cache keys we should substitute
 * data identifying parameters with string using [stringifyParams]
 */
inline fun <reified D: Serializable, P: CacheFriend> DiskLruCacheProvider.withObjectStreamNormalized(
    validatorFactory: EntityValidatorFactory,
    prefix: String = createDefaultDelegatePrefix(D::class.java),
    crossinline stringify: P.() -> String
) : CacheDelegate<D, P> = createNormalizedDelegate(
    prefix = prefix,
    sd = WithObjectStreamAndCacheKey(
        validatorFactory = validatorFactory,
        dataClass = D::class.java
    ),
    stringify = stringify
)

/**
 * Current DiskLruCache key requirements
 */
private const val DISKLRU_LENGTH = 64
private val DISKLRU_PATTERN = "[a-z0-9_-]{1,$DISKLRU_LENGTH}".toRegex()

/**
 * Hex characters
 */
val HEX_CHARS = "0123456789abcdef".toCharArray()

/**
 * Byte array -> Hex
 */
private fun ByteArray.hex(): String {
    val r = StringBuilder(size * 2)
    forEach { b ->
        val i = b.toInt()
        r.append(HEX_CHARS[i shr 4 and 0xF])
        r.append(HEX_CHARS[i and 0xF])
    }
    return r.toString()
}

/**
 * Hashes string
 */
private fun String.md5(): String = MessageDigest.getInstance("MD5").digest(toByteArray()).hex()

/**
 * Checks [CacheFriend.cacheKey] if it fits to [com.jakewharton.disklrucache.DiskLruCache] key
 * requirements and hashes it if not
 */
fun CacheFriend.getNormalizedKey(prefix: String): String = when {
    cacheKey.length + prefix.length + 1 > DISKLRU_LENGTH -> cacheKey.md5()
    false == DISKLRU_PATTERN.matches(cacheKey) -> cacheKey.md5()
    else -> cacheKey
}

/**
 * Creates an adapter delegate that normalizes [CacheFriend.cacheKey] to fit into DiskLruCache requirements of 64 a-zA-Z0-9 symbols
 * @receiver DiskLruCacheSyncDelegate
 */
fun <D: Any, P: CacheFriend> DiskLruCacheSyncDelegate<D>.normalizeParams(prefix: String) = object :
    CacheDelegate<D, P> {
    override fun get(params: P): Entity<D>? = this@normalizeParams.get(params.getNormalizedKey(prefix))
    override fun save(params: P, entity: Entity<D>) = this@normalizeParams.save(params.getNormalizedKey(prefix), entity)
    override fun invalidate(params: P) = this@normalizeParams.invalidate(params.getNormalizedKey(prefix))
    override fun invalidateAll() = this@normalizeParams.invalidateAll()
    override fun delete(params: P) = this@normalizeParams.delete(params.getNormalizedKey(prefix))
}
