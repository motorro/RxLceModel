//[base](../../../../index.md)/[com.motorro.rxlcemodel.base](../../index.md)/[LceState](../index.md)/[Error](index.md)

# Error

[jvm]\
data class [Error](index.md)&lt;out [DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(val data: [DATA](index.md)?, val dataIsValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) : [LceState](../index.md)&lt;[DATA](index.md)&gt; 

Data (or part of it) failed to load

## Constructors

| | |
|---|---|
| [Error](-error.md) | [jvm]<br>fun &lt;out [DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [Error](-error.md)(data: [DATA](index.md)?, dataIsValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [toError](../to-error.md) | [jvm]<br>fun [toError](../to-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [LceState.Error](index.md)&lt;[DATA](index.md)&gt;<br>Transfers to [Error](index.md) state preserving data |
| [toLoading](../to-loading.md) | [jvm]<br>fun [toLoading](../to-loading.md)(type: [LceState.Loading.Type](../-loading/-type/index.md) = Loading.Type.LOADING): [LceState.Loading](../-loading/index.md)&lt;[DATA](index.md)&gt;<br>Transfers to [Loading](../-loading/index.md) state preserving data |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [jvm]<br>open override val [data](data.md): [DATA](index.md)?<br>State data |
| [dataIsValid](data-is-valid.md) | [jvm]<br>open override val [dataIsValid](data-is-valid.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Data validity at the time of emission |
| [error](error.md) | [jvm]<br>val [error](error.md): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)<br>Data load error |
