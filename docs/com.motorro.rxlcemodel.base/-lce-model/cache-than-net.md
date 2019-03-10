[com.motorro.rxlcemodel.base](../index.md) / [LceModel](index.md) / [cacheThanNet](./cache-than-net.md)

# cacheThanNet

`fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> cacheThanNet(params: `[`PARAMS`](cache-than-net.md#PARAMS)`, serviceSet: `[`ServiceSet`](../../com.motorro.rxlcemodel.base.service/-service-set/index.md)`<`[`DATA`](cache-than-net.md#DATA)`, `[`PARAMS`](cache-than-net.md#PARAMS)`>): `[`LceModel`](index.md)`<`[`DATA`](cache-than-net.md#DATA)`, `[`PARAMS`](cache-than-net.md#PARAMS)`>`

Creates a model that returns cached data first, than refreshes if stall

### Parameters

`DATA` - Data type of data being held

`PARAMS` - Params type that identify data being loaded

`params` - Params that identify data being loaded

`serviceSet` - Service-set to load data