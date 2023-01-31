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

package com.motorro.rxlcemodel.cache

import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.cache.entity.EntityValidator
import com.motorro.rxlcemodel.cache.entity.EntityValidatorFactory
import java.io.*

/**
 * Serializes and deserializes [Serializable] objects along with their caching key
 * @param validatorFactory [Entity] validator factory
 * @param dataClass Class type to cast result to
 */
class WithObjectStreamAndCacheKey<D: Serializable>(
    private val validatorFactory: EntityValidatorFactory,
    private val dataClass: Class<D>
): CacheDelegateSerializerDeserializer<DataWithCacheKey<D>> {
    /**
     * Class to store serialized data
     * @property data Entity data
     * @property cacheKey Cache key to store along with data
     * @property serializedValidator Serialized entity validator
     */
    private data class Storage<D: Serializable>(val data: D, val cacheKey: String, val serializedValidator: String):
        Serializable {
        companion object {
            private const val serialVersionUID: Long = 1
        }

        /**
         * Takes entity to serialize
         * @param entity Entity to be stored
         */
        constructor(entity: Entity<DataWithCacheKey<D>>): this(
            entity.data.data,
            entity.data.cacheKey,
            entity.serialize()
        )
    }

    /**
     * Creates [Entity] from serialized data
     */
    private fun Storage<*>.toEntity(invalidated: Boolean): Entity<DataWithCacheKey<D>> =
        Entity.Impl(
            DataWithCacheKey(dataClass.cast(data), cacheKey),
            if (invalidated) EntityValidator.Never else validatorFactory.createSnapshot(
                serializedValidator
            )
        )

    /**
     * Serializes [entity] to [output] stream
     * @param entity Entity to serialize
     * @param output Output stream
     */
    override fun serialize(entity: Entity<DataWithCacheKey<D>>, output: OutputStream) = ObjectOutputStream(
        output
    ).use {
        it.writeObject(Storage(entity))
    }

    /**
     * Deserializes [Entity] from [input] stream
     * @param input Entity to deserialize
     * @param length Content length
     */
    override fun deserializeSnapshot(input: InputStream, length: Long, invalidated: Boolean): Entity<DataWithCacheKey<D>>? = runCatching {
        ObjectInputStream(input).use {
            (it.readObject() as Storage<*>).toEntity(invalidated)
        }
    }.getOrNull()
}