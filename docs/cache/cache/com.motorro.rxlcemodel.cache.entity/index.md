//[cache](../../index.md)/[com.motorro.rxlcemodel.cache.entity](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [Entity](-entity/index.md) | [common]<br>interface [Entity](-entity/index.md)&lt;out [T](-entity/index.md) : Any&gt; : [EntityValidator](-entity-validator/index.md)<br>Cache-controlling entity for [com.motorro.rxlcemodel.cache.entity.Entity](-entity/index.md) implement this interface for cache control |
| [EntityValidator](-entity-validator/index.md) | [common]<br>interface [EntityValidator](-entity-validator/index.md)<br>Entity validator |
| [EntityValidatorFactory](-entity-validator-factory/index.md) | [common]<br>interface [EntityValidatorFactory](-entity-validator-factory/index.md)<br>Cache-control [EntityValidator](-entity-validator/index.md) factory for operations |
| [LifespanValidatorFactory](-lifespan-validator-factory/index.md) | [common]<br>class [LifespanValidatorFactory](-lifespan-validator-factory/index.md)(cacheTtl: Long, clock: [Clock](../../../common/com.motorro.rxlcemodel.common/-clock/index.md) = Clock.SYSTEM) : [EntityValidatorFactory](-entity-validator-factory/index.md)<br>Creates [Lifespan](-entity-validator/-lifespan/index.md) as a cache-control |

## Functions

| Name | Summary |
|---|---|
| [toEntity](to-entity.md) | [common]<br>fun &lt;[T](to-entity.md) : Any&gt; [T](to-entity.md).[toEntity](to-entity.md)(validator: [EntityValidator](-entity-validator/index.md)): [Entity.Impl](-entity/-impl/index.md)&lt;[T](to-entity.md)&gt;<br>Converts [T](to-entity.md) to [Entity](-entity/index.md) to use with services |
