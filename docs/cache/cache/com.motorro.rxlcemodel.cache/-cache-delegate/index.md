//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache](../index.md)/[CacheDelegate](index.md)

# CacheDelegate

[common]\
interface [CacheDelegate](index.md)&lt;[D](index.md) : Any, [P](index.md) : Any&gt;

Delegate that synchronously performs caching operations

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [common]<br>abstract fun [delete](delete.md)(params: [P](index.md))<br>Deletes cached value |
| [get](get.md) | [common]<br>abstract fun [get](get.md)(params: [P](index.md)): [Entity](../../com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;?<br>Returns data if cached |
| [invalidate](invalidate.md) | [common]<br>abstract fun [invalidate](invalidate.md)(params: [P](index.md))<br>Invalidates cached value |
| [invalidateAll](invalidate-all.md) | [common]<br>abstract fun [invalidateAll](invalidate-all.md)()<br>Invalidates all cached values |
| [save](save.md) | [common]<br>abstract fun [save](save.md)(params: [P](index.md), entity: [Entity](../../com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;)<br>Saves data to cache |

## Inheritors

| Name |
|---|
| [CacheFriendDelegate](../-cache-friend-delegate/index.md) |
| [MemorySyncDelegate](../-memory-sync-delegate/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [makeFriendParams](../make-friend-params.md) | [common]<br>inline fun &lt;[D](../make-friend-params.md) : Any, [P](../make-friend-params.md) : Any&gt; [CacheDelegate](index.md)&lt;[D](../make-friend-params.md), [CacheFriend](../-cache-friend/index.md)&gt;.[makeFriendParams](../make-friend-params.md)(crossinline stringify: [P](../make-friend-params.md).() -&gt; String): [CacheDelegate](index.md)&lt;[D](../make-friend-params.md), [P](../make-friend-params.md)&gt;<br>Creates an adapter delegate that creates [CacheFriend](../-cache-friend/index.md) params using [stringify](../make-friend-params.md) function |
| [stringifyParams](../stringify-params.md) | [common]<br>inline fun &lt;[D](../stringify-params.md) : Any, [P](../stringify-params.md) : Any&gt; [CacheDelegate](index.md)&lt;[D](../stringify-params.md), String&gt;.[stringifyParams](../stringify-params.md)(crossinline stringify: [P](../stringify-params.md).() -&gt; String = { toString() }): [CacheDelegate](index.md)&lt;[D](../stringify-params.md), [P](../stringify-params.md)&gt;<br>Creates an adapter delegate that [stringify](../stringify-params.md) and uses result string as params to receiver |
