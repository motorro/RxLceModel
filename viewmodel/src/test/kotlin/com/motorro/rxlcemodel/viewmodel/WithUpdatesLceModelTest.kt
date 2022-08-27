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

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.motorro.rxlcemodel.rx.LceState
import com.motorro.rxlcemodel.rx.LceUseCase
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WithUpdatesLceModelTest {
    companion object {
        private const val DATA = "Data"
    }

    private lateinit var data: Subject<LceState<String>>
    private lateinit var model: TestModel
    private lateinit var observer: Observer<LceState<String>>
    private var refreshed: Boolean = false

    @get:Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private class TestModel(useCase: LceUseCase<String>) : BaseLceModel.WithUpdates<String>(useCase) {
        fun run(operation: Completable, terminating: Boolean = false) = runUpdate(operation, terminating)
        fun clearOperation() = clearOperationStatus()
    }

    @Before
    fun init() {
        data = PublishSubject.create()
        refreshed = false

        model = TestModel(
                mock {
                    on { this.state } doReturn data
                    on { this.refresh } doReturn Completable.fromAction {
                        refreshed = true
                    }
                },
        )

        observer = mock()
        model.state.observeForever(observer)
    }

    @Test
    fun loadsData() {
        model.initialize()
        data.onNext(LceState.Loading(null, false))
        data.onNext(LceState.Content(DATA, true))
        inOrder(observer) {
            verify(observer).onChanged(LceState.Loading(null, false))
            verify(observer).onChanged(LceState.Content(DATA, true))
        }
    }

    @Test
    fun refreshes() {
        model.initialize()
        data.onNext(LceState.Content(DATA, true))
        model.refresh()
        assertTrue(refreshed)
    }

    @Test
    fun runsSuccessfulCardOperationRefreshingData() {
        model.initialize()
        data.onNext(LceState.Content(DATA, true))
        model.run(Completable.complete())
        inOrder(observer) {
            verify(observer).onChanged(LceState.Content(DATA, true))
            verify(observer).onChanged(LceState.Loading(DATA, true, LceState.Loading.Type.UPDATING))
            verify(observer).onChanged(LceState.Content(DATA, true))
            verifyNoMoreInteractions()
        }
        assertTrue(refreshed)
    }

    @Test
    fun runsSuccessfulCardOperationAndCompletesIfTerminating() {
        model.initialize()
        data.onNext(LceState.Content(DATA, true))
        model.run(Completable.complete(), true)
        inOrder(observer) {
            verify(observer).onChanged(LceState.Content(DATA, true))
            verify(observer).onChanged(LceState.Loading(DATA, true, LceState.Loading.Type.UPDATING))
            verify(observer).onChanged(LceState.Terminated)
            verifyNoMoreInteractions()
        }
        assertTrue(refreshed)
    }

    @Test
    fun runsFailingOperationAndDoesNotCallComplete() {
        val error = IOException()
        model.initialize()
        data.onNext(LceState.Content(DATA, true))
        model.run(Completable.error(error))
        inOrder(observer) {
            verify(observer).onChanged(LceState.Content(DATA, true))
            verify(observer).onChanged(LceState.Loading(DATA, true, LceState.Loading.Type.UPDATING))
            verify(observer).onChanged(LceState.Error(DATA, true, error))
        }
        assertFalse(refreshed)
    }

    @Test
    fun dismissesFailingOperationError() {
        val error = IOException()
        model.initialize()
        data.onNext(LceState.Content(DATA, true))
        model.run(Completable.error(error))
        model.clearOperation()
        inOrder(observer) {
            verify(observer).onChanged(LceState.Content(DATA, true))
            verify(observer).onChanged(LceState.Loading(DATA, true, LceState.Loading.Type.UPDATING))
            verify(observer).onChanged(LceState.Error(DATA, true, error))
            verify(observer).onChanged(LceState.Content(DATA, true))
        }
        assertFalse(refreshed)
    }
}