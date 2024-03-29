//[kserializer](../../../index.md)/[com.motorro.rxlcemodel.kserializer](../index.md)/[KotlinCacheDelegateSerializer](index.md)

# KotlinCacheDelegateSerializer

@ExperimentalSerializationApi

class [KotlinCacheDelegateSerializer](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(validatorFactory: [EntityValidatorFactory](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity-validator-factory/index.md), kSerializer: KSerializer&lt;[D](index.md)&gt;, binaryFormat: BinaryFormat) : [CacheDelegateSerializerDeserializer](../../../../cache/cache/com.motorro.rxlcemodel.cache/-cache-delegate-serializer-deserializer/index.md)&lt;[D](index.md)&gt; 

Serializes and deserializes objects with kotlinx.serialization.KSerializer

#### Parameters

jvm

| | |
|---|---|
| validatorFactory | [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md) validator factory |
| kSerializer | Serializer to use with [D](index.md) |
| binaryFormat | Serializer to use |

## Constructors

| | |
|---|---|
| [KotlinCacheDelegateSerializer](-kotlin-cache-delegate-serializer.md) | [jvm]<br>constructor(validatorFactory: [EntityValidatorFactory](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity-validator-factory/index.md), kSerializer: KSerializer&lt;[D](index.md)&gt;, binaryFormat: BinaryFormat) |

## Functions

| Name | Summary |
|---|---|
| [deserializeSnapshot](deserialize-snapshot.md) | [jvm]<br>open override fun [deserializeSnapshot](deserialize-snapshot.md)(input: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), length: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), invalidated: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;?<br>Deserializes [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md) snapshot from [input](deserialize-snapshot.md) stream Snapshots are used because the validity status is only actual when we are getting cached data. https://github.com/motorro/RxLceModel/issues/5 |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(entity: [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;, output: [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html))<br>Serializes [entity](serialize.md) to [output](serialize.md) stream |
