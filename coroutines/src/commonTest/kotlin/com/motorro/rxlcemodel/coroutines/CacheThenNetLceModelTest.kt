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

package com.motorro.rxlcemodel.coroutines

import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.cache.entity.EntityValidator
import com.motorro.rxlcemodel.coroutines.service.CacheService
import com.motorro.rxlcemodel.coroutines.service.NetService
import com.motorro.rxlcemodel.coroutines.service.ServiceSet
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.lce.LceState.Loading.Type.REFRESHING
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class CacheThenNetLceModelTest {
    companion object {
        private const val PARAMS = "params"

        private val VALID_ENTITY = Entity.Impl(1, EntityValidator.Always)
        private val INVALID_ENTITY = Entity.Impl(2, EntityValidator.Never)
    }

    private lateinit var serviceSet: TestServiceSet<Int, Unit, String>
    private lateinit var cacheData: MutableSharedFlow<Entity<Int>?>
    private lateinit var model: CacheThenNetLceModel<Int, String>

    private inline fun TestScope.withCollectingState(crossinline block: (values: List<LceState<Int>>) -> Unit) {
        val values = mutableListOf<LceState<Int>>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            model.state.collect {
                values.add(it)
            }
        }

        block(values)

        collectJob.cancel()
    }


    /**
     * Creates test model and service set
     */
    private fun createModel(configure: ServiceConfig<Int>.() -> Unit) {
        val testServiceSet = createServiceSet<Int, Unit, String>(configure)
        serviceSet = testServiceSet
        cacheData = testServiceSet.cacheData
        model = CacheThenNetLceModel(
            params = PARAMS,
            serviceSet = serviceSet,
            startWith = emptyFlow(),
            ioDispatcher = UnconfinedTestDispatcher(),
            logger = { _, _ -> }
        )
    }

    @Test
    fun willLoadCachedDataAndWontLoadNetIfValid() = runTest {
        createModel {
            cacheInitial = { VALID_ENTITY }
        }

        withCollectingState { values ->
            assertEquals(
                listOf<LceState<Int>>(LceState.Content(VALID_ENTITY.data, true)),
                values
            )

            with (serviceSet) {
                cache.assertGet { this == PARAMS }
            }
        }
    }

    @Test
    fun willStartWithPassedInitialEmission() = runTest {
        val testServiceSet = createServiceSet<Int, Unit, String> {
            cacheInitial = { VALID_ENTITY }
        }
        serviceSet = testServiceSet
        cacheData = testServiceSet.cacheData
        model = CacheThenNetLceModel(
            params = PARAMS,
            serviceSet = serviceSet,
            startWith = flowOf(LceState.Loading(null, false)),
            ioDispatcher = UnconfinedTestDispatcher(),
            logger = { _, _ -> }
        )

        withCollectingState { values ->
            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Content(VALID_ENTITY.data, true)
                ),
                values
            )
        }
    }

    @Test
    fun willLoadCachedDataAndLoadNetIfNoCachedData() = runTest {
        createModel {
            cacheInitial = { null }
            netGet = { VALID_ENTITY }
        }

        withCollectingState { values ->
            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Content(VALID_ENTITY.data, true)
                ),
                values
            )

            with (serviceSet) {
                cache.assertGet { this == PARAMS }
                net.assertGet { this == PARAMS }
                cache.assertSaved(PARAMS, VALID_ENTITY)
            }
        }
    }

    @Test
    fun willLoadCachedDataAndLoadNetIfCacheIsOutdated() = runTest {
        createModel {
            cacheInitial = { INVALID_ENTITY }
            netGet = { VALID_ENTITY }
        }

        withCollectingState { values ->
            assertEquals(
                listOf(
                    LceState.Loading(INVALID_ENTITY.data, false, REFRESHING),
                    LceState.Content(VALID_ENTITY.data, true)
                ),
                values
            )

            with (serviceSet) {
                cache.assertGet { this == PARAMS }
                net.assertGet { this == PARAMS }
                cache.assertSaved(PARAMS, VALID_ENTITY)
            }
        }
    }

    @Test
    fun willUpdateSubscriberWhenCacheChanges() = runTest {
        createModel {
            cacheInitial = { VALID_ENTITY }
        }

        withCollectingState { values ->
            assertEquals(
                listOf(
                    LceState.Content(VALID_ENTITY.data, true)
                ),
                values
            )

            val updateJob = launch {
                val newData = 3
                val updatedEntity = VALID_ENTITY.copy(data = newData)

                cacheData.emit(updatedEntity)

                assertEquals(
                    listOf(
                        LceState.Content(VALID_ENTITY.data, true),
                        LceState.Content(updatedEntity.data, true)
                    ),
                    values
                )
            }

            updateJob.cancel()
        }
    }

    @Test
    fun willExplicitlyRefreshData() = runTest {
        val updatedEntity = VALID_ENTITY.copy(data = 3)
        createModel {
            cacheInitial = { VALID_ENTITY }
            netGet = { updatedEntity }
        }

        withCollectingState { values ->
            assertEquals(
                listOf(
                    LceState.Content(VALID_ENTITY.data, true)
                ),
                values
            )

            val updateJob = launch {
                model.refresh()

                assertEquals(
                    listOf(
                        LceState.Content(VALID_ENTITY.data, true),
                        LceState.Loading(VALID_ENTITY.data, true, REFRESHING),
                        LceState.Loading(updatedEntity.data, true, REFRESHING),
                        LceState.Content(updatedEntity.data, true)
                    ),
                    values
                )
            }

            updateJob.cancel()

            with (serviceSet) {
                cache.assertSaved(PARAMS, updatedEntity)
            }
        }
    }

    @Test
    fun willReportNetworkErrorOnNoData() = runTest {
        val error = Exception("Network error")
        createModel {
            cacheInitial = { null }
            netGet = { throw(error) }
        }

        withCollectingState { values ->
            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Error(null, false, error)
                ),
                values
            )
        }
    }

    @Test
    fun willReportNetworkErrorOnRefresh() = runTest {
        val error = Exception("Network error")
        createModel {
            cacheInitial = { INVALID_ENTITY }
            netGet = { throw(error) }
        }

        withCollectingState { values ->
            assertEquals(
                listOf(
                    LceState.Loading(INVALID_ENTITY.data, false, REFRESHING),
                    LceState.Error(INVALID_ENTITY.data, false, error)
                ),
                values
            )
        }
    }

    @Test
    fun willResetNetworkStateOnDispose() = runTest {
        val serviceSet = object: ServiceSet<Int, String> {
            override val net: NetService<Int, String> = object : NetService<Int, String> {
                override suspend fun get(params: String): Entity<Int> {
                    return flow<Entity<Int>> { /* Wait forever */ }.first()
                }
            }
            override val cache: CacheService<Int, String> = CacheServiceMock { VALID_ENTITY }
        }

        model = CacheThenNetLceModel(
            params = PARAMS,
            serviceSet = serviceSet,
            startWith = flowOf(LceState.Loading(null, false)),
            ioDispatcher = UnconfinedTestDispatcher(),
            logger = { _, _ -> }
        )

        val values = mutableListOf<LceState<Int>>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            model.state.collect {
                values.add(it)
            }
        }

        assertEquals(
            listOf(
                LceState.Loading(null, false),
                LceState.Content(VALID_ENTITY.data, true)
            ),
            values
        )

        val refreshJob = launch {
            model.refresh()
        }

        refreshJob.cancel()
        collectJob.cancel()

        assertEquals(
            listOf(
                LceState.Loading(null, false),
                LceState.Content(VALID_ENTITY.data, true),
                LceState.Loading(VALID_ENTITY.data, true, REFRESHING),
                LceState.Content(VALID_ENTITY.data, true)
            ),
            values
        )
    }

    @Test
    fun severalSubscribersShareNetworkOperation() = runTest {
        val netValue = MutableSharedFlow<Int>()

        val serviceSet = object: ServiceSet<Int, String> {
            override val net: NetService<Int, String> = object : NetService<Int, String> {
                override suspend fun get(params: String): Entity<Int> {
                    return netValue.map { Entity.Impl(it, EntityValidator.Always) }.first()
                }
            }
            override val cache: CacheService<Int, String> = CacheServiceMock { INVALID_ENTITY }
        }

        model = CacheThenNetLceModel(
            params = PARAMS,
            serviceSet = serviceSet,
            startWith = emptyFlow(),
            ioDispatcher = UnconfinedTestDispatcher(),
            logger = { _, _ -> }
        )

        val values1 = mutableListOf<LceState<Int>>()
        val values2 = mutableListOf<LceState<Int>>()

        val shared = model.state.shareIn(this, SharingStarted.Lazily, 1)

        val collect1 = launch {
            shared.collect { values1.add(it) }
        }
        val collect2 = launch {
            shared.collect { values2.add(it) }
        }

        assertEquals(
            listOf<LceState<Int>>(LceState.Loading(INVALID_ENTITY.data, false, REFRESHING)),
            values1
        )

        assertEquals(
            listOf<LceState<Int>>(LceState.Loading(INVALID_ENTITY.data, false, REFRESHING)),
            values2
        )

        netValue.emit(VALID_ENTITY.data)

        collect1.cancel()
        collect2.cancel()

        with (serviceSet) {
            (cache as CacheServiceMock).assertSaved(PARAMS, VALID_ENTITY, 1)
        }
    }
}
