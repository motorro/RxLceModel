//[base](../index.md)/[com.motorro.rxlcemodel.base](index.md)/[map](map.md)



# map  
[jvm]  
Brief description  


Maps data in LceState



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| mapper| <br><br>Data mapper<br><br>
  
  
Content  
inline fun <[DATA_1](map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceState](-lce-state/index.md)<[DATA_1](map.md)>.[map](map.md)(mapper: ([DATA_1](map.md)) -> [DATA_2](map.md)): [LceState](-lce-state/index.md)<[DATA_2](map.md)>  


[jvm]  
Brief description  


Creates a use-case wrapper that converts [DATA_1](map.md) to [DATA_2](map.md)



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Original model<br><br>
| DATA_1| <br><br>Source data type<br><br>
| DATA_2| <br><br>Resulting data type<br><br>
| mapper| <br><br>Data mapper<br><br>
  
  
Content  
fun <[DATA_1](map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceUseCase](-lce-use-case/index.md)<[DATA_1](map.md)>.[map](map.md)(mapper: ([DATA_1](map.md)) -> [DATA_2](map.md)): [LceUseCase](-lce-use-case/index.md)<[DATA_2](map.md)>  


[jvm]  
Brief description  


Creates a model wrapper that converts [DATA_1](map.md) to [DATA_2](map.md)



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>Original model<br><br>
| DATA_1| <br><br>Source model data type<br><br>
| DATA_2| <br><br>Resulting model data type<br><br>
| mapper| <br><br>Data mapper<br><br>
| PARAMS| <br><br>Params type that identify data being loaded<br><br>
  
  
Content  
fun <[DATA_1](map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceModel](-lce-model/index.md)<[DATA_1](map.md), [PARAMS](map.md)>.[map](map.md)(mapper: ([DATA_1](map.md)) -> [DATA_2](map.md)): [LceModel](-lce-model/index.md)<[DATA_2](map.md), [PARAMS](map.md)>  



