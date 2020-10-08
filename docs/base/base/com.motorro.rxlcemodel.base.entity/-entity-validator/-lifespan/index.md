//[base](../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../index.md)/[EntityValidator](../index.md)/[Lifespan](index.md)



# Lifespan  
 [jvm] 

Uses creation time and TTL to validate

class [Lifespan](index.md) : [EntityValidator](../index.md)   


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| ttl| <br><br>Time to live<br><br>
| validation| <br><br>Validation delegate to create a dynamic or snapshot validator<br><br>
| wasBorn| <br><br>Time entity was born<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [Lifespan](-lifespan.md)|  [jvm] <br><br><br><br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  <br>  <br>fun [Lifespan](-lifespan.md)(ttl: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), clock: [Clock](../../-clock/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| [Companion](-companion/index.md)| [jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>
| [LifespanDeserializer](-lifespan-deserializer/index.md)| [jvm]  <br>Brief description  <br><br><br>Deserializes validator from string<br><br>  <br>Content  <br>class [LifespanDeserializer](-lifespan-deserializer/index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()constructor(**clock**: [Clock](../../-clock/index.md)) : [EntityValidator.Deserializer](../-deserializer/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [createSnapshot](create-snapshot.md)| [jvm]  <br>Brief description  <br><br><br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value<br><br>  <br>Content  <br>open override fun [createSnapshot](create-snapshot.md)(): [EntityValidator](../index.md)  <br><br><br>
| [equals](equals.md)| [jvm]  <br>Brief description  <br><br><br>As soon as we should provide [EntityValidator](../index.md) interface we compare only the main property - validity - not the internal state<br><br>  <br>Content  <br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](hash-code.md)| [jvm]  <br>Brief description  <br><br><br>As soon as we should provide [EntityValidator](../index.md) interface we calculate the main property - validity - not the internal state<br><br>  <br>Content  <br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [isValid](is-valid.md)| [jvm]  <br>Brief description  <br><br><br>If true cached entity is valid.<br><br>  <br>Content  <br>open override fun [isValid](is-valid.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [serialize](serialize.md)| [jvm]  <br>Brief description  <br><br><br>A way to serialize entity<br><br>  <br>Content  <br>open override fun [serialize](serialize.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [toString](to-string.md)| [jvm]  <br>Brief description  <br><br><br>Display string<br><br>  <br>Content  <br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

