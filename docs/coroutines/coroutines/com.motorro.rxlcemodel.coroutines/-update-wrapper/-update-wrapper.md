//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines](../index.md)/[UpdateWrapper](index.md)/[UpdateWrapper](-update-wrapper.md)

# UpdateWrapper

[common]\
fun &lt;[DATA](index.md) : Any, [PARAMS](index.md) : Any&gt; [UpdateWrapper](-update-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, cacheService: [CacheService](../../com.motorro.rxlcemodel.coroutines.service/-cache-service/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, ioDispatcher: CoroutineDispatcher, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?)

#### Parameters

common

| | |
|---|---|
| DATA | Data Type of data being held |
| PARAMS | Params type that identify data being loaded |
| upstream | LceModel that performs reading |
| cacheService | Data cache service that updates the same cache as [upstream](../../../../coroutines/com.motorro.rxlcemodel.coroutines/-update-wrapper/[60]init[62].md) uses |
| ioDispatcher | Scheduler to run IO operations |
| logger | Logging function |
