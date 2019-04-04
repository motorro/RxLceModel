
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

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.view.BaseLceModel
import com.motorro.rxlcemodel.sample.view.LceFragment
import com.motorro.rxlcemodel.sample.view.TIME_FORMATTER
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_note_list.*
import timber.log.Timber
import javax.inject.Inject

class NoteListFragment : LceFragment<ViewGroup, NoteList, Unit>() {
    /**
     * Factory for [noteListModel]
     */
    @Inject
    lateinit var noteListModelFactory: ViewModelProvider.Factory

    /**
     * Model to load note list
     */
    private lateinit var noteListModel: BaseLceModel<NoteList, Unit>

    /**
     * List adapter
     */
    private val listAdapter = UserListAdapter(this::onNoteClicked)

    /**
     * Called by [processState] to process new data
     */
    override fun processStateData(data: NoteList, isValid: Boolean, isUpdating: Boolean) {
        loaded_at.text = TIME_FORMATTER.format(data.timeStamp)
        is_valid_data.text = isValid.toString()
        listAdapter.notes = data.notes
        if (data.notes.isNotEmpty()) {
            data_view.visibility = View.VISIBLE
            no_data_view.visibility = View.GONE
        } else {
            data_view.visibility = View.GONE
            no_data_view.visibility = View.VISIBLE
        }
    }

    /**
     * Updates view according to [state]
     * Removes refresh indicator when load completes
     */
    override fun processStateView(state: LceState<NoteList, Unit>) {
        super.processStateView(state)
        if (state is LceState.Error || state is LceState.Content) {
            swipe_refresh.isRefreshing = false
        }
    }

    /**
     * Performs action on error click
     */
    override fun onErrorClick() = noteListModel.refresh()

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(com.motorro.rxlcemodel.sample.R.layout.fragment_note_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUserList()
        setupRefresh()
        add_note.setOnClickListener { onAddClicked() }

        @Suppress("UNCHECKED_CAST")
        noteListModel = ViewModelProviders.of(this, noteListModelFactory).get(BaseLceModel::class.java) as BaseLceModel<NoteList, Unit>
        noteListModel.state.observe(this, Observer<LceState<NoteList, Unit>> { processState(it) })
        noteListModel.initialize()
    }

    private fun setupUserList() {
        val layoutManager = LinearLayoutManager(this.context)
        note_list.layoutManager = layoutManager
        note_list.adapter = listAdapter
        note_list.setHasFixedSize(true)
        val itemDecoration = DividerItemDecoration(
            note_list.context,
            layoutManager.orientation
        )
        note_list.addItemDecoration(itemDecoration)
    }

    private fun setupRefresh() {
        swipe_refresh.setOnRefreshListener {
            Timber.d("Refreshing note list...")
            noteListModel.refresh()
        }
    }

    private fun onNoteClicked(id: Int, title: CharSequence) {
        Timber.d("Opening note $id")
        view?.findNavController()?.navigate(
            NoteListFragmentDirections.actionNoteListFragmentToNoteFragment(id, title.toString())
        )
    }

    private fun onAddClicked() {
        Timber.d("Going to add a note...")
        view?.findNavController()?.navigate(
            NoteListFragmentDirections.actionNoteListFragmentToAddNoteFragment()
        )
    }
}
