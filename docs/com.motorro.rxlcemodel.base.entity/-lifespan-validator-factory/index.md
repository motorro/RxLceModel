[com.motorro.rxlcemodel.base.entity](../index.md) / [LifespanValidatorFactory](./index.md)

# LifespanValidatorFactory

`class LifespanValidatorFactory : `[`EntityValidatorFactory`](../-entity-validator-factory/index.md)

Creates [Lifespan](../-entity-validator/-lifespan/index.md) as a cache-control

### Parameters

`cacheTtl` - Cache TTL

`clock` - System clock

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LifespanValidatorFactory(cacheTtl: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, clock: `[`Clock`](../-clock/index.md)` = Clock.SYSTEM)`<br>Creates [Lifespan](../-entity-validator/-lifespan/index.md) as a cache-control |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`EntityValidator`](../-entity-validator/index.md)<br>Creates entity cache-control |
