//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../index.md)/[EntityValidator](../index.md)/[Never](index.md)

# Never

[jvm]\
object [Never](index.md) : [EntityValidator](../index.md)

Entity that is never valid

## Types

| Name | Summary |
|---|---|
| [NeverDeserializer](-never-deserializer/index.md) | [jvm]<br>object [NeverDeserializer](-never-deserializer/index.md) : [EntityValidator.Deserializer](../-deserializer/index.md)<br>Deserializes validator from string |

## Functions

| Name | Summary |
|---|---|
| [createSnapshot](../create-snapshot.md) | [jvm]<br>open fun [createSnapshot](../create-snapshot.md)(): [EntityValidator](../index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value |
| [isValid](is-valid.md) | [jvm]<br>open override fun [isValid](is-valid.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |
