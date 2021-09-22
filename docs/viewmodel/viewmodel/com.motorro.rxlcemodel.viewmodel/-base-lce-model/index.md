//[viewmodel](../../../index.md)/[com.motorro.rxlcemodel.viewmodel](../index.md)/[BaseLceModel](index.md)

# BaseLceModel

[androidJvm]\
abstract class [BaseLceModel](index.md)&lt;[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [BaseViewModel](../-base-view-model/index.md)

Base model with [state](state.md) and [refresh](refresh.md)

## Constructors

| | |
|---|---|
| [BaseLceModel](-base-lce-model.md) | [androidJvm]<br>fun [BaseLceModel](-base-lce-model.md)() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |
| [Impl](-impl/index.md) | [androidJvm]<br>abstract class [Impl](-impl/index.md)&lt;[DATA](-impl/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [BaseLceModel](index.md)&lt;[DATA](-impl/index.md)&gt; <br>Basic ViewModel with LceModel inside |
| [WithUpdates](-with-updates/index.md) | [androidJvm]<br>open class [WithUpdates](-with-updates/index.md)&lt;[DATA](-with-updates/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(dataUseCase: [LceUseCase](../../../../base/base/com.motorro.rxlcemodel.base/-lce-use-case/index.md)&lt;[DATA](-with-updates/index.md)&gt;) : [BaseLceModel.Impl](-impl/index.md)&lt;[DATA](-with-updates/index.md)&gt; <br>View model with operations that mix with main state |

## Functions

| Name | Summary |
|---|---|
| [clear](../-base-view-model/index.md#-1936886459%2FFunctions%2F1456247564) | [androidJvm]<br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)<br>fun [clear](../-base-view-model/index.md#-1936886459%2FFunctions%2F1456247564)() |
| [dismissCurrentError](dismiss-current-error.md) | [androidJvm]<br>fun [dismissCurrentError](dismiss-current-error.md)()<br>Dismisses error set in state if it is error |
| [dismissError](dismiss-error.md) | [androidJvm]<br>open fun [dismissError](dismiss-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html))<br>Default action on critical error |
| [doClear](../-base-view-model/do-clear.md) | [androidJvm]<br>abstract fun [doClear](../-base-view-model/do-clear.md)()<br>Disposes active operations when model is destroyed |
| [getTag](../-base-view-model/index.md#-215894976%2FFunctions%2F1456247564) | [androidJvm]<br>open fun &lt;[T](../-base-view-model/index.md#-215894976%2FFunctions%2F1456247564) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [getTag](../-base-view-model/index.md#-215894976%2FFunctions%2F1456247564)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](../-base-view-model/index.md#-215894976%2FFunctions%2F1456247564) |
| [initialize](../-base-view-model/initialize.md) | [androidJvm]<br>fun [initialize](../-base-view-model/initialize.md)()<br>Call this function to initialize a new model and start receiving events |
| [refresh](refresh.md) | [androidJvm]<br>abstract fun [refresh](refresh.md)()<br>Requests data refresh |
| [restart](restart.md) | [androidJvm]<br>abstract fun [restart](restart.md)()<br>Retries data subscription from scratch |
| [setTagIfAbsent](../-base-view-model/index.md#-1567230750%2FFunctions%2F1456247564) | [androidJvm]<br>open fun &lt;[T](../-base-view-model/index.md#-1567230750%2FFunctions%2F1456247564) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [setTagIfAbsent](../-base-view-model/index.md#-1567230750%2FFunctions%2F1456247564)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: [T](../-base-view-model/index.md#-1567230750%2FFunctions%2F1456247564)): [T](../-base-view-model/index.md#-1567230750%2FFunctions%2F1456247564) |

## Properties

| Name | Summary |
|---|---|
| [cleared](../-base-view-model/cleared.md) | [androidJvm]<br>var [cleared](../-base-view-model/cleared.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>Is model cleared |
| [initialized](../-base-view-model/initialized.md) | [androidJvm]<br>var [initialized](../-base-view-model/initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>Is model initialized |
| [state](state.md) | [androidJvm]<br>abstract val [state](state.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[LceState](../../../../base/base/com.motorro.rxlcemodel.base/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>LCE State |

## Inheritors

| Name |
|---|
| [BaseLceModel](-impl/index.md) |
