package com.fighter.donutsapp.ui.screens.details

import com.fighter.donutsapp.R

data class DetailsUiState(
    val image: Int = R.drawable.details_donut,
    val name: String = "",
    val description: String = "",
    val price: String = "",
    val counter: Int = 1
)
