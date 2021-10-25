//[base](../../../../index.md)/[com.motorro.rxlcemodel.base](../../index.md)/[LceState](../index.md)/[Content](index.md)

# Content

[jvm]\
data class [Content](index.md)&lt;out [DATA](index.md) : Any&gt;(data: [DATA](index.md), dataIsValid: Boolean) : [LceState](../index.md)&lt;[DATA](index.md)&gt; 

Data is loaded and content is displayed

## Constructors

| | |
|---|---|
| [Content](-content.md) | [jvm]<br>fun &lt;out [DATA](index.md) : Any&gt; [Content](-content.md)(data: [DATA](index.md), dataIsValid: Boolean) |

## Functions

| Name | Summary |
|---|---|
| [toError](../to-error.md) | [jvm]<br>fun [toError](../to-error.md)(error: Throwable): [LceState.Error](../-error/index.md)&lt;[DATA](index.md)&gt;<br>Transfers to [Error](../-error/index.md) state preserving data |
| [toLoading](../to-loading.md) | [jvm]<br>fun [toLoading](../to-loading.md)(type: [LceState.Loading.Type](../-loading/-type/index.md) = Loading.Type.LOADING): [LceState.Loading](../-loading/index.md)&lt;[DATA](index.md)&gt;<br>Transfers to [Loading](../-loading/index.md) state preserving data |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [jvm]<br>open override val [data](data.md): [DATA](index.md)<br>State data |
| [dataIsValid](data-is-valid.md) | [jvm]<br>open override val [dataIsValid](data-is-valid.md): Boolean<br>Data validity at the time of emission |
