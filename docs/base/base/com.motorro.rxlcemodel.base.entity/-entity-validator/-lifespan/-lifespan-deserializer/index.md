//[base](../../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../../index.md)/[EntityValidator](../../index.md)/[Lifespan](../index.md)/[LifespanDeserializer](index.md)

# LifespanDeserializer

[jvm]\
class [LifespanDeserializer](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(clock: [Clock](../../../-clock/index.md)) : [EntityValidator.Deserializer](../../-deserializer/index.md)

Deserializes validator from string

## Constructors

| | |
|---|---|
| [LifespanDeserializer](-lifespan-deserializer.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [LifespanDeserializer](-lifespan-deserializer.md)(clock: [Clock](../../../-clock/index.md) = Clock.SYSTEM) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [jvm]<br>open override fun [deserialize](deserialize.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../../index.md)?<br>Deserializes validator from string if string is recognized |
| [deserializeSnapshot](deserialize-snapshot.md) | [jvm]<br>open override fun [deserializeSnapshot](deserialize-snapshot.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../../index.md)?<br>Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../../is-valid.md) with time |
