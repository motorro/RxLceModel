//[base](../index.md)/[com.motorro.rxlcemodel.base](index.md)/[flatMapSingleData](flat-map-single-data.md)



# flatMapSingleData  
[jvm]  
Brief description  


Maps each [DATA_1](flat-map-single-data.md) to single for [DATA_2](flat-map-single-data.md) and merges back to LceState. If error occurs in mapper emits [LceState.Error](-lce-state/-error/index.md). Example: load some [DATA_2](flat-map-single-data.md) from server using original [DATA_1](flat-map-single-data.md) as a parameter.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| DATA_1| <br><br>Source data type<br><br>
| DATA_2| <br><br>Resulting data type<br><br>
| mapper| <br><br>Data mapper<br><br>
  
  
Content  
fun <[DATA_1](flat-map-single-data.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), [DATA_2](flat-map-single-data.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](-lce-state/index.md)<[DATA_1](flat-map-single-data.md)>>.[flatMapSingleData](flat-map-single-data.md)(mapper: ([DATA_1](flat-map-single-data.md)) -> [Single](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Single.html)<[DATA_2](flat-map-single-data.md)>): [Observable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Observable.html)<[LceState](-lce-state/index.md)<[DATA_2](flat-map-single-data.md)>>  



