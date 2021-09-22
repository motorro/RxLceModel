/

# Module base

A reactive data loading for Android based on  [RxJava](https://github.com/ReactiveX/RxJava). The library follows the guidelines recommended in official [Android guide to app architecture](https://developer.android.com/jetpack/docs/guide) to load data and report an  operation state (Loading/Content/Error). 

##  Features

<ul><li>Widely used design with Loading/Content/Error states.</li><li>Uses cache as a 'source of truth' with CacheThenNetLceModel.</li><li>Checks data is valid (up-to-date or whatever).</li><li>Falls back to invalid cache data if failed to refresh which allows offline application use.</li><li>Supports data *refresh* or *update* to implement reload or server data update operations.</li><li>Cache may be *invalidated* separately from loading to allow lazy data updates and complex data linking.</li><li>Extendable architecture on every level.</li><li>Thoroughly tested.</li></ul>

Please see a [github project](https://github.com/motorro/RxLceModel) for detailed description.

#  Package com.motorro.rxlcemodel.base

Basic LceModel classes

#  Package com.motorro.rxlcemodel.base.entity

Contains tools to maintain data validity

#  Package com.motorro.rxlcemodel.base.service

Contains tools to load and store data

#  Package com.motorro.rxlcemodel.disklrucache

[Jake Wharton's DiskLruCache](https://github.com/JakeWharton/DiskLruCache) cache delegate for RxLceModel

#  Package com.motorro.rxlcemodel.kserializer

DiskLruCache serialization delegate using [Kotlin serialization](https://github.com/Kotlin/kotlinx.serialization/)

## All modules:

| Name |
|---|
| [base](base/index.md) |  |
| [composeview](composeview/index.md) |  |
| [disklrucache](disklrucache/index.md) |  |
| [kserializer](kserializer/index.md) |  |
| [viewmodel](viewmodel/index.md) |  |
