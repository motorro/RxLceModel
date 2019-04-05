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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.sample.di.FragmentScope
import com.motorro.rxlcemodel.sample.service.usecase.AddNote
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import com.motorro.rxlcemodel.sample.view.BaseLceModel
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Adds notes manually generating [LceState] for UI
 */
class AddNoteViewModel(private val addNote: (String, String) -> Completable): BaseLceModel<Unit, Unit>() {
    /**
     * State live-data
     */
    private val stateData = MutableLiveData<LceState<Unit, Unit>>()

    /**
     * LCE State
     */
    override val state: LiveData<LceState<Unit, Unit>>
        get() = stateData

    /**
     * Call this function to initialize a new model and start receiving events
     */
    override fun doInitialize() {
        stateData.value = LceState.Content(Unit, true, Unit)
    }

    /**
     * Requests data refresh
     */
    override fun refresh() = Unit

    /**
     * Adds new Note
     */
    fun add(title: String, text: String) {
        val subscription = addNote(title, text)
            .toObservable<LceState<Unit, Unit>>()
            .startWith(LceState.Loading(null, false, Unit, LceState.Loading.Type.LOADING))
            .onErrorReturn { LceState.Error(null, false, Unit, it) }
            .concatWith(Observable.just(LceState.Terminated(Unit)))
            .subscribe(
                { state -> stateData.value = state},
                { error -> throw error }
            )

        disposables.add(subscription)
    }

    @FragmentScope
    class Factory @Inject constructor(addNote: AddNote, schedulers: SchedulerRepository): ViewModelProvider.Factory {

        private val addNoteOperation = { title: String, text: String ->
            addNote.add(title, text)
                .subscribeOn(schedulers.io)
                .observeOn(schedulers.ui)
        }

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T  = AddNoteViewModel(addNoteOperation) as T
    }
}