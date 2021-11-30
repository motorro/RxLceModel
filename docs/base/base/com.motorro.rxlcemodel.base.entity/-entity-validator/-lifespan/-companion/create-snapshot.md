//[base](../../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../../index.md)/[EntityValidator](../../index.md)/[Lifespan](../index.md)/[Companion](index.md)/[createSnapshot](create-snapshot.md)

# createSnapshot

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)

fun [createSnapshot](create-snapshot.md)(ttl: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), clock: [Clock](../../../-clock/index.md) = Clock.SYSTEM): [EntityValidator.Lifespan](../index.md)

Creates a snapshot that may be serialized and deserialized back to dynamic [Lifespan](../index.md)

## Parameters

jvm

| | |
|---|---|
| ttl | Time to live |
| clock | Clock implementation |
