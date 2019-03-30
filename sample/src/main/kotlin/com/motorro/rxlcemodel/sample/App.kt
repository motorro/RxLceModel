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

package com.motorro.rxlcemodel.sample

import android.app.Activity
import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.motorro.rxlcemodel.sample.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class App: Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    /**
     * Returns an [AndroidInjector] of [Activity]s.
     */
    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    /**
     * Creates Dagger application component and injects application
     */
    private fun inject() = DaggerApplicationComponent
        .builder()
        .create(this)
        .inject(this)

    /**
     * Sets-up console logging
     */
    private fun setupLogger() {
        Timber.plant(Timber.DebugTree())
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        inject()
        setupLogger()
        Timber.d("Application started")
    }
}