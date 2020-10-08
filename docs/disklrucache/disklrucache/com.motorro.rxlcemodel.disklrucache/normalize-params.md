//[disklrucache](../index.md)/[com.motorro.rxlcemodel.disklrucache](index.md)/[normalizeParams](normalize-params.md)



# normalizeParams  
[jvm]  
Brief description  


Creates an adapter delegate that normalizes CacheFriend.cacheKey to fit into DiskLruCache requirements of 64 a-zA-Z0-9 symbols

  
Content  
fun <[D](normalize-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](normalize-params.md) : CacheFriend> [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md)<[D](normalize-params.md)>.[normalizeParams](normalize-params.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](normalize-params.md), [P](normalize-params.md)>  



