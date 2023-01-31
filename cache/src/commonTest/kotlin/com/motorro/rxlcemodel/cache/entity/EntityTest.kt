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

package com.motorro.rxlcemodel.cache.entity

import com.motorro.rxlcemodel.cache.entity.EntityValidator.*
import com.motorro.rxlcemodel.common.ClockMock
import kotlin.test.*

class EntityTest {

    @Test
    fun serializesAndDeserializesSimple() {
        var v = Simple(true)
        var s = v.serialize()
        assertEquals(v, Simple.SimpleDeserializer.deserialize(s))
        assertTrue(v.isValid())

        v = Simple(false)
        s = v.serialize()
        assertEquals(v, Simple.SimpleDeserializer.deserialize(s))
        assertFalse(v.isValid())
    }

    @Test
    fun simpleWillNotDeserializeUnknownString() {
        val s = "Unknown"
        assertNull(Simple.SimpleDeserializer.deserialize(s))
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
        val clock = ClockMock(5)

        val v = Lifespan(5, clock)
        val s = v.serialize()
        assertEquals(v, Lifespan.LifespanDeserializer(clock).deserialize(s))
    }

    @Test
    fun lifespanWillNotDeserializeUnknownString() {
        val clock = ClockMock(5)

        val s = "Unknown"
        assertNull(Lifespan.LifespanDeserializer(clock).deserialize(s))
    }

    // As soon as we should provide Entity interface - not internal state
    @Test
    fun twoDifferentLifeSpansBothUpToDateShouldBeEqual() {
        val clock = ClockMock(5, 10)

        val entity1 = Lifespan(15, clock)
        val entity2 = Lifespan(25, clock)
        assertTrue { entity1 == entity2 }
    }

    @Test
    fun twoDifferentLifeSpansWithDifferentUpToDateShouldNotBeEqual() {
        val clock = ClockMock(5, 10, 30)

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
        val clock = ClockMock(5, 10)

        val entity1 = Lifespan(15, clock)
        val entity2 = Lifespan(25, clock)

        assertEquals(entity1.hashCode(), entity2.hashCode())
    }

    @Test
    fun twoDifferentLifeSpansWithDifferentUpToDateShouldHaveDifferentHashCode() {
        val clock = ClockMock(5, 10, 30)

        val entity1 = Lifespan(15, clock)
        val entity2 = Lifespan(25, clock)

        // Tick the clock - see clock mock above
        assertFalse { entity1.isValid() }
        assertTrue { entity2.isValid() }

        assertNotEquals(entity1.hashCode(), entity2.hashCode())
    }

    @Test
    fun lifeSpanWillExpire() {
        val clock = ClockMock(5, 10, 15)

        val entity = Lifespan(5, clock)
        assertTrue(entity.isValid())
        assertFalse(entity.isValid())
    }

    @Test
    fun lifeSpanSnapshotWillNotExpire() {
        val clock = ClockMock(5, 10, 15)

        val entity = Lifespan.createSnapshot(5, clock)
        assertTrue(entity.isValid())
        assertTrue(entity.isValid())
    }

    @Test
    fun deserializesSnapshot() {
        val clock = ClockMock(5, 10, 15)

        val lifespan = Lifespan(5, clock)
        val serialized = lifespan.serialize()
        val deserialized = Lifespan.LifespanDeserializer(clock).deserializeSnapshot(serialized)
        assertTrue(deserialized!!.isValid())
    }

    @Test
    fun deserializedSnapshotCreatesLifespan() {
        val clock = ClockMock(5, 10, 15)

        val lifespan = Lifespan.createSnapshot(5, clock)
        assertTrue(lifespan.isValid())
        val serialized = lifespan.serialize()
        val deserialized = Lifespan.LifespanDeserializer(clock).deserialize(serialized)
        assertFalse(deserialized!!.isValid())
    }
}