[com.motorro.rxlcemodel.base.entity](./index.md)

## Package com.motorro.rxlcemodel.base.entity

Contains tools to maintain data validity

### Types

| Name | Summary |
|---|---|
| [Clock](-clock/index.md) | `interface Clock`<br>Time provider |
| [Entity](-entity/index.md) | `interface Entity<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`EntityValidator`](-entity-validator/index.md)<br>Cache-controlling entity for [com.motorro.rxlcemodel.base.entity.Entity](-entity/index.md) implement this interface for cache control |
| [EntityValidator](-entity-validator/index.md) | `interface EntityValidator`<br>Entity validator |
| [EntityValidatorFactory](-entity-validator-factory/index.md) | `interface EntityValidatorFactory`<br>Cache-control [EntityValidator](-entity-validator/index.md) factory for operations |
| [LifespanValidatorFactory](-lifespan-validator-factory/index.md) | `class LifespanValidatorFactory : `[`EntityValidatorFactory`](-entity-validator-factory/index.md)<br>Creates [Lifespan](-entity-validator/-lifespan/index.md) as a cache-control |
