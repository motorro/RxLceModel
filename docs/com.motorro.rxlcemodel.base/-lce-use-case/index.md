[com.motorro.rxlcemodel.base](../index.md) / [LceUseCase](./index.md)

# LceUseCase

`interface LceUseCase<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

Base LCE use-case with [state](state.md) and [refresh](refresh.md)

### Parameters

`DATA` - Data type of data being loaded

### Properties

| Name | Summary |
|---|---|
| [refresh](refresh.md) | `abstract val refresh: `[`Completable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](state.md) | `abstract val state: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](index.md#DATA)`>>`<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

### Inheritors

| Name | Summary |
|---|---|
| [LceModel](../-lce-model/index.md) | `interface LceModel<DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceUseCase`](./index.md)`<`[`DATA`](../-lce-model/index.md#DATA)`>`<br>A model interface to load data and transmit it to subscribers along with loading operation state |
