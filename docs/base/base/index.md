//[base](index.md)



# base  
 [jvm] 



A reactive data loading for Android based on  [RxJava](https://github.com/ReactiveX/RxJava). The library follows the guidelines recommended in official [Android guide to app architecture](https://developer.android.com/jetpack/docs/guide) to load data and report an  operation state (Loading/Content/Error). 



##  Features  
<ul><li>Widely used design with Loading/Content/Error states.</li><li>Uses cache as a 'source of truth' with CacheThenNetLceModel.</li><li>Checks data is valid (up-to-date or whatever).</li><li>Falls back to invalid cache data if failed to refresh which allows offline application use.</li><li>Supports data *refresh* or *update* to implement reload or server data update operations.</li><li>Cache may be *invalidated* separately from loading to allow lazy data updates and complex data linking.</li><li>Extendable architecture on every level.</li><li>Thoroughly tested.</li></ul>

Please see a [github project](https://github.com/motorro/RxLceModel) for detailed description.



   


## Packages  
  
|  Name|  Summary| 
|---|---|
| [com.motorro.rxlcemodel.base](com.motorro.rxlcemodel.base/index.md)| Basic LceModel classes
| [com.motorro.rxlcemodel.base.entity](com.motorro.rxlcemodel.base.entity/index.md)| Contains tools to maintain data validity
| [com.motorro.rxlcemodel.base.service](com.motorro.rxlcemodel.base.service/index.md)| Contains tools to load and store data

