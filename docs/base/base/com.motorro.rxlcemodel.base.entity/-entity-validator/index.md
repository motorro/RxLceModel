//[base](../../index.md)/[com.motorro.rxlcemodel.base.entity](../index.md)/[EntityValidator](index.md)



# EntityValidator  
 [jvm] 

Entity validator

interface [EntityValidator](index.md)   


## Types  
  
|  Name|  Summary| 
|---|---|
| [Always](-always/index.md)| [jvm]  <br>Brief description  <br><br><br>Entity that is always valid<br><br>  <br>Content  <br>object [Always](-always/index.md) : [EntityValidator](index.md)  <br><br><br>
| [Deserializer](-deserializer/index.md)| [jvm]  <br>Brief description  <br><br><br>Deserializes validator from string<br><br>  <br>Content  <br>interface [Deserializer](-deserializer/index.md)  <br><br><br>
| [Lifespan](-lifespan/index.md)| [jvm]  <br>Brief description  <br><br><br>Uses creation time and TTL to validate<br><br>  <br>Content  <br>class [Lifespan](-lifespan/index.md) : [EntityValidator](index.md)  <br><br><br>
| [Never](-never/index.md)| [jvm]  <br>Brief description  <br><br><br>Entity that is never valid<br><br>  <br>Content  <br>object [Never](-never/index.md) : [EntityValidator](index.md)  <br><br><br>
| [Simple](-simple/index.md)| [jvm]  <br>Brief description  <br><br><br>A simple validator which state is defined on creation May be used to fix the [isValid](-simple/is-valid.md) state of dynamic validator such as [Lifespan](-lifespan/index.md)<br><br>  <br>Content  <br>data class [Simple](-simple/index.md)(**valid**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [EntityValidator](index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [createSnapshot](create-snapshot.md)| [jvm]  <br>Brief description  <br><br><br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](is-valid.md) value<br><br>  <br>Content  <br>open fun [createSnapshot](create-snapshot.md)(): [EntityValidator](index.md)  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [isValid](is-valid.md)| [jvm]  <br>Brief description  <br><br><br>If true cached entity is valid.<br><br>  <br>Content  <br>abstract fun [isValid](is-valid.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [serialize](serialize.md)| [jvm]  <br>Brief description  <br><br><br>A way to serialize entity<br><br>  <br>Content  <br>abstract fun [serialize](serialize.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| [Entity](../-entity/index.md)
| [Entity](../-entity/-impl/index.md)
| [EntityValidator](-simple/index.md)
| [EntityValidator](-always/index.md)
| [EntityValidator](-never/index.md)
| [EntityValidator](-lifespan/index.md)

