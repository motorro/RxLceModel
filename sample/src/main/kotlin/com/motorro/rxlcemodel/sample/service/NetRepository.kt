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
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import timber.log.Timber
import java.time.LocalTime
import java.time.format.DateTimeFormatter
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
    fun getNote(noteId: Int): Single<Note>

    /**
     * Adds new note
     */
    fun addNote(title: String, text: String): Single<Note>

    /**
     * Sets new note title
     */
    fun setNoteTitle(noteId: Int, title: String): Single<Note>

    /**
     * Sets new note text
     */
    fun setNoteText(noteId: Int, text: String): Single<Note>

    /**
     * Deletes note
     */
    fun deleteNote(noteId: Int): Completable
}

/**
 * A fake network server
 */
class FakeServer(private val schedulersRepository: SchedulerRepository): NetRepository {
    companion object {
        /**
         * Time 'loading' takes
         */
        private const val SERVER_DELAY = 1000L

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
     * Returns a list of notes
     */
    override val noteList: Single<NoteList> = emulateLoad {
        NoteList(
            notes.map { (id, properties) -> properties.toDomainListChild(id) },
            LocalTime.now()
        )
    }

    /**
     * Finds note in note-list and transforms data with [operation]
     */
    private inline fun <T> withNoteProperties(noteId: Int, operation: (Int, NoteProperties) -> T): T {
        val properties = notes[noteId] ?: throw (IllegalArgumentException("No note found for id: $noteId"))
        return operation(noteId, properties)
    }

    /**
     * Returns a note
     */
    override fun getNote(noteId: Int): Single<Note> = emulateLoad {
        withNoteProperties(noteId) { id, properties ->
            properties.toDomain(id)
        }
    }

    /**
     * Adds new note
     */
    override fun addNote(title: String, text: String): Single<Note> =
        Single.fromCallable { nextNoteId.getAndIncrement() }
            .flatMap { id ->
                Completable.fromAction {
                    notes[id] = NoteProperties(title, text)
                }.andThen(getNote(id))
            }

    /**
     * Common patch actions
     */
    private inline fun updateNote(noteId: Int, crossinline operation: (Int, NoteProperties) -> NoteProperties): Single<Note> = Completable.fromAction {
        withNoteProperties(noteId) { id, properties ->
            operation(id, properties).also { update ->
                notes[id] = update
            }
        }
    }.andThen(getNote(noteId))

    /**
     * Sets new note title
     */
    override fun setNoteTitle(noteId: Int, title: String): Single<Note> = updateNote(noteId) { id, properties ->
        Timber.i("Patching note $id title: $title")
        properties.setTitle(title)
    }

    /**
     * Sets new note text
     */
    override fun setNoteText(noteId: Int, text: String): Single<Note> = updateNote(noteId) { id, properties ->
        Timber.i("Patching note $id text: $text")
        properties.setText(text)
    }

    /**
     * Deletes note
     */
    override fun deleteNote(noteId: Int): Completable =
        Completable.timer(SERVER_DELAY, TimeUnit.MILLISECONDS, schedulersRepository.computation)
        .andThen(Completable.fromAction {
            if (null == notes.remove(noteId)) {
                throw (IllegalArgumentException("No note found for id: $noteId"))
            }
        })
        .doOnSubscribe { Timber.i("Deleting note $noteId...".withTimeStamp()) }
        .doOnComplete { Timber.i("Request complete".withTimeStamp()) }
        .doOnError { Timber.w(it, "Request error".withTimeStamp()) }
}