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

package com.motorro.rxlcemodel.coroutines.service

import com.motorro.rxlcemodel.cache.MemorySyncDelegate
import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.cache.entity.EntityValidator
import com.motorro.rxlcemodel.coroutines.LceModel
import com.motorro.rxlcemodel.lce.LceState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class CacheThenNetIntegrationTest {
    companion object {
        private val VALID_ENTITY = Entity.Impl("data", EntityValidator.Always)
    }

    @Test
    fun integratesWithCacheThenNetModelWhenNotCached() = runTest {
        val delegate = MemorySyncDelegate.create<String, String>(1)
        val model = LceModel.cacheThenNet(
            "key",
            object : ServiceSet<String, String> {
                override val net: NetService<String, String> = object : NetService<String, String> {
                    override suspend fun get(params: String): Entity<String> = VALID_ENTITY
                }
                override val cache: CacheService<String, String> = SyncDelegateCacheService(delegate)
            },
            emptyFlow()
        )

        val values = mutableListOf<LceState<String>>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            model.state.collect {
                values.add(it)
            }
        }

        collectJob.cancelAndJoin()

        assertEquals(
            listOf(
                LceState.Loading(null, false),
                LceState.Content(VALID_ENTITY.data, true)
            ),
            values
        )
    }

    @Test
    fun integratesWithCacheThenNetModelWhenCached() = runTest {
        val delegate = MemorySyncDelegate.create<String, String>(1).apply {
            save("key", VALID_ENTITY)
        }

        val model = LceModel.cacheThenNet(
            "key",
            object : ServiceSet<String, String> {
                override val net: NetService<String, String> = object : NetService<String, String> {
                    override suspend fun get(params: String): Entity<String> = VALID_ENTITY
                }
                override val cache: CacheService<String, String> = SyncDelegateCacheService(delegate)
            }
        )


        val values = mutableListOf<LceState<String>>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            model.state.collect {
                values.add(it)
            }
        }

        collectJob.cancelAndJoin()

        assertEquals(
            listOf<LceState<String>>(
                LceState.Content(VALID_ENTITY.data, true)
            ),
            values
        )
    }
}