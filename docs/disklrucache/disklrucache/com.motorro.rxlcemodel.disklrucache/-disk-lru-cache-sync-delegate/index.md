//[disklrucache](../../../index.md)/[com.motorro.rxlcemodel.disklrucache](../index.md)/[DiskLruCacheSyncDelegate](index.md)

# DiskLruCacheSyncDelegate

[jvm]\
class [DiskLruCacheSyncDelegate](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: [CacheDelegateSerializerDeserializer](../../../../base/base/com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)&lt;[D](index.md)&gt;, cacheProvider: [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-provider/index.md), clock: [Clock](../../../../base/base/com.motorro.rxlcemodel.base.entity/-clock/index.md) = Clock.SYSTEM) : [SyncDelegateCacheService.Delegate](../../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)&lt;[D](index.md), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; 

DiskLruCache caching delegate for [SyncDelegateCacheService](../../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) Designed to operate common [cacheProvider](../../../../disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/cache-provider.md) instance together with other delegates to be able to clean-up all cache all-together - say delete user's cache when user logs out Each entry contains: 0 - saved entity 1 - timestamp entity was last updated with `save` 2 - timestamp entity was invalidated with `invalidate`

## See also

jvm

| | |
|---|---|
| [com.motorro.rxlcemodel.disklrucache.DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-provider/index.md) |  |

## Parameters

jvm

| | |
|---|---|
| prefix | Cache file prefix to group cached files |
| sd | Entity serializer/deserializer |
| cacheProvider | Disk LRU cache provider. Opens cache with a proper entry config |
| clock | Provides timestamp for cache status marks |

## Constructors

| | |
|---|---|
| [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun &lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: [CacheDelegateSerializerDeserializer](../../../../base/base/com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)&lt;[D](index.md)&gt;, cacheProvider: [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-provider/index.md), clock: [Clock](../../../../base/base/com.motorro.rxlcemodel.base.entity/-clock/index.md) = Clock.SYSTEM) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |
| [DiskLruCacheProvider](-disk-lru-cache-provider/index.md) | [jvm]<br>class [DiskLruCacheProvider](-disk-lru-cache-provider/index.md)(directory: [File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html), appVersion: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), maxSize: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))<br>Provides properly configured DiskLruCache with required entry config |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [jvm]<br>open override fun [delete](delete.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Deletes cached value |
| [get](get.md) | [jvm]<br>open override fun [get](get.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Entity](../../../../base/base/com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;?<br>Returns data if cached |
| [invalidate](invalidate.md) | [jvm]<br>open override fun [invalidate](invalidate.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Clears cached value |
| [invalidateAll](invalidate-all.md) | [jvm]<br>open override fun [invalidateAll](invalidate-all.md)()<br>Invalidates all cached values |
| [save](save.md) | [jvm]<br>open override fun [save](save.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), entity: [Entity](../../../../base/base/com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;)<br>Saves data to cache |

## Extensions

| Name | Summary |
|---|---|
| [normalizeParams](../normalize-params.md) | [jvm]<br>fun &lt;[D](../normalize-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](../normalize-params.md) : [CacheFriend](../../../../base/base/com.motorro.rxlcemodel.base.service/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate](index.md)&lt;[D](../normalize-params.md)&gt;.[normalizeParams](../normalize-params.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SyncDelegateCacheService.Delegate](../../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)&lt;[D](../normalize-params.md), [P](../normalize-params.md)&gt;<br>Creates an adapter delegate that normalizes [CacheFriend.cacheKey](../../../../base/base/com.motorro.rxlcemodel.base.service/-cache-friend/cache-key.md) to fit into DiskLruCache requirements of 64 a-zA-Z0-9 symbols |
