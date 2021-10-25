//[base](../../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../../index.md)/[EntityValidator](../../index.md)/[Lifespan](../index.md)/[Companion](index.md)/[createSnapshot](create-snapshot.md)

# createSnapshot

[jvm]\

@JvmOverloads

fun [createSnapshot](create-snapshot.md)(ttl: Long, clock: [Clock](../../../-clock/index.md) = Clock.SYSTEM): [EntityValidator.Lifespan](../index.md)

Creates a snapshot that may be serialized and deserialized back to dynamic [Lifespan](../index.md)

## Parameters

jvm

| | |
|---|---|
| ttl | Time to live |
| clock | Clock implementation |
