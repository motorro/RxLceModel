//[base](../../index.md)/[com.motorro.rxlcemodel.base](index.md)/[withUpdates](with-updates.md)

# withUpdates

[jvm]\
fun &lt;[DATA](with-updates.md) : Any, [UPDATE](with-updates.md) : Any, [PARAMS](with-updates.md) : Any&gt; [LceModel](-lce-model/index.md)&lt;[DATA](with-updates.md), [PARAMS](with-updates.md)&gt;.[withUpdates](with-updates.md)(serviceSet: [UpdatingServiceSet](../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)&lt;[DATA](with-updates.md), [UPDATE](with-updates.md), [PARAMS](with-updates.md)&gt;, ioScheduler: Scheduler = Schedulers.trampoline(), logger: [Logger](-logger/index.md)? = null): [UpdatingLceModel](-updating-lce-model/index.md)&lt;[DATA](with-updates.md), [UPDATE](with-updates.md), [PARAMS](with-updates.md)&gt;

Wraps an [LceModel](-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](-updating-lce-model/index.md)

#### Receiver

LceModel that performs reading

## Parameters

jvm

| | |
|---|---|
| DATA | Data type of data being held |
| UPDATE | Update type |
| PARAMS | Params type that identify data being loaded |
| serviceSet | Service-set to load data |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |
