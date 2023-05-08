//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../index.md)/[LifespanValidatorFactory](index.md)

# LifespanValidatorFactory

[common]\
class [LifespanValidatorFactory](index.md)(cacheTtl: Long, clock: [Clock](../../../../common/com.motorro.rxlcemodel.common/-clock/index.md) = Clock.SYSTEM) : [EntityValidatorFactory](../-entity-validator-factory/index.md)

Creates [Lifespan](../-entity-validator/-lifespan/index.md) as a cache-control

#### Parameters

common

| | |
|---|---|
| cacheTtl | Cache TTL |
| clock | System clock |

## Constructors

| | |
|---|---|
| [LifespanValidatorFactory](-lifespan-validator-factory.md) | [common]<br>fun [LifespanValidatorFactory](-lifespan-validator-factory.md)(cacheTtl: Long, clock: [Clock](../../../../common/com.motorro.rxlcemodel.common/-clock/index.md) = Clock.SYSTEM) |

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [common]<br>open override fun [create](create.md)(serialized: String?): [EntityValidator](../-entity-validator/index.md)<br>Creates entity cache-control |
| [createSnapshot](create-snapshot.md) | [common]<br>open override fun [createSnapshot](create-snapshot.md)(serialized: String?): [EntityValidator](../-entity-validator/index.md)<br>Creates a snapshot of entity cache-control.The [EntityValidator.isValid](../-entity-validator/is-valid.md) evaluated at the time of creation. |
