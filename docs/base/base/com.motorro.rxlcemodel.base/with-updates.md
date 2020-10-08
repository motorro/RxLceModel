//[base](../index.md)/[com.motorro.rxlcemodel.base](index.md)/[withUpdates](with-updates.md)



# withUpdates  
[jvm]  
Brief description  


Wraps an [LceModel](-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](-updating-lce-model/index.md)



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>LceModel that performs reading<br><br>
| DATA| <br><br>Data type of data being held<br><br>
| PARAMS| <br><br>Params type that identify data being loaded<br><br>
| serviceSet| <br><br>Service-set to load data<br><br>
| UPDATE| <br><br>Update type<br><br>
  
  
Content  
fun <[DATA](with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [UPDATE](with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](with-updates.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceModel](-lce-model/index.md)<[DATA](with-updates.md), [PARAMS](with-updates.md)>.[withUpdates](with-updates.md)(serviceSet: [UpdatingServiceSet](../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)<[DATA](with-updates.md), [UPDATE](with-updates.md), [PARAMS](with-updates.md)>): [UpdatingLceModel](-updating-lce-model/index.md)<[DATA](with-updates.md), [UPDATE](with-updates.md), [PARAMS](with-updates.md)>  



