//[base](../index.md)/[com.motorro.rxlcemodel.base](index.md)/[terminateOnError](terminate-on-error.md)



# terminateOnError  
[jvm]  
Brief description  


Terminates [LceModel.state](-lce-model/index.md#com.motorro.rxlcemodel.base/LceModel/state/#/PointingToDeclaration/) stream if predicate returns true



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| DATA| <br><br>Source model data type<br><br>
| predicate| <br><br>A predicate to check error state. If predicate returns true, the stream is terminated with [LceState.Error.error](-lce-state/-error/index.md#com.motorro.rxlcemodel.base/LceState.Error/error/#/PointingToDeclaration/)<br><br>
  
  
Content  
fun <[DATA](terminate-on-error.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](-lce-state/index.md)<[DATA](terminate-on-error.md)>>.[terminateOnError](terminate-on-error.md)(predicate: ([LceState.Error](-lce-state/-error/index.md)<[DATA](terminate-on-error.md)>) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](-lce-state/index.md)<[DATA](terminate-on-error.md)>>  



