//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../../index.md)/[MemorySyncDelegate](../index.md)/[Companion](index.md)/[custom](custom.md)



# custom  
[jvm]  
Brief description  


Creates an in-memory LRU cache with custom map as a cache



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| map| <br><br>A map to hold cache data<br><br>
  
  
Content  
fun <[D](custom.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](custom.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [custom](custom.md)(map: [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[P](custom.md), [Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](custom.md)>>): [MemorySyncDelegate](../index.md)<[D](custom.md), [P](custom.md)>  



