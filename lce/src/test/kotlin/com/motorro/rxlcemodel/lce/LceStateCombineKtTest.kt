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

package com.motorro.rxlcemodel.lce

import com.motorro.rxlcemodel.lce.LceState.Loading.Type
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class LceStateCombineKtTest {
    @Test
    fun loadingAndLoadingResultsInLoading() {
        val state1 = LceState.Loading(1, false)
        val state2 = LceState.Loading(2, false, Type.REFRESHING)
        val state3 = state1.combine(state2) { _, _ -> null }
        assertTrue(state3 is LceState.Loading)
        assertFalse(state3.dataIsValid)
        assertEquals(Type.LOADING, state3.type)
    }

    @Test
    fun loadingAndContentResultsInLoading() {
        val state1 = LceState.Loading(1, false)
        val state2 = LceState.Content(2, true)
        val state3 = state1.combine(state2) { _, _ -> null }
        assertTrue(state3 is LceState.Loading)
        assertFalse(state3.dataIsValid)
        assertEquals(Type.LOADING, state3.type)
    }

    @Test
    fun loadingAndErrorResultsInError() {
        val error = Error("Some error")
        val state1 = LceState.Loading(1, false)
        val state2 = LceState.Error(2, false, error)
        val state3 = state1.combine(state2) { _, _ -> null }
        assertTrue(state3 is LceState.Error)
        assertFalse(state3.dataIsValid)
        assertEquals(error, state3.error)
    }

    @Test
    fun loadingAndTerminatedResultsInTerminated() {
        val state1 = LceState.Loading(1, false)
        val state2 = LceState.Terminated
        val state3 = state1.combine(state2) { _, _ -> null }
        assertTrue(state3 is LceState.Terminated)
    }

    @Test
    fun contentAndLoadingResultsInLoading() {
        val state1 = LceState.Content(1, true)
        val state2 = LceState.Loading(2, false, Type.REFRESHING)
        val state3 = state1.combine(state2) { d1, d2 -> d1!! + d2!! }
        assertTrue(state3 is LceState.Loading)
        assertFalse(state3.dataIsValid)
        assertEquals(3, state3.data)
        assertEquals(Type.REFRESHING, state3.type)
    }

    @Test
    fun contentAndContentResultsInLoadingIfMapperReturnsNull() {
        val state1 = LceState.Content(1, false)
        val state2 = LceState.Content(2, true)
        val state3 = state1.combine<Int, Int, Int>(state2) { _, _ -> null }
        assertTrue(state3 is LceState.Loading)
        assertFalse(state3.dataIsValid)
        assertNull(state3.data)
        assertEquals(Type.LOADING, state3.type)
    }

    @Test
    fun contentAndContentResultsInContentIfMapperReturnsNonNull() {
        val state1 = LceState.Content(1, true)
        val state2 = LceState.Content(2, true)
        val state3 = state1.combine(state2) { d1, d2 -> d1!! + d2!! }
        assertTrue(state3 is LceState.Content)
        assertTrue(state3.dataIsValid)
        assertEquals(3, state3.data)
    }

    @Test
    fun contentAndErrorResultsInError() {
        val error = Error("Some error")
        val state1 = LceState.Content(1, true)
        val state2 = LceState.Error(2, false, error)
        val state3 = state1.combine(state2) { d1, d2 -> d1!! + d2!! }
        assertTrue(state3 is LceState.Error)
        assertFalse(state3.dataIsValid)
        assertEquals(3, state3.data)
        assertEquals(error, state3.error)
    }

    @Test
    fun contentAndTerminatedResultsInTerminated() {
        val state1 = LceState.Content(1, true)
        val state2 = LceState.Terminated
        val state3 = state1.combine(state2) { _, _ -> null }
        assertTrue(state3 is LceState.Terminated)
    }

    @Test
    fun errorAndLoadingResultsInError() {
        val error = Error("Some error")
        val state1 = LceState.Error(1, false, error)
        val state2 = LceState.Loading(2, false, Type.REFRESHING)
        val state3 = state1.combine(state2) { d1, d2 -> d1!! + d2!! }
        assertTrue(state3 is LceState.Error)
        assertFalse(state3.dataIsValid)
        assertEquals(3, state3.data)
        assertEquals(error, state3.error)
    }

    @Test
    fun errorAndContentResultsInError() {
        val error = Error("Some error")
        val state1 = LceState.Error(1, false, error)
        val state2 = LceState.Content(2, true)
        val state3 = state1.combine(state2) { d1, d2 -> d1!! + d2!! }
        assertTrue(state3 is LceState.Error)
        assertFalse(state3.dataIsValid)
        assertEquals(3, state3.data)
        assertEquals(error, state3.error)
    }

    @Test
    fun errorAndErrorResultsInReceiverError() {
        val error1 = Error("Some error 1")
        val error2 = Error("Some error 2")
        val state1 = LceState.Error(1, false, error1)
        val state2 = LceState.Error(2, true, error2)
        val state3 = state1.combine(state2) { d1, d2 -> d1!! + d2!! }
        assertTrue(state3 is LceState.Error)
        assertFalse(state3.dataIsValid)
        assertEquals(3, state3.data)
        assertEquals(error1, state3.error)
    }

    @Test
    fun errorAndTerminatedResultsInTerminated() {
        val error = Error("Some error")
        val state1 = LceState.Error(1, false, error)
        val state2 = LceState.Terminated
        val state3 = state1.combine(state2) { _, _ -> null }
        assertTrue(state3 is LceState.Terminated)
    }

    @Test
    fun terminatedAndLoadingResultsInTerminated() {
        val state1 = LceState.Terminated
        val state2 = LceState.Loading(2, false, Type.REFRESHING)
        val state3 = state1.combine(state2) { _, _ -> null }
        assertTrue(state3 is LceState.Terminated)
    }

    @Test
    fun terminatedAndContentResultsInTerminated() {
        val state1 = LceState.Terminated
        val state2 = LceState.Content(2, true)
        val state3 = state1.combine(state2) { _, _ -> null }
        assertTrue(state3 is LceState.Terminated)
    }

    @Test
    fun terminatedAndErrorResultsInReceiverTerminated() {
        val error = Error("Some error")
        val state1 = LceState.Terminated
        val state2 = LceState.Error(2, true, error)
        val state3 = state1.combine(state2) { _, _ -> null }
        assertTrue(state3 is LceState.Terminated)
    }

    @Test
    fun terminatedAndTerminatedResultsInTerminated() {
        val state1 = LceState.Terminated
        val state2 = LceState.Terminated
        val state3 = state1.combine(state2) { _, _ -> null }
        assertTrue(state3 is LceState.Terminated)
    }
}