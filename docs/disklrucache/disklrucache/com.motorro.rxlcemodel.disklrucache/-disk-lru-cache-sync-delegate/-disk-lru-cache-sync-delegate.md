//[disklrucache](../../../index.md)/[com.motorro.rxlcemodel.disklrucache](../index.md)/[DiskLruCacheSyncDelegate](index.md)/[DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate.md)

# DiskLruCacheSyncDelegate

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)

fun &lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: [CacheDelegateSerializerDeserializer](../../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate-serializer-deserializer/index.md)&lt;[D](index.md)&gt;, cacheProvider: [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-provider/index.md), clock: [Clock](../../../../common/com.motorro.rxlcemodel.common/-clock/index.md) = Clock.SYSTEM)

#### Parameters

jvm

| | |
|---|---|
| prefix | Cache file prefix to group cached files |
| sd | Entity serializer/deserializer |
| cacheProvider | Disk LRU cache provider. Opens cache with a proper entry config |
| clock | Provides timestamp for cache status marks |
