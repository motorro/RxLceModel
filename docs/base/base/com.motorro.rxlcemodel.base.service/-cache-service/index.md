//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[CacheService](index.md)

# CacheService

[jvm]\
interface [CacheService](index.md)&lt;[D](index.md) : Any, in [P](index.md) : Any&gt;

Interface to cache an [com.motorro.rxlcemodel.base.entity.Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md) locally Cache should notify subscribers that data has been updated through [getData](get-data.md) channel

## Parameters

jvm

| | |
|---|---|
| D | Data type |
| P | Params that identify data type |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [jvm]<br>abstract fun [delete](delete.md)(params: [P](index.md)): Completable<br>Deletes cached value. The [getData](get-data.md) observable for the same key wil emit com.gojuno.koptional.None |
| [getData](get-data.md) | [jvm]<br>abstract fun [getData](get-data.md)(params: [P](index.md)): Observable&lt;Optional&lt;[Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;&gt;&gt;<br>Subscribes to cache data updates |
| [invalidate](invalidate.md) | [jvm]<br>abstract fun [invalidate](invalidate.md)(params: [P](index.md)): Completable<br>Invalidates cached value |
| [refetch](refetch.md) | [jvm]<br>abstract fun [refetch](refetch.md)(params: [P](index.md)): Completable<br>Makes cache service to refetch cached data updating subscribers with [params](refetch.md) |
| [save](save.md) | [jvm]<br>abstract fun [save](save.md)(params: [P](index.md), entity: [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;): Completable<br>Saves entity in a cache |

## Properties

| Name | Summary |
|---|---|
| [invalidateAll](invalidate-all.md) | [jvm]<br>abstract val [invalidateAll](invalidate-all.md): Completable<br>Invalidates all cached values |
| [refetchAll](refetch-all.md) | [jvm]<br>abstract val [refetchAll](refetch-all.md): Completable<br>Makes cache service to refetch cached data for all active subscribers |

## Inheritors

| Name |
|---|
| [SyncDelegateCacheService](../-sync-delegate-cache-service/index.md) |
