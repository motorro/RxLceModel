//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[UpdatingLceModelWrapper](index.md)/[UpdatingLceModelWrapper](-updating-lce-model-wrapper.md)

# UpdatingLceModelWrapper

[jvm]\
fun &lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [UPDATE](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [UpdatingLceModelWrapper](-updating-lce-model-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)&lt;[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../-logger/index.md)?)

## Parameters

jvm

| | |
|---|---|
| DATA | Data Type of data being held |
| UPDATE | Update type |
| PARAMS | Params type that identify data being loaded |
| upstream | LceModel that performs reading |
| serviceSet | Data service-set. Note that cache service should update the same cache as [upstream](../../../../base/com.motorro.rxlcemodel.base/-updating-lce-model-wrapper/[60]init[62].md) uses for things to work correctly |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |
