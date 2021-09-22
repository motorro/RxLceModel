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

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.motorro.rxlcemodel.TestAppTest
import com.motorro.rxlcemodel.base.LceState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@RunWith(RobolectricTestRunner::class)
class LceStateViewTest : TestAppTest() {
    private companion object {
        const val LOADING_TEXT = "Loading"
        const val CONTENT_TEXT = "Content"
        const val FATAL_ERROR_TEXT = "Fatal error"
        const val NON_FATAL_ERROR_TEXT = "Non fatal error"
    }

    @get:Rule
    val composeTestRule: ComposeContentTestRule = createComposeRule()

    @Composable
    private fun TestLoading() {
        Text(text = LOADING_TEXT)
    }

    @Composable
    private fun Content() {
        Text(text = CONTENT_TEXT)
    }

    @Composable
    private fun TestFatalError() {
        Text(text = FATAL_ERROR_TEXT)
    }

    @Composable
    private fun TestNonFatalError() {
        Text(text = NON_FATAL_ERROR_TEXT)
    }

    private fun assertContentDisplayed() {
        composeTestRule.onNodeWithText(CONTENT_TEXT).assertIsDisplayed()
    }

    private fun assertContentNotDisplayed() {
        composeTestRule.onNodeWithText(CONTENT_TEXT).assertDoesNotExist()
    }

    @Composable
    private fun TestLceStateView(
        viewState: LceState<Int>,
        loading: @Composable () -> Unit = { TestLoading() },
        fatalError: @Composable (error: Throwable) -> Unit = {
            TestFatalError()
        },
        nonFatalError: @Composable (error: Throwable) -> Unit = {
            TestNonFatalError()
        },
        termination: @Composable () -> Unit = { },
        isFatalError: (LceState.Error<Int>) -> Boolean = { null == it.data },
        content: @Composable (data: Int, isValid: Boolean, refreshing: Boolean) -> Unit
    ) {
        LceStateView(
            viewState = viewState,
            onRefresh = { },
            loading = loading,
            fatalError = fatalError,
            nonFatalError = nonFatalError,
            termination = termination,
            isFatalError = isFatalError,
            content = content
        )
    }

    @Test
    fun displaysLoadingWhenDataIsNull() {
        composeTestRule.setContent {
            TestLceStateView(viewState = LceState.Loading(null, false)) { _, _, _ ->
                Content()
            }
        }
        composeTestRule.onNodeWithText(LOADING_TEXT).assertIsDisplayed()
        composeTestRule.onNodeWithText(FATAL_ERROR_TEXT).assertDoesNotExist()
        assertContentNotDisplayed()
    }

    @Test
    fun displaysLoadingWhenDataNotNullButLoadingTypeIsLoading() {
        composeTestRule.setContent {
            TestLceStateView(viewState = LceState.Loading(1, true,
                LceState.Loading.Type.LOADING
            )) { _, _, _ ->
                Content()
            }
        }
        composeTestRule.onNodeWithText(LOADING_TEXT).assertIsDisplayed()
        composeTestRule.onNodeWithText(FATAL_ERROR_TEXT).assertDoesNotExist()
        assertContentNotDisplayed()
    }

    @Test
    fun displaysContentWithRefreshingOnOtherLoadingType() {
        composeTestRule.setContent {
            TestLceStateView(viewState = LceState.Loading(1, true,
                LceState.Loading.Type.REFRESHING
            )) { data, dataIsValid, refreshing ->
                assertEquals(1, data)
                assertTrue { dataIsValid }
                assertTrue { refreshing }
                Content()
            }
        }
        composeTestRule.onNodeWithText(LOADING_TEXT).assertDoesNotExist()
        composeTestRule.onNodeWithText(FATAL_ERROR_TEXT).assertDoesNotExist()
        assertContentDisplayed()
    }

    @Test
    fun displaysContentOnContent() {
        composeTestRule.setContent {
            TestLceStateView(viewState = LceState.Content(1, true)) { data, dataIsValid, refreshing ->
                assertEquals(1, data)
                assertTrue { dataIsValid }
                assertFalse { refreshing }
                Content()
            }
        }
        composeTestRule.onNodeWithText(LOADING_TEXT).assertDoesNotExist()
        composeTestRule.onNodeWithText(FATAL_ERROR_TEXT).  assertDoesNotExist()
        assertContentDisplayed()
    }

    @Test
    fun displaysFatalErrorOnErrorWithoutData() {
        val lceError = IOException("Error")
        composeTestRule.setContent {
            TestLceStateView(
                viewState = LceState.Error(
                    data = null,
                    dataIsValid = false,
                    error = lceError
                ),
                fatalError = { error ->
                    assertEquals(lceError, error)
                    TestFatalError()
                },
                isFatalError = { false }
            ) { _, _, _ ->
                Content()
            }
        }
        composeTestRule.onNodeWithText(LOADING_TEXT).assertDoesNotExist()
        composeTestRule.onNodeWithText(FATAL_ERROR_TEXT).assertIsDisplayed()
        assertContentNotDisplayed()
    }

    @Test
    fun displaysFatalErrorOnFatalError() {
        val lceError = IOException("Error")
        composeTestRule.setContent {
            TestLceStateView(
                viewState = LceState.Error(
                    data = 1,
                    dataIsValid = false,
                    error = lceError
                ),
                fatalError = { error ->
                    assertEquals(lceError, error)
                    TestFatalError()
                },
                isFatalError = { true }
            ) { _, _, _ ->
                Content()
            }
        }
        composeTestRule.onNodeWithText(LOADING_TEXT).assertDoesNotExist()
        composeTestRule.onNodeWithText(FATAL_ERROR_TEXT).assertIsDisplayed()
        assertContentNotDisplayed()
    }

    @Test
    fun displaysNonFatalErrorOnErrorWithData() {
        val lceError = IOException("Error")
        composeTestRule.setContent {
            TestLceStateView(
                viewState = LceState.Error(
                    data = 1,
                    dataIsValid = true,
                    error = lceError
                ),
                fatalError = { error ->
                    assertEquals(lceError, error)
                    TestFatalError()
                },
                isFatalError = { false }
            ) { data, dataIsValid, refreshing ->
                assertEquals(1, data)
                assertTrue { dataIsValid }
                assertFalse { refreshing }
                Content()
            }
        }
        composeTestRule.onNodeWithText(LOADING_TEXT).assertDoesNotExist()
        composeTestRule.onNodeWithText(FATAL_ERROR_TEXT).assertDoesNotExist()
        assertContentDisplayed()
        composeTestRule.onNodeWithText(NON_FATAL_ERROR_TEXT).assertIsDisplayed()
    }
}