[com.motorro.rxlcemodel.base.service](../index.md) / [MemorySyncDelegate](./index.md)

# MemorySyncDelegate

`abstract class MemorySyncDelegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](index.md#D)`, `[`P`](index.md#P)`>`

A simple memory cache for [SyncDelegateCacheService](../-sync-delegate-cache-service/index.md).

### Parameters

`D` - Data type

`P` - Params type

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MemorySyncDelegate()`<br>A simple memory cache for [SyncDelegateCacheService](../-sync-delegate-cache-service/index.md). |

### Properties

| Name | Summary |
|---|---|
| [cache](cache.md) | `abstract val cache: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`P`](index.md#P)`, `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>>`<br>Data storage |

### Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | `open fun delete(params: `[`P`](index.md#P)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deletes cached value |
| [get](get.md) | `open fun get(params: `[`P`](index.md#P)`): `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>?`<br>Returns data if cached |
| [invalidate](invalidate.md) | `open fun invalidate(params: `[`P`](index.md#P)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Invalidates cached value |
| [invalidateAll](invalidate-all.md) | `open fun invalidateAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Invalidates all cached values |
| [save](save.md) | `open fun save(params: `[`P`](index.md#P)`, entity: `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Saves data to cache |

### Companion Object Functions

| Name | Summary |
|---|---|
| [custom](custom.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> custom(map: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`P`](custom.md#P)`, `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](custom.md#D)`>>): `[`MemorySyncDelegate`](./index.md)`<`[`D`](custom.md#D)`, `[`P`](custom.md#P)`>`<br>Creates an in-memory LRU cache with custom [map](custom.md#com.motorro.rxlcemodel.base.service.MemorySyncDelegate.Companion$custom(kotlin.collections.MutableMap((com.motorro.rxlcemodel.base.service.MemorySyncDelegate.Companion.custom.P, com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.service.MemorySyncDelegate.Companion.custom.D)))))/map) as a cache |
| [lru](lru.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> lru(maxEntries: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, initialCapacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 16): `[`MemorySyncDelegate`](./index.md)`<`[`D`](lru.md#D)`, `[`P`](lru.md#P)`>`<br>Creates an in-memory LRU cache with [maxEntries](lru.md#com.motorro.rxlcemodel.base.service.MemorySyncDelegate.Companion$lru(kotlin.Int, kotlin.Int)/maxEntries) records maximum |
| [simple](simple.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> simple(initialCapacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 16): `[`MemorySyncDelegate`](./index.md)`<`[`D`](simple.md#D)`, `[`P`](simple.md#P)`>`<br>Creates a simple in-memory cache without LRU strategy |

### Extension Functions

| Name | Summary |
|---|---|
| [stringifyParams](../stringify-params.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](../stringify-params.md#D)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.stringifyParams(stringify: `[`P`](../stringify-params.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](../stringify-params.md#D)`, `[`P`](../stringify-params.md#P)`>`<br>Creates an adapter delegate that [stringify](../stringify-params.md#P) and uses result string as params to receiver |
