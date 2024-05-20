package com.example.animatedtabbar.components

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.feature_one.presentation.components.ItemsScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabBar() {
    val pages = listOf("kotlin", "java", "c#", "php", "golang", "rust")
    val pagerState = rememberPagerState(pageCount = { pages.size })
    val tabIndex = remember { derivedStateOf { pagerState.currentPage } }
    val coroutineScope = rememberCoroutineScope()
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    Column(
        modifier = Modifier
            .padding(start = 6.dp, end = 6.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        ScrollableTabRow(
            modifier = Modifier.height(50.dp),
            selectedTabIndex = tabIndex.value,
            indicator = indicator
        ) {
            pages.forEachIndexed { index, title ->
                Tab(
                    modifier = Modifier.zIndex(6f),
                    text = { Text(text = title) },
                    selected = index == tabIndex.value,
                    onClick = {
                        Log.d("TAG", "TabBar: $index")
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                )
            }
        }
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> {
                    ItemsScreen()
                }

                else -> {
                    ItemsScreen()
                }
            }

        }
    }
}