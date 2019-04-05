[com.motorro.rxlcemodel.base.entity](../index.md) / [EntityValidator](./index.md)

# EntityValidator

`interface EntityValidator`

Entity validator

### Types

| Name | Summary |
|---|---|
| [Always](-always/index.md) | `object Always : `[`EntityValidator`](./index.md)<br>Entity that is always valid |
| [Deserializer](-deserializer/index.md) | `interface Deserializer`<br>Deserializes validator from string |
| [Lifespan](-lifespan/index.md) | `class Lifespan : `[`EntityValidator`](./index.md)<br>Uses creation time and TTL to validate |
| [Never](-never/index.md) | `object Never : `[`EntityValidator`](./index.md)<br>Entity that is never valid |
| [Simple](-simple/index.md) | `data class Simple : `[`EntityValidator`](./index.md)<br>A simple validator which state is defined on creation May be used to fix the [isValid](-simple/is-valid.md) state of dynamic validator such as [Lifespan](-lifespan/index.md) |

### Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | `open fun createSnapshot(): `[`EntityValidator`](./index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](is-valid.md) value |
| [isValid](is-valid.md) | `abstract fun isValid(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [serialize](serialize.md) | `abstract fun serialize(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |

### Inheritors

| Name | Summary |
|---|---|
| [Always](-always/index.md) | `object Always : `[`EntityValidator`](./index.md)<br>Entity that is always valid |
| [Entity](../-entity/index.md) | `interface Entity<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`EntityValidator`](./index.md)<br>Cache-controlling entity for [com.motorro.rxlcemodel.base.entity.Entity](../-entity/index.md) implement this interface for cache control |
| [Impl](../-entity/-impl/index.md) | `data class Impl<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Entity`](../-entity/index.md)`<`[`T`](../-entity/-impl/index.md#T)`>, `[`EntityValidator`](./index.md)<br>Simple entity implementation |
| [Lifespan](-lifespan/index.md) | `class Lifespan : `[`EntityValidator`](./index.md)<br>Uses creation time and TTL to validate |
| [Never](-never/index.md) | `object Never : `[`EntityValidator`](./index.md)<br>Entity that is never valid |
| [Simple](-simple/index.md) | `data class Simple : `[`EntityValidator`](./index.md)<br>A simple validator which state is defined on creation May be used to fix the [isValid](-simple/is-valid.md) state of dynamic validator such as [Lifespan](-lifespan/index.md) |
