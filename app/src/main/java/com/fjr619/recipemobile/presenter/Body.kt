package com.fjr619.recipemobile.presenter

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fjr619.recipemobile.data.Recipe
import com.fjr619.recipemobile.headerHeight
import com.fjr619.recipemobile.presenter.components.BasicInfo
import com.fjr619.recipemobile.presenter.components.Description
import com.fjr619.recipemobile.presenter.components.Images
import com.fjr619.recipemobile.presenter.components.IngredientsHeader
import com.fjr619.recipemobile.presenter.components.IngredientsList
import com.fjr619.recipemobile.presenter.components.Reviews
import com.fjr619.recipemobile.presenter.components.ServingCalculator
import com.fjr619.recipemobile.presenter.components.ShoppingListButton

@Composable
fun Body(
    recipe: Recipe,
    modifier: Modifier = Modifier, scrollState: LazyListState
) {
    BoxWithConstraints {
        val parentHeight = maxHeight
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier,
            state = scrollState,
            contentPadding = PaddingValues(top = headerHeight)
        ) {

            item {
                BasicInfo(recipe = recipe)
                Description(recipe)
                ServingCalculator()
                IngredientsHeader()
                IngredientsList(recipe, parentHeight)
                ShoppingListButton()
                Reviews(recipe)
                Images()
                Spacer(modifier = Modifier.heightIn(16.dp))
            }
        }
    }

}