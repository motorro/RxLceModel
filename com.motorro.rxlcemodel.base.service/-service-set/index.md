[com.motorro.rxlcemodel.base.service](../index.md) / [ServiceSet](./index.md)

# ServiceSet

`interface ServiceSet<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

Service-set for [com.motorro.rxlcemodel.base.LceModel](../../com.motorro.rxlcemodel.base/-lce-model/index.md)

### Parameters

`D` - Data type

`P` - Params that identify data type

### Properties

| Name | Summary |
|---|---|
| [cache](cache.md) | `abstract val cache: `[`CacheService`](../-cache-service/index.md)`<`[`D`](index.md#D)`, `[`P`](index.md#P)`>`<br>Cache service |
| [net](net.md) | `abstract val net: `[`NetService`](../-net-service/index.md)`<`[`D`](index.md#D)`, `[`P`](index.md#P)`>`<br>Net service |

### Inheritors

| Name | Summary |
|---|---|
| [UpdatingServiceSet](../-updating-service-set/index.md) | `interface UpdatingServiceSet<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in U : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ServiceSet`](./index.md)`<`[`D`](../-updating-service-set/index.md#D)`, `[`P`](../-updating-service-set/index.md#P)`>`<br>[ServiceSet](./index.md) extension with updating [net](../-updating-service-set/net.md) |
