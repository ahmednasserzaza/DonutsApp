package com.fighter.donutsapp.ui.screens.home

import com.fighter.donutsapp.R
import com.fighter.donutsapp.ui.screens.details.DetailsUiState

data class HomeUiState(
    val donuts: List<DonutUiState> = emptyList(),
)

data class DonutUiState(
    val donutImage: Int = R.drawable.donut_1,
    val donutTitle: String = "",
    val donutPrice: String = "",
    val description: String = ""
)

fun DonutUiState.toDetailsUiState(): DetailsUiState {
    return DetailsUiState(
        image = donutImage,
        name = donutTitle,
        price = donutPrice,
        description = description
    )
}
