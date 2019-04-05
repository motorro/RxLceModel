[com.motorro.rxlcemodel.base.service](../../index.md) / [CacheDelegateSerializerDeserializer](../index.md) / [WithObjectStream](index.md) / [deserializeSnapshot](./deserialize-snapshot.md)

# deserializeSnapshot

`fun deserializeSnapshot(input: `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`, length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, invalidated: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Entity`](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>?`

Overrides [CacheDelegateSerializerDeserializer.deserializeSnapshot](../deserialize-snapshot.md)

Deserializes [Entity](../../../com.motorro.rxlcemodel.base.entity/-entity/index.md) from [input](deserialize-snapshot.md#com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer.WithObjectStream$deserializeSnapshot(java.io.InputStream, kotlin.Long, kotlin.Boolean)/input) stream

### Parameters

`input` - Entity to deserialize

`length` - Content length