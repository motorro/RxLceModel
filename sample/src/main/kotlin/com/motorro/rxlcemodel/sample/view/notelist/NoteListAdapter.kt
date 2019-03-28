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

package com.motorro.rxlcemodel.sample.view.notelist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.calculateDiff
import androidx.recyclerview.widget.RecyclerView
import com.motorro.rxlcemodel.sample.R
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import org.threeten.bp.format.DateTimeFormatter
import kotlin.properties.Delegates

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    var notes: List<NoteList.Child> by Delegates.observable(emptyList()) { _, old, new ->
        calculateDiff(UserDiff(old, new), false).dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = notes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val container = LayoutInflater.from(parent.context).inflate(R.layout.note_list_item, parent, false) as ViewGroup
        return ViewHolder(container)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = notes[position].run {
        holder.id = id
        holder.title.text = title
        holder.lastModified.text = NoteLastModifiedFormatter.format(lastModified)
    }

    class ViewHolder(itemView: ViewGroup): RecyclerView.ViewHolder(itemView) {
        var id: Int = -1
        val title: TextView = itemView.findViewById(R.id.note_title)
        val lastModified: TextView = itemView.findViewById(R.id.note_last_modified)
    }
}

private class UserDiff(private val old: List<NoteList.Child>, private val new: List<NoteList.Child>): DiffUtil.Callback() {

    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        old[oldItemPosition].id == new[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = old[oldItemPosition]
        val newItem = new[newItemPosition]
        return oldItem.lastModified == newItem.lastModified && oldItem.title == newItem.title
    }
}

private val NoteLastModifiedFormatter = DateTimeFormatter.ofPattern("HH:mm:s")
