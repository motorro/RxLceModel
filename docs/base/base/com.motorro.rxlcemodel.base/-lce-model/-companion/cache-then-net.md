//[base](../../../../index.md)/[com.motorro.rxlcemodel.base](../../index.md)/[LceModel](../index.md)/[Companion](index.md)/[cacheThenNet](cache-then-net.md)

# cacheThenNet

[jvm]\

@JvmOverloads

fun &lt;[DATA](cache-then-net.md) : Any, [PARAMS](cache-then-net.md) : Any&gt; [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), serviceSet: [ServiceSet](../../../com.motorro.rxlcemodel.base.service/-service-set/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, startWith: Observable&lt;[LceState](../../-lce-state/index.md)&lt;[DATA](cache-then-net.md)&gt;&gt; = Observable.empty(), ioScheduler: Scheduler = Schedulers.trampoline(), logger: [Logger](../../-logger/index.md)? = null): [LceModel](../index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;

Creates a model that returns cached data first, then refreshes if stall

## Parameters

jvm

| | |
|---|---|
| DATA | Data type of data being held |
| PARAMS | Params type that identify data being loaded |
| params | Params that identify data being loaded |
| serviceSet | Service-set to load data |
| startWith | Observable that emits at loading start. Defaults to [LceState.Loading](../../-lce-state/-loading/index.md) |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |

[jvm]\

@JvmOverloads

fun &lt;[DATA](cache-then-net.md) : Any, [PARAMS](cache-then-net.md) : Any&gt; [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), net: [NetService](../../../com.motorro.rxlcemodel.base.service/-net-service/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, cache: [CacheService](../../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, startWith: Observable&lt;[LceState](../../-lce-state/index.md)&lt;[DATA](cache-then-net.md)&gt;&gt; = Observable.empty(), ioScheduler: Scheduler = Schedulers.trampoline(), logger: [Logger](../../-logger/index.md)? = null): [LceModel](../index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;

Creates a model that returns cached data first, than refreshes if stall

## Parameters

jvm

| | |
|---|---|
| DATA | Data type of data being held |
| PARAMS | Params type that identify data being loaded |
| params | Params that identify data being loaded |
| net | Net-service |
| cache | Cache-service |
| startWith | Observable that emits at loading start. Defaults to [LceState.Loading](../../-lce-state/-loading/index.md) |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |
