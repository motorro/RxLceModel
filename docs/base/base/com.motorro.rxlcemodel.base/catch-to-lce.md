//[base](../index.md)/[com.motorro.rxlcemodel.base](index.md)/[catchToLce](catch-to-lce.md)



# catchToLce  
[jvm]  
Brief description  




Runs transformation block catching any error and wrapping it to [LceState.Error](-lce-state/-error/index.md):

<ul><li>The output data will be null</li><li>The data will be invalid</li></ul>

  
Content  
inline fun <[DATA_1](catch-to-lce.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](catch-to-lce.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [LceState](-lce-state/index.md)<[DATA_1](catch-to-lce.md)>.[catchToLce](catch-to-lce.md)(block: [LceState](-lce-state/index.md)<[DATA_1](catch-to-lce.md)>.() -> [LceState](-lce-state/index.md)<[DATA_2](catch-to-lce.md)>): [LceState](-lce-state/index.md)<[DATA_2](catch-to-lce.md)>  



