//[base](../../index.md)/[com.motorro.rxlcemodel.base](index.md)/[combine](combine.md)

# combine

[jvm]\
inline fun &lt;[DATA_1](combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_3](combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceState](-lce-state/index.md)&lt;[DATA_1](combine.md)&gt;.[combine](combine.md)(other: [LceState](-lce-state/index.md)&lt;[DATA_2](combine.md)&gt;, mapper: ([DATA_1](combine.md)?, [DATA_2](combine.md)?) -&gt; [DATA_3](combine.md)?): [LceState](-lce-state/index.md)&lt;[DATA_3](combine.md)&gt;

Combines two Lce states. Here is the result state matrix | Receiver   | other      | Result     | |------------|------------|------------| | Loading    | Loading    | Loading    | | Loading    | Content    | Loading    | | Loading    | Error      | Error      | | Loading    | Terminated | Terminated | | Content    | Loading    | Loading    | | Content    | Content    | Content*   | | Content    | Error      | Error      | | Content    | Terminated | Terminated | | Error      | Loading    | Error      | | Error      | Content    | Error      | | Error      | Error      | Error      | | Error      | Terminated | Terminated | | Terminated | Loading    | Terminated | | Terminated | Content    | Terminated | | Terminated | Error      | Terminated | | Terminated | Terminated | Terminated |

#### Receiver

An Lce state that has a priority in final state resolution

## Parameters

jvm

| | |
|---|---|
| other | Other state to combine with |
| mapper | Data mapper function. Returning null from it means data is not ready and will result in loading state even if both states has data. You may return null-value of any kind to alter resulting state. |
