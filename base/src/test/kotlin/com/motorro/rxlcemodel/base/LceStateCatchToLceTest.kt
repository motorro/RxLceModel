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
}