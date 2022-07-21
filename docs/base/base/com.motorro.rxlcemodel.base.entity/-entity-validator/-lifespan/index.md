//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../index.md)/[EntityValidator](../index.md)/[Lifespan](index.md)

# Lifespan

[jvm]\
class [Lifespan](index.md) : [EntityValidator](../index.md)

Uses creation time and TTL to validate

## Parameters

jvm

| | |
|---|---|
| wasBorn | Time entity was born |
| ttl | Time to live |
| validation | Validation delegate to create a dynamic or snapshot validator |

## Constructors

| | |
|---|---|
| [Lifespan](-lifespan.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [Lifespan](-lifespan.md)(ttl: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), clock: [Clock](../../-clock/index.md) = Clock.SYSTEM) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |
| [LifespanDeserializer](-lifespan-deserializer/index.md) | [jvm]<br>class [LifespanDeserializer](-lifespan-deserializer/index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(clock: [Clock](../../-clock/index.md) = Clock.SYSTEM) : [EntityValidator.Deserializer](../-deserializer/index.md)<br>Deserializes validator from string |

## Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | [jvm]<br>open override fun [createSnapshot](create-snapshot.md)(): [EntityValidator](../index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value |
| [equals](equals.md) | [jvm]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>As soon as we should provide [EntityValidator](../index.md) interface we compare only the main property - validity - not the internal state |
| [hashCode](hash-code.md) | [jvm]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>As soon as we should provide [EntityValidator](../index.md) interface we calculate the main property - validity - not the internal state |
| [isValid](is-valid.md) | [jvm]<br>open override fun [isValid](is-valid.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |
| [toString](to-string.md) | [jvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Display string |
