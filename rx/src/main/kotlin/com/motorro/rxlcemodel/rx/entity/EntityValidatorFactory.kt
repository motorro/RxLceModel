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

package com.motorro.rxlcemodel.rx.entity

import com.motorro.rxlcemodel.rx.entity.EntityValidator.Lifespan
import com.motorro.rxlcemodel.utils.Clock

/**
 * Cache-control [EntityValidator] factory for operations
 */
interface EntityValidatorFactory {
    /**
     * Creates entity cache-control
     * @param serialized Serialized validator string. Creates a new validator if null is passed
     * @throws IllegalArgumentException if serialized can't be deserialized
     */
    fun create(serialized: String? = null): EntityValidator

    /**
     * Creates a snapshot of entity cache-control.The [EntityValidator.isValid] evaluated at the time of creation.
     * @param serialized Serialized validator string. Creates a valid snapshot if null is passed
     * @throws IllegalArgumentException if serialized can't be deserialized
     */
    fun createSnapshot(serialized: String? = null): EntityValidator
}

/**
 * Creates [Lifespan] as a cache-control
 * @param cacheTtl Cache TTL
 * @param clock System clock
 */
class LifespanValidatorFactory @JvmOverloads constructor(
    private val cacheTtl: Long,
    private val clock: Clock = Clock.SYSTEM
): EntityValidatorFactory {
    /**
     * Deserializer
     */
    private val deserializer = Lifespan.LifespanDeserializer(clock)

    /**
     * Creates entity cache-control
     * @param serialized Serialized validator string. Creates a new validator if null is passed
     * @throws IllegalArgumentException if serialized can't be deserialized
     */
    override fun create(serialized: String?): EntityValidator =
        serialized?.let { deserializer.deserialize(serialized)} ?: Lifespan(cacheTtl, clock)

    /**
     * Creates a snapshot of entity cache-control.The [EntityValidator.isValid] evaluated at the time of creation.
     * @param serialized Serialized validator string. Creates a valid snapshot if null is passed
     * @throws IllegalArgumentException if serialized can't be deserialized
     */
    override fun createSnapshot(serialized: String?): EntityValidator =
        serialized?.let { deserializer.deserializeSnapshot(serialized)} ?: Lifespan.createSnapshot(cacheTtl, clock)
}