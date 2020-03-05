[com.motorro.rxlcemodel.kserializer](index.md) / [withKotlin](./with-kotlin.md)

# withKotlin

`inline fun <reified D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`CacheFriend`](../com.motorro.rxlcemodel.base.service/-cache-friend/index.md)`> `[`DiskLruCacheProvider`](../com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md)`.withKotlin(validatorFactory: `[`EntityValidatorFactory`](../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md)`, serializer: KSerializer<`[`D`](with-kotlin.md#D)`>, binaryFormat: BinaryFormat = Cbor, prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = createDefaultDelegatePrefix(D::class.java)): `[`Delegate`](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](with-kotlin.md#D)`, `[`P`](with-kotlin.md#P)`>`

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts Kotlin-serializable data

### Parameters

`validatorFactory` - Entity validation factory (defines cache TTL)

`serializer` - Data serializer/deserializer

`binaryFormat` - Binary format serializer

`prefix` - Caching name prefix to distinguish cache files from other delegates within the same cache directory

**Receiver**
Cache provider

`inline fun <reified D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`DiskLruCacheProvider`](../com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md)`.withKotlin(validatorFactory: `[`EntityValidatorFactory`](../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md)`, serializer: KSerializer<`[`D`](with-kotlin.md#D)`>, binaryFormat: BinaryFormat = Cbor, prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = createDefaultDelegatePrefix(D::class.java), crossinline stringify: `[`P`](with-kotlin.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Delegate`](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](with-kotlin.md#D)`, `[`P`](with-kotlin.md#P)`>`

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts Kotlin-serializable data

### Parameters

`validatorFactory` - Entity validation factory (defines cache TTL)

`serializer` - Data serializer/deserializer

`binaryFormat` - Binary format serializer

`prefix` - Caching name prefix to distinguish cache files from other delegates within the same cache directory

`stringify` - As [DiskLruCacheSyncDelegate](../com.motorro.rxlcemodel.disklrucache/-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute
data identifying parameters with string using [stringifyParams](../com.motorro.rxlcemodel.base.service/stringify-params.md)

**Receiver**
Cache provider

