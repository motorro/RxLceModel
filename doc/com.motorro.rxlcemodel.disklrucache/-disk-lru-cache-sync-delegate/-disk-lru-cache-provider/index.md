[com.motorro.rxlcemodel.disklrucache](../../index.md) / [DiskLruCacheSyncDelegate](../index.md) / [DiskLruCacheProvider](./index.md)

# DiskLruCacheProvider

`class DiskLruCacheProvider`

Provides properly configured [DiskLruCache](#) with required entry config

### Parameters

`directory` - a writable directory

`appVersion` - Current application version

`maxSize` - the maximum number of bytes this cache should use to store

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DiskLruCacheProvider(directory: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, appVersion: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, maxSize: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)`<br>Provides properly configured [DiskLruCache](#) with required entry config |

### Properties

| Name | Summary |
|---|---|
| [cache](cache.md) | `val cache: DiskLruCache`<br>Configured [DiskLruCache](#) |
