[com.motorro.rxlcemodel.base.entity](../index.md) / [EntityValidatorFactory](./index.md)

# EntityValidatorFactory

`interface EntityValidatorFactory`

Cache-control [EntityValidator](../-entity-validator/index.md) factory for operations

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `abstract fun create(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): `[`EntityValidator`](../-entity-validator/index.md)<br>Creates entity cache-control |

### Inheritors

| Name | Summary |
|---|---|
| [LifespanValidatorFactory](../-lifespan-validator-factory/index.md) | `class LifespanValidatorFactory : `[`EntityValidatorFactory`](./index.md)<br>Creates [Lifespan](../-entity-validator/-lifespan/index.md) as a cache-control |
