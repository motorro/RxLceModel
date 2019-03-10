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

import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.entity.EntityValidator
import com.motorro.rxlcemodel.base.service.UpdateOperationState.*
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test


class CacheUpdateKtTest {
    companion object {
        private const val PARAMS = "params"
        private val ENTITY = Entity.Impl(1, EntityValidator.Always)
    }

    private lateinit var cacheService: CacheService<Int, String>
    private lateinit var update: (params: String) -> Single<Entity<Int>>

    @Before
    fun init() {
        cacheService = mock {
            on { save(any(), any()) } doReturn Completable.complete()
        }
        update = mock()
        whenever(update.invoke(any())).thenReturn(Single.just(ENTITY))
    }

    @Test
    fun updatesCacheAndEmitsIdle() {
        cacheService.buildUpdateOperation(PARAMS, update).test()
                .assertValues(LOADING, IDLE)
                .assertNoErrors()
                .assertComplete()

        verify(update).invoke(PARAMS)
        verify(cacheService).save(PARAMS, ENTITY)
    }

    @Test
    fun willReportUpdateOperationError() {
        val error = Error("An error")
        whenever(update.invoke(any())).thenReturn(Single.error(error))

        cacheService.buildUpdateOperation(PARAMS, update)
                .test()
                .assertValues(LOADING, ERROR(error))
                .assertNoErrors()
                .assertComplete()
    }
}