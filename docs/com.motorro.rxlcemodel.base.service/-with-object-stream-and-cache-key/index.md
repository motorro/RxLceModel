[com.motorro.rxlcemodel.base.service](../index.md) / [WithObjectStreamAndCacheKey](./index.md)

# WithObjectStreamAndCacheKey

`class WithObjectStreamAndCacheKey<D : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)`> : `[`CacheDelegateSerializerDeserializer`](../-cache-delegate-serializer-deserializer/index.md)`<`[`DataWithCacheKey`](../-data-with-cache-key/index.md)`<`[`D`](index.md#D)`>>`

Serializes and deserializes [Serializable](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html) objects along with their caching key

### Parameters

`validatorFactory` - [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) validator factory

`dataClass` - Class type to cast result to

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WithObjectStreamAndCacheKey(validatorFactory: `[`EntityValidatorFactory`](../../com.motorro.rxlcemodel.base.entity/-entity-validator-factory/index.md)`, dataClass: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<`[`D`](index.md#D)`>)`<br>Serializes and deserializes [Serializable](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html) objects along with their caching key |

### Functions

| Name | Summary |
|---|---|
| [deserializeSnapshot](deserialize-snapshot.md) | `fun deserializeSnapshot(input: `[`InputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`, length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, invalidated: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`DataWithCacheKey`](../-data-with-cache-key/index.md)`<`[`D`](index.md#D)`>>?`<br>Deserializes [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) from [input](deserialize-snapshot.md#com.motorro.rxlcemodel.base.service.WithObjectStreamAndCacheKey$deserializeSnapshot(java.io.InputStream, kotlin.Long, kotlin.Boolean)/input) stream |
| [serialize](serialize.md) | `fun serialize(entity: `[`Entity`](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)`<`[`DataWithCacheKey`](../-data-with-cache-key/index.md)`<`[`D`](index.md#D)`>>, output: `[`OutputStream`](http://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`): <ERROR CLASS>`<br>Serializes [entity](serialize.md#com.motorro.rxlcemodel.base.service.WithObjectStreamAndCacheKey$serialize(com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.service.DataWithCacheKey((com.motorro.rxlcemodel.base.service.WithObjectStreamAndCacheKey.D)))), java.io.OutputStream)/entity) to [output](serialize.md#com.motorro.rxlcemodel.base.service.WithObjectStreamAndCacheKey$serialize(com.motorro.rxlcemodel.base.entity.Entity((com.motorro.rxlcemodel.base.service.DataWithCacheKey((com.motorro.rxlcemodel.base.service.WithObjectStreamAndCacheKey.D)))), java.io.OutputStream)/output) stream |
