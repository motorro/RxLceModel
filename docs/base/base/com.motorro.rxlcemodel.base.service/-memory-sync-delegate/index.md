//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[MemorySyncDelegate](index.md)

# MemorySyncDelegate

[jvm]\
abstract class [MemorySyncDelegate](index.md)&lt;[D](index.md) : Any, [P](index.md) : Any&gt; : [SyncDelegateCacheService.Delegate](../-sync-delegate-cache-service/-delegate/index.md)&lt;[D](index.md), [P](index.md)&gt; 

A simple memory cache for [SyncDelegateCacheService](../-sync-delegate-cache-service/index.md).

## Parameters

jvm

| | |
|---|---|
| D | Data type |
| P | Params type |

## Constructors

| | |
|---|---|
| [MemorySyncDelegate](-memory-sync-delegate.md) | [jvm]<br>fun [MemorySyncDelegate](-memory-sync-delegate.md)() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [jvm]<br>open override fun [delete](delete.md)(params: [P](index.md))<br>Deletes cached value |
| [get](get.md) | [jvm]<br>open override fun [get](get.md)(params: [P](index.md)): [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;?<br>Returns data if cached |
| [invalidate](invalidate.md) | [jvm]<br>open override fun [invalidate](invalidate.md)(params: [P](index.md))<br>Invalidates cached value |
| [invalidateAll](invalidate-all.md) | [jvm]<br>open override fun [invalidateAll](invalidate-all.md)()<br>Invalidates all cached values |
| [save](save.md) | [jvm]<br>open override fun [save](save.md)(params: [P](index.md), entity: [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;)<br>Saves data to cache |
