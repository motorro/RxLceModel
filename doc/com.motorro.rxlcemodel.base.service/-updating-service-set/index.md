[com.motorro.rxlcemodel.base.service](../index.md) / [UpdatingServiceSet](./index.md)

# UpdatingServiceSet

`interface UpdatingServiceSet<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in U : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ServiceSet`](../-service-set/index.md)`<`[`D`](index.md#D)`, `[`P`](index.md#P)`>`

[ServiceSet](../-service-set/index.md) extension with updating [net](net.md)

### Parameters

`D` - Data type

`U` - Update type

`P` - Params that identify data type

### Properties

| Name | Summary |
|---|---|
| [net](net.md) | `abstract val net: `[`UpdatingNetService`](../-updating-net-service/index.md)`<`[`D`](index.md#D)`, `[`U`](index.md#U)`, `[`P`](index.md#P)`>`<br>Updating net service |

### Inherited Properties

| Name | Summary |
|---|---|
| [cache](../-service-set/cache.md) | `abstract val cache: `[`CacheService`](../-cache-service/index.md)`<`[`D`](../-service-set/index.md#D)`, `[`P`](../-service-set/index.md#P)`>`<br>Cache service |
