package com.fighter.donutsapp.ui.screens.home

import com.fighter.donutsapp.R

data class HomeUiState(
    val offers: List<OfferUiState> = emptyList(),
    val donuts: List<DonutUiState> = emptyList(),
)

data class OfferUiState(
    val offerDonutImage: Int = R.drawable.offer_one,
    val offerTittle: String = "",
    val offerContent: String = "",
    val offerPrice: String = "",
)

data class DonutUiState(
    val donutImage: Int = R.drawable.donut_1,
    val donutTitle: String = "",
    val donutPrice: String = ""
)
