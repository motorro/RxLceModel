[com.motorro.rxlcemodel.base](../index.md) / [LceState](./index.md)

# LceState

`sealed class LceState<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

State for "Loading-Content-Error" resource which retrieves [data](data.md)

### Parameters

`DATA` - Data Type of data being held

`PARAMS` - Params that identify data being loaded

### Types

| Name | Summary |
|---|---|
| [Content](-content/index.md) | `data class Content<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](./index.md)`<`[`DATA`](-content/index.md#DATA)`, `[`PARAMS`](-content/index.md#PARAMS)`>`<br>Data is loaded and content is displayed |
| [Error](-error/index.md) | `data class Error<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](./index.md)`<`[`DATA`](-error/index.md#DATA)`, `[`PARAMS`](-error/index.md#PARAMS)`>`<br>Data (or part of it) failed to load |
| [Loading](-loading/index.md) | `data class Loading<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](./index.md)`<`[`DATA`](-loading/index.md#DATA)`, `[`PARAMS`](-loading/index.md#PARAMS)`>`<br>View is loading |
| [Terminated](-terminated/index.md) | `data class Terminated<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](./index.md)`<`[`DATA`](-terminated/index.md#DATA)`, `[`PARAMS`](-terminated/index.md#PARAMS)`>`<br>A special state that may be used to terminate state emission in cases we always need a latest state to proceed For example we have a view that subscribes to [LceState](./index.md) for a resource identified with [PARAMS](-terminated/index.md#PARAMS). Than a delete operation is performed on that resource and it is not available anymore. The one may emit [Terminated](-terminated/index.md) to do a special processing (e.g. close the corresponding view) instead of doing it through server request that will return a `Not found` error and doing a special case processing afterwards. Also useful when `onComplete` from state-emitter can't be processed by the end-subscriber. For example LiveData does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion logic. |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `abstract val data: `[`DATA`](index.md#DATA)`?`<br>State data |
| [dataIsValid](data-is-valid.md) | `abstract val dataIsValid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>A property that is evaluated internally and may mean that data being emitted is stall, invalidated or otherwise 'not-so-valid' until some further emission (say after network reload). |
| [params](params.md) | `abstract val params: `[`PARAMS`](index.md#PARAMS)<br>Params used to load state [data](data.md) |

### Functions

| Name | Summary |
|---|---|
| [toError](to-error.md) | `fun toError(error: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Error`](-error/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>`<br>Transfers to [Error](-error/index.md) state preserving data |
| [toLoading](to-loading.md) | `fun toLoading(type: `[`Type`](-loading/-type/index.md)` = Loading.Type.LOADING): `[`Loading`](-loading/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>`<br>Transfers to [Loading](-loading/index.md) state preserving data |

### Extension Functions

| Name | Summary |
|---|---|
| [map](../map.md) | `fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceState`](./index.md)`<`[`DATA_1`](../map.md#DATA_1)`, `[`PARAMS`](../map.md#PARAMS)`>.map(mapper: (data: `[`DATA_1`](../map.md#DATA_1)`) -> `[`DATA_2`](../map.md#DATA_2)`): `[`LceState`](./index.md)`<`[`DATA_2`](../map.md#DATA_2)`, `[`PARAMS`](../map.md#PARAMS)`>`<br>Maps data in LceState |

### Inheritors

| Name | Summary |
|---|---|
| [Content](-content/index.md) | `data class Content<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](./index.md)`<`[`DATA`](-content/index.md#DATA)`, `[`PARAMS`](-content/index.md#PARAMS)`>`<br>Data is loaded and content is displayed |
| [Error](-error/index.md) | `data class Error<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](./index.md)`<`[`DATA`](-error/index.md#DATA)`, `[`PARAMS`](-error/index.md#PARAMS)`>`<br>Data (or part of it) failed to load |
| [Loading](-loading/index.md) | `data class Loading<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](./index.md)`<`[`DATA`](-loading/index.md#DATA)`, `[`PARAMS`](-loading/index.md#PARAMS)`>`<br>View is loading |
| [Terminated](-terminated/index.md) | `data class Terminated<out DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`LceState`](./index.md)`<`[`DATA`](-terminated/index.md#DATA)`, `[`PARAMS`](-terminated/index.md#PARAMS)`>`<br>A special state that may be used to terminate state emission in cases we always need a latest state to proceed For example we have a view that subscribes to [LceState](./index.md) for a resource identified with [PARAMS](-terminated/index.md#PARAMS). Than a delete operation is performed on that resource and it is not available anymore. The one may emit [Terminated](-terminated/index.md) to do a special processing (e.g. close the corresponding view) instead of doing it through server request that will return a `Not found` error and doing a special case processing afterwards. Also useful when `onComplete` from state-emitter can't be processed by the end-subscriber. For example LiveData does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion logic. |
