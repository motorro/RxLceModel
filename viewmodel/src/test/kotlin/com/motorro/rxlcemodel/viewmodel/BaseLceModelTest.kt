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
import com.motorro.rxlcemodel.base.LceState
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BaseLceModelTest {
    private fun createModel(
        stateObservable: Observable<LceState<String>>,
        refresh: Completable
    ): BaseLceModel<String> = BaseLceModel.create(stateObservable, refresh)

    @get:Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun initializesOnce() {
        var numOfSubscriptions = 0
        val state = Observable.fromCallable<LceState<String>> {
            ++numOfSubscriptions
            LceState.Terminated
        }

        val model = createModel(state, Completable.complete())
        model.initialize()
        model.initialize()
        assertEquals(1, numOfSubscriptions)
    }

    @Test
    fun transmitsState() {
        val state = LceState.Terminated

        val observer: Observer<LceState<String>> = mock()
        val model = createModel(Observable.just(state), Completable.complete())
        model.state.observeForever(observer)
        model.initialize()

        verify(observer).onChanged(state)
    }

    @Test
    fun refreshes() {
        var numOfSubscriptions = 0
        val refresh = Completable.fromAction {
            ++numOfSubscriptions
        }

        val model = createModel(Observable.empty(), refresh)
        model.refresh()

        assertEquals(1, numOfSubscriptions)
    }

    @Test
    fun restarts() {
        var numOfSubscriptions = 0
        val state = Observable.fromCallable<LceState<String>> {
            ++numOfSubscriptions
            LceState.Terminated
        }

        val model = createModel(state, Completable.complete())
        model.initialize()
        assertEquals(1, numOfSubscriptions)
        model.restart()
        assertEquals(2, numOfSubscriptions)
    }

    @Test
    fun restartsOnError() {
        var numOfSubscriptions = 0
        val state = Observable.fromCallable<LceState<String>> {
            ++numOfSubscriptions
            LceState.Terminated
        }
        val model = createModel(state, Completable.complete())
        model.initialize()
        model.initialize()
        assertEquals(1, numOfSubscriptions)
        model.dismissError(RuntimeException())
        assertEquals(2, numOfSubscriptions)
    }

    @Test
    fun cleansUpOnCleared() {
        val state = PublishSubject.create<LceState<String>>()
        val refresh = PublishSubject.create<Int>()

        val model = createModel(state, refresh.ignoreElements())
        model.initialize()
        model.refresh()

        assertTrue { state.hasObservers() }
        assertTrue { refresh.hasObservers() }

        model.testOnCleared()

        assertFalse { state.hasObservers() }
        assertFalse { refresh.hasObservers() }
    }
}
