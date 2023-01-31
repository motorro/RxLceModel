//[rx](../../../index.md)/[com.motorro.rxlcemodel.rx](../index.md)/[CacheThenNetLceModel](index.md)

# CacheThenNetLceModel

[jvm]\
class [CacheThenNetLceModel](index.md)&lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(val params: [PARAMS](index.md), serviceSet: [ServiceSet](../../com.motorro.rxlcemodel.rx.service/-service-set/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, startWith: Observable&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;, ioScheduler: Scheduler, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?) : [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt; 

A [LceModel](../-lce-model/index.md) which uses cache subscription as a 'source of truth'. When [state](state.md) is subscribed it loads cache data refreshing it if cache is stall or whenever cache returns empty [java.util.Optional](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html). The model always returns cached data first - then network if data is stall Cache service *must* notify of its data changes!

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

## Constructors

| | |
|---|---|
| [CacheThenNetLceModel](-cache-then-net-lce-model.md) | [jvm]<br>fun &lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [CacheThenNetLceModel](-cache-then-net-lce-model.md)(params: [PARAMS](index.md), serviceSet: [ServiceSet](../../com.motorro.rxlcemodel.rx.service/-service-set/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, startWith: Observable&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;, ioScheduler: Scheduler, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?) |

## Properties

| Name | Summary |
|---|---|
| [params](params.md) | [jvm]<br>open override val [params](params.md): [PARAMS](index.md) |
| [refresh](refresh.md) | [jvm]<br>open override val [refresh](refresh.md): Completable<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](state.md) | [jvm]<br>open override val [state](state.md): Observable&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

## Extensions

| Name | Summary |
|---|---|
| [map](../map.md) | [jvm]<br>fun &lt;[DATA_1](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceModel](../-lce-model/index.md)&lt;[DATA_1](../map.md), [PARAMS](../map.md)&gt;.[map](../map.md)(mapper: (data: [DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceModel](../-lce-model/index.md)&lt;[DATA_2](../map.md), [PARAMS](../map.md)&gt;<br>Creates a model wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md)<br>[jvm]<br>fun &lt;[DATA_1](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA_1](../map.md)&gt;.[map](../map.md)(mapper: (data: [DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceUseCase](../-lce-use-case/index.md)&lt;[DATA_2](../map.md)&gt;<br>Creates a use-case wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md) |
| [refreshed](../refreshed.md) | [jvm]<br>fun &lt;[DATA](../refreshed.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../refreshed.md)&gt;.[refreshed](../refreshed.md)(): [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../refreshed.md)&gt;<br>Wraps use-case to refresh on each subscription |
| [withRefresh](../with-refresh.md) | [jvm]<br>fun &lt;[DATA](../with-refresh.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../with-refresh.md)&gt;.[withRefresh](../with-refresh.md)(refreshStream: Observable&lt;in [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)&gt;): Observable&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](../with-refresh.md)&gt;&gt;<br>Takes the [LceUseCase.state](../-lce-use-case/state.md) of model that is being refreshed each time [refreshStream](../with-refresh.md) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../../../../rx/com.motorro.rxlcemodel.rx/-lce-model/refresh.md) property becomes invisible for the outside world |
| [withUpdates](../with-updates.md) | [jvm]<br>fun &lt;[DATA](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [UPDATE](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceModel](../-lce-model/index.md)&lt;[DATA](../with-updates.md), [PARAMS](../with-updates.md)&gt;.[withUpdates](../with-updates.md)(serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.rx.service/-updating-service-set/index.md)&lt;[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)&gt;, ioScheduler: Scheduler = Schedulers.trampoline(), logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)? = null): [UpdatingLceModel](../-updating-lce-model/index.md)&lt;[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)&gt;<br>Wraps an [LceModel](../-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](../-updating-lce-model/index.md) |
