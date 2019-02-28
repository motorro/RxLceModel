[com.motorro.rxlcemodel.base](../index.md) / [io.reactivex.Observable](index.md) / [terminateOnError](./terminate-on-error.md)

# terminateOnError

`fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](terminate-on-error.md#DATA)`, `[`PARAMS`](terminate-on-error.md#PARAMS)`>>.terminateOnError(predicate: (`[`Error`](../-lce-state/-error/index.md)`<`[`DATA`](terminate-on-error.md#DATA)`, `[`PARAMS`](terminate-on-error.md#PARAMS)`>) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](terminate-on-error.md#DATA)`, `[`PARAMS`](terminate-on-error.md#PARAMS)`>>`

Terminates [LceModel.state](../-lce-model/state.md) stream if [predicate](terminate-on-error.md#com.motorro.rxlcemodel.base$terminateOnError(io.reactivex.Observable((com.motorro.rxlcemodel.base.LceState((com.motorro.rxlcemodel.base.terminateOnError.DATA, com.motorro.rxlcemodel.base.terminateOnError.PARAMS)))), kotlin.Function1((com.motorro.rxlcemodel.base.LceState.Error((com.motorro.rxlcemodel.base.terminateOnError.DATA, com.motorro.rxlcemodel.base.terminateOnError.PARAMS)), kotlin.Boolean)))/predicate) returns true

### Parameters

`DATA` - Source model data type

`PARAMS` - Params type

`predicate` - A predicate to check error state. If predicate returns true, the stream
is terminated with [LceState.Error.error](../-lce-state/-error/error.md)