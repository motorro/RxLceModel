//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../../index.md)/[LceState](../index.md)/[Loading](index.md)



# Loading  
 [jvm] 

View is loading

data class [Loading](index.md)<[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()constructor(**data**: [DATA](index.md)?, **dataIsValid**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **type**: [LceState.Loading.Type](-type/index.md)) : [LceState](../index.md)<[DATA](index.md)>    


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [Loading](-loading.md)|  [jvm] @[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  <br>  <br>fun <[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Loading](-loading.md)(data: [DATA](index.md)?, dataIsValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), type: [LceState.Loading.Type](-type/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| [Type](-type/index.md)| [jvm]  <br>Brief description  <br><br><br>Loading type<br><br>  <br>Content  <br>enum [Type](-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[LceState.Loading.Type](-type/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [component1](component1.md)| [jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [DATA](index.md)?  <br><br><br>
| [component2](component2.md)| [jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [component3](component3.md)| [jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [LceState.Loading.Type](-type/index.md)  <br><br><br>
| [copy](copy.md)| [jvm]  <br>Content  <br>fun [copy](copy.md)(data: [DATA](index.md)?, dataIsValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), type: [LceState.Loading.Type](-type/index.md)): [LceState.Loading](index.md)<[DATA](index.md)>  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toError](../to-error.md)| [jvm]  <br>Brief description  <br><br><br>Transfers to [Error](../-error/index.md) state preserving data<br><br>  <br>Content  <br>override fun [toError](../to-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [LceState.Error](../-error/index.md)<[DATA](index.md)>  <br><br><br>
| [toLoading](../to-loading.md)| [jvm]  <br>Brief description  <br><br><br>Transfers to [Loading](index.md) state preserving data<br><br>  <br>Content  <br>override fun [toLoading](../to-loading.md)(type: [LceState.Loading.Type](-type/index.md)): [LceState.Loading](index.md)<[DATA](index.md)>  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [data](index.md#com.motorro.rxlcemodel.base/LceState.Loading/data/#/PointingToDeclaration/)|  [jvm] <br><br>State data<br><br>open override val [data](index.md#com.motorro.rxlcemodel.base/LceState.Loading/data/#/PointingToDeclaration/): [DATA](index.md)?   <br>
| [dataIsValid](index.md#com.motorro.rxlcemodel.base/LceState.Loading/dataIsValid/#/PointingToDeclaration/)|  [jvm] <br><br>Data validity at the time of emission<br><br>open override val [dataIsValid](index.md#com.motorro.rxlcemodel.base/LceState.Loading/dataIsValid/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [type](index.md#com.motorro.rxlcemodel.base/LceState.Loading/type/#/PointingToDeclaration/)|  [jvm] <br><br>Loading type<br><br>val [type](index.md#com.motorro.rxlcemodel.base/LceState.Loading/type/#/PointingToDeclaration/): [LceState.Loading.Type](-type/index.md)   <br>

