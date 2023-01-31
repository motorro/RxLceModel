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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.rx.LceUseCase
import com.motorro.rxlcemodel.sample.di.FragmentScope
import com.motorro.rxlcemodel.sample.service.usecase.AddNote
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import com.motorro.rxlcemodel.viewmodel.BaseLceModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * Adds notes manually generating [LceState] for UI
 */
class AddNoteViewModel(private val addNote: (String, String) -> Completable): BaseLceModel.WithUpdates<Unit>(DUMMY_USE_CASE) {
    private companion object {
        val DUMMY_USE_CASE = object : LceUseCase<Unit> {
            override val state: Observable<LceState<Unit>> = Observable.just(LceState.Content(Unit, true))
            override val refresh: Completable = Completable.complete()
        }
    }

    /**
     * Adds new Note
     */
    fun add(title: String, text: String) {
        runUpdate(addNote(title, text), true)
    }

    @FragmentScope
    class Factory @Inject constructor(addNote: AddNote, schedulers: SchedulerRepository): ViewModelProvider.Factory {

        private val addNoteOperation = { title: String, text: String ->
            addNote.add(title, text)
                .subscribeOn(schedulers.io)
                .observeOn(schedulers.ui)
        }

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T  = AddNoteViewModel(addNoteOperation) as T
    }
}