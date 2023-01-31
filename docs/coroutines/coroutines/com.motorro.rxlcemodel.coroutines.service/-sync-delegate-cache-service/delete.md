//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines.service](../index.md)/[SyncDelegateCacheService](index.md)/[delete](delete.md)

# delete

[common]\
open suspend override fun [delete](delete.md)(params: [P](index.md))

Deletes cached value. The [getData](get-data.md) observable for the same key will emit empty `null`.

#### Parameters

common

| | |
|---|---|
| params | Caching key |
