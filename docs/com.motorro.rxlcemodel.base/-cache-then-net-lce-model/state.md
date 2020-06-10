[com.motorro.rxlcemodel.base](../index.md) / [CacheThenNetLceModel](index.md) / [state](./state.md)

# state

`val state: `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](index.md#DATA)`>>`

Overrides [LceUseCase.state](../-lce-use-case/state.md)

Model data. Subscription starts data load for the first subscriber.
Whenever last subscriber cancels, the model unsubscribes internal components for data updates

**Getter**

Model data. Subscription starts data load for the first subscriber.
Whenever last subscriber cancels, the model unsubscribes internal components for data updates

