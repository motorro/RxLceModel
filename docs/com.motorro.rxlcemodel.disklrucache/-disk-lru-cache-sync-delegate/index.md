[com.motorro.rxlcemodel.disklrucache](../index.md) / [DiskLruCacheSyncDelegate](./index.md)

# DiskLruCacheSyncDelegate

`class DiskLruCacheSyncDelegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Delegate`](../../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](index.md#D)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`

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

### Types

| Name | Summary |
|---|---|
| [DiskLruCacheProvider](-disk-lru-cache-provider/index.md) | `class DiskLruCacheProvider`<br>Provides properly configured [DiskLruCache](#) with required entry config |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DiskLruCacheSyncDelegate(prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sd: `[`CacheDelegateSerializerDeserializer`](../../com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)`<`[`D`](index.md#D)`>, cacheProvider: `[`DiskLruCacheProvider`](-disk-lru-cache-provider/index.md)`, clock: `[`Clock`](../../com.motorro.rxlcemodel.base.entity/-clock/index.md)` = Clock.SYSTEM)`<br>[DiskLruCache](#) caching delegate for [SyncDelegateCacheService](../../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) Designed to operate common [cacheProvider](#) instance together with other delegates to be able to clean-up all cache all-together - say delete user's cache when user logs out Each entry contains: 0 - saved entity 1 - timestamp entity was last updated with `save` 2 - timestamp entity was invalidated with `invalidate` Thus, delegate requires [cacheProvider](#) with `valueCount` equals to 3 |

### Functions

| Name | Summary |
|---|---|
| [get](get.md) | `fun get(params: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>?`<br>Returns data if cached |
| [invalidate](invalidate.md) | `fun invalidate(params: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Clears cached value |
| [invalidateAll](invalidate-all.md) | `fun invalidateAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Invalidates all cached values |
| [save](save.md) | `fun save(params: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, entity: `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Saves data to cache |

### Extension Functions

| Name | Summary |
|---|---|
| [stringifyParams](../../com.motorro.rxlcemodel.base.service/stringify-params.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Delegate`](../../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](../../com.motorro.rxlcemodel.base.service/stringify-params.md#D)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.stringifyParams(stringify: `[`P`](../../com.motorro.rxlcemodel.base.service/stringify-params.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](../../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](../../com.motorro.rxlcemodel.base.service/stringify-params.md#D)`, `[`P`](../../com.motorro.rxlcemodel.base.service/stringify-params.md#P)`>`<br>Creates an adapter delegate that [stringify](../../com.motorro.rxlcemodel.base.service/stringify-params.md#P) and uses result string as params to receiver |
