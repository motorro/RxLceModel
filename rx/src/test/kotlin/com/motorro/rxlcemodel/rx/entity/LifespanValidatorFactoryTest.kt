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

package com.motorro.rxlcemodel.rx.entity

import com.motorro.rxlcemodel.rx.entity.EntityValidator.Lifespan
import com.motorro.rxlcemodel.utils.Clock
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LifespanValidatorFactoryTest {
    private lateinit var clock: Clock
    private lateinit var factory: LifespanValidatorFactory

    @Before
    fun init() {
        clock = mock()
        whenever(clock.getMillis()).thenReturn(5).thenReturn(10).thenReturn(15)
        factory = LifespanValidatorFactory(5, clock)
    }

    @Test
    fun deserializesLifespan() {
        val lifespan = Lifespan(5, clock)
        val fromFactory = factory.create(lifespan.serialize())
        assertTrue(fromFactory is Lifespan)
        assertTrue(fromFactory.isValid())
        assertFalse(fromFactory.isValid())
    }

    @Test
    fun createsLifespan() {
        val fromFactory = factory.create()
        assertTrue(fromFactory.isValid())
        assertFalse(fromFactory.isValid())
    }

    @Test
    fun deserializesLifespanSnapshot() {
        val lifespan = Lifespan(5, clock)
        val fromFactory = factory.createSnapshot(lifespan.serialize())
        assertTrue(fromFactory is Lifespan)
        assertTrue(fromFactory.isValid())
        assertTrue(fromFactory.isValid())
    }

    @Test
    fun createsLifespanSnapshot() {
        val fromFactory = factory.createSnapshot()
        assertTrue(fromFactory.isValid())
        assertTrue(fromFactory.isValid())
    }
}