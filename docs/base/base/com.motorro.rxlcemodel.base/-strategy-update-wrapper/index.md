//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[StrategyUpdateWrapper](index.md)

# StrategyUpdateWrapper

[jvm]\
class [StrategyUpdateWrapper](index.md)&lt;[DATA](index.md) : Any, [PARAMS](index.md) : Any&gt;(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, cacheService: [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../-logger/index.md)?) : [UpdateWrapper](../-update-wrapper/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt; 

Wraps [LceModel](../-lce-model/index.md) and mixes in a data update state Use to build models that patch some properties and load the whole data structure as a result Implement methods to update properties using [doUpdate](../../../../base/com.motorro.rxlcemodel.base/-strategy-update-wrapper/do-update.md) template

## Parameters

jvm

| | |
|---|---|
| DATA | Data Type of data being held |
| PARAMS | Params type that identify data being loaded |
| upstream | LceModel that performs reading |
| cacheService | Data cache service that updates the same cache as [upstream](../../../../base/com.motorro.rxlcemodel.base/-strategy-update-wrapper/upstream.md) uses |
| ioScheduler | Scheduler to run IO operations |
| logger | Logging function |

## Constructors

| | |
|---|---|
| [StrategyUpdateWrapper](-strategy-update-wrapper.md) | [jvm]<br>fun &lt;[DATA](index.md) : Any, [PARAMS](index.md) : Any&gt; [StrategyUpdateWrapper](-strategy-update-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, cacheService: [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)&lt;[DATA](index.md), [PARAMS](index.md)&gt;, ioScheduler: Scheduler, logger: [Logger](../-logger/index.md)?) |

## Functions

| Name | Summary |
|---|---|
| [update](update.md) | [jvm]<br>fun [update](update.md)(dataSource: ([PARAMS](index.md)) -&gt; Single&lt;out [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[DATA](index.md)&gt;&gt;): Completable<br>Creates a cache-update operation that gets data from [dataSource](update.md) and saves to cache. The completable updates [networkOperationState](../../../../base/com.motorro.rxlcemodel.base/-strategy-update-wrapper/network-operation-state.md) to mix state to original [upstream](../../../../base/com.motorro.rxlcemodel.base/-strategy-update-wrapper/upstream.md) |

## Properties

| Name | Summary |
|---|---|
| [params](../-lce-model/params.md) | [jvm]<br>open override val [params](../-lce-model/params.md): [PARAMS](index.md)<br>Params that identify data being loaded |
| [refresh](../-lce-use-case/refresh.md) | [jvm]<br>open override val [refresh](../-lce-use-case/refresh.md): Completable<br>Requests a refresh of data. Data will be updated asynchronously |
| [state](../-update-wrapper/state.md) | [jvm]<br>open override val [state](../-update-wrapper/state.md): Observable&lt;[LceState](../-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates Wrapper mixes the [upstream](../../../../base/com.motorro.rxlcemodel.base/-update-wrapper/upstream.md) emissions with update operation status. |
