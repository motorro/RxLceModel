//[rx](../../index.md)/[com.motorro.rxlcemodel.rx](index.md)/[errorToLce](error-to-lce.md)

# errorToLce

[jvm]\
inline fun &lt;[T](error-to-lce.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; Observable&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[T](error-to-lce.md)&gt;&gt;.[errorToLce](error-to-lce.md)(crossinline errorData: ([Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) -&gt; [T](error-to-lce.md)? = { null }): Observable&lt;[LceState](../../../lce/lce/com.motorro.rxlcemodel.lce/-lce-state/index.md)&lt;[T](error-to-lce.md)&gt;&gt;

Maps an upstream error to LceError

#### Parameters

jvm

| | |
|---|---|
| errorData | Evaluates data for error state |
