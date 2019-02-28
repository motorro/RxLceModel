[com.motorro.rxlcemodel.base](../index.md) / [LceState](index.md) / [dataIsValid](./data-is-valid.md)

# dataIsValid

`abstract val dataIsValid: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

A property that is evaluated internally and may mean that data being emitted is stall,
invalidated or otherwise 'not-so-valid' until some further emission (say after network
reload).
