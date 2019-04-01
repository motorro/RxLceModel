package com.motorro.rxlcemodel.sample.view.note.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.testOnCleared
import com.nhaarman.mockitokotlin2.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class NoteViewModelTest {
    private lateinit var startState: NoteViewModelState
    private lateinit var model: NoteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        startState = mock()
        model = NoteViewModel(1, startState)
    }

    @Test
    fun setsStartStateOnInitialize() {
        model.initialize()

        verify(startState).master = argThat { 1 == params}
        verify(startState).subscribe()
    }

    @Test
    fun initializesOnce() {
        model.initialize()
        model.initialize()

        verify(startState, times(1)).subscribe()
    }

    @Test
    fun providesStateWithOutLiveData() {
        val state = LceState.Terminated<Note, Int>(0)

        model.initialize()
        val observer: Observer<LceState<Note, Int>> = mock()
        model.state.observeForever(observer)

        argumentCaptor<NoteViewModelStateMaster>().apply {
            verify(startState).master = capture()

            firstValue.out.value = state
        }

        verify(observer).onChanged(state)
    }

    @Test
    fun delegatesMethodsToState() {
        model.initialize()

        model.refresh()
        verify(startState).refresh()

        model.setTitle("title")
        verify(startState).setTitle("title")

        model.setText("text")
        verify(startState).setText("text")

        model.delete()
        verify(startState).delete()
    }

    @Test
    fun changesState() {
        val newState: NoteViewModelState = mock()

        model.initialize()
        argumentCaptor<NoteViewModelStateMaster>().apply {
            verify(startState).master = capture()

            firstValue.setState(newState)
        }

        verify(startState).clear()
        verify(newState).subscribe()
    }

    @Test
    fun clearsStateOnCleared() {
        model.initialize()
        model.testOnCleared()

        verify(startState).clear()
    }

}