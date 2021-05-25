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

package com.motorro.rxlcemodel.base

import com.gojuno.koptional.None
import com.motorro.rxlcemodel.base.LceState.Content
import com.motorro.rxlcemodel.base.LceState.Loading
import com.motorro.rxlcemodel.base.entity.Entity
import com.motorro.rxlcemodel.base.entity.EntityValidator
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class UpdatingLceModelWrapperTest {
    companion object {
        private const val PARAMS = "params"

        private val VALID_ENTITY = Entity.Impl(1, EntityValidator.Always)
    }

    @Test
    fun integratesWithCacheThenNetModel() {
        val updatedEntity = VALID_ENTITY.copy(data = 2)
        val serviceSet = createServiceSet<Int, Int, String> {
                cacheInitial = { None }
                netGet = { VALID_ENTITY }
                netUpdate = { updatedEntity }
            }

        val upstream = LceModel.cacheThenNet(PARAMS, serviceSet, Observable.empty())
        val model = UpdatingLceModelWrapper(
            upstream,
            serviceSet,
            Schedulers.trampoline()
        ) { _, _ -> }

        val s = model.state.test()
        s.assertNoErrors()
        s.assertNotComplete()
        s.assertValues(
                Loading(null, false),
                Content(VALID_ENTITY.data, true)
        )

        model.update(updatedEntity.data).test().assertComplete().assertNoErrors()
        verify(serviceSet.net).update(PARAMS, updatedEntity.data)
        verify(serviceSet.cache).save(PARAMS, updatedEntity)
        s.assertNotComplete()
        s.assertNoErrors()
        s.assertValues(
                Loading(null, false),
                Content(VALID_ENTITY.data, true),
                Loading(VALID_ENTITY.data, true, Loading.Type.UPDATING),
                Loading(updatedEntity.data, true, Loading.Type.UPDATING),
                Content(updatedEntity.data, true)
        )
    }
}