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

import com.motorro.rxlcemodel.rx.service.DataWithCacheKey
import kotlinx.serialization.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Serializer for [DataWithCacheKey]
 */
@Serializer(forClass = DataWithCacheKey::class)
@ExperimentalSerializationApi
data class DataWithCacheKeySerializer<D: Any>(val dataSerializer: KSerializer<D>):
    KSerializer<DataWithCacheKey<D>> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("DataWithCacheKey") {
        element("data", dataSerializer.descriptor)
        element("cacheKey", String.serializer().descriptor)
    }

    override fun serialize(encoder: Encoder, value: DataWithCacheKey<D>) {
        val out = encoder.beginStructure(descriptor)
        out.encodeSerializableElement(descriptor, 0, dataSerializer, value.data)
        out.encodeStringElement(descriptor, 1, value.cacheKey)
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): DataWithCacheKey<D> {
        val inp = decoder.beginStructure(descriptor)
        lateinit var data: D
        lateinit var cacheKey: String

        loop@ while (true) {
            when (val i = inp.decodeElementIndex(descriptor)) {
                CompositeDecoder.DECODE_DONE -> break@loop
                0 -> data = inp.decodeSerializableElement(descriptor, i, dataSerializer)
                1 -> cacheKey = inp.decodeStringElement(descriptor, i)
                else -> throw SerializationException("Unknown index $i")
            }
        }
        inp.endStructure(descriptor)

        return DataWithCacheKey(data, cacheKey)
    }
}