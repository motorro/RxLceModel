//[coroutines](../../index.md)/[com.motorro.rxlcemodel.coroutines](index.md)/[flatMapLatestFlow](flat-map-latest-flow.md)

# flatMapLatestFlow

[common]\
fun &lt;[DATA_1](flat-map-latest-flow.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](flat-map-latest-flow.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA_1](flat-map-latest-flow.md)&gt;&gt;.[flatMapLatestFlow](flat-map-latest-flow.md)(mapper: suspend (data: [DATA_1](flat-map-latest-flow.md)) -&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA_2](flat-map-latest-flow.md)&gt;&gt;): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA_2](flat-map-latest-flow.md)&gt;&gt;

Maps each [DATA_1](flat-map-latest-flow.md) to flow for [DATA_2](flat-map-latest-flow.md) and combines with original state. If error occurs in [mapper](flat-map-latest-flow.md) emits [LceState.Error](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/index.md). Example: Using original [DATA_1](flat-map-latest-flow.md) as a parameter switch to new [DATA_2](flat-map-latest-flow.md) LCE flow

#### Parameters

common

| | |
|---|---|
| DATA_1 | Source data type |
| DATA_2 | Resulting data type |
| mapper | Data mapper |
