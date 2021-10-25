//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[LceModel](index.md)

# LceModel

[jvm]\
interface [LceModel](index.md)&lt;[DATA](index.md) : Any, [PARAMS](index.md) : Any&gt; : [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](index.md)&gt; 

A model interface to load data and transmit it to subscribers along with loading operation state

## Parameters

jvm

| | |
|---|---|
| DATA | Data type of data being loaded |
| PARAMS | Params type that identify data being loaded |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [params](params.md) | [jvm]<br>abstract val [params](params.md): [PARAMS](index.md)<br>Params that identify data being loaded |
| [refresh](../-lce-use-case/refresh.md) | [jvm]<br>abstract val [refresh](../-lce-use-case/refresh.md): Completable<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](../-lce-use-case/state.md) | [jvm]<br>abstract val [state](../-lce-use-case/state.md): Observable&lt;[LceState](../-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

## Inheritors

| Name |
|---|
| [CacheThenNetLceModel](../-cache-then-net-lce-model/index.md) |
| [UpdatingLceModel](../-updating-lce-model/index.md) |
| [UpdateWrapper](../-update-wrapper/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [map](../map.md) | [jvm]<br>fun &lt;[DATA_1](../map.md) : Any, [DATA_2](../map.md) : Any, [PARAMS](../map.md) : Any&gt; [LceModel](index.md)&lt;[DATA_1](../map.md), [PARAMS](../map.md)&gt;.[map](../map.md)(mapper: ([DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceModel](index.md)&lt;[DATA_2](../map.md), [PARAMS](../map.md)&gt;<br>Creates a model wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md) |
| [withUpdates](../with-updates.md) | [jvm]<br>fun &lt;[DATA](../with-updates.md) : Any, [UPDATE](../with-updates.md) : Any, [PARAMS](../with-updates.md) : Any&gt; [LceModel](index.md)&lt;[DATA](../with-updates.md), [PARAMS](../with-updates.md)&gt;.[withUpdates](../with-updates.md)(serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)&lt;[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)&gt;, ioScheduler: Scheduler = Schedulers.trampoline(), logger: [Logger](../-logger/index.md)? = null): [UpdatingLceModel](../-updating-lce-model/index.md)&lt;[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)&gt;<br>Wraps an [LceModel](index.md) to updating delegate creating an [UpdatingLceModel](../-updating-lce-model/index.md) |
