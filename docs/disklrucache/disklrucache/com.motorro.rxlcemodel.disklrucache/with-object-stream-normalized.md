//[disklrucache](../../index.md)/[com.motorro.rxlcemodel.disklrucache](index.md)/[withObjectStreamNormalized](with-object-stream-normalized.md)

# withObjectStreamNormalized

[jvm]\
inline fun &lt;[D](with-object-stream-normalized.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html), [P](with-object-stream-normalized.md) : [CacheFriend](../../../base/base/com.motorro.rxlcemodel.base.service/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withObjectStreamNormalized](with-object-stream-normalized.md)(validatorFactory: [EntityValidatorFactory](../../../base/base/com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md), prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = createDefaultDelegatePrefix(D::class.java)): [SyncDelegateCacheService.Delegate](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)&lt;[D](with-object-stream-normalized.md), [P](with-object-stream-normalized.md)&gt;

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) data with cache key normalizing and check.

#### Receiver

Cache provider

## Parameters

jvm

| | |
|---|---|
| validatorFactory | Entity validation factory (defines cache TTL) |
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory data identifying parameters with string using [stringifyParams](../../../base/base/com.motorro.rxlcemodel.base.service/stringify-params.md) |

[jvm]\
inline fun &lt;[D](with-object-stream-normalized.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html), [P](with-object-stream-normalized.md) : [CacheFriend](../../../base/base/com.motorro.rxlcemodel.base.service/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withObjectStreamNormalized](with-object-stream-normalized.md)(validatorFactory: [EntityValidatorFactory](../../../base/base/com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md), prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = createDefaultDelegatePrefix(D::class.java), crossinline stringify: [P](with-object-stream-normalized.md).() -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SyncDelegateCacheService.Delegate](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)&lt;[D](with-object-stream-normalized.md), [P](with-object-stream-normalized.md)&gt;

Creates DiskLRU caching delegate for [SyncDelegateCacheService](../../../base/base/com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/index.md) that accepts [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) data with cache key normalizing and check.

#### Receiver

Cache provider

## Parameters

jvm

| | |
|---|---|
| validatorFactory | Entity validation factory (defines cache TTL) |
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory |
| stringify | As [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute data identifying parameters with string using [stringifyParams](../../../base/base/com.motorro.rxlcemodel.base.service/stringify-params.md) |
