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

package com.motorro.rxlcemodel.base

import io.reactivex.Completable
import io.reactivex.Observable
import org.junit.Test

class LceModelKtTest {
    companion object {
        private const val PARAMS = "params"
    }

    private fun createStateModel(vararg states: LceState<Int, String>) = object : LceModel<Int, String> {
        override val state: Observable<LceState<Int, String>> = Observable.fromArray(*states)
        override val refresh: Completable = Completable.error(NotImplementedError("An operation is not implemented"))
        override val params: String = PARAMS
    }

    @Test
    fun terminateOnErrorWillUsePredicateToStop() {
        val error = Exception("error")
        val value = LceState.Error(null, false, PARAMS, error)
        val model = createStateModel(value)

        model.state.terminateOnError { true }.test().assertNoValues().assertError(error)
        model.state.terminateOnError { false }.test().assertNoErrors().assertComplete().assertValues(value)
    }


    @Test
    fun stopOnErrorWillStopOnAnyError() {
        val error = Exception("error")
        val models = listOf(
                createStateModel(LceState.Error(null, false, PARAMS, error)),
                createStateModel(LceState.Error(1, true, PARAMS, error))
        )
        models.forEach {
            it.state.stopOnErrors.test().assertNoValues().assertError(error)
        }
    }

    @Test
    fun stopOnEmptyErrorWillStopOnEmptyError() {
        val error = Exception("error")
        val model1 = createStateModel(LceState.Error(null, false, PARAMS, error))
        val model2 = createStateModel(LceState.Error(1, true, PARAMS, error))

        model1.state.stopOnErrors.test().assertNoValues().assertError(error)
        model2.state.stopOnEmptyErrors.test().assertNoErrors().assertComplete().assertValues(LceState.Error(1, true, PARAMS, error))
    }

    @Test
    fun getDataWillUsePredicateToMapError() {
        val error = Exception("error")
        val model = createStateModel(LceState.Error(null, false, PARAMS, error))

        model.state.getData { true }.test().assertNoValues().assertError(error)
        model.state.getData { false }.test().assertNoErrors().assertComplete()
    }

    @Test
    fun getDataWillPassNonNullData() {
        val models = listOf(
                createStateModel(LceState.Loading(1, true, PARAMS)),
                createStateModel(LceState.Content(1, true, PARAMS)),
                createStateModel(LceState.Error(1, true, PARAMS, Exception()))
        )
        models.forEach {
            it.state.getData { false }.test().assertNoErrors().assertComplete().assertValues(1)
        }
    }

    @Test
    fun getDataWillNotPassNulls() {
        val models = listOf(
                createStateModel(LceState.Loading(null, false, PARAMS)),
                createStateModel(LceState.Error(null, false, PARAMS, Exception()))
        )
        models.forEach {
            it.state.getData { false }.test().assertNoErrors().assertComplete().assertNoValues()
        }
    }

    @Test
    fun getDataDistinctUntilDataChanged() {
        val model = createStateModel(LceState.Loading(1, true, PARAMS), LceState.Content(1, true, PARAMS))
        model.state.getData { false }.test().assertNoErrors().assertComplete().assertValues(1)
    }

    @Test
    fun dataNoErrorsWillNotStopOnAnyError() {
        val error = Exception("error")
        createStateModel(LceState.Error(null, false, PARAMS, error))
                .state
                .dataNoErrors
                .test()
                .assertNoValues()
                .assertComplete()

        createStateModel(LceState.Error(1, true, PARAMS, error))
                .state
                .dataNoErrors
                .test()
                .assertValues(1)
                .assertComplete()
    }

    @Test
    fun dataStopOnErrorWillStopOnAnyError() {
        val error = Exception("error")
        val models = listOf(
                createStateModel(LceState.Error(null, false, PARAMS, error)),
                createStateModel(LceState.Error(1, true, PARAMS, error))
        )
        models.forEach {
            it.state.dataStopOnErrors.test().assertNoValues().assertError(error)
        }
    }

    @Test
    fun dataStopOnEmptyErrorWillStopOnEmptyError() {
        val error = Exception("error")
        val model1 = createStateModel(LceState.Error(null, false, PARAMS, error))
        val model2 = createStateModel(LceState.Error(1, true, PARAMS, error))

        model1.state.dataStopOnEmptyErrors.test().assertNoValues().assertError(error)
        model2.state.dataStopOnEmptyErrors.test().assertNoErrors().assertComplete().assertValues(1)
    }


    @Test
    fun validDataReturnsValidDataOnly() {
        val model = createStateModel(LceState.Loading(0, false, PARAMS), LceState.Content(1, true, PARAMS))
        model.state.validData.test().assertNoErrors().assertComplete().assertValues(1)
    }

    @Test
    fun validDataDistinctUntilDataChanged() {
        val model = createStateModel(LceState.Content(1, true, PARAMS), LceState.Content(1, true, PARAMS))
        model.state.validData.test().assertNoErrors().assertComplete().assertValues(1)
    }

    @Test
    fun validDataWillStopOnAnyError() {
        val error = Exception("error")
        val models = listOf(
                createStateModel(LceState.Error(null, false, PARAMS, error)),
                createStateModel(LceState.Error(1, true, PARAMS, error))
        )
        models.forEach {
            it.state.validData.test().assertNoValues().assertError(error)
        }
    }
}