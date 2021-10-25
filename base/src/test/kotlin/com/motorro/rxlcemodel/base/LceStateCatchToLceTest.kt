/*
 * Copyright 2021 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.base

import org.junit.Test
import java.io.IOException
import kotlin.test.assertEquals

class LceStateCatchToLceTest {
    @Test
    fun bypassesMappedState() {
        val state1 = LceState.Content(1, true)
        val state2 = state1.catchToLce { map { it + 1 } }
        assertEquals(
            LceState.Content(2, true),
            state2
        )
    }

    @Test
    fun catchesErrorToLce() {
        val error = IllegalArgumentException("error")
        val state1 = LceState.Content(1, true)
        val state2 = state1.catchToLce<Int, Int> { throw error }
        assertEquals(
            LceState.Error(null, false, error),
            state2
        )
    }

    @Test
    fun substitutesEmptyLoading() {
        val original = LceState.Loading<Int>(null, false)
        val substitute = LceState.Content(10, true)
        assertEquals(
            substitute,
            original.mapEmptyData { substitute }
        )
    }

    @Test
    fun substitutesEmptyError() {
        val original = LceState.Error<Int>(null, false, IOException())
        val substitute = LceState.Content(10, true)
        assertEquals(
            substitute,
            original.mapEmptyData { substitute }
        )
    }

    @Test
    fun substitutesTermination() {
        val original = LceState.Terminated<Int>()
        val substitute = LceState.Content(10, true)
        assertEquals(
            substitute,
            original.mapEmptyData { substitute }
        )
    }

    @Test
    fun passesNonEmptyLoading() {
        val original = LceState.Loading(10, true)
        val substitute = LceState.Content(10, true)
        assertEquals(
            original,
            original.mapEmptyData { substitute }
        )
    }

    @Test
    fun passesNonEmptyError() {
        val original = LceState.Error(10, true, IOException())
        val substitute = LceState.Content(10, true)
        assertEquals(
            original,
            original.mapEmptyData { substitute }
        )
    }

    @Test
    fun substitutesEmptyLoadingItem() {
        val original = LceState.Loading<Int>(null, false)
        val substitute = 10
        assertEquals(
            LceState.Loading(10, false),
            original.mapEmptyDataItem { substitute }
        )
    }

    @Test
    fun substitutesEmptyErrorItem() {
        val error = IOException()
        val original = LceState.Error<Int>(null, false, error)
        val substitute = 10
        assertEquals(
            LceState.Error(10, false, error),
            original.mapEmptyDataItem { substitute }
        )
    }

    @Test
    fun passesNonEmptyLoadingItem() {
        val original = LceState.Loading(10, true)
        val substitute = 100
        assertEquals(
            original,
            original.mapEmptyDataItem { substitute }
        )
    }

    @Test
    fun passesNonEmptyErrorItem() {
        val original = LceState.Error(10, true, IOException())
        val substitute = 100
        assertEquals(
            original,
            original.mapEmptyDataItem { substitute }
        )
    }

    @Test
    fun passesTerminationItem() {
        val original = LceState.Terminated<Int>()
        val substitute = 100
        assertEquals(
            original,
            original.mapEmptyDataItem { substitute }
        )
    }
}