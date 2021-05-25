package com.motorro.rxlcemodel.base

import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.service.CacheService
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single

/**
 * Wraps [LceModel] and mixes in a data update state
 * Use to build models that patch some properties and load the whole data structure as a result
 * Implement methods to update properties using [doUpdate] template
 * @param DATA Data Type of data being held
 * @param PARAMS Params type that identify data being loaded
 * @param upstream LceModel that performs reading
 * @param cacheService Data cache service that updates the same cache as [upstream] uses
 * @param logger Logging function
 * @param ioScheduler Scheduler to run IO operations
 */
class StrategyUpdateWrapper<DATA: Any, PARAMS: Any>(
    upstream: LceModel<DATA, PARAMS>,
    cacheService: CacheService<DATA, PARAMS>,
    logger: Logger?,
    ioScheduler: Scheduler
): UpdateWrapper<DATA, PARAMS>(upstream, cacheService, logger, ioScheduler) {
    /**
     * Creates a cache-update operation that gets data from [dataSource] and saves to cache.
     * The completable updates [networkOperationState] to mix state to original [upstream]
     * @param dataSource Update operation data source factory
     */
    fun update(dataSource: (params: PARAMS) -> Single<out Entity<DATA>>): Completable = doUpdate(dataSource)
}