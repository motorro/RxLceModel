//[coroutines](../../index.md)/[com.motorro.rxlcemodel.coroutines](index.md)/[refreshed](refreshed.md)

# refreshed

[common]\
fun &lt;[DATA](refreshed.md) : Any&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](refreshed.md)&gt;&gt;.[refreshed](refreshed.md)(refresh: suspend () -&gt; Unit): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](refreshed.md)&gt;&gt;

Refreshes data on subscription once

#### Receiver

Original stream

#### Parameters

common

| | |
|---|---|
| refresh | Refresh operation |

[common]\
fun &lt;[DATA](refreshed.md) : Any&gt; [LceUseCase](-lce-use-case/index.md)&lt;[DATA](refreshed.md)&gt;.[refreshed](refreshed.md)(): [LceUseCase](-lce-use-case/index.md)&lt;[DATA](refreshed.md)&gt;

Wraps use-case to refresh on each subscription

#### Receiver

Original model
