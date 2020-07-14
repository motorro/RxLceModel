[com.motorro.rxlcemodel.base](index.md) / [withRefresh](./with-refresh.md)

# withRefresh

`fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceUseCase`](-lce-use-case/index.md)`<`[`DATA`](with-refresh.md#DATA)`>.withRefresh(refreshStream: `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<in `[`Nothing`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)`>): `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](-lce-state/index.md)`<`[`DATA`](with-refresh.md#DATA)`>>`

Takes the [LceUseCase.state](-lce-use-case/state.md) of model that is being refreshed each time [refreshStream](with-refresh.md#com.motorro.rxlcemodel.base$withRefresh(com.motorro.rxlcemodel.base.LceUseCase((com.motorro.rxlcemodel.base.withRefresh.DATA)), io.reactivex.rxjava3.core.Observable((kotlin.Nothing)))/refreshStream) emits a value
Useful when you create a model as a result of mapping of some input (params for example) and the
[LceModel.refresh](-lce-use-case/refresh.md) property becomes invisible for the outside world

### Parameters

`DATA` - Source model data type

`refreshStream` - Whenever this stream emits a value, the model is refreshed

**Receiver**
Original model

