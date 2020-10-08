//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../../index.md)/[EntityValidator](../../index.md)/[Lifespan](../index.md)/[LifespanDeserializer](index.md)/[deserializeSnapshot](deserialize-snapshot.md)



# deserializeSnapshot  
[jvm]  
Brief description  


Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../../is-valid.md) with time



#### Return  


Deserialized validator or null if not recognized



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| serialized| <br><br>Serialized validator<br><br>
  
  
Content  
open override fun [deserializeSnapshot](deserialize-snapshot.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../../index.md)?  



