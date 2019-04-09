[com.motorro.rxlcemodel.disklrucache](index.md) / [withObjectStream](./with-object-stream.md)

# withObjectStream

`inline fun <reified D : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`DiskLruCacheProvider`](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md)`.withObjectStream(prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, validatorFactory: `[`EntityValidatorFactory`](../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md)`, crossinline stringify: `[`P`](with-object-stream.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { toString() }): `[`Delegate`](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](with-object-stream.md#D)`, `[`P`](with-object-stream.md#P)`>`

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts [Serializable](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html) data

### Parameters

`prefix` - Caching name prefix to distinguish cache files from other delegates within the same cache directory

`validatorFactory` - Entity validation factory (defines cache TTL)

`stringify` - As [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute
data identifying parameters with string using [stringifyParams](../com.motorro.rxlcemodel.base.service/stringify-params.md)

**Receiver**
Cache provider
