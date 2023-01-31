package com.motorro.rxlcemodel.coroutines

import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.common.Logger
import com.motorro.rxlcemodel.coroutines.service.CacheService
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Wraps [LceModel] and mixes in a data update state
 * Use to build models that patch some properties and load the whole data structure as a result
 * Implement methods to update properties using [doUpdate] template
 * @param DATA Data Type of data being held
 * @param PARAMS Params type that identify data being loaded
 * @param upstream LceModel that performs reading
 * @param cacheService Data cache service that updates the same cache as [upstream] uses
 * @param ioDispatcher Scheduler to run IO operations
 * @param logger Logging function
 */
class StrategyUpdateWrapper<DATA: Any, PARAMS: Any>(
    upstream: LceModel<DATA, PARAMS>,
    cacheService: CacheService<DATA, PARAMS>,
    ioDispatcher: CoroutineDispatcher,
    logger: Logger?
): UpdateWrapper<DATA, PARAMS>(upstream, cacheService, ioDispatcher, logger) {
    /**
     * Creates a cache-update operation that gets data from [dataSource] and saves to cache.
     * The completable updates [networkOperationState] to mix state to original [upstream]
     * @param dataSource Update operation data source factory
     */
    suspend fun update(dataSource: suspend (params: PARAMS) -> Entity<DATA>) = doUpdate(dataSource)
}