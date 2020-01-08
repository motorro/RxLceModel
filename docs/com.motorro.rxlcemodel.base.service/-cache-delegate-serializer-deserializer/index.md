[com.motorro.rxlcemodel.base.service](../index.md) / [CacheDelegateSerializerDeserializer](./index.md)

# CacheDelegateSerializerDeserializer

`interface CacheDelegateSerializerDeserializer<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

Serializer for cache delegates

### Types

| Name | Summary |
|---|---|
| [WithObjectStream](-with-object-stream/index.md) | `class WithObjectStream<D : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`> : `[`CacheDelegateSerializerDeserializer`](./index.md)`<`[`D`](-with-object-stream/index.md#D)`>`<br>Serializes and deserializes [Serializable](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html) objects |

### Functions

| Name | Summary |
|---|---|
| [deserializeSnapshot](deserialize-snapshot.md) | `abstract fun deserializeSnapshot(input: `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`, length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, invalidated: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>?`<br>Deserializes [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) snapshot from [input](deserialize-snapshot.md#com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer$deserializeSnapshot(java.io.InputStream, kotlin.Long, kotlin.Boolean)/input) stream Snapshots are used because the validity status is only actual when we are getting cached data. https://github.com/motorro/RxLceModel/issues/5 |
| [serialize](serialize.md) | `abstract fun serialize(entity: `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>, output: `[`OutputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Serializes [entity](serialize.md#com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer$serialize(com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer.D)), java.io.OutputStream)/entity) to [output](serialize.md#com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer$serialize(com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer.D)), java.io.OutputStream)/output) stream |

### Inheritors

| Name | Summary |
|---|---|
| [KotlinCacheDelegateSerializer](../../com.motorro.rxlcemodel.kserializer/-kotlin-cache-delegate-serializer/index.md) | `class KotlinCacheDelegateSerializer<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`CacheDelegateSerializerDeserializer`](./index.md)`<`[`D`](../../com.motorro.rxlcemodel.kserializer/-kotlin-cache-delegate-serializer/index.md#D)`>`<br>Serializes and deserializes objects with [kotlinx.serialization.KSerializer](#) |
| [WithObjectStream](-with-object-stream/index.md) | `class WithObjectStream<D : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`> : `[`CacheDelegateSerializerDeserializer`](./index.md)`<`[`D`](-with-object-stream/index.md#D)`>`<br>Serializes and deserializes [Serializable](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html) objects |
