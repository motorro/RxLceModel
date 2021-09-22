//[disklrucache](../../index.md)/[com.motorro.rxlcemodel.disklrucache](index.md)/[createNormalizedDelegate](create-normalized-delegate.md)

# createNormalizedDelegate

[jvm]\
fun &lt;[D](create-normalized-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](create-normalized-delegate.md) : [CacheFriend](../../../base/base/com.motorro.rxlcemodel.base.service/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[createNormalizedDelegate](create-normalized-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: [CacheDelegateSerializerDeserializer](../../../base/base/com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)&lt;[DataWithCacheKey](../../../base/base/com.motorro.rxlcemodel.base.service/-data-with-cache-key/index.md)&lt;[D](create-normalized-delegate.md)&gt;&gt;): [SyncDelegateCacheService.Delegate](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)&lt;[D](create-normalized-delegate.md), [P](create-normalized-delegate.md)&gt;

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) with cache key normalizing and check. Delegate uses cache directory provided by [DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md). This directory is designed to be shared between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix](../../../disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/prefix.md) to not to mix data with other delegates. The [DiskLruCacheSyncDelegate.sd](../../../disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/sd.md) is a serializer/deserializer that saves/restores entity from file streams.

#### Receiver

Cache provider

## Parameters

jvm

| | |
|---|---|
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory |
| sd | Entity Serializer/deserializer data identifying parameters with string using [normalizeParams](normalize-params.md) |

[jvm]\
inline fun &lt;[D](create-normalized-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](create-normalized-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[createNormalizedDelegate](create-normalized-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: [CacheDelegateSerializerDeserializer](../../../base/base/com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)&lt;[DataWithCacheKey](../../../base/base/com.motorro.rxlcemodel.base.service/-data-with-cache-key/index.md)&lt;[D](create-normalized-delegate.md)&gt;&gt;, crossinline stringify: [P](create-normalized-delegate.md).() -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SyncDelegateCacheService.Delegate](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)&lt;[D](create-normalized-delegate.md), [P](create-normalized-delegate.md)&gt;

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) with cache key normalizing and check Delegate uses cache directory provided by [DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md). This directory is designed to be shared between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix](../../../disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/prefix.md) to not to mix data with other delegates. The [DiskLruCacheSyncDelegate.sd](../../../disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/sd.md) is a serializer/deserializer that saves/restores entity from file streams.

#### Receiver

Cache provider

## Parameters

jvm

| | |
|---|---|
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory |
| sd | Entity Serializer/deserializer |
| stringify | As [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute data identifying parameters with string using [normalizeParams](normalize-params.md) |
