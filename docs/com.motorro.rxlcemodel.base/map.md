[com.motorro.rxlcemodel.base](index.md) / [map](./map.md)

# map

`fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](-lce-model/index.md)`<`[`DATA_1`](map.md#DATA_1)`, `[`PARAMS`](map.md#PARAMS)`>.map(mapper: (data: `[`DATA_1`](map.md#DATA_1)`) -> `[`DATA_2`](map.md#DATA_2)`): `[`LceModel`](-lce-model/index.md)`<`[`DATA_2`](map.md#DATA_2)`, `[`PARAMS`](map.md#PARAMS)`>`

Creates a model wrapper that converts [DATA_1](map.md#DATA_1) to [DATA_2](map.md#DATA_2)

### Parameters

`DATA_1` - Source model data type

`DATA_2` - Resulting model data type

`mapper` - Data mapper`inline fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceState`](-lce-state/index.md)`<`[`DATA_1`](map.md#DATA_1)`>.map(mapper: (data: `[`DATA_1`](map.md#DATA_1)`) -> `[`DATA_2`](map.md#DATA_2)`): `[`LceState`](-lce-state/index.md)`<`[`DATA_2`](map.md#DATA_2)`>`

Maps data in LceState

### Parameters

`mapper` - Data mapper