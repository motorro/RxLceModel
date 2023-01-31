//[lce](../../index.md)/[com.motorro.rxlcemodel.lce](index.md)/[catchToLce](catch-to-lce.md)

# catchToLce

[common]\
inline fun &lt;[DATA_1](catch-to-lce.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](catch-to-lce.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceState](-lce-state/index.md)&lt;[DATA_1](catch-to-lce.md)&gt;.[catchToLce](catch-to-lce.md)(block: [LceState](-lce-state/index.md)&lt;[DATA_1](catch-to-lce.md)&gt;.() -&gt; [LceState](-lce-state/index.md)&lt;[DATA_2](catch-to-lce.md)&gt;): [LceState](-lce-state/index.md)&lt;[DATA_2](catch-to-lce.md)&gt;

Runs transformation [block](catch-to-lce.md) catching any error and wrapping it to [LceState.Error](-lce-state/-error/index.md):

- 
   The output data will be null
- 
   The data will be invalid
