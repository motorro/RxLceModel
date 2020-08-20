/*
 * Copyright 2020 Nikolai Kotchetkov.
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
@file:UseSerializers(DataWithCacheKeySerializer::class)

package com.motorro.rxlcemodel.kserializer

import com.motorro.rxlcemodel.base.service.DataWithCacheKey
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.UseSerializers
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.parse
import kotlinx.serialization.stringify
import org.junit.Test

class DataWithCacheKeySerializerTest() {
    private val json = Json { allowStructuredMapKeys = true }
    private val serializer = DataWithCacheKeySerializer(String.serializer())

    @Test
    fun serializes() {
        val dataWithKey = DataWithCacheKey("string", "key")
        val jsonData = json.encodeToString(serializer, dataWithKey)
        val fromJson = json.decodeFromString(serializer, jsonData)
        kotlin.test.assertEquals(dataWithKey, fromJson)
    }
}