[com.motorro.rxlcemodel.base](../index.md) / [io.reactivex.rxjava3.core.Observable](index.md) / [getData](./get-data.md)

# getData

`fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](get-data.md#DATA)`>>.getData(terminateOnError: (`[`Error`](../-lce-state/-error/index.md)`<`[`DATA`](get-data.md#DATA)`>) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`DATA`](get-data.md#DATA)`>`

Returns model's data stream dropping state information

### Parameters

`DATA` - Source model data type

`terminateOnError` - A predicate to check error state. If predicate returns true, the stream
is terminated with [LceState.Error.error](../-lce-state/-error/error.md)