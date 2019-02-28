[com.motorro.rxlcemodel.base.entity](../../index.md) / [EntityValidator](../index.md) / [Deserializer](./index.md)

# Deserializer

`interface Deserializer`

Deserializes validator from string

### Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | `abstract fun deserialize(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`EntityValidator`](../index.md)`?`<br>Deserializes validator from string if string is recognized |

### Inheritors

| Name | Summary |
|---|---|
| [AlwaysDeserializer](../-always/-always-deserializer/index.md) | `object AlwaysDeserializer : `[`Deserializer`](./index.md)<br>Deserializes validator from string |
| [LifespanDeserializer](../-lifespan/-lifespan-deserializer/index.md) | `class LifespanDeserializer : `[`Deserializer`](./index.md)<br>Deserializes validator from string |
| [NeverDeserializer](../-never/-never-deserializer/index.md) | `object NeverDeserializer : `[`Deserializer`](./index.md)<br>Deserializes validator from string |
