/

# Module base

A reactive data loading for Android based on  [RxJava](https://github.com/ReactiveX/RxJava). The library follows the guidelines recommended in official [Android guide to app architecture](https://developer.android.com/jetpack/docs/guide) to load data and report an  operation state (`Loading`/`Content`/`Error`). 

##  Features

- 
   Widely used design with `Loading`/`Content`/`Error` states.
- 
   Uses cache as a 'source of truth' with `CacheThenNetLceModel`.
- 
   Checks data is valid (up-to-date or whatever).
- 
   Falls back to invalid cache data if failed to refresh which allows offline application use.
- 
   Supports data *refresh* or *update* to implement reload or server data update operations.
- 
   Cache may be *invalidated* separately from loading to allow lazy data updates and complex data linking.
- 
   Extendable architecture on every level.
- 
   Thoroughly tested.

Please see a [github project](https://github.com/motorro/RxLceModel) for detailed description.

#  Package com.motorro.rxlcemodel.rx

Basic LceModel classes

#  Package com.motorro.rxlcemodel.rx.entity

Contains tools to maintain data validity

#  Package com.motorro.rxlcemodel.rx.service

Contains tools to load and store data

#  Package com.motorro.rxlcemodel.disklrucache

[Jake Wharton's DiskLruCache](https://github.com/JakeWharton/DiskLruCache) cache delegate for RxLceModel

#  Package com.motorro.rxlcemodel.kserializer

DiskLruCache serialization delegate using [Kotlin serialization](https://github.com/Kotlin/kotlinx.serialization/)

## All modules:

| Name |
|---|
| [cache](cache/index.md) |  |
| [common](common/index.md) |  |
| [composeview](composeview/index.md) |  |
| [coroutines](coroutines/index.md) |  |
| [disklrucache](disklrucache/index.md) |  |
| [kserializer](kserializer/index.md) |  |
| [lce](lce/index.md) |  |
| [rx](rx/index.md) |  |
| [utils](utils/index.md) |  |
| [viewmodel](viewmodel/index.md) |  |
