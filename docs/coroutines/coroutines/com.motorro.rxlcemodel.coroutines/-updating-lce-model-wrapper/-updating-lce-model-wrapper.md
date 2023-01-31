//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines](../index.md)/[UpdatingLceModelWrapper](index.md)/[UpdatingLceModelWrapper](-updating-lce-model-wrapper.md)

# UpdatingLceModelWrapper

[common]\
fun &lt;[DATA](index.md) : Any, in [UPDATE](index.md) : Any, [PARAMS](index.md) : Any&gt; [UpdatingLceModelWrapper](-updating-lce-model-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.coroutines.service/-updating-service-set/index.md)&lt;[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)&gt;, ioDispatcher: CoroutineDispatcher, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?)

#### Parameters

common

| | |
|---|---|
| DATA | Data Type of data being held |
| UPDATE | Update type |
| PARAMS | Params type that identify data being loaded |
| upstream | LceModel that performs reading |
| serviceSet | Data service-set. Note that cache service should update the same cache as [upstream](../../../../coroutines/com.motorro.rxlcemodel.coroutines/-updating-lce-model-wrapper/[60]init[62].md) uses for things to work correctly |
| ioDispatcher | Scheduler to run IO operations |
| logger | Logging function |
