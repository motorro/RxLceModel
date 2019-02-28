[com.motorro.rxlcemodel.base.service](../index.md) / [MemorySyncDelegate](index.md) / [lru](./lru.md)

# lru

`fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> lru(maxEntries: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, initialCapacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 16): `[`MemorySyncDelegate`](index.md)`<`[`D`](lru.md#D)`, `[`P`](lru.md#P)`>`

Creates an in-memory LRU cache with [maxEntries](lru.md#com.motorro.rxlcemodel.base.service.MemorySyncDelegate.Companion$lru(kotlin.Int, kotlin.Int)/maxEntries) records maximum

### Parameters

`maxEntries` - Maximum number of entries in map

`initialCapacity` - The initial capacity. The implementation performs internal sizing
to accommodate this many elements.