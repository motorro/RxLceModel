[com.motorro.rxlcemodel.base.service](index.md) / [stringifyParams](./stringify-params.md)

# stringifyParams

`inline fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Delegate`](-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](stringify-params.md#D)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.stringifyParams(crossinline stringify: `[`P`](stringify-params.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](stringify-params.md#D)`, `[`P`](stringify-params.md#P)`>`

Creates an adapter delegate that [stringify](stringify-params.md#P) and uses result string as params to receiver

### Parameters

`stringify` - Function to stringify [P](stringify-params.md#P)

**Receiver**
Delegate with String params e.g. the one that saves data to files and uses params as file names

