//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[LceState](index.md)



# LceState  
 [jvm] 

State for "Loading-Content-Error" resource which retrieves [data](index.md#com.motorro.rxlcemodel.base/LceState/data/#/PointingToDeclaration/)

sealed class [LceState](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>   


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| DATA| <br><br>Data Type of data being held<br><br>
  


## Types  
  
|  Name|  Summary| 
|---|---|
| [Content](-content/index.md)| [jvm]  <br>Brief description  <br><br><br>Data is loaded and content is displayed<br><br>  <br>Content  <br>data class [Content](-content/index.md)<[DATA](-content/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**data**: [DATA](-content/index.md), **dataIsValid**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [LceState](index.md)<[DATA](-content/index.md)>   <br><br><br>
| [Error](-error/index.md)| [jvm]  <br>Brief description  <br><br><br>Data (or part of it) failed to load<br><br>  <br>Content  <br>data class [Error](-error/index.md)<[DATA](-error/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**data**: [DATA](-error/index.md)?, **dataIsValid**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **error**: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) : [LceState](index.md)<[DATA](-error/index.md)>   <br><br><br>
| [Loading](-loading/index.md)| [jvm]  <br>Brief description  <br><br><br>View is loading<br><br>  <br>Content  <br>data class [Loading](-loading/index.md)<[DATA](-loading/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()constructor(**data**: [DATA](-loading/index.md)?, **dataIsValid**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **type**: [LceState.Loading.Type](-loading/-type/index.md)) : [LceState](index.md)<[DATA](-loading/index.md)>   <br><br><br>
| [Terminated](-terminated/index.md)| [jvm]  <br>Brief description  <br><br><br>A special state that may be used to terminate state emission in cases we always need a latest state to proceed For example we have a view that subscribes to [LceState](index.md) for a resource identified with some PARAMS. Than a delete operation is performed on that resource and it is not available anymore. The one may emit [Terminated](-terminated/index.md) to do a special processing (e.g. close the corresponding view) instead of doing it through server request that will return a Not found error and doing a special case processing afterwards. Also useful when onComplete from state-emitter can't be processed by the end-subscriber. For example LiveData does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion logic.<br><br>  <br>Content  <br>class [Terminated](-terminated/index.md)<[DATA](-terminated/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> : [LceState](index.md)<[DATA](-terminated/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toError](to-error.md)| [jvm]  <br>Brief description  <br><br><br>Transfers to [Error](-error/index.md) state preserving data<br><br>  <br>Content  <br>fun [toError](to-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [LceState.Error](-error/index.md)<[DATA](index.md)>  <br><br><br>
| [toLoading](to-loading.md)| [jvm]  <br>Brief description  <br><br><br>Transfers to [Loading](-loading/index.md) state preserving data<br><br>  <br>Content  <br>fun [toLoading](to-loading.md)(type: [LceState.Loading.Type](-loading/-type/index.md)): [LceState.Loading](-loading/index.md)<[DATA](index.md)>  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [data](index.md#com.motorro.rxlcemodel.base/LceState/data/#/PointingToDeclaration/)|  [jvm] <br><br>State data<br><br>abstract val [data](index.md#com.motorro.rxlcemodel.base/LceState/data/#/PointingToDeclaration/): [DATA](index.md)?   <br>
| [dataIsValid](index.md#com.motorro.rxlcemodel.base/LceState/dataIsValid/#/PointingToDeclaration/)|  [jvm] <br><br>A property that is evaluated internally and may mean that data being emitted is stall, invalidated or otherwise 'not-so-valid' until some further emission (say after network reload).<br><br>abstract val [dataIsValid](index.md#com.motorro.rxlcemodel.base/LceState/dataIsValid/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>


## Inheritors  
  
|  Name| 
|---|
| [LceState](-loading/index.md)
| [LceState](-content/index.md)
| [LceState](-error/index.md)
| [LceState](-terminated/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| [combine](../combine.md)| [jvm]  <br>Brief description  <br><br><br>Combines two Lce states. Here is the result state matrix | Receiver   | other      | Result     | |------------|------------|------------| | Loading    | Loading    | Loading    | | Loading    | Content    | Loading    | | Loading    | Error      | Error      | | Loading    | Terminated | Terminated | | Content    | Loading    | Loading    | | Content    | Content    | Content*   | | Content    | Error      | Error      | | Content    | Terminated | Terminated | | Error      | Loading    | Error      | | Error      | Content    | Error      | | Error      | Error      | Error      | | Error      | Terminated | Terminated | | Terminated | Loading    | Terminated | | Terminated | Content    | Terminated | | Terminated | Error      | Terminated | | Terminated | Terminated | Terminated |<br><br>  <br>Content  <br>inline fun <[DATA_1](../combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_3](../combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceState](index.md)<[DATA_1](../combine.md)>.[combine](../combine.md)(other: [LceState](index.md)<[DATA_2](../combine.md)>, mapper: ([DATA_1](../combine.md)?, [DATA_2](../combine.md)?) -> [DATA_3](../combine.md)?): [LceState](index.md)<[DATA_3](../combine.md)>  <br><br><br>
| [map](../map.md)| [jvm]  <br>Brief description  <br><br><br>Maps data in LceState<br><br>  <br>Content  <br>inline fun <[DATA_1](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceState](index.md)<[DATA_1](../map.md)>.[map](../map.md)(mapper: ([DATA_1](../map.md)) -> [DATA_2](../map.md)): [LceState](index.md)<[DATA_2](../map.md)>  <br><br><br>

