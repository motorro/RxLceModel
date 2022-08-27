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
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.motorro.rxlcemodel.rx.LceState
import com.motorro.rxlcemodel.sample.R
import com.motorro.rxlcemodel.sample.databinding.FragmentNoteBinding
import com.motorro.rxlcemodel.sample.di.ProvidesNoteId
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.view.LceFragment
import com.motorro.rxlcemodel.sample.view.TIME_FORMATTER
import dagger.android.support.AndroidSupportInjection
import timber.log.Timber
import javax.inject.Inject
import kotlin.properties.Delegates

class NoteFragment : LceFragment<ViewGroup, Note>(), ProvidesNoteId {

    /**
     * Fragment arguments - note ID
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
     * Model to load a note
     */
    private val noteModel: NoteViewModel by viewModels { noteModelFactory }

    /**
     * View-binding
     */
    private var binding: FragmentNoteBinding? = null

    /**
     * Called by [processState] to process new data
     */
    override fun processStateData(data: Note, isValid: Boolean, isUpdating: Boolean) {
        binding?.run {
            lastModified.text = TIME_FORMATTER.format(data.lastModified)
            isValidData.text = isValid.toString()
            if (!isUpdating) {
                noteTitle.setText(data.title, TextView.BufferType.EDITABLE)
                noteText.setText(data.text, TextView.BufferType.EDITABLE)
                restoreButtons()
            }
        }
    }

    /**
     * Updates view according to [state]
     * Removes refresh indicator when load completes
     */
    override fun processStateView(state: LceState<Note>) {
        super.processStateView(state)
        if (state is LceState.Error || state is LceState.Content) {
            binding?.swipeRefresh?.isRefreshing = false
        }
    }

    /**
     * Delete option visibility
     */
    private var isDeleteVisible by Delegates.observable(false) { _, old, new ->
        if (old != new) {
            activity?.invalidateOptionsMenu()
        }
    }

    /**
     * Called when content is displayed
     */
    override fun onShowContent() {
        super.onShowContent()
        isDeleteVisible = true
    }

    /**
     * Called when content is hidden
     */
    override fun onHideContent() {
        super.onHideContent()
        isDeleteVisible = false
    }

    /**
     * Refresh
     */
    private fun setupRefresh() {
        binding?.swipeRefresh?.setOnRefreshListener {
            Timber.d("Refreshing note...")
            noteModel.refresh()
        }
    }

    /**
     * Performs action on error click
     */
    override fun onErrorClick() = noteModel.refresh()

    /**
     * Updates title
     */
    private fun patchTitle(title: String) {
        noteModel.setTitle(title)
    }

    /**
     * Updates text
     */
    private fun patchText(text: String) {
        noteModel.setText(text)
    }

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentNoteBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.binding = null
    }

    private fun Menu.setDeleteVisible() {
        findItem(R.id.action_delete)?.isVisible = isDeleteVisible
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu,inflater)
        inflater.inflate(R.menu.menu_fragment_note, menu)
        menu.setDeleteVisible()
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.setDeleteVisible()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRefresh()

        noteModel.state.observe(viewLifecycleOwner, { processState(it) })
        noteModel.initialize()

        binding?.run {
            patchTitle.setOnClickListener {
                patch(it, noteTitle) { title -> patchTitle(title) }
            }
            patchText.setOnClickListener {
                patch(it, noteText) { text -> patchText(text) }
            }
        }
    }

    private inline fun patch(button: View, edit: TextView, toDo: (String) -> Unit) {
        button.isEnabled = false
        toDo(edit.text.toString())
    }

    private fun restoreButtons() {
        binding?.run {
            patchTitle.isEnabled = true
            patchText.isEnabled = true
        }
    }
}
