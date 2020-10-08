//[base](../../index.md)/[com.motorro.rxlcemodel.base.entity](../index.md)/[EntityValidatorFactory](index.md)



# EntityValidatorFactory  
 [jvm] 

Cache-control [EntityValidator](../-entity-validator/index.md) factory for operations

interface [EntityValidatorFactory](index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [create](create.md)| [jvm]  <br>Brief description  <br><br><br>Creates entity cache-control<br><br>  <br>Content  <br>abstract fun [create](create.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [EntityValidator](../-entity-validator/index.md)  <br><br><br>
| [createSnapshot](create-snapshot.md)| [jvm]  <br>Brief description  <br><br><br>Creates a snapshot of entity cache-control.The [EntityValidator.isValid](../-entity-validator/is-valid.md) evaluated at the time of creation.<br><br>  <br>Content  <br>abstract fun [createSnapshot](create-snapshot.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [EntityValidator](../-entity-validator/index.md)  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| [LifespanValidatorFactory](../-lifespan-validator-factory/index.md)

