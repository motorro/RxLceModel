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

package com.motorro.rxlcemodel.sample.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.motorro.rxlcemodel.base.LceState
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable

/**
 * Basic ViewModel with LceModel inside
 * @property state LCE state
 * @param refresh Refresh completable
 */
open class BaseLceModel<DATA: Any, PARAMS: Any>(val state: LiveData<LceState<DATA, PARAMS>>, private val refresh: Completable): ViewModel() {
    /**
     * Maintains refresh subscriptions
     */
    private val disposables = CompositeDisposable()

    /**
     * Requests data refresh
     * Errors are ignored as they are transmitted through [state] property
     */
    fun refresh() {
        disposables.add(refresh.onErrorComplete().subscribe())
    }

    /**
     * Disposes active operations when model is destroyed
     * The state subscription is implemented using androidx converter
     */
    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}