package com.umesh.composetravel.model

import com.umesh.composetravel.R


data class Destination(
    val destinationId: Int,
    val destinationName: String,
    val destinationCity: String,
    val destinationCountry: String,
    val destinationRating: String,
    val destinationDuration: String,
    val destinationTemp: String,
    val destinationDescription: String,
    val destinationImg: Int,
    val destinationTicketPrice: String,
    val isFavourite: Boolean = false
)

val destinations = listOf(
    Destination(
        destinationId = 1,
        destinationName = "Mount Fuji",
        destinationCity = "Tokiyo",
        destinationCountry = "Japan",
        destinationRating = "4.8",
        destinationDuration = "8 hour",
        destinationTemp = "16 °C",
        destinationDescription = "Japan’s Mt. Fuji is an active volcano about 100 kilometers southwest of Tokyo. Commonly called “Fuji-san,” it’s the country’s tallest peak, at 3,776 meters. A pilgrimage site for centuries, it’s considered one of Japan’s 3 sacred mountains, and summit hikes remain a popular activity. Its iconic profile is the subject of numerous works of art, notably Edo Period prints by Hokusai and Hiroshige.",
        destinationImg = R.drawable.ic_destination_1,
        destinationTicketPrice = "$230",
        isFavourite = false
    ),
    Destination(
        destinationId = 2,
        destinationName = "Andes",
        destinationCity = "South",
        destinationCountry = "America",
        destinationRating = "4.3",
        destinationDuration = "4 hour",
        destinationTemp = "18 °C",
        destinationDescription = "The Andes, running along South America's western side, is among the world's longest mountain ranges. Its varied terrain encompasses glaciers, volcanoes, grassland, desert, lakes and forest. The mountains shelter pre-Columbian archaeological sites and wildlife including chinchillas and condors.",
        destinationImg = R.drawable.ic_destination_2,
        destinationTicketPrice = "$300",
        isFavourite = false
    ),
)