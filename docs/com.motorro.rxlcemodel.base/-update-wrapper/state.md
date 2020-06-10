[com.motorro.rxlcemodel.base](../index.md) / [UpdateWrapper](index.md) / [state](./state.md)

# state

`open val state: `[`Observable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html)`<`[`LceState`](../-lce-state/index.md)`<`[`DATA`](index.md#DATA)`>>`

Overrides [LceUseCase.state](../-lce-use-case/state.md)

Model state. Subscription starts data load for the first subscriber.
Whenever last subscriber cancels, the model unsubscribes internal components for data updates
Wrapper mixes the [upstream](#) emissions with update operation status.

**Getter**

Model state. Subscription starts data load for the first subscriber.
Whenever last subscriber cancels, the model unsubscribes internal components for data updates
Wrapper mixes the [upstream](#) emissions with update operation status.

