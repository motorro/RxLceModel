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
import com.nhaarman.mockitokotlin2.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import kotlin.test.*

class CacheFriendDelegateTest {
    companion object {
        private val PARAMS = object : CacheFriend {
            override val cacheKey: String = "params1"
        }
        private val VALID_ENTITY = Entity.Impl("data", EntityValidator.Always)
        private val VALID_ENTITY_WITH_KEY = Entity.Impl(DataWithCacheKey("data", PARAMS.cacheKey), EntityValidator.Always)
    }

    private lateinit var cacheDelegate: CacheDelegate<DataWithCacheKey<String>, CacheFriend>
    private lateinit var friendDelegate: CacheDelegate<String, CacheFriend>
    private lateinit var validatorFactory: EntityValidatorFactory
    private lateinit var objectStream: CacheDelegateSerializerDeserializer<DataWithCacheKey<String>>

    @BeforeTest
    fun init() {
        cacheDelegate = mock()
        friendDelegate = CacheFriendDelegate(cacheDelegate)

        validatorFactory = mock()
        whenever(validatorFactory.createSnapshot(any())).thenReturn(EntityValidator.Always)
        objectStream = WithObjectStreamAndCacheKey(validatorFactory, String::class.java)
    }

    @Test
    fun savesDataWithCacheKey() {
        friendDelegate.save(PARAMS, VALID_ENTITY)
        verify(cacheDelegate).save(PARAMS, VALID_ENTITY.map { DataWithCacheKey("data", "params1") })
    }

    @Test
    fun ifKeyMatchesReturnsData() {
        whenever(cacheDelegate.get(PARAMS)).thenReturn(VALID_ENTITY.map { DataWithCacheKey("data", "params1") })
        assertEquals(VALID_ENTITY, friendDelegate.get(PARAMS))
    }

    @Test
    fun returnsNullifDelegateReturnsNull() {
        whenever(cacheDelegate.get(PARAMS)).thenReturn(null)
        assertNull(friendDelegate.get(PARAMS))
    }

    @Test
    fun returnsNullifParamsNotMatch() {
        whenever(cacheDelegate.get(PARAMS)).thenReturn(VALID_ENTITY.map { DataWithCacheKey("data", "params2") })
        assertNull(friendDelegate.get(PARAMS))
    }

    @Test
    fun serializesToObjectStream() {
        val sOut = ByteArrayOutputStream()

        objectStream.serialize(VALID_ENTITY_WITH_KEY, sOut)
        assertTrue { sOut.size() > 0 }

        val sIn = ByteArrayInputStream(sOut.toByteArray())
        assertEquals(
            VALID_ENTITY_WITH_KEY,
            objectStream.deserializeSnapshot(sIn, sOut.size().toLong(), false)
        )
    }

    @Test
    fun ifInvalidatedCreatesInvalidEntity() {
        val sOut = ByteArrayOutputStream()

        objectStream.serialize(VALID_ENTITY_WITH_KEY, sOut)
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

        objectStream.serialize(VALID_ENTITY_WITH_KEY, sOut)
        assertTrue { sOut.size() > 0 }

        val sIn = ByteArrayInputStream(sOut.toByteArray())
        whenever(validatorFactory.createSnapshot(any())).thenAnswer {
            throw Exception("Error")
        }

        assertNull(objectStream.deserializeSnapshot(sIn, sOut.size().toLong(), false))
    }

    @Test
    fun createsFriendWrapper() {
        friendDelegate = mock()
        val wrapper: CacheDelegate<String, String> = friendDelegate.makeFriendParams { this }

        wrapper.get("params")
        verify(friendDelegate).get(argThat { "params" == cacheKey })

        wrapper.save("params", VALID_ENTITY)
        verify(friendDelegate).save(argThat { "params" == cacheKey }, any())

        wrapper.invalidate("params")
        verify(friendDelegate).invalidate(argThat { "params" == cacheKey })

        wrapper.invalidateAll()
        verify(friendDelegate).invalidateAll()

        wrapper.delete("params")
        verify(friendDelegate).delete(argThat { "params" == cacheKey })
    }
}