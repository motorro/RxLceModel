//[base](../../../../index.md)/[com.motorro.rxlcemodel.base](../../index.md)/[LceState](../index.md)/[Terminated](index.md)

# Terminated

[jvm]\
object [Terminated](index.md) : [LceState](../index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)&gt; 

A special state that may be used to terminate state emission in cases we always need a latest state to proceed For example we have a view that subscribes to [LceState](../index.md) for a resource identified with some PARAMS. Than a delete operation is performed on that resource and it is not available anymore. The one may emit [Terminated](index.md) to do a special processing (e.g. close the corresponding view) instead of doing it through server request that will return a `Not found` error and doing a special case processing afterwards. Also useful when `onComplete` from state-emitter can't be processed by the end-subscriber. For example LiveData does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion logic.

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [jvm]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toError](../to-error.md) | [jvm]<br>fun [toError](../to-error.md)(error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [LceState.Error](../-error/index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)&gt;<br>Transfers to [Error](../-error/index.md) state preserving data |
| [toLoading](../to-loading.md) | [jvm]<br>fun [toLoading](../to-loading.md)(type: [LceState.Loading.Type](../-loading/-type/index.md) = Loading.Type.LOADING): [LceState.Loading](../-loading/index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)&gt;<br>Transfers to [Loading](../-loading/index.md) state preserving data |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [jvm]<br>open override val [data](data.md): [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)? = null<br>State data |
| [dataIsValid](data-is-valid.md) | [jvm]<br>open override val [dataIsValid](data-is-valid.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false<br>A property that is evaluated internally and may mean that data being emitted is stall, invalidated or otherwise 'not-so-valid' until some further emission (say after network reload). |
