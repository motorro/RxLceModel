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

package com.motorro.rxlcemodel.base.service

import com.gojuno.koptional.None
import com.gojuno.koptional.Some
import com.motorro.rxlcemodel.base.LceModel
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.entity.EntityValidator
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import java.util.*
import kotlin.collections.HashMap

class SyncDelegateCacheServiceTest {
    companion object {
        private const val PARAMS_1 = "params1"
        private const val PARAMS_2 = "params2"
        private val VALID_ENTITY = Entity.Impl("data", EntityValidator.Always)
    }
    
    private lateinit var cacheDelegate: SyncDelegateCacheService.Delegate<String, String>
    private lateinit var service: SyncDelegateCacheService<String, String>

    @Before
    fun init() {
        cacheDelegate = mock()
        service = SyncDelegateCacheService(cacheDelegate)
    }

    @Test
    fun getsInitialFromDelegate() {
        whenever(cacheDelegate.get(any())).thenReturn(null)

        val s = service.getData(PARAMS_1).test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)
        verify(cacheDelegate).get(PARAMS_1)
    }

    @Test
    fun failsToGetEntityIfDelegateFails() {
        val error = Exception("Error")
        whenever(cacheDelegate.get(any())).thenAnswer {
            throw error
        }

        service.getData(PARAMS_1).test().assertError(error)
    }

    @Test
    fun savesEntityAndUpdatesFromDelegate() {
        whenever(cacheDelegate.get(any()))
                .thenReturn(null)
                .thenReturn(VALID_ENTITY)

        val s = service.getData(PARAMS_1).test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)
        verify(cacheDelegate).get(PARAMS_1)

        service.save(PARAMS_1, VALID_ENTITY).test().assertComplete()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None, Some(VALID_ENTITY))
        verify(cacheDelegate).save(PARAMS_1, VALID_ENTITY)
        verify(cacheDelegate, times(2)).get(PARAMS_1)
    }

    @Test
    fun failsToSaveEntityIfDelegateFails() {
        val error = Exception("Error")
        whenever(cacheDelegate.get(any())).thenReturn(null)
        whenever(cacheDelegate.save(any(), any())).thenAnswer {
            throw error
        }
        val s = service.getData(PARAMS_1).test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)

        service.save(PARAMS_1, VALID_ENTITY).test().assertError(error)
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)
    }

    @Test
    fun invalidatesCacheAndAndUpdatesFromDelegate() {
        whenever(cacheDelegate.get(any())).thenReturn(null)

        val s = service.getData(PARAMS_1).test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)
        verify(cacheDelegate).get(PARAMS_1)

        service.invalidate(PARAMS_1).test().assertComplete()
        verify(cacheDelegate).invalidate(PARAMS_1)

        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)
        verify(cacheDelegate, times(2)).get(PARAMS_1)
    }

    @Test
    fun failsToInvalidateCacheIfDelegateFails() {
        val error = Exception("Error")
        whenever(cacheDelegate.invalidate(any())).thenAnswer {
            throw error
        }

        val s = service.getData(PARAMS_1).test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)

        service.invalidate(PARAMS_1).test().assertError(error)
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)
        verify(cacheDelegate, times(1)).get(PARAMS_1)
    }

    @Test
    fun invalidatesAllCache() {
        whenever(cacheDelegate.get(any())).thenReturn(null)

        val params = listOf(PARAMS_1, PARAMS_2)
        val subscribers = params.map {
            it to service.getData(it).test()
        }

        subscribers.forEach { (params, s) ->
            s.assertNoErrors()
            s.assertNotComplete()
            s.assertValues(None)
            verify(cacheDelegate).get(params)
        }

        service.invalidateAll.test().assertComplete()
        verify(cacheDelegate).invalidateAll()

        subscribers.forEach { (params, s) ->
            s.assertNoErrors()
            s.assertNotComplete()
            s.assertValues(None)
            verify(cacheDelegate, times(2)).get(params)
        }
    }

    @Test
    fun failsToInvalidateAllCacheIfDelegateFails() {
        val error = Exception("Error")
        whenever(cacheDelegate.invalidateAll()).thenAnswer {
            throw error
        }

        val params = listOf(PARAMS_1, PARAMS_2)
        val subscribers = params.map {
            it to service.getData(it).test()
        }

        subscribers.forEach { (params, s) ->
            s.assertNoErrors()
            s.assertNotComplete()
            s.assertValues(None)
            verify(cacheDelegate).get(params)
        }

        service.invalidateAll.test().assertError(error)
        verify(cacheDelegate).invalidateAll()

        subscribers.forEach { (params, s) ->
            s.assertNoErrors()
            s.assertNotComplete()
            s.assertValues(None)
            verify(cacheDelegate, times(1)).get(params)
        }
    }

    @Test
    fun deletesCacheAndAndUpdatesFromDelegate() {
        whenever(cacheDelegate.get(any())).thenReturn(null)

        val s = service.getData(PARAMS_1).test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)
        verify(cacheDelegate).get(PARAMS_1)

        service.delete(PARAMS_1).test().assertComplete()
        verify(cacheDelegate).delete(PARAMS_1)

        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)
        verify(cacheDelegate, times(2)).get(PARAMS_1)
    }

    @Test
    fun failsToDeleteCacheIfDelegateFails() {
        val error = Exception("Error")
        whenever(cacheDelegate.delete(any())).thenAnswer {
            throw error
        }

        val s = service.getData(PARAMS_1).test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)

        service.delete(PARAMS_1).test().assertError(error)
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(None)
        verify(cacheDelegate, times(1)).get(PARAMS_1)
    }

    @Test
    fun integratesWithCacheThenNetModelWhenNotCached() {
        val model = LceModel.cacheThenNet(
                "key",
                object : ServiceSet<String, String> {
                    override val net: NetService<String, String> = object : NetService<String, String> {
                        override fun get(params: String): Single<Entity<String>> = Single.fromCallable { VALID_ENTITY }
                    }
                    override val cache: CacheService<String, String> = SyncDelegateCacheService(
                            MemorySyncDelegate.custom(Collections.synchronizedMap(HashMap()))
                    )
                }
        )

        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(LceState.Loading(null, false, "key"), LceState.Content(VALID_ENTITY.data, true, "key"))
    }

    @Test
    fun integratesWithCacheThenNetModelWhenCached() {
        val model = LceModel.cacheThenNet(
                "key",
                object : ServiceSet<String, String> {
                    override val net: NetService<String, String> = object : NetService<String, String> {
                        override fun get(params: String): Single<Entity<String>> = Single.fromCallable { VALID_ENTITY }
                    }
                    override val cache: CacheService<String, String> = SyncDelegateCacheService(
                            MemorySyncDelegate.custom(Collections.synchronizedMap(mutableMapOf<String, Entity<String>>("key" to VALID_ENTITY)))
                    )
                }
        )

        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(LceState.Loading(null, false, "key"), LceState.Content(VALID_ENTITY.data, true, "key"))
    }
}
