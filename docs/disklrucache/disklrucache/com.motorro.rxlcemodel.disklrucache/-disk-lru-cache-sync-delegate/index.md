//[disklrucache](../../../index.md)/[com.motorro.rxlcemodel.disklrucache](../index.md)/[DiskLruCacheSyncDelegate](index.md)

# DiskLruCacheSyncDelegate

class [DiskLruCacheSyncDelegate](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: [CacheDelegateSerializerDeserializer](../../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate-serializer-deserializer/index.md)&lt;[D](index.md)&gt;, cacheProvider: [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-provider/index.md), clock: [Clock](../../../../common/com.motorro.rxlcemodel.common/-clock/index.md) = Clock.SYSTEM) : [CacheDelegate](../../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](index.md), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; 

DiskLruCache caching delegate for cache services Designed to operate common [cacheProvider](../../../../disklrucache/com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/cache-provider.md) instance together with other delegates to be able to clean-up all cache all-together - say delete user's cache when user logs out Each entry contains: 0 - saved entity 1 - timestamp entity was last updated with `save` 2 - timestamp entity was invalidated with `invalidate`

#### Parameters

jvm

| | |
|---|---|
| prefix | Cache file prefix to group cached files |
| sd | Entity serializer/deserializer |
| cacheProvider | Disk LRU cache provider. Opens cache with a proper entry config |
| clock | Provides timestamp for cache status marks |

#### See also

| |
|---|
| [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-provider/index.md) |

## Constructors

| | |
|---|---|
| [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>constructor(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: [CacheDelegateSerializerDeserializer](../../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate-serializer-deserializer/index.md)&lt;[D](index.md)&gt;, cacheProvider: [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-provider/index.md), clock: [Clock](../../../../common/com.motorro.rxlcemodel.common/-clock/index.md) = Clock.SYSTEM) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |
| [DiskLruCacheProvider](-disk-lru-cache-provider/index.md) | [jvm]<br>class [DiskLruCacheProvider](-disk-lru-cache-provider/index.md)(directory: [File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html), appVersion: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), maxSize: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))<br>Provides properly configured DiskLruCache with required entry config |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [jvm]<br>open override fun [delete](delete.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Deletes cached value |
| [get](get.md) | [jvm]<br>open override fun [get](get.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;?<br>Returns data if cached |
| [invalidate](invalidate.md) | [jvm]<br>open override fun [invalidate](invalidate.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Clears cached value |
| [invalidateAll](invalidate-all.md) | [jvm]<br>open override fun [invalidateAll](invalidate-all.md)()<br>Invalidates all cached values |
| [normalizeParams](../normalize-params.md) | [jvm]<br>fun &lt;[D](../normalize-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](../normalize-params.md) : [CacheFriend](../../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate](index.md)&lt;[D](../normalize-params.md)&gt;.[normalizeParams](../normalize-params.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [CacheDelegate](../../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](../normalize-params.md), [P](../normalize-params.md)&gt;<br>Creates an adapter delegate that normalizes [CacheFriend.cacheKey](../../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-friend/cache-key.md) to fit into DiskLruCache requirements of 64 a-zA-Z0-9 symbols |
| [save](save.md) | [jvm]<br>open override fun [save](save.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), entity: [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;)<br>Saves data to cache |
