//[base](../../index.md)/[com.motorro.rxlcemodel.base](index.md)/[getData](get-data.md)

# getData

[jvm]\
fun &lt;[DATA](get-data.md) : Any&gt; Observable&lt;[LceState](-lce-state/index.md)&lt;[DATA](get-data.md)&gt;&gt;.[getData](get-data.md)(terminateOnError: ([LceState.Error](-lce-state/-error/index.md)&lt;[DATA](get-data.md)&gt;) -&gt; Boolean): Observable&lt;[DATA](get-data.md)&gt;

Returns model's data stream dropping state information

## Parameters

jvm

| | |
|---|---|
| DATA | Source model data type |
| terminateOnError | A predicate to check error state. If predicate returns true, the stream is terminated with [LceState.Error.error](-lce-state/-error/error.md) |
