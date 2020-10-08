//[base](../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[DataWithCacheKey](index.md)



# DataWithCacheKey  
 [jvm] 

Data combined with full cached key to validate we get exactly what we are looking for For example, DiskLruCache has strict requirements and limited length of a cache key and hashing of keys may be required to fit into requirements - thus there is a possibility of key clash.

data class [DataWithCacheKey](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**data**: [D](index.md), **cacheKey**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)   


## See also  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| [CacheFriendDelegate](../-cache-friend-delegate/index.md)| <br><br><br><br>
  


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| cacheKey| <br><br>Full unmodified cache key<br><br>
| data| <br><br>Original data<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [DataWithCacheKey](-data-with-cache-key.md)|  [jvm] <br><br>Original data<br><br>fun <[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [DataWithCacheKey](-data-with-cache-key.md)(data: [D](index.md), cacheKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [component1](component1.md)| [jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [D](index.md)  <br><br><br>
| [component2](component2.md)| [jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [copy](copy.md)| [jvm]  <br>Content  <br>fun [copy](copy.md)(data: [D](index.md), cacheKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DataWithCacheKey](index.md)<[D](index.md)>  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [cacheKey](index.md#com.motorro.rxlcemodel.base.service/DataWithCacheKey/cacheKey/#/PointingToDeclaration/)|  [jvm] <br><br>Full unmodified cache key<br><br>val [cacheKey](index.md#com.motorro.rxlcemodel.base.service/DataWithCacheKey/cacheKey/#/PointingToDeclaration/): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>
| [data](index.md#com.motorro.rxlcemodel.base.service/DataWithCacheKey/data/#/PointingToDeclaration/)|  [jvm] <br><br>Original data<br><br>val [data](index.md#com.motorro.rxlcemodel.base.service/DataWithCacheKey/data/#/PointingToDeclaration/): [D](index.md)   <br>

