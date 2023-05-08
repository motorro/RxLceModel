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
| [addCloseable](index.md#264516373%2FFunctions%2F1456247564) | [androidJvm]<br>open fun [addCloseable](index.md#264516373%2FFunctions%2F1456247564)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [doClear](do-clear.md) | [androidJvm]<br>abstract fun [doClear](do-clear.md)()<br>Disposes active operations when model is destroyed |
| [initialize](initialize.md) | [androidJvm]<br>fun [initialize](initialize.md)()<br>Call this function to initialize a new model and start receiving events |

## Properties

| Name | Summary |
|---|---|
| [cleared](cleared.md) | [androidJvm]<br>var [cleared](cleared.md): Boolean = false<br>Is model cleared |
| [initialized](initialized.md) | [androidJvm]<br>var [initialized](initialized.md): Boolean = false<br>Is model initialized |

## Inheritors

| Name |
|---|
| [BaseLceModel](../-base-lce-model/index.md) |
