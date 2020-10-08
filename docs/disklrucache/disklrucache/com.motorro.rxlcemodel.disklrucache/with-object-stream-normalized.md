//[disklrucache](../index.md)/[com.motorro.rxlcemodel.disklrucache](index.md)/[withObjectStreamNormalized](with-object-stream-normalized.md)



# withObjectStreamNormalized  
[jvm]  
Brief description  


Creates DiskLRU caching delegate for SyncDelegateCacheService that accepts [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) data with cache key normalizing and check.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Cache provider<br><br>
| prefix| <br><br>Caching name prefix to distinguish cache files from other delegates within the same cache directory data identifying parameters with string using stringifyParams<br><br>
| validatorFactory| <br><br>Entity validation factory (defines cache TTL)<br><br>
  
  
Content  
inline fun <[D](with-object-stream-normalized.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html), [P](with-object-stream-normalized.md) : CacheFriend> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withObjectStreamNormalized](with-object-stream-normalized.md)(validatorFactory: EntityValidatorFactory, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](with-object-stream-normalized.md), [P](with-object-stream-normalized.md)>  


[jvm]  
Brief description  


Creates DiskLRU caching delegate for SyncDelegateCacheService that accepts [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) data with cache key normalizing and check.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Cache provider<br><br>
| prefix| <br><br>Caching name prefix to distinguish cache files from other delegates within the same cache directory<br><br>
| stringify| <br><br>As [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute data identifying parameters with string using stringifyParams<br><br>
| validatorFactory| <br><br>Entity validation factory (defines cache TTL)<br><br>
  
  
Content  
inline fun <[D](with-object-stream-normalized.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html), [P](with-object-stream-normalized.md) : CacheFriend> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withObjectStreamNormalized](with-object-stream-normalized.md)(validatorFactory: EntityValidatorFactory, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), crossinline stringify: [P](with-object-stream-normalized.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](with-object-stream-normalized.md), [P](with-object-stream-normalized.md)>  



