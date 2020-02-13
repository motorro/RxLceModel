[com.motorro.rxlcemodel.base.service](../index.md) / [CacheFriendDelegate](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`CacheFriendDelegate(delegate: `[`Delegate`](../-sync-delegate-cache-service/-delegate/index.md)`<`[`DataWithCacheKey`](../-data-with-cache-key/index.md)`<`[`D`](index.md#D)`>, `[`P`](index.md#P)`>)`

Wraps [delegate](#) adding unmodified [CacheFriend.cacheKey](../-cache-friend/cache-key.md) to the mix with data.
Validates that key on [get](get.md) and returns null if it is not equals original.
Helps to make sure the data returned is not a result of clashed cache key.

