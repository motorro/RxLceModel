//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../../index.md)/[SyncDelegateCacheService](../index.md)/[Delegate](index.md)



# Delegate  
 [jvm] 

Delegate that synchronously performs caching operations

interface [Delegate](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [delete](delete.md)| [jvm]  <br>Brief description  <br><br><br>Deletes cached value<br><br>  <br>Content  <br>abstract fun [delete](delete.md)(params: [P](index.md))  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [get](get.md)| [jvm]  <br>Brief description  <br><br><br>Returns data if cached<br><br>  <br>Content  <br>abstract fun [get](get.md)(params: [P](index.md)): [Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>?  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [invalidate](invalidate.md)| [jvm]  <br>Brief description  <br><br><br>Invalidates cached value<br><br>  <br>Content  <br>abstract fun [invalidate](invalidate.md)(params: [P](index.md))  <br><br><br>
| [invalidateAll](invalidate-all.md)| [jvm]  <br>Brief description  <br><br><br>Invalidates all cached values<br><br>  <br>Content  <br>abstract fun [invalidateAll](invalidate-all.md)()  <br><br><br>
| [save](save.md)| [jvm]  <br>Brief description  <br><br><br>Saves data to cache<br><br>  <br>Content  <br>abstract fun [save](save.md)(params: [P](index.md), entity: [Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| [CacheFriendDelegate](../../-cache-friend-delegate/index.md)
| [MemorySyncDelegate](../../-memory-sync-delegate/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| [makeFriendParams](../../make-friend-params.md)| [jvm]  <br>Brief description  <br><br><br>Creates an adapter delegate that creates [CacheFriend](../../-cache-friend/index.md) params using stringify function<br><br>  <br>Content  <br>inline fun <[D](../../make-friend-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](../../make-friend-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [SyncDelegateCacheService.Delegate](index.md)<[D](../../make-friend-params.md), [CacheFriend](../../-cache-friend/index.md)>.[makeFriendParams](../../make-friend-params.md)(crossinline stringify: [P](../../make-friend-params.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SyncDelegateCacheService.Delegate](index.md)<[D](../../make-friend-params.md), [P](../../make-friend-params.md)>  <br><br><br>
| [stringifyParams](../../stringify-params.md)| [jvm]  <br>Brief description  <br><br><br>Creates an adapter delegate that [stringify](../../stringify-params.md) and uses result string as params to receiver<br><br>  <br>Content  <br>inline fun <[D](../../stringify-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](../../stringify-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [SyncDelegateCacheService.Delegate](index.md)<[D](../../stringify-params.md), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>.[stringifyParams](../../stringify-params.md)(crossinline stringify: [P](../../stringify-params.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SyncDelegateCacheService.Delegate](index.md)<[D](../../stringify-params.md), [P](../../stringify-params.md)>  <br><br><br>

