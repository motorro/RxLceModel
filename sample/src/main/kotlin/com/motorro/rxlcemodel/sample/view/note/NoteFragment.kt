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

package com.motorro.rxlcemodel.sample.view.note

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.sample.R
import com.motorro.rxlcemodel.sample.di.ProvidesNoteId
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.view.LceFragment
import com.motorro.rxlcemodel.sample.view.note.viewmodel.NoteViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_note.*
import org.threeten.bp.format.DateTimeFormatter
import timber.log.Timber
import javax.inject.Inject

class NoteFragment : LceFragment<ViewGroup, Note, Int>(), ProvidesNoteId {

    /**
     * Fragment arguments
     */
    private val arguments: NoteFragmentArgs by navArgs()

    /**
     * Provides note ID to injector
     */
    override val noteId: Int
        get() = arguments.noteId

    /**
     * Factory for [noteModel]
     */
    @Inject
    lateinit var noteModelFactory: ViewModelProvider.Factory

    /**
     * Model to load user list
     */
    private lateinit var noteModel: NoteViewModel


    /**
     * Called by [processState] to process new data
     */
    override fun processStateData(data: Note, isValid: Boolean) {
        last_modified.text = DateTimeFormatter.ISO_TIME.format(data.lastModified)
        is_valid_data.text = isValid.toString()
        title.setText(data.title, TextView.BufferType.EDITABLE)
        text.setText(data.text, TextView.BufferType.EDITABLE)
    }

    /**
     * Performs action on error click
     */
    override fun onErrorClick() = noteModel.refresh()

    /**
     * Delete note...
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_delete -> {
            Timber.d("Deleting note...")
            noteModel.delete()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    /**
     * ...and return to list on complete
     */
    override fun processTermination() {
        findNavController().popBackStack()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_note, container, false)

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu,inflater)
        inflater.inflate(R.menu.menu_fragment_note, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteModel = ViewModelProviders.of(this, noteModelFactory).get(NoteViewModel::class.java)
        noteModel.state.observe(this, Observer<LceState<Note, Int>> { processState(it) })
        noteModel.initialize()
    }
}
