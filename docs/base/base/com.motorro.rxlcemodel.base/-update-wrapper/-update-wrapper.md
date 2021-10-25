//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[UpdateWrapper](index.md)/[UpdateWrapper](-update-wrapper.md)

# UpdateWrapper

[jvm]\
fun &lt;[DATA](index.md) : Any, [PARAMS](index.md) : Any&gt; [UpdateWrapper](-update-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, cacheService: [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../-logger/index.md)?)

## Parameters

jvm

| | |
|---|---|
| DATA | Data Type of data being held |
| PARAMS | Params type that identify data being loaded |
| upstream | LceModel that performs reading |
| cacheService | Data cache service that updates the same cache as [upstream](../../../../base/com.motorro.rxlcemodel.base/-update-wrapper/[60]init[62].md) uses |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |
