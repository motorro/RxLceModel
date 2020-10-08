//[base](../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[SyncDelegateCacheService](index.md)



# SyncDelegateCacheService  
 [jvm] 

Service implementation

class [SyncDelegateCacheService](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> : [CacheService](../-cache-service/index.md)<[D](index.md), [P](index.md)>    


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| delegate| <br><br>Delegate to perform concrete caching operations<br><br>
  


## Types  
  
|  Name|  Summary| 
|---|---|
| [Delegate](-delegate/index.md)| [jvm]  <br>Brief description  <br><br><br>Delegate that synchronously performs caching operations<br><br>  <br>Content  <br>interface [Delegate](-delegate/index.md)<[D](-delegate/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](-delegate/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [delete](delete.md)| [jvm]  <br>Brief description  <br><br><br>Deletes cached value. The [getData](get-data.md) observable for the same key wil emit com.gojuno.koptional.None<br><br>  <br>Content  <br>open override fun [delete](delete.md)(params: [P](index.md)): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getData](get-data.md)| [jvm]  <br>Brief description  <br><br><br>Subscribes to cache data updates<br><br>  <br>Content  <br>open override fun [getData](get-data.md)(params: [P](index.md)): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<Optional<[Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>>>  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [invalidate](invalidate.md)| [jvm]  <br>Brief description  <br><br><br>Clears cached value<br><br>  <br>Content  <br>open override fun [invalidate](invalidate.md)(params: [P](index.md)): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)  <br><br><br>
| [save](save.md)| [jvm]  <br>Brief description  <br><br><br>Saves entity in a cache<br><br>  <br>Content  <br>open override fun [save](save.md)(params: [P](index.md), entity: [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [invalidateAll](index.md#com.motorro.rxlcemodel.base.service/SyncDelegateCacheService/invalidateAll/#/PointingToDeclaration/)|  [jvm] <br><br>Invalidates all cached values<br><br>open override val [invalidateAll](index.md#com.motorro.rxlcemodel.base.service/SyncDelegateCacheService/invalidateAll/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>

