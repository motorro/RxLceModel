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

package com.motorro.rxlcemodel.sample.view.notelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.toLiveData
import com.motorro.rxlcemodel.base.LceModel
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.base.service.NetService
import com.motorro.rxlcemodel.base.service.ServiceSet
import com.motorro.rxlcemodel.sample.di.FragmentScope
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import com.motorro.rxlcemodel.sample.view.notelist.NoteListViewModel.Factory
import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * LiveData for user list
 * As no parameters are required to load state the underlying [LceModel.state] is being set-up and converted to
 * live-data in [Factory], while each refresh operation is subscribed separately.
 */

class NoteListViewModel (val state: LiveData<LceState<NoteList, Unit>>, private val refresh: Completable): ViewModel() {
    /**
     * Maintains refresh subscriptions
     */
    private val disposables = CompositeDisposable()

    /**
     * Requests data refresh
     * Errors are ignored as they are transmitted through [state] property
     */
    fun refresh() {
        disposables.add(refresh.onErrorComplete().subscribe())
    }

    /**
     * Disposes active operations when model is destroyed
     * The state subscription is implemented using androidx converter
     */
    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    @FragmentScope
    class Factory @Inject constructor(
        listNetService: @JvmSuppressWildcards NetService<NoteList, Unit>,
        listCacheService: @JvmSuppressWildcards CacheService<NoteList, Unit>,
        private val schedulers: SchedulerRepository
    ): ViewModelProvider.Factory {
        /**
         * A service-set for [LceModel]
         */
        private val serviceSet = object : ServiceSet<NoteList, Unit> {
            override val net: NetService<NoteList, Unit> = listNetService
            override val cache: CacheService<NoteList, Unit> = listCacheService
        }

        /**
         * Creates [LceModel]
         */
        private fun createLceModel() = LceModel.cacheThanNet(
            params = Unit,
            serviceSet = serviceSet,
            startWith = Observable.empty() // To not to show loader when cache has data
        )

        /**
         * Creates state live-data
         */
        private fun LceModel<NoteList, Unit>.createStateLiveData() =
            state
                .subscribeOn(schedulers.io)
                .observeOn(schedulers.ui)
                .toFlowable(BackpressureStrategy.LATEST)
                .toLiveData()

        /**
         * Sets-up refresh operation
         */
        private fun LceModel<NoteList, Unit>.setupRefresh() =
            refresh
                .subscribeOn(schedulers.io)
                .observeOn(schedulers.ui)

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val lceModel = createLceModel()
            return NoteListViewModel(lceModel.createStateLiveData(), lceModel.setupRefresh()) as T
        }
    }
}
