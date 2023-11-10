package com.fjr619.recipemobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import com.fjr619.recipemobile.data.strawberryCake
import com.fjr619.recipemobile.presenter.Body
import com.fjr619.recipemobile.presenter.Header
import com.fjr619.recipemobile.presenter.Title
import com.fjr619.recipemobile.presenter.Toolbar
import com.fjr619.recipemobile.ui.theme.RecipeMobileTheme

/**
 * Base
 * https://www.youtube.com/watch?v=bbvYidjZ_CE
 * https://github.com/jurajkusnier/recipes-app/tree/master
 *
 * with modification with
 * https://proandroiddev.com/collapsing-toolbar-with-parallax-effect-and-curve-motion-in-jetpack-compose-9ed1c3c0393f
 * https://github.com/mazzouzi/collapsing-toolbar-with-parallax-effect-and-curved-motion-in-compose/tree/quadratic_bezier_curve_version
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.Transparent.toArgb(), Color.Transparent.toArgb()
            ),
            navigationBarStyle = SystemBarStyle.light(
                Color.Transparent.toArgb(), Color.Transparent.toArgb()
            )
        )
        super.onCreate(savedInstanceState)
        val recipe = strawberryCake

        setContent {
            RecipeMobileTheme {
                Surface {
                    Box(modifier = Modifier.fillMaxSize()) {
                        val headerHeightPx = with(LocalDensity.current) { headerHeight.toPx() }
                        val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.toPx() }
                        val scrollState = rememberLazyListState()

                        Header(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(headerHeight),
                            category = recipe.category,
                            headerHeightPx = headerHeightPx,
                            scrollState = scrollState
                        )
                        Body(
                            recipe = recipe,
                            modifier = Modifier.fillMaxSize(),
                            scrollState = scrollState
                        )
                        Toolbar(
                            scrollState = scrollState,
                            headerHeightPx = headerHeightPx,
                            toolbarHeightPx = toolbarHeightPx
                        )
                        Title(
                            title = recipe.title,
                            scrollState = scrollState,
                            headerHeightPx = headerHeightPx,
                            toolbarHeightPx = toolbarHeightPx
                        )
                    }
                }
            }
        }
    }
}