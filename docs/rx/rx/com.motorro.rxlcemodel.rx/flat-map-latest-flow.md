//[rx](../../index.md)/[com.motorro.rxlcemodel.rx](index.md)/[flatMapLatestFlow](flat-map-latest-flow.md)

# flatMapLatestFlow

[jvm]\
fun &lt;[DATA_1](flat-map-latest-flow.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](flat-map-latest-flow.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; Observable&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA_1](flat-map-latest-flow.md)&gt;&gt;.[flatMapLatestFlow](flat-map-latest-flow.md)(mapper: (data: [DATA_1](flat-map-latest-flow.md)) -&gt; Observable&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA_2](flat-map-latest-flow.md)&gt;&gt;): Observable&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA_2](flat-map-latest-flow.md)&gt;&gt;

Maps each [DATA_1](flat-map-latest-flow.md) to flow for [DATA_2](flat-map-latest-flow.md) and combines with original state. If error occurs in [mapper](flat-map-latest-flow.md) emits [LceState.Error](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/index.md). Example: Using original [DATA_1](flat-map-latest-flow.md) as a parameter switch to new [DATA_2](flat-map-latest-flow.md) LCE flow

#### Parameters

jvm

| | |
|---|---|
| DATA_1 | Source data type |
| DATA_2 | Resulting data type |
| mapper | Data mapper |
