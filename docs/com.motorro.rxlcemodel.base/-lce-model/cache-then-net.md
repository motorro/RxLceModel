[com.motorro.rxlcemodel.base](../index.md) / [LceModel](index.md) / [cacheThenNet](./cache-then-net.md)

# cacheThenNet

`@JvmOverloads fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> cacheThenNet(params: `[`PARAMS`](cache-then-net.md#PARAMS)`, serviceSet: `[`ServiceSet`](../../com.motorro.rxlcemodel.base.service/-service-set/index.md)`<`[`DATA`](cache-then-net.md#DATA)`, `[`PARAMS`](cache-then-net.md#PARAMS)`>, startWith: `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](cache-then-net.md#DATA)`>> = Observable.just(Loading(null, false))): `[`LceModel`](index.md)`<`[`DATA`](cache-then-net.md#DATA)`, `[`PARAMS`](cache-then-net.md#PARAMS)`>`

Creates a model that returns cached data first, then refreshes if stall

### Parameters

`DATA` - Data type of data being held

`PARAMS` - Params type that identify data being loaded

`params` - Params that identify data being loaded

`serviceSet` - Service-set to load data

`startWith` - Observable that emits at loading start. Defaults to [LceState.Loading](../-lce-state/-loading/index.md)`@JvmOverloads fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> cacheThenNet(params: `[`PARAMS`](cache-then-net.md#PARAMS)`, net: `[`NetService`](../../com.motorro.rxlcemodel.base.service/-net-service/index.md)`<`[`DATA`](cache-then-net.md#DATA)`, `[`PARAMS`](cache-then-net.md#PARAMS)`>, cache: `[`CacheService`](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)`<`[`DATA`](cache-then-net.md#DATA)`, `[`PARAMS`](cache-then-net.md#PARAMS)`>, startWith: `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](cache-then-net.md#DATA)`>> = Observable.just(Loading(null, false))): `[`LceModel`](index.md)`<`[`DATA`](cache-then-net.md#DATA)`, `[`PARAMS`](cache-then-net.md#PARAMS)`>`

Creates a model that returns cached data first, than refreshes if stall

### Parameters

`DATA` - Data type of data being held

`PARAMS` - Params type that identify data being loaded

`params` - Params that identify data being loaded

`net` - Net-service

`cache` - Cache-service

`startWith` - Observable that emits at loading start. Defaults to [LceState.Loading](../-lce-state/-loading/index.md)