[com.motorro.rxlcemodel.base.entity](../index.md) / [EntityValidatorFactory](index.md) / [createSnapshot](./create-snapshot.md)

# createSnapshot

`abstract fun createSnapshot(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): `[`EntityValidator`](../-entity-validator/index.md)

Creates a snapshot of entity cache-control.The [EntityValidator.isValid](../-entity-validator/is-valid.md) evaluated at the time of creation.

### Parameters

`serialized` - Serialized validator string. Creates a valid snapshot if null is passed

### Exceptions

`IllegalArgumentException` - if serialized can't be deserialized