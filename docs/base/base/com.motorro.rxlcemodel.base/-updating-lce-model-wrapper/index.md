//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[UpdatingLceModelWrapper](index.md)



# UpdatingLceModelWrapper  
 [jvm] 

Wraps an [LceModel](../-lce-model/index.md) to enable simple data updates with the [UPDATE](index.md) structure (say a PUT operation) rather than individual property updates (PATCH operation). Implement [UpdateWrapper](../-update-wrapper/index.md) to achieve PATCH workflow

class [UpdatingLceModelWrapper](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [UPDATE](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**upstream**: [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>, **serviceSet**: [UpdatingServiceSet](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)<[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)>, **logger**: [Logger](../-logger/index.md)?, **ioScheduler**: [Scheduler](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Scheduler.html)) : [UpdateWrapper](../-update-wrapper/index.md)<[DATA](index.md), [PARAMS](index.md)> , [UpdatingLceModel](../-updating-lce-model/index.md)<[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)>    


## See also  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| [UpdateWrapper](../-update-wrapper/index.md)| <br><br><br><br>
  


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| DATA| <br><br>Data Type of data being held<br><br>
| ioScheduler| <br><br>Scheduler to run IO operations<br><br>
| logger| <br><br>Logging function<br><br>
| PARAMS| <br><br>Params type that identify data being loaded<br><br>
| serviceSet| <br><br>Data service-set. Note that cache service should update the same cache as upstream uses for things to work correctly<br><br>
| UPDATE| <br><br>Update type<br><br>
| upstream| <br><br>LceModel that performs reading<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [UpdatingLceModelWrapper](-updating-lce-model-wrapper.md)|  [jvm] <br><br>Data Type of data being held<br><br>fun <[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [UPDATE](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [UpdatingLceModelWrapper](-updating-lce-model-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>, serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)<[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)>, logger: [Logger](../-logger/index.md)?, ioScheduler: [Scheduler](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Scheduler.html))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| modelLog| [jvm]  <br>Brief description  <br><br><br>Logs message to logger with model id<br><br>  <br>Content  <br>override fun [Logger](../-logger/index.md).modelLog(level: [LogLevel](../-log-level/index.md), message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [update](update.md)| [jvm]  <br>Brief description  <br><br><br>Updates data on server and refreshes local data<br><br>  <br>Content  <br>open override fun [update](update.md)(update: [UPDATE](index.md)): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)  <br><br><br>
| withLogger| [jvm]  <br>Brief description  <br><br><br>Runs if logger present<br><br>  <br>Content  <br>inline override fun withLogger(block: [Logger](../-logger/index.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [cacheService](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/cacheService/#/PointingToDeclaration/)|  [jvm] <br><br>Data cache service that updates the same cache as upstream uses<br><br>override val [cacheService](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/cacheService/#/PointingToDeclaration/): [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)<[DATA](index.md), [PARAMS](index.md)>   <br>
| [ioScheduler](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/ioScheduler/#/PointingToDeclaration/)|  [jvm] <br><br>Scheduler to run IO operations<br><br>override val [ioScheduler](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/ioScheduler/#/PointingToDeclaration/): [Scheduler](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Scheduler.html)   <br>
| [logger](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/logger/#/PointingToDeclaration/)|  [jvm] <br><br>Logging function<br><br>override val [logger](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/logger/#/PointingToDeclaration/): [Logger](../-logger/index.md)?   <br>
| [networkOperationState](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/networkOperationState/#/PointingToDeclaration/)|  [jvm] <br><br>Network operation state broadcast<br><br>override val [networkOperationState](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/networkOperationState/#/PointingToDeclaration/): [PublishSubject](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/subjects/PublishSubject.html)<UpdateOperationState>   <br>
| [params](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/params/#/PointingToDeclaration/)|  [jvm] open override val [params](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/params/#/PointingToDeclaration/): [PARAMS](index.md)   <br>
| [refresh](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/refresh/#/PointingToDeclaration/)|  [jvm] open override val [refresh](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/refresh/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>
| [state](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/state/#/PointingToDeclaration/)|  [jvm] open override val [state](index.md#com.motorro.rxlcemodel.base/UpdatingLceModelWrapper/state/#/PointingToDeclaration/): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../-lce-state/index.md)<[DATA](index.md)>>   <br>

