//[viewmodel](../../../../index.md)/[com.motorro.rxlcemodel.viewmodel](../../index.md)/[BaseLceModel](../index.md)/[Companion](index.md)

# Companion

[androidJvm]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [create](create.md) | [androidJvm]<br>fun &lt;[DATA](create.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [create](create.md)(useCase: [LceUseCase](../../../../../rx/rx/com.motorro.rxlcemodel.rx/-lce-use-case/index.md)&lt;[DATA](create.md)&gt;): [BaseLceModel](../index.md)&lt;[DATA](create.md)&gt;<br>fun &lt;[DATA](create.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [create](create.md)(stateObservable: Observable&lt;[LceState](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](create.md)&gt;&gt;, refresh: Completable): [BaseLceModel](../index.md)&lt;[DATA](create.md)&gt;<br>Creates LCE model |
