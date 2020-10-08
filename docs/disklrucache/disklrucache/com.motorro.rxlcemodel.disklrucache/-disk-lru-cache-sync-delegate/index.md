//[disklrucache](../../index.md)/[com.motorro.rxlcemodel.disklrucache](../index.md)/[DiskLruCacheSyncDelegate](index.md)



# DiskLruCacheSyncDelegate  
 [jvm] 

DiskLruCache caching delegate for SyncDelegateCacheService Designed to operate common cacheProvider instance together with other delegates to be able to clean-up all cache all-together - say delete user's cache when user logs out Each entry contains: 0 - saved entity 1 - timestamp entity was last updated with save 2 - timestamp entity was invalidated with invalidate

class [DiskLruCacheSyncDelegate](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()constructor(**prefix**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **sd**: CacheDelegateSerializerDeserializer<[D](index.md)>, **cacheProvider**: [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-provider/index.md), **clock**: Clock) : SyncDelegateCacheService.Delegate<[D](index.md), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>    


## See also  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| [DiskLruCacheProvider](-disk-lru-cache-provider/index.md)| <br><br><br><br>
  


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| cacheProvider| <br><br>Disk LRU cache provider. Opens cache with a proper entry config<br><br>
| clock| <br><br>Provides timestamp for cache status marks<br><br>
| prefix| <br><br>Cache file prefix to group cached files<br><br>
| sd| <br><br>Entity serializer/deserializer<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate.md)|  [jvm] <br><br>Cache file prefix to group cached files<br><br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  <br>  <br>fun <[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: CacheDelegateSerializerDeserializer<[D](index.md)>, cacheProvider: [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-provider/index.md), clock: Clock)   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| [Companion](-companion/index.md)| [jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>
| [DiskLruCacheProvider](-disk-lru-cache-provider/index.md)| [jvm]  <br>Brief description  <br><br><br>Provides properly configured DiskLruCache with required entry config<br><br>  <br>Content  <br>class [DiskLruCacheProvider](-disk-lru-cache-provider/index.md)(**directory**: [File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html), **appVersion**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **maxSize**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [delete](delete.md)| [jvm]  <br>Brief description  <br><br><br>Deletes cached value<br><br>  <br>Content  <br>open override fun [delete](delete.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [get](get.md)| [jvm]  <br>Brief description  <br><br><br>Returns data if cached<br><br>  <br>Content  <br>open override fun [get](get.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Entity<[D](index.md)>?  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [invalidate](invalidate.md)| [jvm]  <br>Brief description  <br><br><br>Clears cached value<br><br>  <br>Content  <br>open override fun [invalidate](invalidate.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br><br><br>
| [invalidateAll](invalidate-all.md)| [jvm]  <br>Brief description  <br><br><br>Invalidates all cached values<br><br>  <br>Content  <br>open override fun [invalidateAll](invalidate-all.md)()  <br><br><br>
| [save](save.md)| [jvm]  <br>Brief description  <br><br><br>Saves data to cache<br><br>  <br>Content  <br>open override fun [save](save.md)(params: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), entity: Entity<[D](index.md)>)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Extensions  
  
|  Name|  Summary| 
|---|---|
| [normalizeParams](../normalize-params.md)| [jvm]  <br>Brief description  <br><br><br>Creates an adapter delegate that normalizes CacheFriend.cacheKey to fit into DiskLruCache requirements of 64 a-zA-Z0-9 symbols<br><br>  <br>Content  <br>fun <[D](../normalize-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](../normalize-params.md) : CacheFriend> [DiskLruCacheSyncDelegate](index.md)<[D](../normalize-params.md)>.[normalizeParams](../normalize-params.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](../normalize-params.md), [P](../normalize-params.md)>  <br><br><br>

