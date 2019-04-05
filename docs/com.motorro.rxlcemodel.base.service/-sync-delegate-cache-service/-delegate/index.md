[com.motorro.rxlcemodel.base.service](../../index.md) / [SyncDelegateCacheService](../index.md) / [Delegate](./index.md)

# Delegate

`interface Delegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

Delegate that synchronously performs caching operations

### Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | `abstract fun delete(params: `[`P`](index.md#P)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deletes cached value |
| [get](get.md) | `abstract fun get(params: `[`P`](index.md#P)`): `[`Entity`](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>?`<br>Returns data if cached |
| [invalidate](invalidate.md) | `abstract fun invalidate(params: `[`P`](index.md#P)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Invalidates cached value |
| [invalidateAll](invalidate-all.md) | `abstract fun invalidateAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Invalidates all cached values |
| [save](save.md) | `abstract fun save(params: `[`P`](index.md#P)`, entity: `[`Entity`](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Saves data to cache |

### Extension Functions

| Name | Summary |
|---|---|
| [stringifyParams](../../stringify-params.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Delegate`](./index.md)`<`[`D`](../../stringify-params.md#D)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.stringifyParams(stringify: `[`P`](../../stringify-params.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](./index.md)`<`[`D`](../../stringify-params.md#D)`, `[`P`](../../stringify-params.md#P)`>`<br>Creates an adapter delegate that [stringify](../../stringify-params.md#P) and uses result string as params to receiver |

### Inheritors

| Name | Summary |
|---|---|
| [DiskLruCacheSyncDelegate](../../../com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/index.md) | `class DiskLruCacheSyncDelegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Delegate`](./index.md)`<`[`D`](../../../com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/index.md#D)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>[DiskLruCache](#) caching delegate for [SyncDelegateCacheService](../index.md) Designed to operate common [cacheProvider](#) instance together with other delegates to be able to clean-up all cache all-together - say delete user's cache when user logs out Each entry contains: 0 - saved entity 1 - timestamp entity was last updated with `save` 2 - timestamp entity was invalidated with `invalidate` |
| [MemorySyncDelegate](../../-memory-sync-delegate/index.md) | `abstract class MemorySyncDelegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Delegate`](./index.md)`<`[`D`](../../-memory-sync-delegate/index.md#D)`, `[`P`](../../-memory-sync-delegate/index.md#P)`>`<br>A simple memory cache for [SyncDelegateCacheService](../index.md). |
