//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[LceState](index.md)

# LceState

[jvm]\
sealed class [LceState](index.md)&lt;out [DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

State for &quot;Loading-Content-Error&quot; resource which retrieves [data](data.md)

## Parameters

jvm

| | |
|---|---|
| DATA | Data Type of data being held |

## Types

| Name | Summary |
|---|---|
| [Content](-content/index.md) | [jvm]<br>data class [Content](-content/index.md)&lt;out [DATA](-content/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(val data: [DATA](-content/index.md), val dataIsValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [LceState](index.md)&lt;[DATA](-content/index.md)&gt; <br>Data is loaded and content is displayed |
| [Error](-error/index.md) | [jvm]<br>data class [Error](-error/index.md)&lt;out [DATA](-error/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(val data: [DATA](-error/index.md)?, val dataIsValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) : [LceState](index.md)&lt;[DATA](-error/index.md)&gt; <br>Data (or part of it) failed to load |
| [Loading](-loading/index.md) | [jvm]<br>data class [Loading](-loading/index.md)&lt;out [DATA](-loading/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(val data: [DATA](-loading/index.md)?, val dataIsValid: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val type: [LceState.Loading.Type](-loading/-type/index.md) = Type.LOADING) : [LceState](index.md)&lt;[DATA](-loading/index.md)&gt; <br>View is loading |
| [Terminated](-terminated/index.md) | [jvm]<br>object [Terminated](-terminated/index.md) : [LceState](index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)&gt; <br>A special state that may be used to terminate state emission in cases we always need a latest state to proceed For example we have a view that subscribes to [LceState](index.md) for a resource identified with some PARAMS. Than a delete operation is performed on that resource and it is not available anymore. The one may emit [Terminated](-terminated/index.md) to do a special processing (e.g. close the corresponding view) instead of doing it through server request that will return a `Not found` error and doing a special case processing afterwards. Also useful when `onComplete` from state-emitter can't be processed by the end-subscriber. For example LiveData does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion logic. |

## Functions

| Name | Summary |
|---|---|
| [toError](to-error.md) | [jvm]<br>fun [toError](to-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [LceState.Error](-error/index.md)&lt;[DATA](index.md)&gt;<br>Transfers to [Error](-error/index.md) state preserving data |
| [toLoading](to-loading.md) | [jvm]<br>fun [toLoading](to-loading.md)(type: [LceState.Loading.Type](-loading/-type/index.md) = Loading.Type.LOADING): [LceState.Loading](-loading/index.md)&lt;[DATA](index.md)&gt;<br>Transfers to [Loading](-loading/index.md) state preserving data |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [jvm]<br>abstract val [data](data.md): [DATA](index.md)?<br>State data |
| [dataIsValid](data-is-valid.md) | [jvm]<br>abstract val [dataIsValid](data-is-valid.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>A property that is evaluated internally and may mean that data being emitted is stall, invalidated or otherwise 'not-so-valid' until some further emission (say after network reload). |

## Inheritors

| Name |
|---|
| [Loading](-loading/index.md) |
| [Content](-content/index.md) |
| [Error](-error/index.md) |
| [Terminated](-terminated/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [catchToLce](../catch-to-lce.md) | [jvm]<br>inline fun &lt;[DATA_1](../catch-to-lce.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../catch-to-lce.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceState](index.md)&lt;[DATA_1](../catch-to-lce.md)&gt;.[catchToLce](../catch-to-lce.md)(block: [LceState](index.md)&lt;[DATA_1](../catch-to-lce.md)&gt;.() -&gt; [LceState](index.md)&lt;[DATA_2](../catch-to-lce.md)&gt;): [LceState](index.md)&lt;[DATA_2](../catch-to-lce.md)&gt;<br>Runs transformation [block](../catch-to-lce.md) catching any error and wrapping it to [LceState.Error](-error/index.md): |
| [combine](../combine.md) | [jvm]<br>inline fun &lt;[DATA_1](../combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_3](../combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceState](index.md)&lt;[DATA_1](../combine.md)&gt;.[combine](../combine.md)(other: [LceState](index.md)&lt;[DATA_2](../combine.md)&gt;, mapper: (data1: [DATA_1](../combine.md)?, data2: [DATA_2](../combine.md)?) -&gt; [DATA_3](../combine.md)?): [LceState](index.md)&lt;[DATA_3](../combine.md)&gt;<br>Combines two Lce states. Here is the result state matrix | Receiver   | other      | Result     | |------------|------------|------------| | Loading    | Loading    | Loading    | | Loading    | Content    | Loading    | | Loading    | Error      | Error      | | Loading    | Terminated | Terminated | | Content    | Loading    | Loading    | | Content    | Content    | Content*   | | Content    | Error      | Error      | | Content    | Terminated | Terminated | | Error      | Loading    | Error      | | Error      | Content    | Error      | | Error      | Error      | Error      | | Error      | Terminated | Terminated | | Terminated | Loading    | Terminated | | Terminated | Content    | Terminated | | Terminated | Error      | Terminated | | Terminated | Terminated | Terminated | |
| [map](../map.md) | [jvm]<br>inline fun &lt;[DATA_1](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](../map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceState](index.md)&lt;[DATA_1](../map.md)&gt;.[map](../map.md)(mapper: (data: [DATA_1](../map.md)) -&gt; [DATA_2](../map.md)): [LceState](index.md)&lt;[DATA_2](../map.md)&gt;<br>Maps data in LceState |
| [mapEmptyData](../map-empty-data.md) | [jvm]<br>inline fun &lt;[DATA](../map-empty-data.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceState](index.md)&lt;[DATA](../map-empty-data.md)&gt;.[mapEmptyData](../map-empty-data.md)(crossinline block: ([LceState](index.md)&lt;[DATA](../map-empty-data.md)&gt;) -&gt; [LceState](index.md)&lt;[DATA](../map-empty-data.md)&gt;): [LceState](index.md)&lt;[DATA](../map-empty-data.md)&gt;<br>Substitutes a state with empty data with empty data with state produced by [block](../map-empty-data.md) |
| [mapEmptyDataItem](../map-empty-data-item.md) | [jvm]<br>inline fun &lt;[DATA](../map-empty-data-item.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceState](index.md)&lt;[DATA](../map-empty-data-item.md)&gt;.[mapEmptyDataItem](../map-empty-data-item.md)(crossinline block: () -&gt; [DATA](../map-empty-data-item.md)?): [LceState](index.md)&lt;[DATA](../map-empty-data-item.md)&gt;<br>Substitutes an item in a state with empty data with item produced by [block](../map-empty-data-item.md) |
