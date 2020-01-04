[com.motorro.rxlcemodel.base](../../index.md) / [LceState](../index.md) / [Error](./index.md)

# Error

`data class Error<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](../index.md)`<`[`DATA`](index.md#DATA)`>`

Data (or part of it) failed to load

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Error(data: `[`DATA`](index.md#DATA)`?, dataIsValid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`)`<br>Data (or part of it) failed to load |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `val data: `[`DATA`](index.md#DATA)`?`<br>State data |
| [dataIsValid](data-is-valid.md) | `val dataIsValid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Data validity at the time of emission |
| [error](error.md) | `val error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)<br>Data load error |

### Inherited Functions

| Name | Summary |
|---|---|
| [toError](../to-error.md) | `fun toError(error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Error`](./index.md)`<`[`DATA`](../index.md#DATA)`>`<br>Transfers to [Error](./index.md) state preserving data |
| [toLoading](../to-loading.md) | `fun toLoading(type: `[`Type`](../-loading/-type/index.md)` = Loading.Type.LOADING): `[`Loading`](../-loading/index.md)`<`[`DATA`](../index.md#DATA)`>`<br>Transfers to [Loading](../-loading/index.md) state preserving data |
