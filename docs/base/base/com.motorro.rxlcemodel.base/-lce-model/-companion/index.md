//[base](../../../../index.md)/[com.motorro.rxlcemodel.base](../../index.md)/[LceModel](../index.md)/[Companion](index.md)

# Companion

[jvm]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [cacheThenNet](cache-then-net.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun &lt;[DATA](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), serviceSet: [ServiceSet](../../../com.motorro.rxlcemodel.base.service/-service-set/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, startWith: Observable&lt;[LceState](../../-lce-state/index.md)&lt;[DATA](cache-then-net.md)&gt;&gt; = Observable.empty(), ioScheduler: Scheduler = Schedulers.trampoline(), logger: [Logger](../../-logger/index.md)? = null): [LceModel](../index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;<br>Creates a model that returns cached data first, then refreshes if stall<br>[jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun &lt;[DATA](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [PARAMS](cache-then-net.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [cacheThenNet](cache-then-net.md)(params: [PARAMS](cache-then-net.md), net: [NetService](../../../com.motorro.rxlcemodel.base.service/-net-service/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, cache: [CacheService](../../../com.motorro.rxlcemodel.base.service/-cache-service/index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;, startWith: Observable&lt;[LceState](../../-lce-state/index.md)&lt;[DATA](cache-then-net.md)&gt;&gt; = Observable.empty(), ioScheduler: Scheduler = Schedulers.trampoline(), logger: [Logger](../../-logger/index.md)? = null): [LceModel](../index.md)&lt;[DATA](cache-then-net.md), [PARAMS](cache-then-net.md)&gt;<br>Creates a model that returns cached data first, than refreshes if stall |
