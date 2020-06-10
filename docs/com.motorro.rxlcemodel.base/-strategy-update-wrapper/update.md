[com.motorro.rxlcemodel.base](../index.md) / [StrategyUpdateWrapper](index.md) / [update](./update.md)

# update

`fun update(dataSource: (params: `[`PARAMS`](index.md#PARAMS)`) -> `[`Single`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Single.html)`<out `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`DATA`](index.md#DATA)`>>): `[`Completable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html)

Creates a cache-update operation that gets data from [dataSource](update.md#com.motorro.rxlcemodel.base.StrategyUpdateWrapper$update(kotlin.Function1((com.motorro.rxlcemodel.base.StrategyUpdateWrapper.PARAMS, io.reactivex.rxjava3.core.Single((com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.StrategyUpdateWrapper.DATA)))))))/dataSource) and saves to cache.
The completable updates [networkOperationState](#) to mix state to original [upstream](#)

### Parameters

`dataSource` - Update operation data source factory