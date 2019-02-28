[com.motorro.rxlcemodel.base](../index.md) / [UpdatingLceModelWrapper](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`UpdatingLceModelWrapper(upstream: `[`LceModel`](../-lce-model/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>, serviceSet: `[`UpdatingServiceSet`](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)`<`[`DATA`](index.md#DATA)`, `[`UPDATE`](index.md#UPDATE)`, `[`PARAMS`](index.md#PARAMS)`>)`

Wraps an [LceModel](../-lce-model/index.md) to enable simple data updates with the [UPDATE](index.md#UPDATE) structure
(say a PUT operation) rather than individual property updates (PATCH operation).
Implement [UpdateWrapper](../-update-wrapper/index.md) to achieve PATCH workflow

### Parameters

`DATA` - Data Type of data being held

`UPDATE` - Update type

`PARAMS` - Params type that identify data being loaded

`upstream` - LceModel that performs reading

`serviceSet` - Data service-set. Note that cache service should update the
same cache as [upstream](#) uses for things to work correctly

**See Also**

[UpdateWrapper](../-update-wrapper/index.md)

