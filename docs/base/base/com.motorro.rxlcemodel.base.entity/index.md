//[base](../index.md)/[com.motorro.rxlcemodel.base.entity](index.md)



# Package com.motorro.rxlcemodel.base.entity  
 [jvm] 

Contains tools to maintain data validity

   


## Types  
  
|  Name|  Summary| 
|---|---|
| [Clock](-clock/index.md)| [jvm]  <br>Brief description  <br><br><br>Time provider<br><br>  <br>Content  <br>interface [Clock](-clock/index.md)  <br><br><br>
| [Entity](-entity/index.md)| [jvm]  <br>Brief description  <br><br><br>Cache-controlling entity for [com.motorro.rxlcemodel.base.entity.Entity](-entity/index.md) implement this interface for cache control<br><br>  <br>Content  <br>interface [Entity](-entity/index.md)<[T](-entity/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> : [EntityValidator](-entity-validator/index.md)  <br><br><br>
| [EntityValidator](-entity-validator/index.md)| [jvm]  <br>Brief description  <br><br><br>Entity validator<br><br>  <br>Content  <br>interface [EntityValidator](-entity-validator/index.md)  <br><br><br>
| [EntityValidatorFactory](-entity-validator-factory/index.md)| [jvm]  <br>Brief description  <br><br><br>Cache-control [EntityValidator](-entity-validator/index.md) factory for operations<br><br>  <br>Content  <br>interface [EntityValidatorFactory](-entity-validator-factory/index.md)  <br><br><br>
| [LifespanValidatorFactory](-lifespan-validator-factory/index.md)| [jvm]  <br>Brief description  <br><br><br>Creates [Lifespan](-entity-validator/-lifespan/index.md) as a cache-control<br><br>  <br>Content  <br>class [LifespanValidatorFactory](-lifespan-validator-factory/index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()constructor(**cacheTtl**: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), **clock**: [Clock](-clock/index.md)) : [EntityValidatorFactory](-entity-validator-factory/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [toEntity](to-entity.md)| [jvm]  <br>Brief description  <br><br><br>Converts [T](to-entity.md) to [Entity](-entity/index.md) to use with services<br><br>  <br>Content  <br>fun <[T](to-entity.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [T](to-entity.md).[toEntity](to-entity.md)(validator: [EntityValidator](-entity-validator/index.md)): [Entity.Impl](-entity/-impl/index.md)<[T](to-entity.md)>  <br><br><br>

