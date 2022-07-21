//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[LceUseCase](index.md)

# LceUseCase

[jvm]\
interface [LceUseCase](index.md)&lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

Base LCE use-case with [state](state.md) and [refresh](refresh.md)

## Parameters

jvm

| | |
|---|---|
| DATA | Data type of data being loaded |

## Properties

| Name | Summary |
|---|---|
| [refresh](refresh.md) | [jvm]<br>abstract val [refresh](refresh.md): Completable<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](state.md) | [jvm]<br>abstract val [state](state.md): Observable&lt;[LceState](../-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

## Inheritors

| Name |
|---|
| [LceModel](../-lce-model/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [map](../map.md) | [jvm]<br>fun &lt;[DATA_1](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](index.md)&lt;[DATA_1](../map.md)&gt;.[map](../map.md)(mapper: (data: [DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceUseCase](index.md)&lt;[DATA_2](../map.md)&gt;<br>Creates a use-case wrapper that converts [DATA_1](../map.md) to [DATA_2](../map.md) |
| [refreshed](../refreshed.md) | [jvm]<br>fun &lt;[DATA](../refreshed.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](index.md)&lt;[DATA](../refreshed.md)&gt;.[refreshed](../refreshed.md)(): [LceUseCase](index.md)&lt;[DATA](../refreshed.md)&gt;<br>Wraps use-case to refresh on each subscription |
| [withRefresh](../with-refresh.md) | [jvm]<br>fun &lt;[DATA](../with-refresh.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](index.md)&lt;[DATA](../with-refresh.md)&gt;.[withRefresh](../with-refresh.md)(refreshStream: Observable&lt;in [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)&gt;): Observable&lt;[LceState](../-lce-state/index.md)&lt;[DATA](../with-refresh.md)&gt;&gt;<br>Takes the [LceUseCase.state](state.md) of model that is being refreshed each time [refreshStream](../with-refresh.md) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../../../../base/com.motorro.rxlcemodel.base/-lce-model/refresh.md) property becomes invisible for the outside world |
