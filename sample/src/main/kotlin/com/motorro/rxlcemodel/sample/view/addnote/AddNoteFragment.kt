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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.motorro.rxlcemodel.base.LceState
import com.motorro.rxlcemodel.sample.R
import com.motorro.rxlcemodel.sample.view.LceFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_add_note.*
import javax.inject.Inject

class AddNoteFragment: LceFragment<ViewGroup, Unit, Unit>() {

    /**
     * Factory for [noteModel]
     */
    @Inject
    lateinit var noteModelFactory: ViewModelProvider.Factory

    /**
     * Model to load a note
     */
    private lateinit var noteModel: AddNoteViewModel

    /**
     * Called by [processState] to process new data
     */
    override fun processStateData(data: Unit, isValid: Boolean, isUpdating: Boolean) = Unit

    /**
     * Creates new note
     */
    private fun addNote() {
        noteModel.add(note_title.text.toString(), note_text.text.toString())
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_add_note, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteModel = ViewModelProviders.of(this, noteModelFactory).get(AddNoteViewModel::class.java)
        noteModel.state.observe(this, Observer<LceState<Unit, Unit>> { processState(it) })
        noteModel.initialize()

        add_note.setOnClickListener { addNote() }
    }
}