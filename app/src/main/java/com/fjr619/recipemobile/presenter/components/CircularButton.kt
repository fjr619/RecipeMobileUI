package com.fjr619.recipemobile.presenter.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.fjr619.recipemobile.ui.theme.Gray

@Composable
fun CircularButton(
    @DrawableRes iconResource: Int,
    color: Color = Gray,
    onClick: () -> Unit = {}
) {
    FilledIconButton(
        onClick = onClick,
        modifier = Modifier,
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = Color.White
        )
    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = "",
            tint = color
        )
    }
}