//[cache](../../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../../index.md)/[EntityValidator](../index.md)/[Simple](index.md)

# Simple

[common]\
data class [Simple](index.md)(valid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [EntityValidator](../index.md)

A simple validator which state is defined on creation May be used to fix the [isValid](is-valid.md) state of dynamic validator such as [Lifespan](../-lifespan/index.md)

#### Parameters

common

| | |
|---|---|
| valid | Validity state |

## Constructors

| | |
|---|---|
| [Simple](-simple.md) | [common]<br>fun [Simple](-simple.md)(valid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |

## Types

| Name | Summary |
|---|---|
| [SimpleDeserializer](-simple-deserializer/index.md) | [common]<br>object [SimpleDeserializer](-simple-deserializer/index.md) : [EntityValidator.Deserializer](../-deserializer/index.md)<br>Deserializes validator from string |

## Functions

| Name | Summary |
|---|---|
| [createSnapshot](../create-snapshot.md) | [common]<br>open fun [createSnapshot](../create-snapshot.md)(): [EntityValidator](../index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value |
| [isValid](is-valid.md) | [common]<br>open override fun [isValid](is-valid.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [serialize](serialize.md) | [common]<br>open override fun [serialize](serialize.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |
