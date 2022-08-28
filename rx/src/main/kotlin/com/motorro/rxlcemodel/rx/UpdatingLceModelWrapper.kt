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

package com.motorro.rxlcemodel.rx

import com.motorro.rxlcemodel.rx.service.UpdatingServiceSet
import com.motorro.rxlcemodel.utils.Logger
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler

/**
 * Wraps an [LceModel] to enable simple data updates with the [UPDATE] structure
 * (say a PUT operation) rather than individual property updates (PATCH operation).
 * Implement [UpdateWrapper] to achieve PATCH workflow
 * @param DATA Data Type of data being held
 * @param UPDATE Update type
 * @param PARAMS Params type that identify data being loaded
 * @param upstream LceModel that performs reading
 * @param serviceSet Data service-set. Note that cache service should update the
 * same cache as [upstream] uses for things to work correctly
 * @param ioScheduler Scheduler to run IO operations
 * @param logger Logging function
 * @see UpdateWrapper
 */
class UpdatingLceModelWrapper<DATA: Any, in UPDATE: Any, PARAMS: Any>(
    private val upstream: LceModel<DATA, PARAMS>,
    private val serviceSet: UpdatingServiceSet<DATA, UPDATE, PARAMS>,
    ioScheduler: Scheduler,
    logger: Logger?
): UpdateWrapper<DATA, PARAMS>(upstream, serviceSet.cache, ioScheduler, logger), UpdatingLceModel<DATA, UPDATE, PARAMS> {
    /**
     * Updates data on server and refreshes local data
     * @param update Data update
     */
    override fun update(update: UPDATE): Completable = doUpdate {
        serviceSet.net.update(upstream.params, update)
    }
}