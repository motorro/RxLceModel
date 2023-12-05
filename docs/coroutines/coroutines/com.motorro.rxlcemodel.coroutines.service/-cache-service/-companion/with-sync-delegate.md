//[coroutines](../../../../index.md)/[com.motorro.rxlcemodel.coroutines.service](../../index.md)/[CacheService](../index.md)/[Companion](index.md)/[withSyncDelegate](with-sync-delegate.md)

# withSyncDelegate

[common]\
fun &lt;[D](with-sync-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-sync-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [withSyncDelegate](with-sync-delegate.md)(delegate: [CacheDelegate](../../../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md)&lt;[D](with-sync-delegate.md), [P](with-sync-delegate.md)&gt;): [SyncDelegateCacheService](../../-sync-delegate-cache-service/index.md)&lt;[D](with-sync-delegate.md), [P](with-sync-delegate.md)&gt;

Creates synchronous [CacheDelegate](../../../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate/index.md) cache service

#### Parameters

common

| | |
|---|---|
| delegate | Delegate that synchronously performs caching actions |
