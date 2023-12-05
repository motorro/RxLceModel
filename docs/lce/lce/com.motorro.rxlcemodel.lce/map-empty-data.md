//[lce](../../index.md)/[com.motorro.rxlcemodel.lce](index.md)/[mapEmptyData](map-empty-data.md)

# mapEmptyData

[common]\
inline fun &lt;[DATA](map-empty-data.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceState](-lce-state/index.md)&lt;[DATA](map-empty-data.md)&gt;.[mapEmptyData](map-empty-data.md)(crossinline block: ([LceState](-lce-state/index.md)&lt;[DATA](map-empty-data.md)&gt;) -&gt; [LceState](-lce-state/index.md)&lt;[DATA](map-empty-data.md)&gt;): [LceState](-lce-state/index.md)&lt;[DATA](map-empty-data.md)&gt;

Substitutes a state with empty data with empty data with state produced by [block](map-empty-data.md)

#### Receiver

LCE state

#### Parameters

common

| | |
|---|---|
| block | transformation block |
