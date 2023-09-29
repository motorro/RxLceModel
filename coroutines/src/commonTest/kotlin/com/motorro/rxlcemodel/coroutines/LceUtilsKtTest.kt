/*
 * Copyright 2020 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.coroutines

import com.motorro.rxlcemodel.lce.LceState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class LceUtilsKtTest {
    companion object {
        private const val PARAMS = "params"
    }

    private fun createStateModel(vararg states: LceState<Int>) = object : LceModel<Int, String> {
        override val state: Flow<LceState<Int>> = states.asFlow()
        override suspend fun refresh() = throw NotImplementedError("An operation is not implemented")
        override val params: String = PARAMS
    }

    @Test
    fun terminateOnErrorWillUsePredicateToStop() = runTest {
        val error = Exception("error")
        val value = LceState.Error(null, false, error)
        val model = createStateModel(value)

        assertFailsWith<Exception> { model.state.terminateOnError { true }.collect() }
        model.state.terminateOnError { false }.collect {
            assertEquals(value, it)
        }
    }


    @Test
    fun stopOnErrorWillStopOnAnyError() = runTest {
        val error = Exception("error")
        val models = listOf(
            createStateModel(LceState.Error(null, false, error)),
            createStateModel(LceState.Error(1, true, error))
        )
        models.forEach {
            assertFailsWith<Exception> { it.state.stopOnErrors.collect() }
        }
    }

    @Test
    fun stopOnEmptyErrorWillStopOnEmptyError() = runTest {
        val error = Exception("error")
        val model1 = createStateModel(LceState.Error(null, false, error))
        val model2 = createStateModel(LceState.Error(1, true, error))

        assertFailsWith<Exception> { model1.state.stopOnErrors.collect() }
        model2.state.stopOnEmptyErrors.collect {
            assertEquals(LceState.Error(1, true, error), it)
        }
    }

    @Test
    fun getDataWillUsePredicateToMapError() = runTest {
        val error = Exception("error")
        val model = createStateModel(LceState.Error(null, false, error))

        assertFailsWith<Exception> { model.state.getData { true }.collect() }
        model.state.getData { false }.collect {
            throw Exception("No values expected")
        }
    }

    @Test
    fun getDataWillPassNonNullData() = runTest {
        val models = listOf(
                createStateModel(LceState.Loading(1, true)),
                createStateModel(LceState.Content(1, true)),
                createStateModel(LceState.Error(1, true, Exception()))
        )
        models.forEach {model ->
            model.state.getData { false }.collect {
                assertEquals(1, it)
            }
        }
    }

    @Test
    fun getDataWillNotPassNulls() = runTest {
        val models = listOf(
                createStateModel(LceState.Loading(null, false)),
                createStateModel(LceState.Error(null, false, Exception()))
        )
        models.forEach {
            it.state.getData { false }.collect {
                throw Exception("No values expected")
            }
        }
    }

    @Test
    fun getDataDistinctUntilDataChanged() = runTest {
        val model = createStateModel(LceState.Loading(1, true), LceState.Content(1, true))
        model.state.getData { false }.collect {
            assertEquals(1, it)
        }
    }

    @Test
    fun dataNoErrorsWillNotStopOnAnyError() = runTest {
        val error = Exception("error")
        createStateModel(LceState.Error(null, false, error))
            .state
            .dataNoErrors
            .collect {
                throw Exception("No values expected")
            }

        createStateModel(LceState.Error(1, true, error))
            .state
            .dataNoErrors
            .collect {
                assertEquals(1, it)
            }
    }

    @Test
    fun dataStopOnErrorWillStopOnAnyError() = runTest {
        val error = Exception("error")
        val models = listOf(
                createStateModel(LceState.Error(null, false, error)),
                createStateModel(LceState.Error(1, true, error))
        )
        models.forEach {
            assertFailsWith<Exception> { it.state.dataStopOnErrors.collect() }
        }
    }

    @Test
    fun dataStopOnEmptyErrorWillStopOnEmptyError() = runTest {
        val error = Exception("error")
        val model1 = createStateModel(LceState.Error(null, false, error))
        val model2 = createStateModel(LceState.Error(1, true, error))

        assertFailsWith<Exception> { model1.state.dataStopOnEmptyErrors.collect() }
        model2.state.dataStopOnEmptyErrors.collect {
            assertEquals(1, it)
        }
    }


    @Test
    fun validDataReturnsValidDataOnly() = runTest {
        val model = createStateModel(LceState.Loading(0, false), LceState.Content(1, true))
        model.state.validData.collect {
            assertEquals(1, it)
        }
    }

    @Test
    fun validDataDistinctUntilDataChanged() = runTest {
        val model = createStateModel(LceState.Content(1, true), LceState.Content(1, true))
        model.state.validData.collect {
            assertEquals(1, it)
        }
    }

    @Test
    fun validDataWillStopOnAnyError() = runTest {
        val error = Exception("error")
        val models = listOf(
                createStateModel(LceState.Error(null, false, error)),
                createStateModel(LceState.Error(1, true, error))
        )
        models.forEach {
            assertFailsWith<Exception> { it.state.validData.collect() }
        }
    }

    @Test
    fun flatMapsSingleData() = runTest {
        val error = Exception("error")

        fun mapper(input: Int) = input.toString()

        val source = flowOf(
            LceState.Loading(null, false),
            LceState.Loading(1, true),
            LceState.Content(2, true),
            LceState.Error(null, false, error),
            LceState.Error(3, true, error),
            LceState.Terminated
        )

        assertEquals(
            listOf(
                LceState.Loading(null, false),
                LceState.Loading("1", true),
                LceState.Content("2", true),
                LceState.Error(null, false, error),
                LceState.Error("3", true, error),
                LceState.Terminated
            ),
            source.flatMapSingleData(::mapper).toList()
        )
    }

    @Test
    fun returnsErrorIfSingleDataMapperFails() = runTest {
        val error1 = Exception("error 1")
        val error2 = Exception("error 2")

        @Suppress("UNUSED_PARAMETER")
        fun mapper(input: Int): String = throw error2

        val source = flowOf(
            LceState.Loading(null, false),
            LceState.Loading(1, true),
            LceState.Content(2, true),
            LceState.Error(null, false, error1),
            LceState.Error(3, true, error1),
            LceState.Terminated
        )

        assertEquals(
            listOf(
                LceState.Loading(null, false),
                LceState.Error(null, false, error2),
                LceState.Error(null, false, error2),
                LceState.Error(null, false, error1),
                LceState.Error(null, false, error1),
                LceState.Terminated
            ),
            source.flatMapSingleData(::mapper).toList()
        )
    }

    @Test
    fun singleDataMapperBypassesCancellationExceptions() = runTest {
        val error1 = Exception("error 1")
        val error2 = CancellationException("Cancelled")

        @Suppress("UNUSED_PARAMETER")
        fun mapper(input: Int): String = throw error2

        val source = flowOf(
            LceState.Loading(null, false),
            LceState.Content(2, true)
        )

        val result = source.flatMapSingleData(::mapper).toList()
        assertEquals(1, result.size)
    }

    @Test
    fun mapsUseCaseData() = runTest {
        val error = Exception()



        val source: LceUseCase<Int>  = createStateModel(
            LceState.Loading(null, false),
            LceState.Content(10, true),
            LceState.Error(15, true, error)
        )

        assertEquals(
            listOf(
                LceState.Loading(null, false),
                LceState.Content(20, true),
                LceState.Error(30, true, error)
            ),
            source.map { it * 2 }.state.toList()
        )
    }

    @Test
    fun mapsModelData() = runTest {
        val error = Exception()
        val source = createStateModel(
            LceState.Loading(null, false),
            LceState.Content(10, true),
            LceState.Error(15, true, error)
        )

        assertEquals(
            listOf(
                LceState.Loading(null, false),
                LceState.Content(20, true),
                LceState.Error(30, true, error)
            ),
            source.map { it * 2 }.state.toList()
        )
    }

    @Test
    fun createsRefreshingStream() = runTest {
        val value1 = LceState.Content(1, true)
        val value2 = LceState.Content(2, true)
        val refreshStream = MutableSharedFlow<Int>()
        val model = object : LceModel<Int, String> {
            val stateSubject = MutableStateFlow<LceState<Int>>(value1)
            var refreshed = false

            override val state: Flow<LceState<Int>> = stateSubject
            override suspend fun refresh() {
                refreshed = true
                stateSubject.value = value2
            }
            override val params: String = PARAMS
        }

        val values = mutableListOf<LceState<Int>>()
        val collectJob = launch(UnconfinedTestDispatcher(testScheduler)) {
            model.withRefresh(refreshStream).toList(values)
        }

        assertEquals(listOf<LceState<Int>>(value1), values)

        refreshStream.emit(1)

        assertEquals(listOf<LceState<Int>>(value1, value2), values)

        collectJob.cancel()
    }

    @Test
    fun refreshedLceStreamRefreshesValidContentOnStartOnce() = runTest {
        val value1: LceState<Int> = LceState.Content(1, true)
        val value2: LceState<Int> = LceState.Content(2, true)

        var refreshedTimes = 0
        fun refresh() { ++refreshedTimes }

        assertEquals(
            listOf(value1, value2),
            flowOf(value1, value2).refreshed(::refresh).toList()
        )

        assertEquals(1, refreshedTimes)
    }

    @Test
    fun refreshedLceStreamDoesNotRefreshIfLoading() = runTest {
        val value1: LceState<Int> = LceState.Loading(null, false)
        val value2: LceState<Int> = LceState.Content(2, true)

        var refreshedTimes = 0
        fun refresh() { ++refreshedTimes }

        assertEquals(
            listOf(value1, value2),
            flowOf(value1, value2).refreshed(::refresh).toList()
        )

        assertEquals(0, refreshedTimes)
    }

    @Test
    fun refreshedLceStreamDoesNotRefreshIfError() = runTest {
        val value1: LceState<Int> = LceState.Error(null, false, Exception())
        val value2: LceState<Int> = LceState.Content(2, true)

        var refreshedTimes = 0
        fun refresh() { ++refreshedTimes }

        assertEquals(
            listOf(value1, value2),
            flowOf(value1, value2).refreshed(::refresh).toList()
        )

        assertEquals(0, refreshedTimes)
    }

    @Test
    fun refreshedUseCaseRefreshesOnEachSubscribe() = runTest {
        val value1: LceState<Int> = LceState.Content(1, true)
        val value2: LceState<Int> = LceState.Content(2, true)
        val source: MutableSharedFlow<LceState<Int>> = MutableSharedFlow()
        var refreshedTimes = 0

        val useCase: LceUseCase<Int> = object : LceUseCase<Int> {
            override val state: Flow<LceState<Int>> = source
            override suspend fun refresh() { ++refreshedTimes }
        }

        val refreshed = useCase.refreshed()

        val values1 = mutableListOf<LceState<Int>>()
        val collectJob1 = launch(UnconfinedTestDispatcher(testScheduler)) {
            refreshed.state.toList(values1)
        }
        source.emit(value1)
        assertEquals(listOf(value1), values1)
        assertEquals(1, refreshedTimes)

        val values2 = mutableListOf<LceState<Int>>()
        val collectJob2 = launch(UnconfinedTestDispatcher(testScheduler)) {
            refreshed.state.toList(values2)
        }
        source.emit(value2)
        assertEquals(listOf(value1, value2), values1)
        assertEquals(listOf(value2), values2)
        assertEquals(2, refreshedTimes)

        collectJob1.cancel()
        collectJob2.cancel()
    }

    @Test
    fun substitutesEmptyLoading() = runTest {
        val original = LceState.Loading(null, false)
        val substitute = LceState.Content(10, true)
        val source = flowOf<LceState<Int>>(original)
        val modified = source.onEmptyLoadingReturn { substitute }
        modified.collect {
            assertEquals(substitute, it)
        }
    }

    @Test
    fun passesNonEmptyLoading() = runTest {
        val original = LceState.Loading(10, true)
        val substitute = LceState.Content(10, true)
        val source = flowOf<LceState<Int>>(original)
        val modified = source.onEmptyLoadingReturn { substitute }
        modified.collect {
            assertEquals(original, it)
        }
    }

    @Test
    fun substitutesEmptyLoadingData() = runTest {
        val original = LceState.Loading(null, false)
        val substitute = 10
        val source = flowOf<LceState<Int>>(original)
        val modified = source.onEmptyLoadingReturnItem { substitute }
        modified.collect {
            assertEquals(LceState.Loading(10, false), it)
        }
    }

    @Test
    fun passesNonEmptyLoadingData() = runTest {
        val original = LceState.Loading(10, true)
        val substitute = 10
        val source = flowOf<LceState<Int>>(original)
        val modified = source.onEmptyLoadingReturnItem { substitute }
        modified.collect {
            assertEquals(original, it)
        }
    }

    @Test
    fun catchesErrorToLce() = runTest {
        val error = Exception()
        val source = flow<LceState<Int>> {
            throw error
        }
        source.errorToLce { 5 }.collect {
            assertEquals(LceState.Error(5, false, error), it)
        }
    }
}