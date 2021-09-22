//[base](../../../index.md)/[com.motorro.rxlcemodel.base.entity](../index.md)/[EntityValidator](index.md)

# EntityValidator

[jvm]\
interface [EntityValidator](index.md)

Entity validator

## Types

| Name | Summary |
|---|---|
| [Always](-always/index.md) | [jvm]<br>object [Always](-always/index.md) : [EntityValidator](index.md)<br>Entity that is always valid |
| [Deserializer](-deserializer/index.md) | [jvm]<br>interface [Deserializer](-deserializer/index.md)<br>Deserializes validator from string |
| [Lifespan](-lifespan/index.md) | [jvm]<br>class [Lifespan](-lifespan/index.md) : [EntityValidator](index.md)<br>Uses creation time and TTL to validate |
| [Never](-never/index.md) | [jvm]<br>object [Never](-never/index.md) : [EntityValidator](index.md)<br>Entity that is never valid |
| [Simple](-simple/index.md) | [jvm]<br>data class [Simple](-simple/index.md)(valid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [EntityValidator](index.md)<br>A simple validator which state is defined on creation May be used to fix the [isValid](-simple/is-valid.md) state of dynamic validator such as [Lifespan](-lifespan/index.md) |

## Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | [jvm]<br>open fun [createSnapshot](create-snapshot.md)(): [EntityValidator](index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](is-valid.md) value |
| [isValid](is-valid.md) | [jvm]<br>abstract fun [isValid](is-valid.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [serialize](serialize.md) | [jvm]<br>abstract fun [serialize](serialize.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |

## Inheritors

| Name |
|---|
| [Entity](../-entity/index.md) |
| [Entity](../-entity/-impl/index.md) |
| [EntityValidator](-simple/index.md) |
| [EntityValidator](-always/index.md) |
| [EntityValidator](-never/index.md) |
| [EntityValidator](-lifespan/index.md) |
