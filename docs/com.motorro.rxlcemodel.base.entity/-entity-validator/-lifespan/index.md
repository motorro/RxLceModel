[com.motorro.rxlcemodel.base.entity](../../index.md) / [EntityValidator](../index.md) / [Lifespan](./index.md)

# Lifespan

`class Lifespan : `[`EntityValidator`](../index.md)

Uses creation time and TTL to validate

### Parameters

`wasBorn` - Time entity was born

`ttl` - Time to live

`validation` - Validation delegate to create a dynamic or snapshot validator

### Types

| Name | Summary |
|---|---|
| [LifespanDeserializer](-lifespan-deserializer/index.md) | `class LifespanDeserializer : `[`Deserializer`](../-deserializer/index.md)<br>Deserializes validator from string |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Lifespan(ttl: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, clock: `[`Clock`](../../-clock/index.md)` = Clock.SYSTEM)` |

### Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | `fun createSnapshot(): `[`EntityValidator`](../index.md)<br>Crates a snapshot of validator preserving it's current [EntityValidator.isValid](../is-valid.md) value |
| [equals](equals.md) | `fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>As soon as we should provide [EntityValidator](../index.md) interface we compare only the main property - validity - not the internal state |
| [hashCode](hash-code.md) | `fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>As soon as we should provide [EntityValidator](../index.md) interface we calculate the main property - validity - not the internal state |
| [isValid](is-valid.md) | `fun isValid(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true cached entity is valid. |
| [serialize](serialize.md) | `fun serialize(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A way to serialize entity |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Display string |

### Companion Object Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | `fun createSnapshot(ttl: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, clock: `[`Clock`](../../-clock/index.md)` = Clock.SYSTEM): `[`Lifespan`](./index.md)<br>Creates a snapshot that may be serialized and deserialized back to dynamic [Lifespan](./index.md) |
