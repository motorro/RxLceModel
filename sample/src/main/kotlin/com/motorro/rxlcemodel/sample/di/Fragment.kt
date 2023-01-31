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

package com.motorro.rxlcemodel.sample.di

import androidx.lifecycle.ViewModelProvider
import com.motorro.rxlcemodel.rx.service.CacheService
import com.motorro.rxlcemodel.rx.service.NetService
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import com.motorro.rxlcemodel.sample.view.BaseLceModelFactory
import com.motorro.rxlcemodel.sample.view.addnote.AddNoteViewModel
import com.motorro.rxlcemodel.sample.view.note.NoteFragment
import com.motorro.rxlcemodel.sample.view.note.NoteViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Scope

/**
 * Component lives as long as fragment is alive
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Module
class NoteListFragmentModule {
    @FragmentScope
    @Provides
    fun viewModelFactory(
        netService: @JvmSuppressWildcards NetService<NoteList, Unit>,
        cacheService: @JvmSuppressWildcards CacheService<NoteList, Unit>,
        schedulers: SchedulerRepository
    ): ViewModelProvider.Factory = object : BaseLceModelFactory<NoteList, Unit>(netService, cacheService, schedulers) {
        /**
         * Bound params
         */
        override val params: Unit = Unit
    }
}

@Module
class NoteFragmentModule {
    companion object {
        const val NOTE_ID = "noteId"
    }

    @FragmentScope
    @Provides
    @Named(NOTE_ID)
    fun noteId(noteFragment: NoteFragment): Int = noteFragment.noteId

    @FragmentScope
    @Provides
    fun viewModelFactory(impl: NoteViewModel.Factory): ViewModelProvider.Factory = impl
}

@Module
class AddNoteFragmentModule {
    @FragmentScope
    @Provides
    fun viewModelFactory(impl: AddNoteViewModel.Factory): ViewModelProvider.Factory = impl
}

