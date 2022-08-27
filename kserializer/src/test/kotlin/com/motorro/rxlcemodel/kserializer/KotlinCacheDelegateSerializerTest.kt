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

import com.motorro.rxlcemodel.rx.entity.Entity
import com.motorro.rxlcemodel.rx.entity.EntityValidator
import com.motorro.rxlcemodel.rx.entity.EntityValidatorFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.cbor.Cbor
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

@ExperimentalSerializationApi
class KotlinCacheDelegateSerializerTest {

    @Serializable
    data class TestData(val a: Int, val b: String)

    companion object {
        private val ENTITY = Entity.Impl(TestData(123, "abc"), EntityValidator.Always)
    }

    private lateinit var validatorFactory: EntityValidatorFactory
    private lateinit var kSerializer: KotlinCacheDelegateSerializer<TestData>

    @Before
    @ExperimentalSerializationApi
    fun init() {
        validatorFactory = mock()
        whenever(validatorFactory.createSnapshot(any())).thenReturn(EntityValidator.Always)

        kSerializer = KotlinCacheDelegateSerializer(validatorFactory, TestData.serializer(), Cbor)
    }

    @Test
    fun serializesToObjectStream() {
        val sOut = ByteArrayOutputStream()

        kSerializer.serialize(ENTITY, sOut)
        assertTrue { sOut.size() > 0 }

        val sIn = ByteArrayInputStream(sOut.toByteArray())
        assertEquals(
            ENTITY,
            kSerializer.deserializeSnapshot(sIn, sOut.size().toLong(), false)
        )
    }

    @Test
    fun ifInvalidatedCreatesInvalidEntity() {
        val sOut = ByteArrayOutputStream()

        kSerializer.serialize(ENTITY, sOut)
        assertTrue { sOut.size() > 0 }

        val sIn = ByteArrayInputStream(sOut.toByteArray())
        assertFalse { kSerializer.deserializeSnapshot(sIn, sOut.size().toLong(), true)!!.isValid() }
    }

    @Test
    fun ifDeserializationFailsReturnsNull() {
        val sIn = ByteArrayInputStream(emptyArray<Byte>().toByteArray())
        assertNull(kSerializer.deserializeSnapshot(sIn, 0L, false))
    }

    @Test
    fun ifValidatorFactoryFailsReturnsNull() {
        val sOut = ByteArrayOutputStream()

        kSerializer.serialize(ENTITY, sOut)
        assertTrue { sOut.size() > 0 }

        val sIn = ByteArrayInputStream(sOut.toByteArray())
        whenever(validatorFactory.createSnapshot(any())).thenAnswer {
            throw Exception("Error")
        }

        assertNull(kSerializer.deserializeSnapshot(sIn, sOut.size().toLong(), false))
    }
}