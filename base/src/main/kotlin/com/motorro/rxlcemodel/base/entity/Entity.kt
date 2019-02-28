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

import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

/**
 * Cache-controlling entity for [com.motorro.rxlcemodel.base.entity.Entity]
 * implement this interface for cache control
 */
interface Entity<out T: Any>: EntityValidator {
    /**
     * Entity data
     */
    val data: T

    /**
     * Transforms Entity [data] to another entity data with [mapper]
     * Validation remains the same
     */
    fun <R: Any> map(mapper: (T) -> R): Entity<R>

    /**
     * Simple entity implementation
     * @param data Stored data
     * @param validator Entity validator
     */
    data class Impl<out T: Any>(
        override val data: T,
        private val validator: EntityValidator
    ): Entity<T>, EntityValidator by validator {
        /**
         * Transforms Entity [data] to another entity data with [mapper]
         * Validation remains the same
         */
        override fun <R : Any> map(mapper: (T) -> R): Entity<R> = Impl(
                data = mapper(data),
                validator = validator
        )
    }
}

/**
 * Entity validator
 */
interface EntityValidator {
    /**
     * Deserializes validator from string
     */
    interface Deserializer {
        /**
         * Deserializes validator from string if string is recognized
         * @param serialized Serialized validator
         * @return Deserialized validator or null if not recognized
         */
        fun deserialize(serialized: String): EntityValidator?
    }

    /**
     * If true cached entity is valid.
     */
    fun isValid(): Boolean

    /**
     * A way to serialize entity
     */
    fun serialize(): String

    /**
     * Entity that is always valid
     */
    object Always : EntityValidator {
        /**
         * Serialized string
         */
        private const val SERIALIZED_ALWAYS = "Always!"

        /**
         * Deserializes validator from string
         */
        object AlwaysDeserializer : Deserializer {
            /**
             * Deserializes validator from string if string is recognized
             * @param serialized Serialized validator
             * @return Deserialized validator or null if not recognized
             */
            override fun deserialize(serialized: String): EntityValidator? =
                if (SERIALIZED_ALWAYS == serialized) Always else null
        }

        /**
         * If true cached entity is valid.
         */
        override fun isValid(): Boolean = true

        /**
         * A way to serialize entity
         */
        override fun serialize(): String = SERIALIZED_ALWAYS
    }

    /**
     * Entity that is never valid
     */
    object Never : EntityValidator {
        /**
         * Serialized string
         */
        private const val SERIALIZED_NEVER = "Never!"

        /**
         * Deserializes validator from string
         */
        object NeverDeserializer : Deserializer {
            /**
             * Deserializes validator from string if string is recognized
             * @param serialized Serialized validator
             * @return Deserialized validator or null if not recognized
             */
            override fun deserialize(serialized: String): EntityValidator? =
                if (SERIALIZED_NEVER == serialized) Never else null
        }

        /**
         * If true cached entity is valid.
         */
        override fun isValid(): Boolean = false

        /**
         * A way to serialize entity
         */
        override fun serialize(): String = SERIALIZED_NEVER
    }

    /**
     * Uses creation time and TTL to validate
     * @param wasBorn Time entity was born
     * @param ttl Time to live
     * @param clock Clock implementation
     */
    class Lifespan private constructor(
        private val wasBorn: Long,
        private val ttl: Long,
        private val clock: Clock
    ): EntityValidator {
        /**
         * Deserializes validator from string
         */
        class LifespanDeserializer @JvmOverloads constructor (private val clock: Clock = Clock.SYSTEM) : Deserializer {
            companion object {
                /**
                 * Pattern to deserialize
                 */
                private val DESERIALIZATION_PATTERN = Pattern.compile("^Lifespan:\\s(\\d+)/(\\d+)$")
            }

            /**
             * Deserializes validator from string if string is recognized
             * @param serialized Serialized validator
             * @return Deserialized validator or null if not recognized
             */
            override fun deserialize(serialized: String): EntityValidator? = DESERIALIZATION_PATTERN
                    .matcher(serialized)
                    .takeIf { it.matches() }
                    ?.let { matcher ->
                        matcher.toMatchResult().let { result ->
                            Lifespan(result.group(1).toLong(), result.group(2).toLong(), clock)
                        }
                    }
        }

        /**
         * @constructor
         * @param ttl Time to live
         * @param clock Clock implementation
         */
        @JvmOverloads constructor(ttl: Long, clock: Clock = Clock.SYSTEM) : this(clock.getMillis(), ttl, clock)

        /**
         * If true cached entity is valid.
         */
        override fun isValid(): Boolean = clock.getMillis() - wasBorn <= ttl

        /**
         * A way to serialize entity
         */
        override fun serialize(): String = "Lifespan: $wasBorn/$ttl"

        /**
         * As soon as we should provide [EntityValidator] interface we compare only
         * the main property - validity - not the internal state
         */
        override fun equals(other: Any?): Boolean = when {
            this === other -> true
            other !is EntityValidator -> false
            else -> isValid() == other.isValid()
        }

        /**
         * As soon as we should provide [EntityValidator] interface we calculate
         * the main property - validity - not the internal state
         */
        override fun hashCode(): Int = isValid().hashCode()

        /**
         * Display string
         */
        override fun toString(): String = "Valid till: ${SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date(wasBorn + ttl))}"
    }
}

