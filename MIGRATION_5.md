# Migration to version 5.x

Version 5.x implements a coroutine port of the library.
To be able to migrate, common objects were repackaged and made available for both systems
To migrate to 5.x you should change imports according to the table below

# Imports

| Artefact                            | Old package                         | New package                         |
| ----------------------------------- | ----------------------------------- | ----------------------------------- |
| LceState and extensions             | com.motorro.rxlcemodel.base         | com.motorro.rxlcemodel.lce          |
| LceUseCase, LceModel and extensions | com.motorro.rxlcemodel.base         | com.motorro.rxlcemodel.rx           |
| Clock, Logger                       | com.motorro.rxlcemodel.base         | com.motorro.rxlcemodel.utils        |
| Entity, EntityValidatorFactory      | com.motorro.rxlcemodel.base.entity  | com.motorro.rxlcemodel.cache.entity |
| Cache delegates, friends, utils     | com.motorro.rxlcemodel.base.service | com.motorro.rxlcemodel.cache        |

# Services and service-sets

`Rx` and `coroutines` use different services and service-sets. To switch from `Rx` to `coroutines`
the services should use the same name import but from different modules.
The service interface signatures has also changed from `Rx` to suspended functions usage.
So if you like to switch consider net-service to rewrite.