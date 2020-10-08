//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[LceUseCase](index.md)



# LceUseCase  
 [jvm] 

Base LCE use-case with [state](index.md#com.motorro.rxlcemodel.base/LceUseCase/state/#/PointingToDeclaration/) and [refresh](index.md#com.motorro.rxlcemodel.base/LceUseCase/refresh/#/PointingToDeclaration/)

interface [LceUseCase](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>   


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| DATA| <br><br>Data type of data being loaded<br><br>
  


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [refresh](index.md#com.motorro.rxlcemodel.base/LceUseCase/refresh/#/PointingToDeclaration/)|  [jvm] <br><br>Requests a refresh of data. Data will be updated asynchronously<br><br>abstract val [refresh](index.md#com.motorro.rxlcemodel.base/LceUseCase/refresh/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>
| [state](index.md#com.motorro.rxlcemodel.base/LceUseCase/state/#/PointingToDeclaration/)|  [jvm] <br><br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates<br><br>abstract val [state](index.md#com.motorro.rxlcemodel.base/LceUseCase/state/#/PointingToDeclaration/): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../-lce-state/index.md)<[DATA](index.md)>>   <br>


## Inheritors  
  
|  Name| 
|---|
| [LceModel](../-lce-model/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| [map](../map.md)| [jvm]  <br>Brief description  <br><br><br>Creates a use-case wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md)<br><br>  <br>Content  <br>fun <[DATA_1](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceUseCase](index.md)<[DATA_1](../map.md)>.[map](../map.md)(mapper: ([DATA_1](../map.md)) -> [DATA_2](../map.md)): [LceUseCase](index.md)<[DATA_2](../map.md)>  <br><br><br>
| [withRefresh](../with-refresh.md)| [jvm]  <br>Brief description  <br><br><br>Takes the [LceUseCase.state](index.md#com.motorro.rxlcemodel.base/LceUseCase/state/#/PointingToDeclaration/) of model that is being refreshed each time refreshStream emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../-lce-model/index.md#com.motorro.rxlcemodel.base/LceModel/refresh/#/PointingToDeclaration/) property becomes invisible for the outside world<br><br>  <br>Content  <br>fun <[DATA](../with-refresh.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceUseCase](index.md)<[DATA](../with-refresh.md)>.[withRefresh](../with-refresh.md)(refreshStream: [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<In [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)>): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../-lce-state/index.md)<[DATA](../with-refresh.md)>>  <br><br><br>

