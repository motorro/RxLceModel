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

package com.motorro.rxlcemodel.sample.service

import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.utils.SchedulerRepository
import io.reactivex.Completable
import io.reactivex.Single
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter
import timber.log.Timber
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

/**
 * A sample net repository to load data from server
 */
interface NetRepository {
    /**
     * A list of notes
     */
    val noteList: Single<NoteList>

    /**
     * Returns user profile
     */
    fun getNote(id: Int): Single<Note>
}

/**
 * A fake network server
 */
class FakeServer(private val schedulersRepository: SchedulerRepository): NetRepository {
    companion object {
        /**
         * Time 'loading' takes
         */
        private const val SERVER_DELAY = 3000L

        /**
         * Time string for output
         */
        private fun getCurrentTimeString() = DateTimeFormatter.ISO_TIME.format(LocalTime.now())

        /**
         * Marks message with current time
         */
        private fun String.withTimeStamp() = "[${getCurrentTimeString()}]: $this"
    }

    /**
     * Emulates network delay of data return
     * @param callable Callable that produces data
     */
    private fun <T: Any> emulateLoad(callable: () -> T): Single<T> =
        Completable.timer(SERVER_DELAY, TimeUnit.MILLISECONDS, schedulersRepository.computation)
            .andThen(Single.fromCallable(callable))
            .doOnSubscribe { Timber.i("Performing server data load request...".withTimeStamp()) }
            .doOnSuccess { Timber.i("Request complete".withTimeStamp()) }
            .doOnError { Timber.w(it, "Request error".withTimeStamp()) }

    /**
     * Emulates network delay of data update
     * @param action Action to update data
     */
    private fun emulateUpdate(action: () -> Unit): Completable =
        Completable.timer(SERVER_DELAY, TimeUnit.MILLISECONDS, schedulersRepository.computation)
            .andThen(Completable.fromAction(action))
            .doOnSubscribe { Timber.i("Performing server data update request...".withTimeStamp()) }
            .doOnComplete { Timber.i("Request complete".withTimeStamp()) }
            .doOnError { Timber.w(it, "Request error".withTimeStamp()) }

    /**
     * Internal note data storage class
     */
    private data class NoteProperties(val title: String, val text: String, val lastModified: LocalTime = LocalTime.now()) {
        fun toDomain(id: Int) = Note(id, title, text, lastModified)
        fun toDomainListChild(id: Int) = NoteList.Child(id, title, lastModified)
        fun setTitle(value: String) = copy(title = value, lastModified = LocalTime.now())
        fun setText(value: String) = copy(text = value, lastModified = LocalTime.now())
    }

    /**
     * Next note ID
     */
    private val nextNoteId = AtomicInteger(1)

    /**
     * Stores user profiles
     */
    private val notes: MutableMap<Int, NoteProperties> = ConcurrentHashMap<Int, NoteProperties>().apply {
        put(nextNoteId.getAndIncrement(), NoteProperties("Note list fragment", "Displays notes already there"))
        put(nextNoteId.getAndIncrement(), NoteProperties("Note fragment", "Displays a note as requested"))
    }

    /**
     * Returns a note
     */
    override fun getNote(id: Int): Single<Note> = emulateLoad {
        notes[id]?.toDomain(id) ?: throw (IllegalArgumentException("No note found for id: $id"))
    }

    /**
     * Returns a list of notes
     */
    override val noteList: Single<NoteList> = emulateLoad {
        NoteList(
            notes.map { (id, properties) -> properties.toDomainListChild(id) },
            LocalTime.now()
        )
    }
}