package com.motorro.rxlcemodel.sample.view.note.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
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
import io.reactivex.subjects.PublishSubject
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NoteViewModelStateTest {
    private lateinit var master: NoteViewModelStateMaster
    private lateinit var schedulers: SchedulerRepository
    private lateinit var noteLceModel: NoteLceModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        master = mock {
            on { params } doReturn 1
            on { out } doReturn MutableLiveData()
        }

        schedulers = mock {
            on { io } doReturn Schedulers.trampoline()
            on { computation } doReturn Schedulers.trampoline()
            on { ui } doReturn Schedulers.trampoline()
        }

        noteLceModel = mock()
    }

    private fun createDataState(nextState: NoteViewModelState = mock()) = DataState(
        noteLceModel,
        schedulers,
        nextState
    ).also {
        it.master = this@NoteViewModelStateTest.master
    }

    private fun createDeletionState(deletion: Completable, nextState: NoteViewModelState = mock()) = DeletionState(
        deletion,
        schedulers,
        nextState
    ).also {
        it.master = this@NoteViewModelStateTest.master
    }

    @Test
    fun dataSubscribesLceModelAndTransfersState() {
        val terminated = LceState.Terminated<Note, Int>(0)
        val subject = PublishSubject.create<LceState<Note, Int>>()
        whenever(noteLceModel.state).thenReturn(subject)

        val state = createDataState()
        state.subscribe()
        assertTrue(subject.hasObservers())

        val observer: Observer<LceState<Note, Int>> = mock()
        master.out.observeForever(observer)

        subject.onNext(terminated)
        verify(observer).onChanged(terminated)
    }

    @Test
    fun dataDisposesStateSubscriptionOnClear() {
        val subject = PublishSubject.create<LceState<Note, Int>>()
        whenever(noteLceModel.state).thenReturn(subject)

        val state = createDataState()
        state.subscribe()
        assertTrue(subject.hasObservers())

        state.clear()
        assertFalse(subject.hasObservers())
    }

    @Test
    fun dataDelegatesMethodsToModelIgnoringErrors() {
        val state = createDataState()

        whenever(noteLceModel.refresh).thenReturn(Completable.error(Exception()))
        state.refresh()
        verify(noteLceModel).refresh

        whenever(noteLceModel.setTitle("Title")).thenReturn(Completable.error(Exception()))
        state.setTitle("Title")
        verify(noteLceModel).setTitle("Title")

        whenever(noteLceModel.setText("Text")).thenReturn(Completable.error(Exception()))
        state.setText("Text")
        verify(noteLceModel).setText("Text")
    }

    @Test
    fun dataSetsDeleteStateOnDelete() {
        val deletionState: NoteViewModelState = mock()
        val state = createDataState(deletionState)

        state.delete()
        verify(master).setState(deletionState)
    }

    @Test
    fun deletionExecutesOperationOnSubscribe() {
        val subject = PublishSubject.create<Boolean>()
        val state = createDeletionState(subject.ignoreElements())

        val observer: Observer<LceState<Note, Int>> = mock()
        master.out.observeForever(observer)

        state.subscribe()
        verify(observer).onChanged(LceState.Loading(null, false, 1, LceState.Loading.Type.LOADING))
    }

    @Test
    fun deletionTransmitsErrorStateOnError() {
        val error = Exception("error")
        val subject = PublishSubject.create<Boolean>()
        val state = createDeletionState(subject.ignoreElements())

        val observer: Observer<LceState<Note, Int>> = mock()
        master.out.observeForever(observer)

        state.subscribe()
        verify(observer).onChanged(LceState.Loading(null, false, 1, LceState.Loading.Type.LOADING))

        subject.onError(error)
        verify(observer).onChanged(LceState.Error(null, false, 1, error))
    }

    @Test
    fun deletionSwitchesToNextStateOnComplete() {
        val deletedState: NoteViewModelState = mock()

        val subject = PublishSubject.create<Boolean>()
        val state = createDeletionState(subject.ignoreElements(), deletedState)

        val observer: Observer<LceState<Note, Int>> = mock()
        master.out.observeForever(observer)

        state.subscribe()
        verify(observer).onChanged(LceState.Loading(null, false, 1, LceState.Loading.Type.LOADING))

        subject.onComplete()
        verify(master).setState(deletedState)
    }

    @Test
    fun deletedTransmitsTerminated() {
        val state = DeletedState()
        state.master = master

        val observer: Observer<LceState<Note, Int>> = mock()
        master.out.observeForever(observer)

        state.subscribe()
        verify(observer).onChanged(LceState.Terminated(1))
    }
}