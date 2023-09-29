//[coroutines](../../index.md)/[com.motorro.rxlcemodel.coroutines](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [CacheThenNetLceModel](-cache-then-net-lce-model/index.md) | [common]<br>class [CacheThenNetLceModel](-cache-then-net-lce-model/index.md)&lt;[DATA](-cache-then-net-lce-model/index.md) : Any, [PARAMS](-cache-then-net-lce-model/index.md) : Any&gt;(val params: [PARAMS](-cache-then-net-lce-model/index.md), serviceSet: [ServiceSet](../com.motorro.rxlcemodel.coroutines.service/-service-set/index.md)&lt;[DATA](-cache-then-net-lce-model/index.md), [PARAMS](-cache-then-net-lce-model/index.md)&gt;, startWith: Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](-cache-then-net-lce-model/index.md)&gt;&gt;, ioDispatcher: CoroutineDispatcher, logger: [Logger](../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?) : [LceModel](-lce-model/index.md)&lt;[DATA](-cache-then-net-lce-model/index.md), [PARAMS](-cache-then-net-lce-model/index.md)&gt; <br>A [LceModel](-lce-model/index.md) which uses cache subscription as a 'source of truth'. When [state](-cache-then-net-lce-model/state.md) is subscribed it loads cache data refreshing it if cache is stall or whenever cache returns null. The model always returns cached data first - then network if data is stall Cache service *must* notify of its data changes! |
| [LceModel](-lce-model/index.md) | [common]<br>interface [LceModel](-lce-model/index.md)&lt;[DATA](-lce-model/index.md) : Any, [PARAMS](-lce-model/index.md) : Any&gt; : [LceUseCase](-lce-use-case/index.md)&lt;[DATA](-lce-model/index.md)&gt; <br>A model interface to load data and transmit it to subscribers along with loading operation state |
| [LceUseCase](-lce-use-case/index.md) | [common]<br>interface [LceUseCase](-lce-use-case/index.md)&lt;[DATA](-lce-use-case/index.md) : Any&gt;<br>Base LCE use-case with [state](-lce-use-case/state.md) and [refresh](-lce-use-case/refresh.md) |
| [StrategyUpdateWrapper](-strategy-update-wrapper/index.md) | [common]<br>class [StrategyUpdateWrapper](-strategy-update-wrapper/index.md)&lt;[DATA](-strategy-update-wrapper/index.md) : Any, [PARAMS](-strategy-update-wrapper/index.md) : Any&gt;(upstream: [LceModel](-lce-model/index.md)&lt;[DATA](-strategy-update-wrapper/index.md), [PARAMS](-strategy-update-wrapper/index.md)&gt;, cacheService: [CacheService](../com.motorro.rxlcemodel.coroutines.service/-cache-service/index.md)&lt;[DATA](-strategy-update-wrapper/index.md), [PARAMS](-strategy-update-wrapper/index.md)&gt;, ioDispatcher: CoroutineDispatcher, logger: [Logger](../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?) : [UpdateWrapper](-update-wrapper/index.md)&lt;[DATA](-strategy-update-wrapper/index.md), [PARAMS](-strategy-update-wrapper/index.md)&gt; <br>Wraps [LceModel](-lce-model/index.md) and mixes in a data update state Use to build models that patch some properties and load the whole data structure as a result Implement methods to update properties using [doUpdate](../../../coroutines/com.motorro.rxlcemodel.coroutines/-strategy-update-wrapper/do-update.md) template |
| [UpdateWrapper](-update-wrapper/index.md) | [common]<br>abstract class [UpdateWrapper](-update-wrapper/index.md)&lt;[DATA](-update-wrapper/index.md) : Any, [PARAMS](-update-wrapper/index.md) : Any&gt;(upstream: [LceModel](-lce-model/index.md)&lt;[DATA](-update-wrapper/index.md), [PARAMS](-update-wrapper/index.md)&gt;, cacheService: [CacheService](../com.motorro.rxlcemodel.coroutines.service/-cache-service/index.md)&lt;[DATA](-update-wrapper/index.md), [PARAMS](-update-wrapper/index.md)&gt;, ioDispatcher: CoroutineDispatcher, logger: [Logger](../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?) : [LceModel](-lce-model/index.md)&lt;[DATA](-update-wrapper/index.md), [PARAMS](-update-wrapper/index.md)&gt; <br>A base class that wraps [LceModel](-lce-model/index.md) and mixes in a data update state Extend to build models that patch some properties and load the whole data structure as a result Implement methods to update properties using [doUpdate](../../../coroutines/com.motorro.rxlcemodel.coroutines/-update-wrapper/do-update.md) template |
| [UpdatingLceModel](-updating-lce-model/index.md) | [common]<br>interface [UpdatingLceModel](-updating-lce-model/index.md)&lt;[DATA](-updating-lce-model/index.md) : Any, in [UPDATE](-updating-lce-model/index.md) : Any, [PARAMS](-updating-lce-model/index.md) : Any&gt; : [LceModel](-lce-model/index.md)&lt;[DATA](-updating-lce-model/index.md), [PARAMS](-updating-lce-model/index.md)&gt; <br>[LceModel](-lce-model/index.md) extension that can [update](-updating-lce-model/update.md) data |
| [UpdatingLceModelWrapper](-updating-lce-model-wrapper/index.md) | [common]<br>class [UpdatingLceModelWrapper](-updating-lce-model-wrapper/index.md)&lt;[DATA](-updating-lce-model-wrapper/index.md) : Any, in [UPDATE](-updating-lce-model-wrapper/index.md) : Any, [PARAMS](-updating-lce-model-wrapper/index.md) : Any&gt;(upstream: [LceModel](-lce-model/index.md)&lt;[DATA](-updating-lce-model-wrapper/index.md), [PARAMS](-updating-lce-model-wrapper/index.md)&gt;, serviceSet: [UpdatingServiceSet](../com.motorro.rxlcemodel.coroutines.service/-updating-service-set/index.md)&lt;[DATA](-updating-lce-model-wrapper/index.md), [UPDATE](-updating-lce-model-wrapper/index.md), [PARAMS](-updating-lce-model-wrapper/index.md)&gt;, ioDispatcher: CoroutineDispatcher, logger: [Logger](../../../common/com.motorro.rxlcemodel.common/-logger/index.md)?) : [UpdateWrapper](-update-wrapper/index.md)&lt;[DATA](-updating-lce-model-wrapper/index.md), [PARAMS](-updating-lce-model-wrapper/index.md)&gt; , [UpdatingLceModel](-updating-lce-model/index.md)&lt;[DATA](-updating-lce-model-wrapper/index.md), [UPDATE](-updating-lce-model-wrapper/index.md), [PARAMS](-updating-lce-model-wrapper/index.md)&gt; <br>Wraps an [LceModel](-lce-model/index.md) to enable simple data updates with the [UPDATE](-updating-lce-model-wrapper/index.md) structure (say a PUT operation) rather than individual property updates (PATCH operation). Implement [UpdateWrapper](-update-wrapper/index.md) to achieve PATCH workflow |

## Functions

| Name | Summary |
|---|---|
| [errorToLce](error-to-lce.md) | [common]<br>inline fun &lt;[T](error-to-lce.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[T](error-to-lce.md)&gt;&gt;.[errorToLce](error-to-lce.md)(crossinline errorData: (Throwable) -&gt; [T](error-to-lce.md)? = { null }): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[T](error-to-lce.md)&gt;&gt;<br>Maps an upstream error to LceError |
| [flatMapSingleData](flat-map-single-data.md) | [common]<br>fun &lt;[DATA_1](flat-map-single-data.md) : Any, [DATA_2](flat-map-single-data.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA_1](flat-map-single-data.md)&gt;&gt;.[flatMapSingleData](flat-map-single-data.md)(mapper: suspend (data: [DATA_1](flat-map-single-data.md)) -&gt; [DATA_2](flat-map-single-data.md)): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA_2](flat-map-single-data.md)&gt;&gt;<br>Maps each [DATA_1](flat-map-single-data.md) to single for [DATA_2](flat-map-single-data.md) and merges back to LceState. If error occurs in [mapper](flat-map-single-data.md) emits [LceState.Error](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/index.md). Example: load some [DATA_2](flat-map-single-data.md) from server using original [DATA_1](flat-map-single-data.md) as a parameter. |
| [getData](get-data.md) | [common]<br>fun &lt;[DATA](get-data.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](get-data.md)&gt;&gt;.[getData](get-data.md)(terminateOnError: ([LceState.Error](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/index.md)&lt;[DATA](get-data.md)&gt;) -&gt; Boolean): Flow&lt;[DATA](get-data.md)&gt;<br>Returns model's data stream dropping state information |
| [map](map.md) | [common]<br>fun &lt;[DATA_1](map.md) : Any, [DATA_2](map.md) : Any, [PARAMS](map.md) : Any&gt; [LceModel](-lce-model/index.md)&lt;[DATA_1](map.md), [PARAMS](map.md)&gt;.[map](map.md)(mapper: (data: [DATA_1](map.md)) -&gt; [DATA_2](map.md)): [LceModel](-lce-model/index.md)&lt;[DATA_2](map.md), [PARAMS](map.md)&gt;<br>Creates a model wrapper that converts [DATA_1](map.md) to [DATA_2](map.md)<br>[common]<br>fun &lt;[DATA_1](map.md) : Any, [DATA_2](map.md) : Any&gt; [LceUseCase](-lce-use-case/index.md)&lt;[DATA_1](map.md)&gt;.[map](map.md)(mapper: (data: [DATA_1](map.md)) -&gt; [DATA_2](map.md)): [LceUseCase](-lce-use-case/index.md)&lt;[DATA_2](map.md)&gt;<br>Creates a use-case wrapper that converts [DATA_1](map.md) to [DATA_2](map.md) |
| [onEmptyLoadingReturn](on-empty-loading-return.md) | [common]<br>inline fun &lt;[DATA](on-empty-loading-return.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;&gt;.[onEmptyLoadingReturn](on-empty-loading-return.md)(crossinline block: ([LceState.Loading](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;) -&gt; [LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;&gt;<br>Substitutes [LceState.Loading](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md) with empty data with state produced by [block](on-empty-loading-return.md) |
| [onEmptyLoadingReturnItem](on-empty-loading-return-item.md) | [common]<br>inline fun &lt;[DATA](on-empty-loading-return-item.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](on-empty-loading-return-item.md)&gt;&gt;.[onEmptyLoadingReturnItem](on-empty-loading-return-item.md)(crossinline block: () -&gt; [DATA](on-empty-loading-return-item.md)?): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](on-empty-loading-return-item.md)&gt;&gt;<br>Substitutes [LceState.Loading](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md) empty data with data produced by [block](on-empty-loading-return-item.md) |
| [refreshed](refreshed.md) | [common]<br>fun &lt;[DATA](refreshed.md) : Any&gt; [LceUseCase](-lce-use-case/index.md)&lt;[DATA](refreshed.md)&gt;.[refreshed](refreshed.md)(): [LceUseCase](-lce-use-case/index.md)&lt;[DATA](refreshed.md)&gt;<br>Wraps use-case to refresh on each subscription<br>[common]<br>fun &lt;[DATA](refreshed.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](refreshed.md)&gt;&gt;.[refreshed](refreshed.md)(refresh: suspend () -&gt; Unit): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](refreshed.md)&gt;&gt;<br>Refreshes data on subscription once |
| [terminateOnError](terminate-on-error.md) | [common]<br>fun &lt;[DATA](terminate-on-error.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](terminate-on-error.md)&gt;&gt;.[terminateOnError](terminate-on-error.md)(predicate: ([LceState.Error](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/index.md)&lt;[DATA](terminate-on-error.md)&gt;) -&gt; Boolean): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](terminate-on-error.md)&gt;&gt;<br>Terminates [LceUseCase.state](-lce-use-case/state.md) stream if [predicate](terminate-on-error.md) returns true |
| [withRefresh](with-refresh.md) | [common]<br>fun &lt;[DATA](with-refresh.md) : Any&gt; [LceUseCase](-lce-use-case/index.md)&lt;[DATA](with-refresh.md)&gt;.[withRefresh](with-refresh.md)(refreshStream: Flow&lt;Any&gt;): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](with-refresh.md)&gt;&gt;<br>Takes the [LceUseCase.state](-lce-use-case/state.md) of model that is being refreshed each time [refreshStream](with-refresh.md) emits a value Useful when you create a model as a result of mapping of some input (params for example) and the [LceModel.refresh](../../../coroutines/com.motorro.rxlcemodel.coroutines/-lce-model/refresh.md) property becomes invisible for the outside world |
| [withUpdates](with-updates.md) | [common]<br>fun &lt;[DATA](with-updates.md) : Any, [UPDATE](with-updates.md) : Any, [PARAMS](with-updates.md) : Any&gt; [LceModel](-lce-model/index.md)&lt;[DATA](with-updates.md), [PARAMS](with-updates.md)&gt;.[withUpdates](with-updates.md)(serviceSet: [UpdatingServiceSet](../com.motorro.rxlcemodel.coroutines.service/-updating-service-set/index.md)&lt;[DATA](with-updates.md), [UPDATE](with-updates.md), [PARAMS](with-updates.md)&gt;, ioDispatcher: CoroutineDispatcher = Dispatchers.Unconfined, logger: [Logger](../../../common/com.motorro.rxlcemodel.common/-logger/index.md)? = null): [UpdatingLceModel](-updating-lce-model/index.md)&lt;[DATA](with-updates.md), [UPDATE](with-updates.md), [PARAMS](with-updates.md)&gt;<br>Wraps an [LceModel](-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](-updating-lce-model/index.md) |

## Properties

| Name | Summary |
|---|---|
| [dataNoErrors](data-no-errors.md) | [common]<br>val &lt;[DATA](data-no-errors.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](data-no-errors.md)&gt;&gt;.[dataNoErrors](data-no-errors.md): Flow&lt;[DATA](data-no-errors.md)&gt;<br>Model's data stream with state information dropped. No error state terminates stream |
| [dataStopOnEmptyErrors](data-stop-on-empty-errors.md) | [common]<br>val &lt;[DATA](data-stop-on-empty-errors.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](data-stop-on-empty-errors.md)&gt;&gt;.[dataStopOnEmptyErrors](data-stop-on-empty-errors.md): Flow&lt;[DATA](data-stop-on-empty-errors.md)&gt;<br>Model's data stream with state information dropped. Will terminate on errors with empty data |
| [dataStopOnErrors](data-stop-on-errors.md) | [common]<br>val &lt;[DATA](data-stop-on-errors.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](data-stop-on-errors.md)&gt;&gt;.[dataStopOnErrors](data-stop-on-errors.md): Flow&lt;[DATA](data-stop-on-errors.md)&gt;<br>Model's data stream with state information dropped. Will terminate on any error |
| [stopOnEmptyErrors](stop-on-empty-errors.md) | [common]<br>val &lt;[DATA](stop-on-empty-errors.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](stop-on-empty-errors.md)&gt;&gt;.[stopOnEmptyErrors](stop-on-empty-errors.md): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](stop-on-empty-errors.md)&gt;&gt;<br>Model's state stream which terminates on errors with empty data |
| [stopOnErrors](stop-on-errors.md) | [common]<br>val &lt;[DATA](stop-on-errors.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](stop-on-errors.md)&gt;&gt;.[stopOnErrors](stop-on-errors.md): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](stop-on-errors.md)&gt;&gt;<br>Model's state stream which terminates on any error |
| [validData](valid-data.md) | [common]<br>val &lt;[DATA](valid-data.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](valid-data.md)&gt;&gt;.[validData](valid-data.md): Flow&lt;[DATA](valid-data.md)&gt;<br>Model's valid data stream with state information dropped. Will terminate on any error |