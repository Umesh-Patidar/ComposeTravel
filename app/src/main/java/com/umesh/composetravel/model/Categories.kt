package com.umesh.composetravel.model

data class Categories(val categoryName: String, val isSelected: Boolean)

val categories = listOf(
    Categories(categoryName = "Most Viewed", isSelected = true),
    Categories(categoryName = "Near by", isSelected = false),
    Categories(categoryName = "Latest", isSelected = false),
)

