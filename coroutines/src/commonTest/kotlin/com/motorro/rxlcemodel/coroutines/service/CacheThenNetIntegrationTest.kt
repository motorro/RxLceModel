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

package com.motorro.rxlcemodel.coroutines.service

class CacheThenNetIntegrationTest {
//
//    @Test
//    fun integratesWithCacheThenNetModelWhenNotCached() {
//        val delegate = MemorySyncDelegate.create<String, String>(1)
//        val model = LceModel.cacheThenNet(
//            "key",
//            object : ServiceSet<String, String> {
//                override val net: NetService<String, String> = object : NetService<String, String> {
//                    override fun get(params: String): Single<Entity<String>> = Single.fromCallable { VALID_ENTITY }
//                }
//                override val cache: CacheService<String, String> = SyncDelegateCacheService(delegate)
//            },
//            Observable.empty()
//        )
//
//        val s = model.state.test()
//        s.assertNoErrors()
//        s.assertNotComplete()
//        s.assertValues(LceState.Loading(null, false), LceState.Content(VALID_ENTITY.data, true))
//    }
//
//    @Test
//    fun integratesWithCacheThenNetModelWhenCached() {
//        val delegate = MemorySyncDelegate.create<String, String>(1).apply {
//            save("key", VALID_ENTITY)
//        }
//
//        val model = LceModel.cacheThenNet(
//            "key",
//            object : ServiceSet<String, String> {
//                override val net: NetService<String, String> = object : NetService<String, String> {
//                    override fun get(params: String): Single<Entity<String>> = Single.fromCallable { VALID_ENTITY }
//                }
//                override val cache: CacheService<String, String> = SyncDelegateCacheService(delegate)
//            }
//        )
//
//        val s = model.state.test()
//        s.assertNoErrors()
//        s.assertNotComplete()
//        s.assertValues(LceState.Content(VALID_ENTITY.data, true))
//    }
}