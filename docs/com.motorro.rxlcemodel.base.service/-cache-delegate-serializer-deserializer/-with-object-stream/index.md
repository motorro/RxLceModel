[com.motorro.rxlcemodel.base.service](../../index.md) / [CacheDelegateSerializerDeserializer](../index.md) / [WithObjectStream](./index.md)

# WithObjectStream

`class WithObjectStream<D : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`> : `[`CacheDelegateSerializerDeserializer`](../index.md)`<`[`D`](index.md#D)`>`

Serializes and deserialises [Serializable](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html) objects

### Parameters

`validatorFactory` - [Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md) validator factory

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WithObjectStream(validatorFactory: `[`EntityValidatorFactory`](../../../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md)`, dataClass: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<`[`D`](index.md#D)`>)`<br>Serializes and deserialises [Serializable](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html) objects |

### Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | `fun deserialize(input: `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`, length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, invalidated: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Entity`](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>?`<br>Deserializes [Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md) from [input](deserialize.md#com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer.WithObjectStream$deserialize(java.io.InputStream, kotlin.Long, kotlin.Boolean)/input) stream |
| [serialize](serialize.md) | `fun serialize(entity: `[`Entity`](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>, output: `[`OutputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Serializes [entity](serialize.md#com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer.WithObjectStream$serialize(com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer.WithObjectStream.D)), java.io.OutputStream)/entity) to [output](serialize.md#com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer.WithObjectStream$serialize(com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer.WithObjectStream.D)), java.io.OutputStream)/output) stream |
