package com.motorro.rxlcemodel.sample.view.note.viewmodel

import androidx.lifecycle.MutableLiveData
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

/**
 * State container
 */
interface NoteViewModelStateMaster {
    /**
     * Params used to load data
     */
    val params: Int

    /**
     * A live-data that exports a state to client
     */
    val out: MutableLiveData<LceState<Note, Int>>

    /**
     * Sets new state
     */
    fun setState(newState: NoteViewModelState)
}

/**
 * View-model internal state
 */
interface NoteViewModelState {
    /**
     * State master
     */
    var master: NoteViewModelStateMaster

    /**
     * Refresh model data
     */
    fun refresh() = Unit

    /**
     * Updates note title
     */
    fun setTitle(title: String) = Unit

    /**
     * Updates note text
     */
    fun setText(text: String) = Unit

    /**
     * Deletes note
     */
    fun delete() = Unit

    /**
     * Client subscribed model
     */
    fun subscribe()

    /**
     * Called to clean-up internal state
     */
    fun clear()
}

/**
 * State to operate model data
 */
class DataState(
    private val lceModel: NoteLceModel,
    private val schedulers: SchedulerRepository,
    private val deletionState: NoteViewModelState
): NoteViewModelState {
    /**
     * State master
     */
    override lateinit var master: NoteViewModelStateMaster

    /**
     * Maintains operation subscriptions
     */
    private val disposables = CompositeDisposable()

    /**
     * Applies schedulers and ignores errors - a common way to handle [lceModel] operations
     */
    private fun Completable.prepare(): Completable =
        subscribeOn(schedulers.io).observeOn(schedulers.ui).onErrorComplete()

    /**
     * Starts operation
     */
    private fun Completable.execute() {
        disposables.add(this.prepare().subscribe())
    }

    /**
     * Requests data refresh
     */
    override fun refresh() = lceModel.refresh.execute()

    /**
     * Updates note title
     */
    override fun setTitle(title: String) = lceModel.setTitle(title).execute()

    /**
     * Updates note text
     */
    override fun setText(text: String) = lceModel.setText(text).execute()

    /**
     * Client subscribed model
     */
    override fun subscribe() {
        val subscription = lceModel
            .state
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.ui)
            .subscribe(
                { state -> master.out.value = state},
                { error -> throw error }
            )

        disposables.add(subscription)
    }

    /**
     * Disposes active operations when model is destroyed
     */
    override fun clear() = disposables.clear()

    /**
     * Deletes note
     */
    override fun delete() = master.setState(deletionState)
}

/**
 * State to delete note
 */
class DeletionState(
    private val deleteNote: Completable,
    private val schedulers: SchedulerRepository,
    private val deletedState: NoteViewModelState
): NoteViewModelState {
    /**
     * State master
     */
    override lateinit var master: NoteViewModelStateMaster

    /**
     * Maintains operation subscriptions
     */
    private val disposables = CompositeDisposable()

    /**
     * Deletes note transmitting operation state through [master]
     * When operation is complete transfers to [deletedState]
     * @see subscribe
     */
    private fun getDeleteOperation() = deleteNote
        .toObservable<LceState<Note, Int>>()
        .onErrorReturn { LceState.Error(null, false, master.params, it) }
        .startWith(LceState.Loading(null, false, master.params, LceState.Loading.Type.UPDATING))

    /**
     * Client subscribed model
     */
    override fun subscribe() {
        val subscription = getDeleteOperation()
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.ui)
            .subscribe(
                { state -> master.out.value = state},
                { error -> throw error },
                { master.setState(deletedState) }
            )

        disposables.add(subscription)
    }

    /**
     * A quick-fix for deletion retry although in real life
     * the one should prefer more sophisticated solution
     * @see com.motorro.rxlcemodel.sample.view.note.NoteFragment.onErrorClick
     */
    override fun refresh() = subscribe()

    /**
     * Called to clean-up internal state
     */
    override fun clear() = disposables.clear()
}

/**
 * The final state that represents deleted note
 */
class DeletedState : NoteViewModelState {
    /**
     * State master
     */
    override lateinit var master: NoteViewModelStateMaster
    /**
     * Client subscribed model
     */
    override fun subscribe() {
        master.out.value = (LceState.Terminated(master.params))
    }

    /**
     * Called to clean-up internal state
     */
    override fun clear() = Unit
}

