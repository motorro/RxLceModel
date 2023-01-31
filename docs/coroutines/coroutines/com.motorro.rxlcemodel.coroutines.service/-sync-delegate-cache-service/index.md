//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines.service](../index.md)/[SyncDelegateCacheService](index.md)

# SyncDelegateCacheService

[common]\
class [SyncDelegateCacheService](index.md)&lt;[D](index.md) : Any, [P](index.md) : Any&gt; : [CacheService](../-cache-service/index.md)&lt;[D](index.md), [P](index.md)&gt; 

Service implementation

#### Parameters

common

| | |
|---|---|
| delegate | Delegate to perform concrete caching operations |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [common]<br>open suspend override fun [delete](delete.md)(params: [P](index.md))<br>Deletes cached value. The [getData](get-data.md) observable for the same key will emit empty `null`. |
| [getData](get-data.md) | [common]<br>open override fun [getData](get-data.md)(params: [P](index.md)): Flow&lt;[Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;?&gt;<br>Subscribes to cache data updates |
| [invalidate](invalidate.md) | [common]<br>open suspend override fun [invalidate](invalidate.md)(params: [P](index.md))<br>Clears cached value |
| [invalidateAll](invalidate-all.md) | [common]<br>open suspend override fun [invalidateAll](invalidate-all.md)()<br>Invalidates all cached values |
| [refetch](refetch.md) | [common]<br>open suspend override fun [refetch](refetch.md)(params: [P](index.md))<br>Makes cache service to refetch cached data updating subscribers with [params](refetch.md) |
| [refetchAll](refetch-all.md) | [common]<br>open suspend override fun [refetchAll](refetch-all.md)()<br>Makes cache service to refetch cached data for all active subscribers |
| [save](save.md) | [common]<br>open suspend override fun [save](save.md)(params: [P](index.md), entity: [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;)<br>Saves entity in a cache |
