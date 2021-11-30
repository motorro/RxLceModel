//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[UpdatingLceModelWrapper](index.md)

# UpdatingLceModelWrapper

[jvm]\
class [UpdatingLceModelWrapper](index.md)&lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [UPDATE](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)&lt;[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../-logger/index.md)?) : [UpdateWrapper](../-update-wrapper/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt; , [UpdatingLceModel](../-updating-lce-model/index.md)&lt;[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)&gt; 

Wraps an [LceModel](../-lce-model/index.md) to enable simple data updates with the [UPDATE](index.md) structure (say a PUT operation) rather than individual property updates (PATCH operation). Implement [UpdateWrapper](../-update-wrapper/index.md) to achieve PATCH workflow

## See also

jvm

| | |
|---|---|
| [com.motorro.rxlcemodel.base.UpdateWrapper](../-update-wrapper/index.md) |  |

## Parameters

jvm

| | |
|---|---|
| DATA | Data Type of data being held |
| UPDATE | Update type |
| PARAMS | Params type that identify data being loaded |
| upstream | LceModel that performs reading |
| serviceSet | Data service-set. Note that cache service should update the same cache as [upstream](../../../../base/com.motorro.rxlcemodel.base/-updating-lce-model-wrapper/upstream.md) uses for things to work correctly |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |

## Constructors

| | |
|---|---|
| [UpdatingLceModelWrapper](-updating-lce-model-wrapper.md) | [jvm]<br>fun &lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [UPDATE](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [UpdatingLceModelWrapper](-updating-lce-model-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)&lt;[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../-logger/index.md)?) |

## Functions

| Name | Summary |
|---|---|
| [update](update.md) | [jvm]<br>open override fun [update](update.md)(update: [UPDATE](index.md)): Completable<br>Updates data on server and refreshes local data |

## Properties

| Name | Summary |
|---|---|
| [params](../-lce-model/params.md) | [jvm]<br>open override val [params](../-lce-model/params.md): [PARAMS](index.md)<br>Params that identify data being loaded |
| [refresh](../-lce-use-case/refresh.md) | [jvm]<br>open override val [refresh](../-lce-use-case/refresh.md): Completable<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](../-update-wrapper/state.md) | [jvm]<br>open override val [state](../-update-wrapper/state.md): Observable&lt;[LceState](../-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates Wrapper mixes the [upstream](../../../../base/com.motorro.rxlcemodel.base/-update-wrapper/upstream.md) emissions with update operation status. |
