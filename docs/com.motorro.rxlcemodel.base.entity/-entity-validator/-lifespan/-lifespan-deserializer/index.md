[com.motorro.rxlcemodel.base.entity](../../../index.md) / [EntityValidator](../../index.md) / [Lifespan](../index.md) / [LifespanDeserializer](./index.md)

# LifespanDeserializer

`class LifespanDeserializer : `[`Deserializer`](../../-deserializer/index.md)

Deserializes validator from string

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LifespanDeserializer(clock: `[`Clock`](../../../-clock/index.md)` = Clock.SYSTEM)`<br>Deserializes validator from string |

### Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | `fun deserialize(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`EntityValidator`](../../index.md)`?`<br>Deserializes validator from string if string is recognized |
| [deserializeSnapshot](deserialize-snapshot.md) | `fun deserializeSnapshot(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`EntityValidator`](../../index.md)`?`<br>Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid](../../is-valid.md) with time |
