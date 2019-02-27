# RxLceModel
[![Build Status](https://travis-ci.com/motorro/RxLceModel.svg?token=ZyJexBWWUzhwyHdkocKJ&branch=master)](https://travis-ci.com/motorro/RxLceModel)

A reactive data loading with cache as a 'Single source of truth' for Android based on 
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
- Extendable architecture

## Setting up the dependency
Basic module:
```groovy
dependencies {
    // Base model components
    implementation "com.motorro.rxlcemodel:base:1.0.0"
}
```
Additional modules:
```groovy
dependencies {
    // Jake Wharton's DiskLruCache delegate for cache implementation
    implementation "com.motorro.rxlcemodel:disklrucache:1.0.0"
}
```
 
