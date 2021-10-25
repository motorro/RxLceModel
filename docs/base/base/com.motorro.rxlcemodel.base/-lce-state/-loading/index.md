//[base](../../../../index.md)/[com.motorro.rxlcemodel.base](../../index.md)/[LceState](../index.md)/[Loading](index.md)

# Loading

[jvm]\
data class [Loading](index.md)&lt;out [DATA](index.md) : Any&gt;@JvmOverloadsconstructor(data: [DATA](index.md)?, dataIsValid: Boolean, type: [LceState.Loading.Type](-type/index.md)) : [LceState](../index.md)&lt;[DATA](index.md)&gt; 

View is loading

## Constructors

| | |
|---|---|
| [Loading](-loading.md) | [jvm]<br>@JvmOverloads<br>fun &lt;out [DATA](index.md) : Any&gt; [Loading](-loading.md)(data: [DATA](index.md)?, dataIsValid: Boolean, type: [LceState.Loading.Type](-type/index.md) = Type.LOADING) |

## Types

| Name | Summary |
|---|---|
| [Type](-type/index.md) | [jvm]<br>enum [Type](-type/index.md) : Enum&lt;[LceState.Loading.Type](-type/index.md)&gt; <br>Loading type |

## Functions

| Name | Summary |
|---|---|
| [toError](../to-error.md) | [jvm]<br>fun [toError](../to-error.md)(error: Throwable): [LceState.Error](../-error/index.md)&lt;[DATA](index.md)&gt;<br>Transfers to [Error](../-error/index.md) state preserving data |
| [toLoading](../to-loading.md) | [jvm]<br>fun [toLoading](../to-loading.md)(type: [LceState.Loading.Type](-type/index.md) = Loading.Type.LOADING): [LceState.Loading](index.md)&lt;[DATA](index.md)&gt;<br>Transfers to [Loading](index.md) state preserving data |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [jvm]<br>open override val [data](data.md): [DATA](index.md)?<br>State data |
| [dataIsValid](data-is-valid.md) | [jvm]<br>open override val [dataIsValid](data-is-valid.md): Boolean<br>Data validity at the time of emission |
| [type](type.md) | [jvm]<br>val [type](type.md): [LceState.Loading.Type](-type/index.md)<br>Loading type |
