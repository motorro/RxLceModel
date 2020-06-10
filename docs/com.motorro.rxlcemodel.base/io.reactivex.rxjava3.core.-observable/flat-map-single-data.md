[com.motorro.rxlcemodel.base](../index.md) / [io.reactivex.rxjava3.core.Observable](index.md) / [flatMapSingleData](./flat-map-single-data.md)

# flatMapSingleData

`fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA_1`](flat-map-single-data.md#DATA_1)`>>.flatMapSingleData(mapper: (data: `[`DATA_1`](flat-map-single-data.md#DATA_1)`) -> `[`Single`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Single.html)`<`[`DATA_2`](flat-map-single-data.md#DATA_2)`>): `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA_2`](flat-map-single-data.md#DATA_2)`>>`

Maps each [DATA_1](flat-map-single-data.md#DATA_1) to single for [DATA_2](flat-map-single-data.md#DATA_2) and merges back to LceState.
If error occurs in [mapper](flat-map-single-data.md#com.motorro.rxlcemodel.base$flatMapSingleData(io.reactivex.rxjava3.core.Observable((com.motorro.rxlcemodel.base.LceState((com.motorro.rxlcemodel.base.flatMapSingleData.DATA_1)))), kotlin.Function1((com.motorro.rxlcemodel.base.flatMapSingleData.DATA_1, io.reactivex.rxjava3.core.Single((com.motorro.rxlcemodel.base.flatMapSingleData.DATA_2)))))/mapper) emits [LceState.Error](../-lce-state/-error/index.md).
Example: load some [DATA_2](flat-map-single-data.md#DATA_2) from server using original [DATA_1](flat-map-single-data.md#DATA_1) as a parameter.

### Parameters

`DATA_1` - Source data type

`DATA_2` - Resulting data type

`mapper` - Data mapper