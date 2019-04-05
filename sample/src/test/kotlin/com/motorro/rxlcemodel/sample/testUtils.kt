package com.motorro.rxlcemodel.sample

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