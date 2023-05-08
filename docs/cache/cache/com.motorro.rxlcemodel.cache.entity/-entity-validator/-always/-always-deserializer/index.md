//[cache](../../../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../../../index.md)/[EntityValidator](../../index.md)/[Always](../index.md)/[AlwaysDeserializer](index.md)

# AlwaysDeserializer

[common]\
object [AlwaysDeserializer](index.md) : [EntityValidator.Deserializer](../../-deserializer/index.md)

Deserializes validator from string

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [common]<br>open override fun [deserialize](deserialize.md)(serialized: String): [EntityValidator](../../index.md)?<br>Deserializes validator from string if string is recognized |
| [deserializeSnapshot](../../-deserializer/deserialize-snapshot.md) | [common]<br>open fun [deserializeSnapshot](../../-deserializer/deserialize-snapshot.md)(serialized: String): [EntityValidator](../../index.md)?<br>Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../../is-valid.md) with time |
