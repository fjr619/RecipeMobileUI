package com.fjr619.recipemobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.fjr619.recipemobile.data.strawberryCake
import com.fjr619.recipemobile.presenter.Body
import com.fjr619.recipemobile.presenter.Header
import com.fjr619.recipemobile.presenter.components.CircularButton
import com.fjr619.recipemobile.ui.theme.LightGray
import com.fjr619.recipemobile.ui.theme.Pink
import com.fjr619.recipemobile.ui.theme.RecipeMobileTheme
import com.fjr619.recipemobile.ui.theme.Transparent
import com.fjr619.recipemobile.ui.theme.White

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
                            scrollState = scrollState)
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