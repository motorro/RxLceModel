//[disklrucache](../../../index.md)/[com.motorro.rxlcemodel.disklrucache](../index.md)/[DiskLruCacheSyncDelegate](index.md)/[DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate.md)

# DiskLruCacheSyncDelegate

[jvm]\

@JvmOverloads

fun &lt;[D](index.md) : Any&gt; [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate.md)(prefix: String, sd: [CacheDelegateSerializerDeserializer](../../../../base/base/com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)&lt;[D](index.md)&gt;, cacheProvider: [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-provider/index.md), clock: [Clock](../../../../base/base/com.motorro.rxlcemodel.base.entity/-clock/index.md) = Clock.SYSTEM)

## Parameters

jvm

| | |
|---|---|
| prefix | Cache file prefix to group cached files |
| sd | Entity serializer/deserializer |
| cacheProvider | Disk LRU cache provider. Opens cache with a proper entry config |
| clock | Provides timestamp for cache status marks |
