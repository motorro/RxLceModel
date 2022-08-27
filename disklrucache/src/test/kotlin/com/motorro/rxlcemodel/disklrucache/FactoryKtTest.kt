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

package com.motorro.rxlcemodel.disklrucache

import com.motorro.rxlcemodel.rx.service.CacheFriend
import org.junit.Test
import kotlin.test.assertEquals

class FactoryKtTest {
    companion object {
        const val VALID_KEY = "short"

        const val LONG_KEY = "long_long_long_long_long_long_long_long_long_long_long_long_long"
        const val LONG_KEY_MD5 = "64c9c1ccad29dcce46f03a73132338d5"

        const val INVALID_KEY = "long/long"
        const val INVALID_KEY_MD5 = "ec841a7b07a85a7eb3e4589c7dcce191"
    }

    /**
     * Test friend
     */
    private data class JustFriend(override val cacheKey: String): CacheFriend

    @Test
    fun normalizeReturnsOriginalKeyIfValidForDiskLruCache() {
        val params = JustFriend(VALID_KEY)
        assertEquals(VALID_KEY, params.getNormalizedKey("prefix"))
    }

    @Test
    fun normalizeReturnsHashedKeyIfTooLongForDiskLruCache() {
        val params = JustFriend(LONG_KEY)
        assertEquals(LONG_KEY_MD5, params.getNormalizedKey("prefix"))
    }

    @Test
    fun normalizeReturnsHashedKeyIfInvalidForDiskLruCache() {
        val params = JustFriend(INVALID_KEY)
        assertEquals(INVALID_KEY_MD5, params.getNormalizedKey("prefix"))
    }

    @Test
    fun normalizeTakesPrefixLengthIntoAccount() {
        val almostLongKey = "long_long_long_long_long_long_long_long_long_long_long_long" // 59
        val okPrefix = "pref" // 63
        val params = JustFriend(almostLongKey)
        assertEquals(almostLongKey, params.getNormalizedKey(okPrefix))

        val tooLongPrefix = "prefi" // 64
        assertEquals("97b516d8932a1c0c89a9d36c8f3c5728", params.getNormalizedKey(tooLongPrefix))
    }
}