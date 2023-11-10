package com.fjr619.recipemobile.presenter

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.fjr619.recipemobile.headerHeight
import com.fjr619.recipemobile.paddingMedium
import com.fjr619.recipemobile.titleFontScaleEnd
import com.fjr619.recipemobile.titleFontScaleStart
import com.fjr619.recipemobile.titlePaddingStart
import com.fjr619.recipemobile.toolbarHeight

@Composable
fun Title(
    title: String,
    modifier: Modifier = Modifier,
    scrollState: LazyListState,
    headerHeightPx: Float,
    toolbarHeightPx: Float,
) {

    var titleHeightPx by remember { mutableStateOf(0f) }
    var titleWidthPx by remember { mutableStateOf(0f) }
    val titleHeightDp = with(LocalDensity.current) { titleHeightPx.toDp() }

    val offset by remember {
        derivedStateOf {
            (scrollState.firstVisibleItemIndex * headerHeightPx) + scrollState.firstVisibleItemScrollOffset
        }
    }


    Text(
        text = title,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = modifier
            .wrapContentSize()
            .graphicsLayer {
                val collapseRange: Float = (headerHeightPx - toolbarHeightPx)
                val collapseFraction: Float = (offset / collapseRange).coerceIn(0f, 1f)

                val scalXY = lerp(
                    titleFontScaleStart.dp,
                    titleFontScaleEnd.dp,
                    collapseFraction
                )

                val titleY = lerp(
                    headerHeight - titleHeightDp - paddingMedium,
                    (toolbarHeight + 16.dp) / 2 - titleHeightDp / 2, //16.dp = status bar
                    collapseFraction
                )

                val titleX = lerp(
                    titlePaddingStart,
                    titlePaddingStart + 16.dp,
                    collapseFraction
                )

                translationY = titleY.toPx()
                translationX = titleX.toPx()

                scaleX = scalXY.value
                scaleY = scalXY.value

            }
            .onGloballyPositioned {
                titleHeightPx = it.size.height.toFloat()
                titleWidthPx = it.size.width.toFloat()
            }

    )
}