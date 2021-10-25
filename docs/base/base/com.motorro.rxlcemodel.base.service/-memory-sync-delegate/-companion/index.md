//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.service](../../index.md)/[MemorySyncDelegate](../index.md)/[Companion](index.md)

# Companion

[jvm]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [custom](custom.md) | [jvm]<br>fun &lt;[D](custom.md) : Any, [P](custom.md) : Any&gt; [custom](custom.md)(map: MutableMap&lt;[P](custom.md), [Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](custom.md)&gt;&gt;): [MemorySyncDelegate](../index.md)&lt;[D](custom.md), [P](custom.md)&gt;<br>Creates an in-memory LRU cache with custom [map](custom.md) as a cache |
| [lru](lru.md) | [jvm]<br>fun &lt;[D](lru.md) : Any, [P](lru.md) : Any&gt; [lru](lru.md)(maxEntries: Int, initialCapacity: Int = 16): [MemorySyncDelegate](../index.md)&lt;[D](lru.md), [P](lru.md)&gt;<br>Creates an in-memory LRU cache with [maxEntries](lru.md) records maximum |
| [simple](simple.md) | [jvm]<br>fun &lt;[D](simple.md) : Any, [P](simple.md) : Any&gt; [simple](simple.md)(initialCapacity: Int = 16): [MemorySyncDelegate](../index.md)&lt;[D](simple.md), [P](simple.md)&gt;<br>Creates a simple in-memory cache without LRU strategy |
