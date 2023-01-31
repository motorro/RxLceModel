//[rx](../../index.md)/[com.motorro.rxlcemodel.rx](index.md)/[terminateOnError](terminate-on-error.md)

# terminateOnError

[jvm]\
fun &lt;[DATA](terminate-on-error.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; Observable&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](terminate-on-error.md)&gt;&gt;.[terminateOnError](terminate-on-error.md)(predicate: ([LceState.Error](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/index.md)&lt;[DATA](terminate-on-error.md)&gt;) -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): Observable&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](terminate-on-error.md)&gt;&gt;

Terminates [LceModel.state](../../../rx/com.motorro.rxlcemodel.rx/-lce-model/state.md) stream if [predicate](terminate-on-error.md) returns true

#### Parameters

jvm

| | |
|---|---|
| DATA | Source model data type |
| predicate | A predicate to check error state. If predicate returns true, the stream is terminated with [LceState.Error.error](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/-error/error.md) |
