//[cache](../../../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../../../index.md)/[EntityValidator](../../index.md)/[Lifespan](../index.md)/[Companion](index.md)/[createSnapshot](create-snapshot.md)

# createSnapshot

[common]\
fun [createSnapshot](create-snapshot.md)(ttl: Long, clock: [Clock](../../../../../../common/com.motorro.rxlcemodel.common/-clock/index.md) = Clock.SYSTEM): [EntityValidator.Lifespan](../index.md)

Creates a snapshot that may be serialized and deserialized back to dynamic [Lifespan](../index.md)

#### Parameters

common

| | |
|---|---|
| ttl | Time to live |
| clock | Clock implementation |
