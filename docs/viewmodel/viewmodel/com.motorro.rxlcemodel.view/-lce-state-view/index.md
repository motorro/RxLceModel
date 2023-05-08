//[viewmodel](../../../index.md)/[com.motorro.rxlcemodel.view](../index.md)/[LceStateView](index.md)

# LceStateView

[androidJvm]\
interface [LceStateView](index.md)&lt;[DATA](index.md) : Any&gt;

Load-Content-View interface.

#### Parameters

androidJvm

| | |
|---|---|
| DATA | Data type |

## Functions

| Name | Summary |
|---|---|
| [getLifecycleOwner](get-lifecycle-owner.md) | [androidJvm]<br>abstract fun [getLifecycleOwner](get-lifecycle-owner.md)(): [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)<br>Returns lifecycle owner |
| [isFatal](is-fatal.md) | [androidJvm]<br>open fun [isFatal](is-fatal.md)(error: [LceState.Error](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/index.md)&lt;[DATA](index.md)&gt;): Boolean<br>Checks if error is fatal for this view |
| [processState](process-state.md) | [androidJvm]<br>open fun [processState](process-state.md)(state: [LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;)<br>Call to process view state and data whenever new state arrives from model |
| [processStateData](process-state-data.md) | [androidJvm]<br>open fun [processStateData](process-state-data.md)(data: [DATA](index.md), isValid: Boolean, isUpdating: Boolean)<br>Called by [processState](process-state.md) to process new data. |
| [processStateView](process-state-view.md) | [androidJvm]<br>open fun [processStateView](process-state-view.md)(state: [LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;)<br>Updates view according to [state](process-state-view.md) |
| [processTermination](process-termination.md) | [androidJvm]<br>open fun [processTermination](process-termination.md)()<br>Process [LceState.Terminated](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-terminated/index.md). |
| [showContent](show-content.md) | [androidJvm]<br>abstract fun [showContent](show-content.md)()<br>Displays content. |
| [showError](show-error.md) | [androidJvm]<br>abstract fun [showError](show-error.md)(error: Throwable)<br>Displays error when there is no data to display. |
| [showLoading](show-loading.md) | [androidJvm]<br>abstract fun [showLoading](show-loading.md)()<br>Displays loading when no data available. |
| [showNonFatalError](show-non-fatal-error.md) | [androidJvm]<br>open fun [showNonFatalError](show-non-fatal-error.md)(error: Throwable)<br>Displays some error notification when the error is non-critical and some content may be displayed. |
| [showRefreshing](show-refreshing.md) | [androidJvm]<br>open fun [showRefreshing](show-refreshing.md)(type: [LceState.Loading.Type](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-loading/-type/index.md))<br>Displays data refresh on top of current state. |

## Extensions

| Name | Summary |
|---|---|
| [initializeModel](../initialize-model.md) | [androidJvm]<br>inline fun &lt;[DATA](../initialize-model.md) : Any, [MODEL](../initialize-model.md) : [BaseLceModel](../../com.motorro.rxlcemodel.viewmodel/-base-lce-model/index.md)&lt;[DATA](../initialize-model.md)&gt;&gt; [LceStateView](index.md)&lt;[DATA](../initialize-model.md)&gt;.[initializeModel](../initialize-model.md)(modelStoreOwner: [ViewModelStoreOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelStoreOwner.html), init: [MODEL](../initialize-model.md).() -&gt; Unit = { initialize() }): [MODEL](../initialize-model.md)<br>Creates and initializes LCE view-model subscribing to state updates. |
