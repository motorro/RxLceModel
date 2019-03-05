[com.motorro.rxlcemodel.base](../index.md) / [CacheThenNetLceModel](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`CacheThenNetLceModel(params: `[`PARAMS`](index.md#PARAMS)`, serviceSet: `[`ServiceSet`](../../com.motorro.rxlcemodel.base.service/-service-set/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>)`

A [LceModel](../-lce-model/index.md) which uses cache subscription as a source of truth.
When [state](state.md) is subscribed it loads cache data refreshing it if cache is stall or whenever cache
returns [com.gojuno.koptional.None](#).
The model always returns cached data first - then network if data is stall
Cache service *must* notify of its data changes!

### Parameters

`DATA` - Data type of data being held

`PARAMS` - Params type that identify data being loaded

`params` - Params that identify data being loaded

`serviceSet` - Data service-set