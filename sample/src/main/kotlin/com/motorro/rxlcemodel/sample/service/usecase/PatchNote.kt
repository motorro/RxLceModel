package com.motorro.rxlcemodel.sample.service.usecase

import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.entity.EntityValidatorFactory
import com.motorro.rxlcemodel.base.entity.toEntity
import com.motorro.rxlcemodel.base.service.CacheService
import com.motorro.rxlcemodel.sample.di.ActivityScope
import com.motorro.rxlcemodel.sample.di.CacheConfigModule
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.service.NetRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.SingleSource
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Common actions to take when patching note properties
 * As the note changes we should refresh the note-list. That is done by invalidating [listCache].
 */
@ActivityScope
class PatchNote @Inject constructor (
    private val netRepository: NetRepository,
    private val listCache: @JvmSuppressWildcards CacheService<NoteList, Unit>,
    @Named(CacheConfigModule.NOTE) private val entityFactory: EntityValidatorFactory
) {
    /**
     * Patches note properties and invalidates note-list cache
     */
    fun patch(noteId: Int, patchOperation: NetRepository.(Int) -> Single<Note>) =
        netRepository.patchOperation(noteId).flatMap {
            listCache.invalidateAll.andThen(SingleSource<Entity<Note>> {
                Single.fromCallable { it.toEntity(entityFactory.create()) }
            })
        }
}

/**
 * Sets note title and invalidates list cache
 */
@ActivityScope
class PatchNoteTitle @Inject constructor (private val patcher: PatchNote) {
    /**
     * Sets note title
     */
    fun setTitle(noteId: Int, title: String): Single<Entity<Note>> = patcher.patch(noteId) { id ->
        setNoteTitle(id, title)
    }
}

/**
 * Sets note text and invalidates list cache
 */
@ActivityScope
class PatchNoteText @Inject constructor (private val patcher: PatchNote) {
    /**
     * Sets note text
     */
    fun setText(noteId: Int, text: String): Single<Entity<Note>> = patcher.patch(noteId) { id ->
        setNoteText(id, text)
    }
}

/**
 * Deletes note on server, invalidates list cache and removes cached note
 */
@ActivityScope
class DeleteNote @Inject constructor (
    private val netRepository: NetRepository,
    private val listCache: @JvmSuppressWildcards CacheService<NoteList, Unit>,
    private val noteCache: @JvmSuppressWildcards CacheService<Note, Int>
) {
    /**
     * Deletes note
     */
    fun delete(noteId: Int): Completable = netRepository.deleteNote(noteId)
        .andThen(noteCache.delete(noteId))
        .andThen(listCache.invalidateAll)
}