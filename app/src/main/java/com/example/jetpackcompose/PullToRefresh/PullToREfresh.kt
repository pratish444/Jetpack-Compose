package com.example.jetpackcompose.PullToRefresh

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.material3.pulltorefresh.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// 🌟 Main Composable that holds the refresh logic
@Composable
fun PulltoRefreshScreen() {
    val scope = rememberCoroutineScope() // used to launch coroutines
    var isRefreshing by remember { mutableStateOf(false) } // loading state
    var items by remember { mutableStateOf(List(20) { "Item $it" }) } // list of dummy items

    // Function to simulate refreshing of data
    fun refreshItems() {
        scope.launch {
            isRefreshing = true
            delay(2000) // simulate network delay
            items = List(20) { "Item #${(0..100).random()}" } // simulate new items
            isRefreshing = false
        }
    }

    // Pass to composable that shows UI
    PulltoRefreshCustomIndicatorSample(
        items = items,
        isRefreshing = isRefreshing,
        onRefresh = { refreshItems() }
    )
}

// 💡 Composable to show list and pull-to-refresh box with custom indicator
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PulltoRefreshCustomIndicatorSample(
    items: List<String>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberPullToRefreshState() // manages swipe state

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        state = state,
        modifier = modifier.fillMaxSize(),
        indicator = {
            MyCustomIndicator(
                state = state,
                isRefreshing = isRefreshing
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            // Display scrollable list
            LazyColumn(
                modifier = Modifier.padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(items) {
                    ListItem(
                        headlineContent = { Text(text = it) }
                    )
                }
            }
        }
    }
}

// 🌀 Custom refresh indicator with smooth transition using Crossfade
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCustomIndicator(
    state: PullToRefreshState,
    isRefreshing: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.pullToRefreshIndicator(
            state = state,
            isRefreshing = isRefreshing,
            containerColor = PullToRefreshDefaults.containerColor,
            threshold = PullToRefreshDefaults.PositionalThreshold
        ),
        contentAlignment = Alignment.Center
    ) {
        Crossfade(
            targetState = isRefreshing,
            animationSpec = tween(durationMillis = 1000),
            modifier = Modifier.align(Alignment.Center)
        ) { refreshing ->
            if (refreshing) {
                CircularProgressIndicator(Modifier.size(24.dp))
            } else {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Pull to refresh",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {
    PulltoRefreshScreen()
}
