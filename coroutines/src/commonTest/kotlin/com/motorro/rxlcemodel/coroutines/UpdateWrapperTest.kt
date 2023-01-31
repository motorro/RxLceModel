/*
 * Copyright 2023 Nikolai Kotchetkov.
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
import com.motorro.rxlcemodel.common.TestError
import com.motorro.rxlcemodel.coroutines.service.*
import com.motorro.rxlcemodel.lce.LceState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class UpdateWrapperTest {
    companion object {
        private const val PARAMS = "params"

        private val VALID_ENTITY = Entity.Impl(1, EntityValidator.Always)
    }

    private class TestWrapper(upstream: LceModel<Int, String>, private val serviceSet: UpdatingServiceSet<Int, Int, String>): UpdateWrapper<Int, String>(
        upstream,
        serviceSet.cache,
        UnconfinedTestDispatcher(),
        { _, _ -> }) {

        var updateCallCount = 0

        suspend fun callUpdate() {
            doUpdate {
                ++updateCallCount
                serviceSet.net.update(PARAMS, 0)
            }
        }
    }

    private lateinit var upstream: MutableSharedFlow<LceState<Int>>
    private lateinit var serviceSet: TestServiceSet<Int, Int, String>
    private lateinit var wrapper: TestWrapper

    private suspend inline fun withCollectingState(crossinline block: suspend (values: List<LceState<Int>>) -> Unit) {
        coroutineScope {
            val values = mutableListOf<LceState<Int>>()
            val collectJob = launch(UnconfinedTestDispatcher()) {
                wrapper.state.collect {
                    values.add(it)
                }
            }
            block(values)
            collectJob.cancelAndJoin()
        }
    }

    /**
     * Creates test wrapper and service set
     */
    private fun createWrapper(configure: ServiceConfig<Int>.() -> Unit) {
        upstream = MutableStateFlow(LceState.Loading(null, false))
        val upstreamModel = object : LceModel<Int, String> {
            override val state: Flow<LceState<Int>> = upstream
            override suspend fun refresh() {
                throw UnsupportedOperationException("Should not be executed")
            }
            override val params: String = PARAMS
        }
        serviceSet = createServiceSet(configure)
        wrapper = TestWrapper(upstreamModel, serviceSet)
    }

    @Test
    fun updatesServerAndCache() = runTest {
        createWrapper {
            cacheInitial = { null }
            netUpdate = { VALID_ENTITY }
        }

        wrapper.callUpdate()
        assertEquals(1, wrapper.updateCallCount)
        serviceSet.cache.assertSaved(PARAMS, VALID_ENTITY)
    }

    @Test
    fun transmitsUpstream() = runTest {
        createWrapper {
            cacheInitial = { null }
            netUpdate = { VALID_ENTITY }
        }

        withCollectingState { values ->
            assertEquals(
                listOf<LceState<Int>>(
                    LceState.Loading(null, false)
                ),
                values
            )

            upstream.emit(LceState.Content(2, true))

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Content(2, true)
                ),
                values
            )
        }
    }

    @Test
    fun combinesSuccessfulLoadingWithUpstreamLoading() = runTest {
        createWrapper {
            cacheInitial = { null }
            netUpdate = { VALID_ENTITY }
        }

        withCollectingState { values ->
            assertEquals(
                listOf<LceState<Int>>(
                    LceState.Loading(null, false)
                ),
                values
            )

            wrapper.callUpdate()

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Loading(null, false, LceState.Loading.Type.UPDATING),
                    LceState.Loading(null, false)
                ),
                values
            )
        }
    }

    @Test
    fun combinesFaultyLoadingWithUpstreamLoading() = runTest {
        val error = TestError("Network error")
        createWrapper {
            cacheInitial = { null }
            netUpdate = { throw(error) }
        }

        withCollectingState { values ->
            assertEquals(
                listOf<LceState<Int>>(
                    LceState.Loading(null, false)
                ),
                values
            )

            wrapper.callUpdate()

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Loading(null, false, LceState.Loading.Type.UPDATING),
                    LceState.Error(null, false, error)
                ),
                values
            )
        }
    }

    @Test
    fun combinesSuccessfulLoadingWithUpstreamContent() = runTest {
        createWrapper {
            cacheInitial = { null }
            netUpdate = { VALID_ENTITY }
        }

        withCollectingState { values ->
            assertEquals(
                listOf<LceState<Int>>(
                    LceState.Loading(null, false)
                ),
                values
            )

            upstream.emit(LceState.Content(2, true))

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Content(2, true)
                ),
                values
            )

            wrapper.callUpdate()

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Content(2, true),
                    LceState.Loading(2, true, LceState.Loading.Type.UPDATING),
                    LceState.Content(2, true)
                ),
                values
            )
        }
    }

    @Test
    fun combinesFaultyLoadingWithUpstreamContent() = runTest {
        val error = TestError("Network error")
        createWrapper {
            cacheInitial = { null }
            netUpdate = { throw(error) }
        }

        withCollectingState { values ->
            assertEquals(
                listOf<LceState<Int>>(
                    LceState.Loading(null, false)
                ),
                values
            )

            upstream.emit(LceState.Content(2, true))

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Content(2, true)
                ),
                values
            )

            wrapper.callUpdate()

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Content(2, true),
                    LceState.Loading(2, true, LceState.Loading.Type.UPDATING),
                    LceState.Error(2, true, error)
                ),
                values
            )
        }
    }

    @Test
    fun combinesSuccessfulLoadingWithUpstreamError() = runTest {
        val error = TestError("Network error")
        createWrapper {
            cacheInitial = { null }
            netUpdate = { VALID_ENTITY }
        }

        withCollectingState { values ->
            assertEquals(
                listOf<LceState<Int>>(
                    LceState.Loading(null, false)
                ),
                values
            )

            upstream.emit(LceState.Error(null, false, error))

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Error(null, false, error)
                ),
                values
            )

            wrapper.callUpdate()

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Error(null, false, error),
                    LceState.Loading(null, false, LceState.Loading.Type.UPDATING),
                    LceState.Error(null, false, error)
                ),
                values
            )
        }
    }

    @Test
    fun combinesFaultyLoadingWithUpstreamError() = runTest {
        val error1 = TestError("Network error 1")
        val error2 = TestError("Network error 2")
        createWrapper {
            cacheInitial = { null }
            netUpdate = { throw(error2) }
        }

        withCollectingState { values ->
            assertEquals(
                listOf<LceState<Int>>(
                    LceState.Loading(null, false)
                ),
                values
            )

            upstream.emit(LceState.Error(null, false, error1))

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Error(null, false, error1)
                ),
                values
            )

            wrapper.callUpdate()

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Error(null, false, error1),
                    LceState.Loading(null, false, LceState.Loading.Type.UPDATING),
                    LceState.Error(null, false, error2)
                ),
                values
            )
        }
    }

    @Test
    fun willResetNetworkStateOnDispose() = runTest {
        val net = MutableSharedFlow<Entity<Int>>()
        val serviceSet = object: UpdatingServiceSet<Int, Int, String> {
            override val net: UpdatingNetService<Int, Int, String> = object : UpdatingNetService<Int, Int, String> {
                override suspend fun get(params: String): Entity<Int> {
                    throw UnsupportedOperationException("Should not be executed")
                }
                override suspend fun update(params: String, update: Int): Entity<Int> {
                    return net.first()
                }
            }
            override val cache: CacheService<Int, String> = CacheServiceMock { VALID_ENTITY }
        }

        val upstream = MutableStateFlow(LceState.Loading(null, false))
        val upstreamModel = object : LceModel<Int, String> {
            override val state: Flow<LceState<Int>> = upstream
            override suspend fun refresh() {
                throw UnsupportedOperationException("Should not be executed")
            }
            override val params: String = PARAMS
        }

        wrapper = TestWrapper(upstreamModel, serviceSet)

        val values = mutableListOf<LceState<Int>>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            wrapper.state.collect {
                values.add(it)
            }
        }

        var subscriptions = 0
        val subscriptionJob = launch(UnconfinedTestDispatcher()) {
            net.subscriptionCount.collect { subscriptions = it }
        }

        assertEquals(
            listOf<LceState<Int>>(
                LceState.Loading(null, false)
            ),
            values
        )

        assertEquals(0, subscriptions)
        val updateJob = launch {
            wrapper.callUpdate()
        }
        advanceUntilIdle()
        assertEquals(1, subscriptions)
        updateJob.cancelAndJoin()
        assertEquals(0, subscriptions)

        subscriptionJob.cancelAndJoin()
        collectJob.cancelAndJoin()
    }

    @Test
    fun integratesWithCacheThenNetModel() = runTest {
        val updatedEntity = VALID_ENTITY.copy(data = 2)
        val serviceSet = createServiceSet<Int, Int, String> {
            cacheInitial = { null }
            netGet = { VALID_ENTITY }
            netUpdate = { updatedEntity }
        }

        val upstreamModel = LceModel.cacheThenNet(PARAMS, serviceSet, emptyFlow())
        wrapper = TestWrapper(upstreamModel, serviceSet)

        withCollectingState { values ->
            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Content(VALID_ENTITY.data, true)
                ),
                values
            )

            wrapper.callUpdate()

            assertEquals(
                listOf(
                    LceState.Loading(null, false),
                    LceState.Content(VALID_ENTITY.data, true),
                    LceState.Loading(VALID_ENTITY.data, true, LceState.Loading.Type.UPDATING),
                    LceState.Loading(updatedEntity.data, true, LceState.Loading.Type.UPDATING),
                    LceState.Content(updatedEntity.data, true)
                ),
                values
            )

            serviceSet.net.assertUpdated(PARAMS, 0)
            serviceSet.cache.assertSaved(PARAMS, updatedEntity)
        }
    }
}