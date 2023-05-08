//[cache](../../index.md)/[com.motorro.rxlcemodel.cache](index.md)/[makeFriendParams](make-friend-params.md)

# makeFriendParams

[common]\
inline fun &lt;[D](make-friend-params.md) : Any, [P](make-friend-params.md) : Any&gt; [CacheDelegate](-cache-delegate/index.md)&lt;[D](make-friend-params.md), [CacheFriend](-cache-friend/index.md)&gt;.[makeFriendParams](make-friend-params.md)(crossinline stringify: [P](make-friend-params.md).() -&gt; String): [CacheDelegate](-cache-delegate/index.md)&lt;[D](make-friend-params.md), [P](make-friend-params.md)&gt;

Creates an adapter delegate that creates [CacheFriend](-cache-friend/index.md) params using [stringify](make-friend-params.md) function

#### Receiver

Delegate with [CacheFriend](-cache-friend/index.md) params e.g. the one that saves data to files and uses params as file names

#### Parameters

common

| | |
|---|---|
| stringify | Function to stringify [P](make-friend-params.md) |
