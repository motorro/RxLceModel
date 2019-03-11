[com.motorro.rxlcemodel.disklrucache](../index.md) / [DiskLruCacheSyncDelegate](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`DiskLruCacheSyncDelegate(prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sd: `[`CacheDelegateSerializerDeserializer`](../../com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)`<`[`D`](index.md#D)`>, cacheProvider: `[`DiskLruCacheProvider`](-disk-lru-cache-provider/index.md)`, clock: `[`Clock`](../../com.motorro.rxlcemodel.base.entity/-clock/index.md)` = Clock.SYSTEM)`

[DiskLruCache](#) caching delegate for [SyncDelegateCacheService](../../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md)
Designed to operate common [cacheProvider](#) instance together with other delegates to be able to clean-up all
cache all-together - say delete user's cache when user logs out
Each entry contains:
0 - saved entity
1 - timestamp entity was last updated with `save`
2 - timestamp entity was invalidated with `invalidate`
Thus, delegate requires [cacheProvider](#) with `valueCount` equals to 3

### Parameters

`prefix` - Cache file prefix to group cached files

`sd` - Entity serializer/deserializer

`cacheProvider` - Disk LRU cache provider. Opens cache with a proper entry config.

`clock` - Provides timestamp for cache status marks