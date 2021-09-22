//[base](../../../index.md)/[com.motorro.rxlcemodel.base.entity](../index.md)/[LifespanValidatorFactory](index.md)/[create](create.md)

# create

[jvm]\
open override fun [create](create.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [EntityValidator](../-entity-validator/index.md)

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
