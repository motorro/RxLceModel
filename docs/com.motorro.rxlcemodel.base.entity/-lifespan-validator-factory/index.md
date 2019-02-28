[com.motorro.rxlcemodel.base.entity](../index.md) / [LifespanValidatorFactory](./index.md)

# LifespanValidatorFactory

`class LifespanValidatorFactory : `[`EntityValidatorFactory`](../-entity-validator-factory/index.md)

Creates [Lifespan](../-entity-validator/-lifespan/index.md) as a cache-control

### Parameters

`clock` - System clock

`cacheTtl` - Cache TTL

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LifespanValidatorFactory(clock: `[`Clock`](../-clock/index.md)`, cacheTtl: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)`<br>Creates [Lifespan](../-entity-validator/-lifespan/index.md) as a cache-control |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(serialized: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`EntityValidator`](../-entity-validator/index.md)<br>Creates entity cache-control |
