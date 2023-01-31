//[kserializer](../../../index.md)/[com.motorro.rxlcemodel.kserializer](../index.md)/[DataWithCacheKeySerializer](index.md)

# DataWithCacheKeySerializer

[jvm]\
@ExperimentalSerializationApi

data class [DataWithCacheKeySerializer](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(val dataSerializer: KSerializer&lt;[D](index.md)&gt;) : KSerializer&lt;[DataWithCacheKey](../../../../cache/cache/com.motorro.rxlcemodel.cache/-data-with-cache-key/index.md)&lt;[D](index.md)&gt;&gt; 

Serializer for [DataWithCacheKey](../../../../cache/cache/com.motorro.rxlcemodel.cache/-data-with-cache-key/index.md)

## Constructors

| | |
|---|---|
| [DataWithCacheKeySerializer](-data-with-cache-key-serializer.md) | [jvm]<br>fun &lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [DataWithCacheKeySerializer](-data-with-cache-key-serializer.md)(dataSerializer: KSerializer&lt;[D](index.md)&gt;) |

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [jvm]<br>open override fun [deserialize](deserialize.md)(decoder: Decoder): [DataWithCacheKey](../../../../cache/cache/com.motorro.rxlcemodel.cache/-data-with-cache-key/index.md)&lt;[D](index.md)&gt; |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(encoder: Encoder, value: [DataWithCacheKey](../../../../cache/cache/com.motorro.rxlcemodel.cache/-data-with-cache-key/index.md)&lt;[D](index.md)&gt;) |

## Properties

| Name | Summary |
|---|---|
| [dataSerializer](data-serializer.md) | [jvm]<br>val [dataSerializer](data-serializer.md): KSerializer&lt;[D](index.md)&gt; |
| [descriptor](descriptor.md) | [jvm]<br>open override val [descriptor](descriptor.md): SerialDescriptor |
