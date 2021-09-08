//[viewmodel](../../../index.md)/[com.motorro.rxlcemodel.viewmodel](../../index.md)/[BaseLceModel](../index.md)/[WithUpdates](index.md)



# WithUpdates  
 [androidJvm] 

View model with operations that mix with main state

open class [WithUpdates](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**dataUseCase**: LceUseCase<[DATA](index.md)>) : [BaseLceModel.Impl](../-impl/index.md)<[DATA](index.md)>    


## Parameters  
  
androidJvm  
  
|  Name|  Summary| 
|---|---|
| dataUseCase| <br><br>Main data use-case<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [WithUpdates](-with-updates.md)|  [androidJvm] <br><br>Main data use-case<br><br>fun <[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [WithUpdates](-with-updates.md)(dataUseCase: LceUseCase<[DATA](index.md)>)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [clear](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#clear)| [androidJvm]  <br>Content  <br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)()  <br>  <br>override fun [clear](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#clear)()  <br><br><br>
| [dismissCurrentError](../dismiss-current-error.md)| [androidJvm]  <br>Brief description  <br><br><br>Dismisses error set in state if it is error<br><br>  <br>Content  <br>override fun [dismissCurrentError](../dismiss-current-error.md)()  <br><br><br>
| [dismissError](../dismiss-error.md)| [androidJvm]  <br>Brief description  <br><br><br>Default action on critical error<br><br>  <br>Content  <br>open override fun [dismissError](../dismiss-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html))  <br><br><br>
| [doClear](../-impl/do-clear.md)| [androidJvm]  <br>Brief description  <br><br><br>Disposes active operations when model is destroyed<br><br>  <br>Content  <br>open override fun [doClear](../-impl/do-clear.md)()  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [androidJvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getTag](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#gettag)| [androidJvm]  <br>Content  <br>open override fun <T : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [getTag](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#gettag)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): T  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [androidJvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [initialize](../../-base-view-model/initialize.md)| [androidJvm]  <br>Brief description  <br><br><br>Call this function to initialize a new model and start receiving events<br><br>  <br>Content  <br>override fun [initialize](../../-base-view-model/initialize.md)()  <br><br><br>
| [refresh](../-impl/refresh.md)| [androidJvm]  <br>Brief description  <br><br><br>Requests data refresh<br><br>  <br>Content  <br>open override fun [refresh](../-impl/refresh.md)()  <br><br><br>
| [restart](../-impl/restart.md)| [androidJvm]  <br>Brief description  <br><br><br>Retries data subscription from scratch<br><br>  <br>Content  <br>open override fun [restart](../-impl/restart.md)()  <br><br><br>
| [setTagIfAbsent](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#settagifabsent)| [androidJvm]  <br>Content  <br>open override fun <T : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [setTagIfAbsent](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#settagifabsent)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: T): T  <br><br><br>
| subscribeData| [androidJvm]  <br>Brief description  <br><br><br>Subscribes to data<br><br>  <br>Content  <br>override fun subscribeData()  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [androidJvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [cleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/cleared/#/PointingToDeclaration/)|  [androidJvm] <br><br>Is model cleared<br><br>override var [cleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/cleared/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [disposables](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/disposables/#/PointingToDeclaration/)|  [androidJvm] <br><br>Maintains refresh subscriptions<br><br>override var [disposables](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/disposables/#/PointingToDeclaration/): [CompositeDisposable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/disposables/CompositeDisposable.html)   <br>
| [initialized](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/initialized/#/PointingToDeclaration/)|  [androidJvm] <br><br>Is model initialized<br><br>override var [initialized](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/initialized/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [mBagOfTags](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/mBagOfTags/#/PointingToDeclaration/)|  [androidJvm] @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)()  <br>  <br>override val [mBagOfTags](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/mBagOfTags/#/PointingToDeclaration/): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>?   <br>
| [mCleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/mCleared/#/PointingToDeclaration/)|  [androidJvm] override val [mCleared](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/mCleared/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [state](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/state/#/PointingToDeclaration/)|  [androidJvm] <br><br>LCE State<br><br>open override val [state](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/state/#/PointingToDeclaration/): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)<LceState<[DATA](index.md)>>   <br>
| [stateData](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/stateData/#/PointingToDeclaration/)|  [androidJvm] <br><br>State live-data<br><br>override val [stateData](index.md#com.motorro.rxlcemodel.viewmodel/BaseLceModel.WithUpdates/stateData/#/PointingToDeclaration/): [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)<LceState<[DATA](index.md)>>   <br>

