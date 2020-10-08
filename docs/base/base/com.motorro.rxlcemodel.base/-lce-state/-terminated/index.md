//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../../index.md)/[LceState](../index.md)/[Terminated](index.md)



# Terminated  
 [jvm] 

A special state that may be used to terminate state emission in cases we always need a latest state to proceed For example we have a view that subscribes to [LceState](../index.md) for a resource identified with some PARAMS. Than a delete operation is performed on that resource and it is not available anymore. The one may emit [Terminated](index.md) to do a special processing (e.g. close the corresponding view) instead of doing it through server request that will return a Not found error and doing a special case processing afterwards. Also useful when onComplete from state-emitter can't be processed by the end-subscriber. For example LiveData does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion logic.

class [Terminated](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> : [LceState](../index.md)<[DATA](index.md)>    


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [Terminated](-terminated.md)|  [jvm] fun [Terminated](-terminated.md)()   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](equals.md)| [jvm]  <br>Content  <br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](hash-code.md)| [jvm]  <br>Content  <br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toError](../to-error.md)| [jvm]  <br>Brief description  <br><br><br>Transfers to [Error](../-error/index.md) state preserving data<br><br>  <br>Content  <br>override fun [toError](../to-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [LceState.Error](../-error/index.md)<[DATA](index.md)>  <br><br><br>
| [toLoading](../to-loading.md)| [jvm]  <br>Brief description  <br><br><br>Transfers to [Loading](../-loading/index.md) state preserving data<br><br>  <br>Content  <br>override fun [toLoading](../to-loading.md)(type: [LceState.Loading.Type](../-loading/-type/index.md)): [LceState.Loading](../-loading/index.md)<[DATA](index.md)>  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [data](index.md#com.motorro.rxlcemodel.base/LceState.Terminated/data/#/PointingToDeclaration/)|  [jvm] <br><br>State data<br><br>open override val [data](index.md#com.motorro.rxlcemodel.base/LceState.Terminated/data/#/PointingToDeclaration/): [DATA](index.md)?   <br>
| [dataIsValid](index.md#com.motorro.rxlcemodel.base/LceState.Terminated/dataIsValid/#/PointingToDeclaration/)|  [jvm] <br><br>A property that is evaluated internally and may mean that data being emitted is stall, invalidated or otherwise 'not-so-valid' until some further emission (say after network reload).<br><br>open override val [dataIsValid](index.md#com.motorro.rxlcemodel.base/LceState.Terminated/dataIsValid/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>

