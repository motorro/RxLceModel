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

import java.io.Serializable
import java.time.LocalTime

/**
 * A note
 * @property id Note id
 * @property title Note title
 * @property text Note text
 * @property lastModified The last time the note was modified
 */
data class Note(val id: Int, val title: String, val text: String, val lastModified: LocalTime): Serializable {
    companion object {
        private const val serialVersionUID: Long = 3
    }
}