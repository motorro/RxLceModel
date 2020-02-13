[com.motorro.rxlcemodel.base.service](../index.md) / [CacheFriendDelegate](./index.md)

# CacheFriendDelegate

`class CacheFriendDelegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`CacheFriend`](../-cache-friend/index.md)`> : `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](index.md#D)`, `[`P`](index.md#P)`>`

Wraps [delegate](#) adding unmodified [CacheFriend.cacheKey](../-cache-friend/cache-key.md) to the mix with data.
Validates that key on [get](get.md) and returns null if it is not equals original.
Helps to make sure the data returned is not a result of clashed cache key.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CacheFriendDelegate(delegate: `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`DataWithCacheKey`](../-data-with-cache-key/index.md)`<`[`D`](index.md#D)`>, `[`P`](index.md#P)`>)`<br>Wraps [delegate](#) adding unmodified [CacheFriend.cacheKey](../-cache-friend/cache-key.md) to the mix with data. Validates that key on [get](get.md) and returns null if it is not equals original. Helps to make sure the data returned is not a result of clashed cache key. |

### Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | `fun delete(params: `[`P`](index.md#P)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deletes cached value |
| [get](get.md) | `fun get(params: `[`P`](index.md#P)`): `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>?`<br>Returns data if cached |
| [invalidate](invalidate.md) | `fun invalidate(params: `[`P`](index.md#P)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Invalidates cached value |
| [invalidateAll](invalidate-all.md) | `fun invalidateAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Invalidates all cached values |
| [save](save.md) | `fun save(params: `[`P`](index.md#P)`, entity: `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Saves data to cache |

### Extension Functions

| Name | Summary |
|---|---|
| [makeFriendParams](../make-friend-params.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](../make-friend-params.md#D)`, `[`CacheFriend`](../-cache-friend/index.md)`>.makeFriendParams(stringify: `[`P`](../make-friend-params.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](../make-friend-params.md#D)`, `[`P`](../make-friend-params.md#P)`>`<br>Creates an adapter delegate that creates [CacheFriend](../-cache-friend/index.md) params using [stringify](../make-friend-params.md#com.motorro.rxlcemodel.base.service$makeFriendParams(com.motorro.rxlcemodel.base.service.SyncDelegateCacheService.Delegate((com.motorro.rxlcemodel.base.service.makeFriendParams.D, com.motorro.rxlcemodel.base.service.CacheFriend)), kotlin.Function1((com.motorro.rxlcemodel.base.service.makeFriendParams.P, kotlin.String)))/stringify) function |
| [stringifyParams](../stringify-params.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](../stringify-params.md#D)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.stringifyParams(stringify: `[`P`](../stringify-params.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](../stringify-params.md#D)`, `[`P`](../stringify-params.md#P)`>`<br>Creates an adapter delegate that [stringify](../stringify-params.md#P) and uses result string as params to receiver |
