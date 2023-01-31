//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines](../index.md)/[UpdatingLceModelWrapper](index.md)

# UpdatingLceModelWrapper

[common]\
class [UpdatingLceModelWrapper](index.md)&lt;[DATA](index.md) : Any, in [UPDATE](index.md) : Any, [PARAMS](index.md) : Any&gt;(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.coroutines.service/-updating-service-set/index.md)&lt;[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)&gt;, ioDispatcher: CoroutineDispatcher, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?) : [UpdateWrapper](../-update-wrapper/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt; , [UpdatingLceModel](../-updating-lce-model/index.md)&lt;[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)&gt; 

Wraps an [LceModel](../-lce-model/index.md) to enable simple data updates with the [UPDATE](index.md) structure (say a PUT operation) rather than individual property updates (PATCH operation). Implement [UpdateWrapper](../-update-wrapper/index.md) to achieve PATCH workflow

#### See also

common

| |
|---|
| [UpdateWrapper](../-update-wrapper/index.md) |

#### Parameters

common

| | |
|---|---|
| DATA | Data Type of data being held |
| UPDATE | Update type |
| PARAMS | Params type that identify data being loaded |
| upstream | LceModel that performs reading |
| serviceSet | Data service-set. Note that cache service should update the same cache as [upstream](../../../../coroutines/com.motorro.rxlcemodel.coroutines/-updating-lce-model-wrapper/upstream.md) uses for things to work correctly |
| ioDispatcher | Scheduler to run IO operations |
| logger | Logging function |

## Constructors

| | |
|---|---|
| [UpdatingLceModelWrapper](-updating-lce-model-wrapper.md) | [common]<br>fun &lt;[DATA](index.md) : Any, in [UPDATE](index.md) : Any, [PARAMS](index.md) : Any&gt; [UpdatingLceModelWrapper](-updating-lce-model-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.coroutines.service/-updating-service-set/index.md)&lt;[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)&gt;, ioDispatcher: CoroutineDispatcher, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?) |

## Functions

| Name | Summary |
|---|---|
| [refresh](../-lce-use-case/refresh.md) | [common]<br>open suspend override fun [refresh](../-lce-use-case/refresh.md)()<br>Requests a refresh of data. Data will be updated asynchronously |
| [update](update.md) | [common]<br>open suspend override fun [update](update.md)(update: [UPDATE](index.md))<br>Updates data on server and refreshes local data |

## Properties

| Name | Summary |
|---|---|
| [params](../-lce-model/params.md) | [common]<br>open override val [params](../-lce-model/params.md): [PARAMS](index.md)<br>Params that identify data being loaded |
| [state](../-update-wrapper/state.md) | [common]<br>open override val [state](../-update-wrapper/state.md): Flow&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates Wrapper mixes the [upstream](../../../../coroutines/com.motorro.rxlcemodel.coroutines/-update-wrapper/upstream.md) emissions with update operation status. |

## Extensions

| Name | Summary |
|---|---|
| [map](../map.md) | [common]<br>fun &lt;[DATA_1](../map.md) : Any, [DATA_2](../map.md) : Any, [PARAMS](../map.md) : Any&gt; [LceModel](../-lce-model/index.md)&lt;[DATA_1](../map.md), [PARAMS](../map.md)&gt;.[map](../map.md)(mapper: (data: [DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceModel](../-lce-model/index.md)&lt;[DATA_2](../map.md), [PARAMS](../map.md)&gt;<br>Creates a model wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md)<br>[common]<br>fun &lt;[DATA_1](../map.md) : Any, [DATA_2](../map.md) : Any&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA_1](../map.md)&gt;.[map](../map.md)(mapper: (data: [DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceUseCase](../-lce-use-case/index.md)&lt;[DATA_2](../map.md)&gt;<br>Creates a use-case wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md) |
| [refreshed](../refreshed.md) | [common]<br>fun &lt;[DATA](../refreshed.md) : Any&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../refreshed.md)&gt;.[refreshed](../refreshed.md)(): [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../refreshed.md)&gt;<br>Wraps use-case to refresh on each subscription |
| [withRefresh](../with-refresh.md) | [common]<br>fun &lt;[DATA](../with-refresh.md) : Any&gt; [LceUseCase](../-lce-use-case/index.md)&lt;[DATA](../with-refresh.md)&gt;.[withRefresh](../with-refresh.md)(refreshStream: Flow&lt;Any&gt;): Flow&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](../with-refresh.md)&gt;&gt;<br>Takes the [LceUseCase.state](../-lce-use-case/state.md) of model that is being refreshed each time [refreshStream](../with-refresh.md) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../../../../coroutines/com.motorro.rxlcemodel.coroutines/-lce-model/refresh.md) property becomes invisible for the outside world |
| [withUpdates](../with-updates.md) | [common]<br>fun &lt;[DATA](../with-updates.md) : Any, [UPDATE](../with-updates.md) : Any, [PARAMS](../with-updates.md) : Any&gt; [LceModel](../-lce-model/index.md)&lt;[DATA](../with-updates.md), [PARAMS](../with-updates.md)&gt;.[withUpdates](../with-updates.md)(serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.coroutines.service/-updating-service-set/index.md)&lt;[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)&gt;, ioDispatcher: CoroutineDispatcher = Dispatchers.Unconfined, logger: [Logger](../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)? = null): [UpdatingLceModel](../-updating-lce-model/index.md)&lt;[DATA](../with-updates.md), [UPDATE](../with-updates.md), [PARAMS](../with-updates.md)&gt;<br>Wraps an [LceModel](../-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](../-updating-lce-model/index.md) |
