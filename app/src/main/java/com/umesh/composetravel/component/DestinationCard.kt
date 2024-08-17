package com.umesh.composetravel.component

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composetravel.model.Destination
import com.umesh.composetravel.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DestinationCard(
    modifier: Modifier = Modifier,
    destination: Destination,
    onFavouriteClick: () -> Unit,
    onCardClick: (Int) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    with(sharedTransitionScope) {
        Card(
            modifier = Modifier.Companion
                .sharedElement(
                    sharedTransitionScope.rememberSharedContentState(key = "image-${destination.destinationId}"),
                    animatedVisibilityScope = animatedContentScope
                )
                .width(270.dp)
                .height(405.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))
                .clickable {
                    onCardClick(destination.destinationId)
                },
            elevation = CardDefaults.elevatedCardElevation(),
        ) {
            Box(modifier = modifier.fillMaxSize()) {

                Image(
                    modifier = modifier.fillMaxSize(),
                    painter = painterResource(id = destination.destinationImg),
                    contentDescription = "destination",
                    contentScale = ContentScale.Crop
                )

                Ellipse(
                    modifier = Modifier.align(Alignment.TopEnd),
                    image = R.drawable.ic_favorite
                ) {
                    onFavouriteClick()
                }

                DestinationDesCard(modifier = Modifier.align(Alignment.BottomCenter), destination)

            }
        }
    }
}


@OptIn(ExperimentalSharedTransitionApi::class)
@Preview(showSystemUi = true)
@Composable
fun PreviewDestinationCard() {
//      DestinationCard(
//          destination = destinations.first(),
//          onCardClick = {},
//          onFavouriteClick = {},
//          sharedTransitionScope = SharedTransitionScope(),
//          animatedContentScope = AnimatedContentScope()
//          )
}