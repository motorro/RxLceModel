[com.motorro.rxlcemodel.base.service](../index.md) / [CacheService](./index.md)

# CacheService

`interface CacheService<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

Interface to cache an [com.motorro.rxlcemodel.base.entity.Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) locally
Cache should notify subscribers that data has been updated through [getData](get-data.md) channel

### Parameters

`D` - Data type

`P` - Params that identify data type

### Properties

| Name | Summary |
|---|---|
| [invalidateAll](invalidate-all.md) | `abstract val invalidateAll: `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Invalidates all cached values |

### Functions

| Name | Summary |
|---|---|
| [getData](get-data.md) | `abstract fun getData(params: `[`P`](index.md#P)`): `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<Optional<`[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>>>`<br>Subscribes to cache data updates |
| [invalidate](invalidate.md) | `abstract fun invalidate(params: `[`P`](index.md#P)`): `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Invalidates cached value |
| [save](save.md) | `abstract fun save(params: `[`P`](index.md#P)`, entity: `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>): `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Saves entity in a cache |

### Companion Object Functions

| Name | Summary |
|---|---|
| [withSyncDelegate](with-sync-delegate.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> withSyncDelegate(delegate: `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](with-sync-delegate.md#D)`, `[`P`](with-sync-delegate.md#P)`>): `[`SyncDelegateCacheService`](../-sync-delegate-cache-service/index.md)`<`[`D`](with-sync-delegate.md#D)`, `[`P`](with-sync-delegate.md#P)`>`<br>Creates synchronous [SyncDelegateCacheService.Delegate](../-sync-delegate-cache-service/-delegate/index.md) cache service |

### Inheritors

| Name | Summary |
|---|---|
| [SyncDelegateCacheService](../-sync-delegate-cache-service/index.md) | `class SyncDelegateCacheService<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`CacheService`](./index.md)`<`[`D`](../-sync-delegate-cache-service/index.md#D)`, `[`P`](../-sync-delegate-cache-service/index.md#P)`>`<br>Service implementation |
