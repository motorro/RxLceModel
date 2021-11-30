//[base](../../index.md)/[com.motorro.rxlcemodel.base](index.md)/[refreshed](refreshed.md)

# refreshed

[jvm]\
fun &lt;[DATA](refreshed.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; Observable&lt;[LceState](-lce-state/index.md)&lt;[DATA](refreshed.md)&gt;&gt;.[refreshed](refreshed.md)(refresh: Completable): Observable&lt;[LceState](-lce-state/index.md)&lt;[DATA](refreshed.md)&gt;&gt;

Refreshes data on subscription once

#### Receiver

Original stream

## Parameters

jvm

| | |
|---|---|
| refresh | Refresh operation |

[jvm]\
fun &lt;[DATA](refreshed.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceUseCase](-lce-use-case/index.md)&lt;[DATA](refreshed.md)&gt;.[refreshed](refreshed.md)(): [LceUseCase](-lce-use-case/index.md)&lt;[DATA](refreshed.md)&gt;

Wraps use-case to refresh on each subscription

#### Receiver

Original model
