[com.motorro.rxlcemodel.kserializer](../index.md) / [DataWithCacheKeySerializer](./index.md)

# DataWithCacheKeySerializer

`data class DataWithCacheKeySerializer<D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : KSerializer<`[`DataWithCacheKey`](../../com.motorro.rxlcemodel.base.service/-data-with-cache-key/index.md)`<`[`D`](index.md#D)`>>`

Serializer for [DataWithCacheKey](../../com.motorro.rxlcemodel.base.service/-data-with-cache-key/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DataWithCacheKeySerializer(dataSerializer: KSerializer<`[`D`](index.md#D)`>)`<br>Serializer for [DataWithCacheKey](../../com.motorro.rxlcemodel.base.service/-data-with-cache-key/index.md) |

### Properties

| Name | Summary |
|---|---|
| [dataSerializer](data-serializer.md) | `val dataSerializer: KSerializer<`[`D`](index.md#D)`>` |
| [descriptor](descriptor.md) | `val descriptor: SerialDescriptor` |

### Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | `fun deserialize(decoder: Decoder): `[`DataWithCacheKey`](../../com.motorro.rxlcemodel.base.service/-data-with-cache-key/index.md)`<`[`D`](index.md#D)`>` |
| [serialize](serialize.md) | `fun serialize(encoder: Encoder, value: `[`DataWithCacheKey`](../../com.motorro.rxlcemodel.base.service/-data-with-cache-key/index.md)`<`[`D`](index.md#D)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
