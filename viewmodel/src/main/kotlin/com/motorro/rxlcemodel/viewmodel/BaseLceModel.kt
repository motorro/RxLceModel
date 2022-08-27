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

package com.motorro.rxlcemodel.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.lce.combine
import com.motorro.rxlcemodel.rx.LceUseCase
import com.motorro.rxlcemodel.viewmodel.error.UnhandledException
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.*

/**
 * Base model with [state] and [refresh]
 */
abstract class BaseLceModel<DATA : Any> : BaseViewModel() {
    companion object {
        /**
         * Creates LCE model
         * @param stateObservable Observable of state changes
         * @param refresh Refresh operation
         */
        @SuppressLint("StaticFieldLeak")
        fun <DATA : Any> create(
            stateObservable: Observable<LceState<DATA>>,
            refresh: Completable
        ): BaseLceModel<DATA> = object : Impl<DATA>() {
            override val stateObservable: Observable<LceState<DATA>> = stateObservable
            override val refresh: Completable = refresh
        }

        /**
         * Creates LCE model
         * @param useCase Data use-case
         */
        @SuppressLint("StaticFieldLeak")
        fun <DATA : Any> create(useCase: LceUseCase<DATA>): BaseLceModel<DATA> = object : Impl<DATA>() {
            override val stateObservable: Observable<LceState<DATA>> = useCase.state
            override val refresh: Completable = useCase.refresh
        }
    }

    /**
     * LCE State
     */
    abstract val state: LiveData<LceState<DATA>>

    /**
     * Requests data refresh
     */
    abstract fun refresh()

    /**
     * Retries data subscription from scratch
     */
    abstract fun restart()

    /**
     * Terminates state flow
     */
    protected open fun terminate() {
        doClear()
    }

    /**
     * Default action on critical error
     * @param error Error to dismiss
     */
    open fun dismissError(error: Throwable) {
        restart()
    }

    /**
     * Dismisses error set in state if it is error
     */
    fun dismissCurrentError() {
        state.value?.let { if (it is LceState.Error) dismissError(it.error) }
    }

    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     *
     * It is useful when ViewModel observes some data and you need to clear this subscription to
     * prevent a leak of this ViewModel.
     */
    override fun onCleared() {
        super.onCleared()
        doClear()
    }

    /**
     * Basic ViewModel with LceModel inside
     */
    abstract class Impl<DATA : Any> : BaseLceModel<DATA>() {
        /**
         * State observable
         */
        protected abstract val stateObservable: Observable<LceState<DATA>>

        /**
         * Refresh command
         */
        protected abstract val refresh: Completable

        /**
         * Maintains refresh subscriptions
         */
        private var disposables = CompositeDisposable()

        /**
         * Adds [disposable] to this model
         */
        protected fun addSubscription(disposable: Disposable) {
            disposables.add(disposable)
        }

        /**
         * Subscribes [Completable] operation adding it to common subscription
         * @param completable Completable to subscribe
         */
        protected fun addSubscription(completable: Completable) {
            val subscription = completable.subscribe(
                { /* NOOP */ },
                { error -> throw UnhandledException(error) }
            )

            addSubscription(subscription)
        }

        /**
         * State live-data
         */
        private val stateData = MutableLiveData<LceState<DATA>>()

        /**
         * Call this function to initialize a new model and start receiving events
         */
        override fun doInitialize() {
            if (initialized) {
                return
            }
            subscribeData()
        }

        /**
         * Subscribes to data
         */
        private fun subscribeData() {
            val subscription = stateObservable
                .subscribe(
                    { state -> stateData.value = state },
                    { error -> throw UnhandledException(error) }
                )
            disposables.add(subscription)
        }

        /**
         * LCE State
         */
        override val state: LiveData<LceState<DATA>>
            get() = stateData

        /**
         * Requests data refresh
         */
        override fun refresh() {
            addSubscription(refresh)
        }

        /**
         * Retries data subscription from scratch
         */
        override fun restart() {
            disposables.clear()
            disposables = CompositeDisposable()
            subscribeData()
        }

        /**
         * Terminates state flow
         */
        override fun terminate() {
            disposables.clear()
            stateData.value = LceState.Terminated
        }

        /**
         * Disposes active operations when model is destroyed
         */
        override fun doClear() {
            disposables.clear()
        }
    }

    /**
     * View model with operations that mix with main state
     * @param dataUseCase Main data use-case
     */
    open class WithUpdates<DATA : Any>(dataUseCase: LceUseCase<DATA>) : Impl<DATA>() {
        /**
         * Card operation state to mix with main data loading
         */
        private val operationStream = BehaviorSubject.createDefault<Optional<LceState<Unit>>>(Optional.empty())

        /**
         * Mixes in running operation state
         */
        private fun mixStates(
            viewState: LceState<DATA>,
            operationState: Optional<LceState<Unit>>
        ): LceState<DATA> =
            operationState.orElse(null)
                ?.let { viewState.combine(it) { viewData, _ -> viewData } }
                ?: viewState

        /**
         * Runs update refreshing data on success
         * @param operation Update operation
         * @param terminating If true, terminates model on complete, e.g. if you update some data
         * and want to close view afterwards
         */
        protected fun runUpdate(operation: Completable, terminating: Boolean = false) {
            addSubscription(
                operation
                    .doOnSubscribe {
                        operationStream.onNext(
                            Optional.of(
                                LceState.Loading(
                                    null,
                                    true,
                                    LceState.Loading.Type.UPDATING
                                )
                            )
                        )
                    }
                    .doOnError { error ->
                        operationStream.onNext(
                            Optional.of(
                                LceState.Error(
                                    null,
                                    true,
                                    error
                                )
                            )
                        )
                    }
                    .doOnComplete {
                        operationStream.onNext(
                            when {
                                terminating -> Optional.of(LceState.Terminated)
                                else -> Optional.empty()
                            }
                        )
                    }
                    .andThen(refresh)
                    .onErrorComplete(),
            )
        }

        /**
         * Clears last operation status, e.g. on error dismissal
         */
        protected fun clearOperationStatus() {
            operationStream.onNext(Optional.empty())
        }

        /**
         * State observable
         */
        final override val stateObservable: Observable<LceState<DATA>> = Observable.combineLatest(
            dataUseCase.state,
            operationStream,
            ::mixStates
        )

        /**
         * Refresh command
         */
        final override val refresh: Completable = dataUseCase.refresh
    }
}
