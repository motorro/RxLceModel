//[kserializer](../../index.md)/[com.motorro.rxlcemodel.kserializer](index.md)/[withKotlinNormalized](with-kotlin-normalized.md)

# withKotlinNormalized

[jvm]\
inline fun &lt;[D](with-kotlin-normalized.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-kotlin-normalized.md) : [CacheFriend](../../../base/base/com.motorro.rxlcemodel.base.service/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](../../../disklrucache/disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withKotlinNormalized](with-kotlin-normalized.md)(validatorFactory: [EntityValidatorFactory](../../../base/base/com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md), serializer: KSerializer&lt;[D](with-kotlin-normalized.md)&gt;, binaryFormat: BinaryFormat = Cbor, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = createDefaultDelegatePrefix(D::class.java)): [SyncDelegateCacheService.Delegate](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)&lt;[D](with-kotlin-normalized.md), [P](with-kotlin-normalized.md)&gt;

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts Kotlin-serializable data with cache key normalizing and check.

#### Receiver

Cache provider

## Parameters

jvm

| | |
|---|---|
| validatorFactory | Entity validation factory (defines cache TTL) |
| serializer | Data serializer/deserializer |
| binaryFormat | Binary format serializer |
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory |

[jvm]\
inline fun &lt;[D](with-kotlin-normalized.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-kotlin-normalized.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](../../../disklrucache/disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withKotlinNormalized](with-kotlin-normalized.md)(validatorFactory: [EntityValidatorFactory](../../../base/base/com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md), serializer: KSerializer&lt;[D](with-kotlin-normalized.md)&gt;, binaryFormat: BinaryFormat = Cbor, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = createDefaultDelegatePrefix(D::class.java), crossinline stringify: [P](with-kotlin-normalized.md).() -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SyncDelegateCacheService.Delegate](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)&lt;[D](with-kotlin-normalized.md), [P](with-kotlin-normalized.md)&gt;

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts Kotlin-serializable data with cache key normalizing and check.

#### Receiver

Cache provider

## Parameters

jvm

| | |
|---|---|
| validatorFactory | Entity validation factory (defines cache TTL) |
| serializer | Data serializer/deserializer |
| binaryFormat | Binary format serializer |
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory |
| stringify | As [DiskLruCacheSyncDelegate](../../../disklrucache/disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute data identifying parameters with string using [stringifyParams](../../../base/base/com.motorro.rxlcemodel.base.service/stringify-params.md) |
