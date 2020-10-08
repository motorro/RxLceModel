//[base](../index.md)/[com.motorro.rxlcemodel.base.service](index.md)/[makeFriendParams](make-friend-params.md)



# makeFriendParams  
[jvm]  
Brief description  


Creates an adapter delegate that creates [CacheFriend](-cache-friend/index.md) params using stringify function



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Delegate with [CacheFriend](-cache-friend/index.md) params e.g. the one that saves data to files and uses params as file names<br><br>
| stringify| <br><br>Function to stringify [P](make-friend-params.md)<br><br>
  
  
Content  
inline fun <[D](make-friend-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](make-friend-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [SyncDelegateCacheService.Delegate](-sync-delegate-cache-service/-delegate/index.md)<[D](make-friend-params.md), [CacheFriend](-cache-friend/index.md)>.[makeFriendParams](make-friend-params.md)(crossinline stringify: [P](make-friend-params.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SyncDelegateCacheService.Delegate](-sync-delegate-cache-service/-delegate/index.md)<[D](make-friend-params.md), [P](make-friend-params.md)>  



