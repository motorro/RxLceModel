package com.motorro.rxlcemodel.common

/**
 * Cache update operation state
 */
sealed class UpdateOperationState {
    object IDLE: UpdateOperationState() {
        override fun toString(): String = "IDLE"
    }
    object LOADING: UpdateOperationState() {
        override fun toString(): String = "LOADING"
    }
    data class ERROR(val error: Throwable): UpdateOperationState() {
        override fun toString(): String = "ERROR: $error"
    }
}
