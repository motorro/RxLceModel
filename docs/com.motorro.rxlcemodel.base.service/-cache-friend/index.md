[com.motorro.rxlcemodel.base.service](../index.md) / [CacheFriend](./index.md)

# CacheFriend

`interface CacheFriend`

Generates a cache-friendly key value for parameters

### Properties

| Name | Summary |
|---|---|
| [cacheKey](cache-key.md) | `open val cacheKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A cache key |

### Extension Functions

| Name | Summary |
|---|---|
| [getNormalizedKey](../../com.motorro.rxlcemodel.disklrucache/get-normalized-key.md) | `fun `[`CacheFriend`](./index.md)`.getNormalizedKey(prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Checks [CacheFriend.cacheKey](cache-key.md) if it fits to [com.jakewharton.disklrucache.DiskLruCache](#) key requirements and hashes it if not |
