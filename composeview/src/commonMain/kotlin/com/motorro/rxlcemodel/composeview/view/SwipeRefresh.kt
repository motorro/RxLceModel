package com.motorro.rxlcemodel.composeview.view

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

/**
 * Swipe-refresh content wrapper
 */
@Composable
fun SwipeRefresh(
    refreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.(Boolean) -> Unit
) {
    var refreshingStatus by remember("swipe_refresh_status") {
        mutableStateOf(refreshing)
    }
    val refreshState = rememberPullToRefreshState()

    PullToRefreshBox(
        isRefreshing = refreshing,
        onRefresh = onRefresh,
        modifier = modifier,
        state = refreshState,
        content = {
            content(refreshingStatus)
        }
    )
}