//[cache](../../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../../index.md)/[EntityValidator](../index.md)/[Never](index.md)

# Never

[common]\
object [Never](index.md) : [EntityValidator](../index.md)

Entity that is never valid

## Types

| Name | Summary |
|---|---|
| [NeverDeserializer](-never-deserializer/index.md) | [common]<br>object [NeverDeserializer](-never-deserializer/index.md) : [EntityValidator.Deserializer](../-deserializer/index.md)<br>Deserializes validator from string |

## Functions

| Name | Summary |
|---|---|
| [createSnapshot](../create-snapshot.md) | [common]<br>open fun [createSnapshot](../create-snapshot.md)(): [EntityValidator](../index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value |
| [isValid](is-valid.md) | [common]<br>open override fun [isValid](is-valid.md)(): Boolean<br>If true cached entity is valid. |
| [serialize](serialize.md) | [common]<br>open override fun [serialize](serialize.md)(): String<br>A way to serialize entity |
