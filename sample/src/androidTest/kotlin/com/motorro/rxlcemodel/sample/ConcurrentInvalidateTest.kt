/*
 * Copyright 2021 Nikolai Kotchetkov.
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
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.motorro.rxlcemodel.base.*
import com.motorro.rxlcemodel.base.entity.*
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.base.service.NetService
import com.motorro.rxlcemodel.base.service.SyncDelegateCacheService
import com.motorro.rxlcemodel.disklrucache.DiskLruCacheSyncDelegate
import com.motorro.rxlcemodel.disklrucache.withObjectStream
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.Serializable
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
class ConcurrentInvalidateTest {
    private companion object {
        const val DELAY: Long = 500
        const val CACHE_SIZE: Long = 1 * 1024 * 1024
        const val TAG = "ConcurrentInvalidateTest"
    }

    private val validatorFactory: EntityValidatorFactory = LifespanValidatorFactory(10000L)
    private lateinit var cacheProvider: DiskLruCacheSyncDelegate.DiskLruCacheProvider
    private lateinit var cacheDelegate: SyncDelegateCacheService.Delegate<TestData, Int>
    private lateinit var netService: TestNetService
    private lateinit var cacheService: CacheService<TestData, Int>

    @Before
    fun init() {
        cacheProvider = DiskLruCacheSyncDelegate.DiskLruCacheProvider(
            ApplicationProvider.getApplicationContext<Application>().cacheDir,
            1,
            CACHE_SIZE
        )
        cacheDelegate = cacheProvider.withObjectStream(validatorFactory, "test") { toString() }

        netService = TestNetService(validatorFactory)
        cacheService = CacheService.withSyncDelegate(cacheDelegate)
    }

    @After
    fun deinit() {
        cacheProvider.cache.delete()
    }

    /**
     * Populates cache with [data]
     * Uses common validator factory
     */
    private fun populate(data: TestData) {
        cacheDelegate.save(data.params, data.toEntity(validatorFactory.create()))
    }

    /**
     * Creates double model that is bound to the same cache service with different params
     */
    private fun createDoubleModel(): Observable<LceState<Pair<TestData, TestData>>> {
        val modelLog = Logger { level: LogLevel, message: String -> log("$level: $message") }
        val model1 = LceModel.cacheThenNet(
            1,
            netService,
            cacheService,
            Observable.empty(),
            Schedulers.io(),
            modelLog
        )
            .state
            .subscribeOn(Schedulers.io())
        val model2 = LceModel.cacheThenNet(
            2,
            netService,
            cacheService,
            Observable.empty(),
            Schedulers.io(),
            modelLog
        )
            .state
            .subscribeOn(Schedulers.io())

        return Observable.combineLatest(model1, model2) { dataState1, dataState2 ->
            dataState1.combine(dataState2) { data1, data2 ->
                data1 ?: return@combine null
                data2 ?: return@combine null
                data1 to data2
            }
        }
    }

    @Test
    fun loadsData() {
        LceModel.cacheThenNet(1, netService, cacheService, Observable.empty())
            .state
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .test()
            .awaitCount(2, TestWaitStrategy(1000))
            .assertValues(
                LceState.Loading(null, false),
                LceState.Content(TestData(1), true)
            )

        assertEquals(1, netService.calls.get())
    }

    @Test
    fun combinesData() {
        createDoubleModel()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .test()
            .awaitCount(3, TestWaitStrategy(1000))
            .assertValueSet(
                setOf(
                    LceState.Loading(null, false),
                    LceState.Content(
                        TestData(1) to TestData(2),
                        true
                    )
                )
            )

        assertEquals(2, netService.calls.get())
    }

    @Test
    fun reloadsOnCacheInvalidationData() {
        val operation = Observable.mergeArray(
            createDoubleModel().distinctUntilChanged(),
            Completable.timer(750, TimeUnit.MILLISECONDS).andThen(cacheService.invalidateAll).toObservable()
        )

        operation
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .test()
            .awaitCount(4, TestWaitStrategy(3000))
            .assertValueSet(
                setOf(
                    LceState.Loading(null, false),
                    LceState.Loading(
                        null, // See how data is combined above
                        false,
                        LceState.Loading.Type.REFRESHING
                    ),
                    LceState.Loading(
                        TestData(1) to TestData(2),
                        false,
                        LceState.Loading.Type.REFRESHING
                    ),
                    LceState.Content(
                        TestData(1) to TestData(2),
                        true
                    )
                )
            )

        assertEquals(4, netService.calls.get())
    }

    @Test
    fun reloadsIfCacheIsInvalidatedWhileLoading() {
        val operation = Observable.mergeArray(
            createDoubleModel().distinctUntilChanged(),
            Completable.timer(750, TimeUnit.MILLISECONDS)
                .doOnComplete { log("Refreshing 750...") }
                .andThen(cacheService.invalidateAll)
                .subscribeOn(Schedulers.io())
                .toObservable(),
            Completable.timer(1300, TimeUnit.MILLISECONDS)
                .doOnComplete { log("Refreshing 1300 (concurrently)...") }
                .andThen(cacheService.invalidateAll)
                .toObservable(),
            Completable.timer(3000, TimeUnit.MILLISECONDS)
                .doOnComplete { log("Refreshing 3000...") }
                .andThen(cacheService.invalidateAll)
                .toObservable(),
            Completable.timer(5000, TimeUnit.MILLISECONDS)
                .doOnComplete { log("Refreshing 5000...") }
                .andThen(cacheService.invalidateAll)
                .toObservable()
        )

        operation
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .test()
            .awaitCount(14, TestWaitStrategy(10000))
            .assertValueSet(
                setOf(
                    LceState.Loading(null, false),
                    LceState.Loading(
                        TestData(1) to TestData(2),
                        false,
                        LceState.Loading.Type.REFRESHING
                    ),
                    LceState.Loading(
                        TestData(1) to TestData(2),
                        true,
                        LceState.Loading.Type.REFRESHING
                    ),
                    LceState.Content(
                        TestData(1) to TestData(2),
                        true
                    )
                )
            )

        assertEquals(10, netService.calls.get())
    }

    /**
     * Test data with parameters retained
     */
    private data class TestData(val params: Int): Serializable

    /**
     * Test net service
     */
    private inner class TestNetService(private val validatorFactory: EntityValidatorFactory) : NetService<TestData, Int> {
        /**
         * Number of calls
         */
        val calls = AtomicInteger(0)

        override fun get(params: Int): Single<Entity<TestData>> =
            Single.fromCallable<Entity<TestData>> {
                calls.getAndIncrement()
                Thread.sleep(DELAY)
                TestData(params).toEntity(validatorFactory.create())
            }
                .doOnSubscribe { log("Loading for params: $params") }
                .doOnSuccess { log("Load complete for params: $params") }
    }

    private class TestWaitStrategy(private val delay: Long) : Runnable {
        override fun run() {
            Thread.sleep(delay)
        }
    }

    private fun log(message: String) {
        Log.i(TAG, message)
    }
}




