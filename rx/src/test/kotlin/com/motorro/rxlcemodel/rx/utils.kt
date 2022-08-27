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

package com.motorro.rxlcemodel.rx

import com.motorro.rxlcemodel.rx.entity.Entity
import com.motorro.rxlcemodel.rx.service.CacheService
import com.motorro.rxlcemodel.rx.service.UpdatingNetService
import com.motorro.rxlcemodel.rx.service.UpdatingServiceSet
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.Subject
import java.util.*

/**
 * Service configuration
 * @property cacheInitial Initial cache value
 * @property netGet Value returned from net load
 * @property netUpdate Value returned from net update
 */
data class ServiceConfig<D: Any>(
    var cacheInitial: () -> Optional<Entity<D>> = { throw Exception("Cache get not defined") },
    var netGet: () -> Entity<D> = { throw Exception("Net get not defined") },
    var netUpdate: () -> Entity<D> = { throw Exception("Net update not defined") }
)

/**
 * Test service-set that exposes [cacheData] to emulate cache updates
 */
interface TestServiceSet<D: Any, in U: Any, in P: Any>: UpdatingServiceSet<D, U, P> {
    /**
     * Subject to emit cache data values
     */
    val cacheData: Subject<Optional<Entity<D>>>
}

/**
 * Creates test service set for [LceModel]
 */
inline fun <reified D: Any, reified U: Any, reified P: Any> createServiceSet(configure: ServiceConfig<D>.() -> Unit): TestServiceSet<D, U, P> {
    val config = ServiceConfig<D>().apply {
        configure()
    }

    val cacheData = BehaviorSubject.createDefault(config.cacheInitial())

    @Suppress("UNCHECKED_CAST")
    val cache = mock<CacheService<D, P>> {
        on { getData(any()) } doReturn cacheData
        on { save(any(), any()) } doAnswer { mock ->
            Completable.fromAction {
                cacheData.onNext(Optional.of(mock.arguments[1] as Entity<D>))
            }
        }
    }

    val net = mock<UpdatingNetService<D, U, P>> {
        on { get(any()) } doReturn Single.create { subscriber ->
            try {
                subscriber.onSuccess(config.netGet())
            } catch (e: Throwable) {
                subscriber.onError(e)
            }
        }
        on { update(any(), any()) } doReturn Single.create { subscriber ->
            try {
                subscriber.onSuccess(config.netUpdate())
            } catch (e: Throwable) {
                subscriber.onError(e)
            }
        }
    }

    return object: TestServiceSet<D, U, P> {
        override val cacheData: Subject<Optional<Entity<D>>> = cacheData
        override val net: UpdatingNetService<D, U, P> = net
        override val cache: CacheService<D, P> = cache
    }
}
