[com.motorro.rxlcemodel.base.service](./index.md)

## Package com.motorro.rxlcemodel.base.service

Contains tools to load and store data

### Types

| Name | Summary |
|---|---|
| [CacheDelegateSerializerDeserializer](-cache-delegate-serializer-deserializer/index.md) | `interface CacheDelegateSerializerDeserializer<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`<br>Serializer for cache delegates |
| [CacheManager](-cache-manager/index.md) | `interface CacheManager`<br>Closes and deletes cache |
| [CacheService](-cache-service/index.md) | `interface CacheService<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`<br>Interface to cache an [com.motorro.rxlcemodel.base.entity.Entity](../com.motorro.rxlcemodel.base.entity/-entity/index.md) locally Cache should notify subscribers that data has been updated through [getData](-cache-service/get-data.md) channel |
| [MemorySyncDelegate](-memory-sync-delegate/index.md) | `abstract class MemorySyncDelegate<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Delegate`](-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](-memory-sync-delegate/index.md#D)`, `[`P`](-memory-sync-delegate/index.md#P)`>`<br>A simple memory cache for [SyncDelegateCacheService](-sync-delegate-cache-service/index.md). |
| [NetService](-net-service/index.md) | `interface NetService<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`<br>Interface to load an [com.motorro.rxlcemodel.base.entity.Entity](../com.motorro.rxlcemodel.base.entity/-entity/index.md) from network |
| [ServiceSet](-service-set/index.md) | `interface ServiceSet<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`<br>Service-set for [com.motorro.rxlcemodel.base.LceModel](../com.motorro.rxlcemodel.base/-lce-model/index.md) |
| [SyncDelegateCacheService](-sync-delegate-cache-service/index.md) | `class SyncDelegateCacheService<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`CacheService`](-cache-service/index.md)`<`[`D`](-sync-delegate-cache-service/index.md#D)`, `[`P`](-sync-delegate-cache-service/index.md#P)`>`<br>Service implementation |
| [UpdatingNetService](-updating-net-service/index.md) | `interface UpdatingNetService<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in U : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`NetService`](-net-service/index.md)`<`[`D`](-updating-net-service/index.md#D)`, `[`P`](-updating-net-service/index.md#P)`>`<br>[NetService](-net-service/index.md) extension to update data on server |
| [UpdatingServiceSet](-updating-service-set/index.md) | `interface UpdatingServiceSet<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in U : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, in P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ServiceSet`](-service-set/index.md)`<`[`D`](-updating-service-set/index.md#D)`, `[`P`](-updating-service-set/index.md#P)`>`<br>[ServiceSet](-service-set/index.md) extension with updating [net](-updating-service-set/net.md) |

### Functions

| Name | Summary |
|---|---|
| [stringifyParams](stringify-params.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Delegate`](-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](stringify-params.md#D)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.stringifyParams(stringify: `[`P`](stringify-params.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](stringify-params.md#D)`, `[`P`](stringify-params.md#P)`>`<br>Creates an adapter delegate that [stringify](stringify-params.md#P) and uses result string as params to receiver |
