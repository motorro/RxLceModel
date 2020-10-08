# Module base
A reactive data loading for Android based on 
[RxJava](https://github.com/ReactiveX/RxJava). The library follows the guidelines recommended in official
[Android guide to app architecture](https://developer.android.com/jetpack/docs/guide) to load data and report an 
operation state (`Loading`/`Content`/`Error`). 

## Features
- Widely used design with `Loading`/`Content`/`Error` states.
- Uses cache as a 'source of truth' with `CacheThenNetLceModel`.
- Checks data is valid (up-to-date or whatever).
- Falls back to invalid cache data if failed to refresh which allows offline application use. 
- Supports data _refresh_ or _update_ to implement reload or server data update operations.
- Cache may be _invalidated_ separately from loading to allow lazy data updates and complex data linking.
- Extendable architecture on every level.
- Thoroughly tested.

Please see a [github project](https://github.com/motorro/RxLceModel) for detailed description.

# Package com.motorro.rxlcemodel.base
Basic LceModel classes
# Package com.motorro.rxlcemodel.base.entity
Contains tools to maintain data validity
# Package com.motorro.rxlcemodel.base.service
Contains tools to load and store data
