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

import kotlin.test.Test
import kotlin.test.assertEquals

class LceStateFoldTest {
    @Test
    fun foldsLoading() {
        val state = LceState.Loading(1, true)
        var called = false
        state.fold(
            onLoading = {
                assertEquals(state, it)
                called = true
            },
            onContent = { error("Should not be called") },
            onError = { error("Should not be called") }
        )
        assertEquals(true, called)
    }

    @Test
    fun foldsContent() {
        val state = LceState.Content(1, true)
        var called = false
        state.fold(
            onLoading = { error("Should not be called") },
            onContent = {
                assertEquals(state, it)
                called = true
            },
            onError = { error("Should not be called") }
        )
        assertEquals(true, called)
    }

    @Test
    fun foldsError() {
        val error = Exception("error")
        val state = LceState.Error(1, true, error)
        var called = false
        state.fold(
            onLoading = { error("Should not be called") },
            onContent = { error("Should not be called") },
            onError = {
                assertEquals(state, it)
                called = true
            }
        )
        assertEquals(true, called)
    }

    @Test
    fun foldsTerminated() {
        val state = LceState.Terminated
        var called = false
        state.fold(
            onLoading = { error("Should not be called") },
            onContent = { error("Should not be called") },
            onError = { error("Should not be called") },
            terminated = { called = true }
        )
        assertEquals(true, called)
    }
}
