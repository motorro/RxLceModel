//[coroutines](../../index.md)/[com.motorro.rxlcemodel.coroutines](index.md)/[onEmptyLoadingReturn](on-empty-loading-return.md)

# onEmptyLoadingReturn

[common]\
inline fun &lt;[DATA](on-empty-loading-return.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;&gt;.[onEmptyLoadingReturn](on-empty-loading-return.md)(crossinline block: ([LceState.Loading](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;) -&gt; [LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;&gt;

Substitutes [LceState.Loading](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/index.md) with empty data with state produced by [block](on-empty-loading-return.md)

#### Receiver

LCE stream

#### Parameters

common

| | |
|---|---|
| block | transformation block |
