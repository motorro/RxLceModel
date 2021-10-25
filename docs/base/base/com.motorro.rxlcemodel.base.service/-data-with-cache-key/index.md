//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[DataWithCacheKey](index.md)

# DataWithCacheKey

[jvm]\
data class [DataWithCacheKey](index.md)&lt;[D](index.md) : Any&gt;(data: [D](index.md), cacheKey: String) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)

Data combined with full cached key to validate we get exactly what we are looking for For example, DiskLruCache has strict requirements and limited length of a cache key and hashing of keys may be required to fit into requirements - thus there is a possibility of key clash.

## See also

jvm

| | |
|---|---|
| [com.motorro.rxlcemodel.base.service.CacheFriendDelegate](../-cache-friend-delegate/index.md) |  |

## Parameters

jvm

| | |
|---|---|
| data | Original data |
| cacheKey | Full unmodified cache key |

## Constructors

| | |
|---|---|
| [DataWithCacheKey](-data-with-cache-key.md) | [jvm]<br>fun &lt;[D](index.md) : Any&gt; [DataWithCacheKey](-data-with-cache-key.md)(data: [D](index.md), cacheKey: String) |

## Properties

| Name | Summary |
|---|---|
| [cacheKey](cache-key.md) | [jvm]<br>val [cacheKey](cache-key.md): String |
| [data](data.md) | [jvm]<br>val [data](data.md): [D](index.md) |
