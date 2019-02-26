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

package com.motorro.rxlcemodel.base.entity

import com.motorro.rxlcemodel.base.entity.EntityValidator.Lifespan

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
}

/**
 * Creates [Lifespan] as a cache-control
 * @param clock System clock
 * @param cacheTtl Cache TTL
 */
class LifespanValidatorFactory(private val clock: Clock, private val cacheTtl: Long): EntityValidatorFactory {
    /**
     * Deserializer
     */
    private val deserializer = Lifespan.LifespanDeserializer(clock)

    /**
     * Creates entity cache-control
     * @param serialized Serialized validator string. Creates a new validator if null is passed
     * @throws IllegalArgumentException if serialized can't be deserialized
     */
    override fun create(serialized: String?): EntityValidator = serialized?.let { deserializer.deserialize(serialized)} ?: Lifespan(cacheTtl, clock)
}