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

import com.motorro.rxlcemodel.rx.service.CacheService
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.service.NetRepository
import com.motorro.rxlcemodel.sample.utils.ConnectionChecker
import com.nhaarman.mockitokotlin2.*
import io.reactivex.rxjava3.core.Completable
import org.junit.Before
import org.junit.Test
import java.io.IOException
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DeleteNoteTest {
    private lateinit var connectionChecker: ConnectionChecker
    private lateinit var repo: NetRepository
    private lateinit var listCache: CacheService<NoteList, Unit>
    private lateinit var noteCache: CacheService<Note, Int>
    private lateinit var delete: DeleteNote

    private var listCacheInvalidated = false
    private var noteCacheDeleted = false

    @Before
    fun init() {
        connectionChecker = ConnectionChecker()

        repo = mock {
            on { deleteNote(any()) } doReturn Completable.complete()
        }

        listCacheInvalidated = false
        listCache = mock {
            on { invalidateAll } doReturn Completable.fromAction {
                listCacheInvalidated = true
            }
        }
        noteCacheDeleted = false
        noteCache = mock {
            on { delete(any()) } doReturn Completable.fromAction {
                noteCacheDeleted = true
            }
        }

        delete = DeleteNote(connectionChecker, repo, listCache, noteCache)
    }

    @Test
    fun deletesNote() {
        delete.delete(1)
            .test()
            .assertNoErrors()
            .assertComplete()

        verify(repo).deleteNote(1)
        verify(noteCache).delete(1)
        assertTrue(listCacheInvalidated)
        assertTrue(noteCacheDeleted)
    }

    @Test
    fun deleteFailsOnError() {
        val error = IllegalArgumentException("Note not found")
        whenever(repo.deleteNote(any())).thenReturn(Completable.error(error))
        delete.delete(1)
            .test()
            .assertNoValues()
            .assertError(error)

        assertFalse(listCacheInvalidated)
        assertFalse(noteCacheDeleted)
    }

    @Test
    fun deleteFailsOnConnectionError() {
        connectionChecker.setStatus(false)

        delete.delete(1)
            .test()
            .assertNoValues()
            .assertError(IOException::class.java)
    }
}