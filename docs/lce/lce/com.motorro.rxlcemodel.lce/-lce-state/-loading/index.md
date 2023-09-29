//[lce](../../../../index.md)/[com.motorro.rxlcemodel.lce](../../index.md)/[LceState](../index.md)/[Loading](index.md)

# Loading

[common]\
data class [Loading](index.md)&lt;out [DATA](index.md) : Any&gt;(val data: [DATA](index.md)?, val dataIsValid: Boolean, val type: [LceState.Loading.Type](-type/index.md) = Type.LOADING) : [LceState](../index.md)&lt;[DATA](index.md)&gt; 

View is loading

## Constructors

| | |
|---|---|
| [Loading](-loading.md) | [common]<br>fun &lt;out [DATA](index.md) : Any&gt; [Loading](-loading.md)(data: [DATA](index.md)?, dataIsValid: Boolean, type: [LceState.Loading.Type](-type/index.md) = Type.LOADING) |

## Types

| Name | Summary |
|---|---|
| [Type](-type/index.md) | [common]<br>enum [Type](-type/index.md) : Enum&lt;[LceState.Loading.Type](-type/index.md)&gt; <br>Loading type |

## Functions

| Name | Summary |
|---|---|
| [toError](../to-error.md) | [common]<br>fun [toError](../to-error.md)(error: Throwable): [LceState.Error](../-error/index.md)&lt;[DATA](index.md)&gt;<br>Transfers to [Error](../-error/index.md) state preserving data |
| [toLoading](../to-loading.md) | [common]<br>fun [toLoading](../to-loading.md)(type: [LceState.Loading.Type](-type/index.md) = Loading.Type.LOADING): [LceState.Loading](index.md)&lt;[DATA](index.md)&gt;<br>Transfers to [Loading](index.md) state preserving data |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [common]<br>open override val [data](data.md): [DATA](index.md)?<br>State data |
| [dataIsValid](data-is-valid.md) | [common]<br>open override val [dataIsValid](data-is-valid.md): Boolean<br>Data validity at the time of emission |
| [type](type.md) | [common]<br>val [type](type.md): [LceState.Loading.Type](-type/index.md)<br>Loading type |

## Extensions

| Name | Summary |
|---|---|
| [catchToLce](../../catch-to-lce.md) | [common]<br>inline fun &lt;[DATA_1](../../catch-to-lce.md) : Any, [DATA_2](../../catch-to-lce.md) : Any&gt; [LceState](../index.md)&lt;[DATA_1](../../catch-to-lce.md)&gt;.[catchToLce](../../catch-to-lce.md)(block: [LceState](../index.md)&lt;[DATA_1](../../catch-to-lce.md)&gt;.() -&gt; [LceState](../index.md)&lt;[DATA_2](../../catch-to-lce.md)&gt;): [LceState](../index.md)&lt;[DATA_2](../../catch-to-lce.md)&gt;<br>Runs transformation [block](../../catch-to-lce.md) catching any error and wrapping it to [LceState.Error](../-error/index.md): |
| [combine](../../combine.md) | [common]<br>inline fun &lt;[DATA_1](../../combine.md) : Any, [DATA_2](../../combine.md) : Any, [DATA_3](../../combine.md) : Any&gt; [LceState](../index.md)&lt;[DATA_1](../../combine.md)&gt;.[combine](../../combine.md)(other: [LceState](../index.md)&lt;[DATA_2](../../combine.md)&gt;, mapper: (data1: [DATA_1](../../combine.md)?, data2: [DATA_2](../../combine.md)?) -&gt; [DATA_3](../../combine.md)?): [LceState](../index.md)&lt;[DATA_3](../../combine.md)&gt;<br>Combines two Lce states. Here is the result state matrix | Receiver   | other      | Result     | |------------|------------|------------| | Loading    | Loading    | Loading    | | Loading    | Content    | Loading    | | Loading    | Error      | Error      | | Loading    | Terminated | Terminated | | Content    | Loading    | Loading    | | Content    | Content    | Content*   | | Content    | Error      | Error      | | Content    | Terminated | Terminated | | Error      | Loading    | Error      | | Error      | Content    | Error      | | Error      | Error      | Error      | | Error      | Terminated | Terminated | | Terminated | Loading    | Terminated | | Terminated | Content    | Terminated | | Terminated | Error      | Terminated | | Terminated | Terminated | Terminated | |
| [flatMap](../../flat-map.md) | [common]<br>inline fun &lt;[DATA_1](../../flat-map.md) : Any, [DATA_2](../../flat-map.md) : Any&gt; [LceState](../index.md)&lt;[DATA_1](../../flat-map.md)&gt;.[flatMap](../../flat-map.md)(mapper: (data1: [DATA_1](../../flat-map.md)) -&gt; [LceState](../index.md)&lt;[DATA_2](../../flat-map.md)&gt;): [LceState](../index.md)&lt;[DATA_2](../../flat-map.md)&gt;<br>Flat-maps Lce states with the result of other Here is the result state matrix | Receiver   | mapper     | Result     | |------------|------------|------------| | Loading    | Loading    | Loading    | | Loading    | Content    | Loading    | | Loading    | Error      | Error      | | Loading    | Terminated | Terminated | | Content    | Loading    | Loading    | | Content    | Content    | Content*   | | Content    | Error      | Error      | | Content    | Terminated | Terminated | | Error      | Loading    | Error      | | Error      | Content    | Error      | | Error      | Error      | Error      | | Error      | Terminated | Terminated | | Terminated | Loading    | Terminated | | Terminated | Content    | Terminated | | Terminated | Error      | Terminated | | Terminated | Terminated | Terminated | |
| [map](../../map.md) | [common]<br>inline fun &lt;[DATA_1](../../map.md) : Any, [DATA_2](../../map.md) : Any&gt; [LceState](../index.md)&lt;[DATA_1](../../map.md)&gt;.[map](../../map.md)(mapper: (data: [DATA_1](../../map.md)) -&gt; [DATA_2](../../map.md)): [LceState](../index.md)&lt;[DATA_2](../../map.md)&gt;<br>Maps data in LceState |
| [mapEmptyData](../../map-empty-data.md) | [common]<br>inline fun &lt;[DATA](../../map-empty-data.md) : Any&gt; [LceState](../index.md)&lt;[DATA](../../map-empty-data.md)&gt;.[mapEmptyData](../../map-empty-data.md)(crossinline block: ([LceState](../index.md)&lt;[DATA](../../map-empty-data.md)&gt;) -&gt; [LceState](../index.md)&lt;[DATA](../../map-empty-data.md)&gt;): [LceState](../index.md)&lt;[DATA](../../map-empty-data.md)&gt;<br>Substitutes a state with empty data with empty data with state produced by [block](../../map-empty-data.md) |
| [mapEmptyDataItem](../../map-empty-data-item.md) | [common]<br>inline fun &lt;[DATA](../../map-empty-data-item.md) : Any&gt; [LceState](../index.md)&lt;[DATA](../../map-empty-data-item.md)&gt;.[mapEmptyDataItem](../../map-empty-data-item.md)(crossinline block: () -&gt; [DATA](../../map-empty-data-item.md)?): [LceState](../index.md)&lt;[DATA](../../map-empty-data-item.md)&gt;<br>Substitutes an item in a state with empty data with item produced by [block](../../map-empty-data-item.md) |