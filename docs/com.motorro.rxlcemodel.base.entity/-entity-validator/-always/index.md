[com.motorro.rxlcemodel.base.entity](../../index.md) / [EntityValidator](../index.md) / [Always](./index.md)

# Always

`object Always : `[`EntityValidator`](../index.md)

Entity that is always valid

### Types

| Name | Summary |
|---|---|
| [AlwaysDeserializer](-always-deserializer/index.md) | `object AlwaysDeserializer : `[`Deserializer`](../-deserializer/index.md)<br>Deserializes validator from string |

### Functions

| Name | Summary |
|---|---|
| [isValid](is-valid.md) | `fun isValid(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [serialize](serialize.md) | `fun serialize(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |

### Inherited Functions

| Name | Summary |
|---|---|
| [createSnapshot](../create-snapshot.md) | `open fun createSnapshot(): `[`EntityValidator`](../index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value |
