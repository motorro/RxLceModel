//[base](../../index.md)/[com.motorro.rxlcemodel.base](../index.md)/[StrategyUpdateWrapper](index.md)/[update](update.md)



# update  
[jvm]  
Brief description  


Creates a cache-update operation that gets data from dataSource and saves to cache. The completable updates [networkOperationState](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/networkOperationState/#/PointingToDeclaration/) to mix state to original [upstream](index.md#com.motorro.rxlcemodel.base/StrategyUpdateWrapper/upstream/#/PointingToDeclaration/)



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| dataSource| <br><br>Update operation data source factory<br><br>
  
  
Content  
fun [update](update.md)(dataSource: ([PARAMS](index.md)) -> [Single](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Single.html)<Out [Entity](../../com.motorro.rxlcemodel.base.entity/-entity/index.md)<[DATA](index.md)>>): [Completable](http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Completable.html)  



