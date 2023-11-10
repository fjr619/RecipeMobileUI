package com.fjr619.recipemobile.presenter.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fjr619.recipemobile.data.Recipe
import com.fjr619.recipemobile.ui.theme.DarkGray
import com.fjr619.recipemobile.ui.theme.LightGray

@Composable
fun IngredientsList(recipe: Recipe, parentHeight:Dp) {
    LazyVerticalGrid(
        modifier = Modifier.heightIn(max = parentHeight),
        columns = GridCells.Fixed(3)) {
        items(
            items = recipe.ingredients,
            key = { it.title }
        ) {
            IngredientCard(it.image, it.title, it.subtitle, Modifier)
        }
    }
}


@Composable
fun IngredientCard(
    @DrawableRes iconResource: Int,
    title: String,
    subtitle: String,
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(bottom = 16.dp),
    ) {
        Card(
            shape = MaterialTheme.shapes.large,
            elevation = CardDefaults.cardElevation(0.dp),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(bottom = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = LightGray,
                contentColor = LightGray
            )
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(
                    modifier = modifier.fillMaxSize(0.5f),
                    painter = painterResource(id = iconResource),
                    contentDescription = null,
                )
            }

        }
        Text(text = title, modifier = Modifier.width(100.dp), fontSize = 14.sp, fontWeight = FontWeight.Medium)
        Text(text = subtitle, color = DarkGray, modifier = Modifier.width(100.dp), fontSize = 14.sp)
    }
}
