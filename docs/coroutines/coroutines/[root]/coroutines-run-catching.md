//[coroutines](../../index.md)/[[root]](index.md)/[coroutinesRunCatching](coroutines-run-catching.md)

# coroutinesRunCatching

[common]\
inline fun &lt;[T](coroutines-run-catching.md), [R](coroutines-run-catching.md)&gt; [T](coroutines-run-catching.md).[coroutinesRunCatching](coroutines-run-catching.md)(block: [T](coroutines-run-catching.md).() -&gt; [R](coroutines-run-catching.md)): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)&lt;[R](coroutines-run-catching.md)&gt;

Calls the specified function [block](coroutines-run-catching.md) with `this` value as its receiver and returns its encapsulated result if invocation was successful, catching any [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) exception besides CancellationException that was thrown from the [block](coroutines-run-catching.md) function execution and encapsulating it as a failure.
