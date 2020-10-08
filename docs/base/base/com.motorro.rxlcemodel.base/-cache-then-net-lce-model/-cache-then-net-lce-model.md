//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[CacheThenNetLceModel](index.md)/[CacheThenNetLceModel](-cache-then-net-lce-model.md)



# CacheThenNetLceModel  
[jvm]  
Brief description  


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| DATA| <br><br>Data type of data being held<br><br>
| params| <br><br>Params that identify data being loaded<br><br>
| serviceSet| <br><br>Data service-set<br><br>
| startWith| <br><br>Observable that emits at loading start. Defaults to [LceState.Loading](../-lce-state/-loading/index.md)<br><br>
  
  
Content  
fun <[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [CacheThenNetLceModel](-cache-then-net-lce-model.md)(params: [PARAMS](index.md), serviceSet: [ServiceSet](../../com.motorro.rxlcemodel.base.service/-service-set/index.md)<[DATA](index.md), [PARAMS](index.md)>, startWith: [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../-lce-state/index.md)<[DATA](index.md)>>)  



