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

package com.motorro.rxlcemodel.rx

import com.motorro.rxlcemodel.lce.LceState
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import org.junit.Test
import java.io.IOException
import kotlin.test.assertEquals

class LceUtilsKtTest {
    companion object {
        private const val PARAMS = "params"
    }

    private fun createStateModel(vararg states: LceState<Int>) = object : LceModel<Int, String> {
        override val state: Observable<LceState<Int>> = Observable.fromArray(*states)
        override val refresh: Completable = Completable.error(NotImplementedError("An operation is not implemented"))
        override val params: String = PARAMS
    }

    @Test
    fun terminateOnErrorWillUsePredicateToStop() {
        val error = Exception("error")
        val value = LceState.Error(null, false, error)
        val model = createStateModel(value)

        model.state.terminateOnError { true }.test().assertNoValues().assertError(error)
        model.state.terminateOnError { false }.test().assertNoErrors().assertComplete().assertValues(value)
    }


    @Test
    fun stopOnErrorWillStopOnAnyError() {
        val error = Exception("error")
        val models = listOf(
                createStateModel(LceState.Error(null, false, error)),
                createStateModel(LceState.Error(1, true, error))
        )
        models.forEach {
            it.state.stopOnErrors.test().assertNoValues().assertError(error)
        }
    }

    @Test
    fun stopOnEmptyErrorWillStopOnEmptyError() {
        val error = Exception("error")
        val model1 = createStateModel(LceState.Error(null, false, error))
        val model2 = createStateModel(LceState.Error(1, true, error))

        model1.state.stopOnErrors.test().assertNoValues().assertError(error)
        model2.state.stopOnEmptyErrors.test().assertNoErrors().assertComplete().assertValues(LceState.Error(1, true, error))
    }

    @Test
    fun getDataWillUsePredicateToMapError() {
        val error = Exception("error")
        val model = createStateModel(LceState.Error(null, false, error))

        model.state.getData { true }.test().assertNoValues().assertError(error)
        model.state.getData { false }.test().assertNoErrors().assertComplete()
    }

    @Test
    fun getDataWillPassNonNullData() {
        val models = listOf(
                createStateModel(LceState.Loading(1, true)),
                createStateModel(LceState.Content(1, true)),
                createStateModel(LceState.Error(1, true, Exception()))
        )
        models.forEach {
            it.state.getData { false }.test().assertNoErrors().assertComplete().assertValues(1)
        }
    }

    @Test
    fun getDataWillNotPassNulls() {
        val models = listOf(
                createStateModel(LceState.Loading(null, false)),
                createStateModel(LceState.Error(null, false, Exception()))
        )
        models.forEach {
            it.state.getData { false }.test().assertNoErrors().assertComplete().assertNoValues()
        }
    }

    @Test
    fun getDataDistinctUntilDataChanged() {
        val model = createStateModel(LceState.Loading(1, true), LceState.Content(1, true))
        model.state.getData { false }.test().assertNoErrors().assertComplete().assertValues(1)
    }

    @Test
    fun dataNoErrorsWillNotStopOnAnyError() {
        val error = Exception("error")
        createStateModel(LceState.Error(null, false, error))
                .state
                .dataNoErrors
                .test()
                .assertNoValues()
                .assertComplete()

        createStateModel(LceState.Error(1, true, error))
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
                createStateModel(LceState.Error(null, false, error)),
                createStateModel(LceState.Error(1, true, error))
        )
        models.forEach {
            it.state.dataStopOnErrors.test().assertNoValues().assertError(error)
        }
    }

    @Test
    fun dataStopOnEmptyErrorWillStopOnEmptyError() {
        val error = Exception("error")
        val model1 = createStateModel(LceState.Error(null, false, error))
        val model2 = createStateModel(LceState.Error(1, true, error))

        model1.state.dataStopOnEmptyErrors.test().assertNoValues().assertError(error)
        model2.state.dataStopOnEmptyErrors.test().assertNoErrors().assertComplete().assertValues(1)
    }


    @Test
    fun validDataReturnsValidDataOnly() {
        val model = createStateModel(LceState.Loading(0, false), LceState.Content(1, true))
        model.state.validData.test().assertNoErrors().assertComplete().assertValues(1)
    }

    @Test
    fun validDataDistinctUntilDataChanged() {
        val model = createStateModel(LceState.Content(1, true), LceState.Content(1, true))
        model.state.validData.test().assertNoErrors().assertComplete().assertValues(1)
    }

    @Test
    fun validDataWillStopOnAnyError() {
        val error = Exception("error")
        val models = listOf(
                createStateModel(LceState.Error(null, false, error)),
                createStateModel(LceState.Error(1, true, error))
        )
        models.forEach {
            it.state.validData.test().assertNoValues().assertError(error)
        }
    }

    @Test
    fun flatMapsSingleData() {
        val error = IOException("error")

        fun mapper(input: Int) = Single.just(input.toString())

        val source = Observable.just(
            LceState.Loading(null, false),
            LceState.Loading(1, true),
            LceState.Content(2, true),
            LceState.Error(null, false, error),
            LceState.Error(3, true, error),
            LceState.Terminated
        )

        source.flatMapSingleData(::mapper)
            .test()
            .assertNoErrors()
            .assertValues(
                LceState.Loading(null, false),
                LceState.Loading("1", true),
                LceState.Content("2", true),
                LceState.Error(null, false, error),
                LceState.Error("3", true, error),
                LceState.Terminated
            )
    }

    @Test
    fun returnsErrorIfSingleDataMapperFails() {
        val error1 = IOException("error 1")
        val error2 = IOException("error 2")

        @Suppress("UNUSED_PARAMETER")
        fun mapper(input: Int) = Single.error<String>(error2)

        val source = Observable.just(
            LceState.Loading(null, false),
            LceState.Loading(1, true),
            LceState.Content(2, true),
            LceState.Error(null, false, error1),
            LceState.Error(3, true, error1),
            LceState.Terminated
        )

        source.flatMapSingleData(::mapper)
            .test()
            .assertNoErrors()
            .assertValues(
                LceState.Loading(null, false),
                LceState.Error(null, false, error2),
                LceState.Error(null, false, error2),
                LceState.Error(null, false, error1),
                LceState.Error(null, false, error1),
                LceState.Terminated
            )
    }

    @Test
    fun mapsLceFlowToOtherFlow() {
        val error = IOException("error")

        fun mapper(input: Int) = Observable.just<LceState<String>>(
            LceState.Content(input.toString(), true)
        )

        val source = Observable.just(
            LceState.Loading(null, false),
            LceState.Loading(1, true),
            LceState.Content(2, true),
            LceState.Error(null, false, error),
            LceState.Error(3, true, error),
            LceState.Terminated
        )

        source.flatMapLatestFlow(::mapper)
            .test()
            .assertNoErrors()
            .assertValues(
                LceState.Loading(null, false),
                LceState.Loading("1", true),
                LceState.Content("2", true),
                LceState.Error(null, false, error),
                LceState.Error("3", true, error),
                LceState.Terminated
            )
    }

    @Test
    @Suppress("UNUSED_PARAMETER")
    fun catchesMapperErrorInFlowMapper() {
        val error = Exception("error")

        fun mapper(input: Int) = Observable.error<LceState<String>>(error)

        val source = Observable.just<LceState<Int>>(
            LceState.Loading(null, false),
            LceState.Loading(1, true)
        )

        source.flatMapLatestFlow(::mapper)
            .test()
            .assertNoErrors()
            .assertValues(
                LceState.Loading(null, false),
                LceState.Error(null, false, error)
            )
    }

    @Test
    fun createsRefreshingStream() {
        val value1 = LceState.Content(1, true)
        val value2 = LceState.Content(2, true)
        val refreshStream = PublishSubject.create<Int>()
        val model = object : LceModel<Int, String> {
            val stateSubject = BehaviorSubject.createDefault<LceState<Int>>(value1)
            var refreshed = false

            override val state: Observable<LceState<Int>> = stateSubject
            override val refresh: Completable = Completable.fromAction {
                refreshed = true
                stateSubject.onNext(value2)
            }
            override val params: String = PARAMS
        }

        val observer = model.withRefresh(refreshStream).test()
        observer.assertNotComplete()
        observer.assertNoErrors()
        observer.assertValues(value1)

        refreshStream.onNext(1)
        observer.assertNotComplete()
        observer.assertNoErrors()
        observer.assertValues(value1, value2)
    }

    @Test
    fun refreshedLceStreamRefreshesValidContentOnStartOnce() {
        val value1: LceState<Int> = LceState.Content(1, true)
        val value2: LceState<Int> = LceState.Content(2, true)

        var refreshedTimes = 0
        val refresh = Completable.fromAction { ++refreshedTimes }

        Observable.just(value1, value2).refreshed(refresh).test()
            .assertNoErrors()
            .assertComplete()
            .assertValues(value1, value2)

        assertEquals(1, refreshedTimes)
    }

    @Test
    fun refreshedLceStreamDoesNotRefreshIfLoading() {
        val value1: LceState<Int> = LceState.Loading(null, false)
        val value2: LceState<Int> = LceState.Content(2, true)

        var refreshedTimes = 0
        val refresh = Completable.fromAction { ++refreshedTimes }

        Observable.just(value1, value2).refreshed(refresh).test()
            .assertNoErrors()
            .assertComplete()
            .assertValues(value1, value2)

        assertEquals(0, refreshedTimes)
    }

    @Test
    fun refreshedLceStreamDoesNotRefreshIfError() {
        val value1: LceState<Int> = LceState.Error(null, false, IOException())
        val value2: LceState<Int> = LceState.Content(2, true)

        var refreshedTimes = 0
        val refresh = Completable.fromAction { ++refreshedTimes }

        Observable.just(value1, value2).refreshed(refresh).test()
            .assertNoErrors()
            .assertComplete()
            .assertValues(value1, value2)

        assertEquals(0, refreshedTimes)
    }

    @Test
    fun refreshedUseCaseRefreshesOnEachSubscribe() {
        val value1: LceState<Int> = LceState.Content(1, true)
        val value2: LceState<Int> = LceState.Content(2, true)
        val source: Subject<LceState<Int>> = PublishSubject.create()
        var refreshedTimes = 0

        val useCase: LceUseCase<Int> = object : LceUseCase<Int> {
            override val state: Observable<LceState<Int>> = source
            override val refresh: Completable = Completable.fromAction { ++refreshedTimes }
        }

        val refreshed = useCase.refreshed()

        val o1 = refreshed.state.test()
        source.onNext(value1)
        o1.assertNoErrors().assertValues(value1)
        assertEquals(1, refreshedTimes)

        val o2 = refreshed.state.test()
        source.onNext(value2)
        o1.assertNoErrors().assertValues(value1, value2)
        o2.assertNoErrors().assertValue(value2)
        assertEquals(2, refreshedTimes)
    }

    @Test
    fun substitutesEmptyLoading() {
        val original = LceState.Loading(null, false)
        val substitute = LceState.Content(10, true)
        val source = Observable.just<LceState<Int>>(original)
        val modified = source.onEmptyLoadingReturn { substitute }
        modified.test().assertComplete().assertNoErrors().assertValue(substitute)
    }

    @Test
    fun passesNonEmptyLoading() {
        val original = LceState.Loading(10, true)
        val substitute = LceState.Content(10, true)
        val source = Observable.just<LceState<Int>>(original)
        val modified = source.onEmptyLoadingReturn { substitute }
        modified.test().assertComplete().assertNoErrors().assertValue(original)
    }

    @Test
    fun substitutesEmptyLoadingData() {
        val original = LceState.Loading(null, false)
        val substitute = 10
        val source = Observable.just<LceState<Int>>(original)
        val modified = source.onEmptyLoadingReturnItem { substitute }
        modified.test().assertComplete().assertNoErrors().assertValue(LceState.Loading(10, false))
    }

    @Test
    fun passesNonEmptyLoadingData() {
        val original = LceState.Loading(10, true)
        val substitute = 10
        val source = Observable.just<LceState<Int>>(original)
        val modified = source.onEmptyLoadingReturnItem { substitute }
        modified.test().assertComplete().assertNoErrors().assertValue(original)
    }
}