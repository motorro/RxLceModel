//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.service](../../index.md)/[CacheService](../index.md)/[Companion](index.md)/[withSyncDelegate](with-sync-delegate.md)

# withSyncDelegate

[jvm]\
fun &lt;[D](with-sync-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](with-sync-delegate.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [withSyncDelegate](with-sync-delegate.md)(delegate: [SyncDelegateCacheService.Delegate](../../-sync-delegate-cache-service/-delegate/index.md)&lt;[D](with-sync-delegate.md), [P](with-sync-delegate.md)&gt;): [SyncDelegateCacheService](../../-sync-delegate-cache-service/index.md)&lt;[D](with-sync-delegate.md), [P](with-sync-delegate.md)&gt;

Creates synchronous [SyncDelegateCacheService.Delegate](../../-sync-delegate-cache-service/-delegate/index.md) cache service

## Parameters

jvm

| | |
|---|---|
| delegate | Delegate that synchronously performs caching actions |
