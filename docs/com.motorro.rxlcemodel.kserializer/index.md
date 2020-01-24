[com.motorro.rxlcemodel.kserializer](./index.md)

## Package com.motorro.rxlcemodel.kserializer

DiskLruCache serialization delegate using [Kotlin serialization](https://github.com/Kotlin/kotlinx.serialization/)

### Types

| Name | Summary |
|---|---|
| [KotlinCacheDelegateSerializer](-kotlin-cache-delegate-serializer/index.md) | `class KotlinCacheDelegateSerializer<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`CacheDelegateSerializerDeserializer`](../com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)`<`[`D`](-kotlin-cache-delegate-serializer/index.md#D)`>`<br>Serializes and deserializes objects with [kotlinx.serialization.KSerializer](#) |

### Functions

| Name | Summary |
|---|---|
| [withKotlin](with-kotlin.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`DiskLruCacheProvider`](../com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md)`.withKotlin(validatorFactory: `[`EntityValidatorFactory`](../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md)`, serializer: KSerializer<`[`D`](with-kotlin.md#D)`>, cbor: Cbor = Cbor.plain, prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = createDefaultDelegatePrefix(D::class.java), stringify: `[`P`](with-kotlin.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](with-kotlin.md#D)`, `[`P`](with-kotlin.md#P)`>`<br>Creates DiskLRU caching delegate for [SyncDelegateCacheService](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts Kotlin-serializable data |
