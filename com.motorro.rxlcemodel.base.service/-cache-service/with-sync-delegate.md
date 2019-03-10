[com.motorro.rxlcemodel.base.service](../index.md) / [CacheService](index.md) / [withSyncDelegate](./with-sync-delegate.md)

# withSyncDelegate

`fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> withSyncDelegate(delegate: `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](with-sync-delegate.md#D)`, `[`P`](with-sync-delegate.md#P)`>): `[`SyncDelegateCacheService`](../-sync-delegate-cache-service/index.md)`<`[`D`](with-sync-delegate.md#D)`, `[`P`](with-sync-delegate.md#P)`>`

Creates synchronous [SyncDelegateCacheService.Delegate](../-sync-delegate-cache-service/-delegate/index.md) cache service

### Parameters

`delegate` - Delegate that synchronously performs caching actions