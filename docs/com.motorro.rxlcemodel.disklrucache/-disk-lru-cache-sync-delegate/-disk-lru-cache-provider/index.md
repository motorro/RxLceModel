[com.motorro.rxlcemodel.disklrucache](../../index.md) / [DiskLruCacheSyncDelegate](../index.md) / [DiskLruCacheProvider](./index.md)

# DiskLruCacheProvider

`class DiskLruCacheProvider`

Provides properly configured [DiskLruCache](#) with required entry config

### Parameters

`directory` - a writable directory

`appVersion` - Current application version

`maxSize` - the maximum number of bytes this cache should use to store

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DiskLruCacheProvider(directory: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, appVersion: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, maxSize: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)`<br>Provides properly configured [DiskLruCache](#) with required entry config |

### Properties

| Name | Summary |
|---|---|
| [cache](cache.md) | `val cache: DiskLruCache`<br>Configured [DiskLruCache](#) |

### Extension Functions

| Name | Summary |
|---|---|
| [createDelegate](../../create-delegate.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`DiskLruCacheProvider`](./index.md)`.createDelegate(prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sd: `[`CacheDelegateSerializerDeserializer`](../../../com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)`<`[`D`](../../create-delegate.md#D)`>, stringify: `[`P`](../../create-delegate.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](../../../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](../../create-delegate.md#D)`, `[`P`](../../create-delegate.md#P)`>`<br>Creates DiskLRU caching delegate for [SyncDelegateCacheService](../../../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) Delegate uses cache directory provided by [DiskLruCacheProvider](./index.md). This directory is designed to be shared between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix](#) to not to mix data with other delegates. The [DiskLruCacheSyncDelegate.sd](#) is a serializer/deserializer that saves/restores entity from file streams. |
| [withKotlin](../../../com.motorro.rxlcemodel.kserializer/with-kotlin.md) | `fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`DiskLruCacheProvider`](./index.md)`.withKotlin(validatorFactory: `[`EntityValidatorFactory`](../../../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md)`, serializer: KSerializer<`[`D`](../../../com.motorro.rxlcemodel.kserializer/with-kotlin.md#D)`>, prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = createDefaultDelegatePrefix(D::class.java), stringify: `[`P`](../../../com.motorro.rxlcemodel.kserializer/with-kotlin.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](../../../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](../../../com.motorro.rxlcemodel.kserializer/with-kotlin.md#D)`, `[`P`](../../../com.motorro.rxlcemodel.kserializer/with-kotlin.md#P)`>`<br>Creates DiskLRU caching delegate for [SyncDelegateCacheService](../../../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts Kotlin-serializable data |
| [withObjectStream](../../with-object-stream.md) | `fun <D : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`DiskLruCacheProvider`](./index.md)`.withObjectStream(validatorFactory: `[`EntityValidatorFactory`](../../../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md)`, prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = createDefaultDelegatePrefix(D::class.java), stringify: `[`P`](../../with-object-stream.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](../../../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](../../with-object-stream.md#D)`, `[`P`](../../with-object-stream.md#P)`>`<br>Creates DiskLRU caching delegate for [SyncDelegateCacheService](../../../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts [Serializable](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html) data |
