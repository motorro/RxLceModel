//[disklrucache](../../index.md)/[com.motorro.rxlcemodel.disklrucache](index.md)/[normalizeParams](normalize-params.md)

# normalizeParams

[jvm]\
fun &lt;[D](normalize-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](normalize-params.md) : [CacheFriend](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md)&lt;[D](normalize-params.md)&gt;.[normalizeParams](normalize-params.md)(prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [CacheDelegate](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](normalize-params.md), [P](normalize-params.md)&gt;

Creates an adapter delegate that normalizes [CacheFriend.cacheKey](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-friend/cache-key.md) to fit into DiskLruCache requirements of 64 a-zA-Z0-9 symbols

#### Receiver

DiskLruCacheSyncDelegate
