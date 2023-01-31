//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines](../index.md)/[StrategyUpdateWrapper](index.md)/[update](update.md)

# update

[common]\
suspend fun [update](update.md)(dataSource: suspend (params: [PARAMS](index.md)) -&gt; [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[DATA](index.md)&gt;)

Creates a cache-update operation that gets data from [dataSource](update.md) and saves to cache. The completable updates [networkOperationState](../../../../coroutines/com.motorro.rxlcemodel.coroutines/-strategy-update-wrapper/network-operation-state.md) to mix state to original [upstream](../../../../coroutines/com.motorro.rxlcemodel.coroutines/-strategy-update-wrapper/upstream.md)

#### Parameters

common

| | |
|---|---|
| dataSource | Update operation data source factory |
