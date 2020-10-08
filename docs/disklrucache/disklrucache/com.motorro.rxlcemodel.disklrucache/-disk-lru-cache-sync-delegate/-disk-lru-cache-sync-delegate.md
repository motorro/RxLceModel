//[disklrucache](../../index.md)/[com.motorro.rxlcemodel.disklrucache](../index.md)/[DiskLruCacheSyncDelegate](index.md)/[DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate.md)



# DiskLruCacheSyncDelegate  
[jvm]  
Brief description  


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| cacheProvider| <br><br>Disk LRU cache provider. Opens cache with a proper entry config<br><br>
| clock| <br><br>Provides timestamp for cache status marks<br><br>
| prefix| <br><br>Cache file prefix to group cached files<br><br>
| sd| <br><br>Entity serializer/deserializer<br><br>
  
  
Content  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun <[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: CacheDelegateSerializerDeserializer<[D](index.md)>, cacheProvider: [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-provider/index.md), clock: Clock)  



