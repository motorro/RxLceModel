[com.motorro.rxlcemodel.disklrucache](index.md) / [normalizeParams](./normalize-params.md)

# normalizeParams

`fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`CacheFriend`](../com.motorro.rxlcemodel.base.service/-cache-friend/index.md)`> `[`DiskLruCacheSyncDelegate`](-disk-lru-cache-sync-delegate/index.md)`<`[`D`](normalize-params.md#D)`>.normalizeParams(prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Delegate`](../com.motorro.rxlcemodel.base.service/-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](normalize-params.md#D)`, `[`P`](normalize-params.md#P)`>`

Creates an adapter delegate that normalizes [CacheFriend.cacheKey](../com.motorro.rxlcemodel.base.service/-cache-friend/cache-key.md) to fit into DiskLruCache requirements of 64 a-zA-Z0-9 symbols

**Receiver**
DiskLruCacheSyncDelegate

