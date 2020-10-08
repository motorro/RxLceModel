//[kserializer](../../index.md)/[com.motorro.rxlcemodel.kserializer](../index.md)/[DataWithCacheKeySerializer](index.md)



# DataWithCacheKeySerializer  
 [jvm] 

Serializer for DataWithCacheKey

data class [DataWithCacheKeySerializer](index.md)<[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>(**dataSerializer**: KSerializer<[D](index.md)>) : KSerializer<DataWithCacheKey<[D](index.md)>>    


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [DataWithCacheKeySerializer](-data-with-cache-key-serializer.md)|  [jvm] fun <[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [DataWithCacheKeySerializer](-data-with-cache-key-serializer.md)(dataSerializer: KSerializer<[D](index.md)>)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [component1](component1.md)| [jvm]  <br>Content  <br>operator fun [component1](component1.md)(): KSerializer<[D](index.md)>  <br><br><br>
| [copy](copy.md)| [jvm]  <br>Content  <br>fun [copy](copy.md)(dataSerializer: KSerializer<[D](index.md)>): [DataWithCacheKeySerializer](index.md)<[D](index.md)>  <br><br><br>
| [deserialize](deserialize.md)| [jvm]  <br>Content  <br>open override fun [deserialize](deserialize.md)(decoder: Decoder): DataWithCacheKey<[D](index.md)>  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [jvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [jvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| patch| [jvm]  <br>Content  <br>~~open~~ ~~override~~ ~~fun~~ ~~patch~~~~(~~~~decoder~~~~:~~ Decoder~~,~~ ~~old~~~~:~~ DataWithCacheKey<[D](index.md)>~~)~~~~:~~ DataWithCacheKey<[D](index.md)>  <br><br><br>
| [serialize](serialize.md)| [jvm]  <br>Content  <br>open override fun [serialize](serialize.md)(encoder: Encoder, value: DataWithCacheKey<[D](index.md)>)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [jvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [dataSerializer](index.md#com.motorro.rxlcemodel.kserializer/DataWithCacheKeySerializer/dataSerializer/#/PointingToDeclaration/)|  [jvm] val [dataSerializer](index.md#com.motorro.rxlcemodel.kserializer/DataWithCacheKeySerializer/dataSerializer/#/PointingToDeclaration/): KSerializer<[D](index.md)>   <br>
| [descriptor](index.md#com.motorro.rxlcemodel.kserializer/DataWithCacheKeySerializer/descriptor/#/PointingToDeclaration/)|  [jvm] open override val [descriptor](index.md#com.motorro.rxlcemodel.kserializer/DataWithCacheKeySerializer/descriptor/#/PointingToDeclaration/): SerialDescriptor   <br>

