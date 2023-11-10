package com.fjr619.recipemobile.presenter

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fjr619.recipemobile.R
import com.fjr619.recipemobile.presenter.components.CircularButton
import com.fjr619.recipemobile.toolbarHeight
import com.fjr619.recipemobile.ui.theme.Pink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    scrollState: LazyListState,
    headerHeightPx: Float,
    toolbarHeightPx: Float,
) {
    val toolbarBottom = headerHeightPx - toolbarHeightPx
    val offset by remember {
        derivedStateOf {
            (scrollState.firstVisibleItemIndex * headerHeightPx) + scrollState.firstVisibleItemScrollOffset
        }
    }

    Log.e("TAG", "$offset $toolbarBottom")

    val showToolbar by remember {
        derivedStateOf { offset >= toolbarBottom }
    }

//    AnimatedVisibility(
//        modifier = modifier,
//        visible = showToolbar,
//        enter = fadeIn(animationSpec = tween(300)),
//        exit = fadeOut(animationSpec = tween(300))
//    ) {

    Surface(
        color = Color.Transparent,
        shadowElevation = if (showToolbar) 2.dp else 0.dp
    ) {
        TopAppBar(
            modifier = Modifier
                .background(
                    if (showToolbar) Color.White else Color.Transparent
                )
                .height(toolbarHeight),
            navigationIcon = {
                CircularButton(iconResource = R.drawable.ic_arrow_back, color = Pink)
            },
            actions = {
                CircularButton(iconResource = R.drawable.ic_favorite, color = Pink)
            },
            title = {},
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Transparent,
            )
        )

    }


//    }
}