[com.motorro.rxlcemodel.base.entity](../../index.md) / [EntityValidator](../index.md) / [Simple](./index.md)

# Simple

`data class Simple : `[`EntityValidator`](../index.md)

A simple validator which state is defined on creation
May be used to fix the [isValid](is-valid.md) state of dynamic validator such as [Lifespan](../-lifespan/index.md)

### Parameters

`valid` - Validity state

### Types

| Name | Summary |
|---|---|
| [SimpleDeserializer](-simple-deserializer/index.md) | `object SimpleDeserializer : `[`Deserializer`](../-deserializer/index.md)<br>Deserializes validator from string |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Simple(valid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)`<br>A simple validator which state is defined on creation May be used to fix the [isValid](is-valid.md) state of dynamic validator such as [Lifespan](../-lifespan/index.md) |

### Functions

| Name | Summary |
|---|---|
| [isValid](is-valid.md) | `fun isValid(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [serialize](serialize.md) | `fun serialize(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |

### Inherited Functions

| Name | Summary |
|---|---|
| [createSnapshot](../create-snapshot.md) | `open fun createSnapshot(): `[`EntityValidator`](../index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value |
