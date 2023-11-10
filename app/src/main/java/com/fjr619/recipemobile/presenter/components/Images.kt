package com.fjr619.recipemobile.presenter.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fjr619.recipemobile.R

@Composable
fun Images() {
    Row(Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Image(
            painter = painterResource(id = R.drawable.strawberry_pie_2),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .clip(MaterialTheme.shapes.small)
        )
        Spacer(modifier = Modifier.weight(0.1f))
        Image(
            painter = painterResource(id = R.drawable.strawberry_pie_3),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .clip(MaterialTheme.shapes.small)
        )
    }
}