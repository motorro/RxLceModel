//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines.service](../index.md)/[NetService](index.md)

# NetService

[common]\
interface [NetService](index.md)&lt;[D](index.md) : Any, in [P](index.md) : Any&gt;

Interface to load an [com.motorro.rxlcemodel.cache.entity.Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md) from network

#### Parameters

common

| | |
|---|---|
| D | Data type |
| P | Params that identify data type |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [common]<br>abstract suspend fun [get](get.md)(params: [P](index.md)): [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;<br>Gets entity from network or throws on error |

## Inheritors

| Name |
|---|
| [UpdatingNetService](../-updating-net-service/index.md) |
