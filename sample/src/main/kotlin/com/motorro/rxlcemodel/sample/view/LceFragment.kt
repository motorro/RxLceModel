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

package com.motorro.rxlcemodel.sample.view

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.motorro.rxlcemodel.rx.LceState
import com.motorro.rxlcemodel.rx.LceState.*
import com.motorro.rxlcemodel.sample.R
import com.motorro.rxlcemodel.view.LceStateView
import timber.log.Timber

/**
 * Fragment to display Loading/Content/Error and a non-fatal error in case there is a content to display
 */
abstract class LceFragment<CV: View, DATA: Any>: Fragment(), LceStateView<DATA> {
    private var _loadingView: View? = null
    private var _contentView: CV? = null
    private var _errorView: TextView? = null
    private var _stateDisplay: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _loadingView = view.findViewById(R.id.loading_view) ?: throw RuntimeException("No loading view")

        _contentView = view.findViewById(R.id.content_view) as? CV ?: throw RuntimeException("No content view or incompatible view")

        _errorView = (view.findViewById(R.id.error_view) as? TextView)?.apply {
            setOnClickListener { onErrorClick() }
        } ?: throw RuntimeException("No error view or incompatible view")

        _stateDisplay = (view.findViewById(R.id.state_display)) as? TextView
    }

    /**
     * Returns lifecycle owner
     */
    override fun getLifecycleOwner(): LifecycleOwner = viewLifecycleOwner

    /**
     * Call to process view state and data whenever new state arrives from model
     */
    override fun processState(state: LceState<DATA>) {
        super.processState(state)
        updateStateDisplay(state)
    }

    /**
     * Called when content is displayed
     */
    protected open fun onShowContent(): Unit = Unit

    /**
     * Called when content is hidden
     */
    protected open fun onHideContent(): Unit = Unit

    /**
     * Displays current state for 
     */
    private fun updateStateDisplay(state: LceState<DATA>) {
        _stateDisplay?.text = when(state) {
            is Loading -> "Loading (${state.type})"
            is Content -> "Content"
            is Error -> "Error (${ if (null != state.data) "with cached" else "no"} data)"
            is Terminated -> "Terminated"
        }
    }

    /**
     * Displays loading when no data available
     */
    override fun showLoading() {
        Timber.d("Show `Loading`")
        _loadingView?.visibility = VISIBLE
        _contentView?.visibility = GONE
        _errorView?.visibility = GONE
        onHideContent()
    }

    /**
     * Displays data refresh
     */
    @CallSuper
    protected open fun showRefreshing(){
        Timber.d("Show `Refreshing`")
    }

    /**
     * Displays content
     */
    override fun showContent() {
        Timber.d("Show `Content`")
        _loadingView?.visibility = GONE
        _contentView?.visibility = VISIBLE
        _errorView?.visibility = GONE
        onShowContent()
    }

    /**
     * Displays content when there is no data to display
     */
    override fun showError(error: Throwable) {
        Timber.w(error, "Show `Error`")
        _errorView?.run {
            text = error.message
            _loadingView?.visibility = GONE
            _contentView?.visibility = GONE
            _errorView?.visibility = VISIBLE
        }
        onHideContent()
    }

    /**
     * Performs action on error click
     */
    protected abstract fun onErrorClick()

    /**
     * Displays some error notification when the error is non-critical and some content may be displayed
     */
    override fun showNonFatalError(error: Throwable) {
        activity?.let {
            Timber.w(error, "Show `Non-fatal error`")
            Toast.makeText(it, error.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _loadingView = null
        _contentView = null
        _errorView?.setOnClickListener(null)
        _errorView = null
        _stateDisplay = null
    }
}