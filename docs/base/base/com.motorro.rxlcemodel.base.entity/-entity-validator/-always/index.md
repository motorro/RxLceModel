//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../index.md)/[EntityValidator](../index.md)/[Always](index.md)

# Always

[jvm]\
object [Always](index.md) : [EntityValidator](../index.md)

Entity that is always valid

## Types

| Name | Summary |
|---|---|
| [AlwaysDeserializer](-always-deserializer/index.md) | [jvm]<br>object [AlwaysDeserializer](-always-deserializer/index.md) : [EntityValidator.Deserializer](../-deserializer/index.md)<br>Deserializes validator from string |

## Functions

| Name | Summary |
|---|---|
| [createSnapshot](../create-snapshot.md) | [jvm]<br>open fun [createSnapshot](../create-snapshot.md)(): [EntityValidator](../index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value |
| [isValid](is-valid.md) | [jvm]<br>open override fun [isValid](is-valid.md)(): Boolean<br>If true cached entity is valid. |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(): String<br>A way to serialize entity |
