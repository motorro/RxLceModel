//[base](../../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../../index.md)/[EntityValidator](../../index.md)/[Simple](../index.md)/[SimpleDeserializer](index.md)

# SimpleDeserializer

[jvm]\
object [SimpleDeserializer](index.md) : [EntityValidator.Deserializer](../../-deserializer/index.md)

Deserializes validator from string

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [jvm]<br>open override fun [deserialize](deserialize.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../../index.md)?<br>Deserializes validator from string if string is recognized |
| [deserializeSnapshot](../../-deserializer/deserialize-snapshot.md) | [jvm]<br>open fun [deserializeSnapshot](../../-deserializer/deserialize-snapshot.md)(serialized: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EntityValidator](../../index.md)?<br>Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../../is-valid.md) with time |
