//[coroutines](../../../../index.md)/[com.motorro.rxlcemodel.coroutines](../../index.md)/[LceModel](../index.md)/[Companion](index.md)

# Companion

[common]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [cacheThenNet](cache-then-net.md) | [common]<br>@JvmOverloads<br>fun &lt;[DATA](cache-then-net.md) : Any, [PARAMS](cache-then-net.md) : Any&gt; [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), serviceSet: [ServiceSet](../../../com.motorro.rxlcemodel.coroutines.service/-service-set/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, startWith: Flow&lt;[LceState](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](cache-then-net.md)&gt;&gt; = emptyFlow(), ioDispatcher: CoroutineDispatcher = Dispatchers.Unconfined, logger: [Logger](../../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)? = null): [LceModel](../index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;<br>Creates a model that returns cached data first, then refreshes if stall<br>[common]<br>@JvmOverloads<br>fun &lt;[DATA](cache-then-net.md) : Any, [PARAMS](cache-then-net.md) : Any&gt; [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), net: [NetService](../../../com.motorro.rxlcemodel.coroutines.service/-net-service/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, cache: [CacheService](../../../com.motorro.rxlcemodel.coroutines.service/-cache-service/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, startWith: Flow&lt;[LceState](../../../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[DATA](cache-then-net.md)&gt;&gt; = emptyFlow(), ioDispatcher: CoroutineDispatcher = Dispatchers.Unconfined, logger: [Logger](../../../../../common/com.motorro.rxlcemodel.common/-logger/index.md)? = null): [LceModel](../index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;<br>Creates a model that returns cached data first, than refreshes if stall |
