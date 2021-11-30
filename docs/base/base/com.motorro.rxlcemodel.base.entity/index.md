//[base](../../index.md)/[com.motorro.rxlcemodel.base.entity](index.md)

# Package com.motorro.rxlcemodel.base.entity

## Types

| Name | Summary |
|---|---|
| [Clock](-clock/index.md) | [jvm]<br>interface [Clock](-clock/index.md)<br>Time provider |
| [Entity](-entity/index.md) | [jvm]<br>interface [Entity](-entity/index.md)&lt;out [T](-entity/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [EntityValidator](-entity-validator/index.md)<br>Cache-controlling entity for [com.motorro.rxlcemodel.base.entity.Entity](-entity/index.md) implement this interface for cache control |
| [EntityValidator](-entity-validator/index.md) | [jvm]<br>interface [EntityValidator](-entity-validator/index.md)<br>Entity validator |
| [EntityValidatorFactory](-entity-validator-factory/index.md) | [jvm]<br>interface [EntityValidatorFactory](-entity-validator-factory/index.md)<br>Cache-control [EntityValidator](-entity-validator/index.md) factory for operations |
| [LifespanValidatorFactory](-lifespan-validator-factory/index.md) | [jvm]<br>class [LifespanValidatorFactory](-lifespan-validator-factory/index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(cacheTtl: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), clock: [Clock](-clock/index.md)) : [EntityValidatorFactory](-entity-validator-factory/index.md)<br>Creates [Lifespan](-entity-validator/-lifespan/index.md) as a cache-control |

## Functions

| Name | Summary |
|---|---|
| [toEntity](to-entity.md) | [jvm]<br>fun &lt;[T](to-entity.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [T](to-entity.md).[toEntity](to-entity.md)(validator: [EntityValidator](-entity-validator/index.md)): [Entity.Impl](-entity/-impl/index.md)&lt;[T](to-entity.md)&gt;<br>Converts [T](to-entity.md) to [Entity](-entity/index.md) to use with services |
