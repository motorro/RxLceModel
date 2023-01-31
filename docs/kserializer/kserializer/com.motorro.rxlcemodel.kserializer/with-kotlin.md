//[kserializer](../../index.md)/[com.motorro.rxlcemodel.kserializer](index.md)/[withKotlin](with-kotlin.md)

# withKotlin

[jvm]\

@ExperimentalSerializationApi

inline fun &lt;[D](with-kotlin.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-kotlin.md) : [CacheFriend](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](../../../disklrucache/disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withKotlin](with-kotlin.md)(validatorFactory: [EntityValidatorFactory](../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity-validator-factory/index.md), serializer: KSerializer&lt;[D](with-kotlin.md)&gt;, binaryFormat: BinaryFormat = Cbor, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = createDefaultDelegatePrefix(D::class.java)): [CacheDelegate](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](with-kotlin.md), [P](with-kotlin.md)&gt;

Creates DiskLRU caching delegate for cache-service that accepts Kotlin-serializable data

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

inline fun &lt;[D](with-kotlin.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-kotlin.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](../../../disklrucache/disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withKotlin](with-kotlin.md)(validatorFactory: [EntityValidatorFactory](../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity-validator-factory/index.md), serializer: KSerializer&lt;[D](with-kotlin.md)&gt;, binaryFormat: BinaryFormat = Cbor, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = createDefaultDelegatePrefix(D::class.java), crossinline stringify: [P](with-kotlin.md).() -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [CacheDelegate](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](with-kotlin.md), [P](with-kotlin.md)&gt;

Creates DiskLRU caching delegate for cache-service that accepts Kotlin-serializable data

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
