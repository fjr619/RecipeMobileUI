package com.fjr619.recipemobile.presenter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fjr619.recipemobile.R
import com.fjr619.recipemobile.data.Recipe
import com.fjr619.recipemobile.ui.theme.DarkGray
import com.fjr619.recipemobile.ui.theme.Pink

@Composable
fun Reviews(recipe: Recipe) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "Reviews", fontWeight = FontWeight.Bold)
            Text(recipe.reviews, color = DarkGray)
        }
        TextButton(
            onClick = { /*TODO*/ }, elevation = null,
            colors = ButtonDefaults.textButtonColors(
                contentColor = Pink
            )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("See all")
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = null
                )
            }
        }
    }
}