[com.motorro.rxlcemodel.base.service](index.md) / [makeFriendParams](./make-friend-params.md)

# makeFriendParams

`inline fun <D : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, P : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Delegate`](-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](make-friend-params.md#D)`, `[`CacheFriend`](-cache-friend/index.md)`>.makeFriendParams(crossinline stringify: `[`P`](make-friend-params.md#P)`.() -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Delegate`](-sync-delegate-cache-service/-delegate/index.md)`<`[`D`](make-friend-params.md#D)`, `[`P`](make-friend-params.md#P)`>`

Creates an adapter delegate that creates [CacheFriend](-cache-friend/index.md) params using [stringify](make-friend-params.md#com.motorro.rxlcemodel.base.service$makeFriendParams(com.motorro.rxlcemodel.base.service.SyncDelegateCacheService.Delegate((com.motorro.rxlcemodel.base.service.makeFriendParams.D, com.motorro.rxlcemodel.base.service.CacheFriend)), kotlin.Function1((com.motorro.rxlcemodel.base.service.makeFriendParams.P, kotlin.String)))/stringify) function

### Parameters

`stringify` - Function to stringify [P](make-friend-params.md#P)

**Receiver**
Delegate with [CacheFriend](-cache-friend/index.md) params e.g. the one that saves data to files and uses params as file names

