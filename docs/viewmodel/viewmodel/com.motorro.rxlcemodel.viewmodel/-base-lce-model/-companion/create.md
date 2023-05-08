//[viewmodel](../../../../index.md)/[com.motorro.rxlcemodel.viewmodel](../../index.md)/[BaseLceModel](../index.md)/[Companion](index.md)/[create](create.md)

# create

[androidJvm]\
fun &lt;[DATA](create.md) : Any&gt; [create](create.md)(stateObservable: Observable&lt;[LceState](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](create.md)&gt;&gt;, refresh: Completable): [BaseLceModel](../index.md)&lt;[DATA](create.md)&gt;

Creates LCE model

#### Parameters

androidJvm

| | |
|---|---|
| stateObservable | Observable of state changes |
| refresh | Refresh operation |

[androidJvm]\
fun &lt;[DATA](create.md) : Any&gt; [create](create.md)(useCase: [LceUseCase](../../../../../rx/rx/com.motorro.rxlcemodel.rx/-lce-use-case/index.md)&lt;[DATA](create.md)&gt;): [BaseLceModel](../index.md)&lt;[DATA](create.md)&gt;

Creates LCE model

#### Parameters

androidJvm

| | |
|---|---|
| useCase | Data use-case |
