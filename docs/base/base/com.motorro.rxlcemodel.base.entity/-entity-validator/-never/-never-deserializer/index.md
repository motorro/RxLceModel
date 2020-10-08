//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../../index.md)/[EntityValidator](../../index.md)/[Never](../index.md)/[NeverDeserializer](index.md)



# NeverDeserializer  
 [jvm] 

Deserializes validator from string

object [NeverDeserializer](index.md) : [EntityValidator.Deserializer](../../-deserializer/index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [deserialize](deserialize.md)| [jvm]  <br>Brief description  <br><br><br>Deserializes validator from string if string is recognized<br><br>  <br>Content  <br>open override fun [deserialize](deserialize.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../../index.md)?  <br><br><br>
| [deserializeSnapshot](../../-deserializer/deserialize-snapshot.md)| [jvm]  <br>Brief description  <br><br><br>Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../../is-valid.md) with time<br><br>  <br>Content  <br>open override fun [deserializeSnapshot](../../-deserializer/deserialize-snapshot.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../../index.md)?  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

