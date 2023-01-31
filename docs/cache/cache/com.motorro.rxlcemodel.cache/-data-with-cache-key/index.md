//[cache](../../../index.md)/[com.motorro.rxlcemodel.cache](../index.md)/[DataWithCacheKey](index.md)

# DataWithCacheKey

[common]\
data class [DataWithCacheKey](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;(val data: [D](index.md), val cacheKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Data combined with full cached key to validate we get exactly what we are looking for For example, DiskLruCache has strict requirements and limited length of a cache key and hashing of keys may be required to fit into requirements - thus there is a possibility of key clash.

#### See also

common

| |
|---|
| [CacheFriendDelegate](../-cache-friend-delegate/index.md) |

#### Parameters

common

| | |
|---|---|
| data | Original data |
| cacheKey | Full unmodified cache key |

## Constructors

| | |
|---|---|
| [DataWithCacheKey](-data-with-cache-key.md) | [common]<br>fun &lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [DataWithCacheKey](-data-with-cache-key.md)(data: [D](index.md), cacheKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [cacheKey](cache-key.md) | [common]<br>val [cacheKey](cache-key.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [data](data.md) | [common]<br>val [data](data.md): [D](index.md) |
