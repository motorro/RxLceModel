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
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.motorro.rxlcemodel.sample.R
import com.motorro.rxlcemodel.sample.service.CacheManager
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var cacheManager: CacheManager

    /**
     * Returns an [AndroidInjector] of [Fragment]s.
     */
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    /**
     * Destroys cache when activity is destroyed to illustrate cache management.
     * @see com.motorro.rxlcemodel.sample.service.CacheManager
     * @see com.motorro.rxlcemodel.sample.di.CacheModule
     */
    override fun onDestroy() {
        super.onDestroy()
        cacheManager.delete()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(nav_host_fragment).navigateUp()
}
