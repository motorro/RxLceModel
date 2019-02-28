[com.motorro.rxlcemodel.base.service](../index.md) / [MemorySyncDelegate](index.md) / [custom](./custom.md)

# custom

`fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> custom(map: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`P`](custom.md#P)`, `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](custom.md#D)`>>): `[`MemorySyncDelegate`](index.md)`<`[`D`](custom.md#D)`, `[`P`](custom.md#P)`>`

Creates an in-memory LRU cache with custom [map](custom.md#com.motorro.rxlcemodel.base.service.MemorySyncDelegate.Companion$custom(kotlin.collections.MutableMap((com.motorro.rxlcemodel.base.service.MemorySyncDelegate.Companion.custom.P, com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.service.MemorySyncDelegate.Companion.custom.D)))))/map) as a cache

### Parameters

`map` - A map to hold cache data