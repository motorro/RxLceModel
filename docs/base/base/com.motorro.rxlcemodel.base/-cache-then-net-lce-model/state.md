//[base](../../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[CacheThenNetLceModel](index.md)/[state](state.md)

# state

[jvm]\
open override val [state](state.md): Observable&lt;[LceState](../-lce-state/index.md)&lt;[DATA](index.md)&gt;&gt;

Model state. Subscription starts data load for the first subscriber. Whenever last subscriber cancels, the model unsubscribes internal components for data updates
