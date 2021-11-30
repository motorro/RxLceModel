//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[CacheDelegateSerializerDeserializer](index.md)/[deserializeSnapshot](deserialize-snapshot.md)

# deserializeSnapshot

[jvm]\
abstract fun [deserializeSnapshot](deserialize-snapshot.md)(input: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), length: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), invalidated: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;?

Deserializes [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) snapshot from [input](deserialize-snapshot.md) stream Snapshots are used because the validity status is only actual when we are getting cached data. https://github.com/motorro/RxLceModel/issues/5

## Parameters

jvm

| | |
|---|---|
| input | Entity to deserialize |
| length | Content length |
| invalidated | If true, the entity was externally invalidated |
