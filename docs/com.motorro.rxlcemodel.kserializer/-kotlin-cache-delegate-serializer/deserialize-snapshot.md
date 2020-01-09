[com.motorro.rxlcemodel.kserializer](../index.md) / [KotlinCacheDelegateSerializer](index.md) / [deserializeSnapshot](./deserialize-snapshot.md)

# deserializeSnapshot

`fun deserializeSnapshot(input: `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`, length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, invalidated: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`D`](index.md#D)`>?`

Overrides [CacheDelegateSerializerDeserializer.deserializeSnapshot](../../com.motorro.rxlcemodel.base.service/-cache-delegate-serializer-deserializer/deserialize-snapshot.md)

Deserializes [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) snapshot from [input](deserialize-snapshot.md#com.motorro.rxlcemodel.kserializer.KotlinCacheDelegateSerializer$deserializeSnapshot(java.io.InputStream, kotlin.Long, kotlin.Boolean)/input) stream
Snapshots are used because the validity status is only actual when we are getting cached data.
https://github.com/motorro/RxLceModel/issues/5

### Parameters

`input` - Entity to deserialize

`length` - Content length

`invalidated` - If true, the entity was externally invalidated