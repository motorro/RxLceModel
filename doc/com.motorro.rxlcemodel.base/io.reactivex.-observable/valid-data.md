[com.motorro.rxlcemodel.base](../index.md) / [io.reactivex.Observable](index.md) / [validData](./valid-data.md)

# validData

`val <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](valid-data.md#DATA)`, `[`PARAMS`](valid-data.md#PARAMS)`>>.validData: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`DATA`](valid-data.md#DATA)`>`

Model's valid data stream with state information dropped.
Will terminate on any error

### Parameters

`DATA` - Source model data type

`PARAMS` - Params type