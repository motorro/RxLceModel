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

package com.motorro.rxlcemodel.disklrucache

import com.motorro.rxlcemodel.cache.CacheDelegateSerializerDeserializer
import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.cache.entity.EntityValidator
import com.motorro.rxlcemodel.common.Clock
import com.nhaarman.mockitokotlin2.*
import org.junit.After
import org.junit.Assume.assumeFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.InputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.OutputStream
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class DiskLruCacheSyncDelegateTest {
    companion object {
        private const val PREFIX = "prefix"
        private val ENTITY = Entity.Impl(1, EntityValidator.Always)
    }

    private lateinit var diskLruCache: DiskLruCacheSyncDelegate.DiskLruCacheProvider
    private lateinit var clock: Clock
    private lateinit var sd: CacheDelegateSerializerDeserializer<Int>
    private lateinit var delegate: DiskLruCacheSyncDelegate<Int>

    /**
     * Detects Windows OS
     */
    private fun isRunningWindows() = true == System.getProperty("os.name")
        .lowercase(Locale.US)
        .contains("windows")

    @get:[Rule]
    var tempDir: TemporaryFolder = TemporaryFolder()

    @Before
    fun init() {
        diskLruCache = DiskLruCacheSyncDelegate.DiskLruCacheProvider(
                tempDir.newFolder("cache"),
                1,
                Long.MAX_VALUE
        )

        clock = mock()

        sd = mock()
        whenever(sd.serialize(any(), any())).thenAnswer {
            @Suppress("UNCHECKED_CAST")
            val entity = it.arguments[0] as Entity<Int>
            val stream = it.arguments[1] as OutputStream
            ObjectOutputStream(stream).use { oStream ->
                oStream.writeObject(entity.data)
            }
        }
        whenever(sd.deserializeSnapshot(any(), any(), any())).thenAnswer {
            val stream = it.arguments[0] as InputStream
            val invalidated = it.arguments[2] as Boolean
            ObjectInputStream(stream).use { iStream ->
                Entity.Impl(
                        iStream.readObject() as Int,
                        if(invalidated) EntityValidator.Never else EntityValidator.Always
                )
            }
        }

        delegate = DiskLruCacheSyncDelegate(
                PREFIX,
                sd,
                diskLruCache,
                clock
        )
    }

    @After
    fun deinit() {
        diskLruCache.cache.close()
    }

    @Test
    fun returnsNullIfEntityNotFound() {
        assertNull(delegate.get("key"))
    }

    @Test
    fun createsAndReturnsEntity() {
        whenever(clock.getMillis()).thenReturn(100)
        delegate.save("key", ENTITY)
        assertEquals(ENTITY, delegate.get("key"))
        verify(sd).serialize(eq(ENTITY), any())
        verify(sd).deserializeSnapshot(any(), any(), eq(false))
    }

    @Test
    fun throwsErrorIfSaveFails() {
        whenever(sd.serialize(any(), any())).thenThrow(RuntimeException("Error saving data"))
        assertFailsWith<RuntimeException> {
            delegate.save("key", ENTITY)
        }
    }

    @Test
    fun invalidatesEntity() {
        // DiskLruCache is not intended to run on Windows due to file-system locks
        // https://github.com/JakeWharton/DiskLruCache/issues/70
        assumeFalse(isRunningWindows())

        whenever(clock.getMillis()).thenReturn(100)
        delegate.save("key", ENTITY)
        assertNotNull(delegate.get("key"))
        verify(sd).serialize(eq(ENTITY), any())
        verify(sd).deserializeSnapshot(any(), any(), eq(false))

        whenever(clock.getMillis()).thenReturn(200)
        delegate.invalidate("key")
        assertNotNull(delegate.get("key"))
        verify(sd).deserializeSnapshot(any(), any(), eq(true))
    }

    @Test
    fun invalidatesOnlyIfKeySaved() {
        delegate.invalidate("key")
    }

    @Test
    fun entitySavedAfterInvalidationIsValidAgain() {
        // DiskLruCache is not intended to run on Windows due to file-system locks
        // https://github.com/JakeWharton/DiskLruCache/issues/70
        assumeFalse(isRunningWindows())

        whenever(clock.getMillis()).thenReturn(100)
        delegate.save("key", ENTITY)
        assertNotNull(delegate.get("key"))
        verify(sd).serialize(eq(ENTITY), any())
        verify(sd).deserializeSnapshot(any(), any(), eq(false))

        whenever(clock.getMillis()).thenReturn(200)
        delegate.invalidate("key")
        assertNotNull(delegate.get("key"))
        verify(sd).deserializeSnapshot(any(), any(), eq(true))

        whenever(clock.getMillis()).thenReturn(300)
        delegate.save("key", ENTITY)
        assertNotNull(delegate.get("key"))
        verify(sd, times(2)).deserializeSnapshot(any(), any(), eq(false))
    }

    @Test
    fun invalidatesAllEntities() {
        whenever(clock.getMillis()).thenReturn(100)
        delegate.save("key", ENTITY)
        assertNotNull(delegate.get("key"))
        verify(sd).serialize(eq(ENTITY), any())
        verify(sd).deserializeSnapshot(any(), any(), eq(false))

        whenever(clock.getMillis()).thenReturn(200)
        delegate.invalidateAll()

        assertNotNull(delegate.get("key"))
        verify(sd).deserializeSnapshot(any(), any(), eq(true))
    }

    @Test
    fun entitySavedAfterInvalidationOfAllIsValidAgain() {
        // DiskLruCache is not intended to run on Windows due to file-system locks
        // https://github.com/JakeWharton/DiskLruCache/issues/70
        assumeFalse(isRunningWindows())

        whenever(clock.getMillis()).thenReturn(100)
        delegate.save("key", ENTITY)
        assertNotNull(delegate.get("key"))
        verify(sd).serialize(eq(ENTITY), any())
        verify(sd).deserializeSnapshot(any(), any(), eq(false))

        whenever(clock.getMillis()).thenReturn(200)
        delegate.invalidateAll()

        assertNotNull(delegate.get("key"))
        verify(sd).deserializeSnapshot(any(), any(), eq(true))

        whenever(clock.getMillis()).thenReturn(300)
        delegate.save("key", ENTITY)
        assertNotNull(delegate.get("key"))
        verify(sd, times(2)).deserializeSnapshot(any(), any(), eq(false))
    }

    @Test
    fun deletesEntity() {
        whenever(clock.getMillis()).thenReturn(100)
        delegate.save("key", ENTITY)
        assertNotNull(delegate.get("key"))
        verify(sd).serialize(eq(ENTITY), any())
        verify(sd).deserializeSnapshot(any(), any(), eq(false))

        delegate.delete("key")
        assertNull(delegate.get("key"))
    }

    @Test
    fun deletesOnlyIfKeySaved() {
        delegate.delete("key")
    }
}