//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../../index.md)/[EntityValidator](../../index.md)/[Lifespan](../index.md)/[Companion](index.md)/[createSnapshot](create-snapshot.md)



# createSnapshot  
[jvm]  
Brief description  


Creates a snapshot that may be serialized and deserialized back to dynamic [Lifespan](../index.md)



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| clock| <br><br>Clock implementation<br><br>
| ttl| <br><br>Time to live<br><br>
  
  
Content  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [createSnapshot](create-snapshot.md)(ttl: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), clock: [Clock](../../../-clock/index.md)): [EntityValidator.Lifespan](../index.md)  



