//[cache](../../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../../index.md)/[EntityValidator](../index.md)/[Lifespan](index.md)

# Lifespan

[common]\
class [Lifespan](index.md) : [EntityValidator](../index.md)

Uses creation time and TTL to validate

#### Parameters

common

| | |
|---|---|
| wasBorn | Time entity was born |
| ttl | Time to live |
| validation | Validation delegate to create a dynamic or snapshot validator |

## Constructors

| | |
|---|---|
| [Lifespan](-lifespan.md) | [common]<br>fun [Lifespan](-lifespan.md)(ttl: Long, clock: [Clock](../../../../../common/com.motorro.rxlcemodel.common/-clock/index.md) = Clock.SYSTEM) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [LifespanDeserializer](-lifespan-deserializer/index.md) | [common]<br>class [LifespanDeserializer](-lifespan-deserializer/index.md)(clock: [Clock](../../../../../common/com.motorro.rxlcemodel.common/-clock/index.md) = Clock.SYSTEM) : [EntityValidator.Deserializer](../-deserializer/index.md)<br>Deserializes validator from string |

## Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | [common]<br>open override fun [createSnapshot](create-snapshot.md)(): [EntityValidator](../index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: Any?): Boolean<br>As soon as we should provide [EntityValidator](../index.md) interface we compare only the commonMain property - validity - not the internal state |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): Int<br>As soon as we should provide [EntityValidator](../index.md) interface we calculate the commonMain property - validity - not the internal state |
| [isValid](is-valid.md) | [common]<br>open override fun [isValid](is-valid.md)(): Boolean<br>If true cached entity is valid. |
| [serialize](serialize.md) | [common]<br>open override fun [serialize](serialize.md)(): String<br>A way to serialize entity |
| [toString](to-string.md) | [common]<br>open override fun [toString](to-string.md)(): String<br>Display string |
