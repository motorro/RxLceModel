//[base](../../../index.md)/[com.motorro.rxlcemodel.base.entity](../index.md)/[EntityValidatorFactory](index.md)/[create](create.md)

# create

[jvm]\
abstract fun [create](create.md)(serialized: String? = null): [EntityValidator](../-entity-validator/index.md)

Creates entity cache-control

## Parameters

jvm

| | |
|---|---|
| serialized | Serialized validator string. Creates a new validator if null is passed |

## Throws

| | |
|---|---|
| kotlin.IllegalArgumentException | if serialized can't be deserialized |
