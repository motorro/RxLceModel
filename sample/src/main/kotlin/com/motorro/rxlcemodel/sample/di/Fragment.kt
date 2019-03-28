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
import com.motorro.rxlcemodel.sample.view.NoteFragment
import com.motorro.rxlcemodel.sample.view.notelist.NoteListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

/**
 * Component lives as long as fragment is alive
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Module
abstract class NoteListFragmentModule {
    @FragmentScope
    @Binds
    abstract fun viewModelFactory(impl: NoteListViewModel.Factory): ViewModelProvider.Factory
}

@Module
abstract class NoteFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, NoteFragmentModule::class])
    abstract fun noteFragment(): NoteFragment
}