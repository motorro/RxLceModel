[com.motorro.rxlcemodel.base](../../index.md) / [LceState](../index.md) / [Loading](./index.md)

# Loading

`data class Loading<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](../index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>`

View is loading

### Types

| Name | Summary |
|---|---|
| [Type](-type/index.md) | `enum class Type`<br>Loading type |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Loading(data: `[`DATA`](index.md#DATA)`?, dataIsValid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, params: `[`PARAMS`](index.md#PARAMS)`, type: `[`Type`](-type/index.md)` = Type.LOADING)`<br>View is loading |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `val data: `[`DATA`](index.md#DATA)`?`<br>State data |
| [dataIsValid](data-is-valid.md) | `val dataIsValid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Data validity at the time of emission |
| [params](params.md) | `val params: `[`PARAMS`](index.md#PARAMS)<br>Params used to load [data](data.md) |
| [type](type.md) | `val type: `[`Type`](-type/index.md)<br>Loading type |

### Inherited Functions

| Name | Summary |
|---|---|
| [toError](../to-error.md) | `fun toError(error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Error`](../-error/index.md)`<`[`DATA`](../index.md#DATA)`, `[`PARAMS`](../index.md#PARAMS)`>`<br>Transfers to [Error](../-error/index.md) state preserving data |
| [toLoading](../to-loading.md) | `fun toLoading(type: `[`Type`](-type/index.md)` = Loading.Type.LOADING): `[`Loading`](./index.md)`<`[`DATA`](../index.md#DATA)`, `[`PARAMS`](../index.md#PARAMS)`>`<br>Transfers to [Loading](./index.md) state preserving data |
