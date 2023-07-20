package com.fighter.donutsapp.ui.screens.home

import androidx.lifecycle.ViewModel
import com.fighter.donutsapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()


    init {
        getDonutOffers()
        getDonuts()
    }

    private fun getDonuts() {
        _state.update {
            it.copy(
                donuts = listOf(
                    DonutUiState(
                        donutImage = R.drawable.d2,
                        donutTitle = "Chocolate Cherry",
                        donutPrice = "$18",
                    ),
                    DonutUiState(
                        donutImage = R.drawable.d3,
                        donutTitle = "Strawberry Rain",
                        donutPrice = "$22",
                    ),
                    DonutUiState(
                        donutImage = R.drawable.d4,
                        donutTitle = "Strawberry donut",
                        donutPrice = "$12",
                    ),
                    DonutUiState(
                        donutImage = R.drawable.d5,
                        donutTitle = "Jelly-Filled",
                        donutPrice = "$7",
                    ),
                    DonutUiState(
                        donutImage = R.drawable.d6,
                        donutTitle = "Boston Cream",
                        donutPrice = "$9",
                    ),
                    DonutUiState(
                        donutImage = R.drawable.d7,
                        donutTitle = "Maple Bar",
                        donutPrice = "$15",
                    ),
                    DonutUiState(
                        donutImage = R.drawable.d8,
                        donutTitle = "Old-Fashioned",
                        donutPrice = "$48",
                    ),
                    DonutUiState(
                        donutImage = R.drawable.d10,
                        donutTitle = "Powdered Sugar",
                        donutPrice = "$3",
                    ),
                )
            )
        }
    }

    private fun getDonutOffers() {
        return _state.update {
            it.copy(
                offers = listOf(
                    OfferUiState(
                        offerDonutImage = R.drawable.d5,
                        offerTittle = "Strawberry Wheel",
                        offerContent = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                        offerPrice = "$16",
                        offerId = 3
                    ),
                    OfferUiState(
                        offerDonutImage = R.drawable.d6,
                        offerTittle = "Chocolate Glaze",
                        offerContent = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                        offerPrice = "$18",
                        offerId = 4
                    ),
                    OfferUiState(
                        offerDonutImage = R.drawable.d7,
                        offerTittle = "Craze Donut",
                        offerContent = "Delicious and Juicy baked chocolate donuts full of Craze Tasty.",
                        offerPrice = "$25",
                        offerId = 5
                    ),
                    OfferUiState(
                        offerDonutImage = R.drawable.d11,
                        offerTittle = "Raspberry Filled",
                        offerContent = "Donuts filled with tangy raspberry preserves, balancing sweetness with a zesty twist.",
                        offerPrice = "$16",
                        offerId = 3
                    )
                )
            )
        }
    }
}