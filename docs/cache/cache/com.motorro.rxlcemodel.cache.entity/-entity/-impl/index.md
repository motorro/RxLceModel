//[cache](../../../../index.md)/[com.motorro.rxlcemodel.cache.entity](../../index.md)/[Entity](../index.md)/[Impl](index.md)

# Impl

[common]\
data class [Impl](index.md)&lt;out [T](index.md) : Any&gt;(val data: [T](index.md), validator: [EntityValidator](../../-entity-validator/index.md)) : [Entity](../index.md)&lt;[T](index.md)&gt; , [EntityValidator](../../-entity-validator/index.md)

Simple entity implementation

#### Parameters

common

| | |
|---|---|
| data | Stored data |
| validator | Entity validator |

## Constructors

| | |
|---|---|
| [Impl](-impl.md) | [common]<br>fun &lt;out [T](index.md) : Any&gt; [Impl](-impl.md)(data: [T](index.md), validator: [EntityValidator](../../-entity-validator/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | [common]<br>open override fun [createSnapshot](create-snapshot.md)(): [Entity](../index.md)&lt;[T](index.md)&gt;<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../../-entity-validator/is-valid.md) value |
| [isValid](../../-entity-validator/is-valid.md) | [common]<br>open override fun [isValid](../../-entity-validator/is-valid.md)(): Boolean<br>If true cached entity is valid. |
| [map](map.md) | [common]<br>open override fun &lt;[R](map.md) : Any&gt; [map](map.md)(mapper: ([T](index.md)) -&gt; [R](map.md)): [Entity](../index.md)&lt;[R](map.md)&gt;<br>Transforms Entity [data](data.md) to another entity data with [mapper](map.md) Validation remains the same |
| [serialize](../../-entity-validator/serialize.md) | [common]<br>open override fun [serialize](../../-entity-validator/serialize.md)(): String<br>A way to serialize entity |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [common]<br>open override val [data](data.md): [T](index.md) |
