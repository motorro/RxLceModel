//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.service](../../index.md)/[MemorySyncDelegate](../index.md)/[Companion](index.md)/[lru](lru.md)

# lru

[jvm]\
fun &lt;[D](lru.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](lru.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [lru](lru.md)(maxEntries: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), initialCapacity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 16): [MemorySyncDelegate](../index.md)&lt;[D](lru.md), [P](lru.md)&gt;

Creates an in-memory LRU cache with [maxEntries](lru.md) records maximum

## Parameters

jvm

| | |
|---|---|
| maxEntries | Maximum number of entries in map |
| initialCapacity | The initial capacity. The implementation performs internal sizing to accommodate this many elements. |
