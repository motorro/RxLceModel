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

import android.content.Context
import com.motorro.rxlcemodel.base.service.NetService
import com.motorro.rxlcemodel.sample.App
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.service.FakeServer
import com.motorro.rxlcemodel.sample.service.NetRepository
import com.motorro.rxlcemodel.sample.service.usecase.NoteListNetService
import com.motorro.rxlcemodel.sample.service.usecase.NoteNetService
import com.motorro.rxlcemodel.sample.utils.ConnectionChecker
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton



@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityModule::class])
interface ApplicationComponent: AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}

@Module(includes = [ServiceModule::class, CacheConfigModule::class])
/**
 * Provides common application parts
 */
class ApplicationModule {
    /**
     * Application context
     */
    @Singleton
    @Provides
    fun context(app: App): Context = app.applicationContext

    /**
     * Provides schedulers
     */
    @Singleton
    @Provides
    fun schedulers(): SchedulerRepository = object : SchedulerRepository {
        override val io: Scheduler = Schedulers.io()
        override val ui: Scheduler = AndroidSchedulers.mainThread()
        override val computation: Scheduler = Schedulers.computation()
    }

    /**
     * Fake connection checker to emulate IO errors
     */
    @Singleton
    @Provides
    fun connectionChecker(): ConnectionChecker = ConnectionChecker()

    /**
     * Provides a fake server to emulate network data
     */
    @Singleton
    @Provides
    fun netRepository(schedulers: SchedulerRepository): NetRepository = FakeServer(schedulers)
}

@Module
abstract class ServiceModule {
    @Singleton
    @Binds
    abstract fun noteListNetService(impl: NoteListNetService): NetService<NoteList, Unit>

    @Singleton
    @Binds
    abstract fun noteNetService(impl: NoteNetService): NetService<Note, Int>
}

