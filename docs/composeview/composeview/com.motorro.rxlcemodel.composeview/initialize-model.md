//[composeview](../../index.md)/[com.motorro.rxlcemodel.composeview](index.md)/[initializeModel](initialize-model.md)

# initializeModel

[androidJvm]\

@Composable

inline fun &lt;[DATA](initialize-model.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [MODEL](initialize-model.md) : [BaseLceModel](../../../viewmodel/viewmodel/com.motorro.rxlcemodel.viewmodel/-base-lce-model/index.md)&lt;[DATA](initialize-model.md)&gt;&gt; [initializeModel](initialize-model.md)(modelStoreOwner: [ViewModelStoreOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelStoreOwner.html) = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    }, init: [MODEL](initialize-model.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = { initialize() }): [MODEL](initialize-model.md)

Creates and initializes LCE view-model
