//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines.service](../index.md)/[ServiceSet](index.md)

# ServiceSet

interface [ServiceSet](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

Service-set for [com.motorro.rxlcemodel.coroutines.LceModel](../../com.motorro.rxlcemodel.coroutines/-lce-model/index.md)

#### Parameters

common

| | |
|---|---|
| D | Data type |
| P | Params that identify data type |

#### Inheritors

| |
|---|
| [UpdatingServiceSet](../-updating-service-set/index.md) |

## Properties

| Name | Summary |
|---|---|
| [cache](cache.md) | [common]<br>abstract val [cache](cache.md): [CacheService](../-cache-service/index.md)&lt;[D](index.md), [P](index.md)&gt;<br>Cache service |
| [net](net.md) | [common]<br>abstract val [net](net.md): [NetService](../-net-service/index.md)&lt;[D](index.md), [P](index.md)&gt;<br>Net service |
