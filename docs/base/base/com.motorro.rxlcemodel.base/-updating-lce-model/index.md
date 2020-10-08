//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[UpdatingLceModel](index.md)



# UpdatingLceModel  
 [jvm] 

[LceModel](../-lce-model/index.md) extension that can [update](update.md) data

interface [UpdatingLceModel](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [UPDATE](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> : [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>    


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| DATA| <br><br>Data type of data being held<br><br>
| PARAMS| <br><br>Params type that identify data being loaded<br><br>
| UPDATE| <br><br>Update type<br><br>
  


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [update](update.md)| [jvm]  <br>Brief description  <br><br><br>Updates data on server and refreshes local data<br><br>  <br>Content  <br>abstract fun [update](update.md)(update: [UPDATE](index.md)): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [params](index.md#com.motorro.rxlcemodel.base/UpdatingLceModel/params/#/PointingToDeclaration/)|  [jvm] <br><br>Params that identify data being loaded<br><br>abstract override val [params](index.md#com.motorro.rxlcemodel.base/UpdatingLceModel/params/#/PointingToDeclaration/): [PARAMS](index.md)   <br>
| [refresh](index.md#com.motorro.rxlcemodel.base/UpdatingLceModel/refresh/#/PointingToDeclaration/)|  [jvm] <br><br>Requests a refresh of data. Data will be updated asynchronously<br><br>abstract override val [refresh](index.md#com.motorro.rxlcemodel.base/UpdatingLceModel/refresh/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>
| [state](index.md#com.motorro.rxlcemodel.base/UpdatingLceModel/state/#/PointingToDeclaration/)|  [jvm] <br><br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates<br><br>abstract override val [state](index.md#com.motorro.rxlcemodel.base/UpdatingLceModel/state/#/PointingToDeclaration/): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../-lce-state/index.md)<[DATA](index.md)>>   <br>


## Inheritors  
  
|  Name| 
|---|
| [UpdatingLceModelWrapper](../-updating-lce-model-wrapper/index.md)

