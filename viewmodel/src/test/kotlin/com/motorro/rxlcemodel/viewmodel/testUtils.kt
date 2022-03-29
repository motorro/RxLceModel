/*
 * Copyright 2021 Nikolai Kotchetkov.
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

package com.motorro.rxlcemodel.viewmodel

import androidx.lifecycle.ViewModel
import kotlin.reflect.jvm.isAccessible

/**
 * Opens [ViewModel.onCleared] to test clean-up actions
 */
fun ViewModel.testOnCleared() {
    ViewModel::class.members
        .single { it.name == "onCleared" }
        .apply { isAccessible = true }
        .call(this)
}
