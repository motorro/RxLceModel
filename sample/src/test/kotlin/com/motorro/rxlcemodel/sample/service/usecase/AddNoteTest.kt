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

import com.motorro.rxlcemodel.base.service.CacheService
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

class AddNoteTest {
    private lateinit var connectionChecker: ConnectionChecker
    private lateinit var repo: NetRepository
    private lateinit var listCache: CacheService<NoteList, Unit>
    private lateinit var addNote: AddNote

    private var listCacheInvalidated = false

    @Before
    fun init() {
        connectionChecker = ConnectionChecker()

        repo = mock {
            on { addNote(any(), any()) } doReturn Single.just(NOTE)
        }

        listCacheInvalidated = false
        listCache = mock {
            on { invalidateAll } doReturn Completable.fromAction {
                listCacheInvalidated = true
            }
        }

        addNote = AddNote(connectionChecker, repo, listCache)
    }


    @Test
    fun addsNote() {
        addNote.add("Title", "Text")
            .test()
            .assertNoErrors()
            .assertComplete()

        verify(repo).addNote("Title", "Text")
        assertTrue(listCacheInvalidated)
    }

    @Test
    fun deleteFailsOnError() {
        val error = RuntimeException("DB error")
        whenever(repo.addNote("Title", "Text")).thenReturn(Single.error(error))
        addNote.add("Title", "Text")
            .test()
            .assertNoValues()
            .assertError(error)

        assertFalse(listCacheInvalidated)
    }

    @Test
    fun deleteFailsOnConnectionError() {
        connectionChecker.setStatus(false)

        addNote.add("Title", "Text")
            .test()
            .assertNoValues()
            .assertError(IOException::class.java)
    }
}