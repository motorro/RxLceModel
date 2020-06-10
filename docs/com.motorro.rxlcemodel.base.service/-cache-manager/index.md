[com.motorro.rxlcemodel.base.service](../index.md) / [CacheManager](./index.md)

# CacheManager

`interface CacheManager`

Closes and deletes cache
May be used to close or delete all scoped cache at once e.g. for current user

### Properties

| Name | Summary |
|---|---|
| [close](close.md) | `abstract val close: `[`Completable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html)<br>Closes cache |
| [delete](delete.md) | `abstract val delete: `[`Completable`](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html)<br>Closes cache and deletes data |
