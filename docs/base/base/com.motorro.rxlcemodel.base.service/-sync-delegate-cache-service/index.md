//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[SyncDelegateCacheService](index.md)

# SyncDelegateCacheService

[jvm]\
class [SyncDelegateCacheService](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [CacheService](../-cache-service/index.md)&lt;[D](index.md), [P](index.md)&gt; 

Service implementation

## Parameters

jvm

| | |
|---|---|
| delegate | Delegate to perform concrete caching operations |

## Types

| Name | Summary |
|---|---|
| [Delegate](-delegate/index.md) | [jvm]<br>interface [Delegate](-delegate/index.md)&lt;[D](-delegate/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](-delegate/index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;<br>Delegate that synchronously performs caching operations |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [jvm]<br>open override fun [delete](delete.md)(params: [P](index.md)): Completable<br>Deletes cached value. The [getData](get-data.md) observable for the same key wil emit com.gojuno.koptional.None |
| [getData](get-data.md) | [jvm]<br>open override fun [getData](get-data.md)(params: [P](index.md)): Observable&lt;Optional&lt;[Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;&gt;&gt;<br>Subscribes to cache data updates |
| [invalidate](invalidate.md) | [jvm]<br>open override fun [invalidate](invalidate.md)(params: [P](index.md)): Completable<br>Clears cached value |
| [refetch](refetch.md) | [jvm]<br>open override fun [refetch](refetch.md)(params: [P](index.md)): Completable<br>Makes cache service to refetch cached data updating subscribers with [params](refetch.md) |
| [save](save.md) | [jvm]<br>open override fun [save](save.md)(params: [P](index.md), entity: [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;): Completable<br>Saves entity in a cache |

## Properties

| Name | Summary |
|---|---|
| [invalidateAll](invalidate-all.md) | [jvm]<br>open override val [invalidateAll](invalidate-all.md): Completable<br>Invalidates all cached values |
| [refetchAll](refetch-all.md) | [jvm]<br>open override val [refetchAll](refetch-all.md): Completable<br>Makes cache service to refetch cached data for all active subscribers |
