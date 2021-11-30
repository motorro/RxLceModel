//[base](../../../index.md)/[com.motorro.rxlcemodel.base.entity](../index.md)/[EntityValidatorFactory](index.md)/[create](create.md)

# create

[jvm]\
abstract fun [create](create.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [EntityValidator](../-entity-validator/index.md)

Creates entity cache-control

## Parameters

jvm

| | |
|---|---|
| serialized | Serialized validator string. Creates a new validator if null is passed |

## Throws

| | |
|---|---|
| [kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | if serialized can't be deserialized |
