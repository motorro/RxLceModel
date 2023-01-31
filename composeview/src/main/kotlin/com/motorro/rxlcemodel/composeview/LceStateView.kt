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

package com.motorro.rxlcemodel.composeview

import androidx.compose.runtime.Composable
import com.motorro.rxlcemodel.composeview.view.SwipeRefresh
import com.motorro.rxlcemodel.lce.LceState

/**
 * Attaches composable view to view-model
 * @param viewState View state
 * @param onRefresh Refresh handler
 * @param loading Loading override
 * @param fatalError Fatal error override
 * @param nonFatalError Non-fatal error override
 * @param termination Termination override
 * @param isFatalError Checks if error is fatal
 * @param content Content rendering function
 */
@Composable
fun <DATA : Any> LceStateView(
    viewState: LceState<DATA>,
    onRefresh: () -> Unit,
    loading: @Composable () -> Unit,
    fatalError: @Composable (error: Throwable) -> Unit,
    nonFatalError: @Composable (error: Throwable) -> Unit,
    termination: @Composable () -> Unit,
    isFatalError: (LceState.Error<DATA>) -> Boolean = { null == it.data },
    content: @Composable (data: DATA, isValid: Boolean, refreshing: Boolean) -> Unit
) {
    when (viewState) {
        is LceState.Loading -> {
            val data = viewState.data
            when {
                null == data -> {
                    loading()
                }
                LceState.Loading.Type.LOADING == viewState.type -> {
                    loading()
                }
                else -> {
                    content(data, viewState.dataIsValid, true)
                }
            }
        }
        is LceState.Content -> {
            SwipeRefresh(false, onRefresh) {
                content(viewState.data, viewState.dataIsValid, false)
            }
        }
        is LceState.Error -> {
            val data = viewState.data
            when {
                isFatalError(viewState) || null == data -> {
                    fatalError(viewState.error)
                }
                else -> {
                    content(data, viewState.dataIsValid, false)
                    nonFatalError(viewState.error)
                }
            }
        }
        is LceState.Terminated -> {
            termination()
        }
    }
}
