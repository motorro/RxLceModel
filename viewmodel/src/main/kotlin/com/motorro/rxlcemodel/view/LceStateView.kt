package com.motorro.rxlcemodel.view

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.motorro.rxlcemodel.lce.LceState
import com.motorro.rxlcemodel.lce.LceState.*
import com.motorro.rxlcemodel.lce.LceState.Loading.Type.LOADING
import com.motorro.rxlcemodel.lce.LceState.Loading.Type.UPDATING
import com.motorro.rxlcemodel.viewmodel.BaseLceModel

/**
 * Load-Content-View interface.
 * @param DATA Data type
 */
interface LceStateView<DATA : Any> {
    /**
     * Call to process view state and data whenever new state arrives from model
     */
    fun processState(state: LceState<DATA>) {
        state.data?.let {
            processStateData(
                data = it,
                isValid = state.dataIsValid,
                isUpdating = state is Loading && UPDATING == state.type
            )
        }
        processStateView(state)
    }

    /**
     * Called by [processState] to process new data.
     */
    fun processStateData(data: DATA, isValid: Boolean, isUpdating: Boolean) {

    }

    /**
     * Updates view according to [state]
     */
    fun processStateView(state: LceState<DATA>) {
        when (state) {
            is Loading -> when (state.type) {
                LOADING -> showLoading()
                else -> showRefreshing(state.type)
            }
            is Content -> showContent()
            is Error -> {
                val error = state.error
                when {
                    isFatal(state) -> showError(error)
                    else -> {
                        showContent()
                        showNonFatalError(error)
                    }
                }
            }
            is Terminated -> processTermination()
        }
    }

    /**
     * Checks if error is fatal for this view
     */
    fun isFatal(error: Error<DATA>): Boolean =
        null == error.data

    /**
     * Displays loading when no data available.
     */
    fun showLoading()

    /**
     * Displays data refresh on top of current state.
     */
    fun showRefreshing(type: Loading.Type) {
        showContent()
    }

    /**
     * Displays content.
     */
    fun showContent()

    /**
     * Displays error when there is no data to display.
     * @param error Error to display
     */
    fun showError(error: Throwable)

    /**
     * Displays some error notification when the error is non-critical and some content
     * may be displayed.
     * @param error Error to display
     */
    fun showNonFatalError(error: Throwable) {
        showContent()
    }

    /**
     * Process [LceState.Terminated].
     */
    fun processTermination(): Unit = throw IllegalStateException("Unexpected `Terminated` state")

    /**
     * Returns lifecycle owner
     */
    fun getLifecycleOwner(): LifecycleOwner
}

/**
 * Creates and initializes LCE view-model subscribing to state updates.
 * @param init Model initialization action
 */
inline fun <reified DATA : Any, reified MODEL : BaseLceModel<DATA>> LceStateView<DATA>.initializeModel(
    modelStoreOwner: ViewModelStoreOwner,
    init: MODEL.() -> Unit = { initialize() }
): MODEL {
    val model = ViewModelProvider(modelStoreOwner).get(MODEL::class.java)
    model.state.observe(getLifecycleOwner()) { processState(it) }
    model.init()
    return model
}