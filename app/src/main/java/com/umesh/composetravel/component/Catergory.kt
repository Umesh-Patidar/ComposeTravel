package com.umesh.composetravel.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composetravel.ui.theme.LightThinGrey

@Composable
fun Category(modifier: Modifier = Modifier, category: String, isSelected: Boolean = false, onCategoryClick: () -> Unit) {
    Box(
        modifier = modifier
            .padding(5.dp)
            .wrapContentWidth()
            .defaultMinSize(minWidth = 100.dp)
            .height(50.dp)
            .background(
                color = if (isSelected) Color.Black else LightThinGrey,
                shape = RoundedCornerShape(18.dp)
            )
            .padding(15.dp).clickable(onClick = onCategoryClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category,
            style = MaterialTheme.typography.titleMedium,
            color = if (isSelected) Color.White else Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategory() {
    Category(category = "Most Viewed", isSelected = true){}
}

@Preview(showBackground = true)
@Composable
fun PreviewCategory2() {
    Category(category = "Most Viewed", isSelected = false){}
}