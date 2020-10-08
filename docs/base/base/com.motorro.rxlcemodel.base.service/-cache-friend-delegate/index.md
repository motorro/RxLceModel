//[base](../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[CacheFriendDelegate](index.md)



# CacheFriendDelegate  
 [jvm] 

Wraps delegate adding unmodified [CacheFriend.cacheKey](../-cache-friend/index.md#com.motorro.rxlcemodel.base.service/CacheFriend/cacheKey/#/PointingToDeclaration/) to the mix with data. Validates that key on [get](get.md) and returns null if it is not equals original. Helps to make sure the data returned is not a result of clashed cache key.

class [CacheFriendDelegate](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [CacheFriend](../-cache-friend/index.md)>(**delegate**: [SyncDelegateCacheService.Delegate](../-sync-delegate-cache-service/-delegate/index.md)<[DataWithCacheKey](../-data-with-cache-key/index.md)<[D](index.md)>, [P](index.md)>) : [SyncDelegateCacheService.Delegate](../-sync-delegate-cache-service/-delegate/index.md)<[D](index.md), [P](index.md)>    


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [CacheFriendDelegate](-cache-friend-delegate.md)|  [jvm] fun <[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [CacheFriend](../-cache-friend/index.md)> [CacheFriendDelegate](-cache-friend-delegate.md)(delegate: [SyncDelegateCacheService.Delegate](../-sync-delegate-cache-service/-delegate/index.md)<[DataWithCacheKey](../-data-with-cache-key/index.md)<[D](index.md)>, [P](index.md)>)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [delete](delete.md)| [jvm]  <br>Brief description  <br><br><br>Deletes cached value<br><br>  <br>Content  <br>open override fun [delete](delete.md)(params: [P](index.md))  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [get](get.md)| [jvm]  <br>Brief description  <br><br><br>Returns data if cached<br><br>  <br>Content  <br>open override fun [get](get.md)(params: [P](index.md)): [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>?  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [invalidate](invalidate.md)| [jvm]  <br>Brief description  <br><br><br>Invalidates cached value<br><br>  <br>Content  <br>open override fun [invalidate](invalidate.md)(params: [P](index.md))  <br><br><br>
| [invalidateAll](invalidate-all.md)| [jvm]  <br>Brief description  <br><br><br>Invalidates all cached values<br><br>  <br>Content  <br>open override fun [invalidateAll](invalidate-all.md)()  <br><br><br>
| [save](save.md)| [jvm]  <br>Brief description  <br><br><br>Saves data to cache<br><br>  <br>Content  <br>open override fun [save](save.md)(params: [P](index.md), entity: [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

