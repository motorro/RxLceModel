/*
 * Copyright 2019 Nikolai Kotchetkov.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.motorro.rxlcemodel.base.service

import io.reactivex.rxjava3.core.Completable

/**
 * Closes and deletes cache
 * May be used to close or delete all scoped cache at once e.g. for current user
 */
interface CacheManager {
    /**
     * Closes cache
     */
    val close: Completable
    /**
     * Closes cache and deletes data
     */
    val delete: Completable
}