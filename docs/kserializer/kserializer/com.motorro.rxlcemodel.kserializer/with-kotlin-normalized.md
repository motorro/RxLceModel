//[kserializer](../../index.md)/[com.motorro.rxlcemodel.kserializer](index.md)/[withKotlinNormalized](with-kotlin-normalized.md)

# withKotlinNormalized

[jvm]\

@ExperimentalSerializationApi

inline fun &lt;[D](with-kotlin-normalized.md) : Any, [P](with-kotlin-normalized.md) : [CacheFriend](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](../../../disklrucache/disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withKotlinNormalized](with-kotlin-normalized.md)(validatorFactory: [EntityValidatorFactory](../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity-validator-factory/index.md), serializer: KSerializer&lt;[D](with-kotlin-normalized.md)&gt;, binaryFormat: BinaryFormat = Cbor, prefix: String = createDefaultDelegatePrefix(D::class.java)): [CacheDelegate](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](with-kotlin-normalized.md), [P](with-kotlin-normalized.md)&gt;

Creates DiskLRU caching delegate for cache-service that accepts Kotlin-serializable data with cache key normalizing and check.

#### Receiver

Cache provider

#### Parameters

jvm

| | |
|---|---|
| validatorFactory | Entity validation factory (defines cache TTL) |
| serializer | Data serializer/deserializer |
| binaryFormat | Binary format serializer |
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory |

[jvm]\

@ExperimentalSerializationApi

inline fun &lt;[D](with-kotlin-normalized.md) : Any, [P](with-kotlin-normalized.md) : Any&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](../../../disklrucache/disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withKotlinNormalized](with-kotlin-normalized.md)(validatorFactory: [EntityValidatorFactory](../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity-validator-factory/index.md), serializer: KSerializer&lt;[D](with-kotlin-normalized.md)&gt;, binaryFormat: BinaryFormat = Cbor, prefix: String = createDefaultDelegatePrefix(D::class.java), crossinline stringify: [P](with-kotlin-normalized.md).() -&gt; String): [CacheDelegate](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](with-kotlin-normalized.md), [P](with-kotlin-normalized.md)&gt;

Creates DiskLRU caching delegate for cache-service that accepts Kotlin-serializable data with cache key normalizing and check.

#### Receiver

Cache provider

#### Parameters

jvm

| | |
|---|---|
| validatorFactory | Entity validation factory (defines cache TTL) |
| serializer | Data serializer/deserializer |
| binaryFormat | Binary format serializer |
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory |
| stringify | As [DiskLruCacheSyncDelegate](../../../disklrucache/disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute data identifying parameters with string using [stringifyParams](../../../cache/cache/com.motorro.rxlcemodel.cache/stringify-params.md) |
