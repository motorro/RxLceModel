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
| [makeFriendParams](../../make-friend-params.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Delegate`](./index.md)`<`[`D`](../../make-friend-params.md#D)`, `[`CacheFriend`](../../-cache-friend/index.md)`>.makeFriendParams(stringify: `[`P`](../../make-friend-params.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Delegate`](./index.md)`<`[`D`](../../make-friend-params.md#D)`, `[`P`](../../make-friend-params.md#P)`>`<br>Creates an adapter delegate that creates [CacheFriend](../../-cache-friend/index.md) params using [stringify](../../make-friend-params.md#com.motorro.rxlcemodel.base.service$makeFriendParams(com.motorro.rxlcemodel.base.service.SyncDelegateCacheService.Delegate((com.motorro.rxlcemodel.base.service.makeFriendParams.D, com.motorro.rxlcemodel.base.service.CacheFriend)), kotlin.Function1((com.motorro.rxlcemodel.base.service.makeFriendParams.P, kotlin.String)))/stringify) function |
| [stringifyParams](../../stringify-params.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Delegate`](./index.md)`<`[`D`](../../stringify-params.md#D)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.stringifyParams(stringify: `[`P`](../../stringify-params.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](./index.md)`<`[`D`](../../stringify-params.md#D)`, `[`P`](../../stringify-params.md#P)`>`<br>Creates an adapter delegate that [stringify](../../stringify-params.md#P) and uses result string as params to receiver |

### Inheritors

| Name | Summary |
|---|---|
| [CacheFriendDelegate](../../-cache-friend-delegate/index.md) | `class CacheFriendDelegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`CacheFriend`](../../-cache-friend/index.md)`> : `[`Delegate`](./index.md)`<`[`D`](../../-cache-friend-delegate/index.md#D)`, `[`P`](../../-cache-friend-delegate/index.md#P)`>`<br>Wraps [delegate](#) adding unmodified [CacheFriend.cacheKey](../../-cache-friend/cache-key.md) to the mix with data. Validates that key on [get](../../-cache-friend-delegate/get.md) and returns null if it is not equals original. Helps to make sure the data returned is not a result of clashed cache key. |
| [DiskLruCacheSyncDelegate](../../../com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/index.md) | `class DiskLruCacheSyncDelegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Delegate`](./index.md)`<`[`D`](../../../com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/index.md#D)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>[DiskLruCache](#) caching delegate for [SyncDelegateCacheService](../index.md) Designed to operate common [cacheProvider](#) instance together with other delegates to be able to clean-up all cache all-together - say delete user's cache when user logs out Each entry contains: 0 - saved entity 1 - timestamp entity was last updated with `save` 2 - timestamp entity was invalidated with `invalidate` |
| [MemorySyncDelegate](../../-memory-sync-delegate/index.md) | `abstract class MemorySyncDelegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Delegate`](./index.md)`<`[`D`](../../-memory-sync-delegate/index.md#D)`, `[`P`](../../-memory-sync-delegate/index.md#P)`>`<br>A simple memory cache for [SyncDelegateCacheService](../index.md). |
