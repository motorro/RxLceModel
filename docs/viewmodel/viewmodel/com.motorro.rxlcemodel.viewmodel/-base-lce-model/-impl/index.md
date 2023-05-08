//[viewmodel](../../../../index.md)/[com.motorro.rxlcemodel.viewmodel](../../index.md)/[BaseLceModel](../index.md)/[Impl](index.md)

# Impl

[androidJvm]\
abstract class [Impl](index.md)&lt;[DATA](index.md) : Any&gt; : [BaseLceModel](../index.md)&lt;[DATA](index.md)&gt; 

Basic ViewModel with LceModel inside

## Constructors

| | |
|---|---|
| [Impl](-impl.md) | [androidJvm]<br>fun [Impl](-impl.md)() |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../../-base-view-model/index.md#264516373%2FFunctions%2F1456247564) | [androidJvm]<br>open fun [addCloseable](../../-base-view-model/index.md#264516373%2FFunctions%2F1456247564)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [dismissCurrentError](../dismiss-current-error.md) | [androidJvm]<br>fun [dismissCurrentError](../dismiss-current-error.md)()<br>Dismisses error set in state if it is error |
| [dismissError](../dismiss-error.md) | [androidJvm]<br>open fun [dismissError](../dismiss-error.md)(error: Throwable)<br>Default action on critical error |
| [doClear](do-clear.md) | [androidJvm]<br>open override fun [doClear](do-clear.md)()<br>Disposes active operations when model is destroyed |
| [initialize](../../-base-view-model/initialize.md) | [androidJvm]<br>fun [initialize](../../-base-view-model/initialize.md)()<br>Call this function to initialize a new model and start receiving events |
| [refresh](refresh.md) | [androidJvm]<br>open override fun [refresh](refresh.md)()<br>Requests data refresh |
| [restart](restart.md) | [androidJvm]<br>open override fun [restart](restart.md)()<br>Retries data subscription from scratch |

## Properties

| Name | Summary |
|---|---|
| [cleared](../../-base-view-model/cleared.md) | [androidJvm]<br>var [cleared](../../-base-view-model/cleared.md): Boolean<br>Is model cleared |
| [initialized](../../-base-view-model/initialized.md) | [androidJvm]<br>var [initialized](../../-base-view-model/initialized.md): Boolean<br>Is model initialized |
| [state](state.md) | [androidJvm]<br>open override val [state](state.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[LceState](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;<br>LCE State |

## Inheritors

| Name |
|---|
| [WithUpdates](../-with-updates/index.md) |
