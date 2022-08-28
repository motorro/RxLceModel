/*
 * Copyright 2022 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.rx

import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.cache.entity.EntityValidator
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.lce.LceState.Loading.Type.REFRESHING
import com.motorro.rxlcemodel.rx.service.CacheService
import com.motorro.rxlcemodel.rx.service.NetService
import com.motorro.rxlcemodel.rx.service.ServiceSet
import com.nhaarman.mockitokotlin2.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import org.junit.Test
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

class CacheThenNetLceModelTest {
    companion object {
        private const val PARAMS = "params"

        private val VALID_ENTITY = Entity.Impl(1, EntityValidator.Always)
        private val INVALID_ENTITY = Entity.Impl(2, EntityValidator.Never)
    }

    private lateinit var serviceSet: ServiceSet<Int, String>
    private lateinit var cacheData: Subject<Optional<Entity<Int>>>
    private lateinit var model: CacheThenNetLceModel<Int, String>

    /**
     * Creates test model and service set
     */
    private fun createModel(configure: ServiceConfig<Int>.() -> Unit) {
        val testServiceSet = createServiceSet<Int, Unit, String>(configure)
        serviceSet = testServiceSet
        cacheData = testServiceSet.cacheData
        model = CacheThenNetLceModel(
            PARAMS,
            serviceSet,
            Observable.empty(),
            Schedulers.trampoline(),
            { _, _ -> }
        )
    }

    @Test
    fun willLoadCachedDataAndWontLoadNetIfValid()  {
        createModel {
            cacheInitial = { Optional.of(VALID_ENTITY) }
        }

        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(
            LceState.Content(VALID_ENTITY.data, true)
        )

        with (serviceSet) {
            verify(cache).getData(PARAMS)
        }
    }

    @Test
    fun willStartWithPassedInitialEmission()  {
        val testServiceSet = createServiceSet<Int, Unit, String> {
            cacheInitial = { Optional.of(VALID_ENTITY) }
        }
        serviceSet = testServiceSet
        cacheData = testServiceSet.cacheData
        model = CacheThenNetLceModel(
            PARAMS,
            serviceSet,
            Observable.just(LceState.Loading(null, false)),
            Schedulers.trampoline(),
            { _, _ -> }
        )

        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(
            LceState.Loading(null, false),
            LceState.Content(VALID_ENTITY.data, true)
        )

        with (serviceSet) {
            verify(cache).getData(PARAMS)
        }
    }

    @Test
    fun willLoadCachedDataAndLoadNetIfNoCachedData() {
        createModel {
            cacheInitial = { Optional.empty<Entity<Int>>() }
            netGet = { VALID_ENTITY }
        }

        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(
            LceState.Loading(null, false),
            LceState.Content(VALID_ENTITY.data, true)
        )
        with (serviceSet) {
            verify(cache).getData(PARAMS)
            verify(net).get(PARAMS)
            verify(cache).save(PARAMS, VALID_ENTITY)
        }
    }

    @Test
    fun willLoadCachedDataAndLoadNetIfCacheIsOutdated() {
        createModel {
            cacheInitial = { Optional.of(INVALID_ENTITY) }
            netGet = { VALID_ENTITY }
        }

        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(
            LceState.Loading(INVALID_ENTITY.data, false, REFRESHING),
            LceState.Content(VALID_ENTITY.data, true)
        )
        with (serviceSet) {
            verify(cache).getData(PARAMS)
            verify(net).get(PARAMS)
            verify(cache).save(PARAMS, VALID_ENTITY)
        }
    }

    @Test
    fun willUpdateSubscriberWhenCacheChanges() {
        createModel {
            cacheInitial = { Optional.of(VALID_ENTITY) }
        }

        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(
            LceState.Content(VALID_ENTITY.data, true)
        )

        val newData = 3
        val updatedEntity = VALID_ENTITY.copy(data = newData)
        cacheData.onNext(Optional.of(updatedEntity))
        s.assertValues(
            LceState.Content(VALID_ENTITY.data, true),
            LceState.Content(updatedEntity.data, true)
        )
    }

    @Test
    fun willExplicitlyRefreshData() {
        val updatedEntity = VALID_ENTITY.copy(data = 3)
        createModel {
            cacheInitial = { Optional.of(VALID_ENTITY) }
            netGet = { updatedEntity }
        }
        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(
            LceState.Content(VALID_ENTITY.data, true)
        )

        model.refresh.test().await(100, TimeUnit.MILLISECONDS)
        s.assertValues(
            LceState.Content(VALID_ENTITY.data, true),
            LceState.Loading(VALID_ENTITY.data, true, REFRESHING),
            LceState.Loading(updatedEntity.data, true, REFRESHING),
            LceState.Content(updatedEntity.data, true)
        )

        verify(serviceSet.cache).save(PARAMS, updatedEntity)
    }

    @Test
    fun willReportNetworkErrorOnNoData() {
        val error = IOException("Network error")
        createModel {
            cacheInitial = { Optional.empty<Entity<Int>>() }
            netGet = { throw(error) }
        }
        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(
            LceState.Loading(null, false),
            LceState.Error(null, false, error)
        )
    }

    @Test
    fun willReportNetworkErrorOnRefresh() {
        val error = IOException("Network error")
        createModel {
            cacheInitial = { Optional.of(INVALID_ENTITY) }
            netGet = { throw(error) }
        }
        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(
            LceState.Loading(INVALID_ENTITY.data, false, REFRESHING),
            LceState.Error(INVALID_ENTITY.data, false, error)
        )
    }

    @Test
    fun willResetNetworkStateOnDispose() {
        val serviceSet = object: ServiceSet<Int, String> {
            override val net: NetService<Int, String> = mock()
            override val cache: CacheService<Int, String> = mock()
        }
        whenever(serviceSet.net.get(any())).thenReturn(Single.create { /* Endless wait */ })
        whenever(serviceSet.cache.getData(any())).thenReturn(Observable.just<Optional<Entity<Int>>>(Optional.of(VALID_ENTITY)))

        model = CacheThenNetLceModel(
            PARAMS,
            serviceSet,
            Observable.just(LceState.Loading(null, false)),
            Schedulers.trampoline(),
            { _, _ -> }
        )
        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(
            LceState.Loading(null, false),
            LceState.Content(VALID_ENTITY.data, true)
        )

        val r = model.refresh.test()
        r.assertNoErrors()
        r.assertNotComplete()

        r.dispose()

        s.assertValues(
            LceState.Loading(null, false),
            LceState.Content(VALID_ENTITY.data, true),
            LceState.Loading(VALID_ENTITY.data, true, REFRESHING),
            LceState.Content(VALID_ENTITY.data, true)
        )
    }

    @Test
    fun severalSubscribersShareNetworkOperation() {
        val netValue = PublishSubject.create<Int>()

        val serviceSet = object: ServiceSet<Int, String> {
            override val net: NetService<Int, String> = mock()
            override val cache: CacheService<Int, String> = mock()
        }
        whenever(serviceSet.net.get(any())).thenReturn(
                netValue.firstOrError().map { Entity.Impl(it, EntityValidator.Always) }
        )
        whenever(serviceSet.cache.getData(any())).thenReturn(Observable.just<Optional<Entity<Int>>>(Optional.of(INVALID_ENTITY)))
        whenever(serviceSet.cache.save(any(), any())).thenReturn(Completable.complete())

        model = CacheThenNetLceModel(
            PARAMS,
            serviceSet,
            Observable.empty(),
            Schedulers.trampoline(),
            { _, _ -> }
        )
        val s1 = model.state.test()
        s1.assertNoErrors()
        s1.assertNotComplete()
        s1.assertValues(
            LceState.Loading(INVALID_ENTITY.data, false, REFRESHING)
        )
        val s2 = model.state.test()
        s2.assertNoErrors()
        s2.assertNotComplete()
        s2.assertValues(
            LceState.Loading(INVALID_ENTITY.data, false, REFRESHING)
        )

        netValue.onNext(VALID_ENTITY.data)
        verify(serviceSet.cache, times(1)).save(any(), any())
    }
}