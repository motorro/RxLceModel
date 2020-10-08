//[base](../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../index.md)/[Entity](../index.md)/[Impl](index.md)



# Impl  
 [jvm] 

Simple entity implementation

data class [Impl](index.md)<[T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**data**: [T](index.md), **validator**: [EntityValidator](../../-entity-validator/index.md)) : [Entity](../index.md)<[T](index.md)> , [EntityValidator](../../-entity-validator/index.md)   


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| data| <br><br>Stored data<br><br>
| validator| <br><br>Entity validator<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [Impl](-impl.md)|  [jvm] <br><br>Stored data<br><br>fun <[T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Impl](-impl.md)(data: [T](index.md), validator: [EntityValidator](../../-entity-validator/index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [component1](component1.md)| [jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [T](index.md)  <br><br><br>
| [copy](copy.md)| [jvm]  <br>Content  <br>fun [copy](copy.md)(data: [T](index.md), validator: [EntityValidator](../../-entity-validator/index.md)): [Entity.Impl](index.md)<[T](index.md)>  <br><br><br>
| [createSnapshot](create-snapshot.md)| [jvm]  <br>Brief description  <br><br><br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../../-entity-validator/is-valid.md) value<br><br>  <br>Content  <br>open override fun [createSnapshot](create-snapshot.md)(): [Entity](../index.md)<[T](index.md)>  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [isValid](../../-entity-validator/is-valid.md)| [jvm]  <br>Content  <br>open override fun [isValid](../../-entity-validator/is-valid.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [map](map.md)| [jvm]  <br>Brief description  <br><br><br>Transforms Entity [data](index.md#com.motorro.rxlcemodel.base.entity/Entity.Impl/data/#/PointingToDeclaration/) to another entity data with mapper Validation remains the same<br><br>  <br>Content  <br>open override fun <[R](map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [map](map.md)(mapper: ([T](index.md)) -> [R](map.md)): [Entity](../index.md)<[R](map.md)>  <br><br><br>
| [serialize](../../-entity-validator/serialize.md)| [jvm]  <br>Content  <br>open override fun [serialize](../../-entity-validator/serialize.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [data](index.md#com.motorro.rxlcemodel.base.entity/Entity.Impl/data/#/PointingToDeclaration/)|  [jvm] <br><br>Stored data<br><br>open override val [data](index.md#com.motorro.rxlcemodel.base.entity/Entity.Impl/data/#/PointingToDeclaration/): [T](index.md)   <br>

