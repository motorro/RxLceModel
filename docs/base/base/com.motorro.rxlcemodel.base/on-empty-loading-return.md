//[base](../../index.md)/[com.motorro.rxlcemodel.base](index.md)/[onEmptyLoadingReturn](on-empty-loading-return.md)

# onEmptyLoadingReturn

[jvm]\
inline fun &lt;[DATA](on-empty-loading-return.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; Observable&lt;[LceState](-lce-state/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;&gt;.[onEmptyLoadingReturn](on-empty-loading-return.md)(crossinline block: ([LceState.Loading](-lce-state/-loading/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;) -&gt; [LceState](-lce-state/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;): Observable&lt;[LceState](-lce-state/index.md)&lt;[DATA](on-empty-loading-return.md)&gt;&gt;

Substitutes [LceState.Loading](-lce-state/-loading/index.md) with empty data with state produced by [block](on-empty-loading-return.md)

#### Receiver

LCE stream

## Parameters

jvm

| | |
|---|---|
| block | transformation block |
