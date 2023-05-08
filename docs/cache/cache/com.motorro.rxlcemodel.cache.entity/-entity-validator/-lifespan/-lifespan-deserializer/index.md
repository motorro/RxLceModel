//[cache](../../../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../../../index.md)/[EntityValidator](../../index.md)/[Lifespan](../index.md)/[LifespanDeserializer](index.md)

# LifespanDeserializer

[common]\
class [LifespanDeserializer](index.md)(clock: [Clock](../../../../../../common/com.motorro.rxlcemodel.common/-clock/index.md) = Clock.SYSTEM) : [EntityValidator.Deserializer](../../-deserializer/index.md)

Deserializes validator from string

## Constructors

| | |
|---|---|
| [LifespanDeserializer](-lifespan-deserializer.md) | [common]<br>fun [LifespanDeserializer](-lifespan-deserializer.md)(clock: [Clock](../../../../../../common/com.motorro.rxlcemodel.common/-clock/index.md) = Clock.SYSTEM) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [common]<br>open override fun [deserialize](deserialize.md)(serialized: String): [EntityValidator](../../index.md)?<br>Deserializes validator from string if string is recognized |
| [deserializeSnapshot](deserialize-snapshot.md) | [common]<br>open override fun [deserializeSnapshot](deserialize-snapshot.md)(serialized: String): [EntityValidator](../../index.md)?<br>Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../../is-valid.md) with time |
