//[base](../../index.md)/[com.motorro.rxlcemodel.base](index.md)/[onEmptyLoadingReturnItem](on-empty-loading-return-item.md)

# onEmptyLoadingReturnItem

[jvm]\
inline fun &lt;[DATA](on-empty-loading-return-item.md) : Any&gt; Observable&lt;[LceState](-lce-state/index.md)&lt;[DATA](on-empty-loading-return-item.md)&gt;&gt;.[onEmptyLoadingReturnItem](on-empty-loading-return-item.md)(crossinline block: () -&gt; [DATA](on-empty-loading-return-item.md)?): Observable&lt;[LceState](-lce-state/index.md)&lt;[DATA](on-empty-loading-return-item.md)&gt;&gt;

Substitutes [LceState.Loading](-lce-state/-loading/index.md) empty data with data produced by [block](on-empty-loading-return-item.md)

#### Receiver

LCE stream

## Parameters

jvm

| | |
|---|---|
| block | Item creation block |
