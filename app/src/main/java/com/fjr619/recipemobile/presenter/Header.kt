package com.fjr619.recipemobile.presenter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fjr619.recipemobile.R
import com.fjr619.recipemobile.ui.theme.LightGray
import com.fjr619.recipemobile.ui.theme.Transparent
import com.fjr619.recipemobile.ui.theme.White

@Composable
fun Header(
    modifier: Modifier = Modifier,
    category: String,
    headerHeightPx: Float,
    scrollState: LazyListState
) {
    val offset by remember {
        derivedStateOf {
            (scrollState.firstVisibleItemIndex * headerHeightPx) + scrollState.firstVisibleItemScrollOffset
        }
    }

    Box(modifier = modifier
        .graphicsLayer {
            translationY = -offset
            alpha = (-1f / headerHeightPx) * offset + 1
        }
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.strawberry_pie_1),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            Pair(0.65f, Transparent),
                            Pair(1f, White),
                        )
                    )
                )
        )

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 16.dp, vertical = 50.dp)
                .graphicsLayer {
                    translationX = -offset
                    alpha = (-1f / headerHeightPx) * offset + 1
                },
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = category,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .background(LightGray.copy(alpha = 0.4f))
                    .padding(vertical = 6.dp, horizontal = 16.dp)

            )
        }

    }
}