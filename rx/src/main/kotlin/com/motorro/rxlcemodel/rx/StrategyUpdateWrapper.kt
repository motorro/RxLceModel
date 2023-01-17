package com.motorro.rxlcemodel.rx

import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.common.Logger
import com.motorro.rxlcemodel.rx.service.CacheService
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single

/**
 * Wraps [LceModel] and mixes in a data update state
 * Use to build models that patch some properties and load the whole data structure as a result
 * Implement methods to update properties using [doUpdate] template
 * @param DATA Data Type of data being held
 * @param PARAMS Params type that identify data being loaded
 * @param upstream LceModel that performs reading
 * @param cacheService Data cache service that updates the same cache as [upstream] uses
 * @param ioScheduler Scheduler to run IO operations
 * @param logger Logging function
 */
class StrategyUpdateWrapper<DATA: Any, PARAMS: Any>(
    upstream: LceModel<DATA, PARAMS>,
    cacheService: CacheService<DATA, PARAMS>,
    ioScheduler: Scheduler,
    logger: Logger?
): UpdateWrapper<DATA, PARAMS>(upstream, cacheService, ioScheduler, logger) {
    /**
     * Creates a cache-update operation that gets data from [dataSource] and saves to cache.
     * The completable updates [networkOperationState] to mix state to original [upstream]
     * @param dataSource Update operation data source factory
     */
    fun update(dataSource: (params: PARAMS) -> Single<out Entity<DATA>>): Completable = doUpdate(dataSource)
}