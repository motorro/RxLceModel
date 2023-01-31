//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines](../index.md)/[UpdateWrapper](index.md)/[state](state.md)

# state

[common]\
open override val [state](state.md): Flow&lt;[LceState](../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;

Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates Wrapper mixes the [upstream](../../../../coroutines/com.motorro.rxlcemodel.coroutines/-update-wrapper/upstream.md) emissions with update operation status.
