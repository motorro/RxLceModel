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

package com.motorro.rxlcemodel.base

import com.gojuno.koptional.None
import com.gojuno.koptional.Some
import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.entity.EntityValidator
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.base.service.UpdatingNetService
import com.motorro.rxlcemodel.base.service.UpdatingServiceSet
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import org.junit.Test
import java.io.IOException
import kotlin.test.assertEquals

class UpdateWrapperTest {
    companion object {
        private const val PARAMS = "params"

        private val VALID_ENTITY = Entity.Impl(1, EntityValidator.Always)
    }

    private class TestWrapper(upstream: LceModel<Int, String>, serviceSet: UpdatingServiceSet<Int, Int, String>): UpdateWrapper<Int, String>(
        upstream,
        serviceSet.cache,
        Schedulers.trampoline(),
        { _, _ -> }) {
        var updateCallCount = 0
        val callUpdate = doUpdate {
            Completable
                    .fromAction { ++updateCallCount }
                    .andThen(serviceSet.net.update(PARAMS, 0))
        }
    }

    private lateinit var upstream: Subject<LceState<Int>>
    private lateinit var serviceSet: UpdatingServiceSet<Int, Int, String>
    private lateinit var wrapper: TestWrapper

    /**
     * Creates test wrapper and service set
     */
    private fun createWrapper(configure: ServiceConfig<Int>.() -> Unit) {
        upstream = BehaviorSubject.createDefault(LceState.Loading(null, false))
        val upstreamModel = object : LceModel<Int, String> {
            override val state: Observable<LceState<Int>> = upstream
            override val refresh: Completable = Completable.error(UnsupportedOperationException("Should not be executed"))
            override val params: String = PARAMS
        }
        serviceSet = createServiceSet(configure)
        wrapper = TestWrapper(upstreamModel, serviceSet)
    }

    @Test
    fun updatesServerAndCache() {
        createWrapper {
            cacheInitial = { None }
            netUpdate = { VALID_ENTITY }
        }

        wrapper.callUpdate.test().assertComplete().assertNoErrors()
        assertEquals(1, wrapper.updateCallCount)
        verify(serviceSet.cache).save(PARAMS, VALID_ENTITY)
    }

    @Test
    fun transmitsUpstream() {
        createWrapper {
            cacheInitial = { None }
            netUpdate = { VALID_ENTITY }
        }

        val s = wrapper.state.test()
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(LceState.Loading(null, false))

        upstream.onNext(LceState.Content(2, true))
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Content(2, true)
        )
    }

    @Test
    fun combinesSuccessfulLoadingWithUpstreamLoading() {
        createWrapper {
            cacheInitial = { None }
            netUpdate = { VALID_ENTITY }
        }

        val s = wrapper.state.test()
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(LceState.Loading(null, false))

        wrapper.callUpdate.test().assertComplete().assertNoErrors()
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Loading(null, false, LceState.Loading.Type.UPDATING),
                LceState.Loading(null, false)
        )
    }

    @Test
    fun combinesFaultyLoadingWithUpstreamLoading() {
        val error = IOException("Network error")
        createWrapper {
            cacheInitial = { None }
            netUpdate = { throw(error) }
        }

        val s = wrapper.state.test()
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(LceState.Loading(null, false))

        wrapper.callUpdate.test().assertComplete().assertNoErrors()
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Loading(null, false, LceState.Loading.Type.UPDATING),
                LceState.Error(null, false, error)
        )
    }

    @Test
    fun combinesSuccessfulLoadingWithUpstreamContent() {
        createWrapper {
            cacheInitial = { None }
            netUpdate = { VALID_ENTITY }
        }

        val s = wrapper.state.test()
        upstream.onNext(LceState.Content(2, true))
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Content(2, true)
        )

        wrapper.callUpdate.test().assertComplete().assertNoErrors()
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Content(2, true),
                LceState.Loading(2, true, LceState.Loading.Type.UPDATING),
                LceState.Content(2, true)
        )
    }

    @Test
    fun combinesFaultyLoadingWithUpstreamContent() {
        val error = IOException("Network error")
        createWrapper {
            cacheInitial = { None }
            netUpdate = { throw(error) }
        }

        val s = wrapper.state.test()
        upstream.onNext(LceState.Content(2, true))
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Content(2, true)
        )

        wrapper.callUpdate.test().assertComplete().assertNoErrors()
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Content(2, true),
                LceState.Loading(2, true, LceState.Loading.Type.UPDATING),
                LceState.Error(2, true, error)
        )
    }

    @Test
    fun combinesSuccessfulLoadingWithUpstreamError() {
        val error = IOException("Network error")
        createWrapper {
            cacheInitial = { None }
            netUpdate = { VALID_ENTITY }
        }

        val s = wrapper.state.test()
        upstream.onNext(LceState.Error(null, false, error))
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Error(null, false, error)
        )

        wrapper.callUpdate.test().assertComplete().assertNoErrors()
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Error(null, false, error),
                LceState.Loading(null, false, LceState.Loading.Type.UPDATING),
                LceState.Error(null, false, error)
        )
    }

    @Test
    fun combinesFaultyLoadingWithUpstreamError() {
        val error1 = IOException("Network error 1")
        val error2 = IOException("Network error 2")
        createWrapper {
            cacheInitial = { None }
            netUpdate = { throw(error2) }
        }

        val s = wrapper.state.test()
        upstream.onNext(LceState.Error(null, false, error1))
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Error(null, false, error1)
        )

        wrapper.callUpdate.test().assertComplete().assertNoErrors()
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Error(null, false, error1),
                LceState.Loading(null, false, LceState.Loading.Type.UPDATING),
                LceState.Error(null, false, error2)
        )
    }

    @Test
    fun willResetNetworkStateOnDispose() {
        val serviceSet = object: UpdatingServiceSet<Int, Int, String> {
            override val net: UpdatingNetService<Int, Int, String> = mock()
            override val cache: CacheService<Int, String> = mock()
        }
        whenever(serviceSet.net.update(any(), any())).thenReturn(Single.create { /* Endless wait */ })
        whenever(serviceSet.cache.getData(any())).thenReturn(Observable.just(Some(VALID_ENTITY)))
        upstream = BehaviorSubject.createDefault(LceState.Loading(null, false))
        val upstreamModel = object : LceModel<Int, String> {
            override val state: Observable<LceState<Int>> = upstream
            override val refresh: Completable = Completable.error(UnsupportedOperationException("Should not be executed"))
            override val params: String = PARAMS
        }

        wrapper = TestWrapper(upstreamModel, serviceSet)
        val s = wrapper.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(LceState.Loading(null, false))

        val u = wrapper.callUpdate.test()
        u.assertNoErrors()
        u.assertNotComplete()

        u.dispose()

        s.assertValues(
                LceState.Loading(null, false),
                LceState.Loading(null, false, LceState.Loading.Type.UPDATING),
                LceState.Loading(null, false)
        )
    }

    @Test
    fun integratesWithCacheThenNetModel() {
        val updatedEntity = VALID_ENTITY.copy(data = 2)
        val serviceSet = createServiceSet<Int, Int, String> {
            cacheInitial = { None }
            netGet = { VALID_ENTITY }
            netUpdate = { updatedEntity }
        }

        val upstreamModel = LceModel.cacheThenNet(PARAMS, serviceSet, Observable.empty())
        wrapper = TestWrapper(upstreamModel, serviceSet)

        val s = wrapper.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Content(VALID_ENTITY.data, true)
        )

        wrapper.callUpdate.test().assertComplete().assertNoErrors()
        verify(serviceSet.net).update(PARAMS, 0)
        verify(serviceSet.cache).save(PARAMS, updatedEntity)
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                LceState.Loading(null, false),
                LceState.Content(VALID_ENTITY.data, true),
                LceState.Loading(VALID_ENTITY.data, true, LceState.Loading.Type.UPDATING),
                LceState.Loading(updatedEntity.data, true, LceState.Loading.Type.UPDATING),
                LceState.Content(updatedEntity.data, true)
        )
    }
}