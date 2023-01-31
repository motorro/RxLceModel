//[coroutines](../../index.md)/[com.motorro.rxlcemodel.coroutines.service](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [CacheService](-cache-service/index.md) | [common]<br>interface [CacheService](-cache-service/index.md)&lt;[D](-cache-service/index.md) : Any, in [P](-cache-service/index.md) : Any&gt;<br>Interface to cache an [com.motorro.rxlcemodel.cache.entity.Entity](../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md) locally Cache should notify subscribers that data has been updated through [getData](-cache-service/get-data.md) channel |
| [NetService](-net-service/index.md) | [common]<br>interface [NetService](-net-service/index.md)&lt;[D](-net-service/index.md) : Any, in [P](-net-service/index.md) : Any&gt;<br>Interface to load an [com.motorro.rxlcemodel.cache.entity.Entity](../../../cache/cache/com.motorro.rxlcemodel.cache.entity/-entity/index.md) from network |
| [ServiceSet](-service-set/index.md) | [common]<br>interface [ServiceSet](-service-set/index.md)&lt;[D](-service-set/index.md) : Any, in [P](-service-set/index.md) : Any&gt;<br>Service-set for [com.motorro.rxlcemodel.coroutines.LceModel](../com.motorro.rxlcemodel.coroutines/-lce-model/index.md) |
| [SyncDelegateCacheService](-sync-delegate-cache-service/index.md) | [common]<br>class [SyncDelegateCacheService](-sync-delegate-cache-service/index.md)&lt;[D](-sync-delegate-cache-service/index.md) : Any, [P](-sync-delegate-cache-service/index.md) : Any&gt; : [CacheService](-cache-service/index.md)&lt;[D](-sync-delegate-cache-service/index.md), [P](-sync-delegate-cache-service/index.md)&gt; <br>Service implementation |
| [UpdatingNetService](-updating-net-service/index.md) | [common]<br>interface [UpdatingNetService](-updating-net-service/index.md)&lt;[D](-updating-net-service/index.md) : Any, in [U](-updating-net-service/index.md) : Any, in [P](-updating-net-service/index.md) : Any&gt; : [NetService](-net-service/index.md)&lt;[D](-updating-net-service/index.md), [P](-updating-net-service/index.md)&gt; <br>[NetService](-net-service/index.md) extension to update data on server |
| [UpdatingServiceSet](-updating-service-set/index.md) | [common]<br>interface [UpdatingServiceSet](-updating-service-set/index.md)&lt;[D](-updating-service-set/index.md) : Any, in [U](-updating-service-set/index.md) : Any, in [P](-updating-service-set/index.md) : Any&gt; : [ServiceSet](-service-set/index.md)&lt;[D](-updating-service-set/index.md), [P](-updating-service-set/index.md)&gt; <br>[ServiceSet](-service-set/index.md) extension with updating [net](-updating-service-set/net.md) |
