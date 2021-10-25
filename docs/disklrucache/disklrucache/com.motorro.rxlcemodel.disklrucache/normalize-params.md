//[disklrucache](../../index.md)/[com.motorro.rxlcemodel.disklrucache](index.md)/[normalizeParams](normalize-params.md)

# normalizeParams

[jvm]\
fun &lt;[D](normalize-params.md) : Any, [P](normalize-params.md) : [CacheFriend](../../../base/base/com.motorro.rxlcemodel.base.service/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md)&lt;[D](normalize-params.md)&gt;.[normalizeParams](normalize-params.md)(prefix: String): [SyncDelegateCacheService.Delegate](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)&lt;[D](normalize-params.md), [P](normalize-params.md)&gt;

Creates an adapter delegate that normalizes [CacheFriend.cacheKey](../../../base/base/com.motorro.rxlcemodel.base.service/-cache-friend/cache-key.md) to fit into DiskLruCache requirements of 64 a-zA-Z0-9 symbols

#### Receiver

DiskLruCacheSyncDelegate
