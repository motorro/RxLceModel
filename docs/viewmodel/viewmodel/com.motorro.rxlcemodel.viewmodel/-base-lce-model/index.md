//[viewmodel](../../../index.md)/[com.motorro.rxlcemodel.viewmodel](../index.md)/[BaseLceModel](index.md)

# BaseLceModel

abstract class [BaseLceModel](index.md)&lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [BaseViewModel](../-base-view-model/index.md)

Base model with [state](state.md) and [refresh](refresh.md)

#### Inheritors

| |
|---|
| [Impl](-impl/index.md) |

## Constructors

| | |
|---|---|
| [BaseLceModel](-base-lce-model.md) | [androidJvm]<br>constructor() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |
| [Impl](-impl/index.md) | [androidJvm]<br>abstract class [Impl](-impl/index.md)&lt;[DATA](-impl/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [BaseLceModel](index.md)&lt;[DATA](-impl/index.md)&gt; <br>Basic ViewModel with LceModel inside |
| [WithUpdates](-with-updates/index.md) | [androidJvm]<br>open class [WithUpdates](-with-updates/index.md)&lt;[DATA](-with-updates/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(dataUseCase: [LceUseCase](../../../../rx/rx/com.motorro.rxlcemodel.rx/-lce-use-case/index.md)&lt;[DATA](-with-updates/index.md)&gt;) : [BaseLceModel.Impl](-impl/index.md)&lt;[DATA](-with-updates/index.md)&gt; <br>View model with operations that mix with commonMain state |

## Properties

| Name | Summary |
|---|---|
| [cleared](../-base-view-model/cleared.md) | [androidJvm]<br>var [cleared](../-base-view-model/cleared.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Is model cleared |
| [initialized](../-base-view-model/initialized.md) | [androidJvm]<br>var [initialized](../-base-view-model/initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Is model initialized |
| [state](state.md) | [androidJvm]<br>abstract val [state](state.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>LCE State |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../-base-view-model/index.md#264516373%2FFunctions%2F1456247564) | [androidJvm]<br>open fun [addCloseable](../-base-view-model/index.md#264516373%2FFunctions%2F1456247564)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [dismissCurrentError](dismiss-current-error.md) | [androidJvm]<br>fun [dismissCurrentError](dismiss-current-error.md)()<br>Dismisses error set in state if it is error |
| [dismissError](dismiss-error.md) | [androidJvm]<br>open fun [dismissError](dismiss-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html))<br>Default action on critical error |
| [doClear](../-base-view-model/do-clear.md) | [androidJvm]<br>abstract fun [doClear](../-base-view-model/do-clear.md)()<br>Disposes active operations when model is destroyed |
| [initialize](../-base-view-model/initialize.md) | [androidJvm]<br>fun [initialize](../-base-view-model/initialize.md)()<br>Call this function to initialize a new model and start receiving events |
| [refresh](refresh.md) | [androidJvm]<br>abstract fun [refresh](refresh.md)()<br>Requests data refresh |
| [restart](restart.md) | [androidJvm]<br>abstract fun [restart](restart.md)()<br>Retries data subscription from scratch |
