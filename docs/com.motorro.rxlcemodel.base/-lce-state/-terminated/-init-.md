[com.motorro.rxlcemodel.base](../../index.md) / [LceState](../index.md) / [Terminated](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`Terminated()`

A special state that may be used to terminate state emission in cases we always need a latest state to proceed
For example we have a view that subscribes to [LceState](../index.md) for a resource identified with some PARAMS.
Than a delete operation is performed on that resource and it is not available anymore.
The one may emit [Terminated](index.md) to do a special processing (e.g. close the corresponding view) instead of
doing it through server request that will return a `Not found` error and doing a special case
processing afterwards.
Also useful when `onComplete` from state-emitter can't be processed by the end-subscriber. For example LiveData
does not emit completion and caches the latest emission. So converting stream to LiveData will loose Rx completion
logic.

