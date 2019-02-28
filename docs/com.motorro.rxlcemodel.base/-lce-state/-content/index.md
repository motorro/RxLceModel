[com.motorro.rxlcemodel.base](../../index.md) / [LceState](../index.md) / [Content](./index.md)

# Content

`data class Content<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](../index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>`

Data is loaded and content is displayed

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Content(data: `[`DATA`](index.md#DATA)`, dataIsValid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, params: `[`PARAMS`](index.md#PARAMS)`)`<br>Data is loaded and content is displayed |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `val data: `[`DATA`](index.md#DATA)<br>State data |
| [dataIsValid](data-is-valid.md) | `val dataIsValid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Data validity at the time of emission |
| [params](params.md) | `val params: `[`PARAMS`](index.md#PARAMS)<br>Params used to load [data](data.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [toError](../to-error.md) | `fun toError(error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Error`](../-error/index.md)`<`[`DATA`](../index.md#DATA)`, `[`PARAMS`](../index.md#PARAMS)`>`<br>Transfers to [Error](../-error/index.md) state preserving data |
| [toLoading](../to-loading.md) | `fun toLoading(type: `[`Type`](../-loading/-type/index.md)` = Loading.Type.LOADING): `[`Loading`](../-loading/index.md)`<`[`DATA`](../index.md#DATA)`, `[`PARAMS`](../index.md#PARAMS)`>`<br>Transfers to [Loading](../-loading/index.md) state preserving data |
