//[rx](../../../index.md)/[com.motorro.rxlcemodel.rx.service](../index.md)/[CacheService](index.md)/[delete](delete.md)

# delete

[jvm]\
abstract fun [delete](delete.md)(params: [P](index.md)): Completable

Deletes cached value. The [getData](get-data.md) observable for the same key will emit empty [java.util.Optional](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html).

#### Parameters

jvm

| | |
|---|---|
| params | Caching key |
