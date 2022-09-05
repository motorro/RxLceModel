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
import com.motorro.rxlcemodel.cache.entity.EntityValidator.Lifespan
import com.motorro.rxlcemodel.utils.Clock
import com.motorro.rxlcemodel.utils.ClockMock
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MemorySyncDelegateTest {
    private lateinit var clock: Clock
    private lateinit var delegate: CacheDelegate<String, Int>

    @BeforeTest
    fun init() {
        clock = ClockMock(5, 10, 15)
        delegate = MemorySyncDelegate.create(10)
    }

    @Test
    fun returnsDataSnapshots() {
        val lifespan = Lifespan(5, clock)
        val entity = Entity.Impl("Value", lifespan)
        delegate.save(1, entity)
        val fromCache = delegate.get(1)!!
        assertFalse(entity.isValid())
        assertTrue(fromCache.isValid())
    }
}