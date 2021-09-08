//[viewmodel](../../../index.md)/[com.motorro.rxlcemodel.viewmodel](../../index.md)/[BaseLceModel](../index.md)/[Impl](index.md)



# Impl  
 [androidJvm] 

Basic ViewModel with LceModel inside

abstract class [Impl](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> : [BaseLceModel](../index.md)<[DATA](index.md)>    


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [Impl](-impl.md)|  [androidJvm] fun [Impl](-impl.md)()   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| [Companion](-companion/index.md)| [androidJvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [clear](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#clear)| [androidJvm]  <br>Content  <br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)()  <br>  <br>override fun [clear](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#clear)()  <br><br><br>
| [dismissCurrentError](../dismiss-current-error.md)| [androidJvm]  <br>Brief description  <br><br><br>Dismisses error set in state if it is error<br><br>  <br>Content  <br>override fun [dismissCurrentError](../dismiss-current-error.md)()  <br><br><br>
| [dismissError](../dismiss-error.md)| [androidJvm]  <br>Brief description  <br><br><br>Default action on critical error<br><br>  <br>Content  <br>open override fun [dismissError](../dismiss-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html))  <br><br><br>
| [doClear](do-clear.md)| [androidJvm]  <br>Brief description  <br><br><br>Disposes active operations when model is destroyed<br><br>  <br>Content  <br>open override fun [doClear](do-clear.md)()  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [androidJvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getTag](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#gettag)| [androidJvm]  <br>Content  <br>open override fun <T : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [getTag](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#gettag)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): T  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [androidJvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [initialize](../../-base-view-model/initialize.md)| [androidJvm]  <br>Brief description  <br><br><br>Call this function to initialize a new model and start receiving events<br><br>  <br>Content  <br>override fun [initialize](../../-base-view-model/initialize.md)()  <br><br><br>
| [refresh](refresh.md)| [androidJvm]  <br>Brief description  <br><br><br>Requests data refresh<br><br>  <br>Content  <br>open override fun [refresh](refresh.md)()  <br><br><br>
| [restart](restart.md)| [androidJvm]  <br>Brief description  <br><br><br>Retries data subscription from scratch<br><br>  <br>Content  <br>open override fun [restart](restart.md)()  <br><br><br>
| [setTagIfAbsent](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#settagifabsent)| [androidJvm]  <br>Content  <br>open override fun <T : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [setTagIfAbsent](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#settagifabsent)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: T): T  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [androidJvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [cleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.Impl/cleared/#/PointingToDeclaration/)|  [androidJvm] <br><br>Is model cleared<br><br>override var [cleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.Impl/cleared/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [initialized](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.Impl/initialized/#/PointingToDeclaration/)|  [androidJvm] <br><br>Is model initialized<br><br>override var [initialized](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.Impl/initialized/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [mBagOfTags](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.Impl/mBagOfTags/#/PointingToDeclaration/)|  [androidJvm] @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)()  <br>  <br>override val [mBagOfTags](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.Impl/mBagOfTags/#/PointingToDeclaration/): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>?   <br>
| [mCleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.Impl/mCleared/#/PointingToDeclaration/)|  [androidJvm] override val [mCleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.Impl/mCleared/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [state](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.Impl/state/#/PointingToDeclaration/)|  [androidJvm] <br><br>LCE State<br><br>open override val [state](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.Impl/state/#/PointingToDeclaration/): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)<LceState<[DATA](index.md)>>   <br>


## Inheritors  
  
|  Name| 
|---|
| [BaseLceModel](../-with-updates/index.md)

