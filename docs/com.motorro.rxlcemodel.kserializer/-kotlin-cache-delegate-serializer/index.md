[com.motorro.rxlcemodel.kserializer](../index.md) / [KotlinCacheDelegateSerializer](./index.md)

# KotlinCacheDelegateSerializer

`class KotlinCacheDelegateSerializer<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`CacheDelegateSerializerDeserializer`](../../com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/index.md)`<`[`D`](index.md#D)`>`

Serializes and deserializes objects with [kotlinx.serialization.KSerializer](#)

### Parameters

`validatorFactory` - [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) validator factory

`kSerializer` - Serializer to use with [D](index.md#D)

`binaryFormat` - Cbor serializer to use

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `KotlinCacheDelegateSerializer(validatorFactory: `[`EntityValidatorFactory`](../../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md)`, kSerializer: KSerializer<`[`D`](index.md#D)`>, binaryFormat: BinaryFormat)`<br>Serializes and deserializes objects with [kotlinx.serialization.KSerializer](#) |

### Functions

| Name | Summary |
|---|---|
| [deserializeSnapshot](deserialize-snapshot.md) | `fun deserializeSnapshot(input: `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`, length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, invalidated: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>?`<br>Deserializes [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) snapshot from [input](deserialize-snapshot.md#com.motorro.rxlcemodel.kserializer.KotlinCacheDelegateSerializer$deserializeSnapshot(java.io.InputStream, kotlin.Long, kotlin.Boolean)/input) stream Snapshots are used because the validity status is only actual when we are getting cached data. https://github.com/motorro/RxLceModel/issues/5 |
| [serialize](serialize.md) | `fun serialize(entity: `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>, output: `[`OutputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Serializes [entity](serialize.md#com.motorro.rxlcemodel.kserializer.KotlinCacheDelegateSerializer$serialize(com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.kserializer.KotlinCacheDelegateSerializer.D)), java.io.OutputStream)/entity) to [output](serialize.md#com.motorro.rxlcemodel.kserializer.KotlinCacheDelegateSerializer$serialize(com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.kserializer.KotlinCacheDelegateSerializer.D)), java.io.OutputStream)/output) stream |
