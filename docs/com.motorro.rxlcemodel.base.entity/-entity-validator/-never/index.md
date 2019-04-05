[com.motorro.rxlcemodel.base.entity](../../index.md) / [EntityValidator](../index.md) / [Never](./index.md)

# Never

`object Never : `[`EntityValidator`](../index.md)

Entity that is never valid

### Types

| Name | Summary |
|---|---|
| [NeverDeserializer](-never-deserializer/index.md) | `object NeverDeserializer : `[`Deserializer`](../-deserializer/index.md)<br>Deserializes validator from string |

### Functions

| Name | Summary |
|---|---|
| [isValid](is-valid.md) | `fun isValid(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [serialize](serialize.md) | `fun serialize(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |

### Inherited Functions

| Name | Summary |
|---|---|
| [createSnapshot](../create-snapshot.md) | `open fun createSnapshot(): `[`EntityValidator`](../index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value |
