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
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.lce.LceState.Content
import com.motorro.rxlcemodel.lce.LceState.Loading
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class UpdatingLceModelWrapperTest {
    companion object {
        private const val PARAMS = "params"

        private val VALID_ENTITY = Entity.Impl(1, EntityValidator.Always)
    }

    @Test
    fun integratesWithCacheThenNetModel() = runTest {
        val updatedEntity = VALID_ENTITY.copy(data = 2)
        val serviceSet = createServiceSet<Int, Int, String> {
                cacheInitial = { null }
                netGet = { VALID_ENTITY }
                netUpdate = { updatedEntity }
            }

        val upstream = LceModel.cacheThenNet(PARAMS, serviceSet, emptyFlow())
        val model = UpdatingLceModelWrapper(
            upstream,
            serviceSet,
            UnconfinedTestDispatcher()
        ) { _, _ -> }

        val values = mutableListOf<LceState<Int>>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            model.state.collect {
                values.add(it)
            }
        }
        assertEquals(
            listOf(
                Loading(null, false),
                Content(VALID_ENTITY.data, true)
            ),
            values
        )

        model.update(updatedEntity.data)

        assertEquals(
            listOf(
                Loading(null, false),
                Content(VALID_ENTITY.data, true),
                Loading(VALID_ENTITY.data, true, Loading.Type.UPDATING),
                Loading(updatedEntity.data, true, Loading.Type.UPDATING),
                Content(updatedEntity.data, true)
            ),
            values
        )

        serviceSet.net.assertUpdated(PARAMS, updatedEntity.data)
        serviceSet.cache.assertSaved(PARAMS, updatedEntity)

        collectJob.cancelAndJoin()
    }
}