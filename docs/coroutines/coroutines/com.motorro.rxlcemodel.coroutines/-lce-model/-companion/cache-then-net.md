//[coroutines](../../../../index.md)/[com.motorro.rxlcemodel.coroutines](../../index.md)/[LceModel](../index.md)/[Companion](index.md)/[cacheThenNet](cache-then-net.md)

# cacheThenNet

[common]\

@JvmOverloads

fun &lt;[DATA](cache-then-net.md) : Any, [PARAMS](cache-then-net.md) : Any&gt; [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), serviceSet: [ServiceSet](../../../com.motorro.rxlcemodel.coroutines.service/-service-set/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, startWith: Flow&lt;[LceState](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](cache-then-net.md)&gt;&gt; = emptyFlow(), ioDispatcher: CoroutineDispatcher = Dispatchers.Unconfined, logger: [Logger](../../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)? = null): [LceModel](../index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;

Creates a model that returns cached data first, then refreshes if stall

#### Parameters

common

| | |
|---|---|
| DATA | Data type of data being held |
| PARAMS | Params type that identify data being loaded |
| params | Params that identify data being loaded |
| serviceSet | Service-set to load data |
| startWith | Observable that emits at loading start. Defaults to [LceState.Loading](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md) |
| ioDispatcher | Scheduler to run IO operations |
| logger | Logging function |

[common]\

@JvmOverloads

fun &lt;[DATA](cache-then-net.md) : Any, [PARAMS](cache-then-net.md) : Any&gt; [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), net: [NetService](../../../com.motorro.rxlcemodel.coroutines.service/-net-service/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, cache: [CacheService](../../../com.motorro.rxlcemodel.coroutines.service/-cache-service/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, startWith: Flow&lt;[LceState](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](cache-then-net.md)&gt;&gt; = emptyFlow(), ioDispatcher: CoroutineDispatcher = Dispatchers.Unconfined, logger: [Logger](../../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)? = null): [LceModel](../index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;

Creates a model that returns cached data first, than refreshes if stall

#### Parameters

common

| | |
|---|---|
| DATA | Data type of data being held |
| PARAMS | Params type that identify data being loaded |
| params | Params that identify data being loaded |
| net | Net-service |
| cache | Cache-service |
| startWith | Observable that emits at loading start. Defaults to [LceState.Loading](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md) |
| ioDispatcher | Scheduler to run IO operations |
| logger | Logging function |
