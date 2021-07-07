//[base](../index.md)/[com.motorro.rxlcemodel.base](index.md)/[refreshed](refreshed.md)



# refreshed  
[jvm]  
Brief description  


Refreshes data on subscription once



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Original stream<br><br>
| refresh| <br><br>Refresh operation<br><br>
  
  
Content  
fun <[DATA](refreshed.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](-lce-state/index.md)<[DATA](refreshed.md)>>.[refreshed](refreshed.md)(refresh: [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](-lce-state/index.md)<[DATA](refreshed.md)>>  


[jvm]  
Brief description  


Wraps use-case to refresh on each subscription

  
Content  
fun <[DATA](refreshed.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceUseCase](-lce-use-case/index.md)<[DATA](refreshed.md)>.[refreshed](refreshed.md)(): [LceUseCase](-lce-use-case/index.md)<[DATA](refreshed.md)>  



