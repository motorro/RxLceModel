[com.motorro.rxlcemodel.base](../index.md) / [LceModel](index.md) / [state](./state.md)

# state

`abstract val state: `[`Observable`](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](index.md#DATA)`, `[`PARAMS`](index.md#PARAMS)`>>`

Model state. Subscription starts data load for the first subscriber.
Whenever last subscriber cancels, the model unsubscribes internal components for data updates

