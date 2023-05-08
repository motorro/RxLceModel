//[lce](../../../../index.md)/[com.motorro.rxlcemodel.lce](../../index.md)/[LceState](../index.md)/[Terminated](index.md)

# Terminated

[common]\
object [Terminated](index.md) : [LceState](../index.md)&lt;Nothing&gt; 

A special state that may be used to terminate state emission in cases we always need a latest state to proceed For example we have a view that subscribes to [LceState](../index.md) for a resource identified with some PARAMS. Than a delete operation is performed on that resource and it is not available anymore. The one may emit [Terminated](index.md) to do a special processing (e.g. close the corresponding view) instead of doing it through server request that will return a `Not found` error and doing a special case processing afterwards. Also useful when `onComplete` from state-emitter can't be processed by the end-subscriber. For example LiveData does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion logic.

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: Any?): Boolean |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): Int |
| [toError](../to-error.md) | [common]<br>fun [toError](../to-error.md)(error: Throwable): [LceState.Error](../-error/index.md)&lt;Nothing&gt;<br>Transfers to [Error](../-error/index.md) state preserving data |
| [toLoading](../to-loading.md) | [common]<br>fun [toLoading](../to-loading.md)(type: [LceState.Loading.Type](../-loading/-type/index.md) = Loading.Type.LOADING): [LceState.Loading](../-loading/index.md)&lt;Nothing&gt;<br>Transfers to [Loading](../-loading/index.md) state preserving data |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [common]<br>open override val [data](data.md): Nothing? = null<br>State data |
| [dataIsValid](data-is-valid.md) | [common]<br>open override val [dataIsValid](data-is-valid.md): Boolean = false<br>A property that is evaluated internally and may mean that data being emitted is stall, invalidated or otherwise 'not-so-valid' until some further emission (say after network reload). |

## Extensions

| Name | Summary |
|---|---|
| [catchToLce](../../catch-to-lce.md) | [common]<br>inline fun &lt;[DATA_1](../../catch-to-lce.md) : Any, [DATA_2](../../catch-to-lce.md) : Any&gt; [LceState](../index.md)&lt;[DATA_1](../../catch-to-lce.md)&gt;.[catchToLce](../../catch-to-lce.md)(block: [LceState](../index.md)&lt;[DATA_1](../../catch-to-lce.md)&gt;.() -&gt; [LceState](../index.md)&lt;[DATA_2](../../catch-to-lce.md)&gt;): [LceState](../index.md)&lt;[DATA_2](../../catch-to-lce.md)&gt;<br>Runs transformation [block](../../catch-to-lce.md) catching any error and wrapping it to [LceState.Error](../-error/index.md): |
| [combine](../../combine.md) | [common]<br>inline fun &lt;[DATA_1](../../combine.md) : Any, [DATA_2](../../combine.md) : Any, [DATA_3](../../combine.md) : Any&gt; [LceState](../index.md)&lt;[DATA_1](../../combine.md)&gt;.[combine](../../combine.md)(other: [LceState](../index.md)&lt;[DATA_2](../../combine.md)&gt;, mapper: (data1: [DATA_1](../../combine.md)?, data2: [DATA_2](../../combine.md)?) -&gt; [DATA_3](../../combine.md)?): [LceState](../index.md)&lt;[DATA_3](../../combine.md)&gt;<br>Combines two Lce states. Here is the result state matrix | Receiver   | other      | Result     | |------------|------------|------------| | Loading    | Loading    | Loading    | | Loading    | Content    | Loading    | | Loading    | Error      | Error      | | Loading    | Terminated | Terminated | | Content    | Loading    | Loading    | | Content    | Content    | Content*   | | Content    | Error      | Error      | | Content    | Terminated | Terminated | | Error      | Loading    | Error      | | Error      | Content    | Error      | | Error      | Error      | Error      | | Error      | Terminated | Terminated | | Terminated | Loading    | Terminated | | Terminated | Content    | Terminated | | Terminated | Error      | Terminated | | Terminated | Terminated | Terminated | |
| [flatMap](../../flat-map.md) | [common]<br>inline fun &lt;[DATA_1](../../flat-map.md) : Any, [DATA_2](../../flat-map.md) : Any&gt; [LceState](../index.md)&lt;[DATA_1](../../flat-map.md)&gt;.[flatMap](../../flat-map.md)(mapper: (data1: [DATA_1](../../flat-map.md)) -&gt; [LceState](../index.md)&lt;[DATA_2](../../flat-map.md)&gt;): [LceState](../index.md)&lt;[DATA_2](../../flat-map.md)&gt;<br>Flat-maps Lce states with the result of other Here is the result state matrix | Receiver   | mapper     | Result     | |------------|------------|------------| | Loading    | Loading    | Loading    | | Loading    | Content    | Loading    | | Loading    | Error      | Error      | | Loading    | Terminated | Terminated | | Content    | Loading    | Loading    | | Content    | Content    | Content*   | | Content    | Error      | Error      | | Content    | Terminated | Terminated | | Error      | Loading    | Error      | | Error      | Content    | Error      | | Error      | Error      | Error      | | Error      | Terminated | Terminated | | Terminated | Loading    | Terminated | | Terminated | Content    | Terminated | | Terminated | Error      | Terminated | | Terminated | Terminated | Terminated | |
| [map](../../map.md) | [common]<br>inline fun &lt;[DATA_1](../../map.md) : Any, [DATA_2](../../map.md) : Any&gt; [LceState](../index.md)&lt;[DATA_1](../../map.md)&gt;.[map](../../map.md)(mapper: (data: [DATA_1](../../map.md)) -&gt; [DATA_2](../../map.md)): [LceState](../index.md)&lt;[DATA_2](../../map.md)&gt;<br>Maps data in LceState |
| [mapEmptyData](../../map-empty-data.md) | [common]<br>inline fun &lt;[DATA](../../map-empty-data.md) : Any&gt; [LceState](../index.md)&lt;[DATA](../../map-empty-data.md)&gt;.[mapEmptyData](../../map-empty-data.md)(crossinline block: ([LceState](../index.md)&lt;[DATA](../../map-empty-data.md)&gt;) -&gt; [LceState](../index.md)&lt;[DATA](../../map-empty-data.md)&gt;): [LceState](../index.md)&lt;[DATA](../../map-empty-data.md)&gt;<br>Substitutes a state with empty data with empty data with state produced by [block](../../map-empty-data.md) |
| [mapEmptyDataItem](../../map-empty-data-item.md) | [common]<br>inline fun &lt;[DATA](../../map-empty-data-item.md) : Any&gt; [LceState](../index.md)&lt;[DATA](../../map-empty-data-item.md)&gt;.[mapEmptyDataItem](../../map-empty-data-item.md)(crossinline block: () -&gt; [DATA](../../map-empty-data-item.md)?): [LceState](../index.md)&lt;[DATA](../../map-empty-data-item.md)&gt;<br>Substitutes an item in a state with empty data with item produced by [block](../../map-empty-data-item.md) |
