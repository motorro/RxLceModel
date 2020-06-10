

A reactive data loading for Android based on
[RxJava](https://github.com/ReactiveX/RxJava). The library follows the guidelines recommended in official
[Android guide to app architecture](https://developer.android.com/jetpack/docs/guide) to load data and report an
operation state (`Loading`/`Content`/`Error`).


## Features

* Widely used design with `Loading`/`Content`/`Error` states.
* Uses cache as a 'source of truth' with `CacheThenNetLceModel`.
* Checks data is valid (up-to-date or whatever).
* Falls back to invalid cache data if failed to refresh which allows offline application use.
* Supports data *refresh* or *update* to implement reload or server data update operations.
* Cache may be *invalidated* separately from loading to allow lazy data updates and complex data linking.
* Extendable architecture on every level.
* Thoroughly tested.

Please see a [github project](https://github.com/motorro/RxLceModel) for detailed description.

### Packages

| Name | Summary |
|---|---|
| [com.motorro.rxlcemodel.base](com.motorro.rxlcemodel.base/index.md) | Basic LceModel classes |
| [com.motorro.rxlcemodel.base.entity](com.motorro.rxlcemodel.base.entity/index.md) | Contains tools to maintain data validity |
| [com.motorro.rxlcemodel.base.service](com.motorro.rxlcemodel.base.service/index.md) | Contains tools to load and store data |
| [com.motorro.rxlcemodel.disklrucache](com.motorro.rxlcemodel.disklrucache/index.md) | [Jake Wharton's DiskLruCache](https://github.com/JakeWharton/DiskLruCache) cache delegate for RxLceModel |
| [com.motorro.rxlcemodel.kserializer](com.motorro.rxlcemodel.kserializer/index.md) | DiskLruCache serialization delegate using [Kotlin serialization](https://github.com/Kotlin/kotlinx.serialization/) |

### Index

[All Types](alltypes/index.md)