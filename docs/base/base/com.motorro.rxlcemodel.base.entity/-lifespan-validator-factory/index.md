//[base](../../../index.md)/[com.motorro.rxlcemodel.base.entity](../index.md)/[LifespanValidatorFactory](index.md)

# LifespanValidatorFactory

[jvm]\
class [LifespanValidatorFactory](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(cacheTtl: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), clock: [Clock](../-clock/index.md) = Clock.SYSTEM) : [EntityValidatorFactory](../-entity-validator-factory/index.md)

Creates [Lifespan](../-entity-validator/-lifespan/index.md) as a cache-control

## Parameters

jvm

| | |
|---|---|
| cacheTtl | Cache TTL |
| clock | System clock |

## Constructors

| | |
|---|---|
| [LifespanValidatorFactory](-lifespan-validator-factory.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [LifespanValidatorFactory](-lifespan-validator-factory.md)(cacheTtl: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), clock: [Clock](../-clock/index.md) = Clock.SYSTEM) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>open override fun [create](create.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [EntityValidator](../-entity-validator/index.md)<br>Creates entity cache-control |
| [createSnapshot](create-snapshot.md) | [jvm]<br>open override fun [createSnapshot](create-snapshot.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [EntityValidator](../-entity-validator/index.md)<br>Creates a snapshot of entity cache-control.The [EntityValidator.isValid](../-entity-validator/is-valid.md) evaluated at the time of creation. |
