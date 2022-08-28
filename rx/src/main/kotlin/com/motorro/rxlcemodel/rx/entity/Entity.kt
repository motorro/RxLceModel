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

import com.motorro.rxlcemodel.utils.Clock
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

/**
 * Cache-controlling entity for [com.motorro.rxlcemodel.rx.entity.Entity]
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
     * Crates a snapshot of validator preserving it's current [EntityValidator.isValid] value
     */
    override fun createSnapshot(): Entity<T>

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

        /**
         * Crates a snapshot of validator preserving it's current [EntityValidator.isValid] value
         */
        override fun createSnapshot(): Entity<T> = copy(validator = validator.createSnapshot())
    }
}

/**
 * Converts [T] to [Entity] to use with services
 * @param validator Entity validator
 * @see com.motorro.rxlcemodel.rx.service.NetService
 * @see com.motorro.rxlcemodel.rx.service.CacheService
 */
fun <T: Any> T.toEntity(validator: EntityValidator) = Entity.Impl(this, validator)

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

        /**
         * Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid] with time
         * @param serialized Serialized validator
         * @return Deserialized validator or null if not recognized
         */
        fun deserializeSnapshot(serialized: String): EntityValidator? = deserialize(serialized)?.createSnapshot()
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
     * Crates a snapshot of validator preserving it's current [EntityValidator.isValid] value
     */
    fun createSnapshot(): EntityValidator = Simple(isValid())

    /**
     * A simple validator which state is defined on creation
     * May be used to fix the [isValid] state of dynamic validator such as [Lifespan]
     * @param valid Validity state
     */
    data class Simple(private val valid: Boolean): EntityValidator {
        /**
         * Deserializes validator from string
         */
        object SimpleDeserializer : Deserializer {
            /**
             * Pattern to deserialize
             */
            private val DESERIALIZATION_PATTERN = Pattern.compile("^Simple:\\s(true|false)$")

            /**
             * Deserializes validator from string if string is recognized
             * @param serialized Serialized validator
             * @return Deserialized validator or null if not recognized
             */
            override fun deserialize(serialized: String): EntityValidator? = DESERIALIZATION_PATTERN
                .matcher(serialized)
                .takeIf { it.matches() }
                ?.let { matcher ->
                    Simple(matcher.toMatchResult()?.group(1)!!.toBoolean())
                }
        }

        /**
         * If true cached entity is valid.
         */
        override fun isValid(): Boolean = valid

        /**
         * A way to serialize entity
         */
        override fun serialize(): String = "Simple: $valid"
    }

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
     * @param validation Validation delegate to create a dynamic or snapshot validator
     */
    class Lifespan private constructor(
        private val wasBorn: Long,
        private val ttl: Long,
        private val validation: Validation
    ): EntityValidator {
        companion object {
            /**
             * Checks if entity has expired
             */
            private fun isValid(wasBorn: Long, ttl: Long, clock: Clock) = clock.getMillis() - wasBorn <= ttl

            /**
             * Creates a snapshot that may be serialized and deserialized back to dynamic [Lifespan]
             * @param ttl Time to live
             * @param clock Clock implementation
             */
            @JvmOverloads
            fun createSnapshot(ttl: Long, clock: Clock = Clock.SYSTEM): Lifespan {
                val wasBorn = clock.getMillis()
                return Lifespan(
                    wasBorn,
                    ttl,
                    Validation.Snapshot(isValid(wasBorn, ttl, clock))
                )
            }
        }

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
             * Parses temporal properties and executes [action] if succeeded
             */
            private inline fun withTemporal(serialized: String, action: (Long, Long) -> Lifespan): Lifespan? =
                DESERIALIZATION_PATTERN
                    .matcher(serialized)
                    .takeIf { it.matches() }
                    ?.let { matcher ->
                        matcher.toMatchResult().let { result ->
                            val wasBorn = result.group(1).toLong()
                            val ttl = result.group(2).toLong()
                            action(wasBorn, ttl)
                        }
                    }
            /**
             * Deserializes validator from string if string is recognized
             * @param serialized Serialized validator
             * @return Deserialized validator or null if not recognized
             */
            override fun deserialize(serialized: String): EntityValidator? = withTemporal(serialized) { wasBorn, ttl ->
                Lifespan(wasBorn, ttl, Validation.Dynamic(clock))
            }

            /**
             * Deserializes an immutable snapshot of validator that does not change [EntityValidator.isValid] with time
             * @param serialized Serialized validator
             * @return Deserialized validator or null if not recognized
             */
            override fun deserializeSnapshot(serialized: String): EntityValidator? = withTemporal(serialized) { wasBorn, ttl ->
                Lifespan(wasBorn, ttl, Validation.Snapshot(isValid(wasBorn, ttl, clock)))
            }
        }

        /**
         * A delegate that performs validation
         * Used to alter Lifespan dynamic instance or a snapshot
         */
        internal interface Validation {
            /**
             * Checks if [Lifespan] is valid
             */
            fun isValid(wasBorn: Long, ttl: Long): Boolean

            /**
             * Use in dynamic [Lifespan]
             */
            class Dynamic(private val clock: Clock): Validation {
                override fun isValid(wasBorn: Long, ttl: Long): Boolean = isValid(wasBorn, ttl, clock)
            }

            /**
             * Use in [Lifespan] snapshot
             */
            class Snapshot(private val valid: Boolean): Validation {
                override fun isValid(wasBorn: Long, ttl: Long): Boolean = valid
            }
        }

        /**
         * Creates dynamic validator that will change it's [EntityValidator.isValid] in time
         * @constructor
         * @param ttl Time to live
         * @param clock Clock implementation
         */
        @JvmOverloads
        constructor(ttl: Long, clock: Clock = Clock.SYSTEM) : this(
            clock.getMillis(),
            ttl,
            Validation.Dynamic(clock)
        )

        /**
         * If true cached entity is valid.
         */
        override fun isValid(): Boolean = validation.isValid(wasBorn, ttl)

        /**
         * A way to serialize entity
         */
        override fun serialize(): String = "Lifespan: $wasBorn/$ttl"

        /**
         * Crates a snapshot of validator preserving it's current [EntityValidator.isValid] value
         */
        override fun createSnapshot(): EntityValidator = Lifespan(wasBorn, ttl, Validation.Snapshot(isValid()))

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

