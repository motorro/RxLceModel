//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../index.md)/[Entity](index.md)

# Entity

interface [Entity](index.md)&lt;out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [EntityValidator](../-entity-validator/index.md)

Cache-controlling entity for [com.motorro.rxlcemodel.cache.entity.Entity](index.md) implement this interface for cache control

#### Inheritors

| |
|---|
| [Impl](-impl/index.md) |

## Types

| Name | Summary |
|---|---|
| [Impl](-impl/index.md) | [common]<br>data class [Impl](-impl/index.md)&lt;out [T](-impl/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(val data: [T](-impl/index.md), validator: [EntityValidator](../-entity-validator/index.md)) : [Entity](index.md)&lt;[T](-impl/index.md)&gt; , [EntityValidator](../-entity-validator/index.md)<br>Simple entity implementation |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [common]<br>abstract val [data](data.md): [T](index.md)<br>Entity data |

## Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | [common]<br>abstract override fun [createSnapshot](create-snapshot.md)(): [Entity](index.md)&lt;[T](index.md)&gt;<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../-entity-validator/is-valid.md) value |
| [isValid](../-entity-validator/is-valid.md) | [common]<br>abstract fun [isValid](../-entity-validator/is-valid.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [map](map.md) | [common]<br>abstract fun &lt;[R](map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [map](map.md)(mapper: ([T](index.md)) -&gt; [R](map.md)): [Entity](index.md)&lt;[R](map.md)&gt;<br>Transforms Entity [data](data.md) to another entity data with [mapper](map.md) Validation remains the same |
| [serialize](../-entity-validator/serialize.md) | [common]<br>abstract fun [serialize](../-entity-validator/serialize.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |
