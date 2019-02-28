[com.motorro.rxlcemodel.base.service](../index.md) / [MemorySyncDelegate](index.md) / [simple](./simple.md)

# simple

`fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> simple(initialCapacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 16): `[`MemorySyncDelegate`](index.md)`<`[`D`](simple.md#D)`, `[`P`](simple.md#P)`>`

Creates a simple in-memory cache without LRU strategy

### Parameters

`initialCapacity` - The initial capacity. The implementation performs internal sizing
to accommodate this many elements.