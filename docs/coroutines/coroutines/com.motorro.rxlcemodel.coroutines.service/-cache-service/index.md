//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines.service](../index.md)/[CacheService](index.md)

# CacheService

interface [CacheService](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

Interface to cache an [com.motorro.rxlcemodel.cache.entity.Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md) locally Cache should notify subscribers that data has been updated through [getData](get-data.md) channel

#### Parameters

common

| | |
|---|---|
| D | Data type |
| P | Params that identify data type |

#### Inheritors

| |
|---|
| [SyncDelegateCacheService](../-sync-delegate-cache-service/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [common]<br>abstract suspend fun [delete](delete.md)(params: [P](index.md))<br>Deletes cached value. The [getData](get-data.md) observable for the same key will emit `null`. |
| [getData](get-data.md) | [common]<br>abstract fun [getData](get-data.md)(params: [P](index.md)): Flow&lt;[Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;?&gt;<br>Subscribes to cache data updates |
| [invalidate](invalidate.md) | [common]<br>abstract suspend fun [invalidate](invalidate.md)(params: [P](index.md))<br>Invalidates cached value |
| [invalidateAll](invalidate-all.md) | [common]<br>abstract suspend fun [invalidateAll](invalidate-all.md)()<br>Invalidates all cached values |
| [refetch](refetch.md) | [common]<br>abstract suspend fun [refetch](refetch.md)(params: [P](index.md))<br>Makes cache service to refetch cached data updating subscribers with [params](refetch.md) |
| [refetchAll](refetch-all.md) | [common]<br>abstract suspend fun [refetchAll](refetch-all.md)()<br>Makes cache service to refetch cached data for all active subscribers |
| [save](save.md) | [common]<br>abstract suspend fun [save](save.md)(params: [P](index.md), entity: [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;)<br>Saves entity in a cache |
