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

import com.motorro.rxlcemodel.cache.entity.Entity
import com.motorro.rxlcemodel.cache.entity.EntityValidatorFactory
import com.motorro.rxlcemodel.cache.entity.toEntity
import com.motorro.rxlcemodel.rx.service.NetService
import com.motorro.rxlcemodel.sample.di.CacheConfigModule.Companion.NOTE_LIST
import com.motorro.rxlcemodel.sample.domain.data.NoteList
import com.motorro.rxlcemodel.sample.service.NetRepository
import com.motorro.rxlcemodel.sample.utils.ConnectionChecker
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Net service to load note list
 */
@Singleton
class NoteListNetService @Inject constructor(
    private val connectionChecker: ConnectionChecker,
    private val netRepository: NetRepository,
    @Named(NOTE_LIST) private val entityFactory: EntityValidatorFactory
): NetService<NoteList, Unit> {
    /**
     * Gets entity from network or throws on error
     * @param params Params that distinguish entity
     */
    override fun get(params: Unit): Single<Entity<NoteList>> =
        connectionChecker.connectionCheck
            .andThen(netRepository.noteList)
            .map { it.toEntity(entityFactory.create()) }
}
