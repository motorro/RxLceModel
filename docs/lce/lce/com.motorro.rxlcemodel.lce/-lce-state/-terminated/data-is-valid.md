//[lce](../../../../index.md)/[com.motorro.rxlcemodel.lce](../../index.md)/[LceState](../index.md)/[Terminated](index.md)/[dataIsValid](data-is-valid.md)

# dataIsValid

[common]\
open override val [dataIsValid](data-is-valid.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false

A property that is evaluated internally and may mean that data being emitted is stall, invalidated or otherwise 'not-so-valid' until some further emission (say after network reload).
