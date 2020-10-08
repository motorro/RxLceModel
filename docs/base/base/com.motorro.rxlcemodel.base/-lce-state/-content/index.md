//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../../index.md)/[LceState](../index.md)/[Content](index.md)



# Content  
 [jvm] 

Data is loaded and content is displayed

data class [Content](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**data**: [DATA](index.md), **dataIsValid**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [LceState](../index.md)<[DATA](index.md)>    


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [Content](-content.md)|  [jvm] fun <[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Content](-content.md)(data: [DATA](index.md), dataIsValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [component1](component1.md)| [jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [DATA](index.md)  <br><br><br>
| [component2](component2.md)| [jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [copy](copy.md)| [jvm]  <br>Content  <br>fun [copy](copy.md)(data: [DATA](index.md), dataIsValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [LceState.Content](index.md)<[DATA](index.md)>  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toError](../to-error.md)| [jvm]  <br>Brief description  <br><br><br>Transfers to [Error](../-error/index.md) state preserving data<br><br>  <br>Content  <br>override fun [toError](../to-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [LceState.Error](../-error/index.md)<[DATA](index.md)>  <br><br><br>
| [toLoading](../to-loading.md)| [jvm]  <br>Brief description  <br><br><br>Transfers to [Loading](../-loading/index.md) state preserving data<br><br>  <br>Content  <br>override fun [toLoading](../to-loading.md)(type: [LceState.Loading.Type](../-loading/-type/index.md)): [LceState.Loading](../-loading/index.md)<[DATA](index.md)>  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [data](index.md#com.motorro.rxlcemodel.base/LceState.Content/data/#/PointingToDeclaration/)|  [jvm] <br><br>State data<br><br>open override val [data](index.md#com.motorro.rxlcemodel.base/LceState.Content/data/#/PointingToDeclaration/): [DATA](index.md)   <br>
| [dataIsValid](index.md#com.motorro.rxlcemodel.base/LceState.Content/dataIsValid/#/PointingToDeclaration/)|  [jvm] <br><br>Data validity at the time of emission<br><br>open override val [dataIsValid](index.md#com.motorro.rxlcemodel.base/LceState.Content/dataIsValid/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>

