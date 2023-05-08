//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache](../index.md)/[WithObjectStreamAndCacheKey](index.md)

# WithObjectStreamAndCacheKey

[jvm]\
class [WithObjectStreamAndCacheKey](index.md)&lt;[D](index.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)&gt;(validatorFactory: [EntityValidatorFactory](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity-validator-factory/index.md), dataClass: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;[D](index.md)&gt;) : [CacheDelegateSerializerDeserializer](../-cache-delegate-serializer-deserializer/index.md)&lt;[DataWithCacheKey](../../../../cache/cache/com.motorro.rxlcemodel.cache/-data-with-cache-key/index.md)&lt;[D](index.md)&gt;&gt; 

Serializes and deserializes [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html) objects along with their caching key

#### Parameters

jvm

| | |
|---|---|
| validatorFactory | [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md) validator factory |
| dataClass | Class type to cast result to |

## Constructors

| | |
|---|---|
| [WithObjectStreamAndCacheKey](-with-object-stream-and-cache-key.md) | [jvm]<br>fun &lt;[D](index.md) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)&gt; [WithObjectStreamAndCacheKey](-with-object-stream-and-cache-key.md)(validatorFactory: [EntityValidatorFactory](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity-validator-factory/index.md), dataClass: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;[D](index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [deserializeSnapshot](deserialize-snapshot.md) | [jvm]<br>open override fun [deserializeSnapshot](deserialize-snapshot.md)(input: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), length: Long, invalidated: Boolean): [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[DataWithCacheKey](../../../../cache/cache/com.motorro.rxlcemodel.cache/-data-with-cache-key/index.md)&lt;[D](index.md)&gt;&gt;?<br>Deserializes [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md) from [input](deserialize-snapshot.md) stream |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(entity: [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[DataWithCacheKey](../../../../cache/cache/com.motorro.rxlcemodel.cache/-data-with-cache-key/index.md)&lt;[D](index.md)&gt;&gt;, output: [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html))<br>Serializes [entity](serialize.md) to [output](serialize.md) stream |
