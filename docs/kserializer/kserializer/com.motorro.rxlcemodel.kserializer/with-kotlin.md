//[kserializer](../index.md)/[com.motorro.rxlcemodel.kserializer](index.md)/[withKotlin](with-kotlin.md)



# withKotlin  
[jvm]  
Brief description  


Creates DiskLRU caching delegate for SyncDelegateCacheService that accepts Kotlin-serializable data



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Cache provider<br><br>
| binaryFormat| <br><br>Binary format serializer<br><br>
| prefix| <br><br>Caching name prefix to distinguish cache files from other delegates within the same cache directory<br><br>
| serializer| <br><br>Data serializer/deserializer<br><br>
| validatorFactory| <br><br>Entity validation factory (defines cache TTL)<br><br>
  
  
Content  
inline fun <[D](with-kotlin.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-kotlin.md) : CacheFriend> DiskLruCacheSyncDelegate.DiskLruCacheProvider.[withKotlin](with-kotlin.md)(validatorFactory: EntityValidatorFactory, serializer: KSerializer<[D](with-kotlin.md)>, binaryFormat: BinaryFormat, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](with-kotlin.md), [P](with-kotlin.md)>  


[jvm]  
Brief description  


Creates DiskLRU caching delegate for SyncDelegateCacheService that accepts Kotlin-serializable data



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Cache provider<br><br>
| binaryFormat| <br><br>Binary format serializer<br><br>
| prefix| <br><br>Caching name prefix to distinguish cache files from other delegates within the same cache directory<br><br>
| serializer| <br><br>Data serializer/deserializer<br><br>
| stringify| <br><br>As DiskLruCacheSyncDelegate uses string params to create cache keys we should substitute data identifying parameters with string using stringifyParams<br><br>
| validatorFactory| <br><br>Entity validation factory (defines cache TTL)<br><br>
  
  
Content  
inline fun <[D](with-kotlin.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-kotlin.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> DiskLruCacheSyncDelegate.DiskLruCacheProvider.[withKotlin](with-kotlin.md)(validatorFactory: EntityValidatorFactory, serializer: KSerializer<[D](with-kotlin.md)>, binaryFormat: BinaryFormat, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), crossinline stringify: [P](with-kotlin.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](with-kotlin.md), [P](with-kotlin.md)>  



