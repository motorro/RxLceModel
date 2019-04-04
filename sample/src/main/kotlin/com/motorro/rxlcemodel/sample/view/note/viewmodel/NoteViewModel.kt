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

package com.motorro.rxlcemodel.sample.view.note.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.motorro.rxlcemodel.base.LceModel
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.base.UpdateWrapper
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.base.service.NetService
import com.motorro.rxlcemodel.sample.di.FragmentScope
import com.motorro.rxlcemodel.sample.di.NoteFragmentModule.Companion.NOTE_ID
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.service.usecase.DeleteNote
import com.motorro.rxlcemodel.sample.service.usecase.PatchNoteText
import com.motorro.rxlcemodel.sample.service.usecase.PatchNoteTitle
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import com.motorro.rxlcemodel.sample.view.BaseLceModel
import com.motorro.rxlcemodel.sample.view.BaseLceModelFactory
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Named

/**
 * The model that
 * - Displays note
 * - Updates note
 * - Deletes notes
 */
class NoteViewModel(noteId: Int, private val startState: NoteViewModelState): BaseLceModel<Note, Int>() {
    /**
     * Current model
     */
    private lateinit var modelState: NoteViewModelState

    /**
     * Interacts with a current model state
     */
    private val stateMaster = object: NoteViewModelStateMaster {
        /**
         * Params used to load data
         */
        override val params: Int = noteId

        /**
         * A live-data that exports a state to client
         */
        override val out: MutableLiveData<LceState<Note, Int>> = MutableLiveData()

        /**
         * Sets and initializes new state
         */
        fun setNewState(newState: NoteViewModelState) {
            modelState = newState
            modelState.master = this
            modelState.subscribe()
        }

        /**
         * Sets new state
         */
        override fun setState(newState: NoteViewModelState) {
            modelState.clear()
            setNewState(newState)
        }
    }

    /**
     * Call this function to initialize a new model and start receiving events
     */
    override fun doInitialize() {
        if (initialized) {
            return
        }

        stateMaster.setNewState(startState)
    }

    /**
     * LCE State
     */
    override val state: LiveData<LceState<Note, Int>>
        get() = stateMaster.out

    /**
     * Requests data refresh
     * Errors are ignored as they are transmitted through [state] property
     */
    override fun refresh() = modelState.refresh()

    /**
     * Updates note title
     */
    fun setTitle(title: String) = modelState.setTitle(title)

    /**
     * Updates note text
     */
    fun setText(text: String) = modelState.setText(text)

    /**
     * Deletes note
     */
    fun delete() = modelState.delete()

    /**
     * Disposes active operations when model is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        modelState.clear()
    }


    /**
     * View-model factory that binds parameters from module
     * Other variants to create parametrized [LceModel]:
     * - update params in a factory instance if a shared factory is used
     * - create [LceModel] in a [ViewModel] on parameters change
     *   e.g. [Transforming LiveData](https://developer.android.com/topic/libraries/architecture/livedata#transform_livedata)
     */
    @FragmentScope
    class Factory @Inject constructor(
        @Named(NOTE_ID) override val params: Int,
        netService: @JvmSuppressWildcards NetService<Note, Int>,
        cacheService: @JvmSuppressWildcards CacheService<Note, Int>,
        private val patchNoteTitle: PatchNoteTitle,
        private val patchNoteText: PatchNoteText,
        private val deleteNote: DeleteNote,
        schedulers: SchedulerRepository
    ): BaseLceModelFactory<Note, Int>(netService, cacheService, schedulers) {
        /**
         * Creates a wrapper with update operations
         */
        private fun createUpdateWrapper(upstream: LceModel<Note, Int>) =
            NoteUpdateWrapper(
                upstream,
                cacheService,
                patchNoteTitle,
                patchNoteText
            )

        /**
         * Creates delete completable
         */
        private fun createDeleteNote() = deleteNote.delete(params)

        /**
         * Creates `Deleted` state
         */
        private fun createDeletedState(): NoteViewModelState = DeletedState()

        /**
         * Creates `Deletion` state
         */
        private fun createDeletionState(): NoteViewModelState = DeletionState(
            deleteNote = createDeleteNote(),
            schedulers = schedulers,
            deletedState = createDeletedState()
        )

        /**
         * Creates `Data` state
         */
        private fun createDataState(): NoteViewModelState = DataState(
            lceModel = createUpdateWrapper(createLceModel()),
            schedulers = schedulers,
            deletionState = createDeletionState()
        )

        /**
         * Model factory function
         */
        override fun createModel(lceModel: LceModel<Note, Int>): ViewModel = NoteViewModel(
            noteId = params,
            startState = createDataState()
        )
    }
}

/**
 * Interface for
 */
interface   NoteLceModel: LceModel<Note, Int> {
    /**
     * Updates note title
     */
    fun setTitle(title: String): Completable

    /**
     * Updates note text
     */
    fun setText(text: String): Completable
}

/**
 * A wrapper of [upstream] with update operations
 */
private class NoteUpdateWrapper(
    private val upstream: LceModel<Note, Int>,
    cacheService: CacheService<Note, Int>,
    private val patchNoteTitle: PatchNoteTitle,
    private val patchNoteText: PatchNoteText
) : UpdateWrapper<Note, Int>(upstream, cacheService), NoteLceModel {
    /**
     * Updates note title
     */
    override fun setTitle(title: String): Completable = doUpdate {
        patchNoteTitle.setTitle(upstream.params, title)
    }

    /**
     * Updates note text
     */
    override fun setText(text: String): Completable = doUpdate {
        patchNoteText.setText(upstream.params, text)
    }
}
