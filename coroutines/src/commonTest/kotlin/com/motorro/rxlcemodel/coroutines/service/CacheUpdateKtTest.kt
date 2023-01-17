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

package com.motorro.rxlcemodel.coroutines.service

import com.motorro.rxlcemodel.cache.CacheDelegateMock
import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.cache.entity.EntityValidator
import com.motorro.rxlcemodel.common.UpdateOperationState
import com.motorro.rxlcemodel.common.UpdateOperationState.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.*
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class CacheUpdateKtTest {
    companion object {
        private const val PARAMS = "params"
        private val ENTITY = Entity.Impl(1, EntityValidator.Always)
    }

    private lateinit var cacheService: CacheService<Int, String>
    private lateinit var cacheDelegate: CacheDelegateMock<Int, String>

    @BeforeTest
    fun init() {
        cacheDelegate = CacheDelegateMock()
        cacheService = SyncDelegateCacheService(cacheDelegate)
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @AfterTest
    fun after() {
        Dispatchers.resetMain()
    }

    @Test
    fun updatesCacheAndEmitsIdle() = runTest {
        val passedParams = mutableListOf<String>()
        val update: (params: String) -> Entity<Int> = {
            passedParams.add(it)
            ENTITY
        }
        val values = mutableListOf<UpdateOperationState>()

        cacheService.buildUpdateOperation(PARAMS, update).toList(values)

        assertEquals(listOf(LOADING, IDLE), values)

        assertEquals(listOf(PARAMS), passedParams)
        cacheDelegate.assertSaved(PARAMS, ENTITY)
    }

    @Test
    fun willReportUpdateOperationError() = runTest {
        val error = Error("An error")
        val update: (params: String) -> Entity<Int> = {
            throw error
        }
        val values = mutableListOf<UpdateOperationState>()

        cacheService.buildUpdateOperation(PARAMS, update).toList(values)

        assertEquals(listOf(LOADING, ERROR(error)), values)
    }
}