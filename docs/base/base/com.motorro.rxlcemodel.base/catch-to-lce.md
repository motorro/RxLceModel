//[base](../../index.md)/[com.motorro.rxlcemodel.base](index.md)/[catchToLce](catch-to-lce.md)

# catchToLce

[jvm]\
inline fun &lt;[DATA_1](catch-to-lce.md) : Any, [DATA_2](catch-to-lce.md) : Any&gt; [LceState](-lce-state/index.md)&lt;[DATA_1](catch-to-lce.md)&gt;.[catchToLce](catch-to-lce.md)(block: [LceState](-lce-state/index.md)&lt;[DATA_1](catch-to-lce.md)&gt;.() -&gt; [LceState](-lce-state/index.md)&lt;[DATA_2](catch-to-lce.md)&gt;): [LceState](-lce-state/index.md)&lt;[DATA_2](catch-to-lce.md)&gt;

Runs transformation [block](catch-to-lce.md) catching any error and wrapping it to [LceState.Error](-lce-state/-error/index.md):

<ul><li>The output data will be null</li><li>The data will be invalid</li></ul>
