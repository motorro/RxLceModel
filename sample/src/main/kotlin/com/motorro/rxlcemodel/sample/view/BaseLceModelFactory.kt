/*
 * Copyright 2019 Nikolai Kotchetkov.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.motorro.rxlcemodel.sample.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.motorro.rxlcemodel.base.LceModel
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.base.service.NetService
import com.motorro.rxlcemodel.base.service.ServiceSet
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import com.motorro.rxlcemodel.viewmodel.BaseLceModel
import io.reactivex.Observable

/**
 * A basic functionality for ViewModel creation that exports state as live-data
 * @param netService Net-service for model
 * @param cacheService Cache-service for model
 * @param schedulers Schedulers
 */
abstract class BaseLceModelFactory<DATA: Any, PARAMS: Any>(
    protected val netService: NetService<DATA, PARAMS>,
    protected val cacheService: CacheService<DATA, PARAMS>,
    protected val schedulers: SchedulerRepository
): ViewModelProvider.Factory {
    /**
     * Bound params
     */
    protected abstract val params: PARAMS

    /**
     * Creates [LceModel]
     */
    protected open fun createLceModel() = LceModel.cacheThenNet(
        params = params,
        serviceSet = object : ServiceSet<DATA, PARAMS> {
            override val net: NetService<DATA, PARAMS> get() = netService
            override val cache: CacheService<DATA, PARAMS> get() = cacheService
        },
        startWith = Observable.empty() // To not to show loader when cache has data
    )

    /**
     * Creates state live-data
     */
    protected open fun LceModel<DATA, PARAMS>.createStateData(): Observable<LceState<DATA>> =
        state
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.ui)

    /**
     * Sets-up refresh operation
     */
    protected fun LceModel<DATA, PARAMS>.setupRefresh() =
        refresh
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.ui)

    /**
     * Model factory function
     * Creates [BaseLceModel] by default
     */
    protected open fun createModel(lceModel: LceModel<DATA, PARAMS>): ViewModel =
        BaseLceModel.Impl.create(
            lceModel.createStateData(),
            lceModel.setupRefresh()
        )

    /**
     * Creates a new instance of the given `Class`.
     *
     * @param modelClass a `Class` whose instance is requested
     * @param T The type parameter for the ViewModel.
     * @return a newly created ViewModel
     */
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = createModel(createLceModel()) as T
}