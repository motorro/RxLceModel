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

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.motorro.rxlcemodel.sample.di.ApplicationComponent
import com.motorro.rxlcemodel.sample.di.DaggerApplicationComponent
import com.motorro.rxlcemodel.sample.di.ProvidesApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber
import java.io.IOException
import java.net.SocketException
import javax.inject.Inject

class App: Application(), HasAndroidInjector, ProvidesApplicationComponent {
    /**
     * Application component
     */
    override lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    /**
     * Returns an AndroidInjector
     */
    override fun androidInjector(): AndroidInjector<Any> = activityInjector

    /**
     * Creates Dagger application component and injects application
     */
    private fun inject() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()

        applicationComponent.inject(this)
    }

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
        setRxErrorHook()
    }

    /**
     * Sets Rx error handler:
     * See "error handling" section here:
     * https://github.com/ReactiveX/RxJava/wiki/What%27s-different-in-2.0
     */
    private fun setRxErrorHook() {
        RxJavaPlugins.setErrorHandler {
            val error: Throwable = if (it is UndeliverableException) (it.cause ?: it) else it
            fun noteException(errorToNote: Throwable) {
                Timber.w(errorToNote, "Unhandled Rx warning:")
            }
            fun pipelineException(errorToPipeline: Throwable) {
                Timber.e(errorToPipeline, "Fatal error:")
                throw errorToPipeline
            }
            when(error) {
                // fine, some blocking code was interrupted by a dispose call
                is InterruptedException -> noteException(error)
                // fine, irrelevant network problem or API that throws on cancellation
                else -> pipelineException(error)
            }
        }
    }
}