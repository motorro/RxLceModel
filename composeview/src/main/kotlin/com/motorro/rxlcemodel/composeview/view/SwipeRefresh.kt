package com.motorro.rxlcemodel.composeview.view

import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Swipe-refresh content wrapper
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeRefresh(
    refreshing: Boolean,
    onRefresh: () -> Unit,
    content: @Composable (Boolean) -> Unit
) {
    var refreshingStatus by remember("swipe_refresh_status") {
        mutableStateOf(refreshing)
    }
    val refreshState = rememberPullRefreshState(refreshing = refreshing, onRefresh = {
        refreshingStatus = false
        onRefresh()
    })
    Box(
        modifier = Modifier.pullRefresh(refreshState),
        content = {
            content(refreshingStatus)
            PullRefreshIndicator(
                refreshing = refreshing,
                state = refreshState,
                modifier = Modifier.align(Alignment.TopCenter),
                scale = true
            )
        }
    )
}