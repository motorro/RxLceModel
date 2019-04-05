[com.motorro.rxlcemodel.base.entity](../../index.md) / [Entity](../index.md) / [Impl](./index.md)

# Impl

`data class Impl<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Entity`](../index.md)`<`[`T`](index.md#T)`>, `[`EntityValidator`](../../-entity-validator/index.md)

Simple entity implementation

### Parameters

`data` - Stored data

`validator` - Entity validator

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Impl(data: `[`T`](index.md#T)`, validator: `[`EntityValidator`](../../-entity-validator/index.md)`)`<br>Simple entity implementation |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `val data: `[`T`](index.md#T)<br>Stored data |

### Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | `fun createSnapshot(): `[`Entity`](../index.md)`<`[`T`](index.md#T)`>`<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../../-entity-validator/is-valid.md) value |
| [map](map.md) | `fun <R : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> map(mapper: (`[`T`](index.md#T)`) -> `[`R`](map.md#R)`): `[`Entity`](../index.md)`<`[`R`](map.md#R)`>`<br>Transforms Entity [data](data.md) to another entity data with [mapper](map.md#com.motorro.rxlcemodel.base.entity.Entity.Impl$map(kotlin.Function1((com.motorro.rxlcemodel.base.entity.Entity.Impl.T, com.motorro.rxlcemodel.base.entity.Entity.Impl.map.R)))/mapper) Validation remains the same |
