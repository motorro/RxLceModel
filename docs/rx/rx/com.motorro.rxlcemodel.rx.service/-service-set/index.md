//[rx](../../../index.md)/[com.motorro.rxlcemodel.rx.service](../index.md)/[ServiceSet](index.md)

# ServiceSet

[jvm]\
interface [ServiceSet](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

Service-set for [com.motorro.rxlcemodel.rx.LceModel](../../com.motorro.rxlcemodel.rx/-lce-model/index.md)

#### Parameters

jvm

| | |
|---|---|
| D | Data type |
| P | Params that identify data type |

## Properties

| Name | Summary |
|---|---|
| [cache](cache.md) | [jvm]<br>abstract val [cache](cache.md): [CacheService](../-cache-service/index.md)&lt;[D](index.md), [P](index.md)&gt;<br>Cache service |
| [net](net.md) | [jvm]<br>abstract val [net](net.md): [NetService](../-net-service/index.md)&lt;[D](index.md), [P](index.md)&gt;<br>Net service |

## Inheritors

| Name |
|---|
| [UpdatingServiceSet](../-updating-service-set/index.md) |
