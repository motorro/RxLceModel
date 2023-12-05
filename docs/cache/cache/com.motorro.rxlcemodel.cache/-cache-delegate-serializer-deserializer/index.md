//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache](../index.md)/[CacheDelegateSerializerDeserializer](index.md)

# CacheDelegateSerializerDeserializer

interface [CacheDelegateSerializerDeserializer](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

Serializer for cache delegates

#### Inheritors

| |
|---|
| [WithObjectStream](-with-object-stream/index.md) |
| [WithObjectStreamAndCacheKey](../-with-object-stream-and-cache-key/index.md) |

## Types

| Name | Summary |
|---|---|
| [WithObjectStream](-with-object-stream/index.md) | [jvm]<br>class [WithObjectStream](-with-object-stream/index.md)&lt;[D](-with-object-stream/index.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)&gt;(validatorFactory: [EntityValidatorFactory](../../com.motorro.rxlcemodel.cache.entity/-entity-validator-factory/index.md), dataClass: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;[D](-with-object-stream/index.md)&gt;) : [CacheDelegateSerializerDeserializer](index.md)&lt;[D](-with-object-stream/index.md)&gt; <br>Serializes and deserializes [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) objects |

## Functions

| Name | Summary |
|---|---|
| [deserializeSnapshot](deserialize-snapshot.md) | [jvm]<br>abstract fun [deserializeSnapshot](deserialize-snapshot.md)(input: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), length: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), invalidated: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Entity](../../com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;?<br>Deserializes [Entity](../../com.motorro.rxlcemodel.cache.entity/-entity/index.md) snapshot from [input](deserialize-snapshot.md) stream Snapshots are used because the validity status is only actual when we are getting cached data. https://github.com/motorro/RxLceModel/issues/5 |
| [serialize](serialize.md) | [jvm]<br>abstract fun [serialize](serialize.md)(entity: [Entity](../../com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;, output: [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html))<br>Serializes [entity](serialize.md) to [output](serialize.md) stream |
