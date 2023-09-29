import kotlinx.coroutines.CancellationException

/**
 * Calls the specified function [block] with `this` value as its receiver and returns its encapsulated result if invocation was successful,
 * catching any [Throwable] exception besides [CancellationException] that was thrown from the [block] function execution and encapsulating it as a failure.
 */
public inline fun <T, R> T.coroutinesRunCatching(block: T.() -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (c: CancellationException) {
        throw c
    } catch (e: Throwable) {
        Result.failure(e)
    }
}
