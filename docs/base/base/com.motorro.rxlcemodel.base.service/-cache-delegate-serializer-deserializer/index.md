//[base](../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[CacheDelegateSerializerDeserializer](index.md)



# CacheDelegateSerializerDeserializer  
 [jvm] 

Serializer for cache delegates

interface [CacheDelegateSerializerDeserializer](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>   


## Types  
  
|  Name|  Summary| 
|---|---|
| [WithObjectStream](-with-object-stream/index.md)| [jvm]  <br>Brief description  <br><br><br>Serializes and deserializes [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) objects<br><br>  <br>Content  <br>class [WithObjectStream](-with-object-stream/index.md)<[D](-with-object-stream/index.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)>(**validatorFactory**: [EntityValidatorFactory](../../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md), **dataClass**: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[D](-with-object-stream/index.md)>) : [CacheDelegateSerializerDeserializer](index.md)<[D](-with-object-stream/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [deserializeSnapshot](deserialize-snapshot.md)| [jvm]  <br>Brief description  <br><br><br>Deserializes [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) snapshot from input stream Snapshots are used because the validity status is only actual when we are getting cached data. https://github.com/motorro/RxLceModel/issues/5<br><br>  <br>Content  <br>abstract fun [deserializeSnapshot](deserialize-snapshot.md)(input: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), length: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), invalidated: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>?  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [serialize](serialize.md)| [jvm]  <br>Brief description  <br><br><br>Serializes entity to output stream<br><br>  <br>Content  <br>abstract fun [serialize](serialize.md)(entity: [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[D](index.md)>, output: [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html))  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| [WithObjectStreamAndCacheKey](../-with-object-stream-and-cache-key/index.md)
| [CacheDelegateSerializerDeserializer](-with-object-stream/index.md)

