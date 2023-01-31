//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines.service](../index.md)/[CacheService](index.md)/[delete](delete.md)

# delete

[common]\
abstract suspend fun [delete](delete.md)(params: [P](index.md))

Deletes cached value. The [getData](get-data.md) observable for the same key will emit `null`.

#### Parameters

common

| | |
|---|---|
| params | Caching key |
