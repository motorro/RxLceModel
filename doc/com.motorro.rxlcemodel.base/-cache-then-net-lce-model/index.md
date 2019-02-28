[com.motorro.rxlcemodel.base](../index.md) / [CacheThenNetLceModel](./index.md)

# CacheThenNetLceModel

`class CacheThenNetLceModel<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceModel`](../-lce-model/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>`

A [LceModel](../-lce-model/index.md) which uses cache subscription as a source of truth.
When [state](state.md) is subscribed it loads cache data refreshing it if cache is stall or whenever cache
returns [com.gojuno.koptional.None](#).
The model always returns cached data first - then network if data is stall
Cache service *must* notify of its data changes!

### Parameters

`DATA` - Data type of data being held

`PARAMS` - Params type that identify data being loaded

`params` - Params that identify data being loaded

`serviceSet` - Data service-set

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CacheThenNetLceModel(params: `[`PARAMS`](index.md#PARAMS)`, serviceSet: `[`ServiceSet`](../../com.motorro.rxlcemodel.base.service/-service-set/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>)`<br>A [LceModel](../-lce-model/index.md) which uses cache subscription as a source of truth. When [state](state.md) is subscribed it loads cache data refreshing it if cache is stall or whenever cache returns [com.gojuno.koptional.None](#). The model always returns cached data first - then network if data is stall Cache service *must* notify of its data changes! |

### Properties

| Name | Summary |
|---|---|
| [params](params.md) | `val params: `[`PARAMS`](index.md#PARAMS)<br>Params that identify data being loaded |
| [refresh](refresh.md) | `val refresh: `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](state.md) | `val state: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>>`<br>Model data. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

### Extension Functions

| Name | Summary |
|---|---|
| [map](../map.md) | `fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](../-lce-model/index.md)`<`[`DATA_1`](../map.md#DATA_1)`, `[`PARAMS`](../map.md#PARAMS)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceModel`](../-lce-model/index.md)`<`[`DATA_2`](../map.md#DATA_2)`, `[`PARAMS`](../map.md#PARAMS)`>`<br>Creates a model wrapper that converts [DATA_1](../map.md#DATA_1) to [DATA_2](../map.md#DATA_2) |
| [withUpdates](../with-updates.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](../-lce-model/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`PARAMS`](../with-updates.md#PARAMS)`>.withUpdates(serviceSet: `[`UpdatingServiceSet`](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>): `[`UpdatingLceModel`](../-updating-lce-model/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>`<br>Wraps an [LceModel](../-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](../-updating-lce-model/index.md) |
