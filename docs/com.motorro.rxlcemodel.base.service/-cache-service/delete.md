[com.motorro.rxlcemodel.base.service](../index.md) / [CacheService](index.md) / [delete](./delete.md)

# delete

`abstract fun delete(params: `[`P`](index.md#P)`): `[`Completable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html)

Deletes cached value.
The [getData](get-data.md) observable for the same key will emit empty [java.util.Optional](http://docs.oracle.com/javase/6/docs/api/java/util/Optional.html).

### Parameters

`params` - Caching key