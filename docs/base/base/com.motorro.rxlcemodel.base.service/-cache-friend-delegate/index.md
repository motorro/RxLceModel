//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[CacheFriendDelegate](index.md)

# CacheFriendDelegate

[jvm]\
class [CacheFriendDelegate](index.md)&lt;[D](index.md) : Any, [P](index.md) : [CacheFriend](../-cache-friend/index.md)&gt;(delegate: [SyncDelegateCacheService.Delegate](../-sync-delegate-cache-service/-delegate/index.md)&lt;[DataWithCacheKey](../-data-with-cache-key/index.md)&lt;[D](index.md)&gt;, [P](index.md)&gt;) : [SyncDelegateCacheService.Delegate](../-sync-delegate-cache-service/-delegate/index.md)&lt;[D](index.md), [P](index.md)&gt; 

Wraps [delegate](../../../../base/com.motorro.rxlcemodel.base.service/-cache-friend-delegate/delegate.md) adding unmodified [CacheFriend.cacheKey](../-cache-friend/cache-key.md) to the mix with data. Validates that key on [get](get.md) and returns null if it is not equals original. Helps to make sure the data returned is not a result of clashed cache key.

## Constructors

| | |
|---|---|
| [CacheFriendDelegate](-cache-friend-delegate.md) | [jvm]<br>fun &lt;[D](index.md) : Any, [P](index.md) : [CacheFriend](../-cache-friend/index.md)&gt; [CacheFriendDelegate](-cache-friend-delegate.md)(delegate: [SyncDelegateCacheService.Delegate](../-sync-delegate-cache-service/-delegate/index.md)&lt;[DataWithCacheKey](../-data-with-cache-key/index.md)&lt;[D](index.md)&gt;, [P](index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [jvm]<br>open override fun [delete](delete.md)(params: [P](index.md))<br>Deletes cached value |
| [get](get.md) | [jvm]<br>open override fun [get](get.md)(params: [P](index.md)): [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;?<br>Returns data if cached |
| [invalidate](invalidate.md) | [jvm]<br>open override fun [invalidate](invalidate.md)(params: [P](index.md))<br>Invalidates cached value |
| [invalidateAll](invalidate-all.md) | [jvm]<br>open override fun [invalidateAll](invalidate-all.md)()<br>Invalidates all cached values |
| [save](save.md) | [jvm]<br>open override fun [save](save.md)(params: [P](index.md), entity: [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;)<br>Saves data to cache |
