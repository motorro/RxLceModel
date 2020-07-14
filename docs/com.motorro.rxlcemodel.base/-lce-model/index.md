[com.motorro.rxlcemodel.base](../index.md) / [LceModel](./index.md)

# LceModel

`interface LceModel<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceUseCase`](../-lce-use-case/index.md)`<`[`DATA`](index.md#DATA)`>`

A model interface to load data and transmit it to subscribers along with loading operation state

### Parameters

`DATA` - Data type of data being loaded

`PARAMS` - Params type that identify data being loaded

### Properties

| Name | Summary |
|---|---|
| [params](params.md) | `abstract val params: `[`PARAMS`](index.md#PARAMS)<br>Params that identify data being loaded |

### Inherited Properties

| Name | Summary |
|---|---|
| [refresh](../-lce-use-case/refresh.md) | `abstract val refresh: `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](../-lce-use-case/state.md) | `abstract val state: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](../-lce-use-case/index.md#DATA)`>>`<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

### Companion Object Functions

| Name | Summary |
|---|---|
| [cacheThenNet](cache-then-net.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> cacheThenNet(params: `[`PARAMS`](cache-then-net.md#PARAMS)`, serviceSet: `[`ServiceSet`](../../com.motorro.rxlcemodel.base.service/-service-set/index.md)`<`[`DATA`](cache-then-net.md#DATA)`, `[`PARAMS`](cache-then-net.md#PARAMS)`>, startWith: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](cache-then-net.md#DATA)`>> = Observable.just(Loading(null, false))): `[`LceModel`](./index.md)`<`[`DATA`](cache-then-net.md#DATA)`, `[`PARAMS`](cache-then-net.md#PARAMS)`>`<br>Creates a model that returns cached data first, then refreshes if stall`fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> cacheThenNet(params: `[`PARAMS`](cache-then-net.md#PARAMS)`, net: `[`NetService`](../../com.motorro.rxlcemodel.base.service/-net-service/index.md)`<`[`DATA`](cache-then-net.md#DATA)`, `[`PARAMS`](cache-then-net.md#PARAMS)`>, cache: `[`CacheService`](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)`<`[`DATA`](cache-then-net.md#DATA)`, `[`PARAMS`](cache-then-net.md#PARAMS)`>, startWith: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](cache-then-net.md#DATA)`>> = Observable.just(Loading(null, false))): `[`LceModel`](./index.md)`<`[`DATA`](cache-then-net.md#DATA)`, `[`PARAMS`](cache-then-net.md#PARAMS)`>`<br>Creates a model that returns cached data first, than refreshes if stall |

### Extension Functions

| Name | Summary |
|---|---|
| [map](../map.md) | `fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](./index.md)`<`[`DATA_1`](../map.md#DATA_1)`, `[`PARAMS`](../map.md#PARAMS)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceModel`](./index.md)`<`[`DATA_2`](../map.md#DATA_2)`, `[`PARAMS`](../map.md#PARAMS)`>`<br>Creates a model wrapper that converts [DATA_1](../map.md#DATA_1) to [DATA_2](../map.md#DATA_2)`fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceUseCase`](../-lce-use-case/index.md)`<`[`DATA_1`](../map.md#DATA_1)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceUseCase`](../-lce-use-case/index.md)`<`[`DATA_2`](../map.md#DATA_2)`>`<br>Creates a use-case wrapper that converts [DATA_1](../map.md#DATA_1) to [DATA_2](../map.md#DATA_2) |
| [withRefresh](../with-refresh.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceUseCase`](../-lce-use-case/index.md)`<`[`DATA`](../with-refresh.md#DATA)`>.withRefresh(refreshStream: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<in `[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>): `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](../with-refresh.md#DATA)`>>`<br>Takes the [LceUseCase.state](../-lce-use-case/state.md) of model that is being refreshed each time [refreshStream](../with-refresh.md#com.motorro.rxlcemodel.base$withRefresh(com.motorro.rxlcemodel.base.LceUseCase((com.motorro.rxlcemodel.base.withRefresh.DATA)), io.reactivex.Observable((kotlin.Nothing)))/refreshStream) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../-lce-use-case/refresh.md) property becomes invisible for the outside world |
| [withUpdates](../with-updates.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](./index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`PARAMS`](../with-updates.md#PARAMS)`>.withUpdates(serviceSet: `[`UpdatingServiceSet`](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>): `[`UpdatingLceModel`](../-updating-lce-model/index.md)`<`[`DATA`](../with-updates.md#DATA)`, `[`UPDATE`](../with-updates.md#UPDATE)`, `[`PARAMS`](../with-updates.md#PARAMS)`>`<br>Wraps an [LceModel](./index.md) to updating delegate creating an [UpdatingLceModel](../-updating-lce-model/index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [CacheThenNetLceModel](../-cache-then-net-lce-model/index.md) | `class CacheThenNetLceModel<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceModel`](./index.md)`<`[`DATA`](../-cache-then-net-lce-model/index.md#DATA)`, `[`PARAMS`](../-cache-then-net-lce-model/index.md#PARAMS)`>`<br>A [LceModel](./index.md) which uses cache subscription as a 'source of truth'. When [state](../-cache-then-net-lce-model/state.md) is subscribed it loads cache data refreshing it if cache is stall or whenever cache returns [com.gojuno.koptional.None](#). The model always returns cached data first - then network if data is stall Cache service *must* notify of its data changes! |
| [UpdateWrapper](../-update-wrapper/index.md) | `abstract class UpdateWrapper<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceModel`](./index.md)`<`[`DATA`](../-update-wrapper/index.md#DATA)`, `[`PARAMS`](../-update-wrapper/index.md#PARAMS)`>`<br>A base class that wraps [LceModel](./index.md) and mixes in a data update state Extend to build models that patch some properties and load the whole data structure as a result Implement methods to update properties using [doUpdate](../-update-wrapper/do-update.md) template |
| [UpdatingLceModel](../-updating-lce-model/index.md) | `interface UpdatingLceModel<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceModel`](./index.md)`<`[`DATA`](../-updating-lce-model/index.md#DATA)`, `[`PARAMS`](../-updating-lce-model/index.md#PARAMS)`>`<br>[LceModel](./index.md) extension that can [update](../-updating-lce-model/update.md) data |
