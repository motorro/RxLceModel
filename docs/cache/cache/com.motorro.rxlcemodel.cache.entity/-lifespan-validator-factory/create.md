//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../index.md)/[LifespanValidatorFactory](index.md)/[create](create.md)

# create

[common]\
open override fun [create](create.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [EntityValidator](../-entity-validator/index.md)

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
