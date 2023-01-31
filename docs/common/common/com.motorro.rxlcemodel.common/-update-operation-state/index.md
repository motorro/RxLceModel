//[common](../../../index.md)/[com.motorro.rxlcemodel.common](../index.md)/[UpdateOperationState](index.md)

# UpdateOperationState

[common]\
sealed class [UpdateOperationState](index.md)

Cache update operation state

## Types

| Name | Summary |
|---|---|
| [ERROR](-e-r-r-o-r/index.md) | [common]<br>data class [ERROR](-e-r-r-o-r/index.md)(val error: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) : [UpdateOperationState](index.md) |
| [IDLE](-i-d-l-e/index.md) | [common]<br>object [IDLE](-i-d-l-e/index.md) : [UpdateOperationState](index.md) |
| [LOADING](-l-o-a-d-i-n-g/index.md) | [common]<br>object [LOADING](-l-o-a-d-i-n-g/index.md) : [UpdateOperationState](index.md) |

## Inheritors

| Name |
|---|
| [IDLE](-i-d-l-e/index.md) |
| [LOADING](-l-o-a-d-i-n-g/index.md) |
| [ERROR](-e-r-r-o-r/index.md) |
