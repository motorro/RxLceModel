[com.motorro.rxlcemodel.base](index.md) / [withUpdates](./with-updates.md)

# withUpdates

`fun <DATA : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, UPDATE : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, PARAMS : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LceModel`](-lce-model/index.md)`<`[`DATA`](with-updates.md#DATA)`, `[`PARAMS`](with-updates.md#PARAMS)`>.withUpdates(serviceSet: `[`UpdatingServiceSet`](../com.motorro.rxlcemodel.base.service/-updating-service-set/index.md)`<`[`DATA`](with-updates.md#DATA)`, `[`UPDATE`](with-updates.md#UPDATE)`, `[`PARAMS`](with-updates.md#PARAMS)`>): `[`UpdatingLceModel`](-updating-lce-model/index.md)`<`[`DATA`](with-updates.md#DATA)`, `[`UPDATE`](with-updates.md#UPDATE)`, `[`PARAMS`](with-updates.md#PARAMS)`>`

Wraps an [LceModel](-lce-model/index.md) to updating delegate creating an [UpdatingLceModel](-updating-lce-model/index.md)

### Parameters

`DATA` - Data type of data being held

`UPDATE` - Update type

`PARAMS` - Params type that identify data being loaded

`serviceSet` - Service-set to load data

**Receiver**
LceModel that performs reading

