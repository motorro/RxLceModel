//[kserializer](../index.md)/[com.motorro.rxlcemodel.kserializer](index.md)



# Package com.motorro.rxlcemodel.kserializer  
 [jvm] 

DiskLruCache serialization delegate using [Kotlin serialization](https://github.com/Kotlin/kotlinx.serialization/)

   


## Types  
  
|  Name|  Summary| 
|---|---|
| [DataWithCacheKeySerializer](-data-with-cache-key-serializer/index.md)| [jvm]  <br>Brief description  <br><br><br>Serializer for DataWithCacheKey<br><br>  <br>Content  <br>data class [DataWithCacheKeySerializer](-data-with-cache-key-serializer/index.md)<[D](-data-with-cache-key-serializer/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**dataSerializer**: KSerializer<[D](-data-with-cache-key-serializer/index.md)>) : KSerializer<DataWithCacheKey<[D](-data-with-cache-key-serializer/index.md)>>   <br><br><br>
| [KotlinCacheDelegateSerializer](-kotlin-cache-delegate-serializer/index.md)| [jvm]  <br>Brief description  <br><br><br>Serializes and deserializes objects with kotlinx.serialization.KSerializer<br><br>  <br>Content  <br>class [KotlinCacheDelegateSerializer](-kotlin-cache-delegate-serializer/index.md)<[D](-kotlin-cache-delegate-serializer/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**validatorFactory**: EntityValidatorFactory, **kSerializer**: KSerializer<[D](-kotlin-cache-delegate-serializer/index.md)>, **binaryFormat**: BinaryFormat) : CacheDelegateSerializerDeserializer<[D](-kotlin-cache-delegate-serializer/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [withKotlin](with-kotlin.md)| [jvm]  <br>Brief description  <br><br><br>Creates DiskLRU caching delegate for SyncDelegateCacheService that accepts Kotlin-serializable data<br><br>  <br>Content  <br>inline fun <[D](with-kotlin.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-kotlin.md) : CacheFriend> DiskLruCacheSyncDelegate.DiskLruCacheProvider.[withKotlin](with-kotlin.md)(validatorFactory: EntityValidatorFactory, serializer: KSerializer<[D](with-kotlin.md)>, binaryFormat: BinaryFormat, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](with-kotlin.md), [P](with-kotlin.md)>  <br>inline fun <[D](with-kotlin.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-kotlin.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> DiskLruCacheSyncDelegate.DiskLruCacheProvider.[withKotlin](with-kotlin.md)(validatorFactory: EntityValidatorFactory, serializer: KSerializer<[D](with-kotlin.md)>, binaryFormat: BinaryFormat, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), crossinline stringify: [P](with-kotlin.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](with-kotlin.md), [P](with-kotlin.md)>  <br><br><br>
| [withKotlinNormalized](with-kotlin-normalized.md)| [jvm]  <br>Brief description  <br><br><br>Creates DiskLRU caching delegate for SyncDelegateCacheService that accepts Kotlin-serializable data with cache key normalizing and check.<br><br>  <br>Content  <br>inline fun <[D](with-kotlin-normalized.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-kotlin-normalized.md) : CacheFriend> DiskLruCacheSyncDelegate.DiskLruCacheProvider.[withKotlinNormalized](with-kotlin-normalized.md)(validatorFactory: EntityValidatorFactory, serializer: KSerializer<[D](with-kotlin-normalized.md)>, binaryFormat: BinaryFormat, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](with-kotlin-normalized.md), [P](with-kotlin-normalized.md)>  <br>inline fun <[D](with-kotlin-normalized.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-kotlin-normalized.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> DiskLruCacheSyncDelegate.DiskLruCacheProvider.[withKotlinNormalized](with-kotlin-normalized.md)(validatorFactory: EntityValidatorFactory, serializer: KSerializer<[D](with-kotlin-normalized.md)>, binaryFormat: BinaryFormat, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), crossinline stringify: [P](with-kotlin-normalized.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](with-kotlin-normalized.md), [P](with-kotlin-normalized.md)>  <br><br><br>

