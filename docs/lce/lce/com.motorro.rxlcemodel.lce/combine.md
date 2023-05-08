//[lce](../../index.md)/[com.motorro.rxlcemodel.lce](index.md)/[combine](combine.md)

# combine

[common]\
inline fun &lt;[DATA_1](combine.md) : Any, [DATA_2](combine.md) : Any, [DATA_3](combine.md) : Any&gt; [LceState](-lce-state/index.md)&lt;[DATA_1](combine.md)&gt;.[combine](combine.md)(other: [LceState](-lce-state/index.md)&lt;[DATA_2](combine.md)&gt;, mapper: (data1: [DATA_1](combine.md)?, data2: [DATA_2](combine.md)?) -&gt; [DATA_3](combine.md)?): [LceState](-lce-state/index.md)&lt;[DATA_3](combine.md)&gt;

Combines two Lce states. Here is the result state matrix | Receiver   | other      | Result     | |------------|------------|------------| | Loading    | Loading    | Loading    | | Loading    | Content    | Loading    | | Loading    | Error      | Error      | | Loading    | Terminated | Terminated | | Content    | Loading    | Loading    | | Content    | Content    | Content*   | | Content    | Error      | Error      | | Content    | Terminated | Terminated | | Error      | Loading    | Error      | | Error      | Content    | Error      | | Error      | Error      | Error      | | Error      | Terminated | Terminated | | Terminated | Loading    | Terminated | | Terminated | Content    | Terminated | | Terminated | Error      | Terminated | | Terminated | Terminated | Terminated |

#### Receiver

An Lce state that has a priority in final state resolution

#### Parameters

common

| | |
|---|---|
| other | Other state to combine with |
| mapper | Data mapper function. Returning null from it means data is not ready and will result in loading state even if both states has data. You may return null-value of any kind to alter resulting state. |
