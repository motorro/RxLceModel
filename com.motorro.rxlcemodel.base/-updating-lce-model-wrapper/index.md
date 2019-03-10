[com.motorro.rxlcemodel.base](../index.md) / [UpdatingLceModelWrapper](./index.md)

# UpdatingLceModelWrapper

`class UpdatingLceModelWrapper<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`UpdateWrapper`](../-update-wrapper/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>, `[`UpdatingLceModel`](../-updating-lce-model/index.md)`<`[`DATA`](index.md#DATA)`, `[`UPDATE`](index.md#UPDATE)`, `[`PARAMS`](index.md#PARAMS)`>`

Wraps an [LceModel](../-lce-model/index.md) to enable simple data updates with the [UPDATE](index.md#UPDATE) structure
(say a PUT operation) rather than individual property updates (PATCH operation).
Implement [UpdateWrapper](../-update-wrapper/index.md) to achieve PATCH workflow

### Parameters

`DATA` - Data Type of data being held

`UPDATE` - Update type

`PARAMS` - Params type that identify data being loaded

`upstream` - LceModel that performs reading

`serviceSet` - Data service-set. Note that cache service should update the
same cache as [upstream](#) uses for things to work correctly

**See Also**

[UpdateWrapper](../-update-wrapper/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `UpdatingLceModelWrapper(upstream: `[`LceModel`](../-lce-model/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>, serviceSet: `[`UpdatingServiceSet`](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)`<`[`DATA`](index.md#DATA)`, `[`UPDATE`](index.md#UPDATE)`, `[`PARAMS`](index.md#PARAMS)`>)`<br>Wraps an [LceModel](../-lce-model/index.md) to enable simple data updates with the [UPDATE](index.md#UPDATE) structure (say a PUT operation) rather than individual property updates (PATCH operation). Implement [UpdateWrapper](../-update-wrapper/index.md) to achieve PATCH workflow |

### Inherited Properties

| Name | Summary |
|---|---|
| [state](../-update-wrapper/state.md) | `open val state: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](../-update-wrapper/index.md#DATA)`, `[`PARAMS`](../-update-wrapper/index.md#PARAMS)`>>`<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates Wrapper mixes the [upstream](#) emissions with update operation status. |

### Functions

| Name | Summary |
|---|---|
| [update](update.md) | `fun update(update: `[`UPDATE`](index.md#UPDATE)`): `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Updates data on server and refreshes local data |

### Inherited Functions

| Name | Summary |
|---|---|
| [doUpdate](../-update-wrapper/do-update.md) | `fun doUpdate(dataSource: (params: `[`PARAMS`](../-update-wrapper/index.md#PARAMS)`) -> `[`Single`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Single.html)`<out `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`DATA`](../-update-wrapper/index.md#DATA)`>>): `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Creates a cache-update operation that gets data from [dataSource](../-update-wrapper/do-update.md#com.motorro.rxlcemodel.base.UpdateWrapper$doUpdate(kotlin.Function1((com.motorro.rxlcemodel.base.UpdateWrapper.PARAMS, io.reactivex.Single((com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.UpdateWrapper.DATA)))))))/dataSource) and saves to cache. The completable updates [networkOperationState](#) to mix state to original [upstream](#) |

### Extension Functions

| Name | Summary |
|---|---|
| [map](../map.md) | `fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](../-lce-model/index.md)`<`[`DATA_1`](../map.md#DATA_1)`, `[`PARAMS`](../map.md#PARAMS)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceModel`](../-lce-model/index.md)`<`[`DATA_2`](../map.md#DATA_2)`, `[`PARAMS`](../map.md#PARAMS)`>`<br>Creates a model wrapper that converts [DATA_1](../map.md#DATA_1) to [DATA_2](../map.md#DATA_2) |
| [withUpdates](../with-updates.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](../-lce-model/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`PARAMS`](../with-updates.md#PARAMS)`>.withUpdates(serviceSet: `[`UpdatingServiceSet`](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>): `[`UpdatingLceModel`](../-updating-lce-model/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>`<br>Wraps an [LceModel](../-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](../-updating-lce-model/index.md) |
