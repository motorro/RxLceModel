[com.motorro.rxlcemodel.base.entity](../../../index.md) / [EntityValidator](../../index.md) / [Never](../index.md) / [NeverDeserializer](./index.md)

# NeverDeserializer

`object NeverDeserializer : `[`Deserializer`](../../-deserializer/index.md)

Deserializes validator from string

### Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | `fun deserialize(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`EntityValidator`](../../index.md)`?`<br>Deserializes validator from string if string is recognized |

### Inherited Functions

| Name | Summary |
|---|---|
| [deserializeSnapshot](../../-deserializer/deserialize-snapshot.md) | `open fun deserializeSnapshot(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`EntityValidator`](../../index.md)`?`<br>Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../../is-valid.md) with time |
