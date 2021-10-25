//[base](../../index.md)/[com.motorro.rxlcemodel.base](index.md)/[map](map.md)

# map

[jvm]\
inline fun &lt;[DATA_1](map.md) : Any, [DATA_2](map.md) : Any&gt; [LceState](-lce-state/index.md)&lt;[DATA_1](map.md)&gt;.[map](map.md)(mapper: ([DATA_1](map.md)) -&gt; [DATA_2](map.md)): [LceState](-lce-state/index.md)&lt;[DATA_2](map.md)&gt;

Maps data in LceState

## Parameters

jvm

| | |
|---|---|
| mapper | Data mapper |

[jvm]\
fun &lt;[DATA_1](map.md) : Any, [DATA_2](map.md) : Any&gt; [LceUseCase](-lce-use-case/index.md)&lt;[DATA_1](map.md)&gt;.[map](map.md)(mapper: ([DATA_1](map.md)) -&gt; [DATA_2](map.md)): [LceUseCase](-lce-use-case/index.md)&lt;[DATA_2](map.md)&gt;

Creates a use-case wrapper that converts [DATA_1](map.md) to [DATA_2](map.md)

#### Receiver

Original model

## Parameters

jvm

| | |
|---|---|
| DATA_1 | Source data type |
| DATA_2 | Resulting data type |
| mapper | Data mapper |

[jvm]\
fun &lt;[DATA_1](map.md) : Any, [DATA_2](map.md) : Any, [PARAMS](map.md) : Any&gt; [LceModel](-lce-model/index.md)&lt;[DATA_1](map.md), [PARAMS](map.md)&gt;.[map](map.md)(mapper: ([DATA_1](map.md)) -&gt; [DATA_2](map.md)): [LceModel](-lce-model/index.md)&lt;[DATA_2](map.md), [PARAMS](map.md)&gt;

Creates a model wrapper that converts [DATA_1](map.md) to [DATA_2](map.md)

#### Receiver

Original model

## Parameters

jvm

| | |
|---|---|
| DATA_1 | Source model data type |
| DATA_2 | Resulting model data type |
| PARAMS | Params type that identify data being loaded |
| mapper | Data mapper |
