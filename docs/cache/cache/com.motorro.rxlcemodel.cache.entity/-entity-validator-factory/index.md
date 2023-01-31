//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../index.md)/[EntityValidatorFactory](index.md)

# EntityValidatorFactory

[common]\
interface [EntityValidatorFactory](index.md)

Cache-control [EntityValidator](../-entity-validator/index.md) factory for operations

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [common]<br>abstract fun [create](create.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [EntityValidator](../-entity-validator/index.md)<br>Creates entity cache-control |
| [createSnapshot](create-snapshot.md) | [common]<br>abstract fun [createSnapshot](create-snapshot.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [EntityValidator](../-entity-validator/index.md)<br>Creates a snapshot of entity cache-control.The [EntityValidator.isValid](../-entity-validator/is-valid.md) evaluated at the time of creation. |

## Inheritors

| Name |
|---|
| [LifespanValidatorFactory](../-lifespan-validator-factory/index.md) |
