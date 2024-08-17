package com.umesh.composetravel.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composetravel.model.Destination
import com.umesh.composetravel.model.destinations
import com.umesh.composetravel.ui.theme.LightBlack
import com.umesh.composetravel.ui.theme.LightGrey
import com.umesh.composetravel.ui.theme.Sapphire
import com.umesh.composetravel.R

@Composable
fun DestinationDesCard(modifier: Modifier = Modifier, destination: Destination) {
    val colors = listOf(LightBlack, Sapphire)
    val gradient = Brush.verticalGradient(colors)
    Box(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(75.dp)
            .border(
                BorderStroke(1.dp, Color.Black),
                RoundedCornerShape(10.dp)
            )
            .background(brush = gradient, shape = RoundedCornerShape(10.dp)),
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceAround
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = destination.destinationName.plus(","),
                    color = Color.White,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = modifier.width(5.dp))

                Text(
                    text = destination.destinationCity,
                    color = LightGrey,
                    style = MaterialTheme.typography.labelSmall,
                )
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(id = R.drawable.ic_marker),
                    contentDescription = destination.destinationName,
                    colorFilter = ColorFilter.tint(color = LightGrey)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text =  destination.destinationCity.plus(","),
                    color = LightGrey,
                    style = MaterialTheme.typography.labelSmall,
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = destination.destinationCountry,
                    color = LightGrey,
                    style = MaterialTheme.typography.labelSmall,
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(id = R.drawable.ic_rating),
                    contentDescription = destination.destinationName,
                    colorFilter = ColorFilter.tint(color = LightGrey)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = destination.destinationRating,
                    color = LightGrey,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewDestinationDesCard() {
    DestinationDesCard(destination = destinations.first())
}