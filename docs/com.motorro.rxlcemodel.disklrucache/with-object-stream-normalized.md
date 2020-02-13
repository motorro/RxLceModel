[com.motorro.rxlcemodel.disklrucache](index.md) / [withObjectStreamNormalized](./with-object-stream-normalized.md)

# withObjectStreamNormalized

`inline fun <reified D : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`, P : `[`CacheFriend`](../com.motorro.rxlcemodel.base.service/-cache-friend/index.md)`> `[`DiskLruCacheProvider`](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md)`.withObjectStreamNormalized(validatorFactory: `[`EntityValidatorFactory`](../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md)`, prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = createDefaultDelegatePrefix(D::class.java)): `[`Delegate`](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](with-object-stream-normalized.md#D)`, `[`P`](with-object-stream-normalized.md#P)`>`

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts [Serializable](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html) data
with cache key normalizing and check.

### Parameters

`validatorFactory` - Entity validation factory (defines cache TTL)

`prefix` - Caching name prefix to distinguish cache files from other delegates within the same cache directory
data identifying parameters with string using [stringifyParams](../com.motorro.rxlcemodel.base.service/stringify-params.md)

**Receiver**
Cache provider

`inline fun <reified D : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`, P : `[`CacheFriend`](../com.motorro.rxlcemodel.base.service/-cache-friend/index.md)`> `[`DiskLruCacheProvider`](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md)`.withObjectStreamNormalized(validatorFactory: `[`EntityValidatorFactory`](../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md)`, prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = createDefaultDelegatePrefix(D::class.java), crossinline stringify: `[`P`](with-object-stream-normalized.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Delegate`](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](with-object-stream-normalized.md#D)`, `[`P`](with-object-stream-normalized.md#P)`>`

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts [Serializable](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html) data
with cache key normalizing and check.

### Parameters

`validatorFactory` - Entity validation factory (defines cache TTL)

`prefix` - Caching name prefix to distinguish cache files from other delegates within the same cache directory

`stringify` - As [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute
data identifying parameters with string using [stringifyParams](../com.motorro.rxlcemodel.base.service/stringify-params.md)

**Receiver**
Cache provider

