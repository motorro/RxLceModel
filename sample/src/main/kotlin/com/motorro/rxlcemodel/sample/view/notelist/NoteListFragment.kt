
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
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.sample.databinding.FragmentNoteListBinding
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.view.LceFragment
import com.motorro.rxlcemodel.sample.view.TIME_FORMATTER
import com.motorro.rxlcemodel.viewmodel.BaseLceModel
import dagger.android.support.AndroidSupportInjection
import timber.log.Timber
import javax.inject.Inject

class NoteListFragment : LceFragment<ViewGroup, NoteList>() {
    /**
     * Factory for [noteListModel]
     */
    @Inject
    lateinit var noteListModelFactory: ViewModelProvider.Factory

    /**
     * Model to load note list
     */
    private val noteListModel: BaseLceModel<NoteList> by viewModels { noteListModelFactory }

    /**
     * List adapter
     */
    private val listAdapter = UserListAdapter(this::onNoteClicked)

    /**
     * View-binding
     */
    private var binding: FragmentNoteListBinding? = null

    /**
     * Called by [processState] to process new data
     */
    override fun processStateData(data: NoteList, isValid: Boolean, isUpdating: Boolean) {
        binding?.run {
            loadedAt.text = TIME_FORMATTER.format(data.timeStamp)
            isValidData.text = isValid.toString()
            listAdapter.notes = data.notes
            if (data.notes.isNotEmpty()) {
                dataView.visibility = View.VISIBLE
                noDataView.visibility = View.GONE
            } else {
                dataView.visibility = View.GONE
                noDataView.visibility = View.VISIBLE
            }
        }
    }

    /**
     * Updates view according to [state]
     * Removes refresh indicator when load completes
     */
    override fun processStateView(state: LceState<NoteList>) {
        super.processStateView(state)
        if (state is LceState.Error || state is LceState.Content) {
            binding?.swipeRefresh?.isRefreshing = false
        }
    }

    /**
     * Refresh
     */
    private fun setupRefresh() {
        binding?.swipeRefresh?.setOnRefreshListener {
            Timber.d("Refreshing note list...")
            noteListModel.refresh()
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentNoteListBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUserList()
        setupRefresh()
        binding?.addNote?.setOnClickListener { onAddClicked() }

        @Suppress("UNCHECKED_CAST")
        noteListModel.state.observe(viewLifecycleOwner, { processState(it) })
        noteListModel.initialize()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.binding = null
    }

    private fun setupUserList() {
        val layoutManager = LinearLayoutManager(this.context)
        binding?.run {
            noteList.layoutManager = layoutManager
            noteList.adapter = listAdapter
            noteList.setHasFixedSize(true)
            val itemDecoration = DividerItemDecoration(
                noteList.context,
                layoutManager.orientation
            )
            noteList.addItemDecoration(itemDecoration)
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
