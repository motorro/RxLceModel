//[lce](../../index.md)/[com.motorro.rxlcemodel.lce](index.md)/[mapEmptyDataItem](map-empty-data-item.md)

# mapEmptyDataItem

[common]\
inline fun &lt;[DATA](map-empty-data-item.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceState](-lce-state/index.md)&lt;[DATA](map-empty-data-item.md)&gt;.[mapEmptyDataItem](map-empty-data-item.md)(crossinline block: () -&gt; [DATA](map-empty-data-item.md)?): [LceState](-lce-state/index.md)&lt;[DATA](map-empty-data-item.md)&gt;

Substitutes an item in a state with empty data with item produced by [block](map-empty-data-item.md)

#### Receiver

LCE stream

#### Parameters

common

| | |
|---|---|
| block | transformation block |
