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
import com.motorro.rxlcemodel.cache.entity.EntityValidator
import com.motorro.rxlcemodel.cache.entity.toEntity
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Cache delegate mock
 */
class CacheDelegateMock<D: Any, P: Any> : CacheDelegate<D, P> {

    private var cached: MutableMap<P, Entity<D>> = mutableMapOf()

    private val got: MutableList<P> = mutableListOf()
    override fun get(params: P): Entity<D>? {
        got.add(params)
        return cached[params]
    }
    fun assertGet(params: P.() -> Boolean) {
        assertTrue { got.any { it.params() } }
    }
    fun assertGet(count: Int, params: P.() -> Boolean) {
        assertEquals(count, got.count { it.params() })
    }

    private val saved: MutableList<Pair<P, Entity<D>>> = mutableListOf()
    override fun save(params: P, entity: Entity<D>) {
        cached[params] = entity
        saved.add(params to entity)
    }
    fun assertSaved(params: P, entity: Entity<D>) {
        assertTrue {
            saved.any { (p, e) ->
                p == params && e == entity
            }
        }
    }
    fun assertSaved(params: P.() -> Boolean, entity: Entity<D>.() -> Boolean) {
        assertTrue {
            saved.any { (p, e) ->
                p.params() && e.entity()
            }
        }
    }

    private val invalidated: MutableList<P> = mutableListOf()
    override fun invalidate(params: P) {
        val current = cached[params]
        if (null != current) {
            cached[params] = current.data.toEntity(EntityValidator.Never)
        }
        invalidated.add(params)
    }
    fun assertInvalidated(params: P.() -> Boolean) {
        assertTrue { invalidated.any { it.params() } }
    }

    private var allInvalidated = 0
    override fun invalidateAll() {
        cached.forEach { (params, entity) ->
            cached[params] = entity.data.toEntity(EntityValidator.Never )
        }
        ++allInvalidated
    }
    fun assertAllInvalidated() {
        assertTrue { allInvalidated > 0 }
    }

    private val deleted: MutableList<P> = mutableListOf()
    override fun delete(params: P) {
        cached.remove(params)
        deleted.add(params)
    }
    fun assertDeleted(params: P.() -> Boolean) {
        assertTrue { deleted.any { it.params() } }
    }
}

/**
 * Cache delegate that fails [get] request
 */
@Suppress("MemberVisibilityCanBePrivate")
class FailingGetDelegateMock<D: Any, P: Any>(
    val error: Throwable,
    val parent: CacheDelegateMock<D, P> = CacheDelegateMock()
) : CacheDelegate<D, P> by parent {
    override fun get(params: P): Entity<D> = throw(error)
}

/**
 * Cache delegate that fails [save] request
 */
@Suppress("MemberVisibilityCanBePrivate")
class FailingSaveDelegateMock<D: Any, P: Any>(
    val error: Throwable,
    val parent: CacheDelegateMock<D, P> = CacheDelegateMock()
) : CacheDelegate<D, P> by parent {
    override fun save(params: P, entity: Entity<D>) {
        throw error
    }
}

/**
 * Cache delegate that fails [invalidate] request
 */
@Suppress("MemberVisibilityCanBePrivate")
class FailingInvalidateDelegateMock<D: Any, P: Any>(
    val error: Throwable,
    val parent: CacheDelegateMock<D, P> = CacheDelegateMock()
) : CacheDelegate<D, P> by parent {
    override fun invalidate(params: P) {
        throw error
    }

    override fun invalidateAll() {
        throw error
    }
}

/**
 * Cache delegate that fails [delete] request
 */
@Suppress("MemberVisibilityCanBePrivate")
class FailingDeleteDelegateMock<D: Any, P: Any>(
    val error: Throwable,
    val parent: CacheDelegateMock<D, P> = CacheDelegateMock()
) : CacheDelegate<D, P> by parent {
    override fun delete(params: P) {
        throw error
    }
}
