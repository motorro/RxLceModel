//[base](../../../index.md)/[com.motorro.rxlcemodel.base.service](../index.md)/[CacheManager](index.md)

# CacheManager

[jvm]\
interface [CacheManager](index.md)

Closes and deletes cache May be used to close or delete all scoped cache at once e.g. for current user

## Properties

| Name | Summary |
|---|---|
| [close](close.md) | [jvm]<br>abstract val [close](close.md): Completable<br>Closes cache |
| [delete](delete.md) | [jvm]<br>abstract val [delete](delete.md): Completable<br>Closes cache and deletes data |
