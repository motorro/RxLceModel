//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../index.md)/[EntityValidator](index.md)

# EntityValidator

[common]\
interface [EntityValidator](index.md)

Entity validator

## Types

| Name | Summary |
|---|---|
| [Always](-always/index.md) | [common]<br>object [Always](-always/index.md) : [EntityValidator](index.md)<br>Entity that is always valid |
| [Deserializer](-deserializer/index.md) | [common]<br>interface [Deserializer](-deserializer/index.md)<br>Deserializes validator from string |
| [Lifespan](-lifespan/index.md) | [common]<br>class [Lifespan](-lifespan/index.md) : [EntityValidator](index.md)<br>Uses creation time and TTL to validate |
| [Never](-never/index.md) | [common]<br>object [Never](-never/index.md) : [EntityValidator](index.md)<br>Entity that is never valid |
| [Simple](-simple/index.md) | [common]<br>data class [Simple](-simple/index.md)(valid: Boolean) : [EntityValidator](index.md)<br>A simple validator which state is defined on creation May be used to fix the [isValid](-simple/is-valid.md) state of dynamic validator such as [Lifespan](-lifespan/index.md) |

## Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | [common]<br>open fun [createSnapshot](create-snapshot.md)(): [EntityValidator](index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](is-valid.md) value |
| [isValid](is-valid.md) | [common]<br>abstract fun [isValid](is-valid.md)(): Boolean<br>If true cached entity is valid. |
| [serialize](serialize.md) | [common]<br>abstract fun [serialize](serialize.md)(): String<br>A way to serialize entity |

## Inheritors

| Name |
|---|
| [Entity](../-entity/index.md) |
| [Impl](../-entity/-impl/index.md) |
| [Simple](-simple/index.md) |
| [Always](-always/index.md) |
| [Never](-never/index.md) |
| [Lifespan](-lifespan/index.md) |
