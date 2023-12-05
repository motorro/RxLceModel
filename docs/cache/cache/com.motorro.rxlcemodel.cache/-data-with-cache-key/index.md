//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache](../index.md)/[DataWithCacheKey](index.md)

# DataWithCacheKey

data class [DataWithCacheKey](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(val data: [D](index.md), val cacheKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Data combined with full cached key to validate we get exactly what we are looking for For example, DiskLruCache has strict requirements and limited length of a cache key and hashing of keys may be required to fit into requirements - thus there is a possibility of key clash.

#### Parameters

common

| | |
|---|---|
| data | Original data |
| cacheKey | Full unmodified cache key |

#### See also

| |
|---|
| [CacheFriendDelegate](../-cache-friend-delegate/index.md) |

## Constructors

| | |
|---|---|
| [DataWithCacheKey](-data-with-cache-key.md) | [common]<br>constructor(data: [D](index.md), cacheKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [cacheKey](cache-key.md) | [common]<br>val [cacheKey](cache-key.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [data](data.md) | [common]<br>val [data](data.md): [D](index.md) |
