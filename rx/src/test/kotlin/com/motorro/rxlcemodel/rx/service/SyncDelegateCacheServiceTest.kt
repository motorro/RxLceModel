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

package com.motorro.rxlcemodel.rx.service

import com.motorro.rxlcemodel.cache.CacheDelegate
import com.motorro.rxlcemodel.cache.MemorySyncDelegate
import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.cache.entity.EntityValidator
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.rx.LceModel
import com.nhaarman.mockitokotlin2.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import java.util.*

class SyncDelegateCacheServiceTest {
    companion object {
        private const val PARAMS_1 = "params1"
        private const val PARAMS_2 = "params2"
        private val VALID_ENTITY = Entity.Impl("data", EntityValidator.Always)
    }
    
    private lateinit var cacheDelegate: CacheDelegate<String, String>
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
        s.assertValues(Optional.empty())
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
        s.assertValues(Optional.empty())
        verify(cacheDelegate).get(PARAMS_1)

        service.save(PARAMS_1, VALID_ENTITY).test().assertComplete()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(Optional.empty(), Optional.of(VALID_ENTITY))
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
        s.assertValues(Optional.empty())

        service.save(PARAMS_1, VALID_ENTITY).test().assertError(error)
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(Optional.empty())
    }

    @Test
    fun refetchesDataFromDelegate() {
        whenever(cacheDelegate.get(any())).thenReturn(null)

        val s = service.getData(PARAMS_1).test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(Optional.empty())
        verify(cacheDelegate).get(PARAMS_1)

        service.refetch(PARAMS_1).test().assertComplete()
        verify(cacheDelegate, times(2)).get(PARAMS_1)

        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(Optional.empty())
        verify(cacheDelegate, times(2)).get(PARAMS_1)
    }

    @Test
    fun refetchesAllDataFromDelegate() {
        whenever(cacheDelegate.get(any())).thenReturn(null)

        val params = listOf(PARAMS_1, PARAMS_2)
        val subscribers = params.map {
            it to service.getData(it).test()
        }

        subscribers.forEach { (params, s) ->
            s.assertNoErrors()
            s.assertNotComplete()
            s.assertValues(Optional.empty())
            verify(cacheDelegate).get(params)
        }
        verify(cacheDelegate).get(PARAMS_1)
        verify(cacheDelegate).get(PARAMS_2)

        service.refetchAll.test().assertComplete()
        verify(cacheDelegate, times(2)).get(PARAMS_1)
        verify(cacheDelegate, times(2)).get(PARAMS_2)

        subscribers.forEach { (params, s) ->
            s.assertNoErrors()
            s.assertNotComplete()
            s.assertValues(Optional.empty())
            verify(cacheDelegate, times(2)).get(params)
        }
    }

    @Test
    fun invalidatesCacheAndAndUpdatesFromDelegate() {
        whenever(cacheDelegate.get(any())).thenReturn(null)

        val s = service.getData(PARAMS_1).test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(Optional.empty())
        verify(cacheDelegate).get(PARAMS_1)

        service.invalidate(PARAMS_1).test().assertComplete()
        verify(cacheDelegate).invalidate(PARAMS_1)

        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(Optional.empty())
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
        s.assertValues(Optional.empty())

        service.invalidate(PARAMS_1).test().assertError(error)
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(Optional.empty())
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
            s.assertValues(Optional.empty())
            verify(cacheDelegate).get(params)
        }

        service.invalidateAll.test().assertComplete()
        verify(cacheDelegate).invalidateAll()

        subscribers.forEach { (params, s) ->
            s.assertNoErrors()
            s.assertNotComplete()
            s.assertValues(Optional.empty())
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
            s.assertValues(Optional.empty())
            verify(cacheDelegate).get(params)
        }

        service.invalidateAll.test().assertError(error)
        verify(cacheDelegate).invalidateAll()

        subscribers.forEach { (params, s) ->
            s.assertNoErrors()
            s.assertNotComplete()
            s.assertValues(Optional.empty())
            verify(cacheDelegate, times(1)).get(params)
        }
    }

    @Test
    fun deletesCacheAndAndUpdatesFromDelegate() {
        whenever(cacheDelegate.get(any())).thenReturn(null)

        val s = service.getData(PARAMS_1).test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(Optional.empty())
        verify(cacheDelegate).get(PARAMS_1)

        service.delete(PARAMS_1).test().assertComplete()
        verify(cacheDelegate).delete(PARAMS_1)

        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(Optional.empty())
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
        s.assertValues(Optional.empty())

        service.delete(PARAMS_1).test().assertError(error)
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(Optional.empty())
        verify(cacheDelegate, times(1)).get(PARAMS_1)
    }

    @Test
    fun integratesWithCacheThenNetModelWhenNotCached() {
        val delegate = MemorySyncDelegate.create<String, String>(1)
        val model = LceModel.cacheThenNet(
            "key",
            object : ServiceSet<String, String> {
                override val net: NetService<String, String> = object : NetService<String, String> {
                    override fun get(params: String): Single<Entity<String>> = Single.fromCallable { VALID_ENTITY }
                }
                override val cache: CacheService<String, String> = SyncDelegateCacheService(delegate)
            },
            Observable.empty()
        )

        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(LceState.Loading(null, false), LceState.Content(VALID_ENTITY.data, true))
    }

    @Test
    fun integratesWithCacheThenNetModelWhenCached() {
        val delegate = MemorySyncDelegate.create<String, String>(1).apply {
            save("key", VALID_ENTITY)
        }

        val model = LceModel.cacheThenNet(
            "key",
            object : ServiceSet<String, String> {
                override val net: NetService<String, String> = object : NetService<String, String> {
                    override fun get(params: String): Single<Entity<String>> = Single.fromCallable { VALID_ENTITY }
                }
                override val cache: CacheService<String, String> = SyncDelegateCacheService(delegate)
            }
        )

        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(LceState.Content(VALID_ENTITY.data, true))
    }
}
