package com.umesh.composetravel

import android.util.Log
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.umesh.composetravel.component.CustomButton
import com.umesh.composetravel.component.DestinationDetailSubCard
import com.umesh.composetravel.component.DetailOverviewIcon
import com.umesh.composetravel.component.Ellipse
import com.umesh.composetravel.model.destinations

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DestinationDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    itemId: Int,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    with(sharedTransitionScope) {
        val selectedDestination = destinations.find { it.destinationId == itemId }
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Log.d("IDdddddddddddddd->>>>>>>>>>>>>", ">>>>>>>>>>$itemId")

            Column(
                modifier = Modifier.wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Card(
                    modifier = Modifier.Companion
                        .sharedElement(
                            sharedTransitionScope.rememberSharedContentState(key = "image-$itemId"),
                            animatedVisibilityScope = animatedContentScope
                        )
                        .fillMaxWidth()
                        .height(460.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    elevation = CardDefaults.cardElevation(10.dp),
                ) {
                    Box(modifier = modifier.fillMaxSize()) {
                        selectedDestination?.let { destination ->
                            Image(
                                modifier = modifier
                                    .fillMaxSize(),
                                painter = painterResource(id = destination.destinationImg),
                                contentDescription = "destination",
                                contentScale = ContentScale.Crop
                            )

                            Row(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Ellipse(image = R.drawable.ic_arrow_left) {
                                    navController.popBackStack()
                                }
                                Ellipse(image = R.drawable.ic_archive) {
                                    //Click Event
                                }
                            }

                            DestinationDetailSubCard(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(10.dp),
                                destination = destination
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Overview",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Details",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                selectedDestination?.let { destination ->
                    DetailOverviewIcon(
                        drawable = R.drawable.ic_clock,
                        text = destination.destinationDuration
                    )
                    DetailOverviewIcon(
                        drawable = R.drawable.ic_cloud,
                        text = destination.destinationTemp
                    )
                    DetailOverviewIcon(
                        drawable = R.drawable.ic_filled_rating,
                        text = destination.destinationRating
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            selectedDestination?.let { destination ->
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = destination.destinationDescription,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray
                )
            }


            Spacer(modifier = Modifier.height(10.dp))

            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Book Now", icon = R.drawable.ic_send_icon
            ) {
                //Click Event
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewDestinationDetailScreen() {
//    SharedTransitionLayout {
//        AnimatedVisibility(visible = true) {
//            DestinationDetailScreen(navController = rememberNavController(), itemId = 2)
//        }
//    }
}

//@OptIn(ExperimentalSharedTransitionApi::class)
//@Composable
//fun SharedTransitionScope.DestinationDetailScreen(navController = rememberNavController(), itemId: Int, animatedVisibilityScope: AnimatedVisibilityScope){}
