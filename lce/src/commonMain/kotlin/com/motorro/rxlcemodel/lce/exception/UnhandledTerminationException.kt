package com.motorro.rxlcemodel.lce.exception

/**
 * Error thrown on unhandled termination
 */
class UnhandledTerminationException(override val cause: Throwable? = null) : IllegalStateException("Unhandled termination") {

    override fun toString(): String {
        return "UnhandledTerminationException: $message"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as UnhandledTerminationException

        return cause == other.cause
    }

    override fun hashCode(): Int {
        return cause?.hashCode() ?: 0
    }
}