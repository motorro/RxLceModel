//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[UpdateWrapper](index.md)

# UpdateWrapper

[jvm]\
abstract class [UpdateWrapper](index.md)&lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, cacheService: [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../-logger/index.md)?) : [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt; 

A base class that wraps [LceModel](../-lce-model/index.md) and mixes in a data update state Extend to build models that patch some properties and load the whole data structure as a result Implement methods to update properties using [doUpdate](../../../../base/com.motorro.rxlcemodel.base/-update-wrapper/do-update.md) template

## Parameters

jvm

| | |
|---|---|
| DATA | Data Type of data being held |
| PARAMS | Params type that identify data being loaded |
| upstream | LceModel that performs reading |
| cacheService | Data cache service that updates the same cache as [upstream](../../../../base/com.motorro.rxlcemodel.base/-update-wrapper/upstream.md) uses |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |

## Constructors

| | |
|---|---|
| [UpdateWrapper](-update-wrapper.md) | [jvm]<br>fun &lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [UpdateWrapper](-update-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, cacheService: [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../-logger/index.md)?) |

## Properties

| Name | Summary |
|---|---|
| [params](../-lce-model/params.md) | [jvm]<br>open override val [params](../-lce-model/params.md): [PARAMS](index.md)<br>Params that identify data being loaded |
| [refresh](../-lce-use-case/refresh.md) | [jvm]<br>open override val [refresh](../-lce-use-case/refresh.md): Completable<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](state.md) | [jvm]<br>open override val [state](state.md): Observable&lt;[LceState](../-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates Wrapper mixes the [upstream](../../../../base/com.motorro.rxlcemodel.base/-update-wrapper/upstream.md) emissions with update operation status. |

## Inheritors

| Name |
|---|
| [StrategyUpdateWrapper](../-strategy-update-wrapper/index.md) |
| [UpdatingLceModelWrapper](../-updating-lce-model-wrapper/index.md) |
