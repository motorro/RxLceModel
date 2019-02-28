[com.motorro.rxlcemodel.base.entity](../index.md) / [EntityValidatorFactory](index.md) / [create](./create.md)

# create

`abstract fun create(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null): `[`EntityValidator`](../-entity-validator/index.md)

Creates entity cache-control

### Parameters

`serialized` - Serialized validator string. Creates a new validator if null is passed

### Exceptions

`IllegalArgumentException` - if serialized can't be deserialized