//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[DataWithCacheKey](index.md)

# DataWithCacheKey

[jvm]\
data class [DataWithCacheKey](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(data: [D](index.md), cacheKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)

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
| [DataWithCacheKey](-data-with-cache-key.md) | [jvm]<br>fun &lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [DataWithCacheKey](-data-with-cache-key.md)(data: [D](index.md), cacheKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [cacheKey](cache-key.md) | [jvm]<br>val [cacheKey](cache-key.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [data](data.md) | [jvm]<br>val [data](data.md): [D](index.md) |
