/*
 * Copyright 2020 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.kserializer

import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.entity.EntityValidator
import com.motorro.rxlcemodel.base.entity.EntityValidatorFactory
import com.motorro.rxlcemodel.base.service.CacheDelegateSerializerDeserializer
import kotlinx.serialization.BinaryFormat
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.cbor.Cbor
import java.io.InputStream
import java.io.OutputStream

/**
 * Serializes and deserializes objects with [kotlinx.serialization.KSerializer]
 * @param validatorFactory [Entity] validator factory
 * @param kSerializer Serializer to use with [D]
 * @param binaryFormat Cbor serializer to use
 */
@ExperimentalSerializationApi
class KotlinCacheDelegateSerializer<D: Any>(
    private val validatorFactory: EntityValidatorFactory,
    private val kSerializer: KSerializer<D>,
    private val binaryFormat: BinaryFormat
): CacheDelegateSerializerDeserializer<D> {
    /**
     * Class to store serialized data
     * @property data Entity data
     * @property serializedValidator Serialized entity validator
     */
    @Serializable
    private data class Storage<D: Any>(val data: D, val serializedValidator: String) {
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
    private fun Storage<D>.toEntity(invalidated: Boolean): Entity<D> = Entity.Impl(
        data,
        if (invalidated) EntityValidator.Never else validatorFactory.createSnapshot(serializedValidator)
    )


    /**
     * Serializes [entity] to [output] stream
     * @param entity Entity to serialize
     * @param output Output stream
     */
    override fun serialize(entity: Entity<D>, output: OutputStream) = output.use {
        it.write(
            binaryFormat.encodeToByteArray(
                Storage.serializer(kSerializer),
                Storage(entity)
            )
        )
    }

    /**
     * Deserializes [Entity] snapshot from [input] stream
     * Snapshots are used because the validity status is only actual when we are getting cached data.
     * https://github.com/motorro/RxLceModel/issues/5
     * @param input Entity to deserialize
     * @param length Content length
     * @param invalidated If true, the entity was externally invalidated
     */
    override fun deserializeSnapshot(input: InputStream, length: Long, invalidated: Boolean): Entity<D>? = kotlin.runCatching {
        input.use {
            Cbor.decodeFromByteArray(
                Storage.serializer(kSerializer),
                it.readBytes()
            ).toEntity(invalidated)
        }
    }.getOrNull()
}