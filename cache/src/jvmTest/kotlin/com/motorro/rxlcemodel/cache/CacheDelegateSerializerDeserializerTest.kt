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
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import kotlin.test.*

class CacheDelegateSerializerDeserializerTest {
    companion object {
        private val ENTITY = Entity.Impl("String", EntityValidator.Always)
    }

    private lateinit var validatorFactory: EntityValidatorFactory
    private lateinit var objectStream: CacheDelegateSerializerDeserializer.WithObjectStream<String>

    @BeforeTest
    fun init() {
        validatorFactory = mock()
        whenever(validatorFactory.createSnapshot(any())).thenReturn(EntityValidator.Always)

        objectStream = CacheDelegateSerializerDeserializer.WithObjectStream(validatorFactory, String::class.java)
    }

    @Test
    fun serializesToObjectStream() {
        val sOut = ByteArrayOutputStream()

        objectStream.serialize(ENTITY, sOut)
        assertTrue { sOut.size() > 0 }

        val sIn = ByteArrayInputStream(sOut.toByteArray())
        assertEquals(
                ENTITY,
                objectStream.deserializeSnapshot(sIn, sOut.size().toLong(), false)
        )
    }

    @Test
    fun ifInvalidatedCreatesInvalidEntity() {
        val sOut = ByteArrayOutputStream()

        objectStream.serialize(ENTITY, sOut)
        assertTrue { sOut.size() > 0 }

        val sIn = ByteArrayInputStream(sOut.toByteArray())
        assertFalse { objectStream.deserializeSnapshot(sIn, sOut.size().toLong(), true)!!.isValid() }
    }

    @Test
    fun ifDeserializationFailsReturnsNull() {
        val sIn = ByteArrayInputStream(emptyArray<Byte>().toByteArray())
        assertNull(objectStream.deserializeSnapshot(sIn, 0L, false))
    }

    @Test
    fun ifValidatorFactoryFailsReturnsNull() {
        val sOut = ByteArrayOutputStream()

        objectStream.serialize(ENTITY, sOut)
        assertTrue { sOut.size() > 0 }

        val sIn = ByteArrayInputStream(sOut.toByteArray())
        whenever(validatorFactory.createSnapshot(any())).thenAnswer {
            throw Exception("Error")
        }

        assertNull(objectStream.deserializeSnapshot(sIn, sOut.size().toLong(), false))
    }
}