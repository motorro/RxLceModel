//[composeview](../../index.md)/[com.motorro.rxlcemodel.composeview](index.md)/[LceStateView](-lce-state-view.md)

# LceStateView

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[DATA](-lce-state-view.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceStateView](-lce-state-view.md)(viewState: [LceState](../../../base/base/com.motorro.rxlcemodel.base/-lce-state/index.md)&lt;[DATA](-lce-state-view.md)&gt;, onRefresh: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), loading: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), fatalError: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), nonFatalError: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), termination: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), isFatalError: ([LceState.Error](../../../base/base/com.motorro.rxlcemodel.base/-lce-state/-error/index.md)&lt;[DATA](-lce-state-view.md)&gt;) -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = { null == it.data }, content: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(data: [DATA](-lce-state-view.md), isValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), refreshing: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Attaches composable view to view-model

## Parameters

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
