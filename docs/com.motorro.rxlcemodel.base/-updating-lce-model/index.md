[com.motorro.rxlcemodel.base](../index.md) / [UpdatingLceModel](./index.md)

# UpdatingLceModel

`interface UpdatingLceModel<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceModel`](../-lce-model/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>`

[LceModel](../-lce-model/index.md) extension that can [update](update.md) data

### Parameters

`DATA` - Data type of data being held

`UPDATE` - Update type

`PARAMS` - Params type that identify data being loaded

### Inherited Properties

| Name | Summary |
|---|---|
| [params](../-lce-model/params.md) | `abstract val params: `[`PARAMS`](../-lce-model/index.md#PARAMS)<br>Params that identify data being loaded |
| [refresh](../-lce-model/refresh.md) | `abstract val refresh: `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](../-lce-model/state.md) | `abstract val state: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](../-lce-model/index.md#DATA)`, `[`PARAMS`](../-lce-model/index.md#PARAMS)`>>`<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

### Functions

| Name | Summary |
|---|---|
| [update](update.md) | `abstract fun update(update: `[`UPDATE`](index.md#UPDATE)`): `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Updates data on server and refreshes local data |

### Extension Functions

| Name | Summary |
|---|---|
| [map](../map.md) | `fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](../-lce-model/index.md)`<`[`DATA_1`](../map.md#DATA_1)`, `[`PARAMS`](../map.md#PARAMS)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceModel`](../-lce-model/index.md)`<`[`DATA_2`](../map.md#DATA_2)`, `[`PARAMS`](../map.md#PARAMS)`>`<br>Creates a model wrapper that converts [DATA_1](../map.md#DATA_1) to [DATA_2](../map.md#DATA_2) |
| [withUpdates](../with-updates.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](../-lce-model/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`PARAMS`](../with-updates.md#PARAMS)`>.withUpdates(serviceSet: `[`UpdatingServiceSet`](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>): `[`UpdatingLceModel`](./index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>`<br>Wraps an [LceModel](../-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](./index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [UpdatingLceModelWrapper](../-updating-lce-model-wrapper/index.md) | `class UpdatingLceModelWrapper<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`UpdateWrapper`](../-update-wrapper/index.md)`<`[`DATA`](../-updating-lce-model-wrapper/index.md#DATA)`, `[`PARAMS`](../-updating-lce-model-wrapper/index.md#PARAMS)`>, `[`UpdatingLceModel`](./index.md)`<`[`DATA`](../-updating-lce-model-wrapper/index.md#DATA)`, `[`UPDATE`](../-updating-lce-model-wrapper/index.md#UPDATE)`, `[`PARAMS`](../-updating-lce-model-wrapper/index.md#PARAMS)`>`<br>Wraps an [LceModel](../-lce-model/index.md) to enable simple data updates with the [UPDATE](../-updating-lce-model-wrapper/index.md#UPDATE) structure (say a PUT operation) rather than individual property updates (PATCH operation). Implement [UpdateWrapper](../-update-wrapper/index.md) to achieve PATCH workflow |
