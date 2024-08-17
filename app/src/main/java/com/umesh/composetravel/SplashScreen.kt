package com.umesh.composetravel

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.umesh.composetravel.navigation.Screen
import com.umesh.composetravel.ui.theme.Cerulean
import com.umesh.composetravel.ui.theme.Sapphire
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val scale = remember { androidx.compose.animation.core.Animatable(0f) }
    val colors = listOf(Cerulean, Sapphire)
    val gradient = Brush.verticalGradient(colors)

    Box(
        Modifier
            .fillMaxSize()
            .background(gradient)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Travel",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
                Image(
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.ic_global_icon),
                    contentDescription = "global icon"
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Find Your Dream",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Destination With Us",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )
        }
    }


    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = { OvershootInterpolator(2f).getInterpolation(it) })
        )
        delay(3000L)
        navController.navigate(Screen.Main.route)
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewSplash() {

}