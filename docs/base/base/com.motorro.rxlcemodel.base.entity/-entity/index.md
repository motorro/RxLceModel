//[base](../../index.md)/[com.motorro.rxlcemodel.base.entity](../index.md)/[Entity](index.md)



# Entity  
 [jvm] 

Cache-controlling entity for [com.motorro.rxlcemodel.base.entity.Entity](index.md) implement this interface for cache control

interface [Entity](index.md)<[T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> : [EntityValidator](../-entity-validator/index.md)   


## Types  
  
|  Name|  Summary| 
|---|---|
| [Impl](-impl/index.md)| [jvm]  <br>Brief description  <br><br><br>Simple entity implementation<br><br>  <br>Content  <br>data class [Impl](-impl/index.md)<[T](-impl/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**data**: [T](-impl/index.md), **validator**: [EntityValidator](../-entity-validator/index.md)) : [Entity](index.md)<[T](-impl/index.md)> , [EntityValidator](../-entity-validator/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [createSnapshot](create-snapshot.md)| [jvm]  <br>Brief description  <br><br><br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../-entity-validator/is-valid.md) value<br><br>  <br>Content  <br>abstract override fun [createSnapshot](create-snapshot.md)(): [Entity](index.md)<[T](index.md)>  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [isValid](../-entity-validator/is-valid.md)| [jvm]  <br>Brief description  <br><br><br>If true cached entity is valid.<br><br>  <br>Content  <br>abstract override fun [isValid](../-entity-validator/is-valid.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [map](map.md)| [jvm]  <br>Brief description  <br><br><br>Transforms Entity [data](index.md#com.motorro.rxlcemodel.base.entity/Entity/data/#/PointingToDeclaration/) to another entity data with mapper Validation remains the same<br><br>  <br>Content  <br>abstract fun <[R](map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [map](map.md)(mapper: ([T](index.md)) -> [R](map.md)): [Entity](index.md)<[R](map.md)>  <br><br><br>
| [serialize](../-entity-validator/serialize.md)| [jvm]  <br>Brief description  <br><br><br>A way to serialize entity<br><br>  <br>Content  <br>abstract override fun [serialize](../-entity-validator/serialize.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [data](index.md#com.motorro.rxlcemodel.base.entity/Entity/data/#/PointingToDeclaration/)|  [jvm] <br><br>Entity data<br><br>abstract val [data](index.md#com.motorro.rxlcemodel.base.entity/Entity/data/#/PointingToDeclaration/): [T](index.md)   <br>


## Inheritors  
  
|  Name| 
|---|
| [Entity](-impl/index.md)

