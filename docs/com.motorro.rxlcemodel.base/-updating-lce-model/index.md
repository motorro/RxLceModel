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

### Functions

| Name | Summary |
|---|---|
| [update](update.md) | `abstract fun update(update: `[`UPDATE`](index.md#UPDATE)`): `[`Completable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html)<br>Updates data on server and refreshes local data |

### Extension Functions

| Name | Summary |
|---|---|
| [map](../map.md) | `fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceUseCase`](../-lce-use-case/index.md)`<`[`DATA_1`](../map.md#DATA_1)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceUseCase`](../-lce-use-case/index.md)`<`[`DATA_2`](../map.md#DATA_2)`>`<br>Creates a use-case wrapper that converts [DATA_1](../map.md#DATA_1) to [DATA_2](../map.md#DATA_2)`fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](../-lce-model/index.md)`<`[`DATA_1`](../map.md#DATA_1)`, `[`PARAMS`](../map.md#PARAMS)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceModel`](../-lce-model/index.md)`<`[`DATA_2`](../map.md#DATA_2)`, `[`PARAMS`](../map.md#PARAMS)`>`<br>Creates a model wrapper that converts [DATA_1](../map.md#DATA_1) to [DATA_2](../map.md#DATA_2) |
| [withRefresh](../with-refresh.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceUseCase`](../-lce-use-case/index.md)`<`[`DATA`](../with-refresh.md#DATA)`>.withRefresh(refreshStream: `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>): `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](../with-refresh.md#DATA)`>>`<br>Takes the [LceUseCase.state](../-lce-use-case/state.md) of model that is being refreshed each time [refreshStream](../with-refresh.md#com.motorro.rxlcemodel.base$withRefresh(com.motorro.rxlcemodel.base.LceUseCase((com.motorro.rxlcemodel.base.withRefresh.DATA)), io.reactivex.rxjava3.core.Observable((kotlin.Int)))/refreshStream) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../-lce-use-case/refresh.md) property becomes invisible for the outside world |
| [withUpdates](../with-updates.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](../-lce-model/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`PARAMS`](../with-updates.md#PARAMS)`>.withUpdates(serviceSet: `[`UpdatingServiceSet`](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>): `[`UpdatingLceModel`](./index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>`<br>Wraps an [LceModel](../-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](./index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [UpdatingLceModelWrapper](../-updating-lce-model-wrapper/index.md) | `class UpdatingLceModelWrapper<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`UpdateWrapper`](../-update-wrapper/index.md)`<`[`DATA`](../-updating-lce-model-wrapper/index.md#DATA)`, `[`PARAMS`](../-updating-lce-model-wrapper/index.md#PARAMS)`>, `[`UpdatingLceModel`](./index.md)`<`[`DATA`](../-updating-lce-model-wrapper/index.md#DATA)`, `[`UPDATE`](../-updating-lce-model-wrapper/index.md#UPDATE)`, `[`PARAMS`](../-updating-lce-model-wrapper/index.md#PARAMS)`>`<br>Wraps an [LceModel](../-lce-model/index.md) to enable simple data updates with the [UPDATE](../-updating-lce-model-wrapper/index.md#UPDATE) structure (say a PUT operation) rather than individual property updates (PATCH operation). Implement [UpdateWrapper](../-update-wrapper/index.md) to achieve PATCH workflow |
