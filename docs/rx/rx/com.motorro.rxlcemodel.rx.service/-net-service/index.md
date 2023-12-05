//[rx](../../../index.md)/[com.motorro.rxlcemodel.rx.service](../index.md)/[NetService](index.md)

# NetService

interface [NetService](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

Interface to load an [com.motorro.rxlcemodel.cache.entity.Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md) from network

#### Parameters

jvm

| | |
|---|---|
| D | Data type |
| P | Params that identify data type |

#### Inheritors

| |
|---|
| [UpdatingNetService](../-updating-net-service/index.md) |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [jvm]<br>abstract fun [get](get.md)(params: [P](index.md)): Single&lt;[Entity](../../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md)&lt;[D](index.md)&gt;&gt;<br>Gets entity from network or throws on error |
