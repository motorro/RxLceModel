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

package com.motorro.rxlcemodel.base.service

import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.entity.EntityValidator
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CacheFriendDelegateTest {
    companion object {
        private val PARAMS = object : CacheFriend {
            override val cacheKey: String = "params1"
        }
        private val VALID_ENTITY = Entity.Impl("data", EntityValidator.Always)
    }

    private lateinit var cacheDelegate: SyncDelegateCacheService.Delegate<DataWithCacheKey<String>, CacheFriend>
    private lateinit var friendDelegate: SyncDelegateCacheService.Delegate<String, CacheFriend>

    @Before
    fun init() {
        cacheDelegate = mock()
        friendDelegate = CacheFriendDelegate(cacheDelegate)
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
}