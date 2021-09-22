//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[UpdatingNetService](index.md)

# UpdatingNetService

[jvm]\
interface [UpdatingNetService](index.md)&lt;[D](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [U](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), in [P](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [NetService](../-net-service/index.md)&lt;[D](index.md), [P](index.md)&gt; 

[NetService](../-net-service/index.md) extension to update data on server

## Parameters

jvm

| | |
|---|---|
| D | Data type |
| U | Update type |
| P | Params that identify data type |

## Functions

| Name | Summary |
|---|---|
| [get](../-net-service/get.md) | [jvm]<br>abstract fun [get](../-net-service/get.md)(params: [P](index.md)): Single&lt;[Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;&gt;<br>Gets entity from network or throws on error |
| [update](update.md) | [jvm]<br>abstract fun [update](update.md)(params: [P](index.md), update: [U](index.md)): Single&lt;[Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)&lt;[D](index.md)&gt;&gt;<br>Updates data on server returning updated one |
