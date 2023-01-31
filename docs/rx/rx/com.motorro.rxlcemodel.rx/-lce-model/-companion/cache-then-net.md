//[rx](../../../../index.md)/[com.motorro.rxlcemodel.rx](../../index.md)/[LceModel](../index.md)/[Companion](index.md)/[cacheThenNet](cache-then-net.md)

# cacheThenNet

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)

fun &lt;[DATA](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), serviceSet: [ServiceSet](../../../com.motorro.rxlcemodel.rx.service/-service-set/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, startWith: Observable&lt;[LceState](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](cache-then-net.md)&gt;&gt; = Observable.empty(), ioScheduler: Scheduler = Schedulers.trampoline(), logger: [Logger](../../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)? = null): [LceModel](../index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;

Creates a model that returns cached data first, then refreshes if stall

#### Parameters

jvm

| | |
|---|---|
| DATA | Data type of data being held |
| PARAMS | Params type that identify data being loaded |
| params | Params that identify data being loaded |
| serviceSet | Service-set to load data |
| startWith | Observable that emits at loading start. Defaults to [LceState.Loading](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md) |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)

fun &lt;[DATA](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), net: [NetService](../../../com.motorro.rxlcemodel.rx.service/-net-service/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, cache: [CacheService](../../../com.motorro.rxlcemodel.rx.service/-cache-service/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, startWith: Observable&lt;[LceState](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](cache-then-net.md)&gt;&gt; = Observable.empty(), ioScheduler: Scheduler = Schedulers.trampoline(), logger: [Logger](../../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)? = null): [LceModel](../index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;

Creates a model that returns cached data first, than refreshes if stall

#### Parameters

jvm

| | |
|---|---|
| DATA | Data type of data being held |
| PARAMS | Params type that identify data being loaded |
| params | Params that identify data being loaded |
| net | Net-service |
| cache | Cache-service |
| startWith | Observable that emits at loading start. Defaults to [LceState.Loading](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md) |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |
