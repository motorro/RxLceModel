//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[UpdateWrapper](index.md)



# UpdateWrapper  
 [jvm] 

A base class that wraps [LceModel](../-lce-model/index.md) and mixes in a data update state Extend to build models that patch some properties and load the whole data structure as a result Implement methods to update properties using doUpdate template

abstract class [UpdateWrapper](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**upstream**: [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>, **cacheService**: [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)<[DATA](index.md), [PARAMS](index.md)>, **logger**: [Logger](../-logger/index.md)?, **ioScheduler**: [Scheduler](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Scheduler.html)) : [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>    


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| cacheService| <br><br>Data cache service that updates the same cache as upstream uses<br><br>
| DATA| <br><br>Data Type of data being held<br><br>
| ioScheduler| <br><br>Scheduler to run IO operations<br><br>
| logger| <br><br>Logging function<br><br>
| PARAMS| <br><br>Params type that identify data being loaded<br><br>
| upstream| <br><br>LceModel that performs reading<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [UpdateWrapper](-update-wrapper.md)|  [jvm] <br><br>Data Type of data being held<br><br>fun <[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [UpdateWrapper](-update-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>, cacheService: [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)<[DATA](index.md), [PARAMS](index.md)>, logger: [Logger](../-logger/index.md)?, ioScheduler: [Scheduler](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Scheduler.html))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [params](index.md#com.motorro.rxlcemodel.base/UpdateWrapper/params/#/PointingToDeclaration/)|  [jvm] <br><br>Params that identify data being loaded<br><br>open override val [params](index.md#com.motorro.rxlcemodel.base/UpdateWrapper/params/#/PointingToDeclaration/): [PARAMS](index.md)   <br>
| [refresh](index.md#com.motorro.rxlcemodel.base/UpdateWrapper/refresh/#/PointingToDeclaration/)|  [jvm] <br><br>Requests a refresh of data. Data will be updated asynchronously<br><br>open override val [refresh](index.md#com.motorro.rxlcemodel.base/UpdateWrapper/refresh/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>
| [state](index.md#com.motorro.rxlcemodel.base/UpdateWrapper/state/#/PointingToDeclaration/)|  [jvm] <br><br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates Wrapper mixes the upstream emissions with update operation status.<br><br>open override val [state](index.md#com.motorro.rxlcemodel.base/UpdateWrapper/state/#/PointingToDeclaration/): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../-lce-state/index.md)<[DATA](index.md)>>   <br>


## Inheritors  
  
|  Name| 
|---|
| [StrategyUpdateWrapper](../-strategy-update-wrapper/index.md)
| [UpdatingLceModelWrapper](../-updating-lce-model-wrapper/index.md)

