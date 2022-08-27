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

package com.motorro.rxlcemodel.sample.view.addnote

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.sample.databinding.FragmentAddNoteBinding
import com.motorro.rxlcemodel.sample.view.LceFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AddNoteFragment: LceFragment<ViewGroup, Unit>() {

    /**
     * Factory for [noteModel]
     */
    @Inject
    lateinit var noteModelFactory: ViewModelProvider.Factory

    /**
     * Model to load a note
     */
    private val noteModel: AddNoteViewModel by viewModels { noteModelFactory }

    /**
     * View-binding
     */
    private var binding: FragmentAddNoteBinding? = null

    /**
     * Called by [processState] to process new data
     */
    override fun processStateData(data: Unit, isValid: Boolean, isUpdating: Boolean) = Unit

    /**
     * Creates new note
     */
    private fun addNote() {
        binding?.run {
            noteModel.add(noteTitle.text.toString(), noteText.text.toString())
        }
    }

    /**
     * Performs action on error click
     */
    override fun onErrorClick() = processTermination()

    /**
     * Process [LceState.Terminated]
     */
    override fun processTermination() {
        findNavController().popBackStack()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteModel.state.observe(viewLifecycleOwner, { processState(it) })
        noteModel.initialize()

        binding?.addNote?.setOnClickListener { addNote() }
    }
}