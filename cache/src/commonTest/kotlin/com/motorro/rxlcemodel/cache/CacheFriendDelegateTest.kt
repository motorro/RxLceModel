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
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CacheFriendDelegateTest {
    companion object {
        private val PARAMS = object : CacheFriend {
            override val cacheKey: String = "params1"
        }
        private val VALID_ENTITY = Entity.Impl("data", EntityValidator.Always)
    }

    private lateinit var cacheDelegate: CacheDelegateMock<DataWithCacheKey<String>, CacheFriend>
    private lateinit var friendDelegate: CacheDelegate<String, CacheFriend>

    @BeforeTest
    fun init() {
        cacheDelegate = CacheDelegateMock()
        friendDelegate = CacheFriendDelegate(cacheDelegate)
    }

    @Test
    fun savesDataWithCacheKey() {
        friendDelegate.save(PARAMS, VALID_ENTITY)
        cacheDelegate.assertSaved(PARAMS, VALID_ENTITY.map { DataWithCacheKey("data", "params1") })
    }

    @Test
    fun ifKeyMatchesReturnsData() {
        cacheDelegate.save(PARAMS, VALID_ENTITY.map { DataWithCacheKey("data", "params1") })
        assertEquals(VALID_ENTITY, friendDelegate.get(PARAMS))
    }

    @Test
    fun returnsNullifDelegateReturnsNull() {
        assertNull(friendDelegate.get(PARAMS))
    }

    @Test
    fun returnsNullifParamsNotMatch() {
        cacheDelegate.save(PARAMS, VALID_ENTITY.map { DataWithCacheKey("data", "params2") })
        assertNull(friendDelegate.get(PARAMS))
    }

    @Test
    fun createsFriendWrapper() {
        val delegate: CacheDelegateMock<String, CacheFriend> = CacheDelegateMock()
        val wrapper: CacheDelegate<String, String> = delegate.makeFriendParams { this }

        wrapper.get("params")
        delegate.assertGet { "params" == cacheKey }

        wrapper.save("params", VALID_ENTITY)
        delegate.assertSaved({ "params" == cacheKey }, { VALID_ENTITY == this })

        wrapper.invalidate("params")
        delegate.assertInvalidated { "params" == cacheKey }

        wrapper.invalidateAll()
        delegate.assertInvalidated()

        wrapper.delete("params")
        delegate.assertDeleted { "params" == cacheKey }
    }
}