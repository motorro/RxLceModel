//[viewmodel](../../../../index.md)/[com.motorro.rxlcemodel.viewmodel](../../index.md)/[BaseLceModel](../index.md)/[WithUpdates](index.md)

# WithUpdates

open class [WithUpdates](index.md)&lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(dataUseCase: [LceUseCase](../../../../../rx/rx/com.motorro.rxlcemodel.rx/-lce-use-case/index.md)&lt;[DATA](index.md)&gt;) : [BaseLceModel.Impl](../-impl/index.md)&lt;[DATA](index.md)&gt; 

View model with operations that mix with commonMain state

#### Parameters

androidJvm

| | |
|---|---|
| dataUseCase | Main data use-case |

## Constructors

| | |
|---|---|
| [WithUpdates](-with-updates.md) | [androidJvm]<br>constructor(dataUseCase: [LceUseCase](../../../../../rx/rx/com.motorro.rxlcemodel.rx/-lce-use-case/index.md)&lt;[DATA](index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [cleared](../../-base-view-model/cleared.md) | [androidJvm]<br>var [cleared](../../-base-view-model/cleared.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Is model cleared |
| [initialized](../../-base-view-model/initialized.md) | [androidJvm]<br>var [initialized](../../-base-view-model/initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Is model initialized |
| [state](../-impl/state.md) | [androidJvm]<br>open override val [state](../-impl/state.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[LceState](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>LCE State |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../-base-view-model/index.md#264516373%2FFunctions%2F1456247564) | [androidJvm]<br>open fun [addCloseable](../../-base-view-model/index.md#264516373%2FFunctions%2F1456247564)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [dismissCurrentError](../dismiss-current-error.md) | [androidJvm]<br>fun [dismissCurrentError](../dismiss-current-error.md)()<br>Dismisses error set in state if it is error |
| [dismissError](../dismiss-error.md) | [androidJvm]<br>open fun [dismissError](../dismiss-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html))<br>Default action on critical error |
| [doClear](../-impl/do-clear.md) | [androidJvm]<br>open override fun [doClear](../-impl/do-clear.md)()<br>Disposes active operations when model is destroyed |
| [initialize](../../-base-view-model/initialize.md) | [androidJvm]<br>fun [initialize](../../-base-view-model/initialize.md)()<br>Call this function to initialize a new model and start receiving events |
| [refresh](../-impl/refresh.md) | [androidJvm]<br>open override fun [refresh](../-impl/refresh.md)()<br>Requests data refresh |
| [restart](../-impl/restart.md) | [androidJvm]<br>open override fun [restart](../-impl/restart.md)()<br>Retries data subscription from scratch |
