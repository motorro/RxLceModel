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

package com.motorro.rxlcemodel.sample.domain.data

import org.threeten.bp.LocalTime
import java.io.Serializable

/**
 * A list of notes
 * @property notes Note list
 * @property timeStamp Time the data was 'output' by our 'server'
 */
data class NoteList(val notes: List<Child>, val timeStamp: LocalTime):Serializable {
    companion object {
        private const val serialVersionUID: Long = 2
    }

    /**
     * Note list child element
     * @property id Note id
     * @property title Note title
     * @property lastModified The last time the note was modified
     */
    data class Child(val id: Int, val title: String, val lastModified: LocalTime): Serializable {
        companion object {
            private const val serialVersionUID: Long = 2
        }
    }
}