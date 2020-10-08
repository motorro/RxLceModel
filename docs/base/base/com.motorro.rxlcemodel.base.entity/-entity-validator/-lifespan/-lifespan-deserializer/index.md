//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../../index.md)/[EntityValidator](../../index.md)/[Lifespan](../index.md)/[LifespanDeserializer](index.md)



# LifespanDeserializer  
 [jvm] 

Deserializes validator from string

class [LifespanDeserializer](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()constructor(**clock**: [Clock](../../../-clock/index.md)) : [EntityValidator.Deserializer](../../-deserializer/index.md)   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [LifespanDeserializer](-lifespan-deserializer.md)|  [jvm] @[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  <br>  <br>fun [LifespanDeserializer](-lifespan-deserializer.md)(clock: [Clock](../../../-clock/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| [Companion](-companion/index.md)| [jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [deserialize](deserialize.md)| [jvm]  <br>Brief description  <br><br><br>Deserializes validator from string if string is recognized<br><br>  <br>Content  <br>open override fun [deserialize](deserialize.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../../index.md)?  <br><br><br>
| [deserializeSnapshot](deserialize-snapshot.md)| [jvm]  <br>Brief description  <br><br><br>Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../../is-valid.md) with time<br><br>  <br>Content  <br>open override fun [deserializeSnapshot](deserialize-snapshot.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../../index.md)?  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

