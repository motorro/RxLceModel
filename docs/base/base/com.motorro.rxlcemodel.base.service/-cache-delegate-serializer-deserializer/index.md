//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[CacheDelegateSerializerDeserializer](index.md)

# CacheDelegateSerializerDeserializer

[jvm]\
interface [CacheDelegateSerializerDeserializer](index.md)&lt;[D](index.md) : Any&gt;

Serializer for cache delegates

## Types

| Name | Summary |
|---|---|
| [WithObjectStream](-with-object-stream/index.md) | [jvm]<br>class [WithObjectStream](-with-object-stream/index.md)&lt;[D](-with-object-stream/index.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)&gt;(validatorFactory: [EntityValidatorFactory](../../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md), dataClass: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;[D](-with-object-stream/index.md)&gt;) : [CacheDelegateSerializerDeserializer](index.md)&lt;[D](-with-object-stream/index.md)&gt; <br>Serializes and deserializes [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) objects |

## Functions

| Name | Summary |
|---|---|
| [deserializeSnapshot](deserialize-snapshot.md) | [jvm]<br>abstract fun [deserializeSnapshot](deserialize-snapshot.md)(input: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), length: Long, invalidated: Boolean): [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;?<br>Deserializes [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) snapshot from [input](deserialize-snapshot.md) stream Snapshots are used because the validity status is only actual when we are getting cached data. https://github.com/motorro/RxLceModel/issues/5 |
| [serialize](serialize.md) | [jvm]<br>abstract fun [serialize](serialize.md)(entity: [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;, output: [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html))<br>Serializes [entity](serialize.md) to [output](serialize.md) stream |

## Inheritors

| Name |
|---|
| [WithObjectStreamAndCacheKey](../-with-object-stream-and-cache-key/index.md) |
| [CacheDelegateSerializerDeserializer](-with-object-stream/index.md) |
