[com.motorro.rxlcemodel.base.service](../index.md) / [SyncDelegateCacheService](./index.md)

# SyncDelegateCacheService

`class SyncDelegateCacheService<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`CacheService`](../-cache-service/index.md)`<`[`D`](index.md#D)`, `[`P`](index.md#P)`>`

Service implementation

### Parameters

`delegate` - Delegate to perform concrete caching operations

### Types

| Name | Summary |
|---|---|
| [Delegate](-delegate/index.md) | `interface Delegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`<br>Delegate that synchronously performs caching operations |

### Properties

| Name | Summary |
|---|---|
| [invalidateAll](invalidate-all.md) | `val invalidateAll: `[`Completable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html)<br>Invalidates all cached values |

### Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | `fun delete(params: `[`P`](index.md#P)`): `[`Completable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html)<br>Deletes cached value. The [getData](get-data.md) observable for the same key wil emit [com.gojuno.koptional.None](#) |
| [getData](get-data.md) | `fun getData(params: `[`P`](index.md#P)`): `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<Optional<`[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>>>`<br>Subscribes to cache data updates |
| [invalidate](invalidate.md) | `fun invalidate(params: `[`P`](index.md#P)`): `[`Completable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html)<br>Clears cached value |
| [save](save.md) | `fun save(params: `[`P`](index.md#P)`, entity: `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>): `[`Completable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html)<br>Saves entity in a cache |
