[com.motorro.rxlcemodel.disklrucache](index.md) / [createDelegate](./create-delegate.md)

# createDelegate

`fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`CacheFriend`](../com.motorro.rxlcemodel.base.service/-cache-friend/index.md)`> `[`DiskLruCacheProvider`](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md)`.createDelegate(prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sd: `[`CacheDelegateSerializerDeserializer`](../com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)`<`[`D`](create-delegate.md#D)`>): `[`Delegate`](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](create-delegate.md#D)`, `[`P`](create-delegate.md#P)`>`

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md)
Delegate uses cache directory provided by [DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md). This directory is designed to be shared
between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix](#)
to not to mix data with other delegates.
The [DiskLruCacheSyncDelegate.sd](#) is a serializer/deserializer that saves/restores entity from file streams.

### Parameters

`prefix` - Caching name prefix to distinguish cache files from other delegates within the same cache directory

`sd` - Entity Serializer/deserializer

**Receiver**
Cache provider

`inline fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`DiskLruCacheProvider`](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md)`.createDelegate(prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sd: `[`CacheDelegateSerializerDeserializer`](../com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)`<`[`D`](create-delegate.md#D)`>, crossinline stringify: `[`P`](create-delegate.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Delegate`](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](create-delegate.md#D)`, `[`P`](create-delegate.md#P)`>`

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md)
Delegate uses cache directory provided by [DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md). This directory is designed to be shared
between several delegates. Thus we need to provide each delegate an unique [DiskLruCacheSyncDelegate.prefix](#)
to not to mix data with other delegates.
The [DiskLruCacheSyncDelegate.sd](#) is a serializer/deserializer that saves/restores entity from file streams.

### Parameters

`prefix` - Caching name prefix to distinguish cache files from other delegates within the same cache directory

`sd` - Entity Serializer/deserializer

`stringify` - As [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute
data identifying parameters with string using [stringifyParams](../com.motorro.rxlcemodel.base.service/stringify-params.md)

**Receiver**
Cache provider

