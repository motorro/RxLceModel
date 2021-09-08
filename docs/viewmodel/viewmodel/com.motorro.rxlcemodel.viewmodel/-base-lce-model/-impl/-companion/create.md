//[viewmodel](../../../../index.md)/[com.motorro.rxlcemodel.viewmodel](../../../index.md)/[BaseLceModel](../../index.md)/[Impl](../index.md)/[Companion](index.md)/[create](create.md)



# create  
[androidJvm]  
Brief description  


Creates LCE model



## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| refresh| <br><br>Refresh operation<br><br>
| stateObservable| <br><br>Observable of state changes<br><br>
  
  
Content  
fun <[DATA](create.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [create](create.md)(stateObservable: [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<LceState<[DATA](create.md)>>, refresh: [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)): [BaseLceModel](../../index.md)<[DATA](create.md)>  



