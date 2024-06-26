/*
 * Copyright 2021 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.view

import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.CreationExtras
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.viewmodel.BaseLceModel
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argThat
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import kotlin.reflect.KClass
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LceStateViewTest {
    /**
     * Need this to test interface method implementation
     * https://github.com/nhaarman/mockito-kotlin/issues/41
     */
    private abstract class LceMock : LceStateView<Int>
    private interface ModelHost: ViewModelStoreOwner, HasDefaultViewModelProviderFactory

    private lateinit var stateView: LceStateView<Int>

    @Before
    fun init() {
        stateView = mock<LceMock>()
        whenever(stateView.processStateView(any())).thenCallRealMethod()
        whenever(stateView.processState(any())).thenCallRealMethod()
        whenever(stateView.isFatal(any())).thenCallRealMethod()
    }

    @Test
    fun processesState() {
        val content = LceState.Content(1, true)
        stateView.processState(content)
        verify(stateView).processStateData(1, isValid = true, isUpdating = false)
        verify(stateView).processStateView(content)
    }

    @Test
    fun processesStateDoesNotProcessDataIfNotSet() {
        val content = LceState.Loading(null, false)
        stateView.processState(content)
        verify(stateView, never()).processStateData(any(), any(), any())
    }

    @Test
    fun processesStateEvaluatesIsUpdatingWhenUpdating() {
        val content = LceState.Loading(1, true, LceState.Loading.Type.UPDATING)
        stateView.processState(content)
        verify(stateView).processStateData(1, isValid = true, isUpdating = true)
    }

    @Test
    fun processesStateEvaluatesIsUpdatingWhenLoading() {
        val content = LceState.Loading(1, true, LceState.Loading.Type.LOADING)
        stateView.processState(content)
        verify(stateView).processStateData(1, isValid = true, isUpdating = false)
    }

    @Test
    fun processStateViewShowsLoadingOnLoadingType() {
        val content = LceState.Loading(1, true, LceState.Loading.Type.LOADING)
        stateView.processStateView(content)
        verify(stateView).showLoading()
    }

    @Test
    fun processStateViewShowsRefreshingOnOtherTypes() {
        var content = LceState.Loading(1, true, LceState.Loading.Type.LOADING_MORE)
        stateView.processStateView(content)
        verify(stateView).showRefreshing(LceState.Loading.Type.LOADING_MORE)

        content = LceState.Loading(1, true, LceState.Loading.Type.REFRESHING)
        stateView.processStateView(content)
        verify(stateView).showRefreshing(LceState.Loading.Type.REFRESHING)

        content = LceState.Loading(1, true, LceState.Loading.Type.UPDATING)
        stateView.processStateView(content)
        verify(stateView).showRefreshing(LceState.Loading.Type.UPDATING)
    }

    @Test
    fun processStateViewShowsContentOnContent() {
        val content = LceState.Content(1, true)
        stateView.processStateView(content)
        verify(stateView).showContent()
    }

    @Test
    fun processStateViewShowsErrorOnFatalError() {
        whenever(stateView.isFatal(any())).thenReturn(true)
        val error = Exception("An error")
        val content = LceState.Error(null, false, error)
        stateView.processStateView(content)
        verify(stateView).showError(error)
    }

    @Test
    fun processStateViewShowsNonFatalErrorOnErrorWithData() {
        whenever(stateView.isFatal(any())).thenReturn(false)
        val error = Exception("An error")
        val content = LceState.Error(null, false, error)
        stateView.processStateView(content)
        verify(stateView).showContent()
        verify(stateView).showNonFatalError(error)
    }

    @Test
    fun processStateViewHandlesTermination() {
        val content = LceState.Terminated
        stateView.processStateView(content)
        verify(stateView).processTermination()
    }

    @Test
    fun initializesLceModel() {
        val liveData: LiveData<LceState<Int>> = mock()
        val lifecycleOwner: LifecycleOwner = mock()
        val model: BaseLceModel<Int> = mock {
            on { state } doReturn liveData
        }
        val factory: ViewModelProvider.Factory = mock {
            onGeneric { create(any<KClass<BaseLceModel<Int>>>(), any()) } doReturn model
        }
        val lceView: LceStateView<Int> = mock {
            on { getLifecycleOwner() } doReturn lifecycleOwner
        }
        val storeOwner: ModelHost = mock {
            on { viewModelStore } doReturn ViewModelStore()
            on { defaultViewModelProviderFactory } doReturn factory
            on { defaultViewModelCreationExtras } doReturn CreationExtras.Empty
        }

        assertEquals(model, lceView.initializeModel(storeOwner))
        assertTrue(model.initialized)
        argumentCaptor<Observer<LceState<Int>>>().apply {
            verify(liveData).observe(argThat { lifecycleOwner == this }, capture())

            val content = LceState.Content(1, true)
            firstValue.onChanged(content)
            verify(lceView).processState(content)
        }
    }
}