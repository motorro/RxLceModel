//[rx](../../../index.md)/[com.motorro.rxlcemodel.rx](../index.md)/[UpdatingLceModelWrapper](index.md)/[UpdatingLceModelWrapper](-updating-lce-model-wrapper.md)

# UpdatingLceModelWrapper

[jvm]\
constructor(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.rx.service/-updating-service-set/index.md)&lt;[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?)

#### Parameters

jvm

| | |
|---|---|
| DATA | Data Type of data being held |
| UPDATE | Update type |
| PARAMS | Params type that identify data being loaded |
| upstream | LceModel that performs reading |
| serviceSet | Data service-set. Note that cache service should update the same cache as [upstream](../../../../rx/com.motorro.rxlcemodel.rx/-updating-lce-model-wrapper/[60]init[62].md) uses for things to work correctly |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |
