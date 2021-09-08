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

package com.motorro.rxlcemodel.viewmodel

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class BaseViewModelTest {
    private class TestModel : BaseViewModel() {
        var doInitializeCallCount = 0
        var clearCallCount = 0

        override fun doInitialize() {
            ++doInitializeCallCount
        }

        override fun doClear() {
            ++clearCallCount
        }
    }

    private lateinit var model: TestModel

    @Before
    fun init() {
        model = TestModel()
    }

    @Test
    fun initializesOnce() {
        model.initialize()
        model.initialize()
        assertEquals(1, model.doInitializeCallCount)
    }

    @Test
    fun cleansUpOnCleared() {
        model.initialize()
        model.testOnCleared()
        assertEquals(1, model.clearCallCount)
    }

    @Test
    fun clearsOnce() {
        model.initialize()
        model.testOnCleared()
        model.testOnCleared()
        assertEquals(1, model.clearCallCount)
    }
}