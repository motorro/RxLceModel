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

import com.motorro.rxlcemodel.sample.view.MainActivity
import com.motorro.rxlcemodel.sample.view.note.NoteFragment
import com.motorro.rxlcemodel.sample.view.notelist.NoteListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

/**
 * Component lives as long as activity is alive
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}

@Module(includes = [CacheModule::class])
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [NoteListFragmentModule::class])
    abstract fun noteListFragment(): NoteListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [NoteFragmentModule::class])
    abstract fun noteFragment(): NoteFragment
}
