//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[UpdateWrapper](index.md)/[UpdateWrapper](-update-wrapper.md)



# UpdateWrapper  
[jvm]  
Brief description  


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| cacheService| <br><br>Data cache service that updates the same cache as upstream uses<br><br>
| DATA| <br><br>Data Type of data being held<br><br>
| PARAMS| <br><br>Params type that identify data being loaded<br><br>
| upstream| <br><br>LceModel that performs reading<br><br>
  
  
Content  
fun <[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [UpdateWrapper](-update-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>, cacheService: [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)<[DATA](index.md), [PARAMS](index.md)>)  



