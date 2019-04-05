[com.motorro.rxlcemodel.base.entity](../index.md) / [Entity](./index.md)

# Entity

`interface Entity<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`EntityValidator`](../-entity-validator/index.md)

Cache-controlling entity for [com.motorro.rxlcemodel.base.entity.Entity](./index.md)
implement this interface for cache control

### Types

| Name | Summary |
|---|---|
| [Impl](-impl/index.md) | `data class Impl<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Entity`](./index.md)`<`[`T`](-impl/index.md#T)`>, `[`EntityValidator`](../-entity-validator/index.md)<br>Simple entity implementation |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `abstract val data: `[`T`](index.md#T)<br>Entity data |

### Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | `abstract fun createSnapshot(): `[`Entity`](./index.md)`<`[`T`](index.md#T)`>`<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../-entity-validator/is-valid.md) value |
| [map](map.md) | `abstract fun <R : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> map(mapper: (`[`T`](index.md#T)`) -> `[`R`](map.md#R)`): `[`Entity`](./index.md)`<`[`R`](map.md#R)`>`<br>Transforms Entity [data](data.md) to another entity data with [mapper](map.md#com.motorro.rxlcemodel.base.entity.Entity$map(kotlin.Function1((com.motorro.rxlcemodel.base.entity.Entity.T, com.motorro.rxlcemodel.base.entity.Entity.map.R)))/mapper) Validation remains the same |

### Inherited Functions

| Name | Summary |
|---|---|
| [isValid](../-entity-validator/is-valid.md) | `abstract fun isValid(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [serialize](../-entity-validator/serialize.md) | `abstract fun serialize(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |

### Inheritors

| Name | Summary |
|---|---|
| [Impl](-impl/index.md) | `data class Impl<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Entity`](./index.md)`<`[`T`](-impl/index.md#T)`>, `[`EntityValidator`](../-entity-validator/index.md)<br>Simple entity implementation |
