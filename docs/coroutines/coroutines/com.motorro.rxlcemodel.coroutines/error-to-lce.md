//[coroutines](../../index.md)/[com.motorro.rxlcemodel.coroutines](index.md)/[errorToLce](error-to-lce.md)

# errorToLce

[common]\
inline fun &lt;[T](error-to-lce.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[T](error-to-lce.md)&gt;&gt;.[errorToLce](error-to-lce.md)(crossinline errorData: ([Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) -&gt; [T](error-to-lce.md)? = { null }): Flow&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[T](error-to-lce.md)&gt;&gt;

Maps an upstream error to LceError

#### Parameters

common

| | |
|---|---|
| errorData | Evaluates data for error state |
