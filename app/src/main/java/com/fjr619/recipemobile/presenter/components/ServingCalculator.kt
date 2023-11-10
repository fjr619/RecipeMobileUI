package com.fjr619.recipemobile.presenter.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fjr619.recipemobile.R
import com.fjr619.recipemobile.ui.theme.LightGray
import com.fjr619.recipemobile.ui.theme.Pink

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ServingCalculator() {
    var value by remember { mutableStateOf(6) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(LightGray)
            .padding(horizontal = 16.dp)
    ) {

        Text(text = "Serving", Modifier.weight(1f), fontWeight = FontWeight.Medium)
        CircularButton(iconResource = R.drawable.ic_minus, color = Pink) { value-- }

        AnimatedContent(
            targetState = value,
            label = "",
            transitionSpec = {
                // Compare the incoming number with the previous number.
                if (targetState > initialState) {
                    // If the target number is larger, it slides down and fades in
                    slideInVertically { height -> -height } + fadeIn() with
                            slideOutVertically { height -> height } + fadeOut()
                } else {
                    // If the target number is smaller, it slides up and fades in
                    slideInVertically { height -> height } + fadeIn() with
                            slideOutVertically { height -> -height } + fadeOut()
                }.using(
                    // Disable clipping since the faded slide-in/out should
                    // be displayed out of bounds.
                    SizeTransform(clip = false)
                )
            }
        ) {
            Text(text = "$it", Modifier.padding(16.dp), fontWeight = FontWeight.Medium)

        }


        CircularButton(iconResource = R.drawable.ic_plus, color = Pink) { value++ }
    }
}