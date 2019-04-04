package com.motorro.rxlcemodel.sample.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.sample.testOnCleared
import com.motorro.rxlcemodel.sample.view.BaseLceModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BaseLceModelTest {
    private fun createModel(stateObservable: Observable<LceState<String, Int>>, refresh: Completable): BaseLceModel<String, Int> =
        BaseLceModel.Impl(
            stateObservable,
            refresh
        )

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun initializesOnce() {
        var numOfSubscriptions = 0
        val state = Observable.fromCallable<LceState<String, Int>> {
            ++numOfSubscriptions
            LceState.Terminated(0)
        }

        val model = createModel(state, Completable.complete())
        model.initialize()
        model.initialize()
        assertEquals(1, numOfSubscriptions)
    }

    @Test
    fun transmitsState() {
        val state = LceState.Terminated<String, Int>(0)

        val observer: Observer<LceState<String, Int>> = mock()
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
    fun ignoresRefreshErrors() {
        val refresh = Completable.error(Exception())

        val model = createModel(Observable.empty(), refresh)
        model.refresh()
    }

    @Test
    fun cleansUpOnCleared() {
        val state = PublishSubject.create<LceState<String, Int>>()
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