//[base](../../index.md)/[com.motorro.rxlcemodel.base](index.md)/[flatMapSingleData](flat-map-single-data.md)

# flatMapSingleData

[jvm]\
fun &lt;[DATA_1](flat-map-single-data.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](flat-map-single-data.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; Observable&lt;[LceState](-lce-state/index.md)&lt;[DATA_1](flat-map-single-data.md)&gt;&gt;.[flatMapSingleData](flat-map-single-data.md)(mapper: ([DATA_1](flat-map-single-data.md)) -&gt; Single&lt;[DATA_2](flat-map-single-data.md)&gt;): Observable&lt;[LceState](-lce-state/index.md)&lt;[DATA_2](flat-map-single-data.md)&gt;&gt;

Maps each [DATA_1](flat-map-single-data.md) to single for [DATA_2](flat-map-single-data.md) and merges back to LceState. If error occurs in [mapper](flat-map-single-data.md) emits [LceState.Error](-lce-state/-error/index.md). Example: load some [DATA_2](flat-map-single-data.md) from server using original [DATA_1](flat-map-single-data.md) as a parameter.

## Parameters

jvm

| | |
|---|---|
| DATA_1 | Source data type |
| DATA_2 | Resulting data type |
| mapper | Data mapper |
