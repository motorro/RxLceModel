//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../index.md)/[EntityValidator](../index.md)/[Deserializer](index.md)/[deserializeSnapshot](deserialize-snapshot.md)

# deserializeSnapshot

[jvm]\
open fun [deserializeSnapshot](deserialize-snapshot.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../index.md)?

Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../is-valid.md) with time

#### Return

Deserialized validator or null if not recognized

## Parameters

jvm

| | |
|---|---|
| serialized | Serialized validator |
