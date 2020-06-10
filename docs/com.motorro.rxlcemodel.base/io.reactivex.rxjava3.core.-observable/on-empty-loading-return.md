[com.motorro.rxlcemodel.base](../index.md) / [io.reactivex.rxjava3.core.Observable](index.md) / [onEmptyLoadingReturn](./on-empty-loading-return.md)

# onEmptyLoadingReturn

`inline fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](on-empty-loading-return.md#DATA)`>>.onEmptyLoadingReturn(crossinline block: (`[`Loading`](../-lce-state/-loading/index.md)`<`[`DATA`](on-empty-loading-return.md#DATA)`>) -> `[`LceState`](../-lce-state/index.md)`<`[`DATA`](on-empty-loading-return.md#DATA)`>): `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](on-empty-loading-return.md#DATA)`>>`

Substitutes [LceState.Loading](../-lce-state/-loading/index.md) with empty data with state produced by [block](on-empty-loading-return.md#com.motorro.rxlcemodel.base$onEmptyLoadingReturn(io.reactivex.rxjava3.core.Observable((com.motorro.rxlcemodel.base.LceState((com.motorro.rxlcemodel.base.onEmptyLoadingReturn.DATA)))), kotlin.Function1((com.motorro.rxlcemodel.base.LceState.Loading((com.motorro.rxlcemodel.base.onEmptyLoadingReturn.DATA)), com.motorro.rxlcemodel.base.LceState(()))))/block)

### Parameters

`block` - transformation block

**Receiver**
LCE stream

