//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[StrategyUpdateWrapper](index.md)



# StrategyUpdateWrapper  
 [jvm] 

Wraps [LceModel](../-lce-model/index.md) and mixes in a data update state Use to build models that patch some properties and load the whole data structure as a result Implement methods to update properties using doUpdate template

class [StrategyUpdateWrapper](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**upstream**: [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>, **cacheService**: [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)<[DATA](index.md), [PARAMS](index.md)>, **logger**: [Logger](../-logger/index.md)?, **ioScheduler**: [Scheduler](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Scheduler.html)) : [UpdateWrapper](../-update-wrapper/index.md)<[DATA](index.md), [PARAMS](index.md)>    


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| cacheService| <br><br>Data cache service that updates the same cache as [upstream](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/upstream/#/PointingToDeclaration/) uses<br><br>
| DATA| <br><br>Data Type of data being held<br><br>
| ioScheduler| <br><br>Scheduler to run IO operations<br><br>
| logger| <br><br>Logging function<br><br>
| PARAMS| <br><br>Params type that identify data being loaded<br><br>
| upstream| <br><br>LceModel that performs reading<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [StrategyUpdateWrapper](-strategy-update-wrapper.md)|  [jvm] <br><br>Data Type of data being held<br><br>fun <[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [StrategyUpdateWrapper](-strategy-update-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>, cacheService: [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)<[DATA](index.md), [PARAMS](index.md)>, logger: [Logger](../-logger/index.md)?, ioScheduler: [Scheduler](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Scheduler.html))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| modelLog| [jvm]  <br>Brief description  <br><br><br>Logs message to logger with model id<br><br>  <br>Content  <br>override fun [Logger](../-logger/index.md).modelLog(level: [LogLevel](../-log-level/index.md), message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [update](update.md)| [jvm]  <br>Brief description  <br><br><br>Creates a cache-update operation that gets data from dataSource and saves to cache. The completable updates [networkOperationState](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/networkOperationState/#/PointingToDeclaration/) to mix state to original [upstream](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/upstream/#/PointingToDeclaration/)<br><br>  <br>Content  <br>fun [update](update.md)(dataSource: ([PARAMS](index.md)) -> [Single](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Single.html)<Out [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[DATA](index.md)>>): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)  <br><br><br>
| withLogger| [jvm]  <br>Brief description  <br><br><br>Runs if logger present<br><br>  <br>Content  <br>inline override fun withLogger(block: [Logger](../-logger/index.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [cacheService](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/cacheService/#/PointingToDeclaration/)|  [jvm] <br><br>Data cache service that updates the same cache as [upstream](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/upstream/#/PointingToDeclaration/) uses<br><br>override val [cacheService](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/cacheService/#/PointingToDeclaration/): [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)<[DATA](index.md), [PARAMS](index.md)>   <br>
| [ioScheduler](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/ioScheduler/#/PointingToDeclaration/)|  [jvm] <br><br>Scheduler to run IO operations<br><br>override val [ioScheduler](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/ioScheduler/#/PointingToDeclaration/): [Scheduler](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Scheduler.html)   <br>
| [logger](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/logger/#/PointingToDeclaration/)|  [jvm] <br><br>Logging function<br><br>override val [logger](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/logger/#/PointingToDeclaration/): [Logger](../-logger/index.md)?   <br>
| [networkOperationState](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/networkOperationState/#/PointingToDeclaration/)|  [jvm] <br><br>Network operation state broadcast<br><br>override val [networkOperationState](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/networkOperationState/#/PointingToDeclaration/): [PublishSubject](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/subjects/PublishSubject.html)<UpdateOperationState>   <br>
| [params](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/params/#/PointingToDeclaration/)|  [jvm] <br><br>Params that identify data being loaded<br><br>open override val [params](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/params/#/PointingToDeclaration/): [PARAMS](index.md)   <br>
| [refresh](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/refresh/#/PointingToDeclaration/)|  [jvm] <br><br>Requests a refresh of data. Data will be updated asynchronously<br><br>open override val [refresh](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/refresh/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>
| [state](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/state/#/PointingToDeclaration/)|  [jvm] <br><br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates Wrapper mixes the [upstream](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/upstream/#/PointingToDeclaration/) emissions with update operation status.<br><br>open override val [state](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/state/#/PointingToDeclaration/): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../-lce-state/index.md)<[DATA](index.md)>>   <br>
| [upstream](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/upstream/#/PointingToDeclaration/)|  [jvm] <br><br>LceModel that performs reading<br><br>override val [upstream](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/upstream/#/PointingToDeclaration/): [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>   <br>

