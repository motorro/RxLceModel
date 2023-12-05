//[rx](../../../index.md)/[com.motorro.rxlcemodel.rx.service](../index.md)/[SyncDelegateCacheService](index.md)

# SyncDelegateCacheService

class [SyncDelegateCacheService](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [CacheService](../-cache-service/index.md)&lt;[D](index.md), [P](index.md)&gt; 

Service implementation

#### Parameters

jvm

| | |
|---|---|
| delegate | Delegate to perform concrete caching operations |

## Properties

| Name | Summary |
|---|---|
| [invalidateAll](invalidate-all.md) | [jvm]<br>open override val [invalidateAll](invalidate-all.md): Completable<br>Invalidates all cached values |
| [refetchAll](refetch-all.md) | [jvm]<br>open override val [refetchAll](refetch-all.md): Completable<br>Makes cache service to refetch cached data for all active subscribers |

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [jvm]<br>open override fun [delete](delete.md)(params: [P](index.md)): Completable<br>Deletes cached value. The [getData](get-data.md) observable for the same key will emit empty [java.util.Optional](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html). |
| [getData](get-data.md) | [jvm]<br>open override fun [getData](get-data.md)(params: [P](index.md)): Observable&lt;[Optional](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)&lt;[Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;&gt;&gt;<br>Subscribes to cache data updates |
| [invalidate](invalidate.md) | [jvm]<br>open override fun [invalidate](invalidate.md)(params: [P](index.md)): Completable<br>Clears cached value |
| [refetch](refetch.md) | [jvm]<br>open override fun [refetch](refetch.md)(params: [P](index.md)): Completable<br>Makes cache service to refetch cached data updating subscribers with [params](refetch.md) |
| [save](save.md) | [jvm]<br>open override fun [save](save.md)(params: [P](index.md), entity: [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;): Completable<br>Saves entity in a cache |
