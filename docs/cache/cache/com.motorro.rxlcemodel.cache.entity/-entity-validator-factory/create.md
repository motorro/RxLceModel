//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../index.md)/[EntityValidatorFactory](index.md)/[create](create.md)

# create

[common]\
abstract fun [create](create.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [EntityValidator](../-entity-validator/index.md)

Creates entity cache-control

#### Parameters

common

| | |
|---|---|
| serialized | Serialized validator string. Creates a new validator if null is passed |

#### Throws

| | |
|---|---|
| [IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | if serialized can't be deserialized |
