//[base](../index.md)/[com.motorro.rxlcemodel.base.service](index.md)/[stringifyParams](stringify-params.md)



# stringifyParams  
[jvm]  
Brief description  


Creates an adapter delegate that [stringify](stringify-params.md) and uses result string as params to receiver



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Delegate with String params e.g. the one that saves data to files and uses params as file names<br><br>
| stringify| <br><br>Function to stringify [P](stringify-params.md)<br><br>
  
  
Content  
inline fun <[D](stringify-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](stringify-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [SyncDelegateCacheService.Delegate](-sync-delegate-cache-service/-delegate/index.md)<[D](stringify-params.md), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>.[stringifyParams](stringify-params.md)(crossinline stringify: [P](stringify-params.md).() -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SyncDelegateCacheService.Delegate](-sync-delegate-cache-service/-delegate/index.md)<[D](stringify-params.md), [P](stringify-params.md)>  



