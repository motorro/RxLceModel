//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines](../index.md)/[LceModel](index.md)

# LceModel

interface [LceModel](index.md)&lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](index.md)&gt; 

A model interface to load data and transmit it to subscribers along with loading operation state

#### Parameters

common

| | |
|---|---|
| DATA | Data type of data being loaded |
| PARAMS | Params type that identify data being loaded |

#### Inheritors

| |
|---|
| [CacheThenNetLceModel](../-cache-then-net-lce-model/index.md) |
| [UpdatingLceModel](../-updating-lce-model/index.md) |
| [UpdateWrapper](../-update-wrapper/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [params](params.md) | [common]<br>abstract val [params](params.md): [PARAMS](index.md)<br>Params that identify data being loaded |
| [state](../-lce-use-case/state.md) | [common]<br>abstract val [state](../-lce-use-case/state.md): Flow&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

## Functions

| Name | Summary |
|---|---|
| [map](../map.md) | [common]<br>fun &lt;[DATA_1](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceModel](index.md)&lt;[DATA_1](../map.md), [PARAMS](../map.md)&gt;.[map](../map.md)(mapper: (data: [DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceModel](index.md)&lt;[DATA_2](../map.md), [PARAMS](../map.md)&gt;<br>Creates a model wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md)<br>[common]<br>fun &lt;[DATA_1](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA_1](../map.md)&gt;.[map](../map.md)(mapper: (data: [DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceUseCase](../-lce-use-case/index.md)&lt;[DATA_2](../map.md)&gt;<br>Creates a use-case wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md) |
| [refresh](../-lce-use-case/refresh.md) | [common]<br>abstract suspend fun [refresh](../-lce-use-case/refresh.md)()<br>Requests a refresh of data. Data will be updated asynchronously |
| [refreshed](../refreshed.md) | [common]<br>fun &lt;[DATA](../refreshed.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../refreshed.md)&gt;.[refreshed](../refreshed.md)(): [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../refreshed.md)&gt;<br>Wraps use-case to refresh on each subscription |
| [withRefresh](../with-refresh.md) | [common]<br>fun &lt;[DATA](../with-refresh.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../with-refresh.md)&gt;.[withRefresh](../with-refresh.md)(refreshStream: Flow&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;): Flow&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](../with-refresh.md)&gt;&gt;<br>Takes the [LceUseCase.state](../-lce-use-case/state.md) of model that is being refreshed each time [refreshStream](../with-refresh.md) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../../../../coroutines/com.motorro.rxlcemodel.coroutines/-lce-model/refresh.md) property becomes invisible for the outside world |
| [withUpdates](../with-updates.md) | [common]<br>fun &lt;[DATA](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [UPDATE](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](../with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceModel](index.md)&lt;[DATA](../with-updates.md), [PARAMS](../with-updates.md)&gt;.[withUpdates](../with-updates.md)(serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.coroutines.service/-updating-service-set/index.md)&lt;[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)&gt;, ioDispatcher: CoroutineDispatcher = Dispatchers.Unconfined, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)? = null): [UpdatingLceModel](../-updating-lce-model/index.md)&lt;[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)&gt;<br>Wraps an [LceModel](index.md) to updating delegate creating an [UpdatingLceModel](../-updating-lce-model/index.md) |
