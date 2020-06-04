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

import io.reactivex.rxjava3.core.Completable
import timber.log.Timber
import java.io.IOException
import java.util.concurrent.atomic.AtomicBoolean

/**
 * A mediator to imitate network connection state
 * and produce load errors
 */
class ConnectionChecker {

    private val status = AtomicBoolean(true)

    /**
     * Get current status
     * @see com.motorro.rxlcemodel.sample.view.MainActivity
     */
    fun getStatus() = status.get()

    /**
     * Updates network status
     * @see com.motorro.rxlcemodel.sample.view.MainActivity
     */
    fun setStatus(status: Boolean) {
        Timber.i("Turning connection ${ if (status) "on" else "off" }")
        this.status.set(status)
    }

    /**
     * Checks if connection active
     */
    val connectionCheck: Completable = Completable.fromAction {
        if (false == status.get()) {
            throw IOException("Not connected")
        }
    }
}