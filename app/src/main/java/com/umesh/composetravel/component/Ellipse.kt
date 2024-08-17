package com.umesh.composetravel.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composetravel.ui.theme.DarkGrey
import com.umesh.composetravel.R

@Composable
fun Ellipse(modifier: Modifier = Modifier, image: Int, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .padding(10.dp)
            .size(45.dp)
            .background(color = DarkGrey, shape = CircleShape),
    ) {
        Image(
            modifier = Modifier
                .size(24.dp).align(Alignment.Center)
                .clickable { onClick() },
            painter = painterResource(id = image),
            contentDescription = "heart"
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewEllipse() {
    Ellipse(image = R.drawable.ic_favorite) {}
}