[com.motorro.rxlcemodel.base](../index.md) / [io.reactivex.rxjava3.core.Observable](index.md) / [terminateOnError](./terminate-on-error.md)

# terminateOnError

`fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](terminate-on-error.md#DATA)`>>.terminateOnError(predicate: (`[`Error`](../-lce-state/-error/index.md)`<`[`DATA`](terminate-on-error.md#DATA)`>) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](terminate-on-error.md#DATA)`>>`

Terminates [LceModel.state](../-lce-use-case/state.md) stream if [predicate](terminate-on-error.md#com.motorro.rxlcemodel.base$terminateOnError(io.reactivex.rxjava3.core.Observable((com.motorro.rxlcemodel.base.LceState((com.motorro.rxlcemodel.base.terminateOnError.DATA)))), kotlin.Function1((com.motorro.rxlcemodel.base.LceState.Error((com.motorro.rxlcemodel.base.terminateOnError.DATA)), kotlin.Boolean)))/predicate) returns true

### Parameters

`DATA` - Source model data type

`predicate` - A predicate to check error state. If predicate returns true, the stream
is terminated with [LceState.Error.error](../-lce-state/-error/error.md)