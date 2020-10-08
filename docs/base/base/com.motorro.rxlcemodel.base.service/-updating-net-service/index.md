//[base](../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[UpdatingNetService](index.md)



# UpdatingNetService  
 [jvm] 

[NetService](../-net-service/index.md) extension to update data on server

interface [UpdatingNetService](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [U](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> : [NetService](../-net-service/index.md)<[D](index.md), [P](index.md)>    


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| D| <br><br>Data type<br><br>
| P| <br><br>Params that identify data type<br><br>
| U| <br><br>Update type<br><br>
  


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [get](../-net-service/get.md)| [jvm]  <br>Brief description  <br><br><br>Gets entity from network or throws on error<br><br>  <br>Content  <br>abstract override fun [get](../-net-service/get.md)(params: [P](index.md)): [Single](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Single.html)<[Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>>  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [update](update.md)| [jvm]  <br>Brief description  <br><br><br>Updates data on server returning updated one<br><br>  <br>Content  <br>abstract fun [update](update.md)(params: [P](index.md), update: [U](index.md)): [Single](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Single.html)<[Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>>  <br><br><br>

