//[base](../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../index.md)/[EntityValidator](../index.md)/[Always](index.md)



# Always  
 [jvm] 

Entity that is always valid

object [Always](index.md) : [EntityValidator](../index.md)   


## Types  
  
|  Name|  Summary| 
|---|---|
| [AlwaysDeserializer](-always-deserializer/index.md)| [jvm]  <br>Brief description  <br><br><br>Deserializes validator from string<br><br>  <br>Content  <br>object [AlwaysDeserializer](-always-deserializer/index.md) : [EntityValidator.Deserializer](../-deserializer/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [createSnapshot](../create-snapshot.md)| [jvm]  <br>Brief description  <br><br><br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value<br><br>  <br>Content  <br>open override fun [createSnapshot](../create-snapshot.md)(): [EntityValidator](../index.md)  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [isValid](is-valid.md)| [jvm]  <br>Brief description  <br><br><br>If true cached entity is valid.<br><br>  <br>Content  <br>open override fun [isValid](is-valid.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [serialize](serialize.md)| [jvm]  <br>Brief description  <br><br><br>A way to serialize entity<br><br>  <br>Content  <br>open override fun [serialize](serialize.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

