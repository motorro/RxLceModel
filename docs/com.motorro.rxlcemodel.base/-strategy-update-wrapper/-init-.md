[com.motorro.rxlcemodel.base](../index.md) / [StrategyUpdateWrapper](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`StrategyUpdateWrapper(upstream: `[`LceModel`](../-lce-model/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>, cacheService: `[`CacheService`](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>)`

Wraps [LceModel](../-lce-model/index.md) and mixes in a data update state
Use to build models that patch some properties and load the whole data structure as a result
Implement methods to update properties using [doUpdate](../-update-wrapper/do-update.md) template

### Parameters

`DATA` - Data Type of data being held

`PARAMS` - Params type that identify data being loaded

`upstream` - LceModel that performs reading

`cacheService` - Data cache service that updates the same cache as [upstream](#) uses