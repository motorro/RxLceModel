//[coroutines](../../../index.md)/[com.motorro.rxlcemodel.coroutines.service](../index.md)/[UpdatingNetService](index.md)

# UpdatingNetService

[common]\
interface [UpdatingNetService](index.md)&lt;[D](index.md) : Any, in [U](index.md) : Any, in [P](index.md) : Any&gt; : [NetService](../-net-service/index.md)&lt;[D](index.md), [P](index.md)&gt; 

[NetService](../-net-service/index.md) extension to update data on server

#### Parameters

common

| | |
|---|---|
| D | Data type |
| U | Update type |
| P | Params that identify data type |

## Functions

| Name | Summary |
|---|---|
| [get](../-net-service/get.md) | [common]<br>abstract suspend fun [get](../-net-service/get.md)(params: [P](index.md)): [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;<br>Gets entity from network or throws on error |
| [update](update.md) | [common]<br>abstract suspend fun [update](update.md)(params: [P](index.md), update: [U](index.md)): [Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;<br>Updates data on server returning updated one |
