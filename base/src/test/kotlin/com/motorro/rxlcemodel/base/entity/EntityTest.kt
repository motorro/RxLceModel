/*
 * Copyright 2019 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.base.entity

import com.motorro.rxlcemodel.base.entity.EntityValidator.*
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import kotlin.test.*

class EntityTest {
    private lateinit var clock: Clock

    @Before
    fun init() {
        clock = mock()
    }

    @Test
    fun serializesAndDeserializesAlways() {
        val v = Always
        val s = v.serialize()
        assertEquals(v, Always.AlwaysDeserializer.deserialize(s))
    }

    @Test
    fun alwaysWillNotDeserializeUnknownString() {
        val s = "Unknown"
        assertNull(Always.AlwaysDeserializer.deserialize(s))
    }

    @Test
    fun serializesAndDeserializesNever() {
        val v = Never
        val s = v.serialize()
        assertEquals(v, Never.NeverDeserializer.deserialize(s))
    }

    @Test
    fun neverWillNotDeserializeUnknownString() {
        val s = "Unknown"
        assertNull(Never.NeverDeserializer.deserialize(s))
    }

    @Test
    fun serializesAndDeserializesLifespan() {
        whenever(clock.millis).thenReturn(5)
        val v = Lifespan(5, clock)
        val s = v.serialize()
        assertEquals(v, Lifespan.LifespanDeserializer(clock).deserialize(s))
    }

    @Test
    fun lifespanWillNotDeserializeUnknownString() {
        whenever(clock.millis).thenReturn(5)
        val s = "Unknown"
        assertNull(Lifespan.LifespanDeserializer(clock).deserialize(s))
    }

    // As soon as we should provide Entity interface - not internal state
    @Test
    fun twoDifferentLifeSpansBothUpToDateShouldBeEqual() {
        whenever(clock.millis).thenReturn(5).thenReturn(10)
        val entity1 = Lifespan(15, clock)
        val entity2 = Lifespan(25, clock)
        assertTrue { entity1 == entity2 }
    }

    @Test
    fun twoDifferentLifeSpansWithDifferentUpToDateShouldNotBeEqual() {
        whenever(clock.millis).thenReturn(5).thenReturn(10).thenReturn(30)
        val entity1 = Lifespan(15, clock)
        val entity2 = Lifespan(25, clock)

        // Tick the clock - see clock mock above
        assertFalse { entity1.isValid() }
        assertTrue { entity2.isValid() }

        assertFalse { entity1 == entity2 }
    }

    // As soon as we should provide Entity interface - not internal state
    @Test
    fun twoDifferentLifeSpansBothUpToDateShouldHaveSameHashCode() {
        whenever(clock.millis).thenReturn(5).thenReturn(10)
        val entity1 = Lifespan(15, clock)
        val entity2 = Lifespan(25, clock)

        assertEquals(entity1.hashCode(), entity2.hashCode())
    }

    @Test
    fun twoDifferentLifeSpansWithDifferentUpToDateShouldHaveDifferentHashCode() {
        whenever(clock.millis).thenReturn(5).thenReturn(10).thenReturn(30)
        val entity1 = Lifespan(15, clock)
        val entity2 = Lifespan(25, clock)

        // Tick the clock - see clock mock above
        assertFalse { entity1.isValid() }
        assertTrue { entity2.isValid() }

        assertNotEquals(entity1.hashCode(), entity2.hashCode())
    }
}