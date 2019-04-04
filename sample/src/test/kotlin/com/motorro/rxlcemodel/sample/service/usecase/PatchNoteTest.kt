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

import com.motorro.rxlcemodel.base.entity.EntityValidator
import com.motorro.rxlcemodel.base.entity.EntityValidatorFactory
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.service.NetRepository
import com.motorro.rxlcemodel.sample.utils.ConnectionChecker
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.anyOrNull
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.threeten.bp.LocalTime
import java.io.IOException

class PatchNoteTest {
    companion object {
        private val NOTE = Note(
            1,
            "Title",
            "Text",
            LocalTime.now()
        )
    }

    private lateinit var connectionChecker: ConnectionChecker
    private lateinit var repo: NetRepository
    private lateinit var listCache: CacheService<NoteList, Unit>
    private lateinit var patcher: PatchNote
    private lateinit var validatorFactory: EntityValidatorFactory

    @Before
    fun init() {
        connectionChecker = ConnectionChecker()

        repo = mock {
            on { setNoteTitle(any(), any()) } doReturn Single.just(NOTE)
        }

        listCache = mock {
            on { invalidateAll } doReturn Completable.complete()
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
    }

    @Test
    fun patcherFailsOnError() {
        val error = IllegalArgumentException("Note not found")
        patcher.patch(1) { Single.error(error) }
            .test()
            .assertNoValues()
            .assertError(error)
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