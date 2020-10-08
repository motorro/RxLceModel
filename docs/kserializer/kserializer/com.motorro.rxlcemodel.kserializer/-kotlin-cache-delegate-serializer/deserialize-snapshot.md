//[kserializer](../../index.md)/[com.motorro.rxlcemodel.kserializer](../index.md)/[KotlinCacheDelegateSerializer](index.md)/[deserializeSnapshot](deserialize-snapshot.md)



# deserializeSnapshot  
[jvm]  
Brief description  


Deserializes Entity snapshot from input stream Snapshots are used because the validity status is only actual when we are getting cached data. https://github.com/motorro/RxLceModel/issues/5



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| input| <br><br>Entity to deserialize<br><br>
| invalidated| <br><br>If true, the entity was externally invalidated<br><br>
| length| <br><br>Content length<br><br>
  
  
Content  
open override fun [deserializeSnapshot](deserialize-snapshot.md)(input: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), length: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), invalidated: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): Entity<[D](index.md)>?  



