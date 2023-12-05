//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines](../index.md)/[CacheThenNetLceModel](index.md)/[CacheThenNetLceModel](-cache-then-net-lce-model.md)

# CacheThenNetLceModel

[common]\
constructor(params: [PARAMS](index.md), serviceSet: [ServiceSet](../../com.motorro.rxlcemodel.coroutines.service/-service-set/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, startWith: Flow&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;, ioDispatcher: CoroutineDispatcher, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?)

#### Parameters

common

| | |
|---|---|
| DATA | Data type of data being held |
| PARAMS | Params type that identify data being loaded |
| params | Params that identify data being loaded |
| serviceSet | Data service-set |
| startWith | Observable that emits at loading start. Defaults to [LceState.Loading](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md) |
| ioDispatcher | Scheduler to run IO operations |
| logger | Logging function |
