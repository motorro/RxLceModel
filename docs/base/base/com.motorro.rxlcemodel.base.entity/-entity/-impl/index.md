//[base](../../../../index.md)/[com.motorro.rxlcemodel.base.entity](../../index.md)/[Entity](../index.md)/[Impl](index.md)

# Impl

[jvm]\
data class [Impl](index.md)&lt;out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(val data: [T](index.md), validator: [EntityValidator](../../-entity-validator/index.md)) : [Entity](../index.md)&lt;[T](index.md)&gt; , [EntityValidator](../../-entity-validator/index.md)

Simple entity implementation

## Parameters

jvm

| | |
|---|---|
| data | Stored data |
| validator | Entity validator |

## Constructors

| | |
|---|---|
| [Impl](-impl.md) | [jvm]<br>fun &lt;out [T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [Impl](-impl.md)(data: [T](index.md), validator: [EntityValidator](../../-entity-validator/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | [jvm]<br>open override fun [createSnapshot](create-snapshot.md)(): [Entity](../index.md)&lt;[T](index.md)&gt;<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../../-entity-validator/is-valid.md) value |
| [isValid](../../-entity-validator/is-valid.md) | [jvm]<br>open override fun [isValid](../../-entity-validator/is-valid.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [map](map.md) | [jvm]<br>open override fun &lt;[R](map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [map](map.md)(mapper: ([T](index.md)) -&gt; [R](map.md)): [Entity](../index.md)&lt;[R](map.md)&gt;<br>Transforms Entity [data](data.md) to another entity data with [mapper](map.md) Validation remains the same |
| [serialize](../../-entity-validator/serialize.md) | [jvm]<br>open override fun [serialize](../../-entity-validator/serialize.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [jvm]<br>open override val [data](data.md): [T](index.md) |
