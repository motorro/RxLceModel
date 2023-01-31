/*
 * Copyright 2022 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.cache

import com.motorro.rxlcemodel.cache.entity.Entity

/**
 * Creates an adapter delegate that [stringify] [P] and uses result string as params to receiver
 * @receiver Delegate with String params e.g. the one that saves data to files and uses params as file names
 * @param stringify Function to stringify [P]
 */
inline fun <D: Any, P: Any> CacheDelegate<D, String>.stringifyParams(crossinline stringify: P.() -> String = { toString() }) = object :
    CacheDelegate<D, P> {
    override fun get(params: P): Entity<D>? = this@stringifyParams.get(params.stringify())
    override fun save(params: P, entity: Entity<D>) = this@stringifyParams.save(params.stringify(), entity)
    override fun invalidate(params: P) = this@stringifyParams.invalidate(params.stringify())
    override fun invalidateAll() = this@stringifyParams.invalidateAll()
    override fun delete(params: P) = this@stringifyParams.delete(params.stringify())
}
