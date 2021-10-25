//[base](../../index.md)/[com.motorro.rxlcemodel.base.service](index.md)/[stringifyParams](stringify-params.md)

# stringifyParams

[jvm]\
inline fun &lt;[D](stringify-params.md) : Any, [P](stringify-params.md) : Any&gt; [SyncDelegateCacheService.Delegate](-sync-delegate-cache-service/-delegate/index.md)&lt;[D](stringify-params.md), String&gt;.[stringifyParams](stringify-params.md)(crossinline stringify: [P](stringify-params.md).() -&gt; String = { toString() }): [SyncDelegateCacheService.Delegate](-sync-delegate-cache-service/-delegate/index.md)&lt;[D](stringify-params.md), [P](stringify-params.md)&gt;

Creates an adapter delegate that [stringify](stringify-params.md) and uses result string as params to receiver

#### Receiver

Delegate with String params e.g. the one that saves data to files and uses params as file names

## Parameters

jvm

| | |
|---|---|
| stringify | Function to stringify [P](stringify-params.md) |
