//[base](../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[UpdatingServiceSet](index.md)



# UpdatingServiceSet  
 [jvm] 

[ServiceSet](../-service-set/index.md) extension with updating [net](index.md#com.motorro.rxlcemodel.base.service/UpdatingServiceSet/net/#/PointingToDeclaration/)

interface [UpdatingServiceSet](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [U](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> : [ServiceSet](../-service-set/index.md)<[D](index.md), [P](index.md)>    


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
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [cache](index.md#com.motorro.rxlcemodel.base.service/UpdatingServiceSet/cache/#/PointingToDeclaration/)|  [jvm] <br><br>Cache service<br><br>abstract override val [cache](index.md#com.motorro.rxlcemodel.base.service/UpdatingServiceSet/cache/#/PointingToDeclaration/): [CacheService](../-cache-service/index.md)<[D](index.md), [P](index.md)>   <br>
| [net](index.md#com.motorro.rxlcemodel.base.service/UpdatingServiceSet/net/#/PointingToDeclaration/)|  [jvm] <br><br>Updating net service<br><br>abstract override val [net](index.md#com.motorro.rxlcemodel.base.service/UpdatingServiceSet/net/#/PointingToDeclaration/): [UpdatingNetService](../-updating-net-service/index.md)<[D](index.md), [U](index.md), [P](index.md)>   <br>

