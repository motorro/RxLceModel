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

package com.motorro.rxlcemodel.sample.view.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.motorro.rxlcemodel.base.LceModel
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.base.service.NetService
import com.motorro.rxlcemodel.sample.di.NoteFragmentModule.Companion.NOTE_ID
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.utils.BaseLceModel
import com.motorro.rxlcemodel.sample.utils.BaseLceModelFactory
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Named


class NoteViewModel(state: LiveData<LceState<Note, Int>>, refresh: Completable): BaseLceModel<Note, Int>(state, refresh) {
    /**
     * View-model factory that binds parameters from module
     * Other variants to create parametrized [LceModel]:
     * - update params in a factory instance if a shared factory is used
     * - create [LceModel] in a [ViewModel] on parameters change
     *   e.g. [Transforming LiveData](https://developer.android.com/topic/libraries/architecture/livedata#transform_livedata)
     */
    class Factory @Inject constructor(
        @Named(NOTE_ID) override val params: Int,
        netService: @JvmSuppressWildcards NetService<Note, Int>,
        cacheService: @JvmSuppressWildcards CacheService<Note, Int>,
        schedulers: SchedulerRepository
    ): BaseLceModelFactory<Note, Int>(netService, cacheService, schedulers) {
        /**
         * Model factory function
         */
        override fun createModel(lceModel: LceModel<Note, Int>): ViewModel = NoteViewModel(
            lceModel.createStateLiveData(),
            lceModel.setupRefresh()
        )
    }
}