//[base](../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[MemorySyncDelegate](index.md)



# MemorySyncDelegate  
 [jvm] 

A simple memory cache for [SyncDelegateCacheService](../-sync-delegate-cache-service/index.md).

abstract class [MemorySyncDelegate](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> : [SyncDelegateCacheService.Delegate](../-sync-delegate-cache-service/-delegate/index.md)<[D](index.md), [P](index.md)>    


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| D| <br><br>Data type<br><br>
| P| <br><br>Params type<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [MemorySyncDelegate](-memory-sync-delegate.md)|  [jvm] <br><br>Data type<br><br>fun [MemorySyncDelegate](-memory-sync-delegate.md)()   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| [Companion](-companion/index.md)| [jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


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

