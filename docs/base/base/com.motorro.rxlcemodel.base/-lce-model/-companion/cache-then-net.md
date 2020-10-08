//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../../index.md)/[LceModel](../index.md)/[Companion](index.md)/[cacheThenNet](cache-then-net.md)



# cacheThenNet  
[jvm]  
Brief description  


Creates a model that returns cached data first, then refreshes if stall



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| DATA| <br><br>Data type of data being held<br><br>
| params| <br><br>Params that identify data being loaded<br><br>
| serviceSet| <br><br>Service-set to load data<br><br>
| startWith| <br><br>Observable that emits at loading start. Defaults to [LceState.Loading](../../-lce-state/-loading/index.md)<br><br>
  
  
Content  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun <[DATA](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), serviceSet: [ServiceSet](../../../com.motorro.rxlcemodel.base.service/-service-set/index.md)<[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)>, startWith: [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../../-lce-state/index.md)<[DATA](cache-then-net.md)>>): [LceModel](../index.md)<[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)>  


[jvm]  
Brief description  


Creates a model that returns cached data first, than refreshes if stall



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| cache| <br><br>Cache-service<br><br>
| DATA| <br><br>Data type of data being held<br><br>
| net| <br><br>Net-service<br><br>
| params| <br><br>Params that identify data being loaded<br><br>
| startWith| <br><br>Observable that emits at loading start. Defaults to [LceState.Loading](../../-lce-state/-loading/index.md)<br><br>
  
  
Content  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun <[DATA](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), net: [NetService](../../../com.motorro.rxlcemodel.base.service/-net-service/index.md)<[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)>, cache: [CacheService](../../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)<[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)>, startWith: [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../../-lce-state/index.md)<[DATA](cache-then-net.md)>>): [LceModel](../index.md)<[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)>  



