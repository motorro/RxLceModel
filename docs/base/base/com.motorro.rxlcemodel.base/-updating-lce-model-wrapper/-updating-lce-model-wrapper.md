//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[UpdatingLceModelWrapper](index.md)/[UpdatingLceModelWrapper](-updating-lce-model-wrapper.md)



# UpdatingLceModelWrapper  
[jvm]  
Brief description  


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| DATA| <br><br>Data Type of data being held<br><br>
| ioScheduler| <br><br>Scheduler to run IO operations<br><br>
| logger| <br><br>Logging function<br><br>
| PARAMS| <br><br>Params type that identify data being loaded<br><br>
| serviceSet| <br><br>Data service-set. Note that cache service should update the same cache as upstream uses for things to work correctly<br><br>
| UPDATE| <br><br>Update type<br><br>
| upstream| <br><br>LceModel that performs reading<br><br>
  
  
Content  
fun <[DATA](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [UPDATE](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [UpdatingLceModelWrapper](-updating-lce-model-wrapper.md)(upstream: [LceModel](../-lce-model/index.md)<[DATA](index.md), [PARAMS](index.md)>, serviceSet: [UpdatingServiceSet](../../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)<[DATA](index.md), [UPDATE](index.md), [PARAMS](index.md)>, ioScheduler: [Scheduler](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Scheduler.html), logger: [Logger](../-logger/index.md)?)  



