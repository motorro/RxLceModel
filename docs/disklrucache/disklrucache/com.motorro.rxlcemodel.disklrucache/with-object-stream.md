//[disklrucache](../../index.md)/[com.motorro.rxlcemodel.disklrucache](index.md)/[withObjectStream](with-object-stream.md)

# withObjectStream

[jvm]\
inline fun &lt;[D](with-object-stream.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html), [P](with-object-stream.md) : [CacheFriend](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-friend/index.md)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withObjectStream](with-object-stream.md)(validatorFactory: [EntityValidatorFactory](../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity-validator-factory/index.md), prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = createDefaultDelegatePrefix(D::class.java)): [CacheDelegate](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](with-object-stream.md), [P](with-object-stream.md)&gt;

Creates DiskLRU caching delegate for cache-service that accepts [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) data with cache key normalizing and check

#### Receiver

Cache provider

#### Parameters

jvm

| | |
|---|---|
| validatorFactory | Entity validation factory (defines cache TTL) |
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory |

[jvm]\
inline fun &lt;[D](with-object-stream.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html), [P](with-object-stream.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [DiskLruCacheSyncDelegate.DiskLruCacheProvider](-disk-lru-cache-sync-delegate/-disk-lru-cache-provider/index.md).[withObjectStream](with-object-stream.md)(validatorFactory: [EntityValidatorFactory](../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity-validator-factory/index.md), prefix: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = createDefaultDelegatePrefix(D::class.java), crossinline stringify: [P](with-object-stream.md).() -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [CacheDelegate](../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](with-object-stream.md), [P](with-object-stream.md)&gt;

Creates DiskLRU caching delegate for cache-service that accepts [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) data with cache key normalizing and check

#### Receiver

Cache provider

#### Parameters

jvm

| | |
|---|---|
| validatorFactory | Entity validation factory (defines cache TTL) |
| prefix | Caching name prefix to distinguish cache files from other delegates within the same cache directory |
| stringify | As [DiskLruCacheSyncDelegate](-disk-lru-cache-sync-delegate/index.md) uses string params to create cache keys we should substitute data identifying parameters with string using [stringifyParams](../../../cache/cache/com.motorro.rxlcemodel.cache/stringify-params.md) |
