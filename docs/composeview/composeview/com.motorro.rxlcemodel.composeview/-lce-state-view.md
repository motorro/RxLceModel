//[composeview](../../index.md)/[com.motorro.rxlcemodel.composeview](index.md)/[LceStateView](-lce-state-view.md)

# LceStateView

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[DATA](-lce-state-view.md) : Any&gt; [LceStateView](-lce-state-view.md)(viewState: [LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](-lce-state-view.md)&gt;, onRefresh: () -&gt; Unit, loading: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; Unit, fatalError: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(error: Throwable) -&gt; Unit, nonFatalError: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(error: Throwable) -&gt; Unit, termination: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; Unit, isFatalError: ([LceState.Error](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/index.md)&lt;[DATA](-lce-state-view.md)&gt;) -&gt; Boolean = { null == it.data }, content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(data: [DATA](-lce-state-view.md), isValid: Boolean, refreshing: Boolean) -&gt; Unit)

Attaches composable view to view-model

#### Parameters

androidJvm

| | |
|---|---|
| viewState | View state |
| onRefresh | Refresh handler |
| loading | Loading override |
| fatalError | Fatal error override |
| nonFatalError | Non-fatal error override |
| termination | Termination override |
| isFatalError | Checks if error is fatal |
| content | Content rendering function |
