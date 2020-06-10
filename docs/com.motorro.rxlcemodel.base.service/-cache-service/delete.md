[com.motorro.rxlcemodel.base.service](../index.md) / [CacheService](index.md) / [delete](./delete.md)

# delete

`abstract fun delete(params: `[`P`](index.md#P)`): `[`Completable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html)

Deletes cached value.
The [getData](get-data.md) observable for the same key wil emit [com.gojuno.koptional.None](#)

### Parameters

`params` - Caching key