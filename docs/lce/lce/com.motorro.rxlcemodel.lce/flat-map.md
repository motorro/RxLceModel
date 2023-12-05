//[lce](../../index.md)/[com.motorro.rxlcemodel.lce](index.md)/[flatMap](flat-map.md)

# flatMap

[common]\
inline fun &lt;[DATA_1](flat-map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](flat-map.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [LceState](-lce-state/index.md)&lt;[DATA_1](flat-map.md)&gt;.[flatMap](flat-map.md)(mapper: (data1: [DATA_1](flat-map.md)) -&gt; [LceState](-lce-state/index.md)&lt;[DATA_2](flat-map.md)&gt;): [LceState](-lce-state/index.md)&lt;[DATA_2](flat-map.md)&gt;

Flat-maps Lce states with the result of other Here is the result state matrix | Receiver   | mapper     | Result     | |------------|------------|------------| | Loading    | Loading    | Loading    | | Loading    | Content    | Loading    | | Loading    | Error      | Error      | | Loading    | Terminated | Terminated | | Content    | Loading    | Loading    | | Content    | Content    | Content*   | | Content    | Error      | Error      | | Content    | Terminated | Terminated | | Error      | Loading    | Error      | | Error      | Content    | Error      | | Error      | Error      | Error      | | Error      | Terminated | Terminated | | Terminated | Loading    | Terminated | | Terminated | Content    | Terminated | | Terminated | Error      | Terminated | | Terminated | Terminated | Terminated |

#### Receiver

An Lce state that has a priority in final state resolution

#### Parameters

common

| | |
|---|---|
| mapper | Returns a new [LceState](-lce-state/index.md) as a product of receiver data |
