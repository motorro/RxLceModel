//[rx](../../../index.md)/[com.motorro.rxlcemodel.rx](../index.md)/[CacheThenNetLceModel](index.md)/[CacheThenNetLceModel](-cache-then-net-lce-model.md)

# CacheThenNetLceModel

[jvm]\
fun &lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [CacheThenNetLceModel](-cache-then-net-lce-model.md)(params: [PARAMS](index.md), serviceSet: [ServiceSet](../../com.motorro.rxlcemodel.rx.service/-service-set/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, startWith: Observable&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;, ioScheduler: Scheduler, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?)

#### Parameters

jvm

| | |
|---|---|
| DATA | Data type of data being held |
| PARAMS | Params type that identify data being loaded |
| params | Params that identify data being loaded |
| serviceSet | Data service-set |
| startWith | Observable that emits at loading start. Defaults to [LceState.Loading](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md) |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |
