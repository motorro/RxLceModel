//[rx](../../index.md)/[com.motorro.rxlcemodel.rx](index.md)/[onEmptyLoadingReturnItem](on-empty-loading-return-item.md)

# onEmptyLoadingReturnItem

[jvm]\
inline fun &lt;[DATA](on-empty-loading-return-item.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; Observable&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](on-empty-loading-return-item.md)&gt;&gt;.[onEmptyLoadingReturnItem](on-empty-loading-return-item.md)(crossinline block: () -&gt; [DATA](on-empty-loading-return-item.md)?): Observable&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](on-empty-loading-return-item.md)&gt;&gt;

Substitutes [LceState.Loading](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md) empty data with data produced by [block](on-empty-loading-return-item.md)

#### Receiver

LCE stream

#### Parameters

jvm

| | |
|---|---|
| block | Item creation block |
