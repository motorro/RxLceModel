//[coroutines](../../index.md)/[com.motorro.rxlcemodel.coroutines](index.md)/[flatMapSingleData](flat-map-single-data.md)

# flatMapSingleData

[common]\
fun &lt;[DATA_1](flat-map-single-data.md) : Any, [DATA_2](flat-map-single-data.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA_1](flat-map-single-data.md)&gt;&gt;.[flatMapSingleData](flat-map-single-data.md)(mapper: suspend (data: [DATA_1](flat-map-single-data.md)) -&gt; [DATA_2](flat-map-single-data.md)): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA_2](flat-map-single-data.md)&gt;&gt;

Maps each [DATA_1](flat-map-single-data.md) to single for [DATA_2](flat-map-single-data.md) and merges back to LceState. If error occurs in [mapper](flat-map-single-data.md) emits [LceState.Error](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/index.md). Example: load some [DATA_2](flat-map-single-data.md) from server using original [DATA_1](flat-map-single-data.md) as a parameter.

#### Parameters

common

| | |
|---|---|
| DATA_1 | Source data type |
| DATA_2 | Resulting data type |
| mapper | Data mapper |
