//[rx](../../../index.md)/[com.motorro.rxlcemodel.rx](../index.md)/[StrategyUpdateWrapper](index.md)/[StrategyUpdateWrapper](-strategy-update-wrapper.md)

# StrategyUpdateWrapper

[jvm]\
fun &lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [StrategyUpdateWrapper](-strategy-update-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, cacheService: [CacheService](../../com.motorro.rxlcemodel.rx.service/-cache-service/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?)

#### Parameters

jvm

| | |
|---|---|
| DATA | Data Type of data being held |
| PARAMS | Params type that identify data being loaded |
| upstream | LceModel that performs reading |
| cacheService | Data cache service that updates the same cache as [upstream](../../../../rx/com.motorro.rxlcemodel.rx/-strategy-update-wrapper/[60]init[62].md) uses |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |
