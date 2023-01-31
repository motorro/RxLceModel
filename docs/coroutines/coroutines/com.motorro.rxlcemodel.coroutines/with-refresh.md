//[coroutines](../../index.md)/[com.motorro.rxlcemodel.coroutines](index.md)/[withRefresh](with-refresh.md)

# withRefresh

[common]\
fun &lt;[DATA](with-refresh.md) : Any&gt; [LceUseCase](-lce-use-case/index.md)&lt;[DATA](with-refresh.md)&gt;.[withRefresh](with-refresh.md)(refreshStream: Flow&lt;Any&gt;): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](with-refresh.md)&gt;&gt;

Takes the [LceUseCase.state](-lce-use-case/state.md) of model that is being refreshed each time [refreshStream](with-refresh.md) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../../../coroutines/com.motorro.rxlcemodel.coroutines/-lce-model/refresh.md) property becomes invisible for the outside world

#### Receiver

Original model

#### Parameters

common

| | |
|---|---|
| DATA | Source model data type |
| refreshStream | Whenever this stream emits a value, the model is refreshed |
