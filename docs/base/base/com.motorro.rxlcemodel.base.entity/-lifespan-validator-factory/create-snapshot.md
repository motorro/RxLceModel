//[base](../../../index.md)/[com.motorro.rxlcemodel.base.entity](../index.md)/[LifespanValidatorFactory](index.md)/[createSnapshot](create-snapshot.md)

# createSnapshot

[jvm]\
open override fun [createSnapshot](create-snapshot.md)(serialized: String?): [EntityValidator](../-entity-validator/index.md)

Creates a snapshot of entity cache-control.The [EntityValidator.isValid](../-entity-validator/is-valid.md) evaluated at the time of creation.

## Parameters

jvm

| | |
|---|---|
| serialized | Serialized validator string. Creates a valid snapshot if null is passed |

## Throws

| | |
|---|---|
| kotlin.IllegalArgumentException | if serialized can't be deserialized |
