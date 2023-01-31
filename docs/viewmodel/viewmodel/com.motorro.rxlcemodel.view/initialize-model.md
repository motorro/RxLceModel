//[viewmodel](../../index.md)/[com.motorro.rxlcemodel.view](index.md)/[initializeModel](initialize-model.md)

# initializeModel

[androidJvm]\
inline fun &lt;[DATA](initialize-model.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [MODEL](initialize-model.md) : [BaseLceModel](../com.motorro.rxlcemodel.viewmodel/-base-lce-model/index.md)&lt;[DATA](initialize-model.md)&gt;&gt; [LceStateView](-lce-state-view/index.md)&lt;[DATA](initialize-model.md)&gt;.[initializeModel](initialize-model.md)(modelStoreOwner: [ViewModelStoreOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelStoreOwner.html), init: [MODEL](initialize-model.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { initialize() }): [MODEL](initialize-model.md)

Creates and initializes LCE view-model subscribing to state updates.

#### Parameters

androidJvm

| | |
|---|---|
| init | Model initialization action |
