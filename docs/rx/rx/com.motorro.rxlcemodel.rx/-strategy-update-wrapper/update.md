//[rx](../../../index.md)/[com.motorro.rxlcemodel.rx](../index.md)/[StrategyUpdateWrapper](index.md)/[update](update.md)

# update

[jvm]\
fun [update](update.md)(dataSource: (params: [PARAMS](index.md)) -&gt; Single&lt;out [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[DATA](index.md)&gt;&gt;): Completable

Creates a cache-update operation that gets data from [dataSource](update.md) and saves to cache. The completable updates [networkOperationState](../../../../rx/com.motorro.rxlcemodel.rx/-strategy-update-wrapper/network-operation-state.md) to mix state to original [upstream](../../../../rx/com.motorro.rxlcemodel.rx/-strategy-update-wrapper/upstream.md)

#### Parameters

jvm

| | |
|---|---|
| dataSource | Update operation data source factory |
