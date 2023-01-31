//[rx](../../../index.md)/[com.motorro.rxlcemodel.rx](../index.md)/[UpdateWrapper](index.md)

# UpdateWrapper

[jvm]\
abstract class [UpdateWrapper](index.md)&lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, cacheService: [CacheService](../../com.motorro.rxlcemodel.rx.service/-cache-service/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?) : [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt; 

A base class that wraps [LceModel](../-lce-model/index.md) and mixes in a data update state Extend to build models that patch some properties and load the whole data structure as a result Implement methods to update properties using [doUpdate](../../../../rx/com.motorro.rxlcemodel.rx/-update-wrapper/do-update.md) template

#### Parameters

jvm

| | |
|---|---|
| DATA | Data Type of data being held |
| PARAMS | Params type that identify data being loaded |
| upstream | LceModel that performs reading |
| cacheService | Data cache service that updates the same cache as [upstream](../../../../rx/com.motorro.rxlcemodel.rx/-update-wrapper/upstream.md) uses |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |

## Constructors

| | |
|---|---|
| [UpdateWrapper](-update-wrapper.md) | [jvm]<br>fun &lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [UpdateWrapper](-update-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, cacheService: [CacheService](../../com.motorro.rxlcemodel.rx.service/-cache-service/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?) |

## Properties

| Name | Summary |
|---|---|
| [params](../-lce-model/params.md) | [jvm]<br>open override val [params](../-lce-model/params.md): [PARAMS](index.md)<br>Params that identify data being loaded |
| [refresh](../-lce-use-case/refresh.md) | [jvm]<br>open override val [refresh](../-lce-use-case/refresh.md): Completable<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](state.md) | [jvm]<br>open override val [state](state.md): Observable&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates Wrapper mixes the [upstream](../../../../rx/com.motorro.rxlcemodel.rx/-update-wrapper/upstream.md) emissions with update operation status. |

## Inheritors

| Name |
|---|
| [StrategyUpdateWrapper](../-strategy-update-wrapper/index.md) |
| [UpdatingLceModelWrapper](../-updating-lce-model-wrapper/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [map](../map.md) | [jvm]<br>fun &lt;[DATA_1](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceModel](../-lce-model/index.md)&lt;[DATA_1](../map.md), [PARAMS](../map.md)&gt;.[map](../map.md)(mapper: (data: [DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceModel](../-lce-model/index.md)&lt;[DATA_2](../map.md), [PARAMS](../map.md)&gt;<br>Creates a model wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md)<br>[jvm]<br>fun &lt;[DATA_1](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA_1](../map.md)&gt;.[map](../map.md)(mapper: (data: [DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceUseCase](../-lce-use-case/index.md)&lt;[DATA_2](../map.md)&gt;<br>Creates a use-case wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md) |
| [refreshed](../refreshed.md) | [jvm]<br>fun &lt;[DATA](../refreshed.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../refreshed.md)&gt;.[refreshed](../refreshed.md)(): [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../refreshed.md)&gt;<br>Wraps use-case to refresh on each subscription |
| [withRefresh](../with-refresh.md) | [jvm]<br>fun &lt;[DATA](../with-refresh.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../with-refresh.md)&gt;.[withRefresh](../with-refresh.md)(refreshStream: Observable&lt;in [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)&gt;): Observable&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](../with-refresh.md)&gt;&gt;<br>Takes the [LceUseCase.state](../-lce-use-case/state.md) of model that is being refreshed each time [refreshStream](../with-refresh.md) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../../../../rx/com.motorro.rxlcemodel.rx/-lce-model/refresh.md) property becomes invisible for the outside world |
| [withUpdates](../with-updates.md) | [jvm]<br>fun &lt;[DATA](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [UPDATE](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceModel](../-lce-model/index.md)&lt;[DATA](../with-updates.md), [PARAMS](../with-updates.md)&gt;.[withUpdates](../with-updates.md)(serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.rx.service/-updating-service-set/index.md)&lt;[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)&gt;, ioScheduler: Scheduler = Schedulers.trampoline(), logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)? = null): [UpdatingLceModel](../-updating-lce-model/index.md)&lt;[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)&gt;<br>Wraps an [LceModel](../-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](../-updating-lce-model/index.md) |
