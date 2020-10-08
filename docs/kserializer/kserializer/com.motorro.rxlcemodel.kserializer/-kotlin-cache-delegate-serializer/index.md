//[kserializer](../../index.md)/[com.motorro.rxlcemodel.kserializer](../index.md)/[KotlinCacheDelegateSerializer](index.md)



# KotlinCacheDelegateSerializer  
 [jvm] 

Serializes and deserializes objects with kotlinx.serialization.KSerializer

class [KotlinCacheDelegateSerializer](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**validatorFactory**: EntityValidatorFactory, **kSerializer**: KSerializer<[D](index.md)>, **binaryFormat**: BinaryFormat) : CacheDelegateSerializerDeserializer<[D](index.md)>    


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| binaryFormat| <br><br>Cbor serializer to use<br><br>
| kSerializer| <br><br>Serializer to use with [D](index.md)<br><br>
| validatorFactory| <br><br>Entity validator factory<br><br>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [KotlinCacheDelegateSerializer](-kotlin-cache-delegate-serializer.md)|  [jvm] <br><br>Entity validator factory<br><br>fun <[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [KotlinCacheDelegateSerializer](-kotlin-cache-delegate-serializer.md)(validatorFactory: EntityValidatorFactory, kSerializer: KSerializer<[D](index.md)>, binaryFormat: BinaryFormat)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [deserializeSnapshot](deserialize-snapshot.md)| [jvm]  <br>Brief description  <br><br><br>Deserializes Entity snapshot from input stream Snapshots are used because the validity status is only actual when we are getting cached data. https://github.com/motorro/RxLceModel/issues/5<br><br>  <br>Content  <br>open override fun [deserializeSnapshot](deserialize-snapshot.md)(input: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), length: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), invalidated: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): Entity<[D](index.md)>?  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [serialize](serialize.md)| [jvm]  <br>Brief description  <br><br><br>Serializes entity to output stream<br><br>  <br>Content  <br>open override fun [serialize](serialize.md)(entity: Entity<[D](index.md)>, output: [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html))  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

