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

@file:OptIn(ExperimentalCoroutinesApi::class)

package com.motorro.rxlcemodel.coroutines.service

import com.motorro.rxlcemodel.cache.*
import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.cache.entity.EntityValidator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import kotlin.test.*

@OptIn(ExperimentalCoroutinesApi::class)
class SyncDelegateCacheServiceTest {
    companion object {
        private const val PARAMS_1 = "params1"
        private const val PARAMS_2 = "params2"
        private val VALID_ENTITY = Entity.Impl("data", EntityValidator.Always)
    }

    private lateinit var cacheDelegate: CacheDelegateMock<String, String>
    private lateinit var service: SyncDelegateCacheService<String, String>

    @BeforeTest
    fun init() {
        cacheDelegate = CacheDelegateMock()
        service = SyncDelegateCacheService(cacheDelegate)
        Dispatchers.setMain(StandardTestDispatcher())
    }


    @AfterTest
    fun after() {
        Dispatchers.resetMain()
    }

    @Test
    fun getsInitialFromDelegate() = runTest {
        assertNull(service.getData(PARAMS_1).first())
    }

    @Test
    fun failsToGetEntityIfDelegateFails() = runTest {
        val error = Exception("Error")
        val delegate = FailingGetDelegateMock<String, String>(error)
        service = SyncDelegateCacheService(delegate)

        assertFailsWith<Exception> {
            service.getData(PARAMS_1).first()
        }
    }

    @Test
    fun savesEntityAndUpdatesFromDelegate() = runTest {
        val values = mutableListOf<Entity<String>?>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            service.getData(PARAMS_1).toList(values)
        }

        assertEquals(listOf<Entity<String>?>(null), values)
        cacheDelegate.assertGet { this == PARAMS_1 }

        service.save(PARAMS_1, VALID_ENTITY)
        assertEquals(listOf<Entity<String>?>(null, VALID_ENTITY), values)
        cacheDelegate.assertSaved(PARAMS_1, VALID_ENTITY)
        cacheDelegate.assertGet(2) { this == PARAMS_1 }

        collectJob.cancel()
    }

    @Test
    fun failsToSaveEntityIfDelegateFails() = runTest {
        val error = Exception("Error")
        val delegate = FailingSaveDelegateMock<String, String>(error)
        service = SyncDelegateCacheService(delegate)

        val values = mutableListOf<Entity<String>?>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            service.getData(PARAMS_1).toList(values)
        }

        assertEquals(listOf<Entity<String>?>(null), values)

        assertFailsWith<Exception> {
            service.save(PARAMS_1, VALID_ENTITY)
        }
        assertEquals(listOf<Entity<String>?>(null), values)

        collectJob.cancel()
    }

    @Test
    fun refetchesDataFromDelegate() = runTest {
        val values = mutableListOf<Entity<String>?>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            service.getData(PARAMS_1).toList(values)
        }

        assertEquals(listOf<Entity<String>?>(null), values)
        cacheDelegate.assertGet { this == PARAMS_1 }

        service.refetch(PARAMS_1)
        assertEquals(listOf<Entity<String>?>(null, null), values)
        cacheDelegate.assertGet(2) { this == PARAMS_1 }

        collectJob.cancel()
    }

    @Test
    fun refetchesAllDataFromDelegate() = runTest {
        val params = listOf(PARAMS_1, PARAMS_2)
        val values: List<MutableList<Entity<String>?>> = listOf(
            mutableListOf(),
            mutableListOf()
        )

        val collectJobs = params.mapIndexed { i, p ->
            launch(UnconfinedTestDispatcher()) {
                service.getData(p).toList(values[i])
            }
        }

        values.forEach {
            assertEquals(listOf<Entity<String>?>(null), it)
        }
        params.forEach {
            cacheDelegate.assertGet { this == it }
        }

        service.refetchAll()

        values.forEach {
            assertEquals(listOf<Entity<String>?>(null, null), it)
        }
        params.forEach {
            cacheDelegate.assertGet(2) { this == it }
        }

        collectJobs.forEach { it.cancel() }
    }

    @Test
    fun invalidatesCacheAndAndUpdatesFromDelegate() = runTest {
        val values = mutableListOf<Entity<String>?>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            service.getData(PARAMS_1).toList(values)
        }

        assertEquals(listOf<Entity<String>?>(null), values)
        cacheDelegate.assertGet { this == PARAMS_1 }

        service.invalidate(PARAMS_1)
        cacheDelegate.assertInvalidated { this == PARAMS_1 }

        assertEquals(listOf<Entity<String>?>(null, null), values)
        cacheDelegate.assertGet(2) { this == PARAMS_1 }

        collectJob.cancel()
    }

    @Test
    fun failsToInvalidateCacheIfDelegateFails() = runTest {
        val error = Exception("Error")
        val delegate = FailingInvalidateDelegateMock(error, cacheDelegate)
        service = SyncDelegateCacheService(delegate)

        val values = mutableListOf<Entity<String>?>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            service.getData(PARAMS_1).toList(values)
        }

        assertEquals(listOf<Entity<String>?>(null), values)

        assertFailsWith<Exception> {
            service.invalidate(PARAMS_1)
        }

        assertEquals(listOf<Entity<String>?>(null), values)
        cacheDelegate.assertGet(1) { this == PARAMS_1 }

        collectJob.cancel()
    }

    @Test
    fun invalidatesAllCache() = runTest {
        val params = listOf(PARAMS_1, PARAMS_2)
        val values: List<MutableList<Entity<String>?>> = listOf(
            mutableListOf(),
            mutableListOf()
        )

        val collectJobs = params.mapIndexed { i, p ->
            launch(UnconfinedTestDispatcher()) {
                service.getData(p).toList(values[i])
            }
        }

        values.forEach {
            assertEquals(listOf<Entity<String>?>(null), it)
        }
        params.forEach {
            cacheDelegate.assertGet { this == it }
        }

        service.invalidateAll()
        cacheDelegate.assertAllInvalidated()

        values.forEach {
            assertEquals(listOf<Entity<String>?>(null, null), it)
        }
        params.forEach {
            cacheDelegate.assertGet(2) { this == it }
        }

        collectJobs.forEach { it.cancel() }
    }

    @Test
    fun failsToInvalidateAllCacheIfDelegateFails() = runTest {
        val error = Exception("Error")
        val delegate = FailingInvalidateDelegateMock(error, cacheDelegate)
        service = SyncDelegateCacheService(delegate)

        val params = listOf(PARAMS_1, PARAMS_2)
        val values: List<MutableList<Entity<String>?>> = listOf(
            mutableListOf(),
            mutableListOf()
        )

        val collectJobs = params.mapIndexed { i, p ->
            launch(UnconfinedTestDispatcher()) {
                service.getData(p).toList(values[i])
            }
        }

        values.forEach {
            assertEquals(listOf<Entity<String>?>(null), it)
        }
        params.forEach {
            cacheDelegate.assertGet { this == it }
        }

        assertFailsWith<Exception> {
            service.invalidateAll()
        }

        values.forEach {
            assertEquals(listOf<Entity<String>?>(null), it)
        }
        params.forEach {
            cacheDelegate.assertGet(1) { this == it }
        }

        collectJobs.forEach { it.cancel() }
    }

    @Test
    fun deletesCacheAndAndUpdatesFromDelegate() = runTest {
        val values = mutableListOf<Entity<String>?>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            service.getData(PARAMS_1).toList(values)
        }

        assertEquals(listOf<Entity<String>?>(null), values)
        cacheDelegate.assertGet { this == PARAMS_1 }

        service.delete(PARAMS_1)
        cacheDelegate.assertDeleted { this == PARAMS_1 }

        assertEquals(listOf<Entity<String>?>(null, null), values)
        cacheDelegate.assertGet(2) { this == PARAMS_1 }

        collectJob.cancel()
    }

    @Test
    fun failsToDeleteCacheIfDelegateFails() = runTest {
        val error = Exception("Error")
        val delegate = FailingDeleteDelegateMock(error, cacheDelegate)
        service = SyncDelegateCacheService(delegate)

        val values = mutableListOf<Entity<String>?>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            service.getData(PARAMS_1).toList(values)
        }

        assertEquals(listOf<Entity<String>?>(null), values)

        assertFailsWith<Exception> {
            service.delete(PARAMS_1)
        }

        assertEquals(listOf<Entity<String>?>(null), values)
        cacheDelegate.assertGet(1) { this == PARAMS_1 }

        collectJob.cancel()
    }
}