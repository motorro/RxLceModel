//[cache](../../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../../index.md)/[EntityValidator](../index.md)/[Deserializer](index.md)

# Deserializer

[common]\
interface [Deserializer](index.md)

Deserializes validator from string

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [common]<br>abstract fun [deserialize](deserialize.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../index.md)?<br>Deserializes validator from string if string is recognized |
| [deserializeSnapshot](deserialize-snapshot.md) | [common]<br>open fun [deserializeSnapshot](deserialize-snapshot.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../index.md)?<br>Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../is-valid.md) with time |

## Inheritors

| Name |
|---|
| [SimpleDeserializer](../-simple/-simple-deserializer/index.md) |
| [AlwaysDeserializer](../-always/-always-deserializer/index.md) |
| [NeverDeserializer](../-never/-never-deserializer/index.md) |
| [LifespanDeserializer](../-lifespan/-lifespan-deserializer/index.md) |
