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

package com.motorro.rxlcemodel.sample.service.usecase

import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.entity.EntityValidatorFactory
import com.motorro.rxlcemodel.base.entity.toEntity
import com.motorro.rxlcemodel.base.service.NetService
import com.motorro.rxlcemodel.sample.di.CacheConfigModule.Companion.NOTE
import com.motorro.rxlcemodel.sample.domain.data.Note
import com.motorro.rxlcemodel.sample.service.NetRepository
import com.motorro.rxlcemodel.sample.utils.ConnectionChecker
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Net service to load a single note
 */
@Singleton
class NoteNetService @Inject constructor(
    private val connectionChecker: ConnectionChecker,
    private val netRepository: NetRepository,
    @Named(NOTE) private val entityFactory: EntityValidatorFactory
): NetService<Note, Int> {
    /**
     * Gets entity from network or throws on error
     * @param params Params that distinguish entity
     */
    override fun get(params: Int): Single<Entity<Note>> =
        connectionChecker.connectionCheck
            .andThen(netRepository.getNote(params))
            .map { it.toEntity(entityFactory.create()) }
}