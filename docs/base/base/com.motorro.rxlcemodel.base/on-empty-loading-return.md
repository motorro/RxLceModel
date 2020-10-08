//[base](../index.md)/[com.motorro.rxlcemodel.base](index.md)/[onEmptyLoadingReturn](on-empty-loading-return.md)



# onEmptyLoadingReturn  
[jvm]  
Brief description  


Substitutes [LceState.Loading](-lce-state/-loading/index.md) with empty data with state produced by block



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>LCE stream<br><br>
| block| <br><br>transformation block<br><br>
  
  
Content  
inline fun <[DATA](on-empty-loading-return.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](-lce-state/index.md)<[DATA](on-empty-loading-return.md)>>.[onEmptyLoadingReturn](on-empty-loading-return.md)(crossinline block: ([LceState.Loading](-lce-state/-loading/index.md)<[DATA](on-empty-loading-return.md)>) -> [LceState](-lce-state/index.md)<[DATA](on-empty-loading-return.md)>): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](-lce-state/index.md)<[DATA](on-empty-loading-return.md)>>  



