//[viewmodel](../../index.md)/[com.motorro.rxlcemodel.viewmodel](../index.md)/[BaseViewModel](index.md)



# BaseViewModel  
 [androidJvm] 

Base view model with [initialize](initialize.md) and [doClear](do-clear.md) methods

abstract class [BaseViewModel](index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [BaseViewModel](-base-view-model.md)|  [androidJvm] fun [BaseViewModel](-base-view-model.md)()   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [clear](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#clear)| [androidJvm]  <br>Content  <br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)()  <br>  <br>override fun [clear](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#clear)()  <br><br><br>
| [doClear](do-clear.md)| [androidJvm]  <br>Brief description  <br><br><br>Disposes active operations when model is destroyed<br><br>  <br>Content  <br>abstract fun [doClear](do-clear.md)()  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [androidJvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getTag](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#gettag)| [androidJvm]  <br>Content  <br>open override fun <T : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [getTag](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#gettag)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): T  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [androidJvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [initialize](initialize.md)| [androidJvm]  <br>Brief description  <br><br><br>Call this function to initialize a new model and start receiving events<br><br>  <br>Content  <br>fun [initialize](initialize.md)()  <br><br><br>
| [setTagIfAbsent](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#settagifabsent)| [androidJvm]  <br>Content  <br>open override fun <T : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [setTagIfAbsent](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#settagifabsent)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: T): T  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [androidJvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [cleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseViewModel/cleared/#/PointingToDeclaration/)|  [androidJvm] <br><br>Is model cleared<br><br>var [cleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseViewModel/cleared/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [initialized](index.md#com.motorro.rxlcemodel.viewmodel/BaseViewModel/initialized/#/PointingToDeclaration/)|  [androidJvm] <br><br>Is model initialized<br><br>var [initialized](index.md#com.motorro.rxlcemodel.viewmodel/BaseViewModel/initialized/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [mBagOfTags](index.md#com.motorro.rxlcemodel.viewmodel/BaseViewModel/mBagOfTags/#/PointingToDeclaration/)|  [androidJvm] @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)()  <br>  <br>override val [mBagOfTags](index.md#com.motorro.rxlcemodel.viewmodel/BaseViewModel/mBagOfTags/#/PointingToDeclaration/): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>?   <br>
| [mCleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseViewModel/mCleared/#/PointingToDeclaration/)|  [androidJvm] override val [mCleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseViewModel/mCleared/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>


## Inheritors  
  
|  Name| 
|---|
| [BaseLceModel](../-base-lce-model/index.md)

