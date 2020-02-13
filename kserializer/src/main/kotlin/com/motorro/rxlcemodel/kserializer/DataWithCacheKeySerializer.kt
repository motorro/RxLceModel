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

import com.motorro.rxlcemodel.base.service.DataWithCacheKey
import kotlinx.serialization.*
import kotlinx.serialization.internal.SerialClassDescImpl

/**
 * Serializer for [DataWithCacheKey]
 */
@Serializer(forClass = DataWithCacheKey::class)
data class DataWithCacheKeySerializer<D: Any>(val dataSerializer: KSerializer<D>):
    KSerializer<DataWithCacheKey<D>> {
    override val descriptor: SerialDescriptor = object : SerialClassDescImpl("DataWithCacheKey") {
        init {
            addElement("data")
            addElement("cacheKey")
        }
    }

    override fun serialize(encoder: Encoder, obj: DataWithCacheKey<D>) {
        val out = encoder.beginStructure(descriptor)
        out.encodeSerializableElement(descriptor, 0, dataSerializer, obj.data)
        out.encodeStringElement(descriptor, 1, obj.cacheKey)
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): DataWithCacheKey<D> {
        val inp = decoder.beginStructure(descriptor)
        lateinit var data: D
        lateinit var cacheKey: String

        loop@ while (true) {
            when (val i = inp.decodeElementIndex(descriptor)) {
                CompositeDecoder.READ_DONE -> break@loop
                0 -> data = inp.decodeSerializableElement(descriptor, i, dataSerializer)
                1 -> cacheKey = inp.decodeStringElement(descriptor, i)
                else -> throw SerializationException("Unknown index $i")
            }
        }
        inp.endStructure(descriptor)

        return DataWithCacheKey(data, cacheKey)
    }
}