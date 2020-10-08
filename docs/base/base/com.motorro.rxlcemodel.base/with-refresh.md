//[base](../index.md)/[com.motorro.rxlcemodel.base](index.md)/[withRefresh](with-refresh.md)



# withRefresh  
[jvm]  
Brief description  


Takes the [LceUseCase.state](-lce-use-case/index.md#com.motorro.rxlcemodel.base/LceUseCase/state/#/PointingToDeclaration/) of model that is being refreshed each time refreshStream emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](-lce-model/index.md#com.motorro.rxlcemodel.base/LceModel/refresh/#/PointingToDeclaration/) property becomes invisible for the outside world



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Original model<br><br>
| DATA| <br><br>Source model data type<br><br>
| refreshStream| <br><br>Whenever this stream emits a value, the model is refreshed<br><br>
  
  
Content  
fun <[DATA](with-refresh.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceUseCase](-lce-use-case/index.md)<[DATA](with-refresh.md)>.[withRefresh](with-refresh.md)(refreshStream: [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<In [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)>): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](-lce-state/index.md)<[DATA](with-refresh.md)>>  



