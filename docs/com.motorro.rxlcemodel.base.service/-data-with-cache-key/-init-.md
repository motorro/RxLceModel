[com.motorro.rxlcemodel.base.service](../index.md) / [DataWithCacheKey](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`DataWithCacheKey(data: `[`D`](index.md#D)`, cacheKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`

Data combined with full cached key to validate we get exactly what we are looking for
For example, DiskLruCache has strict requirements and limited length of a cache key and
hashing of keys may be required to fit into requirements - thus there is a possibility of key
clash.

### Parameters

`data` - Original data

`cacheKey` - Full unmodified cache key

**See Also**

[CacheFriendDelegate](../-cache-friend-delegate/index.md)

