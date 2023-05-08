//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../index.md)/[EntityValidatorFactory](index.md)/[createSnapshot](create-snapshot.md)

# createSnapshot

[common]\
abstract fun [createSnapshot](create-snapshot.md)(serialized: String? = null): [EntityValidator](../-entity-validator/index.md)

Creates a snapshot of entity cache-control.The [EntityValidator.isValid](../-entity-validator/is-valid.md) evaluated at the time of creation.

#### Parameters

common

| | |
|---|---|
| serialized | Serialized validator string. Creates a valid snapshot if null is passed |

#### Throws

| | |
|---|---|
| IllegalArgumentException | if serialized can't be deserialized |
