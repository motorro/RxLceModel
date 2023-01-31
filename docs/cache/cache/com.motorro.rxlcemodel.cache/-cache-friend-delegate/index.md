//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache](../index.md)/[CacheFriendDelegate](index.md)

# CacheFriendDelegate

[common]\
class [CacheFriendDelegate](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [CacheFriend](../-cache-friend/index.md)&gt;(delegate: [CacheDelegate](../-cache-delegate/index.md)&lt;[DataWithCacheKey](../-data-with-cache-key/index.md)&lt;[D](index.md)&gt;, [P](index.md)&gt;) : [CacheDelegate](../-cache-delegate/index.md)&lt;[D](index.md), [P](index.md)&gt; 

Wraps [delegate](../../../../cache/com.motorro.rxlcemodel.cache/-cache-friend-delegate/delegate.md) adding unmodified [CacheFriend.cacheKey](../-cache-friend/cache-key.md) to the mix with data. Validates that key on [get](get.md) and returns null if it is not equals original. Helps to make sure the data returned is not a result of clashed cache key.

## Constructors

| | |
|---|---|
| [CacheFriendDelegate](-cache-friend-delegate.md) | [common]<br>fun &lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [CacheFriend](../-cache-friend/index.md)&gt; [CacheFriendDelegate](-cache-friend-delegate.md)(delegate: [CacheDelegate](../-cache-delegate/index.md)&lt;[DataWithCacheKey](../-data-with-cache-key/index.md)&lt;[D](index.md)&gt;, [P](index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [common]<br>open override fun [delete](delete.md)(params: [P](index.md))<br>Deletes cached value |
| [get](get.md) | [common]<br>open override fun [get](get.md)(params: [P](index.md)): [Entity](../../com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;?<br>Returns data if cached |
| [invalidate](invalidate.md) | [common]<br>open override fun [invalidate](invalidate.md)(params: [P](index.md))<br>Invalidates cached value |
| [invalidateAll](invalidate-all.md) | [common]<br>open override fun [invalidateAll](invalidate-all.md)()<br>Invalidates all cached values |
| [save](save.md) | [common]<br>open override fun [save](save.md)(params: [P](index.md), entity: [Entity](../../com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;)<br>Saves data to cache |

## Extensions

| Name | Summary |
|---|---|
| [makeFriendParams](../make-friend-params.md) | [common]<br>inline fun &lt;[D](../make-friend-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](../make-friend-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [CacheDelegate](../-cache-delegate/index.md)&lt;[D](../make-friend-params.md), [CacheFriend](../-cache-friend/index.md)&gt;.[makeFriendParams](../make-friend-params.md)(crossinline stringify: [P](../make-friend-params.md).() -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [CacheDelegate](../-cache-delegate/index.md)&lt;[D](../make-friend-params.md), [P](../make-friend-params.md)&gt;<br>Creates an adapter delegate that creates [CacheFriend](../-cache-friend/index.md) params using [stringify](../make-friend-params.md) function |
| [stringifyParams](../stringify-params.md) | [common]<br>inline fun &lt;[D](../stringify-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](../stringify-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [CacheDelegate](../-cache-delegate/index.md)&lt;[D](../stringify-params.md), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;.[stringifyParams](../stringify-params.md)(crossinline stringify: [P](../stringify-params.md).() -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { toString() }): [CacheDelegate](../-cache-delegate/index.md)&lt;[D](../stringify-params.md), [P](../stringify-params.md)&gt;<br>Creates an adapter delegate that [stringify](../stringify-params.md) and uses result string as params to receiver |
