[com.motorro.rxlcemodel.base.service](../index.md) / [UpdatingNetService](./index.md)

# UpdatingNetService

`interface UpdatingNetService<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in U : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`NetService`](../-net-service/index.md)`<`[`D`](index.md#D)`, `[`P`](index.md#P)`>`

[NetService](../-net-service/index.md) extension to update data on server

### Parameters

`D` - Data type

`U` - Update type

`P` - Params that identify data type

### Functions

| Name | Summary |
|---|---|
| [update](update.md) | `abstract fun update(params: `[`P`](index.md#P)`, update: `[`U`](index.md#U)`): `[`Single`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Single.html)`<`[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>>`<br>Updates data on server returning updated one |

### Inherited Functions

| Name | Summary |
|---|---|
| [get](../-net-service/get.md) | `abstract fun get(params: `[`P`](../-net-service/index.md#P)`): `[`Single`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Single.html)`<`[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](../-net-service/index.md#D)`>>`<br>Gets entity from network or throws on error |
