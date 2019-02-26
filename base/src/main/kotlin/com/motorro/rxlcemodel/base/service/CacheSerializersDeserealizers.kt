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

package com.motorro.rxlcemodel.base.service

import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.entity.EntityValidator.Never
import com.motorro.rxlcemodel.base.entity.EntityValidatorFactory
import java.io.*

/**
 * Serializer for cache delegates
 */
interface CacheDelegateSerializerDeserializer<D: Any> {
    /**
     * Serializes [entity] to [output] stream
     * @param entity Entity to serialize
     * @param output Output stream
     */
    fun serialize (entity: Entity<D>, output: OutputStream)

    /**
     * Deserializes [Entity] from [input] stream
     * @param input Entity to deserialize
     * @param length Content length
     * @param invalidated If true, the entity was externally invalidated
     */
    fun deserialize (input: InputStream, length: Long, invalidated: Boolean): Entity<D>?

    /**
     * Serializes and deserialises [Serializable] objects
     * @param validatorFactory [Entity] validator factory
     */
    class WithObjectStream<D: Serializable>(private val validatorFactory: EntityValidatorFactory, private val dataClass: Class<D>) :
        CacheDelegateSerializerDeserializer<D> {
        /**
         * Class to store serialized data
         * @property data Entity data
         * @property serializedValidator Serialized entity validator
         */
        private data class Storage<D: Serializable>(val data: D, val serializedValidator: String): Serializable {
            companion object {
                private const val serialVersionUID: Long = 1
            }

            /**
             * Takes entity to serialize
             * @param entity Entity to be stored
             */
            constructor(entity: Entity<D>): this(
                    entity.data,
                    entity.serialize()
            )
        }

        /**
         * Creates [Entity] from serialized data
         */
        private fun Storage<*>.toEntity(invalidated: Boolean): Entity<D> = Entity.Impl(
                dataClass.cast(data),
                if (invalidated) Never else validatorFactory.create(serializedValidator)
        )

        /**
         * Serializes [entity] to [output] stream
         * @param entity Entity to serialize
         * @param output Output stream
         */
        override fun serialize(entity: Entity<D>, output: OutputStream) = ObjectOutputStream(output).use {
            it.writeObject(Storage(entity))
        }

        /**
         * Deserializes [Entity] from [input] stream
         * @param input Entity to deserialize
         * @param length Content length
         */
        override fun deserialize(input: InputStream, length: Long, invalidated: Boolean): Entity<D>? = runCatching {
            ObjectInputStream(input).use {
                (it.readObject() as Storage<*>).toEntity(invalidated)
            }
        }.getOrNull()
    }
}
