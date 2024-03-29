//[disklrucache](../../index.md)/[com.motorro.rxlcemodel.disklrucache](index.md)/[createDelegate](create-delegate.md)

# createDelegate

[jvm]\
fun &lt;[D](create-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](create-delegate.md) : [CacheFriend](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[createDelegate](create-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: [CacheDelegateSerializerDeserializer](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate-serializer-deserializer/index.md)&lt;[D](create-delegate.md)&gt;): [CacheDelegate](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](create-delegate.md), [P](create-delegate.md)&gt;

Creates DiskLRU caching delegate for cache-service Delegate uses cache directory provided by [DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md). This directory is designed to be shared between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix](../../../disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/prefix.md) to not to mix data with other delegates. The [DiskLruCacheSyncDelegate.sd](../../../disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/sd.md) is a serializer/deserializer that saves/restores entity from file streams.

#### Receiver

Cache provider

#### Parameters

jvm

| | |
|---|---|
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory |
| sd | Entity Serializer/deserializer |

[jvm]\
inline fun &lt;[D](create-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](create-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[createDelegate](create-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: [CacheDelegateSerializerDeserializer](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate-serializer-deserializer/index.md)&lt;[D](create-delegate.md)&gt;, crossinline stringify: [P](create-delegate.md).() -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [CacheDelegate](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](create-delegate.md), [P](create-delegate.md)&gt;

Creates DiskLRU caching delegate for cache-service Delegate uses cache directory provided by [DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md). This directory is designed to be shared between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix](../../../disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/prefix.md) to not to mix data with other delegates. The [DiskLruCacheSyncDelegate.sd](../../../disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/sd.md) is a serializer/deserializer that saves/restores entity from file streams.

#### Receiver

Cache provider

#### Parameters

jvm

| | |
|---|---|
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory |
| sd | Entity Serializer/deserializer |
| stringify | As [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute data identifying parameters with string using [stringifyParams](../../../cache/cache/com.motorro.rxlcemodel.cache/stringify-params.md) |
