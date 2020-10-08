//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../../index.md)/[LceModel](../index.md)/[Companion](index.md)



# Companion  
 [jvm] object [Companion](index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [cacheThenNet](cache-then-net.md)| [jvm]  <br>Brief description  <br><br><br>Creates a model that returns cached data first, then refreshes if stall<br><br>  <br>Content  <br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  <br>  <br>fun <[DATA](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), serviceSet: [ServiceSet](../../../com.motorro.rxlcemodel.base.service/-service-set/index.md)<[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)>, startWith: [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../../-lce-state/index.md)<[DATA](cache-then-net.md)>>): [LceModel](../index.md)<[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)>  <br><br><br>[jvm]  <br>Brief description  <br><br><br>Creates a model that returns cached data first, than refreshes if stall<br><br>  <br>Content  <br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  <br>  <br>fun <[DATA](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), net: [NetService](../../../com.motorro.rxlcemodel.base.service/-net-service/index.md)<[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)>, cache: [CacheService](../../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)<[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)>, startWith: [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](../../-lce-state/index.md)<[DATA](cache-then-net.md)>>): [LceModel](../index.md)<[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)>  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

