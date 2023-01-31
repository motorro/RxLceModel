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

import android.content.Context
import androidx.lifecycle.ViewModel
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.rx.LceModel
import com.motorro.rxlcemodel.rx.UpdateWrapper
import com.motorro.rxlcemodel.rx.service.CacheService
import com.motorro.rxlcemodel.rx.service.NetService
import com.motorro.rxlcemodel.sample.di.FragmentScope
import com.motorro.rxlcemodel.sample.di.NoteFragmentModule.Companion.NOTE_ID
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.service.usecase.DeleteWorker
import com.motorro.rxlcemodel.sample.service.usecase.PatchNoteText
import com.motorro.rxlcemodel.sample.service.usecase.PatchNoteTitle
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import com.motorro.rxlcemodel.sample.view.BaseLceModelFactory
import com.motorro.rxlcemodel.viewmodel.BaseLceModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Named

/**
 * The model that:
 * - Displays note
 * - Updates note
 * - Deletes notes using work manager to demonstrate data updates from non-visual components
 * Model uses [NoteUpdateWrapper] descendant to demonstrate several update operations for data
 * (like PATCHing requests in HTTP APIs). If PUTing a whole data structure on server is enough
 * [com.motorro.rxlcemodel.rx.UpdatingLceModel] is a simpler choice
 */
class NoteViewModel(
    private val noteId: Int,
    private val lceModel: NoteLceModel,
    private val schedulers: SchedulerRepository,
    private val scheduleDelete: (Int) -> Unit
): BaseLceModel.Impl<Note>() {
    /**
     * Terminates model
     * @see delete
     */
    private val termination = PublishSubject.create<Unit>()

    /**
     * State observable
     */
    override val stateObservable: Observable<LceState<Note>> =
        lceModel.state
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.ui)
            .takeUntil(termination)
            .concatWith(Single.just(LceState.Terminated))
            .distinctUntilChanged()

    /**
     * Refresh command
     */
    override val refresh: Completable =
        lceModel.refresh.subscribeOn(schedulers.io).observeOn(schedulers.ui)

    /**
     * Applies schedulers and ignores errors - a common way to handle [lceModel] operations
     */
    private fun Completable.prepare(): Completable =
        subscribeOn(schedulers.io).observeOn(schedulers.ui).onErrorComplete()

    /**
     * Updates note title
     */
    fun setTitle(title: String) {
        addSubscription(lceModel.setTitle(title).prepare())
    }

    /**
     * Updates note text
     */
    fun setText(text: String) {
        addSubscription(lceModel.setText(text).prepare())
    }

    /**
     * Deletes note
     */
    fun delete() {
        // Terminate model
        termination.onNext(Unit)
        // Delete note
        scheduleDelete(noteId)
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
        private val context: Context,
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
         * Model factory function
         */
        override fun createModel(lceModel: LceModel<Note, Int>): ViewModel =
            NoteViewModel(
                noteId = params,
                lceModel = createUpdateWrapper(createLceModel()),
                schedulers = schedulers,
                scheduleDelete = { DeleteWorker.execute(context, it) }
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
) : UpdateWrapper<Note, Int>(upstream, cacheService, Schedulers.trampoline(), { _, _ -> }), NoteLceModel {
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
