//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines](../index.md)/[LceUseCase](index.md)

# LceUseCase

[common]\
interface [LceUseCase](index.md)&lt;[DATA](index.md) : Any&gt;

Base LCE use-case with [state](state.md) and [refresh](refresh.md)

#### Parameters

common

| | |
|---|---|
| DATA | Data type of data being loaded |

## Functions

| Name | Summary |
|---|---|
| [refresh](refresh.md) | [common]<br>abstract suspend fun [refresh](refresh.md)()<br>Requests a refresh of data. Data will be updated asynchronously |

## Properties

| Name | Summary |
|---|---|
| [state](state.md) | [common]<br>abstract val [state](state.md): Flow&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

## Inheritors

| Name |
|---|
| [LceModel](../-lce-model/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [map](../map.md) | [common]<br>fun &lt;[DATA_1](../map.md) : Any, [DATA_2](../map.md) : Any&gt; [LceUseCase](index.md)&lt;[DATA_1](../map.md)&gt;.[map](../map.md)(mapper: (data: [DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceUseCase](index.md)&lt;[DATA_2](../map.md)&gt;<br>Creates a use-case wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md) |
| [refreshed](../refreshed.md) | [common]<br>fun &lt;[DATA](../refreshed.md) : Any&gt; [LceUseCase](index.md)&lt;[DATA](../refreshed.md)&gt;.[refreshed](../refreshed.md)(): [LceUseCase](index.md)&lt;[DATA](../refreshed.md)&gt;<br>Wraps use-case to refresh on each subscription |
| [withRefresh](../with-refresh.md) | [common]<br>fun &lt;[DATA](../with-refresh.md) : Any&gt; [LceUseCase](index.md)&lt;[DATA](../with-refresh.md)&gt;.[withRefresh](../with-refresh.md)(refreshStream: Flow&lt;Any&gt;): Flow&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](../with-refresh.md)&gt;&gt;<br>Takes the [LceUseCase.state](state.md) of model that is being refreshed each time [refreshStream](../with-refresh.md) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../../../../coroutines/com.motorro.rxlcemodel.coroutines/-lce-model/refresh.md) property becomes invisible for the outside world |
