package com.motorro.rxlcemodel.coroutines

import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.coroutines.service.CacheService
import com.motorro.rxlcemodel.coroutines.service.UpdatingNetService
import com.motorro.rxlcemodel.coroutines.service.UpdatingServiceSet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Service configuration
 * @property cacheInitial Initial cache value
 * @property netGet Value returned from net load
 * @property netUpdate Value returned from net update
 */
data class ServiceConfig<D: Any>(
    var cacheInitial: () -> Entity<D>? = { throw Exception("Cache get not defined") },
    var netGet: () -> Entity<D> = { throw Exception("Net get not defined") },
    var netUpdate: () -> Entity<D> = { throw Exception("Net update not defined") }
)


/**
 * Test service-set that exposes [cacheData] to emulate cache updates
 */
interface TestServiceSet<D: Any, in U: Any, in P: Any>: UpdatingServiceSet<D, U, P> {
    /**
     * Subject to emit cache data values
     */
    val cacheData: MutableSharedFlow<Entity<D>?>

    /**
     * Cache service mock
     */
    override val cache: CacheServiceMock<D, @UnsafeVariance P>

    /**
     * Net service mock
     */
    override val net: NetServiceMock<D, @UnsafeVariance U, @UnsafeVariance P>
}

/**
 * Cache service mock
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class CacheServiceMock<D: Any, P: Any>(cacheInitial: () -> Entity<D>?) : CacheService<D, P> {

    val cached = MutableStateFlow(cacheInitial())

    private val got: MutableList<P> = mutableListOf()
    override fun getData(params: P): Flow<Entity<D>?> {
        got.add(params)
        return cached
    }
    fun assertGet(params: P.() -> Boolean) {
        assertTrue { got.any { it.params() } }
    }
    fun assertGet(count: Int, params: P.() -> Boolean) {
        assertEquals(count, got.count { it.params() })
    }

    private val saved: MutableList<Pair<P, Entity<D>>> = mutableListOf()
    override suspend fun save(params: P, entity: Entity<D>) {
        saved.add(params to entity)
        cached.emit(entity)
    }
    fun assertSaved(params: P, entity: Entity<D>, count: Int = 0) {
        assertTrue {
            saved.any { (p, e) ->
                p == params && e == entity
            }
        }
        if (count > 0) {
            assertEquals(
                count,
                saved.count { (p, e) ->
                    p == params && e == entity
                }
            )
        }
    }
    fun assertSaved(params: P.() -> Boolean, entity: Entity<D>.() -> Boolean) {
        assertTrue {
            saved.any { (p, e) ->
                p.params() && e.entity()
            }
        }
    }

    val refetchedWith: MutableList<P> = mutableListOf()
    override suspend fun refetch(params: P) {
        refetchedWith.add(params)
    }

    var refetchedAll: Int = 0
    override suspend fun refetchAll() {
        ++refetchedAll
    }

    var invalidatedWith: MutableList<P> = mutableListOf()
    override suspend fun invalidate(params: P) {
        invalidatedWith.add(params)
    }

    var invalidatedAll = 0
    override suspend fun invalidateAll() {
        ++invalidatedAll
    }

    var deletedWith: MutableList<P> = mutableListOf()
    override suspend fun delete(params: P) {
        deletedWith.add(params)
    }
}

class NetServiceMock<D: Any, U: Any, P: Any>(
    private val netGet: () -> Entity<D>,
    private val netUpdate: () -> Entity<D>
) : UpdatingNetService<D, U, P> {

    private val got: MutableList<P> = mutableListOf()
    override suspend fun get(params: P): Entity<D> {
        got.add(params)
        return netGet()
    }
    fun assertGet(params: P.() -> Boolean) {
        assertTrue { got.any { it.params() } }
    }

    private val saved: MutableList<Pair<P, U>> = mutableListOf()
    override suspend fun update(params: P, update: U): Entity<D> {
        saved.add(params to update)
        return netUpdate()
    }

    fun assertUpdated(params: P, update: U, count: Int = 0) {
        assertTrue {
            saved.any { (p, u) ->
                p == params && u == update
            }
        }
        if (count > 0) {
            assertEquals(
                count,
                saved.count { (p, u) ->
                    p == params && u == update
                }
            )
        }
    }
}

/**
 * Creates test service set for [LceModel]
 */
inline fun <reified D: Any, reified U: Any, reified P: Any> createServiceSet(configure: ServiceConfig<D>.() -> Unit): TestServiceSet<D, U, P> {
    val config = ServiceConfig<D>().apply {
        configure()
    }

    val cache = CacheServiceMock<D, P>(config.cacheInitial)
    val net = NetServiceMock<D, U, P>(config.netGet, config.netUpdate)

    return object: TestServiceSet<D, U, P> {
        override val cacheData: MutableSharedFlow<Entity<D>?> = cache.cached
        override val net: NetServiceMock<D, U, P> = net
        override val cache: CacheServiceMock<D, P> = cache
    }
}
