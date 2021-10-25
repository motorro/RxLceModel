//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[UpdatingLceModel](index.md)

# UpdatingLceModel

[jvm]\
interface [UpdatingLceModel](index.md)&lt;[DATA](index.md) : Any, in [UPDATE](index.md) : Any, [PARAMS](index.md) : Any&gt; : [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt; 

[LceModel](../-lce-model/index.md) extension that can [update](update.md) data

## Parameters

jvm

| | |
|---|---|
| DATA | Data type of data being held |
| UPDATE | Update type |
| PARAMS | Params type that identify data being loaded |

## Functions

| Name | Summary |
|---|---|
| [update](update.md) | [jvm]<br>abstract fun [update](update.md)(update: [UPDATE](index.md)): Completable<br>Updates data on server and refreshes local data |

## Properties

| Name | Summary |
|---|---|
| [params](../-lce-model/params.md) | [jvm]<br>abstract val [params](../-lce-model/params.md): [PARAMS](index.md)<br>Params that identify data being loaded |
| [refresh](../-lce-use-case/refresh.md) | [jvm]<br>abstract val [refresh](../-lce-use-case/refresh.md): Completable<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](../-lce-use-case/state.md) | [jvm]<br>abstract val [state](../-lce-use-case/state.md): Observable&lt;[LceState](../-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates |

## Inheritors

| Name |
|---|
| [UpdatingLceModelWrapper](../-updating-lce-model-wrapper/index.md) |
