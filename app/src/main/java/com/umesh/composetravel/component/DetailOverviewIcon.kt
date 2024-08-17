package com.umesh.composetravel.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composetravel.ui.theme.LightThinGrey
import com.umesh.composetravel.R

@Composable
fun DetailOverviewIcon(modifier: Modifier = Modifier, drawable: Int, text: String) {
    Row(
        modifier = modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = modifier
                .size(30.dp)
                .background(color = LightThinGrey, shape = RoundedCornerShape(5.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "drawable"
            )
        }

        Text(
            modifier = Modifier.padding(5.dp),
            text = text,
            color = Color.Gray,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetailOverviewIcon() {
    DetailOverviewIcon(drawable = R.drawable.ic_clock, text = "16 C")
}