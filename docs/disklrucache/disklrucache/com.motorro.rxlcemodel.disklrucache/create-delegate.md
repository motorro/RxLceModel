//[disklrucache](../index.md)/[com.motorro.rxlcemodel.disklrucache](index.md)/[createDelegate](create-delegate.md)



# createDelegate  
[jvm]  
Brief description  


Creates DiskLRU caching delegate for SyncDelegateCacheService Delegate uses cache directory provided by [DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md). This directory is designed to be shared between several delegates. Thus we need to provide each delegate an unique DiskLruCacheSyncDelegate.prefix to not to mix data with other delegates. The DiskLruCacheSyncDelegate.sd is a serializer/deserializer that saves/restores entity from file streams.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Cache provider<br><br>
| prefix| <br><br>Caching name prefix to distinguish cache files from other delegates within the same cache directory<br><br>
| sd| <br><br>Entity Serializer/deserializer<br><br>
  
  
Content  
fun <[D](create-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](create-delegate.md) : CacheFriend> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[createDelegate](create-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: CacheDelegateSerializerDeserializer<[D](create-delegate.md)>): SyncDelegateCacheService.Delegate<[D](create-delegate.md), [P](create-delegate.md)>  


[jvm]  
Brief description  


Creates DiskLRU caching delegate for SyncDelegateCacheService Delegate uses cache directory provided by [DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md). This directory is designed to be shared between several delegates. Thus we need to provide each delegate an unique DiskLruCacheSyncDelegate.prefix to not to mix data with other delegates. The DiskLruCacheSyncDelegate.sd is a serializer/deserializer that saves/restores entity from file streams.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Cache provider<br><br>
| prefix| <br><br>Caching name prefix to distinguish cache files from other delegates within the same cache directory<br><br>
| sd| <br><br>Entity Serializer/deserializer<br><br>
| stringify| <br><br>As [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute data identifying parameters with string using stringifyParams<br><br>
  
  
Content  
inline fun <[D](create-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](create-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[createDelegate](create-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: CacheDelegateSerializerDeserializer<[D](create-delegate.md)>, crossinline stringify: [P](create-delegate.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](create-delegate.md), [P](create-delegate.md)>  



