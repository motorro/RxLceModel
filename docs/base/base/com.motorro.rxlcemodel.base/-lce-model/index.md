//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[LceModel](index.md)



# LceModel  
 [jvm] 

A model interface to load data and transmit it to subscribers along with loading operation state

interface [LceModel](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> : [LceUseCase](../-lce-use-case/index.md)<[DATA](index.md)>    


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| DATA| <br><br>Data type of data being loaded<br><br>
| PARAMS| <br><br>Params type that identify data being loaded<br><br>
  


## Types  
  
|  Name|  Summary| 
|---|---|
| [Companion](-companion/index.md)| [jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [params](index.md#com.motorro.rxlcemodel.base/LceModel/params/#/PointingToDeclaration/)|  [jvm] <br><br>Params that identify data being loaded<br><br>abstract val [params](index.md#com.motorro.rxlcemodel.base/LceModel/params/#/PointingToDeclaration/): [PARAMS](index.md)   <br>
| [refresh](index.md#com.motorro.rxlcemodel.base/LceModel/refresh/#/PointingToDeclaration/)|  [jvm] <br><br>Requests a refresh of data. Data will be updated asynchronously<br><br>abstract override val [refresh](index.md#com.motorro.rxlcemodel.base/LceModel/refresh/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>
| [state](index.md#com.motorro.rxlcemodel.base/LceModel/state/#/PointingToDeclaration/)|  [jvm] <br><br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates<br><br>abstract override val [state](index.md#com.motorro.rxlcemodel.base/LceModel/state/#/PointingToDeclaration/): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../-lce-state/index.md)<[DATA](index.md)>>   <br>


## Inheritors  
  
|  Name| 
|---|
| [CacheThenNetLceModel](../-cache-then-net-lce-model/index.md)
| [UpdatingLceModel](../-updating-lce-model/index.md)
| [UpdateWrapper](../-update-wrapper/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| [map](../map.md)| [jvm]  <br>Brief description  <br><br><br>Creates a model wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md)<br><br>  <br>Content  <br>fun <[DATA_1](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceModel](index.md)<[DATA_1](../map.md), [PARAMS](../map.md)>.[map](../map.md)(mapper: ([DATA_1](../map.md)) -> [DATA_2](../map.md)): [LceModel](index.md)<[DATA_2](../map.md), [PARAMS](../map.md)>  <br><br><br>
| [withUpdates](../with-updates.md)| [jvm]  <br>Brief description  <br><br><br>Wraps an [LceModel](index.md) to updating delegate creating an [UpdatingLceModel](../-updating-lce-model/index.md)<br><br>  <br>Content  <br>fun <[DATA](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [UPDATE](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceModel](index.md)<[DATA](../with-updates.md), [PARAMS](../with-updates.md)>.[withUpdates](../with-updates.md)(serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)<[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)>, logger: [Logger](../-logger/index.md)?, ioScheduler: [Scheduler](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Scheduler.html)): [UpdatingLceModel](../-updating-lce-model/index.md)<[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)>  <br><br><br>

