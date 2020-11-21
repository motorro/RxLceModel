//[base](../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[CacheService](index.md)



# CacheService  
 [jvm] 

Interface to cache an [com.motorro.rxlcemodel.base.entity.Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) locally Cache should notify subscribers that data has been updated through [getData](get-data.md) channel

interface [CacheService](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>   


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| D| <br><br>Data type<br><br>
| P| <br><br>Params that identify data type<br><br>
  


## Types  
  
|  Name|  Summary| 
|---|---|
| [Companion](-companion/index.md)| [jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [delete](delete.md)| [jvm]  <br>Brief description  <br><br><br>Deletes cached value. The [getData](get-data.md) observable for the same key wil emit com.gojuno.koptional.None<br><br>  <br>Content  <br>abstract fun [delete](delete.md)(params: [P](index.md)): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getData](get-data.md)| [jvm]  <br>Brief description  <br><br><br>Subscribes to cache data updates<br><br>  <br>Content  <br>abstract fun [getData](get-data.md)(params: [P](index.md)): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<Optional<[Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>>>  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [invalidate](invalidate.md)| [jvm]  <br>Brief description  <br><br><br>Invalidates cached value<br><br>  <br>Content  <br>abstract fun [invalidate](invalidate.md)(params: [P](index.md)): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)  <br><br><br>
| [refetch](refetch.md)| [jvm]  <br>Brief description  <br><br><br>Makes cache service to refetch cached data updating subscribers with params<br><br>  <br>Content  <br>abstract fun [refetch](refetch.md)(params: [P](index.md)): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)  <br><br><br>
| [save](save.md)| [jvm]  <br>Brief description  <br><br><br>Saves entity in a cache<br><br>  <br>Content  <br>abstract fun [save](save.md)(params: [P](index.md), entity: [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [invalidateAll](index.md#com.motorro.rxlcemodel.base.service/CacheService/invalidateAll/#/PointingToDeclaration/)|  [jvm] <br><br>Invalidates all cached values<br><br>abstract val [invalidateAll](index.md#com.motorro.rxlcemodel.base.service/CacheService/invalidateAll/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>
| [refetchAll](index.md#com.motorro.rxlcemodel.base.service/CacheService/refetchAll/#/PointingToDeclaration/)|  [jvm] <br><br>Makes cache service to refetch cached data for all active subscribers<br><br>abstract val [refetchAll](index.md#com.motorro.rxlcemodel.base.service/CacheService/refetchAll/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>


## Inheritors  
  
|  Name| 
|---|
| [SyncDelegateCacheService](../-sync-delegate-cache-service/index.md)

