/*
 * Copyright 2022 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.coroutines

import com.motorro.rxlcemodel.lce.LceState
import kotlinx.coroutines.flow.Flow

/**
 * Base LCE use-case with [state] and [refresh]
 * @param DATA Data type of data being loaded
 */
interface LceUseCase<DATA: Any> {
    /**
     * Model state. Subscription starts data load for the first subscriber.
     * Whenever last subscriber cancels, the model unsubscribes internal components for data updates
     */
    val state: Flow<LceState<DATA>>

    /**
     * Requests a refresh of data.
     * Data will be updated asynchronously
     */
    suspend fun refresh()
}