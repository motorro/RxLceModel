//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[CacheThenNetLceModel](index.md)

# CacheThenNetLceModel

[jvm]\
class [CacheThenNetLceModel](index.md)&lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(val params: [PARAMS](index.md), serviceSet: [ServiceSet](../../com.motorro.rxlcemodel.base.service/-service-set/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, startWith: Observable&lt;[LceState](../-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;, ioScheduler: Scheduler, logger: [Logger](../-logger/index.md)?) : [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt; 

A [LceModel](../-lce-model/index.md) which uses cache subscription as a 'source of truth'. When [state](state.md) is subscribed it loads cache data refreshing it if cache is stall or whenever cache returns empty [java.util.Optional](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html). The model always returns cached data first - then network if data is stall Cache service *must* notify of its data changes!

## Parameters

jvm

| | |
|---|---|
| DATA | Data type of data being held |
| PARAMS | Params type that identify data being loaded |
| params | Params that identify data being loaded |
| serviceSet | Data service-set |
| startWith | Observable that emits at loading start. Defaults to [LceState.Loading](../-lce-state/-loading/index.md) |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |

## Constructors

| | |
|---|---|
| [CacheThenNetLceModel](-cache-then-net-lce-model.md) | [jvm]<br>fun &lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [CacheThenNetLceModel](-cache-then-net-lce-model.md)(params: [PARAMS](index.md), serviceSet: [ServiceSet](../../com.motorro.rxlcemodel.base.service/-service-set/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, startWith: Observable&lt;[LceState](../-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;, ioScheduler: Scheduler, logger: [Logger](../-logger/index.md)?) |

## Properties

| Name | Summary |
|---|---|
| [params](params.md) | [jvm]<br>open override val [params](params.md): [PARAMS](index.md) |
| [refresh](refresh.md) | [jvm]<br>open override val [refresh](refresh.md): Completable<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](state.md) | [jvm]<br>open override val [state](state.md): Observable&lt;[LceState](../-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |
