[com.motorro.rxlcemodel.base](../index.md) / [io.reactivex.Observable](index.md) / [dataStopOnEmptyErrors](./data-stop-on-empty-errors.md)

# dataStopOnEmptyErrors

`val <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](data-stop-on-empty-errors.md#DATA)`>>.dataStopOnEmptyErrors: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`DATA`](data-stop-on-empty-errors.md#DATA)`>`

Model's data stream with state information dropped.
Will terminate on errors with empty data

### Parameters

`DATA` - Source model data type