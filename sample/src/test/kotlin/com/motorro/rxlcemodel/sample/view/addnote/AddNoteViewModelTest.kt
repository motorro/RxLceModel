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

package com.motorro.rxlcemodel.sample.view.addnote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.motorro.rxlcemodel.base.LceState
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Completable
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AddNoteViewModelTest {
    private lateinit var useCase: (String, String) -> Completable
    private lateinit var model: AddNoteViewModel
    private lateinit var observer: Observer<LceState<Unit>>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        useCase = mock()
        whenever(useCase(any(), any())).thenReturn(Completable.complete())

        model = AddNoteViewModel(useCase)

        observer = mock()
        model.state.observeForever(observer)
    }

    @Test
    fun setsContentStateOnInitialize() {
        model.initialize()
        verify(observer).onChanged(LceState.Content(Unit, true))
    }

    @Test
    fun addWillShowLoadingAndComplete() {
        model.initialize()
        model.add("Title", "Text")

        verify(observer).onChanged(LceState.Content(Unit, true))
        verify(observer).onChanged(LceState.Loading(null, false, LceState.Loading.Type.LOADING))
        verify(observer).onChanged(LceState.Terminated)

        verify(useCase)("Title", "Text")
    }

    @Test
    fun addWillShowErrorOnError() {
        val error = Exception("Error")
        whenever(useCase(any(), any())).thenReturn(Completable.error(error))

        model.initialize()
        model.add("Title", "Text")

        verify(observer).onChanged(LceState.Content(Unit, true))
        verify(observer).onChanged(LceState.Loading(null, false, LceState.Loading.Type.LOADING))
        verify(observer).onChanged(LceState.Error(null, false, error))

        verify(useCase)("Title", "Text")
    }
}