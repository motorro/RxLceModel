//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../../index.md)/[CacheDelegateSerializerDeserializer](../index.md)/[WithObjectStream](index.md)



# WithObjectStream  
 [jvm] 

Serializes and deserializes [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) objects

class [WithObjectStream](index.md)<[D](index.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)>(**validatorFactory**: [EntityValidatorFactory](../../../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md), **dataClass**: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[D](index.md)>) : [CacheDelegateSerializerDeserializer](../index.md)<[D](index.md)>    


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| dataClass| <br><br>Class type to cast result to<br><br>
| validatorFactory| <br><br>[Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md) validator factory<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [WithObjectStream](-with-object-stream.md)|  [jvm] <br><br>[Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md) validator factory<br><br>fun <[D](index.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)> [WithObjectStream](-with-object-stream.md)(validatorFactory: [EntityValidatorFactory](../../../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md), dataClass: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[D](index.md)>)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [deserializeSnapshot](deserialize-snapshot.md)| [jvm]  <br>Brief description  <br><br><br>Deserializes [Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md) from input stream<br><br>  <br>Content  <br>open override fun [deserializeSnapshot](deserialize-snapshot.md)(input: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), length: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), invalidated: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>?  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [serialize](serialize.md)| [jvm]  <br>Brief description  <br><br><br>Serializes entity to output stream<br><br>  <br>Content  <br>open override fun [serialize](serialize.md)(entity: [Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>, output: [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html))  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

