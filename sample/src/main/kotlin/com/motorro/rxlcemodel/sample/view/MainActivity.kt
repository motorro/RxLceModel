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

package com.motorro.rxlcemodel.sample.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.motorro.rxlcemodel.sample.R
import com.motorro.rxlcemodel.sample.service.CacheManager
import com.motorro.rxlcemodel.sample.service.usecase.DeleteWorker
import com.motorro.rxlcemodel.sample.utils.ConnectionChecker
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var cacheManager: CacheManager

    @Inject
    lateinit var connectionChecker: ConnectionChecker

    /**
     * Returns an [AndroidInjector].
     */
    override fun androidInjector(): AndroidInjector<Any> = fragmentInjector

    /**
     * Destroys cache when activity is destroyed to illustrate cache management.
     * @see com.motorro.rxlcemodel.sample.service.CacheManager
     * @see com.motorro.rxlcemodel.sample.di.CacheModule
     */
    override fun onDestroy() {
        super.onDestroy()
        //cacheManager.delete()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupConnectionSwitch()
        setupDeleteListener()
        setSupportActionBar(toolbar)
        setupNavigation()
    }

    /**
     * A duct-tape to emulate network disconnection
     */
    private fun setupConnectionSwitch() {
        connection_state.isChecked = connectionChecker.getStatus()
        connection_state.setOnCheckedChangeListener { _, isChecked ->  connectionChecker.setStatus(isChecked) }
    }

    /**
     * Notes are deleted using [WorkManager] to illustrate data updates from non-visual components
     */
    private fun setupDeleteListener() {
        WorkManager.getInstance(applicationContext).getWorkInfosByTagLiveData(DeleteWorker.TAG).observe(this, Observer<List<WorkInfo>> { workInfo ->
            if (workInfo.isNullOrEmpty()){
                return@Observer
            }

            val message: String? = when {
                workInfo.any { WorkInfo.State.SUCCEEDED == it.state } -> "Note deleted"
                workInfo.any { WorkInfo.State.FAILED == it.state } -> "Failed to delete note"
                else -> null
            }
            if (null != message) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }

            WorkManager.getInstance(applicationContext).pruneWork()
        })
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}
