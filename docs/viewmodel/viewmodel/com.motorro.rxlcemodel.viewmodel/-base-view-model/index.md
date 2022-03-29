//[viewmodel](../../../index.md)/[com.motorro.rxlcemodel.viewmodel](../index.md)/[BaseViewModel](index.md)

# BaseViewModel

[androidJvm]\
abstract class [BaseViewModel](index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

Base view model with [initialize](initialize.md) and [doClear](do-clear.md) methods

## Constructors

| | |
|---|---|
| [BaseViewModel](-base-view-model.md) | [androidJvm]<br>fun [BaseViewModel](-base-view-model.md)() |

## Functions

| Name | Summary |
|---|---|
| [clear](index.md#-1936886459%2FFunctions%2F1456247564) | [androidJvm]<br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)<br>fun [clear](index.md#-1936886459%2FFunctions%2F1456247564)() |
| [doClear](do-clear.md) | [androidJvm]<br>abstract fun [doClear](do-clear.md)()<br>Disposes active operations when model is destroyed |
| [getTag](index.md#-215894976%2FFunctions%2F1456247564) | [androidJvm]<br>open fun &lt;[T](index.md#-215894976%2FFunctions%2F1456247564) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [getTag](index.md#-215894976%2FFunctions%2F1456247564)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](index.md#-215894976%2FFunctions%2F1456247564) |
| [initialize](initialize.md) | [androidJvm]<br>fun [initialize](initialize.md)()<br>Call this function to initialize a new model and start receiving events |
| [setTagIfAbsent](index.md#-1567230750%2FFunctions%2F1456247564) | [androidJvm]<br>open fun &lt;[T](index.md#-1567230750%2FFunctions%2F1456247564) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [setTagIfAbsent](index.md#-1567230750%2FFunctions%2F1456247564)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: [T](index.md#-1567230750%2FFunctions%2F1456247564)): [T](index.md#-1567230750%2FFunctions%2F1456247564) |

## Properties

| Name | Summary |
|---|---|
| [cleared](cleared.md) | [androidJvm]<br>var [cleared](cleared.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>Is model cleared |
| [initialized](initialized.md) | [androidJvm]<br>var [initialized](initialized.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>Is model initialized |

## Inheritors

| Name |
|---|
| [BaseLceModel](../-base-lce-model/index.md) |
