/*
 * Copyright 2021 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.viewmodel

import androidx.lifecycle.ViewModel

/**
 * Base view model with [initialize] and [doClear] methods
 */
abstract class BaseViewModel : ViewModel() {
    /**
     * Is model initialized
     */
    var initialized: Boolean = false
        private set

    /**
     * Is model cleared
     */
    var cleared: Boolean = false

    /**
     * Call this function to initialize a new model and start receiving events
     */
    fun initialize() {
        if (false == initialized) {
            doInitialize()
            initialized = true
        }
    }

    /**
     * Internal initialization
     */
    protected open fun doInitialize() {

    }

    /**
     * Disposes active operations when model is destroyed
     */
    abstract fun doClear()

    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     *
     * It is useful when ViewModel observes some data and you need to clear this subscription to
     * prevent a leak of this ViewModel.
     */
    override fun onCleared() {
        super.onCleared()
        if (false == cleared) {
            doClear()
            cleared = true
        }
    }
}