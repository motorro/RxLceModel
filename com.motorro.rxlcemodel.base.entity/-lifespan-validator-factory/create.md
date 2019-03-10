[com.motorro.rxlcemodel.base.entity](../index.md) / [LifespanValidatorFactory](index.md) / [create](./create.md)

# create

`fun create(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`EntityValidator`](../-entity-validator/index.md)

Overrides [EntityValidatorFactory.create](../-entity-validator-factory/create.md)

Creates entity cache-control

### Parameters

`serialized` - Serialized validator string. Creates a new validator if null is passed

### Exceptions

`IllegalArgumentException` - if serialized can't be deserialized