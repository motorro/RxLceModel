[com.motorro.rxlcemodel.base.service](../index.md) / [CacheDelegateSerializerDeserializer](index.md) / [deserialize](./deserialize.md)

# deserialize

`abstract fun deserialize(input: `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`, length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, invalidated: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>?`

Deserializes [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) from [input](deserialize.md#com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer$deserialize(java.io.InputStream, kotlin.Long, kotlin.Boolean)/input) stream

### Parameters

`input` - Entity to deserialize

`length` - Content length

`invalidated` - If true, the entity was externally invalidated