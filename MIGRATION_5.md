# Migration to version 5.x

# Imports

| Artefact                            | Old package                         | New package                         |
| ----------------------------------- | ----------------------------------- | ----------------------------------- |
| LceState and extensions             | com.motorro.rxlcemodel.base         | com.motorro.rxlcemodel.lce          |
| LceUseCase, LceModel and extensions | com.motorro.rxlcemodel.base         | com.motorro.rxlcemodel.rx           |
| Clock, Logger                       | com.motorro.rxlcemodel.base         | com.motorro.rxlcemodel.utils        |
| Entity, EntityValidatorFactory      | com.motorro.rxlcemodel.base.entity  | com.motorro.rxlcemodel.cache.entity |
| Cache delegates, friends, utils     | com.motorro.rxlcemodel.base.service | com.motorro.rxlcemodel.cache        |