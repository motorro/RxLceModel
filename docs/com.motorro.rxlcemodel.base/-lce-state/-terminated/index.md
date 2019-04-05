[com.motorro.rxlcemodel.base](../../index.md) / [LceState](../index.md) / [Terminated](./index.md)

# Terminated

`data class Terminated<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](../index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>`

A special state that may be used to terminate state emission in cases we always need a latest state to proceed
For example we have a view that subscribes to [LceState](../index.md) for a resource identified with [PARAMS](index.md#PARAMS).
Than a delete operation is performed on that resource and it is not available anymore.
The one may emit [Terminated](./index.md) to do a special processing (e.g. close the corresponding view) instead of
doing it through server request that will return a `Not found` error and doing a special case
processing afterwards.
Also useful when `onComplete` from state-emitter can't be processed by the end-subscriber. For example LiveData
does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion
logic.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Terminated(params: `[`PARAMS`](index.md#PARAMS)`)`<br>A special state that may be used to terminate state emission in cases we always need a latest state to proceed For example we have a view that subscribes to [LceState](../index.md) for a resource identified with [PARAMS](index.md#PARAMS). Than a delete operation is performed on that resource and it is not available anymore. The one may emit [Terminated](./index.md) to do a special processing (e.g. close the corresponding view) instead of doing it through server request that will return a `Not found` error and doing a special case processing afterwards. Also useful when `onComplete` from state-emitter can't be processed by the end-subscriber. For example LiveData does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion logic. |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `val data: `[`DATA`](index.md#DATA)`?`<br>State data |
| [dataIsValid](data-is-valid.md) | `val dataIsValid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>A property that is evaluated internally and may mean that data being emitted is stall, invalidated or otherwise 'not-so-valid' until some further emission (say after network reload). |
| [params](params.md) | `val params: `[`PARAMS`](index.md#PARAMS)<br>Params used to load [data](data.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [toError](../to-error.md) | `fun toError(error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Error`](../-error/index.md)`<`[`DATA`](../index.md#DATA)`, `[`PARAMS`](../index.md#PARAMS)`>`<br>Transfers to [Error](../-error/index.md) state preserving data |
| [toLoading](../to-loading.md) | `fun toLoading(type: `[`Type`](../-loading/-type/index.md)` = Loading.Type.LOADING): `[`Loading`](../-loading/index.md)`<`[`DATA`](../index.md#DATA)`, `[`PARAMS`](../index.md#PARAMS)`>`<br>Transfers to [Loading](../-loading/index.md) state preserving data |
