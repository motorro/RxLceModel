//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[CacheThenNetLceModel](index.md)



# CacheThenNetLceModel  
 [jvm] 

A [LceModel](../-lce-model/index.md) which uses cache subscription as a 'source of truth'. When [state](index.md#com.motorro.rxlcemodel.base/CacheThenNetLceModel/state/#/PointingToDeclaration/) is subscribed it loads cache data refreshing it if cache is stall or whenever cache returns com.gojuno.koptional.None. The model always returns cached data first - then network if data is stall Cache service *must* notify of its data changes!

class [CacheThenNetLceModel](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**params**: [PARAMS](index.md), **serviceSet**: [ServiceSet](../../com.motorro.rxlcemodel.base.service/-service-set/index.md)<[DATA](index.md), [PARAMS](index.md)>, **startWith**: [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../-lce-state/index.md)<[DATA](index.md)>>) : [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>    


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| DATA| <br><br>Data type of data being held<br><br>
| params| <br><br>Params that identify data being loaded<br><br>
| serviceSet| <br><br>Data service-set<br><br>
| startWith| <br><br>Observable that emits at loading start. Defaults to [LceState.Loading](../-lce-state/-loading/index.md)<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [CacheThenNetLceModel](-cache-then-net-lce-model.md)|  [jvm] <br><br>Data type of data being held<br><br>fun <[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [CacheThenNetLceModel](-cache-then-net-lce-model.md)(params: [PARAMS](index.md), serviceSet: [ServiceSet](../../com.motorro.rxlcemodel.base.service/-service-set/index.md)<[DATA](index.md), [PARAMS](index.md)>, startWith: [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../-lce-state/index.md)<[DATA](index.md)>>)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [params](index.md#com.motorro.rxlcemodel.base/CacheThenNetLceModel/params/#/PointingToDeclaration/)|  [jvm] <br><br>Params that identify data being loaded<br><br>open override val [params](index.md#com.motorro.rxlcemodel.base/CacheThenNetLceModel/params/#/PointingToDeclaration/): [PARAMS](index.md)   <br>
| [refresh](index.md#com.motorro.rxlcemodel.base/CacheThenNetLceModel/refresh/#/PointingToDeclaration/)|  [jvm] <br><br>Requests a refresh of data. Data will be updated asynchronously<br><br>open override val [refresh](index.md#com.motorro.rxlcemodel.base/CacheThenNetLceModel/refresh/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>
| [state](index.md#com.motorro.rxlcemodel.base/CacheThenNetLceModel/state/#/PointingToDeclaration/)|  [jvm] <br><br>Model data. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates<br><br>open override val [state](index.md#com.motorro.rxlcemodel.base/CacheThenNetLceModel/state/#/PointingToDeclaration/): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../-lce-state/index.md)<[DATA](index.md)>>   <br>

