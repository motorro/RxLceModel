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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.motorro.rxlcemodel.base.LceState
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

/**
 * Base model with [state] and [refresh]
 */
abstract class BaseLceModel<DATA: Any> : ViewModel() {
    /**
     * Maintains refresh subscriptions
     */
    protected val disposables = CompositeDisposable()

    /**
     * Is model initialized
     */
    var initialized: Boolean = false
        private set

    /**
     * Call this function to initialize a new model and start receiving events
     */
    fun initialize() {
        if (false == initialized) {
            doInitialize()
            initialized = true
        }
    }

    protected abstract fun doInitialize()

    /**
     * LCE State
     */
    abstract val state: LiveData<LceState<DATA>>

    /**
     * Requests data refresh
     */
    abstract fun refresh()

    /**
     * Disposes active operations when model is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    /**
     * Basic ViewModel with LceModel inside
     * @property state LCE state
     * @param refresh Refresh completable
     */
    class Impl<DATA: Any>(private val stateObservable: Observable<LceState<DATA>>, private val refresh: Completable): BaseLceModel<DATA>() {
        /**
         * State live-data
         */
        private val stateData = MutableLiveData<LceState<DATA>>()

        /**
         * Call this function to initialize a new model and start receiving events
         */
        override fun doInitialize() {
            if (initialized) {
                return
            }

            val subscription = stateObservable
                .subscribe(
                    { state -> stateData.value = state},
                    { error -> throw error }
                )
            disposables.add(subscription)
        }

        /**
         * LCE State
         */
        override val state: LiveData<LceState<DATA>>
            get() = stateData

        /**
         * Requests data refresh
         */
        override fun refresh() {
            // Errors are ignored as they are transmitted through [state] property
            disposables.add(refresh.onErrorComplete().subscribe())
        }
    }
}

