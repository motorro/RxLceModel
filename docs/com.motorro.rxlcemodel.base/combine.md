[com.motorro.rxlcemodel.base](index.md) / [combine](./combine.md)

# combine

`inline fun <DATA_1 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_2 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, DATA_3 : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceState`](-lce-state/index.md)`<`[`DATA_1`](combine.md#DATA_1)`>.combine(other: `[`LceState`](-lce-state/index.md)`<`[`DATA_2`](combine.md#DATA_2)`>, mapper: (data1: `[`DATA_1`](combine.md#DATA_1)`?, data2: `[`DATA_2`](combine.md#DATA_2)`?) -> `[`DATA_3`](combine.md#DATA_3)`?): `[`LceState`](-lce-state/index.md)`<`[`DATA_3`](combine.md#DATA_3)`>`

Combines two Lce states.
Here is the result state matrix
| Receiver   | other      | Result     |
|------------|------------|------------|
| Loading    | Loading    | Loading    |
| Loading    | Content    | Loading    |
| Loading    | Error      | Error      |
| Loading    | Terminated | Terminated |
| Content    | Loading    | Loading    |
| Content    | Content    | Content*   |
| Content    | Error      | Error      |
| Content    | Terminated | Terminated |
| Error      | Loading    | Error      |
| Error      | Content    | Error      |
| Error      | Error      | Error      |
| Error      | Terminated | Terminated |
| Terminated | Loading    | Terminated |
| Terminated | Content    | Terminated |
| Terminated | Error      | Terminated |
| Terminated | Terminated | Terminated |

### Parameters

`other` - Other state to combine with

`mapper` - Data mapper function. Returning null from it means data is not ready and will result
in loading state even if both states has data. You may return null-value of any kind to alter resulting state.

**Receiver**
An Lce state that has a priority in final state resolution

