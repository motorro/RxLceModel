//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines.service](../index.md)/[UpdatingServiceSet](index.md)

# UpdatingServiceSet

[common]\
interface [UpdatingServiceSet](index.md)&lt;[D](index.md) : Any, in [U](index.md) : Any, in [P](index.md) : Any&gt; : [ServiceSet](../-service-set/index.md)&lt;[D](index.md), [P](index.md)&gt; 

[ServiceSet](../-service-set/index.md) extension with updating [net](net.md)

#### Parameters

common

| | |
|---|---|
| D | Data type |
| U | Update type |
| P | Params that identify data type |

## Properties

| Name | Summary |
|---|---|
| [cache](../-service-set/cache.md) | [common]<br>abstract val [cache](../-service-set/cache.md): [CacheService](../-cache-service/index.md)&lt;[D](index.md), [P](index.md)&gt;<br>Cache service |
| [net](net.md) | [common]<br>abstract override val [net](net.md): [UpdatingNetService](../-updating-net-service/index.md)&lt;[D](index.md), [U](index.md), [P](index.md)&gt;<br>Updating net service |
