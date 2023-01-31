//[rx](../../index.md)/[com.motorro.rxlcemodel.rx](index.md)/[getData](get-data.md)

# getData

[jvm]\
fun &lt;[DATA](get-data.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; Observable&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](get-data.md)&gt;&gt;.[getData](get-data.md)(terminateOnError: ([LceState.Error](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/index.md)&lt;[DATA](get-data.md)&gt;) -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): Observable&lt;[DATA](get-data.md)&gt;

Returns model's data stream dropping state information

#### Parameters

jvm

| | |
|---|---|
| DATA | Source model data type |
| terminateOnError | A predicate to check error state. If predicate returns true, the stream is terminated with [LceState.Error.error](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/error.md) |
