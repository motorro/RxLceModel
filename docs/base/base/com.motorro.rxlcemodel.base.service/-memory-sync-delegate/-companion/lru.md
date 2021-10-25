//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.service](../../index.md)/[MemorySyncDelegate](../index.md)/[Companion](index.md)/[lru](lru.md)

# lru

[jvm]\
fun &lt;[D](lru.md) : Any, [P](lru.md) : Any&gt; [lru](lru.md)(maxEntries: Int, initialCapacity: Int = 16): [MemorySyncDelegate](../index.md)&lt;[D](lru.md), [P](lru.md)&gt;

Creates an in-memory LRU cache with [maxEntries](lru.md) records maximum

## Parameters

jvm

| | |
|---|---|
| maxEntries | Maximum number of entries in map |
| initialCapacity | The initial capacity. The implementation performs internal sizing to accommodate this many elements. |
