//[base](../../../index.md)/[com.motorro.rxlcemodel.base.entity](../index.md)/[EntityValidatorFactory](index.md)

# EntityValidatorFactory

[jvm]\
interface [EntityValidatorFactory](index.md)

Cache-control [EntityValidator](../-entity-validator/index.md) factory for operations

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [jvm]<br>abstract fun [create](create.md)(serialized: String? = null): [EntityValidator](../-entity-validator/index.md)<br>Creates entity cache-control |
| [createSnapshot](create-snapshot.md) | [jvm]<br>abstract fun [createSnapshot](create-snapshot.md)(serialized: String? = null): [EntityValidator](../-entity-validator/index.md)<br>Creates a snapshot of entity cache-control.The [EntityValidator.isValid](../-entity-validator/is-valid.md) evaluated at the time of creation. |

## Inheritors

| Name |
|---|
| [LifespanValidatorFactory](../-lifespan-validator-factory/index.md) |
