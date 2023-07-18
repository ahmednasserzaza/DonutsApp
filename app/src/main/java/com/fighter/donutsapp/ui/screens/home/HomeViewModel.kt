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
                        donutImage = R.drawable.offer_one,
                        donutTitle = "Chocolate Cherry",
                        donutPrice = "$18"
                    ),
                    DonutUiState(
                        R.drawable.offer_two,
                        donutTitle = "Strawberry Rain",
                        donutPrice = "$22"
                    ),
                    DonutUiState(
                        R.drawable.offer_one,
                        donutTitle = "Strawberry donut",
                        donutPrice = "$12"
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
                        offerDonutImage = R.drawable.donut_1,
                        offerTittle = "Strawberry Wheel",
                        offerContent = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                        offerPrice = "$16"
                    ),
                    OfferUiState(
                        offerDonutImage = R.drawable.donut_2,
                        offerTittle = "Chocolate Glaze",
                        offerContent = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                        offerPrice = "$18"
                    ),
                    OfferUiState(
                        offerDonutImage = R.drawable.donut_3,
                        offerTittle = "Craze Donut",
                        offerContent = "Delicious and Juicy baked chocolate donuts full of Craze Tasty.",
                        offerPrice = "$25"
                    ),
                )
            )
        }
    }
}