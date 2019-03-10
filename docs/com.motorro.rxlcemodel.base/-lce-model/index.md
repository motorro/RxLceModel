[com.motorro.rxlcemodel.base](../index.md) / [LceModel](./index.md)

# LceModel

`interface LceModel<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

A model interface to load and hold some data.
Model asynchronously loads data and transmits it through [state](state.md)

### Parameters

`DATA` - Data type of data being held

`PARAMS` - Params type that identify data being loaded

### Properties

| Name | Summary |
|---|---|
| [params](params.md) | `abstract val params: `[`PARAMS`](index.md#PARAMS)<br>Params that identify data being loaded |
| [refresh](refresh.md) | `abstract val refresh: `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](state.md) | `abstract val state: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>>`<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

### Companion Object Functions

| Name | Summary |
|---|---|
| [cacheThanNet](cache-than-net.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> cacheThanNet(params: `[`PARAMS`](cache-than-net.md#PARAMS)`, serviceSet: `[`ServiceSet`](../../com.motorro.rxlcemodel.base.service/-service-set/index.md)`<`[`DATA`](cache-than-net.md#DATA)`, `[`PARAMS`](cache-than-net.md#PARAMS)`>, startWith: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](cache-than-net.md#DATA)`, `[`PARAMS`](cache-than-net.md#PARAMS)`>> = Observable.just(Loading(null, false, params))): `[`LceModel`](./index.md)`<`[`DATA`](cache-than-net.md#DATA)`, `[`PARAMS`](cache-than-net.md#PARAMS)`>`<br>Creates a model that returns cached data first, than refreshes if stall |

### Extension Functions

| Name | Summary |
|---|---|
| [map](../map.md) | `fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](./index.md)`<`[`DATA_1`](../map.md#DATA_1)`, `[`PARAMS`](../map.md#PARAMS)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceModel`](./index.md)`<`[`DATA_2`](../map.md#DATA_2)`, `[`PARAMS`](../map.md#PARAMS)`>`<br>Creates a model wrapper that converts [DATA_1](../map.md#DATA_1) to [DATA_2](../map.md#DATA_2) |
| [withUpdates](../with-updates.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](./index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`PARAMS`](../with-updates.md#PARAMS)`>.withUpdates(serviceSet: `[`UpdatingServiceSet`](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>): `[`UpdatingLceModel`](../-updating-lce-model/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>`<br>Wraps an [LceModel](./index.md) to updating delegate creating an [UpdatingLceModel](../-updating-lce-model/index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [CacheThenNetLceModel](../-cache-then-net-lce-model/index.md) | `class CacheThenNetLceModel<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceModel`](./index.md)`<`[`DATA`](../-cache-then-net-lce-model/index.md#DATA)`, `[`PARAMS`](../-cache-then-net-lce-model/index.md#PARAMS)`>`<br>A [LceModel](./index.md) which uses cache subscription as a source of truth. When [state](../-cache-then-net-lce-model/state.md) is subscribed it loads cache data refreshing it if cache is stall or whenever cache returns [com.gojuno.koptional.None](#). The model always returns cached data first - then network if data is stall Cache service *must* notify of its data changes! |
| [UpdateWrapper](../-update-wrapper/index.md) | `abstract class UpdateWrapper<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceModel`](./index.md)`<`[`DATA`](../-update-wrapper/index.md#DATA)`, `[`PARAMS`](../-update-wrapper/index.md#PARAMS)`>`<br>A base class that wraps [LceModel](./index.md) and mixes in a data update state Extend to build models that patch some properties and load the whole data structure as a result Implement methods to update properties using [doUpdate](../-update-wrapper/do-update.md) template |
| [UpdatingLceModel](../-updating-lce-model/index.md) | `interface UpdatingLceModel<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceModel`](./index.md)`<`[`DATA`](../-updating-lce-model/index.md#DATA)`, `[`PARAMS`](../-updating-lce-model/index.md#PARAMS)`>`<br>[LceModel](./index.md) extension that can [update](../-updating-lce-model/update.md) data |
