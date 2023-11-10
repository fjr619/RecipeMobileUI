package com.fjr619.recipemobile.presenter.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fjr619.recipemobile.data.Recipe

@Composable
fun Description(recipe: Recipe) {
    Text(
        text = recipe.description,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
    )
}