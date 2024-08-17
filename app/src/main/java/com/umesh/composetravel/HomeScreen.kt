package com.umesh.composetravel

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.umesh.composetravel.component.Category
import com.umesh.composetravel.component.CustomSearchBar
import com.umesh.composetravel.component.CustomTitleBar
import com.umesh.composetravel.component.DestinationCard
import com.umesh.composetravel.model.categories
import com.umesh.composetravel.model.destinations
import com.umesh.composetravel.navigation.Screen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    Column(
        modifier = modifier
            .padding(5.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        CustomTitleBar {
            // Profile icon click event
        }

        Spacer(modifier = Modifier.height(10.dp))

        CustomSearchBar {
            // Search click event
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Popular Places",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                modifier = Modifier.clickable {
                    //Click event
                },
                text = "View all",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        var selectedIndex by remember { mutableIntStateOf(0) }
        LazyRow(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            items(categories) { item ->
                val index = categories.indexOf(item)
                Category(
                    category = item.categoryName,
                    isSelected = index == selectedIndex,
                    onCategoryClick = { selectedIndex = index })
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(destinations) { destination ->
                DestinationCard(
                    destination = destination,
                    onCardClick = { id ->
                        navController.navigate(Screen.Detail.createRoute(id))
                    },
                    onFavouriteClick = {},
                    sharedTransitionScope = sharedTransitionScope,
                    animatedContentScope = animatedContentScope
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen() {

}