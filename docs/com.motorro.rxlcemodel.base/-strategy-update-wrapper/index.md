[com.motorro.rxlcemodel.base](../index.md) / [StrategyUpdateWrapper](./index.md)

# StrategyUpdateWrapper

`class StrategyUpdateWrapper<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`UpdateWrapper`](../-update-wrapper/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>`

Wraps [LceModel](../-lce-model/index.md) and mixes in a data update state
Use to build models that patch some properties and load the whole data structure as a result
Implement methods to update properties using [doUpdate](../-update-wrapper/do-update.md) template

### Parameters

`DATA` - Data Type of data being held

`PARAMS` - Params type that identify data being loaded

`upstream` - LceModel that performs reading

`cacheService` - Data cache service that updates the same cache as [upstream](#) uses

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `StrategyUpdateWrapper(upstream: `[`LceModel`](../-lce-model/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>, cacheService: `[`CacheService`](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>)`<br>Wraps [LceModel](../-lce-model/index.md) and mixes in a data update state Use to build models that patch some properties and load the whole data structure as a result Implement methods to update properties using [doUpdate](../-update-wrapper/do-update.md) template |

### Inherited Properties

| Name | Summary |
|---|---|
| [state](../-update-wrapper/state.md) | `open val state: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](../-update-wrapper/index.md#DATA)`>>`<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates Wrapper mixes the [upstream](#) emissions with update operation status. |

### Functions

| Name | Summary |
|---|---|
| [update](update.md) | `fun update(dataSource: (params: `[`PARAMS`](index.md#PARAMS)`) -> `[`Single`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Single.html)`<out `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`DATA`](index.md#DATA)`>>): `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Creates a cache-update operation that gets data from [dataSource](update.md#com.motorro.rxlcemodel.base.StrategyUpdateWrapper$update(kotlin.Function1((com.motorro.rxlcemodel.base.StrategyUpdateWrapper.PARAMS, io.reactivex.Single((com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.StrategyUpdateWrapper.DATA)))))))/dataSource) and saves to cache. The completable updates [networkOperationState](#) to mix state to original [upstream](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [doUpdate](../-update-wrapper/do-update.md) | `fun doUpdate(dataSource: (params: `[`PARAMS`](../-update-wrapper/index.md#PARAMS)`) -> `[`Single`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Single.html)`<out `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`DATA`](../-update-wrapper/index.md#DATA)`>>): `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Creates a cache-update operation that gets data from [dataSource](../-update-wrapper/do-update.md#com.motorro.rxlcemodel.base.UpdateWrapper$doUpdate(kotlin.Function1((com.motorro.rxlcemodel.base.UpdateWrapper.PARAMS, io.reactivex.Single((com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.UpdateWrapper.DATA)))))))/dataSource) and saves to cache. The completable updates [networkOperationState](#) to mix state to original [upstream](#) |

### Extension Functions

| Name | Summary |
|---|---|
| [map](../map.md) | `fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceUseCase`](../-lce-use-case/index.md)`<`[`DATA_1`](../map.md#DATA_1)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceUseCase`](../-lce-use-case/index.md)`<`[`DATA_2`](../map.md#DATA_2)`>`<br>Creates a use-case wrapper that converts [DATA_1](../map.md#DATA_1) to [DATA_2](../map.md#DATA_2)`fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](../-lce-model/index.md)`<`[`DATA_1`](../map.md#DATA_1)`, `[`PARAMS`](../map.md#PARAMS)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceModel`](../-lce-model/index.md)`<`[`DATA_2`](../map.md#DATA_2)`, `[`PARAMS`](../map.md#PARAMS)`>`<br>Creates a model wrapper that converts [DATA_1](../map.md#DATA_1) to [DATA_2](../map.md#DATA_2) |
| [withRefresh](../with-refresh.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceUseCase`](../-lce-use-case/index.md)`<`[`DATA`](../with-refresh.md#DATA)`>.withRefresh(refreshStream: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<in `[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>): `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](../with-refresh.md#DATA)`>>`<br>Takes the [LceUseCase.state](../-lce-use-case/state.md) of model that is being refreshed each time [refreshStream](../with-refresh.md#com.motorro.rxlcemodel.base$withRefresh(com.motorro.rxlcemodel.base.LceUseCase((com.motorro.rxlcemodel.base.withRefresh.DATA)), io.reactivex.Observable((kotlin.Nothing)))/refreshStream) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../-lce-use-case/refresh.md) property becomes invisible for the outside world |
| [withUpdates](../with-updates.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](../-lce-model/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`PARAMS`](../with-updates.md#PARAMS)`>.withUpdates(serviceSet: `[`UpdatingServiceSet`](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>): `[`UpdatingLceModel`](../-updating-lce-model/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>`<br>Wraps an [LceModel](../-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](../-updating-lce-model/index.md) |
