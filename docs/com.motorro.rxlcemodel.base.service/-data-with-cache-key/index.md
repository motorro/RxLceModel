[com.motorro.rxlcemodel.base.service](../index.md) / [DataWithCacheKey](./index.md)

# DataWithCacheKey

`data class DataWithCacheKey<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)

Data combined with full cached key to validate we get exactly what we are looking for
For example, DiskLruCache has strict requirements and limited length of a cache key and
hashing of keys may be required to fit into requirements - thus there is a possibility of key
clash.

### Parameters

`data` - Original data

`cacheKey` - Full unmodified cache key

**See Also**

[CacheFriendDelegate](../-cache-friend-delegate/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DataWithCacheKey(data: `[`D`](index.md#D)`, cacheKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>Data combined with full cached key to validate we get exactly what we are looking for For example, DiskLruCache has strict requirements and limited length of a cache key and hashing of keys may be required to fit into requirements - thus there is a possibility of key clash. |

### Properties

| Name | Summary |
|---|---|
| [cacheKey](cache-key.md) | `val cacheKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Full unmodified cache key |
| [data](data.md) | `val data: `[`D`](index.md#D)<br>Original data |
