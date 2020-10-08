//[base](../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[CacheManager](index.md)



# CacheManager  
 [jvm] 

Closes and deletes cache May be used to close or delete all scoped cache at once e.g. for current user

interface [CacheManager](index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [close](index.md#com.motorro.rxlcemodel.base.service/CacheManager/close/#/PointingToDeclaration/)|  [jvm] <br><br>Closes cache<br><br>abstract val [close](index.md#com.motorro.rxlcemodel.base.service/CacheManager/close/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>
| [delete](index.md#com.motorro.rxlcemodel.base.service/CacheManager/delete/#/PointingToDeclaration/)|  [jvm] <br><br>Closes cache and deletes data<br><br>abstract val [delete](index.md#com.motorro.rxlcemodel.base.service/CacheManager/delete/#/PointingToDeclaration/): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)   <br>

