//[base](../index.md)/[com.motorro.rxlcemodel.base](index.md)/[combine](combine.md)



# combine  
[jvm]  
Brief description  


Combines two Lce states. Here is the result state matrix | Receiver   | other      | Result     | |------------|------------|------------| | Loading    | Loading    | Loading    | | Loading    | Content    | Loading    | | Loading    | Error      | Error      | | Loading    | Terminated | Terminated | | Content    | Loading    | Loading    | | Content    | Content    | Content*   | | Content    | Error      | Error      | | Content    | Terminated | Terminated | | Error      | Loading    | Error      | | Error      | Content    | Error      | | Error      | Error      | Error      | | Error      | Terminated | Terminated | | Terminated | Loading    | Terminated | | Terminated | Content    | Terminated | | Terminated | Error      | Terminated | | Terminated | Terminated | Terminated |



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <receiver>| <br><br>An Lce state that has a priority in final state resolution<br><br>
| mapper| <br><br>Data mapper function. Returning null from it means data is not ready and will result in loading state even if both states has data. You may return null-value of any kind to alter resulting state.<br><br>
| other| <br><br>Other state to combine with<br><br>
  
  
Content  
inline fun <[DATA_1](combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_3](combine.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceState](-lce-state/index.md)<[DATA_1](combine.md)>.[combine](combine.md)(other: [LceState](-lce-state/index.md)<[DATA_2](combine.md)>, mapper: ([DATA_1](combine.md)?, [DATA_2](combine.md)?) -> [DATA_3](combine.md)?): [LceState](-lce-state/index.md)<[DATA_3](combine.md)>  



