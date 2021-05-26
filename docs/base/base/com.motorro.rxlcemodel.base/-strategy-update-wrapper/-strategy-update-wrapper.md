//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[StrategyUpdateWrapper](index.md)/[StrategyUpdateWrapper](-strategy-update-wrapper.md)



# StrategyUpdateWrapper  
[jvm]  
Brief description  


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| cacheService| <br><br>Data cache service that updates the same cache as [upstream](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/upstream/#/PointingToDeclaration/) uses<br><br>
| DATA| <br><br>Data Type of data being held<br><br>
| ioScheduler| <br><br>Scheduler to run IO operations<br><br>
| logger| <br><br>Logging function<br><br>
| PARAMS| <br><br>Params type that identify data being loaded<br><br>
| upstream| <br><br>LceModel that performs reading<br><br>
  
  
Content  
fun <[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [StrategyUpdateWrapper](-strategy-update-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>, cacheService: [CacheService](../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)<[DATA](index.md), [PARAMS](index.md)>, ioScheduler: [Scheduler](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Scheduler.html), logger: [Logger](../-logger/index.md)?)  



