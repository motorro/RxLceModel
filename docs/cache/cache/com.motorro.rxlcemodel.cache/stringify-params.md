//[cache](../../index.md)/[com.motorro.rxlcemodel.cache](index.md)/[stringifyParams](stringify-params.md)

# stringifyParams

[common]\
inline fun &lt;[D](stringify-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [P](stringify-params.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [CacheDelegate](-cache-delegate/index.md)&lt;[D](stringify-params.md), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;.[stringifyParams](stringify-params.md)(crossinline stringify: [P](stringify-params.md).() -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { toString() }): [CacheDelegate](-cache-delegate/index.md)&lt;[D](stringify-params.md), [P](stringify-params.md)&gt;

Creates an adapter delegate that [stringify](stringify-params.md) and uses result string as params to receiver

#### Receiver

Delegate with String params e.g. the one that saves data to files and uses params as file names

#### Parameters

common

| | |
|---|---|
| stringify | Function to stringify [P](stringify-params.md) |
