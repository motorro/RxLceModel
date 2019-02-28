[com.motorro.rxlcemodel.base.service](../index.md) / [NetService](./index.md)

# NetService

`interface NetService<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

Interface to load an [com.motorro.rxlcemodel.base.entity.Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) from network

### Parameters

`D` - Data type

`P` - Params that identify data type

### Functions

| Name | Summary |
|---|---|
| [get](get.md) | `abstract fun get(params: `[`P`](index.md#P)`): `[`Single`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Single.html)`<`[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>>`<br>Gets entity from network or throws on error |

### Inheritors

| Name | Summary |
|---|---|
| [UpdatingNetService](../-updating-net-service/index.md) | `interface UpdatingNetService<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in U : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`NetService`](./index.md)`<`[`D`](../-updating-net-service/index.md#D)`, `[`P`](../-updating-net-service/index.md#P)`>`<br>[NetService](./index.md) extension to update data on server |
