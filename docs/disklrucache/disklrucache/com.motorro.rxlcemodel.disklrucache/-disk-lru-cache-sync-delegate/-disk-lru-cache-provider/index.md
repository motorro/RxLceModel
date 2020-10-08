//[disklrucache](../../../index.md)/[com.motorro.rxlcemodel.disklrucache](../../index.md)/[DiskLruCacheSyncDelegate](../index.md)/[DiskLruCacheProvider](index.md)



# DiskLruCacheProvider  
 [jvm] 

Provides properly configured DiskLruCache with required entry config

class [DiskLruCacheProvider](index.md)(**directory**: [File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html), **appVersion**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **maxSize**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))   


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| appVersion| <br><br>Current application version<br><br>
| directory| <br><br>a writable directory<br><br>
| maxSize| <br><br>the maximum number of bytes this cache should use to store<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [DiskLruCacheProvider](-disk-lru-cache-provider.md)|  [jvm] <br><br>a writable directory<br><br>fun [DiskLruCacheProvider](-disk-lru-cache-provider.md)(directory: [File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html), appVersion: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), maxSize: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [cache](index.md#com.motorro.rxlcemodel.disklrucache/DiskLruCacheSyncDelegate.DiskLruCacheProvider/cache/#/PointingToDeclaration/)|  [jvm] <br><br>Configured DiskLruCache<br><br>val [cache](index.md#com.motorro.rxlcemodel.disklrucache/DiskLruCacheSyncDelegate.DiskLruCacheProvider/cache/#/PointingToDeclaration/): DiskLruCache   <br>


## Extensions  
  
|  Name|  Summary| 
|---|---|
| [createDelegate](../../create-delegate.md)| [jvm]  <br>Brief description  <br><br><br>Creates DiskLRU caching delegate for SyncDelegateCacheService Delegate uses cache directory provided by [DiskLruCacheProvider](index.md). This directory is designed to be shared between several delegates. Thus we need to provide each delegate an unique DiskLruCacheSyncDelegate.prefix to not to mix data with other delegates. The DiskLruCacheSyncDelegate.sd is a serializer/deserializer that saves/restores entity from file streams.<br><br>  <br>Content  <br>fun <[D](../../create-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](../../create-delegate.md) : CacheFriend> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](index.md).[createDelegate](../../create-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: CacheDelegateSerializerDeserializer<[D](../../create-delegate.md)>): SyncDelegateCacheService.Delegate<[D](../../create-delegate.md), [P](../../create-delegate.md)>  <br>inline fun <[D](../../create-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](../../create-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](index.md).[createDelegate](../../create-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: CacheDelegateSerializerDeserializer<[D](../../create-delegate.md)>, crossinline stringify: [P](../../create-delegate.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](../../create-delegate.md), [P](../../create-delegate.md)>  <br><br><br>
| [createNormalizedDelegate](../../create-normalized-delegate.md)| [jvm]  <br>Brief description  <br><br><br>Creates DiskLRU caching delegate for SyncDelegateCacheService with cache key normalizing and check. Delegate uses cache directory provided by [DiskLruCacheProvider](index.md). This directory is designed to be shared between several delegates. Thus we need to provide each delegate an unique DiskLruCacheSyncDelegate.prefix to not to mix data with other delegates. The DiskLruCacheSyncDelegate.sd is a serializer/deserializer that saves/restores entity from file streams.<br><br>  <br>Content  <br>fun <[D](../../create-normalized-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](../../create-normalized-delegate.md) : CacheFriend> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](index.md).[createNormalizedDelegate](../../create-normalized-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: CacheDelegateSerializerDeserializer<DataWithCacheKey<[D](../../create-normalized-delegate.md)>>): SyncDelegateCacheService.Delegate<[D](../../create-normalized-delegate.md), [P](../../create-normalized-delegate.md)>  <br><br><br>[jvm]  <br>Brief description  <br><br><br>Creates DiskLRU caching delegate for SyncDelegateCacheService with cache key normalizing and check Delegate uses cache directory provided by [DiskLruCacheProvider](index.md). This directory is designed to be shared between several delegates. Thus we need to provide each delegate an unique DiskLruCacheSyncDelegate.prefix to not to mix data with other delegates. The DiskLruCacheSyncDelegate.sd is a serializer/deserializer that saves/restores entity from file streams.<br><br>  <br>Content  <br>inline fun <[D](../../create-normalized-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](../../create-normalized-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](index.md).[createNormalizedDelegate](../../create-normalized-delegate.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), sd: CacheDelegateSerializerDeserializer<DataWithCacheKey<[D](../../create-normalized-delegate.md)>>, crossinline stringify: [P](../../create-normalized-delegate.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](../../create-normalized-delegate.md), [P](../../create-normalized-delegate.md)>  <br><br><br>
| [withObjectStream](../../with-object-stream.md)| [jvm]  <br>Brief description  <br><br><br>Creates DiskLRU caching delegate for SyncDelegateCacheService that accepts [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) data with cache key normalizing and check<br><br>  <br>Content  <br>inline fun <[D](../../with-object-stream.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html), [P](../../with-object-stream.md) : CacheFriend> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](index.md).[withObjectStream](../../with-object-stream.md)(validatorFactory: EntityValidatorFactory, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](../../with-object-stream.md), [P](../../with-object-stream.md)>  <br>inline fun <[D](../../with-object-stream.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html), [P](../../with-object-stream.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](index.md).[withObjectStream](../../with-object-stream.md)(validatorFactory: EntityValidatorFactory, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), crossinline stringify: [P](../../with-object-stream.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](../../with-object-stream.md), [P](../../with-object-stream.md)>  <br><br><br>
| [withObjectStreamNormalized](../../with-object-stream-normalized.md)| [jvm]  <br>Brief description  <br><br><br>Creates DiskLRU caching delegate for SyncDelegateCacheService that accepts [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) data with cache key normalizing and check.<br><br>  <br>Content  <br>inline fun <[D](../../with-object-stream-normalized.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html), [P](../../with-object-stream-normalized.md) : CacheFriend> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](index.md).[withObjectStreamNormalized](../../with-object-stream-normalized.md)(validatorFactory: EntityValidatorFactory, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](../../with-object-stream-normalized.md), [P](../../with-object-stream-normalized.md)>  <br>inline fun <[D](../../with-object-stream-normalized.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html), [P](../../with-object-stream-normalized.md) : CacheFriend> [DiskLruCacheSyncDelegate.DiskLruCacheProvider](index.md).[withObjectStreamNormalized](../../with-object-stream-normalized.md)(validatorFactory: EntityValidatorFactory, prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), crossinline stringify: [P](../../with-object-stream-normalized.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): SyncDelegateCacheService.Delegate<[D](../../with-object-stream-normalized.md), [P](../../with-object-stream-normalized.md)>  <br><br><br>

