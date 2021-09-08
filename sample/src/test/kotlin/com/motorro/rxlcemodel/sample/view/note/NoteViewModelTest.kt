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

package com.motorro.rxlcemodel.sample.view.note

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.CompletableSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NoteViewModelTest {
    private lateinit var schedulers: SchedulerRepository
    private lateinit var state: Subject<LceState<Note>>
    private lateinit var refresh: CompletableSubject
    private lateinit var noteLceModel: NoteLceModel
    private lateinit var deleteScheduler: (Int) -> Unit
    private lateinit var model: NoteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        schedulers = mock {
            on { this.io } doReturn Schedulers.trampoline()
            on { this.computation } doReturn Schedulers.trampoline()
            on { this.ui } doReturn Schedulers.trampoline()
        }

        state = PublishSubject.create()
        refresh = CompletableSubject.create()
        noteLceModel = mock {
            on { this.state } doReturn state
            on { this.refresh } doReturn refresh
        }

        deleteScheduler = mock()

        model = NoteViewModel(1, noteLceModel, schedulers, deleteScheduler)
    }

    @Test
    fun subscribesLceModelAndTransfersState() {
        val terminated = LceState.Terminated<Note>()

        model.initialize()
        assertTrue(state.hasObservers())

        val observer: Observer<LceState<Note>> = mock()
        model.state.observeForever(observer)

        state.onNext(terminated)
        verify(observer).onChanged(terminated)
    }

    @Test
    fun dataDelegatesMethodsToModelIgnoringErrors() {
        whenever(noteLceModel.setTitle("Title")).thenReturn(Completable.error(Exception()))
        model.setTitle("Title")
        verify(noteLceModel).setTitle("Title")

        whenever(noteLceModel.setText("Text")).thenReturn(Completable.error(Exception()))
        model.setText("Text")
        verify(noteLceModel).setText("Text")
    }

    @Test
    fun deletesOnDelete() {
        model.delete()
        verify(deleteScheduler)(1)
    }

    @Test
    fun terminatesStateSubscriptionOnDelete() {
        model.initialize()
        assertTrue { state.hasObservers() }
        model.delete()
        assertFalse { state.hasObservers() }
    }

    @Test
    fun deletesTerminatesView() {
        val observer: Observer<LceState<Note>> = mock()
        model.initialize()
        model.state.observeForever(observer)
        model.delete()
        verify(observer).onChanged(LceState.Terminated())
    }
}