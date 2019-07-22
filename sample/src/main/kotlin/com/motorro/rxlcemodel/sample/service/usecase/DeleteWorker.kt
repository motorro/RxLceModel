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

import android.content.Context
import androidx.work.*
import com.motorro.rxlcemodel.sample.di.ProvidesApplicationComponent
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

/**
 * Delete with worker to illustrate how data may be invalidated from non-visual components
 * @see DeleteNote
 */
class DeleteWorker(context: Context, params: WorkerParameters) : RxWorker(context, params) {
    companion object {
        private const val NOTE_ID = "noteId"
        const val TAG = "deleteNote"

        /**
         * Schedules a job
         * @param context Context
         * @param noteId Note ID to delete
         */
        fun execute(context: Context, noteId: Int) {
            val request = OneTimeWorkRequestBuilder<DeleteWorker>()
                .setInputData(workDataOf(NOTE_ID to noteId))
                .addTag(TAG)
                .build()
            WorkManager.getInstance(context).enqueue(request)
            Timber.d("DeleteWorker scheduled to delete note $noteId")
        }
    }

    /**
     * Deletion use-case
     */
    @Inject
    lateinit var deleteNote: DeleteNote

    init {
        (context as ProvidesApplicationComponent).applicationComponent.inject(this)
        Timber.d("DeleteWorker created")
    }

    /**
     * Deletes a note
     */
    override fun createWork(): Single<Result> {
        val id = inputData.getInt(NOTE_ID, -1)
        Timber.d("Creating work to delete note $id")

        return deleteNote.delete(id).andThen(Single.just(Result.success()))
    }
}