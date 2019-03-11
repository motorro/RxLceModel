[com.motorro.rxlcemodel.disklrucache](./index.md)

## Package com.motorro.rxlcemodel.disklrucache

[Jake Wharton's DiskLruCache](https://github.com/JakeWharton/DiskLruCache) cache delegate for RxLceModel

### Types

| Name | Summary |
|---|---|
| [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md) | `class DiskLruCacheSyncDelegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Delegate`](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](-disk-lru-cache-sync-delegate/index.md#D)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>[DiskLruCache](#) caching delegate for [SyncDelegateCacheService](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) Designed to operate common [cacheProvider](#) instance together with other delegates to be able to clean-up all cache all-together - say delete user's cache when user logs out Each entry contains: 0 - saved entity 1 - timestamp entity was last updated with `save` 2 - timestamp entity was invalidated with `invalidate` Thus, delegate requires [cacheProvider](#) with `valueCount` equals to 3 |
