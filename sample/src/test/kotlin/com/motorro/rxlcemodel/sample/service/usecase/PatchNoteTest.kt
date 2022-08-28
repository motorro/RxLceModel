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

package com.motorro.rxlcemodel.sample.service.usecase

import com.motorro.rxlcemodel.cache.entity.EntityValidator
import com.motorro.rxlcemodel.cache.entity.EntityValidatorFactory
import com.motorro.rxlcemodel.rx.service.CacheService
import com.motorro.rxlcemodel.sample.NOTE
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.service.NetRepository
import com.motorro.rxlcemodel.sample.utils.ConnectionChecker
import com.nhaarman.mockitokotlin2.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import java.io.IOException
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PatchNoteTest {
    private lateinit var connectionChecker: ConnectionChecker
    private lateinit var repo: NetRepository
    private lateinit var listCache: CacheService<NoteList, Unit>
    private lateinit var patcher: PatchNote
    private lateinit var validatorFactory: EntityValidatorFactory

    private var listCacheInvalidated = false

    @Before
    fun init() {
        connectionChecker = ConnectionChecker()

        repo = mock {
            on { setNoteTitle(any(), any()) } doReturn Single.just(NOTE)
        }

        listCacheInvalidated = false
        listCache = mock {
            on { invalidateAll } doReturn Completable.fromAction {
                listCacheInvalidated = true
            }
        }

        validatorFactory = mock {
            on { create(anyOrNull()) } doReturn EntityValidator.Always
        }

        patcher = PatchNote(connectionChecker, repo, listCache, validatorFactory)
    }

    @Test
    fun patcherPatches() {
        patcher.patch(1) { id -> setNoteTitle(id, "Title") }
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue {
                NOTE == it.data
            }
        verify(repo).setNoteTitle(1, "Title")
        assertTrue { listCacheInvalidated }
        verify(validatorFactory).create()
    }

    @Test
    fun patcherFailsOnError() {
        val error = IllegalArgumentException("Note not found")
        patcher.patch(1) { Single.error(error) }
            .test()
            .assertNoValues()
            .assertError(error)

        assertFalse { listCacheInvalidated }
    }

    @Test
    fun patcherFailsOnConnectionError() {
        connectionChecker.setStatus(false)

        patcher.patch(1) { id -> setNoteTitle(id, "Title") }
            .test()
            .assertNoValues()
            .assertError(IOException::class.java)
    }
}