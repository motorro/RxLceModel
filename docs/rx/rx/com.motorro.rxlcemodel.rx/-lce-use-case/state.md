//[rx](../../../index.md)/[com.motorro.rxlcemodel.rx](../index.md)/[LceUseCase](index.md)/[state](state.md)

# state

[jvm]\
abstract val [state](state.md): Observable&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;

Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates
