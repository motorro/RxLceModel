[com.motorro.rxlcemodel.base](../index.md) / [LceUseCase](./index.md)

# LceUseCase

`interface LceUseCase<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

Base LCE use-case with [state](state.md) and [refresh](refresh.md)

### Parameters

`DATA` - Data type of data being loaded

### Properties

| Name | Summary |
|---|---|
| [refresh](refresh.md) | `abstract val refresh: `[`Completable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html)<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](state.md) | `abstract val state: `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](index.md#DATA)`>>`<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

### Extension Functions

| Name | Summary |
|---|---|
| [map](../map.md) | `fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceUseCase`](./index.md)`<`[`DATA_1`](../map.md#DATA_1)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceUseCase`](./index.md)`<`[`DATA_2`](../map.md#DATA_2)`>`<br>Creates a use-case wrapper that converts [DATA_1](../map.md#DATA_1) to [DATA_2](../map.md#DATA_2) |
| [withRefresh](../with-refresh.md) | `fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceUseCase`](./index.md)`<`[`DATA`](../with-refresh.md#DATA)`>.withRefresh(refreshStream: `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>): `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](../with-refresh.md#DATA)`>>`<br>Takes the [LceUseCase.state](state.md) of model that is being refreshed each time [refreshStream](../with-refresh.md#com.motorro.rxlcemodel.base$withRefresh(com.motorro.rxlcemodel.base.LceUseCase((com.motorro.rxlcemodel.base.withRefresh.DATA)), io.reactivex.rxjava3.core.Observable((kotlin.Int)))/refreshStream) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](refresh.md) property becomes invisible for the outside world |

### Inheritors

| Name | Summary |
|---|---|
| [LceModel](../-lce-model/index.md) | `interface LceModel<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceUseCase`](./index.md)`<`[`DATA`](../-lce-model/index.md#DATA)`>`<br>A model interface to load data and transmit it to subscribers along with loading operation state |
