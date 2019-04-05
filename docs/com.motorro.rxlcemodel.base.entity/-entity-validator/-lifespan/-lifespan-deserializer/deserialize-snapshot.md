[com.motorro.rxlcemodel.base.entity](../../../index.md) / [EntityValidator](../../index.md) / [Lifespan](../index.md) / [LifespanDeserializer](index.md) / [deserializeSnapshot](./deserialize-snapshot.md)

# deserializeSnapshot

`fun deserializeSnapshot(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`EntityValidator`](../../index.md)`?`

Overrides [Deserializer.deserializeSnapshot](../../-deserializer/deserialize-snapshot.md)

Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../../is-valid.md) with time

### Parameters

`serialized` - Serialized validator

**Return**
Deserialized validator or null if not recognized

