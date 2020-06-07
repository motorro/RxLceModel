[com.motorro.rxlcemodel.base](index.md) / [withRefresh](./with-refresh.md)

# withRefresh

`fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](-lce-model/index.md)`<`[`DATA`](with-refresh.md#DATA)`, `[`PARAMS`](with-refresh.md#PARAMS)`>.withRefresh(refreshStream: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>): `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](-lce-state/index.md)`<`[`DATA`](with-refresh.md#DATA)`>>`

Takes the [LceModel.state](-lce-use-case/state.md) of model that is being refreshed each time [refreshStream](with-refresh.md#com.motorro.rxlcemodel.base$withRefresh(com.motorro.rxlcemodel.base.LceModel((com.motorro.rxlcemodel.base.withRefresh.DATA, com.motorro.rxlcemodel.base.withRefresh.PARAMS)), io.reactivex.Observable((kotlin.Int)))/refreshStream) emits a value
Useful when you create a model as a result of mapping of some input (params for example) and the
[LceModel.refresh](-lce-use-case/refresh.md) property becomes invisible for the outside world

### Parameters

`DATA` - Source model data type

`PARAMS` - Params type that identify data being loaded

`refreshStream` - Whenever this stream emits a value, the model is refreshed

**Receiver**
Original model

