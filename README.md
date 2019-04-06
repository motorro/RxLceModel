# RxLceModel
[![Build Status](https://travis-ci.com/motorro/RxLceModel.svg?token=ZyJexBWWUzhwyHdkocKJ&branch=master)](https://travis-ci.com/motorro/RxLceModel)

A reactive data loading for Android based on 
[RxJava](https://github.com/ReactiveX/RxJava). The library follows the guidelines recommended in official
[Android guide to app architecture](https://developer.android.com/jetpack/docs/guide) to load data and report an 
operation state (`Loading`/`Content`/`Error`). 

## Features
- Uses cache as a 'source of truth'.
- Checks cache data is valid (up-to-date or whatever).
- Falls back to invalid cache data if failed to refresh which allows offline application use. 
- Emits data loading state (`Loading`/`Content`/`Error`) along with data.
- Supports data _refresh_ or _update_ to implement reload or server data update operations.
- Cache may be _invalidated_ separately from loading to allow lazy data updates and complex data linking.
- Extendable architecture on every level.

## Sample application

Included as a `sample` module - a classic notes application that illustrates `RxLceModel` use along with:
* [Dagger2](https://github.com/google/dagger)
* [Android architecture components](https://developer.android.com/topic/libraries/architecture)
* Basic `ViewModel` unit-testing

If you have questions on a general use of these tools in Android projects please refer to the following excellent 
articles by [James Shvarts](https://github.com/jshvarts):
* [Implementing MVVM using LiveData, RxJava, Dagger Android](https://proandroiddev.com/mvvm-architecture-using-livedata-rxjava-and-new-dagger-android-injection-639837b1eb6c)
* [Navigation Architecture Component for the Rest of Us](https://proandroiddev.com/navigation-architecture-component-for-the-rest-of-us-faafa890e5)

## Setting up the dependency
Basic module [ ![Base](https://api.bintray.com/packages/motorro/RxLceModel/base/images/download.svg) ](https://bintray.com/motorro/RxLceModel/base/_latestVersion):
```groovy
dependencies {
    // Base model components
    implementation "com.motorro.rxlcemodel:base:x.x.x"
}
```
[Jake Wharton's DiskLruCache](https://github.com/JakeWharton/DiskLruCache) cache delegate for RxLceModel [ ![DiskLruCache delegate](https://api.bintray.com/packages/motorro/RxLceModel/disklrucache/images/download.svg) ](https://bintray.com/motorro/RxLceModel/disklrucache/_latestVersion)
:
```groovy
dependencies {
    // Jake Wharton's DiskLruCache delegate for cache implementation
    implementation "com.motorro.rxlcemodel:disklrucache:x.x.x"
}
```

## LceState
A modern approach to architecting the reactive application suggests packing the combined state of the application into a 
flow of immutable state-objects. Each of them the should contain the whole set of data required to process, transform, 
and display according to the business requirement. The most commonly used information besides the data itself is a state 
of data-loading pipeline.

![LceState class diagram](https://raw.githubusercontent.com/motorro/RxLceModel/docs/readme_files/lce_state.puml?token=AA4beOp3V1D2VF-WGRD04-ND5kPma7A9ks5csgx-wA%3D%3D)

Each `LceState<DATA, PARAMS>` subclass represents a data-loading phase and contains the following data:
*   `data: DATA?` - Loaded data
*   `dataIsValid: Boolean` - The validity of data at the time of emission. May be used by caching services to indicate 
    the need of data refresh. More about it in [CacheThenNetLceModel](#cachethennetlcemodel) section.
*   `params`: PARAMS - Params that identify data being loaded

States being emitted are:
*   `Loading` - data is being loaded or updated. May contain some data. The exact state is defined by `type` property:
```kotlin
/**
 * Loading type
 */
enum class Type {
    /**
     * Just loads. May be initial load operation
     */
    LOADING,
    /**
     * Loading more items for paginated view
     */
    LOADING_MORE,
    /**
     * Refreshing content
     */
    REFRESHING,
    /**
     * Updating data on server
     */
    UPDATING,
}        
```
*   `Content` - data is loaded.
*   `Error` - some error  while loading or updating data. May also contain some data.
*   `Terminated` - a special state to indicate that resource identified by `params` is not available anymore. The sample
    application demonstrates the use of `Terminated` to indicate that the note is deleted and [view](sample/src/main/kotlin/com/motorro/rxlcemodel/sample/view/note/NoteFragment.kt) 
    should be closed:
```kotlin
override fun processTermination() {
    findNavController().popBackStack()
}
``` 
 
## LceModel
`LceModel<DATA, PARAMS>` is an interface that loads `DATA` identified with `PARAMS` from some data-source. The interface 
itself is primary intended to use as a use-case for UI components giving them a

## CacheThenNetLceModel   