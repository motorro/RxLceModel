[com.motorro.rxlcemodel.base.entity](../../index.md) / [EntityValidator](../index.md) / [Lifespan](index.md) / [createSnapshot](./create-snapshot.md)

# createSnapshot

`fun createSnapshot(): `[`EntityValidator`](../index.md)

Overrides [EntityValidator.createSnapshot](../create-snapshot.md)

Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value

`@JvmOverloads fun createSnapshot(ttl: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, clock: `[`Clock`](../../-clock/index.md)` = Clock.SYSTEM): `[`Lifespan`](index.md)

Creates a snapshot that may be serialized and deserialized back to dynamic [Lifespan](index.md)

### Parameters

`ttl` - Time to live

`clock` - Clock implementation